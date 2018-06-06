/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(-1);
        ListNode headptr = head;

		ListNode ptr1=l1;
		ListNode ptr2=l2;

		int carry = 0;


		while(ptr1!=null & ptr2!=null) {
			int sum = ptr1.val + ptr2.val + carry;

			carry = sum / 10;
			int digit = sum % 10;

			ListNode newNode = new ListNode(digit);
            headptr.next=newNode;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
            headptr=newNode;
		}

		while (ptr1 != null) {
			int sum = ptr1.val + carry;
			carry = sum / 10;
			int digit = sum % 10;
			ListNode newNode = new ListNode(digit);
            headptr.next=newNode;
			ptr1 = ptr1.next;
            headptr=newNode;
		}

        while (ptr2 != null) {
			int sum = ptr2.val + carry;
			carry = sum / 10;
			int digit = sum % 10;
			ListNode newNode = new ListNode(digit);
            headptr.next=newNode;
			ptr2 = ptr2.next;
            headptr=newNode;
		}
        
		if (carry > 0){
            ListNode newNode = new ListNode(carry);
            headptr.next=newNode;
        }
			

		return head.next;
    }
}
