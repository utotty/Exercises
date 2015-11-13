package data;

public class RowData {
	private int id;
	private String name;
	private String registeredDate;
	
	public RowData(int id, String name, String registeredDate) {
		this.id = id;
		this.name = name;
		this.registeredDate = registeredDate;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRegisteredDate() {
		return this.registeredDate;
	}
}
