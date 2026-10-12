<#-- Shared page chrome (prototype/ is the visual reference). Model: lang, user?, isStaff?, csrfToken, flash?.
     Usage: <#import "/layout/base.ftl" as l>  <@l.page title="..." nav="data" chrome="app|public|none"> ... </@l.page> -->
<#function tr es en><#return ((lang!"es") == "en")?then(en, es)></#function>
<#-- css/js: lists of /static paths for this page. Every page gets fb-app.js (the FB helper); fb-render.js is added by pages that
     render form fields. JSON embedded in <script type="application/json"> must come from the handler already escaped
     (Ctx.scriptJson) and be printed with ?no_esc. -->
<#macro page title="" nav="" chrome="app" css=[] js=[] bodyClass="">
<!doctype html>
<html lang="${((lang!"es") == "en")?then("en-US", "es-MX")}">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>${title}<#if title?has_content> · </#if>${brand!"Formus Web Client"}</title>
<link rel="icon" href="${brandLogo!"/static/img/logo-cmp.png"}">
<#assign v = "?v=" + (assetV!"0")>
<link rel="stylesheet" href="/static/css/bootstrap-icons.min.css${v}">
<link rel="stylesheet" href="/static/css/fb.css${v}">
<link rel="stylesheet" href="/static/css/fb-form.css${v}">
<#list css as c><link rel="stylesheet" href="${c}${v}">
</#list>
<meta name="csrf-token" content="${csrfToken!""}">
<meta name="fb-urls" content="${urlsJson!"{}"}">
<#if user??><meta name="fb-user" content="${user.email}" data-name="${user.name!""}" data-role="${user.role!"solicitante"}" data-id="${user.id!""}"></#if>
</head>
<body<#if bodyClass?has_content> class="${bodyClass}"</#if>>
<#if chrome != "none">
<header class="topbar"><div class="container topbar-in">
  <a class="brand" href="${user???then(home!"/", "/")}"><img src="${brandLogo!"/static/img/logo-cmp.png"}" alt="${brand!""}"><small>${brand!"Formus Web Client"}</small></a>
  <#if chrome == "app" && user??>
  <nav class="nav-pills" aria-label="${tr("Principal", "Main")}">
    <#list (navItems![]) as n><#if (n.href!"")?has_content && (!(n.staffOnly!false) || (user.role)! == "staff")><a href="${n.href}"<#if nav == n.key> aria-current="page"</#if>>${n.label}</a></#if></#list>
  </nav>
  </#if>
  <div class="topbar-right">
    <#if chrome == "app" && (user.plan)!?has_content><a class="plan-badge" href="${(urls.plans)!"#"}" title="${tr("Tu plan", "Your plan")}"><i class="bi bi-gem" aria-hidden="true"></i> ${user.plan}</a></#if>
    <div class="lang" role="group" aria-label="Language">
      <button type="button" data-lang="es" aria-pressed="${((lang!"es") == "es")?c}">ES</button>
      <button type="button" data-lang="en" aria-pressed="${((lang!"es") == "en")?c}">EN</button>
    </div>
    <#if user??>
    <details class="menu-wrap"><summary class="avatar-btn"><span class="avatar">${user.initials}</span></summary>
      <div class="menu open" role="menu">
        <div class="who"><#if (user.library)!?has_content><span class="lib" title="${tr("Biblioteca de recursos", "Resource library")}"><i class="bi bi-collection" aria-hidden="true"></i> ${user.library}</span><br></#if>${user.name!""}<br>${user.email}<br><span class="chip">${(user.role == "staff")?then("Staff", tr("Usuario", "User"))}</span></div><hr>
        <#list (menuItems![]) as n><#if !(n.staffOnly!false) || (user.role)! == "staff"><#if (n.href!"")?has_content><a href="${n.href}" role="menuitem"<#if (n.key)?has_content && nav == n.key> aria-current="page"</#if>>${n.label}</a><#elseif (n.children![])?has_content><#assign grpOpen = false><#assign grpShown = 0><#list n.children as ch><#if !(ch.staffOnly!false) || (user.role)! == "staff"><#assign grpShown = grpShown + 1><#if (ch.key)?has_content && nav == ch.key><#assign grpOpen = true></#if></#if></#list><#if grpShown gt 0><details class="menu-group"<#if grpOpen> open</#if>><summary>${n.label}<i class="bi bi-chevron-down" aria-hidden="true"></i></summary><div class="menu-sub"><#list n.children as ch><#if !(ch.staffOnly!false) || (user.role)! == "staff"><a href="${ch.href}" role="menuitem"<#if (ch.key)?has_content && nav == ch.key> aria-current="page"</#if>>${ch.label}</a></#if></#list></div></details></#if><#else><div class="menu-head" role="presentation">${n.label}</div></#if></#if></#list><#if (menuItems![])?has_content><hr></#if>
        <form method="post" action="/auth/logout"><input type="hidden" name="_csrf" value="${csrfToken}"><button type="submit">${tr("Cerrar sesión", "Log out")}</button></form>
      </div></details>
    <#else>
    <a class="btn btn-primary btn-sm" href="/login">${tr("Iniciar sesión", "Sign in")}</a>
    </#if>
  </div>
</div></header>
</#if>
<main>
<#if flash??>
  <#assign flashCodes = flashMessages!{}>
  <div class="container"><div class="alert alert-${(flash.kind == "error")?then("bad", "ok")}" role="status">${flashCodes[flash.text]!flash.text}</div></div>
</#if>
<#nested>
</main>
<#if footerText?? || footerLogo??>
<footer class="footer"><div class="container row"><div class="by"><#if footerText??>${footerText} </#if><#if footerLogo??><img src="${footerLogo}" alt="${footerAlt!""}"></#if></div>
<#if footerNote??><div class="muted">${footerNote}</div></#if></div></footer>
</#if>
<script src="/static/js/fb-app.js${v}"></script>
<#list js as j><script src="${j}${v}"></script>
</#list>
</body>
</html>
</#macro>
