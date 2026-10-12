<#import "/layout/base.ftl" as l>
<@l.page title=l.tr("Iniciar sesión", "Sign in") chrome="public">
<div class="auth-wrap"><div class="card auth-card">
  <img class="brand-big" src="${brandLogo!"/static/img/logo-cmp.png"}" alt="${brand!""}">
  <h1 style="text-align:center;font-size:1.5rem">${l.tr("Inicia sesión", "Sign in")}</h1>
  <p class="muted" style="text-align:center">${l.tr("Usa tu cuenta de Google o Facebook; no necesitas contraseña.", "Use your Google or Facebook account; no password needed.")}</p>
  <#if errorCode??>
    <div class="alert alert-bad" role="alert"><div>
      <#switch errorCode>
        <#case "denied">${l.tr("Cancelaste el inicio de sesión.", "You cancelled the sign-in.")}<#break>
        <#case "state">${l.tr("No pudimos verificar el inicio de sesión. Intenta de nuevo.", "We could not verify the sign-in. Try again.")}<#break>
        <#case "provider">${l.tr("El proveedor no pudo validar tu cuenta. Intenta de nuevo.", "The provider could not validate your account. Try again.")}<#break>
        <#case "noemail">${l.tr("No obtuvimos un correo verificado de tu cuenta. Usa otra cuenta.", "We did not get a verified e-mail from your account. Use another account.")}<#break>
        <#case "identify">${l.tr("No pudimos identificar tu usuario en este momento. Intenta más tarde.", "We could not identify your user right now. Try again later.")}<#break>
        <#default>${l.tr("Tu sesión expiró. Intenta iniciar sesión de nuevo.", "Your session expired. Please sign in again.")}
      </#switch>
    </div></div>
  </#if>
  <#if providers.google><a class="btn btn-social" href="/auth/google/login<#if next?has_content>?next=${next?url}</#if>"><i class="bi bi-google"></i> ${l.tr("Continuar con Google", "Continue with Google")}</a></#if>
  <#if providers.facebook><div style="height:10px"></div><a class="btn btn-social" href="/auth/facebook/login<#if next?has_content>?next=${next?url}</#if>"><i class="bi bi-facebook"></i> ${l.tr("Continuar con Facebook", "Continue with Facebook")}</a></#if>
  <#if providers.dev>
    <div class="divider">DEV</div>
    <form method="post" action="/auth/dev/login">
      <input type="hidden" name="_csrf" value="${csrfToken}"><input type="hidden" name="next" value="${next!""}">
      <div class="field"><label for="devEmail">E-mail</label><input id="devEmail" name="email" type="email" required></div>
      <button class="btn btn-block" type="submit">Dev login</button>
    </form>
  </#if>
</div></div>
</@l.page>
