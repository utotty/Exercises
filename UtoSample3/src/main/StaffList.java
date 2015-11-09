package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StaffList {
	private static final StaffList instance = new StaffList();
	private final String filePath = "C:\\Users\\t-nakamura\\git\\Exercises\\UtoSample3\\file\\StaffList.csv";

	private StaffList() {}

	public static StaffList getInstance() {
		return instance;
	}

	public Map<String, ArrayList<String>> getCsv() {
		Map<String, ArrayList<String>> fileValues = new HashMap<String, ArrayList<String>>();

		FileReader fr     = null;
		BufferedReader br = null;
		try {
			// ファイル読み込み
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] lineVal = line.split(",");
				if (fileValues.containsKey(lineVal[1])) {
					fileValues.get(lineVal[1]).add(lineVal[2]);
				} else {
					ArrayList<String> names = new ArrayList<String>();
					names.add(lineVal[2]);
					fileValues.put(lineVal[1], names);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return fileValues;
	}
}
