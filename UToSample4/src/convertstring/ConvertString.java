package convertstring;

public class ConvertString {
	public static String convertSnakeToCamel(String str) {
		StringBuffer sb = new StringBuffer(str.toLowerCase());
		int idx = 0;
		try {
			while ((idx = sb.indexOf("_")) > 0) {
				 char c = sb.charAt(idx + 1);
				 c = Character.toUpperCase(c);
				 sb.setCharAt(idx + 1, c);
				 sb.deleteCharAt(idx);
			}
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
			
		return sb.toString();
	}
	
	public static String convertUpperFirst(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
}
