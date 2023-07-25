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
 * ���� 
 * ��¥�� �ð�: �ڹ� TimeStamp����, ����Ŭ,MySQL TimeStamp���� = �ش� Ÿ������ �����ϸ� �ȴ�. = SimpleDateformat�� Calendar�ʿ�
 * LocalDateTime ��¥�� �ð� : �ڹ� LocalDateTime����, ����Ŭ,MySQL TimeStamp���� = ��ȯ��� �ʿ�
 */

public class TimeTest {
	
	/*
	 * ---------------------------java.time.LocalDateTime �ֱٿ� ���ͼ� ������ ���� ����ϰ� �� Ŭ����
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
	 * ---------------------------java.sql.TimeStamp ���� ���� ���. ������ Java�� JDBC���� ���� �����ϴ� Ÿ��
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
	 * ---------------------------java.sql.Date ����� �ʿ� ����.
	 * ---------------------------java.sql.Time ����� �ʿ� ����.
	 */
	
	public void sqlDate() {
		//java.sql.Date -> ��, ��, ��
		java.sql.Date time = new java.sql.Date(1);
		System.out.println(time);
	}	
	
	public void sqlTime() {
		//java.sql.Time -> ��, ��, ��
		java.sql.Time time = new java.sql.Time(1);
		System.out.println(time);
	}
	
	/*
	 * ---------------------------java.util.Date ����� �ʿ� ����.
	 */
	
	public void utilDate() {
		//java.util.Date -> ��,��,��,��,��,��
		Date time = new Date();
		System.out.println("time : "+time);
		System.out.println("getTime : "+time.getTime());
	}
	
	public void utilDateFormat() {
		//java.util.Date -> ��,��,��,��,��,��
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd:HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);	
		System.out.println(time1);
	}	
}
