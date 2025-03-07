/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size =0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        ListNode t =head;
        int idx = size - n;
        int i =1;
        if (idx == 0) {
            return head.next;
        }

        while(i < idx){
            t = t.next;
            i++;
        }
        t.next = t.next.next;
        return head;
    }
}