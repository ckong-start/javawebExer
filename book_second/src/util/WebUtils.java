package util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T copy2Bean(T bean, Map params) {
		try {
			BeanUtils.populate(bean, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}
	public static Integer parse2Integer(String str, Integer defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		return defaultValue;
		
	}
}
