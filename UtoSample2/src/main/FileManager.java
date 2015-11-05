package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileManager {
	private static final FileManager instance = new FileManager();
	// TODO newされる事がないから間違いではありませんが、staticの方が良いと思います。メモリ上の話になりますが。。。
	private final String filePath = "C:\\Users\\t-nakamura\\pleiades\\workspace-pleiades\\UtoSample2\\file\\sample.csv";
	private ArrayList<Integer> fileValues = null;

	private FileManager() {}

	public static FileManager getInstance() {
		return instance;
	}

	// TODO ArrayListは具象クラスです。。。DataManagerのコメントを参考に、、、、
	public ArrayList<Integer> getData() {
		if (fileValues != null) {
			return fileValues;
		}

		ArrayList<Integer> fileValues = new ArrayList<Integer>();

		// TODO Exception発生時に、各種ReaderがCloseしていません
		try {
			// ファイル読み込み
			FileReader fr     = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				fileValues.add(Integer.parseInt(line));
			}

			// 終了
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ArrayListの内容をソート
		Collections.sort(fileValues);
		Collections.reverse(fileValues);

		return fileValues;
	}
}
