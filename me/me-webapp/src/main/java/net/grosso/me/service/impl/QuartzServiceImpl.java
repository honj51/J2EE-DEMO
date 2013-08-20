

package net.grosso.me.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.grosso.me.dao.QuartzDao;
import net.grosso.me.domain.QuartzTrigger;
import net.grosso.me.service.QuartzService;

import org.springframework.stereotype.Service;

@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {

	
	@Resource
	private QuartzDao quartzDao ;

	@Override
	public List<QuartzTrigger> findAll() {
		return quartzDao.findAll();
	}

}
