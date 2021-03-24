package Arrays.intersectionOfArrays

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        var smaller: IntArray//Array<Any>
        var bigger: Array<Any>
        if(nums1.size<nums2.size) {
            smaller = nums1//.map { it }.toTypedArray()//arrayOf(nums1)
            bigger = nums2.map { it }.toTypedArray()///arrayOf(nums2)
        } else {
            bigger = nums1.map { it }.toTypedArray()//arrayOf(nums1)
            smaller = nums2//.map { it }.toTypedArray()//arrayOf(nums2)
        }
        var intersectionList :MutableList<Int> = mutableListOf<Int>()
        var k = 0
        for(numberIn1 in smaller) {
            for(j in 0..bigger.size-1) {
                if(numberIn1==bigger[j]) {
                    intersectionList.add(numberIn1.toString().toInt())//[k++] = numberIn1.toString().toInt()
                    bigger[j] = "NA"
                    break
                }
            }
        }
        return intersectionList.toIntArray()
    }
}
fun main(args:Array<String>) {
   /* var nums1 = intArrayOf(1,2,2,1)
    var nums2 = intArrayOf(2,2)*/

    var nums1 = intArrayOf(4,9,5)
    var nums2 = intArrayOf(9,4,9,8,4)
    var intersectArray = Solution().intersect(nums1, nums2)
    //print(intersectArray.toString())
    for(number in intersectArray) {
        print("$number ")
    }
}