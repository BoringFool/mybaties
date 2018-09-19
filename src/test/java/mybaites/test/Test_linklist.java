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

					curr.next = new Node('n');
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

	public int romanToInt(String s) {
		int re = 0;
		for (int i = 0; i < s.length(); i++) {
			int n = i == s.length() - 1 ? 0 : 1;
			switch (s.charAt(i)) {
			case 'V':
				re += 5;
				break;

			case 'L':
				re += 50;
				break;

			case 'D':
				re += 500;
				break;

			case 'M':
				re += 1000;
				break;

			default:
				switch (s.charAt(i)) {
				case 'I':
					if (s.charAt(i + n) == 'V') {
						re += 4;
						i = i + 1;
					} else if (s.charAt(i + n) == 'X') {
						re += 9;
						i = i + 1;
					} else {
						re += 1;
					}
					;
					break;

				case 'X':
					if (s.charAt(i + n) == 'L') {
						re += 40;
						i = i + 1;
					} else if (s.charAt(i + n) == 'C') {
						re += 90;
						i = i + 1;
					} else {
						re += 10;
					}
					;
					break;

				case 'C':
					if (s.charAt(i + n) == 'D') {
						re += 400;
						i = i + 1;
					} else if (s.charAt(i + n) == 'M') {
						re += 900;
						i = i + 1;
					} else {
						re += 100;
					}
					;
					break;

				}
				break;
			}
		}
		return re;
	}

	public boolean isValid(String s) {
		Node h = new Node('a');
		Node c = h;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				Node a = new Node(s.charAt(i));
				a.next = c;
				c = a;
			} else {
				switch (s.charAt(i)) {
				case '}':
					if (c.val != '{')
						return false;
					c = c.next;
					break;

				case ')':
					if (c.val != '(')
						return false;
					c = c.next;
					break;

				case ']':
					if (c.val != '[')
						return false;
					c = c.next;
					break;
				}
			}
		}

		return c.val == 'a' ? true : false;

	}

	private class Node {
		char val;
		Node next;

		public Node(char data) {
			this.val = data;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		ListNode c = l1;
		ListNode ced = l2;
		ListNode r = l1;
		ListNode ced_f = null;
		boolean i = true;
		while (c != null) {
			if (c.val < ced.val) {
				r = c.val < r.val ? c : r;
				ListNode tem = c.next;
				c.next = ced;
				if (i) {
					ced_f = c;
					i = false;
				} else {
					ced_f.next = c;
					ced_f = c;
				}

				c = tem;
			} else if (c.val == ced.val) {
				if (i) {
					r = ced;
					i = false;
				}
				ced_f = ced;
				ListNode tem = c.next;
				ListNode t = ced.next;
				ced.next = c;
				c.next = t;
				ced = c;

				c = tem;
			} else {
				if (i) {
					r = l2;
					i = false;
				}
				ced.next = mergeTwoLists(c, ced.next);
				return r;
			}
		}
		return r;

	}

	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		return searchInsert(nums, target, 0);

	}

	public int searchInsert(int[] nums, int target, int len) {
		// 终止条件
		if (nums.length == 1) {
			if (nums[0] >= target) {
				return len;
			} else {
				return len + 1;
			}
		}
		int l = nums.length >> 1;
		int over = nums.length % 2 == 1 ? l + 1 : l;
		if (nums[l - 1] == target) {
			return l - 1 + len;
		} else if (nums[l - 1] > target) {
			int[] copy = new int[l];
			for (int i = 0; i < l; i++) {
				copy[i] = nums[i];
			}
			return searchInsert(copy, target, len);
		} else {
			int[] copy = new int[over];
			for (int i = 0; i < over; i++) {
				copy[i] = nums[l + i];
			}
			return searchInsert(copy, target, len + l);
		}
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}

		String a = countAndSay(--n);
		if (a.length() == 1) {
			return "11";

		}
		StringBuffer b = new StringBuffer();
		int count = 1;
		for (int i = 0; i < a.length() - 1; i++) {
			if (a.charAt(i) == a.charAt(i + 1)) {
				if(i==a.length()-2) {
					b.append(++count);
					b.append(a.charAt(i));
				};
				count++;
			} else {
				b.append(count);
				b.append(a.charAt(i));
				count = 1;
				if(i==a.length()-2) {
					b.append(count);
					b.append(a.charAt(i+1));
				}
			}
		}
		return b.toString();
	}

	@Test
	public void test_sysout() {
		String c = countAndSay(5);
		System.out.println(c);
	}
}
