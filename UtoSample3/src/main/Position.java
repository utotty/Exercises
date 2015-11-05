package main;

import java.util.HashMap;
import java.util.Map;

public class Position {
	private static final int MAXLEVEL = 3;
	private Map<String, Integer> positionList = new HashMap<String, Integer>();

	public Position() {
		// 初期値をセット
		this.positionList.put("社長", 3);
		this.positionList.put("課長", 2);
		this.positionList.put("一般社員", 1);
	}

	public Map<String, Integer> getPositionList() {
		return positionList;
	}

	public Integer getPosition(String position) {
		return positionList.get(position);
	}

	public Integer getMaxLevel() {
		return MAXLEVEL;
	}
}
