<#import "/layout/base.ftl" as l>
<@l.page title="Pending" nav="">
<div class="container section">
  <div class="alert alert-info" role="status"><i class="bi bi-hammer"></i><div><b>${l.tr("Página pendiente de conversión", "Page pending conversion")}</b><br>
  Template <code>${pendingTemplate!""}</code> — see <code>prototype/</code> (tasks.md Phase 6-8b).</div></div>
  <pre class="card" style="overflow:auto;font-size:.8rem">${pendingJson!""}</pre>
</div>
</@l.page>
