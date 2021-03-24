package LinkedLists;


public class RemoveNthNodeFromEndOfList {


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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p = null;
            int i=1, j=0;
            ListNode current = head;


            while(current!=null) {

                if(i-j==n+1) {
                    p = p==null? head: p.next;
                    j++;
                }
                if(current.next==null) {
                    if(p==null) head=head.next;
                    else {
                        if (p.next != null) p.next = p.next.next;
                        else p.next = null;
                    }
                }
                current = current.next;
                i++;
            }
            return head;
        }
    }

    public static void main(String args[]) {
        /*RemoveNthNodeFromEndOfList.ListNode l1 = new RemoveNthNodeFromEndOfList().new ListNode(1);
        l1.next = new RemoveNthNodeFromEndOfList().new ListNode(2);
        l1.next.next = new RemoveNthNodeFromEndOfList().new ListNode(3);
        l1.next.next.next = new RemoveNthNodeFromEndOfList().new ListNode(4);
        l1.next.next.next.next = new RemoveNthNodeFromEndOfList().new ListNode(5);
        int n =2 ;*/

        /*RemoveNthNodeFromEndOfList.ListNode l1 = new RemoveNthNodeFromEndOfList().new ListNode(1);
        int n = 1;*/

        /*RemoveNthNodeFromEndOfList.ListNode l1 = new RemoveNthNodeFromEndOfList().new ListNode(1);
        l1.next = new RemoveNthNodeFromEndOfList().new ListNode(2);
        int n = 1;*/

        RemoveNthNodeFromEndOfList.ListNode l1 = new RemoveNthNodeFromEndOfList().new ListNode(1);
        l1.next = new RemoveNthNodeFromEndOfList().new ListNode(2);
        int n = 2;

        ListNode list = new RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd(l1, n);

        while(list!=null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}
