/* Renders a form field of the builder model ({type, label, name, ...}) to HTML. Shared by the builder canvas/preview,
   the public fill page and the HTML export, so they cannot drift. Output is escaped here; callers insert it as markup.
   Depends on nothing (esc is local). */
(function () {
  'use strict';
  var esc = function (s) { return String(s == null ? '' : s).replace(/[&<>"']/g, function (c) { return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' }[c]; }); };

  var BUTTONS = ['boton', 'botonjs', 'guardarjs', 'liga', 'locacion', 'probar', 'someter'];
  var LAYOUT = ['heading', 'paragraph', 'divider'];
  var isButton = function (t) { return BUTTONS.indexOf(t) >= 0; };
  var isLayout = function (t) { return LAYOUT.indexOf(t) >= 0; };
  var isInput = function (t) { return !isLayout(t) && !isButton(t); };

  function wcls(f) {
    return f.width === 'half' ? ' fb-half' : f.width === 'third' ? ' fb-third' : f.width === 'fourth' ? ' fb-fourth' : '';
  }

  /** Inner HTML of one field. opts.idPrefix avoids id clashes when several forms share a page. */
  function fieldInner(f, opts) {
    opts = opts || {};
    var id = (opts.idPrefix || 'in_') + (f.name || f.id);
    var req = f.required ? ' required' : '';
    var star = f.required ? '<span class="fb-req" aria-hidden="true">*</span>' : '';
    var help = f.help ? '<p class="fb-help">' + esc(f.help) + '</p>' : '';
    var ph = f.placeholder ? ' placeholder="' + esc(f.placeholder) + '"' : '';
    var nm = ' name="' + esc(f.name) + '"';
    var val = f.value ? ' value="' + esc(f.value) + '"' : '';
    var ro = f.readOnly ? ' readonly' : '';
    var lab = '<label for="' + esc(id) + '">' + esc(f.label) + star + '</label>';
    var err = opts.errors && opts.errors[f.name] ? '<p class="fb-error" role="alert">' + esc(opts.errors[f.name]) + '</p>' : '';
    switch (f.type) {
      case 'heading': var l = [2, 3, 4].indexOf(+f.level) >= 0 ? +f.level : 2; return '<h' + l + '>' + esc(f.text) + '</h' + l + '>';
      case 'paragraph': return '<p class="fb-text">' + esc(f.text) + '</p>';
      case 'divider': return '<hr>';
      case 'text': case 'email': case 'tel': case 'date':
        return lab + '<input id="' + esc(id) + '" type="' + f.type + '"' + nm + ph + val + ro + req + '>' + help + err;
      case 'number':
        return lab + '<input id="' + esc(id) + '" type="number"' + nm + ph + val + ro +
          (f.min !== '' && f.min != null ? ' min="' + esc(f.min) + '"' : '') + (f.max !== '' && f.max != null ? ' max="' + esc(f.max) + '"' : '') + req + '>' + help + err;
      case 'textarea':
        return lab + '<textarea id="' + esc(id) + '"' + nm + ' rows="' + (+f.rows || 4) + '"' + ph + ro + req + '>' + esc(f.value || '') + '</textarea>' + help + err;
      case 'select':
        return lab + '<select id="' + esc(id) + '"' + nm + req + '><option value="">' + esc(f.placeholder || '') + '</option>' +
          (f.options || []).map(function (o) { return '<option>' + esc(o) + '</option>'; }).join('') + '</select>' + help + err;
      case 'radio':
        return '<fieldset><legend>' + esc(f.label) + star + '</legend>' +
          (f.options || []).map(function (o) { return '<label class="fb-opt"><input type="radio"' + nm + ' value="' + esc(o) + '"' + req + '>' + esc(o) + '</label>'; }).join('') + '</fieldset>' + help + err;
      case 'checkboxes':
        return '<fieldset><legend>' + esc(f.label) + star + '</legend>' +
          (f.options || []).map(function (o) { return '<label class="fb-opt"><input type="checkbox" name="' + esc(f.name) + '" value="' + esc(o) + '">' + esc(o) + '</label>'; }).join('') + '</fieldset>' + help + err;
      case 'catalog': {   // several rows of a table, each with a quantity; the choice travels in one hidden field: [{codigo, descripcion, cantidad}]
        var en = (document.documentElement.lang || '').indexOf('en') === 0;
        var th = en ? ['Code', 'Description', 'Quantity'] : ['C\u00f3digo', 'Descripci\u00f3n', 'Cantidad'];
        var items = f.items || [];
        return '<fieldset class="fb-catalog"><legend>' + esc(f.label) + star + '</legend><div class="fb-cat-wrap"><table class="fb-cat"><thead><tr><th></th><th>' + th[0] + '</th><th>' + th[1] + '</th><th>' + th[2] + '</th></tr></thead><tbody>' +
          (items.length ? items.map(function (it) {
            return '<tr data-code="' + esc(it.code) + '" data-label="' + esc(it.label) + '"><td><input type="checkbox" class="fb-cat-sel" aria-label="' + esc(it.code) + '"></td><td>' + esc(it.code) + '</td><td>' + esc(it.label) +
              '</td><td><input type="number" class="fb-cat-qty" min="1" max="100000" step="1" value="1" disabled aria-label="' + th[2] + ' ' + esc(it.code) + '"></td></tr>';
          }).join('') : '<tr><td colspan="4" class="fb-help">' + (en ? 'The catalog has no items.' : 'El cat\u00e1logo no tiene elementos.') + '</td></tr>') +
          '</tbody></table></div><p class="fb-help fb-cat-sum" aria-live="polite"></p><input type="hidden" id="' + esc(id) + '"' + nm + '></fieldset>' + help + err;
      }
      case 'checkbox':
        return '<label class="fb-opt"><input type="checkbox"' + nm + req + '>' + esc(f.label) + star + '</label>' + help + err;
      case 'file':
        return lab + '<input id="' + esc(id) + '" type="file"' + nm + (f.accept ? ' accept="' + esc(f.accept) + '"' : '') + (f.multiple ? ' multiple' : '') + req + '>' + help + err;
      default:
        return '<button type="button" class="fb-btn' + (f.type === 'someter' ? '' : ' fb-secondary') + '" data-command="' + esc(f.commandName || '') + '">' + esc(f.label) + '</button>';
    }
  }

  /** The submit-able body of a form (title, description, fields, submit button) for the public fill page and exports.
      Hidden fields are rendered hidden, buttons other than the submit button are skipped (they are builder-only). */
  function formBody(model, opts) {
    opts = opts || {};
    var m = model.meta || {};
    var h = '<h1>' + esc(m.title) + '</h1>' + (m.description ? '<p class="fb-desc">' + esc(m.description) + '</p>' : '') + '<div class="fb-grid">';
    (model.fields || []).forEach(function (f) {
      if (isButton(f.type)) return;
      h += '<div class="fb-field' + wcls(f) + '"' + (f.hidden ? ' hidden' : '') + '>' + fieldInner(f, opts) + '</div>';
    });
    h += '</div><p style="margin-top:1.5rem"><button type="submit" class="fb-submit">' + esc(m.submit || 'Submit') + '</button></p>';
    return h;
  }

  window.FBRender = { esc: esc, wcls: wcls, fieldInner: fieldInner, formBody: formBody, isButton: isButton, isLayout: isLayout, isInput: isInput, BUTTONS: BUTTONS };
})();
