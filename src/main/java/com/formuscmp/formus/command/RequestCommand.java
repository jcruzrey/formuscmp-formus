/**
 * 
 */
package com.formuscmp.formus.command;

import com.formuscmp.common.command.ComandoVO;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author mac
 *
 */
@XmlRootElement
public class RequestCommand {
	private ComandoVO command;

	/**
	 * @return the command
	 */
	public ComandoVO getComando() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setComando(ComandoVO command) {
		this.command = command;
	}
}
