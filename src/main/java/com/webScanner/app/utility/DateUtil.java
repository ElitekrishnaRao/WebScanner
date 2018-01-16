package com.webScanner.app.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.CURRENT_DATE);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String date = sdf.format(timestamp);
		return date;
	}

	public static Timestamp StringToTimeStamp(String stringDate) {
		SimpleDateFormat sdf =new SimpleDateFormat(AppConstants.CURRENT_DATE);
		Date date =null;
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
		return timeStampDate;
	}
	
	public static String TimeStampToString(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.CURRENT_DATE);
		String date = sdf.format(timestamp);
		return date;
	}
	
	public static Timestamp QueryStringToTimeStamp(String stringDate) {
		SimpleDateFormat sdf =new SimpleDateFormat(AppConstants.INPUT_DATE);
		Date date =null;
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
		return timeStampDate;
	}

}
