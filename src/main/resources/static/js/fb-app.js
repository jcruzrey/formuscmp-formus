/* Client helpers for the server-rendered pages. This replaces the prototype's shell.js (no fake session, no header/footer
   injection: the server renders those). Exposes the subset of the `FB` API that the page scripts use:
     FB.lang, FB.user, FB.can(token), FB.csrf(), FB.add/t/apply (client-side dictionaries for strings built in JS),
     FB.esc, FB.toast, FB.store, FB.$, FB.$$, FB.money, FB.dateFmt, FB.fetchJson, FB.setLang, FB.copy.
   Reads: <html lang>, <meta name="csrf-token">, <meta name="fb-user" content="email" data-name data-role data-id data-permisos>. */
(function () {
  'use strict';
  var $ = function (s, r) { return (r || document).querySelector(s); };
  var $$ = function (s, r) { return Array.prototype.slice.call((r || document).querySelectorAll(s)); };
  var meta = function (n) { var m = document.querySelector('meta[name="' + n + '"]'); return m || null; };

  var lang = (document.documentElement.lang || 'es').toLowerCase().indexOf('en') === 0 ? 'en' : 'es';
  var um = meta('fb-user');
  var user = um ? { email: um.content, name: um.dataset.name || '', role: um.dataset.role || 'solicitante', id: um.dataset.id || '', permisos: um.dataset.permisos || '' } : null;

  var DICT = { es: {}, en: {} };
  function add(d) { ['es', 'en'].forEach(function (l) { Object.assign(DICT[l], (d && d[l]) || {}); }); }
  function t(k) { return (DICT[lang] && DICT[lang][k]) || DICT.es[k] || k; }
  function apply(root) {
    $$('[data-i18n]', root).forEach(function (e) { e.textContent = t(e.dataset.i18n); });
    $$('[data-i18n-placeholder]', root).forEach(function (e) { e.placeholder = t(e.dataset.i18nPlaceholder); });
    $$('[data-i18n-title]', root).forEach(function (e) { e.title = t(e.dataset.i18nTitle); });
    $$('[data-i18n-aria]', root).forEach(function (e) { e.setAttribute('aria-label', t(e.dataset.i18nAria)); });
  }

  var store = {
    get: function (k, d) { try { var v = localStorage.getItem(k); return v === null ? d : JSON.parse(v); } catch (e) { return d; } },
    set: function (k, v) { try { localStorage.setItem(k, JSON.stringify(v)); } catch (e) { /* private mode: drafts just won't persist */ } },
    remove: function (k) { try { localStorage.removeItem(k); } catch (e) { /* ignore */ } }
  };

  function toast(msg, ms) {
    var host = $('.toast-host') || document.body.appendChild(Object.assign(document.createElement('div'), { className: 'toast-host', role: 'status' }));
    host.setAttribute('aria-live', 'polite');
    var el = document.createElement('div'); el.className = 'toast'; el.textContent = msg; host.appendChild(el);
    setTimeout(function () { el.remove(); }, ms || 2600);
  }

  function csrf() { var m = meta('csrf-token'); return m ? m.content : ''; }

  /** fetch() that sends the CSRF header, JSON in/out. Resolves {status, ok, body} and never throws on HTTP errors. */
  function fetchJson(url, opts) {
    opts = opts || {};
    var headers = Object.assign({ 'Accept': 'application/json', 'X-CSRF-Token': csrf() }, opts.headers || {});
    var init = { method: opts.method || (opts.body ? 'POST' : 'GET'), headers: headers, credentials: 'same-origin' };
    if (opts.body !== undefined) {
      if (typeof FormData !== 'undefined' && opts.body instanceof FormData) init.body = opts.body;   // a file upload: no JSON, no Content-Type (the browser adds the multipart boundary)
      else { headers['Content-Type'] = 'application/json'; init.body = typeof opts.body === 'string' ? opts.body : JSON.stringify(opts.body); }
    }
    return fetch(url, init).then(function (r) {
      return r.text().then(function (txt) {
        var body = null; try { body = txt ? JSON.parse(txt) : null; } catch (e) { body = null; }
        return { status: r.status, ok: r.ok, body: body };
      });
    });
  }

  function copy(text) {
    if (navigator.clipboard && navigator.clipboard.writeText) return navigator.clipboard.writeText(text);
    var ta = document.createElement('textarea'); ta.value = text; document.body.appendChild(ta); ta.select();
    try { document.execCommand('copy'); } catch (e) { /* ignore */ }
    ta.remove(); return Promise.resolve();
  }

  var urlsMeta = meta('fb-urls'), urls = {};
  try { urls = urlsMeta ? JSON.parse(urlsMeta.content) : {}; } catch (e) { urls = {}; }

  // Authorization: the user's effective permisos (the backend resolved roles + own rules at sign-in), the same grammar as the server's Permisos:
  // "module[:resource[:action]]", a leading "-" denies, a denial always wins, a missing or "*" segment matches anything, nothing granted is refused.
  // A token asked here is "module:resource:action" (an empty action is "leer"). The CRUD verbs stand for the commands the server maps to them.
  var VERBS = { leer: ['detalle', 'ver', 'buscar', 'listar', 'consultar'], crear: ['nuevo', 'guardar'], actualizar: ['actualizar', 'cambiarstatus', 'cambiar'], eliminar: ['eliminar'] };
  function parsePermisos(list) {
    var grants = [], denials = [];
    String(list || '').split(',').forEach(function (raw) {
      var tk = raw.trim().toLowerCase(), deny = tk.charAt(0) === '-';
      if (deny) tk = tk.slice(1).trim();
      if (!tk) return;
      var parts = tk.split(':');
      if (parts.length > 3) return;
      var seg = ['*', '*', '*'];
      parts.forEach(function (p, i) { p = p.trim(); seg[i] = p === '' ? '*' : p; });
      (deny ? denials : grants).push(seg);
    });
    return { grants: grants, denials: denials };
  }
  function verbOf(action) {
    if (VERBS[action]) return action;
    for (var v in VERBS) { if (VERBS[v].indexOf(action) >= 0) return v; }
    return '';
  }
  function matches(seg, m, r, a, verb) {
    return (seg[0] === '*' || seg[0] === m) && (seg[1] === '*' || seg[1] === r) && (seg[2] === '*' || seg[2] === a || (verb !== '' && seg[2] === verb));
  }
  function can(token) {
    var p = String(token || '').toLowerCase().split(':'), m = p[0] || '', r = p[1] || '', a = p[2] || 'leer';
    var perms = parsePermisos(user && user.permisos), verb = verbOf(a), i;
    for (i = 0; i < perms.denials.length; i++) { if (matches(perms.denials[i], m, r, a, verb)) return false; }
    for (i = 0; i < perms.grants.length; i++) { if (matches(perms.grants[i], m, r, a, verb)) return true; }
    return false;
  }

  window.FB = {
    urls: urls, lang: lang, user: user, add: add, t: t, apply: apply, store: store, toast: toast, csrf: csrf, fetchJson: fetchJson, copy: copy,
    $: $, $$: $$,
    can: can,
    setLang: function (l) { var u = new URL(location.href); u.searchParams.set('lang', l); location.href = u.toString(); },
    esc: function (s) { return String(s == null ? '' : s).replace(/[&<>"']/g, function (c) { return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' }[c]; }); },
    money: function (n, cur) { return new Intl.NumberFormat(lang === 'es' ? 'es-MX' : 'en-US', { style: 'currency', currency: cur || 'MXN' }).format(n); },
    dateFmt: function (iso) { var d = new Date(iso); return isNaN(d) ? '' : d.toLocaleDateString(lang === 'es' ? 'es-MX' : 'en-US', { year: 'numeric', month: 'short', day: 'numeric' }); },
    dateTimeFmt: function (iso) { var d = new Date(iso); return isNaN(d) ? '' : d.toLocaleString(lang === 'es' ? 'es-MX' : 'en-US', { dateStyle: 'medium', timeStyle: 'short' }); }
  };
  document.addEventListener('DOMContentLoaded', function () {
    $$('.lang button[data-lang]').forEach(function (b) { b.addEventListener('click', function () { window.FB.setLang(b.dataset.lang); }); });
    apply(document); document.dispatchEvent(new CustomEvent('fb:ready', { detail: { user: user, lang: lang } })); });
})();
