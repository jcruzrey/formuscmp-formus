/**
 * 
 */
package com.formuscmp.formus.resource;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Jose Luis Cruz Reyes - Formus CMP
 *
 */
@JsonTypeName("Step")
public class Step {
	private String name;
	private String Obs;
	private int order;
	private Set<String> resources = new HashSet<String>();
	private String status;
	private String nextStatus;
	private String actualStatus;
	private String executor;
	private Set<String> owners = new HashSet<String>();
	private Long lastUpdateDate = 0L;
	private Long lastExecutionDate = 0L;
	private String instruction;
	private String prefix;
	private String alias;
	private String uuid;
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
	 * @return the obs
	 */
	public String getObs() {
		return Obs;
	}
	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		Obs = obs;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the executor
	 */
	public String getExecutor() {
		return executor;
	}
	/**
	 * @param executor the executor to set
	 */
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	/**
	 * @return the owners
	 */
	public Set<String> getOwners() {
		return owners;
	}
	/**
	 * @param owners the owners to set
	 */
	public void setOwners(Set<String> owners) {
		this.owners = owners;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public Long getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Long lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the lastExecutionDate
	 */
	public Long getLastExecutionDate() {
		return lastExecutionDate;
	}
	/**
	 * @param lastExecutionDate the lastExecutionDate to set
	 */
	public void setLastExecutionDate(Long lastExecutionDate) {
		this.lastExecutionDate = lastExecutionDate;
	}
	/**
	 * @return the nextStatus
	 */
	public String getNextStatus() {
		return nextStatus;
	}
	/**
	 * @param nextStatus the nextStatus to set
	 */
	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}
	/**
	 * @return the resources
	 */
	public Set<String> getResources() {
		return resources;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(Set<String> resources) {
		this.resources = resources;
	}
	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getActualStatus() {
		return actualStatus;
	}
	public void setActualStatus(String actualStatus) {
		this.actualStatus = actualStatus;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "Step [name=" + name + ", Obs=" + Obs + ", order=" + order + ", resources=" + resources + ", status="
				+ status + ", nextStatus=" + nextStatus + ", actualStatus=" + actualStatus + ", executor=" + executor
				+ ", owners=" + owners + ", lastUpdateDate=" + lastUpdateDate + ", lastExecutionDate="
				+ lastExecutionDate + ", instruction=" + instruction + ", prefix=" + prefix + ", alias=" + alias
				+ ", uuid=" + uuid + "]";
	}
	
	
}
