package net.grosso.me.dao;

import java.io.Serializable;

import net.grosso.me.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IbatisUserDao extends SqlMapClientDaoSupport implements Serializable {

	/**
	 * serialVersionUID long
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(IbatisUserDao.class);
	private static final long serialVersionUID = -1124222804301984736L;

	public User update(User user) {
		getSqlMapClientTemplate().update("updateUser", user);
		return user;
	}

	public int deleteUserAndRole(int userId) {
		try {
			getSqlMapClientTemplate().delete("deleteRoleByUserId", userId);
			getSqlMapClientTemplate().delete("deleteUserById", userId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public void unLockUser() {
		getSqlMapClientTemplate().update("unLockUser");
		logger.info("test quartz.");
	}

}
