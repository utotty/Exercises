package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager implements ResourceManager {
	private static final FileManager instance = new FileManager();

	private final String filePath = "C:\\Users\\t-nakamura\\git\\Exercises\\UtoSample2\\file\\sample.csv";
	private List<Integer> fileValues = null;

	private FileManager() {}

	public static FileManager getInstance() {
		return instance;
	}

	public List<Integer> getData() {
		if (fileValues != null) {
			return fileValues;
		}

		List<Integer> fileValues = new ArrayList<Integer>();

		FileReader fr     = null;
		BufferedReader br = null;
		try {
			// ファイル読み込み
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				fileValues.add(Integer.parseInt(line));
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

		// ArrayListの内容をソート
		Collections.sort(fileValues);
		Collections.reverse(fileValues);

		return fileValues;
	}
}
