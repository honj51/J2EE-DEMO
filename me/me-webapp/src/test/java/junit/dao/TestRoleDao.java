package junit.dao;

import java.util.List;

import javax.annotation.Resource;

import net.yingzhuo.me.dao.RoleDao;
import net.yingzhuo.me.domain.Role;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({"classpath:spring-jpa.xml", "classpath:spring-beans.xml"})
public class TestRoleDao extends AbstractJUnit4SpringContextTests {

	@Resource
	public RoleDao roleDao;
	
	@Test
	public void test1() {
		List<Role> roles = roleDao.findAll();
		
		for (Role role : roles) {
			System.out.println(role.getName());
		}
	}
	
	@Test
	public void test2() {
		Role role = roleDao.findOne(1);
		System.out.println(role.getName());
	}
	
	@Test
	public void test3() {
		System.out.println(roleDao.count());
	}
	
	@Test
	public void test4() {
		System.out.println(roleDao.findByName("ROLE_ADMIN"));
	}
}
