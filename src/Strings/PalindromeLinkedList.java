package Strings;

public class PalindromeLinkedList {
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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            ListNode start = head;
            ListNode last = head;
            ListNode midNode = head;
            int i = 0, size = 1;

            while (last.next != null) {
                last = last.next;
                size++;
            }

            int mid = size / 2 + 1;
            for (int j = 1; j < mid; j++) {
                midNode = midNode.next;
            }

            float resStart = 0, resEnd = 0, sizeFrom = 0;
            float sizeUpTo = size%2==0? mid-2 : mid-1;
            while (mid <= size) {
                resStart += start.val * Math.pow(10, sizeUpTo--);
                resEnd += midNode.val * Math.pow(10, sizeFrom++);
                mid++;
                start = start.next;
                midNode = midNode.next;
            }
            if (resStart == resEnd) return true;
            else return false;
        }
    }
    public  static void main(String args[]) {
        /*PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(1);
        l1.next = new PalindromeLinkedList().new ListNode(2);
        l1.next.next = new PalindromeLinkedList().new ListNode(3);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(4);
        l1.next.next.next.next = new PalindromeLinkedList().new ListNode(5);*/

        /*PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(1);
        l1.next = new PalindromeLinkedList().new ListNode(2);
        l1.next.next = new PalindromeLinkedList().new ListNode(3);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(4);
        l1.next.next.next.next = new PalindromeLinkedList().new ListNode(5);
        l1.next.next.next.next.next = new PalindromeLinkedList().new ListNode(6);*/

        /*PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(1);
        l1.next = new PalindromeLinkedList().new ListNode(2);
        l1.next.next = new PalindromeLinkedList().new ListNode(3);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(2);
        l1.next.next.next.next = new PalindromeLinkedList().new ListNode(1);*/

        /*PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(-129);
        l1.next = new PalindromeLinkedList().new ListNode(-129);*/

        /*PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(-129);
        l1.next = new PalindromeLinkedList().new ListNode(-23);
        l1.next.next = new PalindromeLinkedList().new ListNode(23);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(-129);*/

       /* PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(-129);
        l1.next = new PalindromeLinkedList().new ListNode(-23);
        l1.next.next = new PalindromeLinkedList().new ListNode(-23);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(-129);*/

         /*PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(1);
        l1.next = new PalindromeLinkedList().new ListNode(3);
        l1.next.next = new PalindromeLinkedList().new ListNode(2);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(4);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(3);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(2);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(1);*/

        PalindromeLinkedList.ListNode l1 = new PalindromeLinkedList().new ListNode(-16557);
        l1.next = new PalindromeLinkedList().new ListNode(-8725);
        l1.next.next = new PalindromeLinkedList().new ListNode(-29125);
        l1.next.next.next = new PalindromeLinkedList().new ListNode(28873);
        l1.next.next.next.next = new PalindromeLinkedList().new ListNode(-21702);
        l1.next.next.next.next.next = new PalindromeLinkedList().new ListNode(15483);
        l1.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-28441);
        l1.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-17845);
        l1.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-4317);
        l1.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-10914);
        l1.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-10914);
        l1.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-4317);
        l1.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-17845);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-28441);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(15483);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-21702);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(28873);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-29125);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-8725);
        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new PalindromeLinkedList().new ListNode(-16557);

        System.out.println(new PalindromeLinkedList().new Solution().isPalindrome(l1));
    }
}
