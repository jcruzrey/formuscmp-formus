/**
 * 
 */
package com.formuscmp.formus.regex;

/**
 * @author mac
 *
 */
public class ValidaRegex extends AbstractRegex{

	public ValidaRegex(String uuid, String nombre, String namespace, String valor, String path) {
		super(uuid, nombre, namespace, valor, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ValidaRegex [getUuid()=" + getUuid() + ", getNombre()=" + getNombre() + ", getNamespace()="
				+ getNamespace() + ", getValor()=" + getValor() + ", getPath()=" + getPath() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
