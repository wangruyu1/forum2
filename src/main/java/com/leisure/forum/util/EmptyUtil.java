package com.leisure.forum.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 王如雨
 * @date 创建时间：2017年9月11日 下午4:56:26
 * @version 1.0
 */
public class EmptyUtil {
	/**
	 * 判断null,"",集合,数组大小为0
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof Collection) {
			Collection collection = (Collection) obj;
			return collection.size() == 0;

		}
		if (obj instanceof Map) {
			Map map = (Map) obj;
			return map.size() == 0;

		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;

		}
		if (obj instanceof String) {
			return "".equals(((String) obj).trim());
		}
		return false;
	}

	/**
	 * 判断null,"",集合,数组大小为0
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static void main(String[] args) {
		System.out.println(EmptyUtil.isEmpty(new Object()));
		System.out.println(EmptyUtil.isEmpty(new int[1]));
		System.out.println(EmptyUtil.isEmpty(new String[1]));
		List l = new ArrayList<>();
		l.add("as");
		System.out.println(EmptyUtil.isEmpty(l));
		System.out.println(EmptyUtil.isEmpty(new HashMap<>()));
	}
}
