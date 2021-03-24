package February;

public class CyclicLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head==null || head.next==null) return false;
            ListNode  slow = head;
            ListNode fast = head.next;
            while(fast!=null && slow!=null) {
                if(fast==slow) return true;
                slow = slow.next;
                if (fast.next==null || fast.next.next==null) return false;
                else fast = fast.next.next;
            }
            return false;
        }
    }

    public static void main(String args[]) {
        /*ListNode head = new CyclicLinkedList().new ListNode(3);
        head.next = new  CyclicLinkedList().new ListNode(2);
        head.next.next = new  CyclicLinkedList().new ListNode(0);
        head.next.next.next = new  CyclicLinkedList().new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println(new CyclicLinkedList().new Solution().hasCycle(head));*/

        ListNode head2 = new CyclicLinkedList().new ListNode(1);
        head2.next = new  CyclicLinkedList().new ListNode(2);

        System.out.println(new CyclicLinkedList().new Solution().hasCycle(head2));
    }

}
