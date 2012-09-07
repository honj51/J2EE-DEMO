package net.grosso.me.ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public final class IbatisSqlMapClitentUtil {

	private IbatisSqlMapClitentUtil() {
	}

	private static SqlMapClient sqlMapClient = null;
	private final static String DAFULT_RESOURCE = "SqlMapConfig.xml";

	public static SqlMapClient getSqlMapClient(String resource)
			throws IOException {
		Reader reader;
		if (sqlMapClient == null) {
			reader = Resources.getResourceAsReader(resource);
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		}
		return sqlMapClient;
	}

	public static SqlMapClient getSqlMapClient() throws IOException {
		if (sqlMapClient == null) {
			sqlMapClient = getSqlMapClient(DAFULT_RESOURCE);
		}
		return sqlMapClient;
	}
}
