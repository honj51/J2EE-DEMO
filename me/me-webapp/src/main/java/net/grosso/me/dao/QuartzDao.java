package net.grosso.me.dao;

import java.io.Reader;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.grosso.me.domain.QuartzTrigger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class QuartzDao implements Serializable {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -4522537890173336995L;

	private static final Logger logger = LoggerFactory.getLogger(QuartzDao.class);

	public List<QuartzTrigger> findAll() throws SQLException {
		List<QuartzTrigger> quartzTriggerList = null;
		try {
			
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);

			quartzTriggerList = sqlMapClient.queryForList("getAllQuartz");
			logger.debug("quartzTriggerList.size()"+quartzTriggerList.size());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return quartzTriggerList;
	}
}
