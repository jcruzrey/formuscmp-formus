/**
 * 
 */
package com.formuscmp.formus.resource;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author jcruzrey
 *
 */

@JsonTypeName("Resource")
public class Resource extends AbstractResource implements Cloneable{
	
	public Resource () {
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Object clone() throws CloneNotSupportedException
    {
		Resource f = (Resource)super.clone();
        return f;
    }
}
