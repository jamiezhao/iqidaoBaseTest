package iqidaoTest.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
	
	public static String DatetoString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	
	public static String setDays(int year, int month, int date, int hourOfDay, int minute){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, date, hourOfDay, minute);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calendar.getTime());
	}
	
	public static String setDays(int month, int date){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2, month-1);
		calendar.set(5, date);
		return new SimpleDateFormat("MMdd").format(calendar.getTime());
	}
	


//	@Test
	public void t(){
		String str = setDays(2017,10,10,0,0);
		System.out.println(str);
	}
}
