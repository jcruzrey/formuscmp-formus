<#import "/layout/base.ftl" as l>
<@l.page title=l.tr("Error", "Error") chrome="public">
<div class="container container-narrow"><div class="empty" style="padding:80px 0">
  <i class="bi bi-exclamation-triangle"></i>
  <h1>${l.tr("Algo salió mal", "Something went wrong")}</h1>
  <p>
  <#switch code!"server">
    <#case "backend">${l.tr("No pudimos comunicarnos con el servicio. Intenta de nuevo en unos minutos.", "We could not reach the service. Please try again in a few minutes.")}<#break>
    <#case "csrf">${l.tr("Tu sesión expiró o el formulario no es válido. Recarga la página e intenta de nuevo.", "Your session expired or the form is not valid. Reload the page and try again.")}<#break>
    <#case "forbidden">${l.tr("No tienes permiso para realizar esta acción.", "You are not allowed to do this.")}<#break>
    <#case "too_large">${l.tr("El contenido enviado es demasiado grande.", "The submitted content is too large.")}<#break>
    <#case "bad_request">${l.tr("La solicitud no es válida.", "The request is not valid.")}<#break>
    <#case "method_not_allowed">${l.tr("Método no permitido.", "Method not allowed.")}<#break>
    <#default>${l.tr("Ocurrió un error inesperado. Intenta de nuevo.", "An unexpected error occurred. Please try again.")}
  </#switch>
  </p>
  <#if (correlationId!"")?has_content><p class="muted">ID: ${correlationId}</p></#if>
  <a class="btn" href="/">${l.tr("Volver al inicio", "Back to home")}</a>
</div></div>
</@l.page>
