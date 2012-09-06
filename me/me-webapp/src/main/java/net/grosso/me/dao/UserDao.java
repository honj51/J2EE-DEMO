package net.grosso.me.dao;

import net.grosso.me.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserDao extends Repository<User, Integer> {

	public long count();

	public User findOne(Integer id);

	public User findByUsername(String username);

	public User save(User user);
	
	public Page<User> findAll(Pageable pageable);
}
