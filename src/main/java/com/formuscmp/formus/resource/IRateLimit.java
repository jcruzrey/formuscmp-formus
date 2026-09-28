/**
 * 
 */
package com.formuscmp.formus.resource;

/**
 * @author mac
 *
 */
public interface IRateLimit {
	 Long seconds = 0L;
	 Long requestsPerSeconds = 0L;
	 Long currentStartTime = 0L;
	 Long nextStartTime = 0L;
}
