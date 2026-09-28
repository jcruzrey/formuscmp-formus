/**
 * 
 */
package com.formuscmp.formus.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formuscmp.common.exception.ErrorMessage;

/**
 * @author mac
 *
 */
public class RespuestaComando {
	private List<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
	private Map<String, Object> dato = new HashMap<String, Object>();
	
	public RespuestaComando() {
		super();
	}
	
	public RespuestaComando(List<ErrorMessage> errorMessages) {
		super();
		this.errorMessages = errorMessages;
	}

	/**
	 * @return the dato
	 */
	public Map<String, Object> getDato() {
		return dato;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setDato(Map<String, Object> dato) {
		this.dato = dato;
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
	
}
