/**
 * 
 */
package com.formuscmp.formus.button;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Defines a button to be used in the UI as component
 * @author Jose Luis Cruz Reyes - Formus CMP
 *
 */
public abstract class AbstractButton implements Comparable<AbstractButton>, Serializable{

	private static final long serialVersionUID = 1447720143738921325L;
	private String commandName;
	private String name;
	private String label;
	private String componentType; //text,list, etc
	private String css;
	private int order;
	private String sourceCode;
	private String resourceName;
	private String module;
	private boolean hidden;
	private String resourceType="form"; //form o basket
	private String version;
	private String events;
	private String status;
	private String view;
	private String instruction;
	private String uuid;
	private String comment;
	private String template;
	private String icon;
	private String alias;
	private String ui;
	
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * UI Component Type
	 * @return button to submit, button to call JS, link, etc
	 */
	public String getComponentType() {
		return componentType;
	}
	/**
	 * Assign the component Type, can be button to submit, button to call JS, link  or any component created by the user
	 * inside its asset library
	 * @param componentType
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	/**
	 * CSS for the UI Component
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
	 * Display order on screen in case you want to render from collection
	 * To render specific component, use other methods
	 * @return order
	 */
	public int getOrder() {
		return order;
	}
	
	/**
	 * Assign the display order for screen rendering based on colletion
	 * @param order
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * Get the generated source code to render on UI
	 * @return sourceCode
	 */
	public String getSourceCode() {
		return sourceCode;
	}
	
	/**
	 * Assign the source code to render the component on the UI
	 * @param sourceCode
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	/**
	 * Will the button be hidden
	 * @return hidden
	 */
	public boolean isHidden() {
		return hidden;
	}
	
	/**
	 * Assign if the component will be hidden
	 * @param hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public int compareTo(AbstractButton o) {
		return Comparators.ORDEN.compare(this, o);
	}
	
	/**
	 * Order by order to render
	 * @author Jose Luis Cruz Reyes - Formus CMP
	 *
	 */
	public static class Comparators {

        public static Comparator<AbstractButton> ORDEN = new Comparator<AbstractButton>() {
            public int compare(AbstractButton o1, AbstractButton o2) {
                return o1.order - o2.order;
            }
        };
        
    }
	
	/**
	 * Label of button on UI
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
	 * Getthe name of the button
	 * @return the resourceName, the name of the form or basket
	 */
	public String getResourceName() {
		return resourceName;
	}
	
	/**
	 * Assign the name of the button
	 * @param resourceName the resourceName to set, the name of the form or basket
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	/**
	 * Use for constructing the url to be executed by this button on click on UI
	 * @return the module
	 */
	public String getModule() {
		return module;
	}
	
	/**
	 * Assign the module to be used when constructing the Url when clicked on UI
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}
	/**
	 * @return the resourceType
	 * form o basket
	 */
	public String getResourceType() {
		return resourceType;
	}
	/**
	 * @param resourceType the resourceType to set
	 * form o basket
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	/**
	 * The version of the form or basket
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * Assig the verion of the basket or form to be used when calling logic on the command
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * The events in which the button will be shown, can be new, save, detail, update, delete
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
	/**
	 * @return the commandName
	 */
	public String getCommandName() {
		return commandName;
	}
	/**
	 * @param commandName the commandName to set
	 */
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getUi() {
		return ui;
	}
	
	public void setUi(String ui) {
		this.ui = ui;
	}
	
	@Override
	public String toString() {
		return "AbstractButton [commandName=" + commandName + ", name=" + name + ", label=" + label + ", componentType="
				+ componentType + ", css=" + css + ", order=" + order + ", sourceCode=" + sourceCode + ", resourceName="
				+ resourceName + ", module=" + module + ", hidden=" + hidden + ", resourceType=" + resourceType
				+ ", version=" + version + ", events=" + events + ", status=" + status + ", view=" + view
				+ ", instruction=" + instruction + ", uuid=" + uuid + ", comment=" + comment + ", template=" + template
				+ ", icon=" + icon + ", alias=" + alias + ", ui=" + ui + "]";
	}
	
	
}
