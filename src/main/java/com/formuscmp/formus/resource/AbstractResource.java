/**
 * 
 */
package com.formuscmp.formus.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.formuscmp.formus.button.Button;
import com.formuscmp.formus.field.AbstractField;
import com.formuscmp.formus.field.Field;

/**
 * @author jcruzrey
 *
 */
@JsonTypeInfo(use=Id.NAME)
@JsonSubTypes({
	@JsonSubTypes.Type(value=Resource.class, name="Resource")
})
public abstract class AbstractResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4959363466584761630L;

	public AbstractResource() {
		super();
	}

	private String name;
	private String commandName;
	private String title;
	private String view;
	private String version;
	private String status;
	private String module;
	private String basket;
	private boolean createable;
	private String table;
	private String createdBy;
	private String modifiedBy;
	private boolean validate = false;
	private boolean persistible = true;
	//@JsonbTransient
	private Long lastModificationDate=0L;
	@JsonIgnore
	private Long lastAccessDate=0L;
	private List<Button> methods = new ArrayList<Button>();
	private List<Field> model = new ArrayList<Field>();
	private Map<String, List<Field>> decorators = new HashMap<String,List<Field>>();
	private String resourcePath;
	private String instruction;
	private String destination="db::mysql"; //jms, bd, cassandra
	private String origin="ui::case"; //ui, jms, bd, cassandra
	private boolean versionable = true;
	private boolean searcheable; // se muestra en forma de busqueda
	private String uuid;
	private String comment;
	private Long quoteRangeTimeLimit = 0L;
	private Long quoteTimeSecondsLimit = 0L;
	private Long activationDateRangeStart=0L;
	private Long activationDateRangeEnd=0L;
	private boolean dirty = false;
	private String alias;
	private String prefix;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private String param7;
	private String param8;
	private String param9;
	private String param10;
	
	/**
	 * @return the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}
	/**
	 * @param resourcePath the resourcePath to set
	 */
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	/**
	 * 
	 * @return instruction
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * 
	 * @param instruction
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * 
	 * @param fields
	 */
	public void setModel(List<Field> model) {
		this.model=model;
	}
	/**
	 * 
	 * @return fields
	 */
	public List<Field> getModel() {
		return this.model;
	}

	public AbstractField getField(final String fieldName) {
		for (AbstractField temp : model) {
			if (fieldName.equals(temp.getGroup() + "." +  temp.getName())) return temp;
		}
		return null;
	}

	public AbstractField getFieldByDbName(final String dbName) {
		for (AbstractField temp : model) {
			if (dbName.equals(temp.getFieldName())) return temp;
		}
		return null;
	}
	
	public AbstractField getFieldByUuid(final String uuid) {
		for (AbstractField temp : model) {
			if (uuid.equals(temp.getUuid())) return temp;
		}
		return null;
	}
	
	public AbstractField getFieldByName(final String fieldName) {
		for (AbstractField temp : model) {
			//System.out.println("Buscando:" + fieldName + ", comparando contra:" + temp.getName() + ", iguales:" + fieldName.equals(temp.getName()));
			if (fieldName.equals(temp.getName())) 
				return temp;
		}
		return null;
	}

	public Button getMethod(final String buttonName) {
		for (Button temp : methods) {
			if (buttonName.equals(temp.getName())) 
				return temp;
		}
		return null;
	}

	public Button getMethodByCommand(final String commandName) {
		for (Button temp : methods) {
			if (commandName.equals(temp.getCommandName())) return temp;
		}
		return null;
	}
	
	public Button getMethodByUuid(final String uuid) {
		for (Button temp : methods) {
			if (uuid.equals(temp.getUuid())) return temp;
		}
		return null;
	}
	/**
	 * 
	 * @return buttons
	 */
	public List<Button> getMethods() {
		return methods;
	}
	
	/**
	 * 
	 * @param buttons
	 */
	public void setMethods(List<Button> methods) {
		this.methods = methods;
	}

	/**
	 * @return the titulo
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	/**
	 * @return the view
	 */
	public String getView() {
		return view;
	}
	/**
	 * @param view the view to set
	 */
	public void setView(String view) {
		this.view = view;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}
	/**
	 * @return the basket
	 */
	public String getBasket() {
		return basket;
	}
	/**
	 * @param basket the basket to set
	 */
	public void setBasket(String basket) {
		this.basket = basket;
	}
	/**
	 * @return the create
	 */
	public boolean isCreateable() {
		return createable;
	}
	/**
	 * @param createable the createable to set
	 */
	public void setCreateable(boolean createable) {
		this.createable = createable;
	}
	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the validar
	 */
	public boolean isValidate() {
		return validate;
	}
	/**
	 * @param validar the validar to set
	 */
	public void setValidate(boolean validar) {
		this.validate = validar;
	}
	/**
	 * @return the lastModificationDate
	 */
	public Long getLastModificationDate() {
		return lastModificationDate;
	}
	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Long lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	/**
	 * @return the persistible
	 */
	public boolean isPersistible() {
		return persistible;
	}
	/**
	 * @param persistible the persistible to set
	 */
	public void setPersistible(boolean persistible) {
		this.persistible = persistible;
	}

	public List<AbstractField> getFieldsByGroup(final String groupName) {
		List<AbstractField> grupo = new ArrayList<AbstractField>();
		for (AbstractField temp : model) {
			if (groupName.equals(temp.getGroup())) grupo.add(temp);
		}
		return grupo;
	}

	public List<Button> getMethodsByEvent(final String event) {
		List<Button> accionesEvento = new ArrayList<Button>();
		for (Button temp : methods) {
			String[] eventos = temp.getEvents().split(",");
			for(int i = 0; i < eventos.length; i++) {
				if (eventos[i].equals(event)) 
					accionesEvento.add(temp);
			}
		}
		return accionesEvento;
	}

	public Button getMethodByName(final String methodName) {
		Button accionEvento = null;
		for (Button temp : methods) {
			if (temp.getName().equals(methodName)) {
				accionEvento = temp;
				break;
			}
			
		}
		return accionEvento;
	}
	
	/**
	 * Returns a list of Accion
	 * @param event
	 * @param status
	 * @return
	 */
	public List<Button> getMethodsByEventAndStatus(final String event, final String status) {
		List<Button> accionesEvento = new ArrayList<Button>();
		for (Button accion : methods) {
			String[] eventos = accion.getEvents().split(",");
			for(int i = 0; i < eventos.length; i++) {
				if (null==accion.getStatus() || accion.getStatus().equals("")) {
					if (eventos[i].equals(event)) accionesEvento.add(accion);
				}else {
					if (eventos[i].equals(event) && accion.getStatus().equals(status)) accionesEvento.add(accion);
				}
			}
		}
		return accionesEvento;
	}

	/**
	 * @return the decorators
	 */
	public Map<String, List<Field>> getDecorators() {
		return decorators;
	}
	/**
	 * @param decorators the decorators to set
	 */
	public void setDecorators(Map<String, List<Field>> decorators) {
		this.decorators = decorators;
	}
	/**
	 * 
	 * @return destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * 
	 * @param destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * 
	 * @return versionable
	 */
	public boolean isVersionable() {
		return versionable;
	}
	/**
	 * 
	 * @param versionable
	 */
	public void setVersionable(boolean versionable) {
		this.versionable = versionable;
	}
	/**
	 * 
	 * @return searcheable
	 */
	public boolean isSearcheable() {
		return searcheable;
	}
	/**
	 * 
	 * @param searcheable
	 */
	public void setSearcheable(boolean searcheable) {
		this.searcheable = searcheable;
	}
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the quoteRangeTimeLimit
	 */
	public Long getQuoteRangeTimeLimit() {
		return quoteRangeTimeLimit;
	}
	/**
	 * @param quoteRangeTimeLimit the quoteRangeTimeLimit to set
	 */
	public void setQuoteRangeTimeLimit(Long quoteRangeTimeLimit) {
		this.quoteRangeTimeLimit = quoteRangeTimeLimit;
	}
	/**
	 * @return the quoteTimeSecondsLimit
	 */
	public Long getQuoteTimeSecondsLimit() {
		return quoteTimeSecondsLimit;
	}
	/**
	 * @param quoteTimeSecondsLimit the quoteTimeSecondsLimit to set
	 */
	public void setQuoteTimeSecondsLimit(Long quoteTimeSecondsLimit) {
		this.quoteTimeSecondsLimit = quoteTimeSecondsLimit;
	}
	/**
	 * @return the activationDateRangeStart
	 */
	public Long getActivationDateRangeStart() {
		return activationDateRangeStart;
	}
	/**
	 * @param activationDateRangeStart the activationDateRangeStart to set
	 */
	public void setActivationDateRangeStart(Long activationDateRangeStart) {
		this.activationDateRangeStart = activationDateRangeStart;
	}
	/**
	 * @return the activationDateRangeEnd
	 */
	public Long getActivationDateRangeEnd() {
		return activationDateRangeEnd;
	}
	/**
	 * @param activationDateRangeEnd the activationDateRangeEnd to set
	 */
	public void setActivationDateRangeEnd(Long activationDateRangeEnd) {
		this.activationDateRangeEnd = activationDateRangeEnd;
	}
	
	/**
	 * @return the dirty
	 */
	public boolean isDirty() {
		return dirty;
	}
	/**
	 * @param dirty the dirty to set
	 */
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getParam4() {
		return param4;
	}
	public void setParam4(String param4) {
		this.param4 = param4;
	}
	public String getParam5() {
		return param5;
	}
	public void setParam5(String param5) {
		this.param5 = param5;
	}
	public String getParam6() {
		return param6;
	}
	public void setParam6(String param6) {
		this.param6 = param6;
	}
	public String getParam7() {
		return param7;
	}
	public void setParam7(String param7) {
		this.param7 = param7;
	}
	public String getParam8() {
		return param8;
	}
	public void setParam8(String param8) {
		this.param8 = param8;
	}
	public String getParam9() {
		return param9;
	}
	public void setParam9(String param9) {
		this.param9 = param9;
	}
	public String getParam10() {
		return param10;
	}
	public void setParam10(String param10) {
		this.param10 = param10;
	}
	public Long getLastAccessDate() {
		return lastAccessDate;
	}
	public void setLastAccessDate(Long lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}
	@Override
	public String toString() {
		return "AbstractResource [name=" + name + ", commandName=" + commandName
				+ ", title=" + title + ", view=" + view + ", version=" + version + ", status=" + status + ", module="
				+ module + ", basket=" + basket + ", createable=" + createable + ", table=" + table + ", createdBy="
				+ createdBy + ", modifiedBy=" + modifiedBy + ", validate=" + validate + ", persistible=" + persistible
				+ ", lastModificationDate=" + lastModificationDate + ", lastAccessDate=" + lastAccessDate + ", methods="
				+ methods + ", model=" + model + ", decorators=" + decorators + ", resourcePath=" + resourcePath
				+ ", instruction=" + instruction + ", destination=" + destination + ", origin=" + origin
				+ ", versionable=" + versionable + ", searcheable=" + searcheable + ", uuid=" + uuid + ", comment="
				+ comment + ", quoteRangeTimeLimit=" + quoteRangeTimeLimit + ", quoteTimeSecondsLimit="
				+ quoteTimeSecondsLimit + ", activationDateRangeStart=" + activationDateRangeStart
				+ ", activationDateRangeEnd=" + activationDateRangeEnd + ", dirty=" + dirty + ", alias=" + alias
				+ ", prefix=" + prefix + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3
				+ ", param4=" + param4 + ", param5=" + param5 + ", param6=" + param6 + ", param7=" + param7
				+ ", param8=" + param8 + ", param9=" + param9 + ", param10=" + param10 + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(activationDateRangeEnd, activationDateRangeStart, alias, basket, commandName,
				comment, createable, createdBy, decorators, destination, dirty, instruction, lastAccessDate,
				lastModificationDate, methods, model, modifiedBy, module, name, origin, param1, param10, param2, param3,
				param4, param5, param6, param7, param8, param9, persistible, prefix, quoteRangeTimeLimit,
				quoteTimeSecondsLimit, resourcePath, searcheable, status, table, title, uuid, validate, version,
				versionable, view);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractResource other = (AbstractResource) obj;
		return Objects.equals(activationDateRangeEnd, other.activationDateRangeEnd)
				&& Objects.equals(activationDateRangeStart, other.activationDateRangeStart)
				&& Objects.equals(alias, other.alias) && Objects.equals(basket, other.basket)
				&& Objects.equals(commandName, other.commandName)
				&& Objects.equals(comment, other.comment) && createable == other.createable
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(decorators, other.decorators)
				&& Objects.equals(destination, other.destination) && dirty == other.dirty
				&& Objects.equals(instruction, other.instruction)
				&& Objects.equals(lastAccessDate, other.lastAccessDate)
				&& Objects.equals(lastModificationDate, other.lastModificationDate)
				&& Objects.equals(methods, other.methods) && Objects.equals(model, other.model)
				&& Objects.equals(modifiedBy, other.modifiedBy) && Objects.equals(module, other.module)
				&& Objects.equals(name, other.name) && Objects.equals(origin, other.origin)
				&& Objects.equals(param1, other.param1) && Objects.equals(param10, other.param10)
				&& Objects.equals(param2, other.param2) && Objects.equals(param3, other.param3)
				&& Objects.equals(param4, other.param4) && Objects.equals(param5, other.param5)
				&& Objects.equals(param6, other.param6) && Objects.equals(param7, other.param7)
				&& Objects.equals(param8, other.param8) && Objects.equals(param9, other.param9)
				&& persistible == other.persistible && Objects.equals(prefix, other.prefix)
				&& Objects.equals(quoteRangeTimeLimit, other.quoteRangeTimeLimit)
				&& Objects.equals(quoteTimeSecondsLimit, other.quoteTimeSecondsLimit)
				&& Objects.equals(resourcePath, other.resourcePath) && searcheable == other.searcheable
				&& Objects.equals(status, other.status) && Objects.equals(table, other.table)
				&& Objects.equals(title, other.title) && Objects.equals(uuid, other.uuid) && validate == other.validate
				&& Objects.equals(version, other.version) && versionable == other.versionable
				&& Objects.equals(view, other.view);
	}
	
	
}
