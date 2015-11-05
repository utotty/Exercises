package main;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		// -------------------------------------------------------
		// getData type = 0 : file, type = 1 : DB
		// -------------------------------------------------------
		DataManager dm = new DataManager();

		// file
		List<Integer> fileValues = dm.getData(0);

		// ファイルの内容を出力
		System.out.println("<FILE>");
		for (Integer i : fileValues) {
			System.out.println(i);
		}

		// DB
		List<Integer> dbValues = dm.getData(1);

		// DBの参照結果を出力
		System.out.println("\n<DB>");
		for (Integer i : dbValues) {
			System.out.println(i);
		}
	}
}
