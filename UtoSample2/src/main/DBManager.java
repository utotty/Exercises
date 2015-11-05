package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class DBManager {
	private static final DBManager instance = new DBManager();
	private Connection conn         = null;
	
	// TODO newされる事がないから間違いではありませんが、staticの方が良いと思います。メモリ上の話になりますが。。。
	private final String datasource = "jdbc:mysql://localhost/utosample";
	private final String user       = "sample";
	private final String password   = "sample";

	private ArrayList<Integer> dbValues = null;

	private DBManager() {}

	public static DBManager getInstance() {
		return instance;
	}

	public ArrayList<Integer> getData() {
		if (dbValues != null) {
			return dbValues;
		}

		ArrayList<Integer> dbValues = new ArrayList<Integer>();

		try {
			// TODO thisを付けるなら、、、、統一した方が良いですね。。。
			// DB切断が、Exception発生時に出来ていませんね。
			// DBからデータ参照
			this.conn = DriverManager.getConnection(this.datasource, this.user, this.password);

			// クエリ（昇順ソート）
			String sql = "SELECT text FROM sortTable";

			// クエリの実行
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// 参照結果の格納
			while (rs.next()) {
				dbValues.add(Integer.parseInt(rs.getString("text")));
			}

			// DB切断
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ArrayList内容をソート
		Collections.sort(dbValues);
		Collections.reverse(dbValues);

		return dbValues;
	}
}
