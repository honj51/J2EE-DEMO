

package net.grosso.me.quartz;

import net.grosso.me.util.SpringBeanUtil;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		
		Scheduler scheduler = (Scheduler)SpringBeanUtil.getBean("quartzScheduler");  
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
