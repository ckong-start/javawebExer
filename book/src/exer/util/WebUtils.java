package exer.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	/**
	 * 将请求的参数复制到JavaBean的属性中
	 * @param bean
	 * @param param
	 * @return T
	 */
	public static <T> T copyParamToBean(T bean, Map param) {
		
		try {
			
			BeanUtils.populate(bean, param);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 将字符串转换为int数据类型
	 * @param intStr
	 * @param defaultValue
	 * @return int
	 */
	public static int parseInt(String intStr, Integer defaultValue) {
		
		if(intStr != null && intStr.length() != 0)
		try {
			return Integer.parseInt(intStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultValue;
	}
}
