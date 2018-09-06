package mybaites.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.entity.Goods;
import com.zm.service.GoodsService;

public class GoodsTest {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	GoodsService goodsservice = (GoodsService) ctx.getBean("goodsservice");

	@Test
	public void test_save() {
		Goods g = new Goods();
		g.setName("zza");
		g.setNumberStore(111);
		g.setPrice(11);
		g.setProvider("date");
		goodsservice.save(g);
	}

	@Test
	public void test_SelectAll() {
		List<Goods> listG = goodsservice.selectAll();
		Iterator<Goods> it = listG.iterator();
		while (it.hasNext()) {
			Goods g = it.next();
			System.out.println(g.getName());
		}
	}
}
