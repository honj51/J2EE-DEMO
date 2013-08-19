

package net.grosso.me.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import net.grosso.me.dao.QuartzDao;
import net.grosso.me.domain.QuartzTrigger;
import net.grosso.me.service.QuartzService;

@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {

	private QuartzDao quartzDao = new QuartzDao();

	@Override
	public List<QuartzTrigger> findAll() throws SQLException {
		return quartzDao.findAll();
	}

}
