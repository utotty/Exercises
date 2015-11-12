package data;

public enum TypeEnum {
	
	FILE(1), DB(2);
	
	private int type;
	
	private TypeEnum(int type) {
		this.type = type;
	}
	
	public static TypeEnum getTypeEnum(int type) {
		for (TypeEnum row : TypeEnum.values()) {
			if (row.getType() == type) {
				return row;
			}
		}
		return null;
	}
	
	public int getType() {
		return type;
	}
}
