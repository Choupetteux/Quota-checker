package quota;

public class ProgressEvent {
	/**
	 * @param totalSize
	 */
	public ProgressEvent(long totalSize) {
		super();
		this.totalSize = totalSize;
	}



	public long totalSize;

	/**
	 * @return the totalSize
	 */
	public long getTotalSize() {
		return totalSize;
	}
	
	


}
