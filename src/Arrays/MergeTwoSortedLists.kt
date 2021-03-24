package Arrays

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

class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l2 == null) return l1
        if (l1 == null) return l2
        var l3Head: ListNode? = null
        var l3Iterator: ListNode? = null
        var l1Iterator = l1
        var l2Iterator = l2
        while (l1Iterator != null || l2Iterator != null) {

            if (l1Iterator == null) {
                l3Iterator?.next = l2Iterator
                break
            } else if (l2Iterator == null) {
                l3Iterator?.next = l1Iterator
                break
            } else {
                var num1 = l1Iterator.`val`
                var num2 = l2Iterator.`val`
                if (num1 < num2) {
                    if (l3Head == null) {
                        l3Head = l1Iterator
                        l1Iterator = l1Iterator.next
                        l3Iterator = l3Head
                    } else {
                        l3Iterator?.next = l1Iterator
                        l1Iterator = l1Iterator.next
                        l3Iterator = l3Iterator?.next
                    }
                } else {
                    if (l3Head == null) {
                        l3Head = l2Iterator
                        l2Iterator = l2Iterator.next
                        l3Iterator = l3Head
                    } else {
                        l3Iterator?.next = l2Iterator
                        l2Iterator = l2Iterator.next
                        l3Iterator = l3Iterator?.next
                    }
                }
            }

        }
        return l3Head
    }
}

fun main(args: Array<String>) {
    var l1: ListNode? = ListNode(1)
    l1?.next = ListNode(3)
    l1?.next?.next = ListNode(5)
    l1?.next?.next?.next = ListNode(7)

    var l2: ListNode? = ListNode(2)
    l2?.next = ListNode(6)
    l2?.next?.next = ListNode(8)
    l2?.next?.next?.next = ListNode(10)
    l2?.next?.next?.next?.next = ListNode(16)



    var l3 = MergeTwoSortedLists().mergeTwoLists(l1, l2)
    while (l3 != null) {
        print("${l3.`val`} ")
        l3 = l3.next
    }
    println()
    while (l1 != null) {
        print("${l1.`val`} ")
        l1 = l1?.next
    }
    println()
    while (l2 != null) {
        print("${l2.`val`} ")
        l2 = l2?.next
    }

}