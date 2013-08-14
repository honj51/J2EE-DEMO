package net.grosso.me.dao;

import java.io.Serializable;
import java.sql.SQLException;

import net.grosso.me.domain.User;
import net.grosso.me.ibatis.IbatisSqlMapClitentUtil;



import com.ibatis.sqlmap.client.SqlMapClient;



public class IbatisUserDao implements Serializable {

	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = -1124222804301984736L;

	public User update(User user) throws SQLException {

		try {
			SqlMapClient sqlMap = IbatisSqlMapClitentUtil.getSqlMapClient();
			sqlMap.update("updateUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public int deleteUserAndRole(int userId) throws SQLException {

		try {
			SqlMapClient sqlMap = IbatisSqlMapClitentUtil.getSqlMapClient();
			//delete user and related role.
			sqlMap.startBatch();
			sqlMap.delete("deleteRoleByUserId",userId);
			sqlMap.delete("deleteUserById",userId);
			sqlMap.executeBatch();
		} catch (Exception e) {		
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public void unLockUser() throws SQLException {

		try {
			SqlMapClient sqlMap = IbatisSqlMapClitentUtil.getSqlMapClient();
			sqlMap.update("unLockUser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
