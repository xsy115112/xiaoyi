package com.sogou.xiaoyi.list;

public class FindKthList {
	
	static class ListNode{
		int val;
		ListNode next = null;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode findKthToTail(ListNode head,int k) {
		if(head == null || k <= 0) {
			return null;
		}
		ListNode p = head,q = head;
		int count = 0;
		while(p != null) {
			p = p.next;
			count++;
			if(count > k && p != null) {
				q = q.next;
			}
		}
		if(count < k) {
			return null;
		}
		return q;
	}
}