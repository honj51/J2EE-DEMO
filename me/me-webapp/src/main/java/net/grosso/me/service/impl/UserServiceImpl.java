package net.grosso.me.service.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import net.grosso.me.dao.IbatisUserDao;
import net.grosso.me.dao.UserDao;
import net.grosso.me.domain.Role;
import net.grosso.me.domain.User;

import net.grosso.me.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private UserDao userDao;
	
	private IbatisUserDao ibatisUserDao =new IbatisUserDao();


	@Override
	public void changeInfomations(User user) {
		if (user == null) {
			throw new IllegalArgumentException("user为null");
		}
		
		if (user.getId() == null) {
			logger.debug("保存实体");
			userDao.save(user);
			return;
		}
		
		User mergedUser = userDao.findOne(user.getId());
		if (mergedUser == null) {
			logger.warn("没有找到要更新的实体");
			return;
		}
		
		logger.debug("更新实体");
		mergedUser.setEmails(user.getEmails());
		mergedUser.setName(user.getName());
		mergedUser.setGender(user.getGender());
		userDao.save(mergedUser);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public boolean exists(Integer id, String password) {
		User user = findUserById(id);
		
		if (user != null) {
			String md5Pwd = DigestUtils.md5Hex(password);
			if (md5Pwd.equals(user.getPassword())) {
				return true;
			} else {
				logger.debug("密码不正确");
			}
		} else {
			logger.debug("没有找到实体");
		}
		return false;
	}

	@Override
	public void changePassword(Integer id, String password) {
		User user = userDao.findOne(id);
		if (user == null) {
			logger.debug("没有找到实体");
		} else {
			user.setPassword(DigestUtils.md5Hex(password));
			userDao.save(user);
		}
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}

	@Override
	public boolean hasRole(int userId, String roleName) {
		User user = userDao.findOne(userId);
		
		if (user == null) return false;
		for (Role role : user.getRoles()) {
			if (role.getName().equals(roleName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void lock(Integer userId) {
		User user = userDao.findOne(userId);
		user.setLock(User.Lock.LOCKED);
		userDao.save(user);
	}

	@Override
	public void unlock(Integer userId) {
		User user = userDao.findOne(userId);
		user.setLock(User.Lock.NON_LOCKED);
		userDao.save(user);
	}

	@Override
	public void save(User user) {
		userDao.save(user);	
	}

	@Override
	public void update(User user) throws SQLException {
		ibatisUserDao.update(user);		
	}
	

}
