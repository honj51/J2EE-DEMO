

package net.grosso.me.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import net.grosso.me.domain.QuartzTrigger;
import net.grosso.me.quartz.ReStartJob;
import net.grosso.me.security.CurrentUserHolder;
import net.grosso.me.service.QuartzService;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/quartz")
public class QuartzController {

	
	@Resource
	private QuartzService quartzService;
	/**
	 * Description goes here.
	 *
	 * @param args
	 * @throws SQLException 
	 * @since 
	 */
	@RequestMapping("/list")
	public ModelAndView findAll() throws SQLException {
		List<QuartzTrigger> quartzTriggerList = quartzService.findAll();
		ModelAndView mav = new ModelAndView("#quartz_list");
		mav.addObject("quartzTriggerList",quartzTriggerList);

		return mav;
	}

	@RequestMapping(value = "update/{action}/{triggerName}/{triggerGroup}", method = {RequestMethod.GET})
	public ModelAndView update(
			@PathVariable("action") String action,
			@PathVariable("triggerName") String triggerName,
			@PathVariable("triggerGroup") String triggerGroup) throws SQLException {
		
		ReStartJob reStartJob= new ReStartJob();
		reStartJob.updateTrigger(triggerName, triggerGroup, action);
		List<QuartzTrigger> quartzTriggerList = quartzService.findAll();
		ModelAndView mav = new ModelAndView("#quartz_list");
		mav.addObject("quartzTriggerList",quartzTriggerList);

		return mav;
	}
}
