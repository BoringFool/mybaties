package mybaites.test;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.dao.UserDao;
import com.zm.entity.Te;
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
		map.put("age", "15");
		User u = userservice.selectTwoArg(map);
		System.out.println(u);
	}

	@SuppressWarnings("resource")
	@Test
	public void serviuce_getByName_Test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userservice = (UserService) ctx.getBean("userservice");
		User user = new User();
		user.setUsername("注册");
		int u = userservice.register(user);
		System.out.println(u);

	}

	@SuppressWarnings("unused")
	@Test
	public void anyTest() {
		Te t = new Te("");

	}

	@Test
	public void test_str() {
		int[] a = { -2, 7, 2, 15 };
		int[] b = twoSum(a, 4);
		System.out.println(b);
	}

	public int strStr(String haystack, String needle) {
		if ("".equals(needle)) {
			return 0;
		} else if (haystack.length() < needle.length()) {
			return -1;
		} else {
			int inde = -1;
			boolean r = true;
			char[] hay = haystack.toCharArray();
			char[] nee = needle.toCharArray();
			int diff = hay.length - nee.length;
			for (int i = 0; i <= diff; i++) {
				if ((hay[i] == nee[0])) {

					for (int j = 1; j < nee.length; j++) {
						if (!(nee[j] == hay[i + j])) {
							r = false;
							break;
						}
					}
					if (r) {
						inde = i;
						break;
					} else {
						r = true;
					}
				}
			}
			return inde;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No solution");
	}
}
