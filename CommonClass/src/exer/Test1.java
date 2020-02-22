package exer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class Test1 {
	@Test
	public void test1(){
		String str = "";
		Date d1 = new Date();
		System.out.println(d1.getTime());
		for(int i = 0; i < 200000; i++ ){
			str += "i";
		}
		System.out.println(System.currentTimeMillis());
	}
	@Test
	public void test2(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String format = sdf.format(d);
		System.out.println(format);
	}
	@Test
	public void test3(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "年" + month + "月" + day + "日");
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.println(hour + "时" + min + "分" + sec + "秒");
		cal.set(Calendar.YEAR, 2050);
		year = cal.get(Calendar.YEAR);
		System.out.println(year);
	}
	@Test
	public void test4(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh小时mm分钟ss秒");
		String s = "2018-08-08 下午 05小时06分钟43秒";
		LocalDateTime parse = LocalDateTime.parse(s,dtf);
		System.out.println(parse);
	}
}
