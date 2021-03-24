package Arrays

import java.util.*

class MergeTwoSortedArrays {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var j = 0
        var k = 0
        var nums3: IntArray = IntArray(m)
        for(i in 0..m-1) nums3[i]=nums1[i]

        for (i in 0..nums1.size) {
            if (k<m && j<n ) {
                if (nums2[j] < nums3[k]) {
                    nums1[i] = nums2[j++]
                } else {
                    nums1[i] = nums3[k++]
                }
            } else if(k<m){
                nums1[i] = nums3[k++]
            } else if(j<n) {
                nums1[i] = nums2[j++]
            }
        }
    }
}

fun main(args: Array<String>) {
    var nums1 = intArrayOf(1, 2, 3, 0, 0, 0);
    var m = 3
    var nums2 = intArrayOf(2, 5, 6)
    var n = 3
    MergeTwoSortedArrays().merge(nums1, m, nums2, n);
    println(Arrays.toString(nums1))
}