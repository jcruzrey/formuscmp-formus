  <div class="col-auto form-group">
    <label for="name">${campo.nombre} <#if campo.requerido!false >*</#if></label>
    <#if accion == "nuevo">
    	<input type="text" class="form-control" name="${campo.bd}" id="${campo.bd}" placeholder="${campo.nombre}" value="${(campo.valor)!""}" <#if campo.requerido!false >required</#if> <#if campo.lectura!false >readonly</#if>/>
    <#else>
    	<#if campo.valido!false>
    		<input type="text" class="form-control is-valid" name="${campo.bd}" id="${campo.bd}" placeholder="${campo.nombre}" value="${(campo.valor)!""}" <#if campo.requerido!false >required</#if>/>
    	<#else>
    		<input type="text" class="form-control is-invalid" name="${campo.bd}" id="${campo.bd}" placeholder="${campo.nombre}" value="${(campo.valor)!""}" <#if campo.requerido!false >required</#if>/>
    	</#if>
    </#if>
    
    <div class="valid-feedback">
      Correcto
    </div>
    <div class="invalid-feedback">
      <#if campo.error?has_content>
      	${campo.error}
      <#else>
      	Incorrecto
      </#if>
    </div>
  </div>