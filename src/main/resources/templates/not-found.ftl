<#import "/layout/base.ftl" as l>
<@l.page title="404" chrome="public">
<div class="container container-narrow"><div class="empty" style="padding:80px 0">
  <i class="bi bi-compass"></i>
  <h1>${l.tr("No encontramos esta página", "We could not find this page")}</h1>
  <p>${l.tr("La dirección no existe o ya no está disponible.", "The address does not exist or is no longer available.")}</p>
  <a class="btn btn-primary" href="/">${l.tr("Volver al inicio", "Back to home")}</a>
</div></div>
</@l.page>
