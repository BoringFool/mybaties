package mybaites.test;

import org.junit.Test;

import com.zm.entity.SingleLinkedList;

public class Test_linklist {
	@Test
	public void test_list() {
		SingleLinkedList singleList = new SingleLinkedList();
		singleList.addHead("A");
		singleList.addHead("B");
		singleList.addHead("C");
		singleList.addHead("D");
		// 打印当前链表信息
		singleList.display();
		// 删除C
		singleList.delete("C");
		singleList.display();
		// 查找B
		System.out.println(singleList.find("B"));
	}

	@Test
	public void test_a() {
		System.out.println(18 % 10);
	}


}
