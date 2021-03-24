import java.util.*

class RemoveDuplicatesFromSortedArray {
    /*    fun removeDuplicates(nums: IntArray): Int {
            var lastDistinctPos = 1
            var repCount = 0
            for (currentPos in 1..nums.size-1) {
                if(nums[currentPos-1]>nums[currentPos] *//*|| currentPos== nums.size-1*//*) {
                return currentPos
            }
            if(nums[currentPos-1]!=nums[currentPos] && repCount>=1) {
                var temp = nums[currentPos]
                //nums[currentPos] = nums[lastDistinctPos]
                nums[lastDistinctPos] = temp
                lastDistinctPos++
                repCount = 0
            } else if(nums[currentPos-1]!=nums[currentPos] && repCount==0) {
                lastDistinctPos++

            } else {
                repCount++
            }
            if(currentPos==nums.size-1) return lastDistinctPos
        }
        return nums.size
    }*/
    fun removeDuplicates(nums: IntArray): Int {
        var lastSeen :Int? = null
        //var current = 0
        var lastDistinctAt = -1
        for (current in 0..nums.size-1) {
            if(nums[current]==lastSeen) continue
            else {
                nums[++lastDistinctAt] = nums[current]
                lastSeen = nums[current]
            }
        }
        return lastDistinctAt+1
    }
}

fun main() {
    var nums: IntArray = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    //var nums: IntArray = intArrayOf(1,1,2)
    //var nums: IntArray = intArrayOf(1,2)
    //var nums: IntArray = intArrayOf(1, 1, 2, 3)
    println("${RemoveDuplicatesFromSortedArray().removeDuplicates(nums)} -> ${Arrays.toString(nums)}")
}