package com.leisure.forum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午7:01:49
 */
public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Date parseDate(String date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			LOGGER.error("日期解析失败.");
		}
		return null;
	}
}
