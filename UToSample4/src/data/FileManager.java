package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import date.DateFormat;

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
			this.prop.load(r);
			
			r.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(String text) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(this.prop.getProperty("outputPath"), true);
			fw.write(text + "," + DateFormat.getNowDateStr() + "\n");
			
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
			fw.write(text + "," + DateFormat.getNowDateStr() + "\n");
			
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
		// ファイルの有無をチェック
		File f = new File(this.prop.getProperty("outputPath"));
		try {
			if (f.exists()) {
				FileReader fr     = null;
				BufferedReader br = null;
				List<RowData> data = new ArrayList<RowData>();
				try {
					// ファイル読み込み
					fr = new FileReader(this.prop.getProperty("outputPath"));
					br = new BufferedReader(fr);

					String line;
					while ((line = br.readLine()) != null) {
						String[] row = line.split(",");
						RowData rd = new RowData(Integer.parseInt(row[0]), row[1], row[2]);
						data.add(rd);
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
				
				// ファイルの内容をソート
				if (this.prop.getProperty("sort").equals("ASC")) {
					Collections.sort(data, new Comparator<RowData>() {
						public int compare(RowData rd1, RowData rd2) {
							return rd1.getRegisteredDate().compareTo(rd2.getRegisteredDate());
						}
					});
				} else {
					Collections.sort(data, new Comparator<RowData>() {
						public int compare(RowData rd1, RowData rd2) {
							return rd2.getRegisteredDate().compareTo(rd1.getRegisteredDate());
						}
					});
				}
				
				// ソート後の内容を出力
				for (RowData d : data) {
					System.out.println("[ID] " + d.getID() + " [NAME] " + d.getName() + " [DATE] " + d.getRegisteredDate());
				}
				
			} else {
				System.out.println("ファイルが存在しません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortIndex() {
		// ファイルの有無をチェック
		File f = new File(this.prop.getProperty("outputPath"));
		try {
			if (f.exists()) {
				FileReader fr     = null;
				BufferedReader br = null;
				List<RowData> data = new ArrayList<RowData>();
				try {
					// ファイル読み込み
					fr = new FileReader(this.prop.getProperty("outputPath"));
					br = new BufferedReader(fr);

					String line;
					while ((line = br.readLine()) != null) {
						String[] row = line.split(",");
						RowData rd = new RowData(Integer.parseInt(row[0]), row[1], row[2]);
						data.add(rd);
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
				
				// ファイルの内容をソート
				if (this.prop.getProperty("sort").equals("ASC")) {
					Collections.sort(data, new Comparator<RowData>() {
						public int compare(RowData rd1, RowData rd2) {
							return rd1.getID() - rd2.getID();
						}
					});
				} else {
					Collections.sort(data, new Comparator<RowData>() {
						public int compare(RowData rd1, RowData rd2) {
							return rd2.getID() - rd1.getID();
						}
					});
				}
				
				// ソート後の内容を出力
				for (RowData d : data) {
					System.out.println("[ID] " + d.getID() + " [NAME] " + d.getName() + " [DATE] " + d.getRegisteredDate());
				}
				
			} else {
				System.out.println("ファイルが存在しません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void out() {
		// ファイルの有無をチェック
		File f = new File(this.prop.getProperty("outputPath"));
		try {
			if (f.exists()) {
				FileReader fr     = null;
				BufferedReader br = null;
				List<RowData> data = new ArrayList<RowData>();
				try {
					// ファイル読み込み
					fr = new FileReader(this.prop.getProperty("outputPath"));
					br = new BufferedReader(fr);

					String line;
					while ((line = br.readLine()) != null) {
						String[] row = line.split(",");
						RowData rd = new RowData(Integer.parseInt(row[0]), row[1], row[2]);
						data.add(rd);
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
				
				// ソート後の内容を出力
				for (RowData d : data) {
					System.out.println(d.getID() + "," + d.getName() + "," + d.getRegisteredDate());
				}
			} else {
				System.out.println("ファイルが存在しません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
