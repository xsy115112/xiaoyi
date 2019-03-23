package com.sogou.xiaoyi.array;

public class RemoveNthFromEndKthList {
	
	static class ListNode{
		int val;
		ListNode next = null;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode findKthToTail(ListNode head,int k) {
		ListNode s = new ListNode(0);
        s.next = head;
        ListNode p = s, q = s;
        int count = 0;
        while(p != null){
            p = p.next;
            count++;
            if(count > k && p != null){
                q = q.next;
            }
        }
        q.next = q.next.next;    
        return s.next;
	}
}