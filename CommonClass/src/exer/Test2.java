package exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class Test2 {
	@Test
	public void test6(){
		//1.获取一个DateTimeFormatter对象，并且指定格式
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH小时mm分钟ss秒SSS毫秒");
		//2.解析字符串
		String s = "2018-08-08 20小时08分钟08秒009毫秒";
		LocalDateTime parse = LocalDateTime.parse(s,dtf);
		System.out.println(parse);
		/*//1.获取一个DateTimeFormatter对象，并且指定格式
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh小时mm分钟ss秒");
		//2.解析字符串
		String s = "2018-08-08 下午 05小时06分钟43秒";
		LocalDateTime parse = LocalDateTime.parse(s,dtf);
		System.out.println(parse);*/
	}
	
	@Test
	public void test5(){
		Instant now = Instant.now();
		System.out.println(now);
		now = Instant.now();
		Date date2 = Date.from(now);
		System.out.println(date2);
		Instant instant = date2.toInstant();
		System.out.println(instant);
	}
	
	@Test
	public void test4(){
		LocalDateTime cdt = LocalDateTime.now();
		int year = cdt.getYear();
		int month = cdt.getMonthValue();
		int day = cdt.getDayOfMonth();
		System.out.println(cdt);
		System.out.println(year + " " + month + " " + day);
	}
	
	@Test
	public void test3(){
		Calendar instance = Calendar.getInstance();
//		System.out.println(instance);
		int year = instance.get(Calendar.YEAR);
		instance.add(Calendar.MONTH, 1);
		int month = instance.get(Calendar.MONTH);
		System.out.println(year + " " + month);
		Date time = instance.getTime();
		System.out.println(time);
		
	}
	
	@Test
	public void test2() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒SSS毫秒");
		Date date2 = new Date();
		String format = sdf.format(date2);
		System.out.println(format);
		Date date = sdf.parse("2019年11月02日 星期六 09时40分40秒361毫秒");
		System.out.println(date);
	}
	
	@Test
	public void test1(){
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		Date date2 = new Date(1572658097032L);
		System.out.println(date2);
	}
}
