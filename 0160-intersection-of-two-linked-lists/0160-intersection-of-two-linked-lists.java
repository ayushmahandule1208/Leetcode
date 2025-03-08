/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // HashSet<ListNode> set= new HashSet<>();
        // while(headA!=null){
        //   set.add(headA);
        //   headA = headA.next;
        // }
        // while(headB!=null){
        //   if(set.contains(headB)){
        //     return headB;
        //   }
        //   headB = headB.next;
        // }
        // return null;

         if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while(ptrA != ptrB){
            if(ptrA == null){
                ptrA = headB;
            }
            else{
                ptrA = ptrA.next;
            }
            if(ptrB == null){
                ptrB = headA;
            }
            else{
                ptrB = ptrB.next;
            }
        }
        return ptrB;
    }
}