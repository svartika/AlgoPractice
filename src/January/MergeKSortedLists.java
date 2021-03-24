package January;

public class MergeKSortedLists {

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
        private ListNode merge2Lists(ListNode l1, ListNode l2) {
            ListNode l3 = null, l3Iter = null;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    if (l3 == null) {
                        l3 = l1;
                        l3Iter = l3;
                    } else {
                        l3Iter.next = l1;
                        l3Iter = l3Iter.next;
                    }
                    l1 = l1.next;
                } else {
                    if (l3 == null) {
                        l3 = l2;
                        l3Iter = l3;
                    } else {
                        l3Iter.next = l2;
                        l3Iter = l3Iter.next;
                    }
                    l2 = l2.next;
                }
            }
            while (l1 != null) {
                if (l3 == null) {
                    l3 = l1;
                    l3Iter = l3;
                } else {
                    l3Iter.next = l1;
                    l3Iter = l3Iter.next;
                }
                l1 = l1.next;

            }
            while (l2 != null) {
                if (l3 == null) {
                    l3 = l2;
                    l3Iter = l3;
                } else {
                    l3Iter.next = l2;
                    l3Iter = l3Iter.next;
                }
                l2 = l2.next;

            }
            return l3;
        }

        private ListNode mergeLists(ListNode[] lists, int start, int end) {
            int mid = (end + start) / 2;
            if (end - start == 1) {
                return merge2Lists(lists[start], lists[end]);
            }

            if(start==end) return lists[start];

            ListNode l1 = mergeLists(lists, start, mid);
            ListNode l2 = mergeLists(lists, mid + 1, end);
            return merge2Lists(l1, l2);

        }

        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length<1) {
                return null;
            }
            ListNode merged = mergeLists(lists, 0, lists.length - 1);
            return merged;
        }


    }

    public static void main(String args[]) {
        ListNode l1 = new MergeKSortedLists().new ListNode(1);
        l1.next = new MergeKSortedLists().new ListNode(4);
        l1.next.next = new MergeKSortedLists().new ListNode(5);

        ListNode l2 = new MergeKSortedLists().new ListNode(1);
        l2.next = new MergeKSortedLists().new ListNode(3);
        l2.next.next = new MergeKSortedLists().new ListNode(4);

        ListNode l3 = new MergeKSortedLists().new ListNode(2);
        l3.next = new MergeKSortedLists().new ListNode(6);

        ListNode l4 = new MergeKSortedLists().new ListNode(7);
        l4.next = new MergeKSortedLists().new ListNode(14);
        l4.next.next = new MergeKSortedLists().new ListNode(21);
        l4.next.next.next = new MergeKSortedLists().new ListNode(28);

        ListNode l5 = new MergeKSortedLists().new ListNode(8);
        l5.next = new MergeKSortedLists().new ListNode(16);
        l5.next.next = new MergeKSortedLists().new ListNode(32);

        ListNode l6 = new MergeKSortedLists().new ListNode(2);
        l6.next = new MergeKSortedLists().new ListNode(4);
        l6.next.next = new MergeKSortedLists().new ListNode(6);
        l6.next.next.next = new MergeKSortedLists().new ListNode(8);
        l6.next.next.next.next = new MergeKSortedLists().new ListNode(10);

        ListNode[] lists = new ListNode[]{l1, l2, l3, l4, l5, l6};
        ListNode mergedList = new MergeKSortedLists().new Solution().mergeKLists(lists);
        while(mergedList!=null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
