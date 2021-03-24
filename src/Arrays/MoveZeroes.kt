package Arrays

import java.util.*

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var indexZero = 0
        var indexNonZero = 0
        while (i < nums.size) {
            if (nums[i] == 0) {
                while (indexNonZero < nums.size && nums[indexNonZero] == 0) {
                    indexNonZero++
                }
                if (indexNonZero == nums.size) return // all zeroes until end of array
                if (indexNonZero > i) { // the last non zero element is greater the given index.. interchange
                    var temp = nums[i]
                    nums[i] = nums[indexNonZero]
                    nums[indexNonZero] = temp
                }
            } else {
                indexNonZero++
            }
            i++
        }
    }
}

fun main(args: Array<String>) {
    var nums1 = intArrayOf(0,1,0,3,12)
    var nums2 = intArrayOf(0,1)
    var nums3 = intArrayOf(1, 0)
    MoveZeroes().moveZeroes(nums1)
    MoveZeroes().moveZeroes(nums2)
    MoveZeroes().moveZeroes(nums3)
    println(Arrays.toString(nums1))
    println(Arrays.toString(nums2))
    println(Arrays.toString(nums3))

    var nums4 = intArrayOf(1,0,1)
    MoveZeroes().moveZeroes(nums4)
    println(Arrays.toString(nums4))
}