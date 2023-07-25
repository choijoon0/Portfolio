package test;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;



//java.sql.date
//java.sql.time
//java.util.date
//java.sql.Timestamp
//java.time.LocalDate

//rs.getTime(columnIndex); //java.sql.Time
//rs.getDate(columnIndex); //java.sql.Date
//rs.getTimestamp(columnIndex); //java.sql.Timestamp

/**
 * 정리 
 * 날짜와 시간: 자바 TimeStamp지원, 오라클,MySQL TimeStamp지원 = 해당 타입으로 고정하면 된다. = SimpleDateformat과 Calendar필요
 * LocalDateTime 날짜와 시간 : 자바 LocalDateTime지원, 오라클,MySQL TimeStamp지원 = 변환기술 필요
 */

public class TimeTest {
	
	/*
	 * ---------------------------java.time.LocalDateTime 최근에 나와서 앞으로 많이 사용하게 될 클래스
	 */
	
	public void localDate() {
		//LocalDate
		System.out.println("LocalDate : "+LocalDate.now());
	}
	
	public void localTime() {
		//LocalTime
		System.out.println("LocalTime : "+LocalTime.now());
	}
	
	public void localDateTime() {
		//LocalDateTime
		System.out.println("LocalDateTime : "+LocalDateTime.now());
	}
	
	/*
	 * ---------------------------java.sql.TimeStamp 가장 많이 사용. 이유는 Java와 JDBC에서 동시 지원하는 타입
	 */
	
	public void sqlTimeStamp() {
		//java.sql.TimeStamp
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);

		System.out.println("Timestamp : " + ts);
	}
	
	
	/*
	 * ---------------------------java.sql.Date 사용할 필요 없음.
	 * ---------------------------java.sql.Time 사용할 필요 없음.
	 */
	
	public void sqlDate() {
		//java.sql.Date -> 년, 월, 일
		java.sql.Date time = new java.sql.Date(1);
		System.out.println(time);
	}	
	
	public void sqlTime() {
		//java.sql.Time -> 시, 분, 초
		java.sql.Time time = new java.sql.Time(1);
		System.out.println(time);
	}
	
	/*
	 * ---------------------------java.util.Date 사용할 필요 없음.
	 */
	
	public void utilDate() {
		//java.util.Date -> 년,월,일,시,분,초
		Date time = new Date();
		System.out.println("time : "+time);
		System.out.println("getTime : "+time.getTime());
	}
	
	public void utilDateFormat() {
		//java.util.Date -> 년,월,일,시,분,초
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd:HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);	
		System.out.println(time1);
	}	
}
