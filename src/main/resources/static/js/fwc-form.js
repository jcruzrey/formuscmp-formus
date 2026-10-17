/* Draws a platform form (default/form.ftl, or any view that uses the same ids) from #form-model with the shared renderer and shows the
   backend's field errors. Values the command answered with are already in the model, so a refused submit keeps what the user typed.
   The browser submits normally: every button posts to the address of its own command. */
(function () {
  'use strict';
  var form = document.getElementById('fcForm');
  var body = document.getElementById('fcBody');
  if (!form || !body || !window.FBRender) return;
  function json(id, fallback) {
    var el = document.getElementById(id);
    try { return JSON.parse(el.textContent); } catch (e) { return fallback; }
  }
  var model = json('form-model', null);
  var submitted = json('submitted', {}) || {};
  var errors = {};
  try { errors = JSON.parse(form.dataset.errors || '{}') || {}; } catch (e) { errors = {}; }
  var en = document.documentElement.lang.indexOf('en') === 0;
  if (!model || !Array.isArray(model.fields)) {
    body.textContent = en ? 'This form has no fields.' : 'Este formulario no tiene campos.';
    return;
  }
  var text = {};
  Object.keys(errors).forEach(function (k) { text[k] = String(errors[k]); });
  body.innerHTML = window.FBRender.formBody(model, { errors: text, idPrefix: 'fc_' });
  if (form.querySelector('input[type=file]')) form.enctype = 'multipart/form-data';   // a file field makes the post multipart; everything else stays urlencoded
  var submit = form.querySelector('.fb-submit');
  if (submit && form.dataset.buttons === 'true') submit.remove();   // the command buttons of the resource replace the renderer's own
  else if (submit) submit.textContent = en ? 'Save' : 'Guardar';

  /* single checkboxes post true/false semantics the platform expects; everything else keeps its natural value */
  Array.prototype.forEach.call(form.querySelectorAll('input[type=checkbox]'), function (cb) {
    if (!cb.closest('fieldset')) cb.value = 'true';
  });
  Object.keys(submitted).forEach(function (name) {
    var els = form.querySelectorAll('[name="' + name.replace(/"/g, '') + '"]');
    Array.prototype.forEach.call(els, function (el) {
      var v = submitted[name];
      if (el.type === 'checkbox') el.checked = String(v).split(',').indexOf(el.value) >= 0 || v === 'true';
      else if (el.type === 'radio') el.checked = el.value === v;
      else el.value = v;
    });
  });
  /* minimal client check: required fields only (the platform validates the rest) */
  form.addEventListener('submit', function (e) {
    var bad = null;
    Array.prototype.forEach.call(form.querySelectorAll('[required]'), function (el) {
      var empty = el.type === 'checkbox' ? !el.checked : !String(el.value || '').trim();
      el.setAttribute('aria-invalid', empty ? 'true' : 'false');
      if (empty && !bad) bad = el;
    });
    if (bad) e.preventDefault(), bad.focus();
  });
})();
