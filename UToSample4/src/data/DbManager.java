package data;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import date.DateFormat;

public class DbManager extends DataManager {
	private static final DbManager INSTANCE = new DbManager();
	private static final String DB_PROPERTY = "C:\\Users\\t-nakamura\\git\\Exercises\\UToSample4\\db.properties";
	private Properties prop = null;
	
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
		Connection conn               = null;
		PreparedStatement checkPstmt  = null;
		ResultSet rs                  = null;
		PreparedStatement insertPstmt = null;
		try {
			conn = DriverManager.getConnection(this.prop.getProperty("host"), this.prop.getProperty("user"), this.prop.getProperty("password"));
			
			String[] txt = text.split(",");
			
			// データが存在するかチェック
			String checkSql = "SELECT COUNT(id) AS count FROM sample4 WHERE id=?";
			checkPstmt      = conn.prepareStatement(checkSql);
			checkPstmt.setInt(1, Integer.parseInt(txt[0]));
			rs = checkPstmt.executeQuery();
			rs.next();
			if (rs.getInt("count") == 0) {
				String insertSql = "INSERT INTO sample4(id,name) VALUES(?, ?)";
				insertPstmt      = conn.prepareStatement(insertSql);
				insertPstmt.setInt(1, Integer.parseInt(txt[0]));
				insertPstmt.setString(2, txt[1]);
				
				// クエリ実行
				insertPstmt.executeUpdate();
			} else {
				System.out.println("該当のIDはすでに存在しています。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (insertPstmt != null) {
					insertPstmt.close();
				}

				if (checkPstmt != null) {
					checkPstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(String text) {
		Connection conn               = null;
		PreparedStatement checkPstmt  = null;
		ResultSet rs                  = null;
		PreparedStatement updatePstmt = null;
		try {
			conn = DriverManager.getConnection(this.prop.getProperty("host"), this.prop.getProperty("user"), this.prop.getProperty("password"));
			
			String[] txt = text.split(",");
			
			// データが存在するかチェック
			String checkSql = "SELECT COUNT(id) AS count FROM sample4 WHERE id=?";
			checkPstmt      = conn.prepareStatement(checkSql);
			checkPstmt.setInt(1, Integer.parseInt(txt[0]));
			rs = checkPstmt.executeQuery();
			rs.next();
			if (rs.getInt("count") > 0) {
				String updateSql = "UPDATE sample4 SET name=?,stamp=NOW() WHERE id=?";
				updatePstmt      = conn.prepareStatement(updateSql);
				updatePstmt.setString(1, txt[1]);
				updatePstmt.setInt(2, Integer.parseInt(txt[0]));
				
				// クエリ実行
				updatePstmt.executeUpdate();
			} else {
				System.out.println("該当のIDが存在しません。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (updatePstmt != null) {
					updatePstmt.close();
				}

				if (checkPstmt != null) {
					checkPstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete() {
		Connection conn         = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(this.prop.getProperty("host"), this.prop.getProperty("user"), this.prop.getProperty("password"));
			
			String sql = "TRUNCATE TABLE sample4";
			pstmt= conn.prepareStatement(sql);
			
			// クエリ実行
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void sortInsert() {
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		try {
			conn = DriverManager.getConnection(this.prop.getProperty("host"), this.prop.getProperty("user"), this.prop.getProperty("password"));
			
			String sql = "SELECT * FROM sample4 ORDER BY stamp ASC";
			pstmt= conn.prepareStatement(sql);
			
			// クエリ実行
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("[ID] " + rs.getInt("id") + " [NAME] " + rs.getString("name") + " [STAMP] " + DateFormat.getDateStr(rs.getTimestamp("stamp").getTime()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void sortIndex() {
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		try {
			conn = DriverManager.getConnection(this.prop.getProperty("host"), this.prop.getProperty("user"), this.prop.getProperty("password"));
			
			String sql = "SELECT * FROM sample4 ORDER BY id " + this.prop.getProperty("sort");
			pstmt= conn.prepareStatement(sql);
			
			// クエリ実行
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("[ID] " + rs.getInt("id") + " [NAME] " + rs.getString("name") + " [STAMP] " + DateFormat.getDateStr(rs.getTimestamp("stamp").getTime()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void out() {
		Connection conn         = null;
		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		try {
			conn = DriverManager.getConnection(this.prop.getProperty("host"), this.prop.getProperty("user"), this.prop.getProperty("password"));
			
			String sql = "SELECT * FROM sample4";;
			pstmt= conn.prepareStatement(sql);
			
			// クエリ実行
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "," + rs.getString("name") + "," + DateFormat.getDateStr(rs.getTimestamp("stamp").getTime()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
