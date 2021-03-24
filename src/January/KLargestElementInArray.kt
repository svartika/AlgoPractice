package January

class KLargestElementInArray {
    private fun partition(nums: IntArray, p:Int, r:Int) : Int {
        var i=p-1
        var x = nums[r]
        for(j in p..r-1) {
            if(nums[j]<=x) {
                i++
                var temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
        }
        var temp = nums[i+1]
        nums[i+1] = nums[r]
        nums[r] = temp
        return i+1
    }
    private fun quickSort(nums: IntArray, p: Int, r:Int) {
            if(p<r) {
            var q = partition(nums, p, r)
            quickSort(nums, p,q-1)
            quickSort(nums, q+1, r)
        }
    }
    fun findKthLargest(nums: IntArray, k: Int): Int {
        quickSort(nums, 0, nums.size-1)
        return nums[nums.size-k]
    }
}

fun main(args: Array<String>) {
   /* var nums = intArrayOf(3,2,1,5,6,4)
    var k =2*/

    var nums = intArrayOf(3,2,3,1,2,4,5,5,6)
    var k = 4
    println(KLargestElementInArray().findKthLargest(nums,k))
}