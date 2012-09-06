package junit.service;

import java.util.List;

import javax.annotation.Resource;

import net.yingzhuo.me.domain.Group;
import net.yingzhuo.me.service.ContactService;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({"classpath:spring-jpa.xml", "classpath:spring-beans.xml"})
public class TestContactService extends AbstractJUnit4SpringContextTests {

	@Resource
	private ContactService service;
	
	@Test
	public void test() {
		List<Group> list = service.findAllGroups("admin");

		for (Group group : list) {
			System.out.println(group.getName());
		}
	}
}
