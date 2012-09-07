package junit.ibatis;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import net.grosso.me.domain.User;
import net.grosso.me.ibatis.IbatisSqlMapClitentUtil;

import org.junit.Test;

import com.ibatis.sqlmap.client.SqlMapClient;

public class TestUser {

	@Test
	public void testListUser() throws IOException, SQLException {
		SqlMapClient sqlMap=IbatisSqlMapClitentUtil.getSqlMapClient();
		List<User> userList=sqlMap.queryForList("getAllUsers","admin");
		for(User user:userList)
		{
			System.out.print(user.getId());
			System.out.print(user.getPassword());
			System.out.print(user.getLock());
			System.out.print(user.getGender());
		}
	}
}
