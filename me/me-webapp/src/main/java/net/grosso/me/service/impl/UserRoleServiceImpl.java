package net.grosso.me.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import net.grosso.me.dao.IbatisUserDao;
import net.grosso.me.dao.IbatisUserRoleDao;
import net.grosso.me.dao.UserDao;
import net.grosso.me.domain.Role;
import net.grosso.me.domain.User;
import net.grosso.me.domain.UserRole;

import net.grosso.me.service.UserRoleService;
import net.grosso.me.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private IbatisUserRoleDao ibatisUserRoleDao =new IbatisUserRoleDao();

	@Override
	public List<UserRole> getAllUserRoles() throws SQLException {		
		return ibatisUserRoleDao.getAllUserRoles();
	}


}
