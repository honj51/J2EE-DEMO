package net.grosso.me.quartz;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("simpleService2")
public class SimpleService2 implements Serializable{
	
	private static final long serialVersionUID = 122323233244334343L;
	private static final Logger logger = LoggerFactory.getLogger(SimpleService2.class);
	
	public void testMethod(String triggerName){
		//这里执行定时调度业务
		logger.info(triggerName);
		logger.info("--------------------- next job simple service 2.");
	}
	
	public void testMethod2(){
		logger.info("testMethod2");
	}
}
