package junit;

import net.grosso.me.util.uuid.UUIDUtils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({"classpath:spring-jpa.xml", "classpath:spring-beans.xml"})
public class TestConfig extends AbstractJUnit4SpringContextTests {

	@Value("#{constant['me.author.name']}")
	private String author;

	@Test
	public void test() {
		System.out.println(author);
		
		for (int i=0; i<200; i++) {
			System.out.println(UUIDUtils.randomUUID());
		}
	}
}
