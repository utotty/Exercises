package main;

import java.util.ArrayList;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		// CSVファイルから社員リストの取得
		Map<String, ArrayList<String>> staffList = StaffList.getInstance().getCsv();

		// 役職毎のインスタンス作成
		Handler hira   = null;
		Handler kacho  = null;
		Handler shacho = null;
		for (String key : staffList.keySet()) {
			ArrayList<String> names = staffList.get(key);
			// System.out.println("[ " + key + " ]");
			String nameStr = "";
			for (String s : names) {
				if (nameStr.length() != 0) {
					nameStr += " " + s;
				} else {
					nameStr = s;
				}
			}
			// System.out.println(nameStr);


			// 社員の種類分のインスタンスを生成
			if (key.equals("一般社員")) {
				hira = new Hira(nameStr);
				continue;
			} else if (key.equals("課長")) {
				kacho = new Kacho(nameStr);
				continue;
			} else if (key.equals("社長")) {
				shacho = new Shacho(nameStr);
				continue;
			}
		}

		hira.setNext(kacho).setNext(shacho);
		hira.request("一般社員");
		System.out.println("");
		hira.request("課長");
		System.out.println("");
		hira.request("社長");
	}
}
