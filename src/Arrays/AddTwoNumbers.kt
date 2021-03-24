import Arrays.ListNode

class ListNode2(var `val`: Int) {
    var next: ListNode? = null
}
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Iter = l1
        var l2Iter = l2
        var sum: ListNode? = null
        var sumHead: ListNode? = sum
        var carryOver = 0
        do {
            if(l1Iter==null) {
                while(l2Iter!=null) {
                    //if(carryOver==1) {
                        var localSum = l2Iter?.`val` + carryOver
                        carryOver = localSum/10
                        localSum = localSum%10
                        l2Iter?.`val` = localSum

                   // }
                    if(sum==null) {
                        sum = l2Iter
                        sumHead = sum
                      //  sum = sumHead?.next
                    } else {
                        sum.next = l2Iter
                        sum = sum?.next
                    }
                    l2Iter = l2Iter.next
                }
            } else if(l2Iter==null) {
                while(l1Iter!=null) {
                    //if(carryOver==1) {

                    var localSum = l1Iter?.`val` + carryOver
                    carryOver = localSum/10
                    localSum = localSum%10
                    l1Iter?.`val` = localSum
                    //}
                    if(sum==null) {
                        sum = l1Iter
                        sumHead = sum
                      //  sum = sumHead?.next
                    } else {
                        sum.next = l1Iter
                        sum = sum?.next
                    }
                    l1Iter = l1Iter.next
                }
            } else {
                var localSum = l1Iter?.`val` + l2Iter?.`val` + carryOver
                carryOver = localSum/10
                localSum = localSum%10
                if(sum==null) {
                    sum = ListNode(localSum)
                    sumHead = sum
                  //  sum = sumHead?.next
                } else {
                    sum.next = ListNode(localSum)
                    sum = sum?.next
                }
                l1Iter = l1Iter?.next
                l2Iter = l2Iter?.next
            }
        } while(l1Iter!=null || l2Iter!=null)
        if(carryOver==1) {
            sum?.next = ListNode(1)
        }
        return sumHead
    }
}
fun main(args:Array<String>) {
    /*var l1:Arrays.ListNode? = Arrays.ListNode(2)
    l1?.next = Arrays.ListNode(4)
    l1?.next?.next = Arrays.ListNode(3)
    //l1?.next?.next?.next = Arrays.ListNode(7)

    var l2:Arrays.ListNode? = Arrays.ListNode(5)
    l2?.next = Arrays.ListNode(6)
    l2?.next?.next = Arrays.ListNode(4)
    //l2?.next?.next?.next = Arrays.ListNode(10)
    //l2?.next?.next?.next?.next = Arrays.ListNode(16)*/

    /*var l1:Arrays.ListNode? = Arrays.ListNode(0)
    var l2:Arrays.ListNode? = Arrays.ListNode(0)*/

    var l1: ListNode? = ListNode(9)
    l1?.next = ListNode(9)
    l1?.next?.next = ListNode(9)
    l1?.next?.next?.next = ListNode(9)
    l1?.next?.next?.next?.next= ListNode(9)
    l1?.next?.next?.next?.next?.next = ListNode(9)
    l1?.next?.next?.next?.next?.next?.next = ListNode(9)

    var l2: ListNode? = ListNode(9)
    l2?.next = ListNode(9)
    l2?.next?.next = ListNode(9)
    l2?.next?.next?.next = ListNode(9)



    var l3 = AddTwoNumbers().addTwoNumbers(l1, l2)

    while(l3!=null) {
        print("${l3.`val`} ")
        l3 = l3.next
    }
}