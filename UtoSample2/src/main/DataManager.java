package main;

import java.util.ArrayList;

public class DataManager {
	public ArrayList<Integer> getData(int type) {
		// TODO ArrayListは、具象クラスになります。抽象的に出来る場合は、しましょう。メリットがありので。。たとえば順番を保障したくなったら、、、とかですね。
		ArrayList<Integer> dataList = new ArrayList<Integer>();

		// TODO getDataというインタフェースが用意されていれば、dataList = fm.getData();の行が1行で出来ると思います。行を減らす事 = バグ・変更に強くなります
		// 生成するインスタンスを分岐
		if (type == 0) {
			FileManager fm = FileManager.getInstance();
			dataList = fm.getData();
		} else {
			DBManager dm = DBManager.getInstance();
			dataList = dm.getData();
		}

		return dataList;
	}
}
