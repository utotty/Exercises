package data;

import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class DbManager extends DataManager {
	private static final DbManager INSTANCE = new DbManager();
	private static final String DB_PROPERTY = "C:\\Users\\t-nakamura\\git\\Exercises\\UToSample4\\db.properties";
	private Properties prop = null;
	private Connection conn = null;
	
	private DbManager() {}
	
	public static DataManager getInstance() {
		INSTANCE.init();
		return INSTANCE;
	}
	
	private void init() {
		try {
			this.prop = new Properties();
			FileReader r = new FileReader(DB_PROPERTY);
			prop.load(r);
			
			r.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String text) {
		
		
		
		
		
		
		
		
		
		System.out.println("DB : insert");
	}

	public void update(String text) {
		
	}

	public void delete() {
		
	}

	public void sortInsert() {
		
	}

	public void sortIndex() {
		
	}

	public void out() {
		
	}
}
