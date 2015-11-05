package main;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	public List<Integer> getData(int type) {
		// TODO ArrayListは、具象クラスになります。抽象的に出来る場合は、しましょう。メリットがありので。。たとえば順番を保障したくなったら、、、とかですね。
		List<Integer> dataList = new ArrayList<Integer>();

		// TODO getDataというインタフェースが用意されていれば、dataList = fm.getData();の行が1行で出来ると思います。行を減らす事 = バグ・変更に強くなります
		// 生成するインスタンスを分岐
		if (type == 0) {
			dataList = FileManager.getInstance().getData();
		} else {
			dataList = DBManager.getInstance().getData();
		}

		return dataList;
	}
}
