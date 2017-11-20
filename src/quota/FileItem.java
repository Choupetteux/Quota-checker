package quota;

public class FileItem {

	private String name;
	private int size;
	
	
	/**
	 * @param name
	 * @param size
	 */
	public FileItem(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString(){
		return "[" + this.size + " Mio] " + this.name; 
	}
	
}
