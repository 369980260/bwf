package com.bwf.learning;

public class Demo8 {
	public static void main(String[] args) {
		String str = "a,b,,,,f";
		String[] strs = str.split(",");
		System.out.println(strs[2].equals(""));
	}
}
