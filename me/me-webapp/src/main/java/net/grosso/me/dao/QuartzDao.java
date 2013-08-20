package net.grosso.me.dao;

import java.io.Serializable;
import java.util.List;

import net.grosso.me.domain.QuartzTrigger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class QuartzDao extends SqlMapClientDaoSupport  implements Serializable {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -4522537890173336995L;

	private static final Logger logger = LoggerFactory.getLogger(QuartzDao.class);

	public List<QuartzTrigger> findAll() {	
		logger.info("start::findAll().");
		return getSqlMapClientTemplate().queryForList("getAllQuartz");
	}
}
