package Arrays.RemoveDuplicatesFromSortedLL

/**
 * Example:
 * var li = Arrays.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class Arrays.ListNode(var `val`: Int) {
 *     var next: Arrays.ListNode? = null
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var newHead = head
        var iter = head
        var prev: ListNode? = null
        while(iter!=null) {
            var lengthToCollapse = 0
            var localIter = iter
            while(localIter!=null && localIter.`val` == localIter.next?.`val`) {
                lengthToCollapse++
                localIter = localIter.next
            }
            if(lengthToCollapse==0) {
                prev = iter
                iter = iter.next
            } else {
                for(i in 1..lengthToCollapse+1) {
                    iter = iter?.next
                    if(i==lengthToCollapse) {
                        if(prev!=null) {
                            prev.next = iter?.next
                        } else {
                            newHead = iter?.next
                        }
                    }
                }
            }
        }
        return newHead
    }
}

fun main(args: Array<String>) {
    var head:ListNode? = ListNode(1)
    head?.next = ListNode(1)
    head?.next?.next = ListNode(1)
    head?.next?.next?.next = ListNode(2)
    head?.next?.next?.next?.next = ListNode(3)

/*    var head:Arrays.ListNode? = Arrays.ListNode(1)
    head?.next = Arrays.ListNode(2)
    head?.next?.next = Arrays.ListNode(3)
    head?.next?.next?.next = Arrays.ListNode(3)
    head?.next?.next?.next?.next = Arrays.ListNode(3)
    head?.next?.next?.next?.next?.next = Arrays.ListNode(4)
    head?.next?.next?.next?.next?.next?.next = Arrays.ListNode(4)
    head?.next?.next?.next?.next?.next?.next?.next = Arrays.ListNode(5)*/

    var newHead = Solution().deleteDuplicates(head)

    while(newHead!=null) {
        print("${newHead.`val`} ")
        newHead = newHead.next
    }
}