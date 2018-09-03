import java.util.HashMap;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.dao.UserDao;
import com.zm.entity.User;
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
	public void serviuce_save_Test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userservice = (UserService) ctx.getBean("userservice");
		User user = new User();
		user.setAge(15);
		user.setPassword("614");
		user.setUsername("开始s");
		userservice.save(user);
	}

	@SuppressWarnings("resource")
	@Test
	public void serviuce_delete_Test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userservice = (UserService) ctx.getBean("userservice");
		userservice.delete(3);
	}

	@SuppressWarnings("resource")
	@Test
	public void serviuce_argumentsM_Test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userservice = (UserService) ctx.getBean("userservice");
		HashMap<String, String> map = new HashMap<>();
		map.put("username", "哈哈");
		map.put("age", "11");
		User u = userservice.selectTwoArg(map);
		System.out.println(u);
	}

	@Test
	public void anyTest() {
		System.out.println("********************************************************");
	}
}
