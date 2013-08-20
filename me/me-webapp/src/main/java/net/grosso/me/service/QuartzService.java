package net.grosso.me.service;

import java.util.List;

import net.grosso.me.domain.QuartzTrigger;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface QuartzService {

	
	public List<QuartzTrigger> findAll();

}
