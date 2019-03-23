package com.roc.api.trace.core;

public class ReverseList {
	
	static class ListNode{
		int val;
		ListNode next = null;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}