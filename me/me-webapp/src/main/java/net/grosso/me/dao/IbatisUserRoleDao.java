package net.grosso.me.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import net.grosso.me.domain.UserRole;
import net.grosso.me.ibatis.IbatisSqlMapClitentUtil;



import com.ibatis.sqlmap.client.SqlMapClient;



public class IbatisUserRoleDao {

	@SuppressWarnings("unchecked")
	public List<UserRole> getAllUserRoles() throws SQLException {
		List<UserRole> useRoleList=null;
		try {
			SqlMapClient sqlMap = IbatisSqlMapClitentUtil.getSqlMapClient();
			 useRoleList=sqlMap.queryForList("getAllUserRoles");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return useRoleList;
	}
	
	public void save(UserRole userRole) throws SQLException {
		SqlMapClient sqlMap;
		try {
			sqlMap = IbatisSqlMapClitentUtil.getSqlMapClient();
			sqlMap.insert("insertUserRole", userRole);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void delete(UserRole userRole) throws SQLException {
		SqlMapClient sqlMap;
		try {
			sqlMap = IbatisSqlMapClitentUtil.getSqlMapClient();
			sqlMap.delete("deleteUserRoleById",userRole);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
