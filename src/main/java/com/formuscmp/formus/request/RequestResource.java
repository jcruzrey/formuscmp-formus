/**
 * 
 */
package com.formuscmp.formus.request;

import java.util.HashMap;
import java.util.Map;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author mac
 *
 */
@XmlRootElement
public class RequestResource {

	private Map<String, Object> parameters = new HashMap<String, Object>();
	private String commandName;
	private Integer pageNumber;
	private Object payload;
	private String assetLibrary;
	private String module;
	private String version;
	private String resourceName;
	private String resourceType;
	private String view;
	private String format;
	private String baseUri;
	private String sessionId;
	private String locale;
	private String key;
	private String correlationId;
	private String token="Bearer ewrerewrwfdsf";
	private String origin;
	private String fingerPrint;
	private String uuid;
	private String puuid;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the llave
	 */
	public String getKey() {
		key = getAssetLibrary()+"."+getResourceType()+"."+getModule()+"."+getResourceName()+"."+getVersion()+(getUuid()==null ? "" : "." + getUuid());
		return key;
	}

	public RequestResource() {
		super();
	}
	
	public RequestResource(final Map<String, Object> parameters, final String commandName, final Integer pageNumber, 
			final String resourceType, final String correlationId, final String origin,
			final String fingerPrint) {
		super();
		this.parameters = parameters;
		this.commandName = commandName;
		this.pageNumber = pageNumber;
		this.resourceType = resourceType;
		this.correlationId = correlationId;
		this.origin = origin;
		this.fingerPrint = fingerPrint;
	}

	public RequestResource(final Map<String, Object> parameters, final String commandName, final String module, 
			final String version, final String resourceName, final String assetLibrary, final String resourceType, final String format,
			final String correlationId, final String origin, final String fingerPrint) {
		super();
		this.parameters = parameters;
		this.commandName = commandName;
		this.module = module;
		this.version = version;
		this.resourceName = resourceName;
		this.assetLibrary = assetLibrary;
		this.resourceType = resourceType;
		this.format = format;
		this.correlationId = correlationId;
		this.origin = origin;
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * @return the commandName
	 */
	public String getCommandName() {
		return commandName;
	}

	/**
	 * @param nombreAccion the nombreAccion to set
	 */
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	
	/**
	 * @return the parameters
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pagpageNumberina the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	/**
	 * 
	 * @return assetLibrary
	 */
	public String getAssetLibrary() {
		return assetLibrary;
	}

	public void setAssetLibrary(String assetLibrary) {
		this.assetLibrary = assetLibrary;
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

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/** 
	 * possible values are: api, form, basket
	 * 
	 * @return resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * 
	 * @param resourceType
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
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
	 * @return the format, can be html, ios, bxml or android
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set, can be html, ios, bxml or android
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the baseUri
	 */
	public String getBaseUri() {
		return baseUri;
	}

	/**
	 * @param baseUri the baseUri to set
	 */
	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}
	/**
	 * 
	 * @return sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * 
	 * @param sessionId
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
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
	 * @return the fingerPrint
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * @param fingerPrint the fingerPrint to set
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
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

	@Override
	public String toString() {
		return "RequestResource [parameters=" + parameters + ", commandName=" + commandName + ", pageNumber="
				+ pageNumber + ", payload=" + payload + ", assetLibrary=" + assetLibrary + ", module=" + module
				+ ", version=" + version + ", resourceName=" + resourceName + ", resourceType=" + resourceType
				+ ", view=" + view + ", format=" + format + ", baseUri=" + baseUri + ", sessionId=" + sessionId
				+ ", locale=" + locale + ", key=" + key + ", correlationId=" + correlationId + ", token=" + token
				+ ", origin=" + origin + ", fingerPrint=" + fingerPrint + ", uuid=" + uuid + "]";
	}

	/**
	 * @return the puuid
	 */
	public String getPuuid() {
		return puuid;
	}

	/**
	 * @param puuid the puuid to set
	 */
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	
	
}
