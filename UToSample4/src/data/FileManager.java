package data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileManager extends DataManager {
	private static final FileManager INSTANCE = new FileManager();
	private static final String FILE_PROPERTY = "C:\\Users\\t-nakamura\\git\\Exercises\\UToSample4\\file.properties";
	private Properties prop = null;
	
	private FileManager() {}
	
	public static DataManager getInstance() {
		INSTANCE.init();
		return INSTANCE;
	}
	
	private void init() {
		try {
			this.prop = new Properties();
			FileReader r = new FileReader(FILE_PROPERTY);
			prop.load(r);
			
			r.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(String text) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(this.prop.getProperty("outputPath"), true);
			fw.write(text + "\n");
			
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(String text) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(this.prop.getProperty("outputPath"), false);
			fw.write(text + "\n");
			
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete() {
		try {
			File file = new File(this.prop.getProperty("outputPath"));
			if (file.exists()) {
			    file.delete();
			} else {
			    System.out.println("ファイルが存在しません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortInsert() {
		
	}

	public void sortIndex() {
		
	}

	public void out() {
		
	}
}
