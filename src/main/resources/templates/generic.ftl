<#import "/layout/base.ftl" as l>
<@l.page title="">
<div class="container section">
  <#if (errorMessages![])?has_content><div class="alert alert-bad" role="alert"><div><#list errorMessages as e>${e}<#sep><br></#list></div></div></#if>
  <#if (data!{})?has_content><div class="card"><dl class="kv"><#list data as k, v><dt>${k}</dt><dd>${v?string}</dd></#list></dl></div></#if>
</div>
</@l.page>
