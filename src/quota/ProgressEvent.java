package quota;

public class ProgressEvent {
	
	public Long totalSize;
	private final FileItem fileItem;
	
	/**
	 * @param totalSize
	 */
	public ProgressEvent(long totalSize, FileItem fileItem) {
		super();
		this.totalSize = totalSize;
		this.fileItem = fileItem;
	}
	
	/**
	 * @return the totalSize
	 */
	public long getTotalSize() {
		return totalSize;
	}

	/**
	 * @return the fileItem
	 */
	public FileItem getFileItem() {
		return fileItem;
	}
	
	


}
