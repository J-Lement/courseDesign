package util;

import java.text.ParseException;
import java.util.Date;

public class DateUtil {

	public static String GetTodayStr() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = new java.util.Date();
		
		return sdf.format(today);
	}
	
	public static Date GetDate(String str) throws ParseException {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		return (Date) sdf.parse(str);
	}
}
