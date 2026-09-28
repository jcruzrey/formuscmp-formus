/**
 * 
 */
package com.formuscmp.formus.resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Jose Luis Cruz Reyes
 *
 */
@JsonTypeName("UseCase")
public class UseCase {
	private String name;
	private String resourceName;
	private String title;
	private boolean createable;
	private Map<String,Step> steps = new HashMap<String,Step>();
	private Set<String> owners = new HashSet<String>();
	private Long lastUpdateDate = 0L;
	private Long lastExecutionDate = 0L;
	private String module;
	private String alias;
	private String prefix;
	private String version;
	private String locale;
	private String uuid;
	private String resourceType;
	private String status;
	
	/**
	 * @return the steps
	 */
	public Map<String, Step> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(Map<String, Step> steps) {
		this.steps = steps;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the owners
	 */
	public Set<String> getOwners() {
		return owners;
	}
	/**
	 * @param owners the owners to set
	 */
	public void setOwners(Set<String> owners) {
		this.owners = owners;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public Long getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Long lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the lastExecutionDate
	 */
	public Long getLastExecutionDate() {
		return lastExecutionDate;
	}
	/**
	 * @param lastExecutionDate the lastExecutionDate to set
	 */
	public void setLastExecutionDate(Long lastExecutionDate) {
		this.lastExecutionDate = lastExecutionDate;
	}
	/**
	 * @return the createable
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
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	@Override
	public String toString() {
		return "UseCase [name=" + name + ", resourceName=" + resourceName + ", title=" + title + ", createable="
				+ createable + ", steps=" + steps + ", owners=" + owners + ", lastUpdateDate=" + lastUpdateDate
				+ ", lastExecutionDate=" + lastExecutionDate + ", module=" + module + ", alias=" + alias + ", prefix="
				+ prefix + ", version=" + version + ", locale=" + locale + ", uuid=" + uuid + ", resourceType="
				+ resourceType + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
