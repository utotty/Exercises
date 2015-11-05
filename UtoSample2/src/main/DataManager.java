package main;

import java.util.List;

public class DataManager {
	public List<Integer> getData(int type) {
		return createResourceManager(type).getData();
	}

	private ResourceManager createResourceManager(int type) {
		if (type == 0) {
			return FileManager.getInstance();
		}
		return DBManager.getInstance();
	}
}
