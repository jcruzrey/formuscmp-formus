<#-- A custom view an application would add: named by the view "tablero" in the resource JSON. -->
<#import "/layout/base.ftl" as l>
<@l.page title="Tablero">
<p id="marker">TABLERO:${(resource.title)!""}|${(data.total)!"-"}|${coords.command}|${buttons?size}</p>
</@l.page>
