/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
		for(ListNode now = list1; now != null; now = now.next) {
			stack1.push(now.val);
		}
		for(ListNode now = list2; now != null; now = now.next) {
			stack2.push(now.val);
		}
		ListNode curr = null;
		int carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			int sum = carry;
			if(!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			carry = (sum >= 10) ? 1 : 0;
			sum %= 10;
			ListNode newNode = new ListNode(sum);
			newNode.next = curr;
			curr = newNode;
		}
		if(carry == 1) {
			ListNode newNode = new ListNode(1);
			newNode.next = curr;
			curr = newNode;
		}
		return curr;
	}
}
