/**
 * 
 */
package com.formuscmp.formus.field;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Field to hold data and be shown as component on UI
 * @author Jose Luis Cruz Reyes - Formus CMP
 *
 */
public class AbstractField implements Comparable<AbstractField>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2677848933866689168L;
	private String name;
	private String componentType;
	private String css;
	private int order;
	private String fieldName;
	private String sourceCode;
	private String validation;
	private String value;
	private boolean hidden;
	private boolean readOnly;
	private boolean required;
	private boolean valid=false;
	private String error;
	private boolean showInBasket;
	private boolean id;
	private int length;
	private String group;
	private boolean persistible = true;
	private String origin;
	private String format;
	private boolean searcheable=false;
	private String instruction;
	private Integer decimals;
	private String dbFieldType;
	private String label;
	private String uuid;
	private String comment;
	private String template;
	private String affects;
	private String filter;
	private String events;
	private String alias;
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
	
	private String ui;
	
	
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
	 * source code to render, depending on format
	 * @return the sourceCode
	 */
	public String getSourceCode() {
		return sourceCode;
	}

	/**
	 * @param sourceCode the sourceCode to set
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	/**
	 * Name of field within formusCMP
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName( String name) {
	  this.name=name;
	}
	
	/**
	 * Assign the component type to be dsiplayed on UI, can be text, list, or any other created by user
	 * @param componentType
	 */
	public void setComponentType(String componentType) {
		this.componentType=componentType;
	}
	
	/**
	 * Get the component type to render in UI, can be text, list, or any other created by user
	 * @return componentType
	 */
	public String getComponentType() {
		return componentType;
	}
	
	/**
	 * Get CSS of Field type component
	 * @return
	 */
	public String getCss() {
		return css;
	}
	
	/**
	 * Assign the CSS for the UI component
	 * @param css
	 */
	public void setCss(String css) {
		this.css = css;
	}
	
	/**
	 * Get the order of display for UI rendering
	 * @return order
	 */
	public int getOrder() {
		return order;
	}
	
	/**
	 * Assign the order of display
	 * @param order
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * Field Name on table
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * 
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int compareTo(AbstractField o) {
		return Comparators.ORDEN.compare(this, o);
	}
	
	/**
	 * Order by order to display on sreen the collection of fields
	 * @author Jose Luis Cruz Reyes - Formus CMP
	 *
	 */
	public static class Comparators {

        public static Comparator<AbstractField> ORDEN = new Comparator<AbstractField>() {
            public int compare(AbstractField o1, AbstractField o2) {
                return o1.order - o2.order;
            }
        };
        
    }

	/**
	 * Regex validation
	 * @return the validation
	 */
	public String getValidation() {
		return validation;
	}

	/**
	 * @param validation the validation to set
	 */
	public void setValidation(String validation) {
		this.validation = validation;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * @param hidden the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Determines if this field will be shown in the basket of this form
	 * @return the showInBasket
	 */
	public boolean isShowInBasket() {
		return showInBasket;
	}

	/**
	 * @param showInBasket the showInBasket to set
	 */
	public void setShowInBasket(boolean showInBasket) {
		this.showInBasket = showInBasket;
	}

	/**
	 * Identifies the field as an index with unique values
	 * @return the id
	 */
	public boolean isId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(boolean id) {
		this.id = id;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * The field value will be persisted or not
	 * @return
	 */
	public boolean isPersistible() {
		return persistible;
	}

	/**
	 * Assign the field value will be persisted or not
	 * @param persistible
	 */
	public void setPersistible(boolean persistible) {
		this.persistible = persistible;
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
	 * Valid values are: html, bxml, ios, android
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Valid values are: html, bxml, ios, android
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the searcheable
	 */
	public boolean isSearcheable() {
		return searcheable;
	}

	/**
	 * @param searcheable the searcheable to set
	 */
	public void setSearcheable(boolean searcheable) {
		this.searcheable = searcheable;
	}

	/**
	 * @return the decimals
	 */
	public Integer getDecimals() {
		return decimals;
	}

	/**
	 * @param decimals the decimals to set
	 */
	public void setDecimals(Integer decimals) {
		this.decimals = decimals;
	}

	/**
	 * @return the dbFieldType
	 */
	public String getDbFieldType() {
		return dbFieldType;
	}

	/**
	 * @param dbFieldType the dbFieldType to set
	 */
	public void setDbFieldType(String dbFieldType) {
		this.dbFieldType = dbFieldType;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the affects
	 */
	public String getAffects() {
		return affects;
	}

	/**
	 * @param affects the affects to set
	 */
	public void setAffects(String affects) {
		this.affects = affects;
	}

	/**
	 * @return the filter
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/**
	 * @return the events
	 */
	public String getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(String events) {
		this.events = events;
	}

	

	@Override
	public String toString() {
		return "AbstractField [name=" + name + ", componentType=" + componentType + ", css=" + css + ", order=" + order
				+ ", fieldName=" + fieldName + ", sourceCode=" + sourceCode + ", validation=" + validation + ", value="
				+ value + ", hidden=" + hidden + ", readOnly=" + readOnly + ", required=" + required + ", valid="
				+ valid + ", error=" + error + ", showInBasket=" + showInBasket + ", id=" + id + ", length=" + length
				+ ", group=" + group + ", persistible=" + persistible + ", origin=" + origin + ", format=" + format
				+ ", searcheable=" + searcheable + ", instruction=" + instruction + ", decimals=" + decimals
				+ ", dbFieldType=" + dbFieldType + ", label=" + label + ", uuid=" + uuid + ", comment=" + comment
				+ ", template=" + template + ", affects=" + affects + ", filter=" + filter + ", events=" + events
				+ ", alias=" + alias + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4="
				+ param4 + ", param5=" + param5 + ", param6=" + param6 + ", param7=" + param7 + ", param8=" + param8
				+ ", param9=" + param9 + ", param10=" + param10 + ", ui=" + ui + "]";
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

	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}
	
	
}
