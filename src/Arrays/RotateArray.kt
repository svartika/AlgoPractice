import java.util.*

class RotateArray {
   /* fun rotate(nums: IntArray, k: Int): Unit {
        var j = 0
        var valueToBeRotated = nums[0]
        var even = 1
        var valueToBeRotatedEvenLoop = nums[1]
        for(i in nums) {
            j = (j+k)%nums.size
            var temp = valueToBeRotated
            valueToBeRotated = nums[j]
            nums[j] = temp

            if(nums.size%2==0) {
                even = (even + k) % nums.size
                var temp1 = valueToBeRotatedEvenLoop
                valueToBeRotatedEvenLoop = nums[even]
                nums[even] = temp1
            }
        }
    }*/

    fun rotateInPlace(nums: IntArray, k: Int): Unit {
        var j = 0
        var valueToBeRotated = nums[0]

        for(i in nums) {
            j = (j+k)%nums.size
            var temp = valueToBeRotated
            valueToBeRotated = nums[j]
            nums[j] = temp


        }
    }
    fun reverse(startIndex: Int, endIndex: Int, nums:IntArray) {
        var mid = startIndex+ ((endIndex-startIndex)/2)
       // var j=0
        for( i in startIndex..mid) {
            var temp = nums[i]
            nums[i] = nums[endIndex-i+startIndex]
            nums[endIndex-i+startIndex] = temp
           // j++
        }
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        var kLocal = k
        if(nums.size<=1) return
        kLocal = kLocal%nums.size
        if(kLocal==0) return
        var splitAt = nums.size-1-kLocal
        reverse(0,splitAt, nums)
        reverse(splitAt+1, nums.size-1, nums)
        reverse(0, nums.size-1, nums)
    }
}
fun main(args: Array<String>) {
    /*var nums = intArrayOf(-1,-100,3,99)
    var k = 2*/
    /*var nums = intArrayOf(1,2,3,4,5,6,7)
    var k = 3*/
    var nums = intArrayOf(1)
    var k = 0
   /* var nums = intArrayOf(1,2,3,4,5,6)
    var k = 6*/
    RotateArray().rotate(nums, k)
    println(Arrays.toString(nums))
}