package mybaites.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public void lengthOfLongestSubstring() {
		String s = "abcabcbbjjshsgggauwoghssowowssff";
		System.out.println("a bcabcbbjjshsgggauwoghssowowssff");
		int result = 0;
		int j = 0;
		HashMap<Character, Integer> check = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char g = s.charAt(i);
			if (check.containsKey(g) && check.get(g) + 1 > j) {
				j = check.get(g) + 1;
			}
			check.put(g, i);
			int a = i - j + 1;
			result = a > result ? a : result;
		}
		System.out.println(result);
		System.out.println(lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int j = 0;
		HashMap<Character, Integer> check = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char g = s.charAt(i);
			if (check.containsKey(g)) {
				int a = i - j + 1;
				result = a > result ? a : result;
				j = (check.get(g) + 1) <= j ? j : (check.get(g) + 1);
				check.put(g, i);
			} else {
				check.put(g, i);
				int a = i - j + 1;
				result = a > result ? a : result;
			}
		}
		return result;

	}

	@Test
	public void lengthOfLongestSubstring_FAILED() {
		String in = "abcabcbbdaaa";
		char[] all = in.toCharArray();

		List<Character> copy = new ArrayList<>();
		for (int j = 0; j < all.length; j++) {
			if (!copy.contains(all[j])) {
				copy.add(all[j]);
			}
		}

		System.out.println(copy + " copy");

		int leng = copy.size();

		System.out.println(leng + " copy length");

		List<Node> compa = new ArrayList<>();
		for (int i = 0; i < leng; i++) {
			compa.add(new Node(copy.get(i)));
		}

		System.out.println(compa + " compa");

		for (int i = 0; i < leng; i++) {
			Node curr = compa.get(i);
			for (int j = 0; j < all.length; j++) {
				if (copy.get(i) == all[j]) {

					curr.next = new Node(j);
					curr = curr.next;
				}
			}
		}

		Iterator<Node> it = compa.iterator();
		while (it.hasNext()) {
			Node n = it.next();
			System.out.println(n.val + " " + n.next.next.next.val);
		}

	}

	private class Node {
		int val;
		Node next;

		public Node(int data) {
			this.val = data;
		}
	}

	@Test
	public void i() {
		String s = "abcabcbbdaaa";
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		System.out.println(ans);
	}

	@Test
	public void test_sysout() {
		System.out.println(isPalindrome(121));
	}

	public boolean isPalindrome(int x) {
		if (x < 10 && x > 0)
			return true;
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int re = 0;
		for (int i = x; i > 0;) {
			re = re * 10 + i % 10;
			i = i / 10;
		}
		return x == re;
	}
}
