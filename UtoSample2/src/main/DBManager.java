package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBManager implements ResourceManager {
	private static final DBManager instance = new DBManager();
	private Connection conn         = null;
	private static final String datasource = "jdbc:mysql://localhost/utosample";
	private static final String user       = "sample";
	private static final String password   = "sample";

	private List<Integer> dbValues = null;

	private DBManager() {}

	public static DBManager getInstance() {
		return instance;
	}

	public List<Integer> getData() {
		if (dbValues != null) {
			return dbValues;
		}

		List<Integer> dbValues = new ArrayList<Integer>();

		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		try {
			// DBからデータ参照
			conn = DriverManager.getConnection(datasource, user, password);

			// クエリ（昇順ソート）
			String sql = "SELECT text FROM sortTable";

			// クエリの実行
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			// 参照結果の格納
			while (rs.next()) {
				dbValues.add(Integer.parseInt(rs.getString("text")));
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

		// ArrayList内容をソート
		Collections.sort(dbValues);
		Collections.reverse(dbValues);

		return dbValues;
	}
}
