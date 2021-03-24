package LinkedLists;

public class LinkedListCycle {

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
        public boolean hasCycle(ListNode head) {
            if(head==null || head.next==null) return false;
            ListNode fast = head.next, slow = head;
            while (fast != null) {
                if (slow == fast) return true;

                if(fast.next==null || fast.next.next==null) return false;
                else fast = fast.next.next;

                slow = slow.next;
            }
            return false;
        }
    }

    public static void main(String args[]) {

        /*LinkedListCycle.ListNode l1 = new LinkedListCycle().new ListNode(3);
        ListNode node = new LinkedListCycle().new ListNode(2);
        l1.next = node;
        l1.next.next = new LinkedListCycle().new ListNode(0);
        l1.next.next.next = new LinkedListCycle().new ListNode(-4);
        l1.next.next.next.next = node;
*/

       /* LinkedListCycle.ListNode l1 = new LinkedListCycle().new ListNode(1);
        l1.next = new LinkedListCycle().new ListNode(2);
        l1.next.next = l1;*/

       // LinkedListCycle.ListNode l1 = new LinkedListCycle().new ListNode(1);

        LinkedListCycle.ListNode l1 = new LinkedListCycle().new ListNode(3);
        l1.next = new LinkedListCycle().new ListNode(2);
        l1.next.next = new LinkedListCycle().new ListNode(0);
        l1.next.next.next = new LinkedListCycle().new ListNode(-4);

        System.out.println(new LinkedListCycle().new Solution().hasCycle(l1));
    }
}
