<#-- Default view of any form command (no template named by the resource's view). Standard model of Pages.resultModel:
     coords {module,type,name,version,command,path}, resource (title, instruction), formModel (escaped JSON for the shared renderer, the ONLY
     ?no_esc), buttons [{label,css,command,action}], fieldErrors, errorMessages. The fields are drawn by fwc-form.js; each button posts to
     its own command's address (CSRF field included) and the answer is drawn by the view that command returns. -->
<#import "/layout/base.ftl" as l>
<#assign res = resource!{}>
<#assign pageTitle = ((res.title)!"")?has_content?then(res.title, coords.name)>
<@l.page title=pageTitle js=["/static/js/fb-render.js", "/static/js/fwc-form.js"]>
<style>[hidden]{display:none!important}.fc-wrap{max-width:760px;margin:0 auto;padding:32px 16px}.fc-actions{display:flex;gap:10px;flex-wrap:wrap;margin-top:18px}</style>
<div class="fc-wrap">
  <p class="breadcrumb">${coords.module} / ${coords.name} <span class="chip">v${coords.version}</span></p>
  <h1>${pageTitle}</h1>
  <#if ((res.instruction)!"")?has_content><p class="muted">${res.instruction}</p></#if>
  <#if (errorMessages![])?has_content>
    <div class="alert alert-bad" role="alert"><i class="bi bi-exclamation-triangle"></i><div><#list errorMessages as e>${e}<#sep><br></#list></div></div>
  </#if>
  <#assign errJson>{<#list (fieldErrors!{}) as k, v>"${k?json_string}":"${v?string?json_string}"<#sep>,</#list>}</#assign>
  <div class="card">
    <form method="post" action="${(buttons![])?has_content?then(buttons[0].action, coords.path)}" class="fb-form" id="fcForm" novalidate data-errors='${errJson}' data-buttons="${(buttons![])?has_content?c}">
      <input type="hidden" name="_csrf" value="${csrfToken!""}">
      <#if (query.uuid)??><input type="hidden" name="uuid" value="${query.uuid}"></#if>
      <div id="fcBody"><noscript>${l.tr("Se necesita JavaScript para mostrar el formulario.", "JavaScript is required to show the form.")}</noscript></div>
      <#if (buttons![])?has_content>
      <div class="fc-actions"><#list buttons as b><button type="submit" class="btn ${(b.css)!""}" formaction="${b.action}" data-command="${b.command}">${b.label}</button></#list></div>
      </#if>
    </form>
  </div>
  <script type="application/json" id="form-model">${(formModel!"null")?no_esc}</script>
</div>
</@l.page>
