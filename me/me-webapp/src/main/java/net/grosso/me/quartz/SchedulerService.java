package net.grosso.me.quartz;


import java.util.Date;

import org.quartz.CronExpression;

public interface SchedulerService {
	/**
	 * ��� Quartz Cron Expression ��������
	 * @param cronExpression  Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
	 */
	void schedule(String cronExpression);
	
	/**
	 * ��� Quartz Cron Expression ��������
	 * @param name  Quartz CronTrigger���
	 * @param cronExpression Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
	 */
	void schedule(String name,String cronExpression);
	
	/**
	 * ��� Quartz Cron Expression ��������
	 * @param cronExpression Quartz CronExpression
	 */
	void schedule(CronExpression cronExpression);
	
	/**
	 * ��� Quartz Cron Expression ��������
	 * @param name Quartz CronTrigger���
	 * @param cronExpression Quartz CronExpression
	 */
	void schedule(String name,CronExpression cronExpression);
	
	/**
	 * ��startTimeʱִ�е���һ��
	 * @param startTime ���ȿ�ʼʱ��
	 */
	void schedule(Date startTime);	
	
	/**
	 * ��startTimeʱִ�е���һ��
	 * @param name Quartz SimpleTrigger ���
	 * @param startTime ���ȿ�ʼʱ��
	 */
	void schedule(String name,Date startTime);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 */
	void schedule(Date startTime,Date endTime);	
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
	 * @param name Quartz SimpleTrigger ���
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 */
	void schedule(String name,Date startTime,Date endTime);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 */
	void schedule(Date startTime,Date endTime,int repeatCount);	
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
	 * @param name Quartz SimpleTrigger ���
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 */
	void schedule(String name,Date startTime,Date endTime,int repeatCount);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param repeatInterval ִ��ʱ�����
	 */
	void schedule(Date startTime,Date endTime,int repeatCount,long repeatInterval) ;
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
	 * @param name Quartz SimpleTrigger ���
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param repeatInterval ִ��ʱ�����
	 */
	void schedule(String name,Date startTime,Date endTime,int repeatCount,long repeatInterval);
}
