package net.grosso.me.service;

import net.grosso.me.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface UserService {

	@Transactional
	public void changeInfomations(User user);

	@Transactional
	public void changePassword(Integer id, String password);
	
	@Transactional
	public void save(User user);

	public User findUserById(Integer id);

	public boolean exists(Integer id, String password);

	public Page<User> findAll(Pageable pageable);

	public boolean hasRole(int userId, String roleName);

	@Transactional
	public void lock(Integer userId);

	@Transactional
	public void unlock(Integer userId);
}
