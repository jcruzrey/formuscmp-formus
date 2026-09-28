/**
 * 
 */
package com.formuscmp.formus.validator;

import java.util.regex.Pattern;

/**
 * @author mac
 *
 */
public class ValidadorRegex extends AbstractaValidador {

	@Override
	public boolean esValido(String valor, String regex) {
		return Pattern.compile(regex).matcher(valor).find();
	}


}
