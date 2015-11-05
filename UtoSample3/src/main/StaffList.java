package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StaffList {
	private static final StaffList instance = new StaffList();
	private final String FILEPATH = "C:\\Users\\t-nakamura\\git\\Exercises\\UtoSample3\\file\\StaffList.csv";
	private StaffList() {}

	public static StaffList getInstance() {
		return instance;
	}

	public Map<String, Integer> getStaffList() {
		Map<String, Integer> fileValues = new HashMap<String, Integer>();

		FileReader fr     = null;
		BufferedReader br = null;
		try {
			// ファイル読み込み
			fr = new FileReader(FILEPATH);
			br = new BufferedReader(fr);

			String line;
			StringTokenizer token;
			while ((line = br.readLine()) != null) {
				token = new StringTokenizer(line, ",");

				while (token.hasMoreTokens()) {
					// TODO CSVの行の内容をMapに格納？
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
