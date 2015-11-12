package main;

import java.lang.reflect.Method;

import convertstring.ConvertString;
import data.CommandEnum;
import data.DataManager;
import data.TypeEnum;

public class OperateData {
	private static int execType;
	private static String execCommand = null;
	private static String execText    = null;
	
	public static void operate(int type, String command, String text) {
		execType    = type;
		execCommand = command;
		execText    = text;
		exec(true);
	}
	
	public static void operate(int type, String command) {
		execType    = type;
		execCommand = command;
		exec(false);
	}
	
	private static void exec(boolean arg) {
		TypeEnum te = TypeEnum.getTypeEnum(execType);
		if (te != null) {
			CommandEnum ce = CommandEnum.getCommandEnum(execCommand);
			if (ce != null) {
				// メソッド名作成
				String methodName = ConvertString.convertSnakeToCamel(execCommand);
				
				// 該当リソースのインスタンス作成
				String className = ConvertString.convertUpperFirst(te.toString());
				
				try {
					Class<?> clazz = Class.forName("data." + className + "Manager");
					Method method = clazz.getMethod("getInstance");
					DataManager dm = (DataManager) method.invoke(null);
					
					if (arg) {
						Method methodCommand  = dm.getClass().getMethod(methodName, String.class);
						methodCommand.invoke(dm, execText);
					} else {
						Method methodCommand  = dm.getClass().getMethod(methodName);
						methodCommand.invoke(dm);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("コマンドが存在しません[" + execCommand + "]");
			}
		} else {
			System.out.println("データタイプが存在しません[" + execType + "]");
		}
	}
}
