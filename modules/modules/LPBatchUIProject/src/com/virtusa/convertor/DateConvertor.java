package com.virtusa.convertor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DateConvertor {
	public static LocalDate dateFormat(String DOB) {
		StringTokenizer tokens = new StringTokenizer(DOB,"/");
		List<String> list = new ArrayList<>();
		while(tokens.hasMoreTokens()) {
			list.add(tokens.nextToken());
		}
		int day=Integer.parseInt(list.get(0));
		int month = Integer.parseInt(list.get(1));
		int year = Integer.parseInt(list.get(2));
		LocalDate dob = LocalDate.of(year-1900, month-1, day);
		return dob;		
	}
}
