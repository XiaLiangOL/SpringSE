
package cn.smbms.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author 梁
 *
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
	
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMdd" };
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		}
		else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}
	
	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}
	
	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}
	
	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}
	
	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
	 * "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMdd" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		}
		catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}
	
	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}
	
	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}
	
	/**
	 * 获取某一天的开始时间（0点）
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateStart(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取某一天的结束时间(23:59)
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateEnd(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 比较两个日期时间的大小,反回1表示preDateStr > nextDateStr，0就相等，-1为小于
	 * 
	 * @author: weihuang.peng
	 * @param preDateStr
	 * @param nextDateStr
	 * @return result
	 */
	public static int compareDate(Object preDateStr, Object nextDateStr) {
		int result = 0;
		Date preDate = parseDate(preDateStr);
		Date nextDate = parseDate(nextDateStr);
		try {
			result = preDate.compareTo(nextDate);
		}
		catch (Exception e) {
			result = 0;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取某一天的前几天或者后几天，根据数字符号决定天数
	 * 
	 * @author: weihuang.peng
	 * @param date
	 * @param days
	 * @return
	 */
	public static String getPastDayStr(Object dateObj, int days) {
		Date date = parseDate(dateObj);
		long time = date.getTime() + days * (long) (24 * 60 * 60 * 1000);
		return formatDate(new Date(time));
	}
	
	/**
	 * preDateStr - nextDateStr 返回秒数
	 * 
	 * @author: huiyang.yu
	 * @param preDateStr
	 * @param nextDateStr
	 * @return
	 */
	public static long getSubactDate(Object preDateStr, Object nextDateStr) {
		Date preDate = parseDate(preDateStr);
		Date nextDate = parseDate(nextDateStr);
		long result = (preDate.getTime() - nextDate.getTime()) / 1000L;
		return result;
	}
	
	/**
	 * 返回过去的天数： preDateStr - nextDateStr
	 * 
	 * @author: weihuang.peng
	 * @param preDateStr
	 * @param nextDateStr
	 * @return
	 */
	public static long getDifferDate(Object preDateStr, Object nextDateStr) {
		return getSubactDate(preDateStr, nextDateStr) / (60 * 60 * 24L);
	}
	
	/**
	 * 传入日期时间与当前系统日期时间的比较, 若日期相同，则根据时分秒来返回 , 否则返回具体日期
	 * 
	 * @author: huiyang.yu
	 * @param updateDate
	 *            传入日期
	 * @param updateTime
	 *            传入时间
	 * @return 日期或者 xx小时前||xx分钟前||xx秒前
	 */
	public static String getNewUpdateDateString(String updateDate, String updateTime) {
		String result = updateDate;
		long time = 0;
		if (updateDate.equals(DateUtils.getDate())) {
			time = DateUtils.getSubactDate(DateUtils.getDateTime(), updateDate + " " + updateTime);
			if (time >= 3600) {
				result = time / 3600 + "小时前";
			}
			else if (time >= 60) {
				result = time / 60 + "分钟前";
			}
			else if (time >= 1) {
				result = time + "秒前";
			}
			else {
				result = "刚刚";
			}
		}
		else if (result.length() >= 10) {
			result = result.substring(5);
		}
		return result;
	}
	
}
