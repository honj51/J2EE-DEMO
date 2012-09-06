package net.grosso.me.util.ibatis;

import com.ibatis.sqlmap.client.*;
import com.ibatis.common.resources.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class DemoIbatis {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		String resource ="SqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			List<Account> list= sqlMap.queryForList("getAllUsers", "home");
			
			for (int i=0;i<list.size();i++){
				System.out.println(list.get(i).getGroupname());
				System.out.println(list.get(i).getPassword());
				System.out.println(list.get(i).getUserid());
			
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
