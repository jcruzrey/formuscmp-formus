/**
 * 
 */
package com.formuscmp.formus.adaptor;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @author Jose Luis Cruz Reyes - Formus CMP
 *
 */
@JsonTypeInfo(use=Id.NAME)
@JsonSubTypes({
	@JsonSubTypes.Type(value=ResourceAdaptor.class, name="Adaptor")
})
public class AbstractAdaptor {

	public AbstractAdaptor() {
		
	}

	/**
	 * @param uuid
	 * @param name
	 * @param method
	 * @param template
	 * @param connectionUuid
	 * @param uri
	 * @param type
	 * @param resourceUuid
	 * @param useTemplate
	 */
	public AbstractAdaptor(String uuid, String name, String method, String template, String connectionUuid, String uri,
			String type, String resourceUuid, boolean useTemplate) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.method = method;
		this.template = template;
		this.connectionUuid = connectionUuid;
		this.uri = uri;
		this.type = type;
		this.resourceUuid = resourceUuid;
		this.useTemplate = useTemplate;
	}

	public enum enumType {
		JSON("json"),
		SOAP("soap"),
		RPC("rpc");

		private String type;

		enumType(String type) {
			this.type = type;
		}

		public String getType(){
			return this.type;
		}
	}
	
	public enum enumMethod {
		POST("post"),
		PUT("put"),
		GET("get"),
		DELETE("delete");

		private String type;

		enumMethod(String type) {
			this.type = type;
		}

		public String getType(){
			return this.type;
		}
	}
	

	private String uuid;
	private String name;
	private String method;
	private String template;
	private String connectionUuid;
	private String uri;
	private String type;
	private String resourceUuid;
	private boolean useTemplate;

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
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
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
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Indicates if object or template will be the body of the call
	 * @return the useTemplate
	 */
	public boolean isUseTemplate() {
		return useTemplate;
	}

	/**
	 * @param useTemplate the useTemplate to set
	 */
	public void setUseTemplate(boolean useTemplate) {
		this.useTemplate = useTemplate;
	}

	/**
	 * Provide uuid of resource form with connection information
	 * @return the connectionUuid
	 */
	public String getConnectionUuid() {
		return connectionUuid;
	}

	/**
	 * @param connectionUuid the connectionUuid to set
	 */
	public void setConnectionUuid(String connectionUuid) {
		this.connectionUuid = connectionUuid;
	}

	/**
	 * Provides resource of type form of data to be submitted
	 * @return the resourceUuid
	 */
	public String getResourceUuid() {
		return resourceUuid;
	}

	/**
	 * @param resourceUuid the resourceUuid to set
	 */
	public void setResourceUuid(String resourceUuid) {
		this.resourceUuid = resourceUuid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(connectionUuid, method, name, resourceUuid, template, type, uri, useTemplate, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractAdaptor other = (AbstractAdaptor) obj;
		return Objects.equals(connectionUuid, other.connectionUuid) && Objects.equals(method, other.method)
				&& Objects.equals(name, other.name) && Objects.equals(resourceUuid, other.resourceUuid)
				&& Objects.equals(template, other.template) && Objects.equals(type, other.type)
				&& Objects.equals(uri, other.uri) && useTemplate == other.useTemplate
				&& Objects.equals(uuid, other.uuid);
	}

	@Override
	public String toString() {
		return "AbstractAdaptor [uuid=" + uuid + ", name=" + name + ", method=" + method + ", template=" + template
				+ ", connectionUuid=" + connectionUuid + ", uri=" + uri + ", type=" + type + ", resourceUuid="
				+ resourceUuid + ", useTemplate=" + useTemplate + "]";
	}
	
}
