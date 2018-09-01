import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.dao.UserDao;
import com.zm.service.UserService;

public class TestService {

	@SuppressWarnings("resource")
	@Test
	public void daoTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userdao = (UserDao) ctx.getBean("userdao");
		userdao.test_sqlsessiontemplate();
	}

	@SuppressWarnings("resource")
	@Test
	public void serviuceTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userservice = (UserService) ctx.getBean("userservice");
		userservice.test();
	}

	@Test
	public void anyTest() {
		System.out.println("********************************************************");
	}
}
