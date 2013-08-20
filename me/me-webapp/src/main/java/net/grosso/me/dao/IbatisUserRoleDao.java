package net.grosso.me.dao;

import java.sql.SQLException;
import java.util.List;

import net.grosso.me.domain.UserRole;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IbatisUserRoleDao extends SqlMapClientDaoSupport {

	@SuppressWarnings("unchecked")
	public List<UserRole> getAllUserRoles() {
		List<UserRole> useRoleList = null;
		try {
			useRoleList = getSqlMapClientTemplate().queryForList("getAllUserRoles");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return useRoleList;
	}

	public void save(UserRole userRole) {
		getSqlMapClientTemplate().insert("insertUserRole", userRole);
	}

	public void delete(UserRole userRole) {
		getSqlMapClientTemplate().delete("deleteUserRoleById", userRole);

	}
}
