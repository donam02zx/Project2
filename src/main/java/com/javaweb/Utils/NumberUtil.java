package com.javaweb.Utils;

public class NumberUtil {
	public static boolean isNumber(String data) {
		try {
			Long number = Long.parseLong(data);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
