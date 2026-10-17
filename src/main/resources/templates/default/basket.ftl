<#-- Default view of any basket command (no template named by the resource's basket view): the rows the platform returned as a table with a
     filter per shown column (the platform compares equality on field values) and paging. Standard model of Pages.resultModel:
     coords, basketResource (title), columns [{name,label,show}], rows [{column: value}], pageInfo {total,pages,page,size}, query, errorMessages. -->
<#import "/layout/base.ftl" as l>
<#function qv k><#local v = (query[k])!""><#if v?is_string><#return v></#if><#return ""></#function>
<#macro val v><#if v?is_sequence><#list v as x><@val x /><#sep>, </#list><#elseif v?is_boolean>${v?c}<#elseif v?is_number>${v?c}<#elseif v?is_string><#if v?has_content>${v}<#else>—</#if><#else>—</#if></#macro>
<#assign res = basketResource!{}>
<#assign pageTitle = ((res.title)!"")?has_content?then(res.title, coords.name)>
<#assign shown = (columns![])?filter(c -> c.show)>
<#if !shown?has_content><#assign shown = (columns![])[0..*(((columns![])?size < 4)?then((columns![])?size, 4)) - 1]></#if>
<#assign total = (pageInfo.total)!0>
<#assign pages = (pageInfo.pages)!1>
<#assign pg = (pageInfo.page)!1>
<#assign keep = ""><#list shown as c><#if qv(c.name)?has_content><#assign keep = keep + c.name?url("UTF-8") + "=" + qv(c.name)?url("UTF-8") + "&"></#if></#list>
<@l.page title=pageTitle>
<div class="container" style="padding-top:24px">
  <div class="page-head"><p class="breadcrumb">${coords.module} / ${coords.name} <span class="chip">v${coords.version}</span></p>
    <h1>${pageTitle}</h1><p class="muted">${total} ${l.tr("registros", "records")}</p></div>
  <#if (errorMessages![])?has_content>
    <div class="alert alert-bad" role="alert"><i class="bi bi-exclamation-triangle"></i><div><#list errorMessages as e>${e}<#sep><br></#list></div></div>
  </#if>
  <form class="toolbar" method="get" action="${coords.path}" role="search">
    <#list shown as c>
    <div class="search"><label class="visually-hidden" for="f_${c?index}">${c.label}</label><input class="input" id="f_${c?index}" name="${c.name}" type="search" value="${qv(c.name)}" placeholder="${c.label}"></div>
    </#list>
    <button class="btn" type="submit">${l.tr("Filtrar", "Filter")}</button>
    <#if (basketOptions.exportCsv)!false>
    <a class="btn" href="${coords.path}?${keep}page=${pg}&format=csv" download><i class="bi bi-download" aria-hidden="true"></i> ${l.tr("Exportar CSV", "Export CSV")}</a>
    </#if>
  </form>
  <div class="table-wrap"><table class="table"><caption class="visually-hidden">${pageTitle}</caption>
    <thead><tr><#list shown as c><th scope="col"<#if c.align?? || c.width??> style="<#if c.align??>text-align:${c.align};</#if><#if c.width??>width:${c.width?c}px;</#if>"</#if>>${c.label}</th></#list></tr></thead>
    <tbody>
    <#list (rows![]) as r><tr><#list shown as c><td<#if c.align??> style="text-align:${c.align}"</#if>><@val (r[c.name])!"" /></td></#list></tr></#list>
    </tbody></table></div>
  <#if !(rows![])?has_content><div class="empty"><i class="bi bi-inbox" aria-hidden="true"></i><p>${l.tr("Sin registros.", "No records.")}</p></div></#if>
  <#if (pages > 1)>
  <nav class="pager" aria-label="${l.tr("Paginación", "Pagination")}"><div class="pages">
    <#list 1..pages as p><a href="${coords.path}?${keep}page=${p}"<#if p == pg> aria-current="true"</#if>>${p}</a></#list>
  </div></nav>
  </#if>
</div>
</@l.page>
