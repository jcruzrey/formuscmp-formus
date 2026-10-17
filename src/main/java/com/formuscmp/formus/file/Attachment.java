package com.formuscmp.formus.file;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Reference to a file held by the file store. Commands never receive file bytes: they receive an {@code Attachment} and open the file through
 * {@link FileStores#get()}. A command that wants the caller to download a file puts one in {@code ResponseResource.attachment}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment {

	/** Name of the form field (multipart part) the file came with; null for a download. */
	private String field;
	private String filename;
	private String contentType;
	private long size;
	private String sha256;
	/** Opaque id in the file store. */
	private String storageId;
	/** In a download: true when the file was made only to be sent, so the server deletes it from the store once it has been sent. */
	private Boolean temporary;

	public Boolean getTemporary() { return temporary; }
	public void setTemporary(Boolean temporary) { this.temporary = temporary; }

	public Attachment() {
		super();
	}

	public Attachment(String field, String filename, String contentType, long size, String sha256, String storageId) {
		this.field = field;
		this.filename = filename;
		this.contentType = contentType;
		this.size = size;
		this.sha256 = sha256;
		this.storageId = storageId;
	}

	public String getField() { return field; }
	public void setField(String field) { this.field = field; }
	public String getFilename() { return filename; }
	public void setFilename(String filename) { this.filename = filename; }
	public String getContentType() { return contentType; }
	public void setContentType(String contentType) { this.contentType = contentType; }
	public long getSize() { return size; }
	public void setSize(long size) { this.size = size; }
	public String getSha256() { return sha256; }
	public void setSha256(String sha256) { this.sha256 = sha256; }
	public String getStorageId() { return storageId; }
	public void setStorageId(String storageId) { this.storageId = storageId; }

	@Override
	public String toString() {
		return "Attachment [field=" + field + ", filename=" + filename + ", contentType=" + contentType + ", size=" + size
				+ ", storageId=" + storageId + "]";
	}
}
