package main;

import java.util.ArrayList;

public class DataManager {
	public ArrayList<Integer> getData(int type) {
		ArrayList<Integer> dataList = new ArrayList<Integer>();

		// 生成するインスタンスを分岐
		if (type == 0) {
			FileManager fm = FileManager.getInstance();
			dataList = fm.getData();
		} else {
			DBManager dm = DBManager.getInstance();
			dataList = dm.getData();
		}

		return dataList;
	}
}
