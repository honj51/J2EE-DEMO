package net.grosso.me.quartz;

import java.io.Serializable;
import java.sql.SQLException;

import net.grosso.me.dao.IbatisUserDao;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnLockService implements Serializable {
	static int  i=0;

	private static final long serialVersionUID = 122323233244334343L;

	private static final Logger logger = LoggerFactory.getLogger(UnLockService.class);

	private IbatisUserDao ibatisUserDao;

	public void setIbatisUserDao(IbatisUserDao ibatisUserDao) {
		this.ibatisUserDao = ibatisUserDao;
	}
	
	private static Scheduler getScheduler() {

		ApplicationContext springContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-beans.xml"});  
		Scheduler sf = (Scheduler)springContext.getBean("quartzScheduler");  

		return sf;

	}
	private static Scheduler scheduler = getScheduler();

	


	public void unLockTheUser() throws SQLException, SchedulerException {
		logger.info("start unlock");
		ibatisUserDao.unLockUser();
		logger.info("end unlock");
		i=i+1;
		logger.info("i:"+i);
		if(i==2){
			try {
				scheduler.pauseTrigger(scheduler.getSchedulerName(), "DEFAULT");
				logger.info("stop quartz");
			} catch (SchedulerException e) {
				e.getStackTrace();
			}
		}
	}
}
