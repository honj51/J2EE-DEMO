package net.grosso.me.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringBeanUtil {
	private SpringBeanUtil() {
	}

	private static ApplicationContext springContext;

	public static <T> T getBean(String beanName) {

		if (springContext == null) {
			springContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-beans.xml"});
		}
		T t = (T)springContext.getBean(beanName);
		return t;
	}
}
