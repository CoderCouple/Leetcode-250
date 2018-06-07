/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first=l1;
        ListNode second=l2;
        ListNode result=new ListNode(1);
        ListNode finalResult = result;
        if(l1==null || l2==null)
            return l1==null ? l2 : l1;

        while(first!=null && second!=null){
            if(first.val<=second.val){
                result.next=first;
                first=first.next;
                result=result.next;
            } else {
                result.next=second;
                second=second.next;
                result=result.next;
            }
        }
            
        if(first!=null)
            result.next=first;
        
        if(second!=null)
            result.next=second;
        
        return finalResult.next;
    }
    
}
