/**
 * 
 */
package com.formuscmp.formus.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.formuscmp.common.exception.ErrorMessage;
import com.formuscmp.formus.dto.MenuDto;
import com.formuscmp.formus.resource.Resource;
import com.formuscmp.formus.resource.UseCase;
/**
 * @author Jose Luis Cruz Reyes
 * Formus CMP
 *
 */
public class ResponseResource {

	private Map<String, Resource> resources = new HashMap<String, Resource>();
	private Map<String, Resource> baskets = new HashMap<String, Resource>();
	private Map<String, UseCase> useCases = new HashMap<String, UseCase>();
	
	private List<MenuDto> menuBasket = new ArrayList<MenuDto>();
	private List<MenuDto> menuResource = new ArrayList<MenuDto>();
	
	private List<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
	private Resource resource;
	private Map<String, Object> data = new HashMap<String, Object>();
	private int code = 0;
	@JsonIgnore
	private String srcCode = null;
	
	/**
	 * 
	 */
	public ResponseResource() {
		super();
	}
	
	/**
	 * 
	 * @param resources
	 * @param baskets
	 * @param resource
	 */
	public ResponseResource(Map<String, Resource> resources, Map<String, Resource> baskets, Resource resource) {
		super();
		this.resources = resources;
		this.baskets = baskets;
		this.resource = resource;
	}

	/**
	 * 
	 * @param errorMessages
	 */
	public ResponseResource(List<ErrorMessage> errorMessages) {
		super();
		this.errorMessages = errorMessages;
	}
	
	/**
	 * 
	 * @param form
	 */
	public ResponseResource(Resource resource) {
		super();
		this.resource = resource;
	}
	
	/**
	 * @return the forma
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * @param forma the forma to set
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @return the dato
	 */
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	/**
	 * @return the formas
	 */
	public Map<String, Resource> getResources() {
		return resources;
	}

	/**
	 * @param formas the formas to set
	 */
	public void setResources(Map<String, Resource> resources) {
		this.resources = resources;
	}

	/**
	 * @return the errorMessages
	 */
	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * @param errorMessages the errorMessages to set
	 */
	public void setErrorMessages(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}

	/**
	 * @return the canastas
	 */
	public Map<String, Resource> getBaskets() {
		return baskets;
	}

	/**
	 * @param canastas the canastas to set
	 */
	public void setBaskets(Map<String, Resource> baskets) {
		this.baskets = baskets;
	}

	/**
	 * @return the menuBasket
	 */
	public List<MenuDto> getMenuBasket() {
		return menuBasket;
	}

	/**
	 * @param menuBasket the menuBasket to set
	 */
	public void setMenuBasket(List<MenuDto> menuBasket) {
		this.menuBasket = menuBasket;
	}

	/**
	 * @return the menuResource
	 */
	public List<MenuDto> getMenuResource() {
		return menuResource;
	}

	/**
	 * @param menuForm the menuResource to set
	 */
	public void setMenuForm(List<MenuDto> menuResource) {
		this.menuResource = menuResource;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the srcCode
	 */
	public String getSrcCode() {
		return srcCode;
	}

	/**
	 * @param srcCode the srcCode to set
	 */
	public void setSrcCode(String srcCode) {
		this.srcCode = srcCode;
	}

	public Map<String, UseCase> getUseCases() {
		return useCases;
	}

	public void setUseCases(Map<String, UseCase> useCases) {
		this.useCases = useCases;
	}
	
}
