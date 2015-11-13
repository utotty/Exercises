package main;

public class Main {
	public static void main(String[] args) {
		// ---------------
		//      FILE
		// ---------------
		OperateData.operate(1, "insert", "1,山田太郎");
		OperateData.operate(1, "update", "2,木村一");
		// OperateData.operate(1, "delete");
		// OperateData.operate(1, "sort_insert");
		// OperateData.operate(1, "sort_index");
		// OperateData.operate(1, "out");
		
		
		// ---------------
		//       DB
		// ---------------
		OperateData.operate(2, "insert", "1,山田太郎");
		OperateData.operate(2, "update", "2,木村一");
		// OperateData.operate(2, "delete");
		// OperateData.operate(2, "sort_insert");
		// OperateData.operate(2, "sort_index");
		// OperateData.operate(2, "out");
	}
}
