/**
 * 
 */
package com.formuscmp.formus.dto;

import java.util.Comparator;

/**
 * @author Jose Cruz
 * Formus CMP
 * Represents a menu option on UI, can be a basket or form
 */
public class MenuDto implements Comparable<MenuDto>{
	
	/**
	 * Default constructor
	 */
	public MenuDto() {
		super();
	}
	
	/**
	 * @param assetLibrary
	 * @param title
	 * @param parentUuid
	 * @param version
	 * @param uuid
	 * @param module
	 * @param resourceType
	 * @param resourceName
	 */
	public MenuDto(String assetLibrary, String title, String parentUuid, String version, String uuid, String module,
			String resourceType, String resourceName, boolean createable) {
		super();
		this.assetLibrary = assetLibrary;
		this.title = title;
		this.parentUuid = parentUuid;
		this.version = version;
		this.uuid = uuid;
		this.module = module;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.createable = createable;
	}
	
	//base or company asset
	private String assetLibrary;
	//Form/Use Case title, Field label, Button label
	private String title;
	//Use Case form, fields and buttons parent
	private String parentUuid;
	//version of the asset
	private String version;
	//uuid of object
	private String uuid;
	//module of the modulo, example CRM
	private String module;
	//forma or canasta
	private String resourceType;
	//Name of the canasta or form
	private String resourceName;
	//is it createable to put on menu
	private boolean createable;
	
	/**
	 * @return the assetLibrary
	 */
	public String getAssetLibrary() {
		return assetLibrary;
	}
	/**
	 * @param assetLibrary the assetLibrary to set
	 */
	public void setAssetLibrary(String assetLibrary) {
		this.assetLibrary = assetLibrary;
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
	 * @return the parentUuid
	 */
	public String getParentUuid() {
		return parentUuid;
	}
	/**
	 * @param parentUuid the parentUuid to set
	 */
	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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

	@Override
	public int compareTo(MenuDto o) {
		return Comparators.NAME.compare(this, o);
	}
	
	public static class Comparators {

        public static Comparator<MenuDto> NAME = new Comparator<MenuDto>() {
            public int compare(MenuDto a, MenuDto b) {
            	return a.title.compareTo(b.title);
            }
        };
        
    }

	@Override
	public String toString() {
		return "MenuDto [assetLibrary=" + assetLibrary + ", title=" + title + ", parentUuid=" + parentUuid
				+ ", version=" + version + ", uuid=" + uuid + ", module=" + module + ", resourceType=" + resourceType
				+ ", resourceName=" + resourceName + ", createable=" + createable + "]";
	}
	
	
}
