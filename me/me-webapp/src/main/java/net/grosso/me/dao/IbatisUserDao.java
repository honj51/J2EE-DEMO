package net.grosso.me.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import net.grosso.me.domain.User;
import net.grosso.me.ibatis.IbatisSqlMapClitentUtil;

public class IbatisUserDao {
	
	public User update(User user) throws SQLException{
		
		try {
			SqlMapClient sqlMap=IbatisSqlMapClitentUtil.getSqlMapClient();
			sqlMap.update("updateUser", user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;	
	}

}
