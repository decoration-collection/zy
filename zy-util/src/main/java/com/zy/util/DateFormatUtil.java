package com.zy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
* @ClassName: DateFormatUtil 
* @Description: 日期、时间格式转换工具类
* @author chenrui <chenrui@cstonline.cn> 
* @date 2014-4-23 下午5:11:21 
*
 */
public class DateFormatUtil {
	
	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	public static final String simple = "yyyy-MM-dd HH:mm:ss";
	
	/** 年月日 yyyy-MM-dd */
	public static final String dtSimple = "yyyy-MM-dd";
	
	/** 年月 yyyy-MM */
	public static final String dtSimpleYm = "yyyy-MM";
	
	/** 年月 yyyy-MM */
	public static final String dtSimpleYmSlash = "yyyy/MM";
	
	/** 年月日 yyyy/MM/dd */
	public static final String dtSimpleSlash = "yyyy/MM/dd";
	
	/** 年月日(中文) yyyy年MM月dd日 */
	public static final String dtSimpleChinese = "yyyy年MM月dd日";
	
	public static final String week = "EEEE";
	/** 年月日(无下划线) yyyyMMdd */
	public static final String dtShort = "yyyyMMdd";
	
	/** 年月日时分秒(无下划线) yyyyMMddHHmmss */
	public static final String dtLong = "yyyyMMddHHmmss";
	
	/** 时分秒 HH:mm:ss */
	public static final String hmsFormat = "HH:mm:ss";
	
	/** 时分秒 HHmmss */
	public static final String hmsFormat1 = "HHmmss";
	
	/** 年-月-日 小时:分钟 yyyy-MM-dd HH:mm */
	public static final String simpleFormat = "yyyy-MM-dd HH:mm";
	
	/** 完整时间 yyyy-MM-dd HH:mm:ss.SSS */
	public static final String allSimple = "yyyy-MM-dd HH:mm:ss.SSS";

	/** 时分秒 HH:mm */
	public static final String hmFormat = "HH:mm";
	
	/** 年月日(中文) yyyy年MM月 */
	public static final String yySimpleChinese = "yyyy年";
	
	/** 年月日(中文) yyyy年 */
	public static final String ymSimpleChinese = "yyyy年MM月";
	/** 月日(中文) */
	public static final String ymSimpleChineseMonthDay = "MM月dd日";
	
	/** 月日(-) */
	public static final String mdSimpleMonthDay = "MM-dd";
	
	/**
	 * 获取格式
	 * 
	 * @param format
	 * @return
	 */
	public static final DateFormat getFormat(String format) {
		return new SimpleDateFormat(format);
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static final String simpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(simple).format(date);
	}
	
	/**
	 * MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static final String simpleMHFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(mdSimpleMonthDay).format(date);
	}
	
	/**
	 * yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static final String dtSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimple).format(date);
	}
	
	/**
	 * yyyy-MM
	 * 
	 * @param date
	 * @return
	 */
	public static final String dtSimpleYmFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleYm).format(date);
	}
	
	/**
	 * yyyy/MM
	 * 
	 * @param date
	 * @return
	 */
	public static final String dtSimpleYmSlashFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleYmSlash).format(date);
	}
	
	/**
	 * yyyy-mm 日期格式转换为日期
	 * 
	 * @param strDate
	 * @return
	 */
	public static final Date strToDtSimpleYmFormat(String strDate) {
		if (strDate == null) {
			return null;
		}
		try {
			return getFormat(dtSimpleYm).parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * yyyy-mm-dd 日期格式转换为日期
	 * 
	 * @param strDate
	 * @return
	 */
	public static final Date strToDtSimpleFormat(String strDate) {
		if (strDate == null) {
			return null;
		}
		try {
			return getFormat(dtSimple).parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * yyyy/MM/dd
	 * 
	 * @param date
	 * @return
	 */
	public static final String dtSimpleSlashFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleSlash).format(date);
	}
	
	/**
	 * yyyy/mm/dd 日期格式转换为日期
	 * 
	 * @param strDate
	 * @return
	 */
	public static final Date strToDtSimpleSlashFormat(String strDate) {
		if (strDate == null) {
			return null;
		}
		try {
			return getFormat(dtSimpleSlash).parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 获取输入日期的相差日期
	 * 
	 * @param dt
	 * @param idiff
	 * 
	 * @return
	 */
	public static final String getDiffDate(Date dt, int idiff) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, idiff);
		return dtSimpleFormat(c.getTime());
	}
	
	/**
	 * 获取输入日期月份的相差日期
	 * 
	 * @param dt
	 * @param idiff
	 * @return
	 */
	public static final String getDiffMon(Date dt, int idiff) {
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.MONTH, idiff);
		return dtSimpleFormat(c.getTime());
	}
	
	/**
	 * yyyy年MM月dd日
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String dtSimpleChineseFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleChinese).format(date);
	}
	
	/**
	 * yyyy年MM月
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String dtYMSimpleChineseFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(ymSimpleChinese).format(date);
	}
	
	/**
	 * MM月dd日
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String dtYMSimpleChineseMonthDayFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(ymSimpleChineseMonthDay).format(date);
	}
	
	/**
	 * yyyy年
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String dtYYSimpleChineseFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(yySimpleChinese).format(date);
	}
	
	/**
	 * yyyy-MM-dd到 yyyy年MM月dd日 转换
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String dtSimpleChineseFormatStr(String date) throws ParseException {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleChinese).format(string2Date(date));
	}
	
	/**
	 * yyyy-MM-dd 日期字符转换为时间
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final Date string2Date(String stringDate) throws ParseException {
		if (stringDate == null) {
			return null;
		}
		return getFormat(dtSimple).parse(stringDate);
	}
	
	/**
	 * 返回日期时间
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final Date string2DateTime(String stringDate) throws ParseException {
		if (stringDate == null) {
			return null;
		}
		return getFormat(simple).parse(stringDate);
	}
	

	
	/**
	 * 返回日期时间
	 * 
	 * @param stringDate (yyyyMMdd)
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final Date shortstring2Date(String stringDate) throws ParseException {
		if (stringDate == null) {
			return null;
		}
		return getFormat(dtShort).parse(stringDate);
	}
	
	/**
	 * 返回短日期格式（yyyyMMdd格式）
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final String shortDate(Date Date) {
		if (Date == null) {
			return null;
		}
		return getFormat(dtShort).format(Date);
	}
	
	/**
	 * 返回长日期格式（yyyyMMddHHmmss格式）
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final String longDate(Date Date) {
		if (Date == null) {
			return null;
		}
		return getFormat(dtLong).format(Date);
	}
	
	/**
	 * yyyy-MM-dd 日期字符转换为长整形
	 * 
	 * @param stringDate
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final Long string2DateLong(String stringDate) throws ParseException {
		Date d = string2Date(stringDate);
		if (d == null) {
			return null;
		}
		return Long.valueOf(d.getTime());
	}
	
	/**
	 * 日期转换为字符串 HH:mm:ss
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String hmsFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(hmsFormat).format(date);
	}
	
	/**
	 * 日期转换为字符串 HH:mm
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String hmFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(hmFormat).format(date);
	}
	
	/**
	 * 时间转换字符串 2005-06-30 15:50
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final String simpleDate(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(simpleFormat).format(date);
	}
	
	/**
	 * 字符串 2005-06-30 15:50 转换成时间
	 * @param date String
	 * @return
	 * @throws ParseException
	 */
	public static final Date simpleFormatDate(String dateString) throws ParseException {
		
		if (dateString == null || dateString.trim().length() == 0) {
			return null;
		}
		
		return getFormat(simpleFormat).parse(dateString.trim());
	}
	
	/**
	 * 获取当前日期的日期差 now= 2005-07-19 diff = 1 -> 2005-07-20 diff = -1 -> 2005-07-18
	 * 
	 * @param diff
	 * 
	 * @return
	 */
	public static final String getDiffDate(int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, diff);
		return dtSimpleFormat(c.getTime());
	}
	
	public static final Date getDiffDateTime(int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, diff);
		return c.getTime();
	}
	
	/**
	 * 获取当前日期的日期时间差
	 * 
	 * @param diff
	 * @param hours
	 * 
	 * @return
	 */
	public static final String getDiffDateTime(int diff, int hours) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, diff);
		c.add(Calendar.HOUR, hours);
		return dtSimpleFormat(c.getTime());
	}
	
	/**
	 * 把日期类型的日期换成数字类型 YYYYMMDD类型
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static final Long dateToNumber(Date date) {
		if (date == null) {
			return null;
		}
		String formated = getFormat(dtShort).format(date);
		return Long.valueOf(formated);
	}

	/**
	 * 返回日期相差天数，向下取整数
	 * 
	 * @param dateStart 一般前者小于后者dateEnd
	 * @param dateEnd
	 * 
	 * @return
	 */
	public static int countDays(Date dateStart, Date dateEnd) {
		if ((dateStart == null) || (dateEnd == null)) {
			return -1;
		}
		return (int) ((dateEnd.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	/**
	 * 校验start与end相差的天数，是否满足end-start lessEqual than days
	 * 
	 * @param start
	 * @param end
	 * @param days
	 * 
	 * @return
	 */
	public static boolean checkDays(Date start, Date end, int days) {
		int g = countDays(start, end);
		return g <= days;
	}
	
	/**
	 * @return
	 */
	public static Date now() {
		return new Date();
	}
	
	/**
	 * 日期格式（yyyyMMdd格式）
	 * 
	 * @return
	 */
	public static String nowStr() {
		return shortDate(new Date());
	}
	
	/**
	 * 获取明天
	 * 
	 * @return
	 */
	public static Date tomorrow() {
		Calendar cad = Calendar.getInstance();
		cad.setTime(new Date());
		cad.add(Calendar.DATE, 1);
		return cad.getTime();
	}
	
	/**
	 * alahan add 20050825 获取传入时间相差的日期
	 * 
	 * @param dt 传入日期，可以为空
	 * @param diff 需要获取相隔diff天的日期 如果为正则取以后的日期，否则时间往前推
	 * 
	 * @return
	 */
	public static String getDiffStringDate(Date dt, int diff) {
		Calendar ca = Calendar.getInstance();
		if (dt == null) {
			ca.setTime(new Date());
		} else {
			ca.setTime(dt);
		}
		ca.add(Calendar.DATE, diff);
		return dtSimpleFormat(ca.getTime());
	}
	
	/**
	 * 校验输入的时间格式是否合法，但不需要校验时间一定要是8位的
	 * 
	 * @param statTime
	 * 
	 * @return alahan add 20050901
	 */
	public static boolean checkTime(String statTime) {
		if (statTime.length() > 8) {
			return false;
		}
		String[] timeArray = statTime.split(":");
		if (timeArray.length != 3) {
			return false;
		}
		for (int i = 0; i < timeArray.length; i++) {
			String tmpStr = timeArray[i];
			try {
				Integer tmpInt = new Integer(tmpStr);
				if (i == 0) {
					if ((tmpInt.intValue() > 23) || (tmpInt.intValue() < 0)) {
						return false;
					} else {
						continue;
					}
				}
				if ((tmpInt.intValue() > 59) || (tmpInt.intValue() < 0)) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 返回日期时间
	 * 
	 * @param stringDate (yyyyMMdd)
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	public static final String stringToStringDate(String stringDate) {
		if (stringDate == null) {
			return null;
		}
		if (stringDate.length() != 8) {
			return null;
		}
		return stringDate.substring(0, 4) + stringDate.substring(4, 6) + stringDate.substring(6, 8);
	}
	
	/**
	 * 将字符串按format格式转换为date类型
	 * 
	 * @param str
	 * @param format
	 * 
	 * @return
	 */
	public static Date string2Date(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 加减天数
	 * 
	 * @param date
	 * @return Date
	 */
	public static final Date increaseDate(Date aDate, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDate);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}
	
	/**
	 * 是否闰年
	 * 
	 * @param year
	 * @return
	 */
	public static final boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	/**
	 * 判断是否是默认工作日，一般默认工作日是星期一都星期五， 所以，这个函数本质是判断是否是星期一到星期五
	 * 
	 * @param date
	 * @return
	 */
	public static final boolean isDefaultWorkingDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		return !(week == 7 || week == 1);
	}
	
	/**
	 * 获取星期名，如“星期一”、“星期二”
	 * @param date
	 * @return
	 */
	public static final String getWeekDay(Date date) {
		return getFormat(week).format(date);
	}

	
	/**
	 * 获取当前时间的字符串格式，以半个小时为单位<br>
	 * 当前时间2007-02-02 22:23 则返回 2007-02-02 22:00 当前时间2007-02-02 22:33 则返回
	 * 2007-02-02 22:30
	 * @return
	 */
	public static final String getNowDateForPageSelectAhead() {
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.MINUTE) < 30) {
			cal.set(Calendar.MINUTE, 0);
		} else {
			cal.set(Calendar.MINUTE, 30);
		}
		return simpleDate(cal.getTime());
	}
	
	/**
	 * 获取当前时间的字符串格式，以半个小时为单位<br>
	 * 当前时间2007-02-02 22:23 则返回 2007-02-02 22:30 当前时间2007-02-02 22:33 则返回
	 * 2007-02-02 23:00
	 * @return
	 */
	public static final String getNowDateForPageSelectBehind() {
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.MINUTE) < 30) {
			cal.set(Calendar.MINUTE, 30);
		} else {
			cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
			cal.set(Calendar.MINUTE, 0);
		}
		return simpleDate(cal.getTime());
	}
	
	public static String getNewFormatDateString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(simple);
		return getDateString(date, dateFormat);
	}
	
	public static String getDateString(Date date, DateFormat dateFormat) {
		if (date == null || dateFormat == null) {
			return null;
		}
		return dateFormat.format(date);
	}
	
	/**
	 * 获取一个月前的时间
	 */
	public static Date getOneMonthBegin() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		
		return cal.getTime();
	}
	
	/**
	 * 获取date那天的开始时间，00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartTimeOfTheDate(Date date) {
		if (date == null) {
			return null;
			
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	}


    /**
	 * 获取date那天的结束时间，23:59:
	 * @param date
	 * @return
	 */
	public static Date getEndTimeOfTheDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND,999);
		return c.getTime();
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss.SSS
	 * 
	 * @param date
	 * @return
	 */
	public static final String simpleAllFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(allSimple).format(date);
	}

	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

	
	/**
	 * 格式示例 05-15 周五 09:00 - 17:00
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String formatPeriod(Date date1,Date date2,boolean showHHmm) {
		Date minDate = date1;
		Date maxDate = date2;
		if(date1.after(date2)) {
			minDate = date2;
			maxDate = date1;
		}
		//格式化起止时间
		Calendar minCalendar = Calendar.getInstance();
		minCalendar.setTime(minDate);
		int minYear = minCalendar.get(Calendar.YEAR);
		int minMonth = minCalendar.get(Calendar.MONTH);
		int minDay = minCalendar.get(Calendar.DAY_OF_MONTH);
		String minWeek = getWeekOfDate(minDate);
		
		Calendar maxCalendar = Calendar.getInstance();
		maxCalendar.setTime(maxDate);
		int maxYear = maxCalendar.get(Calendar.YEAR);
		int maxMonth = maxCalendar.get(Calendar.MONTH);
		int maxDay = maxCalendar.get(Calendar.DAY_OF_MONTH);
		String maxWeek = getWeekOfDate(maxDate);
		
		//跨年
		if(minYear != maxYear) {
			StringBuffer strBuff1 = new StringBuffer();
			StringBuffer strBuff2 = new StringBuffer();
			strBuff1.append(dtSimpleFormat(minDate)).append(" ");
			strBuff2.append(dtSimpleFormat(maxDate)).append(" ");
			if(showHHmm) {
				strBuff1.append(hmFormat(minDate)).append(" ");
				strBuff2.append(hmFormat(maxDate)).append(" ");
			}
			return strBuff1.toString() + "~ " + strBuff2.toString();
		} 
		//同年跨月
		else if(minMonth != maxMonth || minDay != maxDay) {
			StringBuffer strBuff1 = new StringBuffer();
			StringBuffer strBuff2 = new StringBuffer();
			strBuff1.append(simpleMHFormat(minDate)).append(" ");
			strBuff2.append(simpleMHFormat(maxDate)).append(" ");
			if(showHHmm) {
				strBuff1.append(hmFormat(minDate)).append(" ");
				strBuff2.append(hmFormat(maxDate)).append(" ");
			}
			return strBuff1.toString() + "~ " + strBuff2.toString();
		} 
		//同一天
		else {
			StringBuffer strBuff = new StringBuffer();
			if(showHHmm) {
				strBuff.append(simpleMHFormat(minDate)).append(" ").append(minWeek).append(" ").append(hmFormat(minDate)).append(" - ")
				.append(hmFormat(maxDate));
			} else {
				strBuff.append(simpleMHFormat(minDate)).append(" ").append(minWeek);
			}
			return strBuff.toString();
		}
	} 

	public static void main(String[] args) {
		System.out.println(formatPeriod(new Date(1424595980500L),new Date(1324595980500L),true));
		
//		System.out.println(getWeekOfDate(new Date()));
	}
}


