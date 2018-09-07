package mybaites.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.entity.Cart;
import com.zm.entity.Goods;
import com.zm.service.CartService;
import com.zm.service.GoodsService;

public class CartTest {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	CartService cartService = (CartService) ctx.getBean("cartservice");
	GoodsService goodsServicec = (GoodsService) ctx.getBean("goodsservice");

	@Test
	public void dataProvid() {
		Goods g = new Goods();
		g.setName("a4");
		g.setNumberStore(14);
		g.setPrice(44);
		g.setProvider("asd4");
		goodsServicec.save(g);
	}

	@Test
	public void test_save() {
		Goods good = goodsServicec.showDetail(4);
		Cart c = new Cart();
		c.setNumber(33);
		c.setGood(good);
		cartService.save(c);
	}

	@Test
	public void test_oneToOne() {
		Cart c = cartService.cartWithGoods(3);
		System.out.println(c.getNumber());
		System.out.println(c.getId());
		System.out.println(c.getGood().getId());
	}
}
