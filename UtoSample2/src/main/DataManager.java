package main;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	public List<Integer> getData(int type) {
		List<Integer> dataList = new ArrayList<Integer>();
		return createResourceManager(type).getData();
	}
	
	private ResourceManager createResourceManager(int type) {
		if (type == 0) {
			return FileManager.getInstance();
		}
		return DBManager.getInstance();
	}
}
