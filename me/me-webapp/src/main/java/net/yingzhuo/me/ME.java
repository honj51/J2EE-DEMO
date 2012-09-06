package net.yingzhuo.me;

public interface ME {

	public static final String CAPTCHA_SESSION_ATTRIBUTE_KEY = ME.class.getName() + "#CAPTCHA_SESSION_ATTRIBUTE_KEY";

	public static final int DEFAULT_PAGE_SIZE = 20;

	public static interface RoleNames {
		
		public static final String ADMIN = "ROLE_ADMIN";

		public static final String USER = "ROLE_USER";
	}
}
