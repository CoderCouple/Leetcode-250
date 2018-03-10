/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>n)
	        return null;

	        if(n-m==0)
	            return head;
	        
	        reverseList(head,m,n,1,head,head);
	        return head;
	    }

	 static void reverseList(ListNode head, int m, int n,int count, ListNode revStart,ListNode curr) {
	     if(count>n)
	         return;
	     if(count==m)
	         revStart=curr;
	     int value=curr.val;
	     reverseList(head,m,n,count+1,revStart,curr.next);
	     if(m<=count && count<=n){
	         ListNode ptr= revStart;
	         for(int i=0;i<=n-count-1;i++)
	         {
	             revStart=revStart.next;
	         }
	         revStart.val=value;
	     }
}

}
