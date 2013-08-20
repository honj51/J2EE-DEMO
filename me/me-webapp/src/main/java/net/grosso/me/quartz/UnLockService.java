package net.grosso.me.quartz;

import java.io.Serializable;

import javax.annotation.Resource;

import net.grosso.me.dao.IbatisUserDao;
import net.grosso.me.util.SpringBeanUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("unLockService")
public class UnLockService implements Serializable {

	private static final long serialVersionUID = 122323233244334343L;

	private static final Logger logger = LoggerFactory.getLogger(UnLockService.class);

	
	public void unLockTheUser() {
		logger.info("start unlock");
		IbatisUserDao ibatisUserDao= SpringBeanUtil.getBean("ibatisUserDao");
		ibatisUserDao.unLockUser();
		logger.info("end unlock");	
	}
}
