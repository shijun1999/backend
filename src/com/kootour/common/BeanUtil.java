package com.kootour.common;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {

	public static void copyProperties(final Object dest, final Object orig, final String[] ignore)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String, String> include = BeanUtils.describe(orig);

		for (String key : ignore) {
			if (include.containsKey(key)) {
				include.remove(key);
			}
		}
		BeanUtils.copyProperties(dest, orig);
	}
}
