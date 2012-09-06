package net.grosso.me.security;

import net.grosso.me.domain.User;

import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentUserHolder {

	private CurrentUserHolder() {
	}

	public static User get() {
		try {
			return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (ClassCastException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public static Integer getId() {
		return get() == null ? null : get().getId();
	}
}
