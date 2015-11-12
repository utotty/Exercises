package data;

public enum CommandEnum {

	INSERT("insert"), UPDATE("update"), DELETE("delete"), SORT_INSERT("sort_insert"), SORT_INDEX("sort_index"), OUT("out");

	private String command;

	private CommandEnum(String command) {
		this.command = command;
	}

	public static CommandEnum getCommandEnum(String command) {
		for (CommandEnum row : CommandEnum.values()) {
			if (row.getCommand().equals(command)) {
				return row;
			}
		}
		return null;
	}

	public String getCommand() {
		return command;
	}
}
