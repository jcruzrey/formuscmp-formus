/**
 * 
 */
package com.formuscmp.formus.field;

import com.fasterxml.jackson.annotation.JsonTypeName;
/**
 * @author mac
 *
 */
@JsonTypeName("Field")
public class Field extends AbstractField implements Cloneable{

	
	public Field () {
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2461804419288417170L;
	

	
	public Field clone() throws CloneNotSupportedException
    {
		Field f = (Field)super.clone();
        return f;
    }

}
