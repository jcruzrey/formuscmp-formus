/**
 * 
 */
package com.formuscmp.formus.adaptor;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author mac
 *
 */
@JsonTypeName("Adaptor")
public class ResourceAdaptor extends AbstractAdaptor implements Cloneable{

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
	public ResourceAdaptor(String uuid, String name, String method, String template, String connectionUuid, String uri,
			String type, String resourceUuid, boolean useTemplate) {
		super(uuid, name, method, template, connectionUuid, uri, type, resourceUuid, useTemplate);
	}

	public ResourceAdaptor() {
		super();
	}

	public Object clone() throws CloneNotSupportedException
    {
		ResourceAdaptor f = (ResourceAdaptor)super.clone();
        return f;
    }

}
