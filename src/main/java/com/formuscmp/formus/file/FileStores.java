package com.formuscmp.formus.file;

/** Process-wide access to the {@link FileStore}, set once by the server at startup, so a command can open an {@link Attachment}. */
public final class FileStores {

	private static volatile FileStore store;

	private FileStores() { }

	public static FileStore get() { return store; }

	public static void set(FileStore fileStore) { store = fileStore; }
}
