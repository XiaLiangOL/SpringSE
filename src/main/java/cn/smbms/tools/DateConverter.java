package cn.smbms.tools;

import org.joda.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期格式
 * 
 * @author 梁
 *
 */
public class DateConverter implements Converter<String, Date> {
	
	/**
	 * *convert就是转换器工作时调用的转换方法<br/>
	 * *参数source就是客户端传递过来的值。
	 */
	
	private static final List<String> formarts = new ArrayList<>(4);
	
	static {
		formarts.add("yyyy-MM");
		formarts.add("yyyy-MM-dd");
		formarts.add("yyyy-MM-dd hh:mm");
		formarts.add("yyyy-MM-dd hh:mm:ss");
	}
	
	@Override
	public Date convert(String s) {
		System.out.println("转换工厂进来啦");
		if (StringUtils.isEmpty(s)) {
			return null;
		}
		try {
			String formatter = "";
			if (s.matches("^\\d{4}-\\d{1,2}$")) {
				formatter = formarts.get(0);
			}
			else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
				formatter = formarts.get(1);
			}
			else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
				formatter = formarts.get(2);
			}
			else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
				formatter = formarts.get(3);
			}
			else {
				throw new IllegalArgumentException("Invalid boolean value '" + s + "'");
			}
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatter);
			DateTime dateTime = DateTime.parse(s, dateTimeFormatter);
			return dateTime.toDate();
		}
		catch (Exception e) {
			return null;
		}
	}
	
}