package com.formuscmp.formus.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/** Where uploaded and generated files live. The servlet saves into it, commands and the download path read from it. */
public interface FileStore {

	/**
	 * Streams {@code in} into the store (never buffering it in memory) and returns its reference.
	 *
	 * @param owner the user that uploaded it (may be null)
	 * @throws IOException on I/O failure or when more than {@code maxBytes} are read
	 */
	Attachment save(String field, String filename, String contentType, String owner, InputStream in, long maxBytes) throws IOException;

	/** The stored file's reference, or null when the id is unknown. The id is validated: anything but a store-issued id returns null. */
	Attachment find(String storageId) throws IOException;

	/** The stored bytes' location, or null when the id is unknown. */
	Path path(String storageId) throws IOException;

	/** Removes a file; false when it did not exist. */
	boolean delete(String storageId) throws IOException;
}
