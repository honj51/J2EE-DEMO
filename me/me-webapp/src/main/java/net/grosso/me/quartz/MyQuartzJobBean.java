package net.grosso.me.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyQuartzJobBean extends QuartzJobBean {

	private SimpleService simpleService;
	
	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}
	
	private SimpleService2 simpleService2;

	public void setSimpleService2(SimpleService2 simpleService2) {
		this.simpleService2 = simpleService2;
	}

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		Trigger trigger = jobexecutioncontext.getTrigger();
		String triggerName = trigger.getName();	
		//定时任务
		simpleService.testMethod(triggerName);
		simpleService2.testMethod(triggerName);
	}

}
