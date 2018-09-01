import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.UserService;

public class TestService {

	@SuppressWarnings("resource")
	@Test
	public void serviuceTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userservice = (UserService) ctx.getBean("userservice");
		userservice.test();
	}
}
