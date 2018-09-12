package mybaites.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.entity.Goods;
import com.zm.entity.Order;
import com.zm.service.GoodsService;
import com.zm.service.OrderService;

public class Test_Order {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	OrderService serviceO = (OrderService) ctx.getBean("orderservice");
	GoodsService serviceG = (GoodsService) ctx.getBean("goodsservice");

	@SuppressWarnings("deprecation")
	@Test
	public void test_save() {
		Order o = new Order();
		Date d = new Date();
		Goods g = serviceG.showDetail(1);
		Calendar c = Calendar.getInstance();
		o.setDateO(Long.toString(d.getTime()));
		o.setDateP(Integer.toString(d.getDate()));
		o.setGood(g);
		o.setNumber(11);
		serviceO.save(o);
		System.out.println();

	}
}
