package LinkedLists;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null) return null;
            ListNode remaining = head.next, reversed=null;
            reversed = head;
            reversed.next = null;
            while(remaining!=null) {
                ListNode temp = reversed;
                ListNode rest = remaining.next;
                reversed = remaining;
                reversed.next = temp;
                remaining = rest;
            }
            return reversed;
        }
    }

    public static void main(String args[]) {
       /* ReverseLinkedList.ListNode l1 = new ReverseLinkedList().new ListNode(1);
        l1.next = new ReverseLinkedList().new ListNode(2);
        l1.next.next = new ReverseLinkedList().new ListNode(3);
        l1.next.next.next = new ReverseLinkedList().new ListNode(4);
        l1.next.next.next.next = new ReverseLinkedList().new ListNode(5);*/

        //ReverseLinkedList.ListNode l1 = new ReverseLinkedList().new ListNode(1);
        //ReverseLinkedList.ListNode l1 = new ReverseLinkedList().new ListNode();
        ReverseLinkedList.ListNode l1 = null;


        ListNode reversed = new ReverseLinkedList().new Solution().reverseList(l1);

        while(reversed!=null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
