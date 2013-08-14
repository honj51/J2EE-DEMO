package net.grosso.me.quartz;

import java.io.Serializable;
import java.sql.SQLException;


import net.grosso.me.dao.IbatisUserDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UnLockService implements Serializable{
	
	private static final long serialVersionUID = 122323233244334343L;
	private static final Logger logger = LoggerFactory.getLogger(UnLockService.class);
	
	private IbatisUserDao ibatisUserDao;
	
	public void setIbatisUserDao(IbatisUserDao ibatisUserDao) {
		this.ibatisUserDao = ibatisUserDao;
	}

	public void unLockTheUser() throws SQLException{
		logger.info("start unlock");
		ibatisUserDao.unLockUser();
		logger.info("end unlock");
	}
}
