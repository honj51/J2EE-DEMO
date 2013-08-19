/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package net.grosso.me.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReStartJob {

	/**
	 * Description goes here.
	 * 
	 * @param args
	 * 
	 * @since
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReStartJob.class);

	public void updateTrigger(String triggerName, String triggerGroup, String action) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(
			new String[]{"classpath:spring-beans.xml"});
		Scheduler scheduler = (Scheduler)springContext.getBean("quartzScheduler");
		try {
			if ("resume".equals(action)) {
				scheduler.resumeTrigger(triggerName, triggerGroup);
			} else if ("pause".equals(action)) {
				scheduler.pauseTrigger(triggerName, triggerGroup);
			}else {
				logger.info("no action.");
			}
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
		}
	}

}
