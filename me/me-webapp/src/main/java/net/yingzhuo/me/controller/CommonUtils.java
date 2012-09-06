/**
 * 
 */
package net.yingzhuo.me.controller;

import java.beans.PropertyEditor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletRequest;

import org.apache.commons.beanutils.BeanUtils;
// import org.springframework.web.bind.BindUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

// import org.springframework.web.bind.ServletRequestDataBinder;

/**
 *
 * 
 * @author longbow
 */
public final class CommonUtils {

	/**
	 * ��ԴBean�е�����ֵ������Ŀ��Bean��
	 * 
	 * @param orig
	 *            Դbean
	 * @param dest
	 *            Ŀ��bean
	 */
	public static void copyProperties(Object orig, Object dest) {
		try {
			BeanUtils.copyProperties(orig, dest);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ϊbean�����Ը�ֵ
	 * 
	 * @param bean
	 * @param name
	 * @param value
	 */
	public static void copyProperty(Object bean, String name, Object value) {
		try {
			BeanUtils.copyProperty(bean, name, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �õ���ļ�� �磺java.lang.Object �����Object
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getShortName(Class clazz) {
		return clazz.getSimpleName();
	}

	@SuppressWarnings("unchecked")
	public static Map getParametersStartingWith(ServletRequest request,
			String prefix) {
		Enumeration paramNames = request.getParameterNames();
		Map params = new TreeMap();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null) {
					// do nothing, no values found at all
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}

	public static void bind(ServletRequest request, Object dest) {
		// BindUtils.bind(request,dest,dest.getClass().getSimpleName());

		// ServletRequestDataBinder binder = new ServletRequestDataBinder(dest,
		// dest.getClass().getSimpleName());
		// binder.bind(request);

		Map properties = getParametersStartingWith(request, null);
		MutablePropertyValues mutableProperties = new MutablePropertyValues(
				properties);
		BeanWrapperImpl wrapper = new BeanWrapperImpl(dest);
		// ���ӽ������ڵĴ���
		wrapper.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

		PropertyEditor integerEditor = new CustomNumberEditor(Integer.class,
				true);
		PropertyEditor longEditor = new CustomNumberEditor(Long.class, true);
		PropertyEditor floatEditor = new CustomNumberEditor(Float.class, true);
		PropertyEditor doubleEditor = new CustomNumberEditor(Double.class, true);
		PropertyEditor bigDecimalEditor = new CustomNumberEditor(
				BigDecimal.class, false);
		PropertyEditor bigIntegerEditor = new CustomNumberEditor(
				BigInteger.class, false);

		// ���ӶԿ���������Ĵ���
		wrapper.registerCustomEditor(int.class, integerEditor);
		wrapper.registerCustomEditor(Integer.class, integerEditor);
		wrapper.registerCustomEditor(long.class, longEditor);
		wrapper.registerCustomEditor(Long.class, longEditor);
		wrapper.registerCustomEditor(float.class, floatEditor);
		wrapper.registerCustomEditor(Float.class, floatEditor);
		wrapper.registerCustomEditor(double.class, doubleEditor);
		wrapper.registerCustomEditor(Double.class, doubleEditor);

		wrapper.registerCustomEditor(BigDecimal.class, bigDecimalEditor);
		wrapper.registerCustomEditor(BigInteger.class, bigIntegerEditor);

		wrapper.setPropertyValues(mutableProperties, true);

	}


}
