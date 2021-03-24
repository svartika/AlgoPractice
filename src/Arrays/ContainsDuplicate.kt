package Arrays

class ContainsDuplicate {
    fun partition(nums: IntArray, p: Int, r: Int): Int {
        var x = nums[r]
        var i = p - 1
        for (j in p..r - 1) {
            if (nums[j] == x) return -1
            if (nums[j] < x) {
                i = i + 1
                var temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
        }
        var temp = nums[i + 1]
        nums[i + 1] = nums[r]
        nums[r] = temp
        return i + 1
    }

    fun quickSort(nums: IntArray, p: Int, r: Int): Boolean {
        //var ret:Boolean = false
        if (p < r) {
            var q = partition(nums, p, r)
            if (q == -1) return true
            if (quickSort(nums, p, q - 1)) return true
            if (quickSort(nums, q + 1, r)) return true
        }
        return false
    }

    fun containsDuplicate1(nums: IntArray): Boolean {
        if (nums.size <= 1) return false
        return quickSort(nums, 0, nums.size - 1)
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        if(nums.size<=1) return false
        var hashTable:Array<Int?> = arrayOfNulls(nums.size)
        for (number in nums) {
            var pos = Math.abs(number % nums.size)
            while (hashTable[pos] != null ) {
                if (hashTable[pos] == number) {
                    return true
                }
                if(pos == Math.abs(number % nums.size)-1) {
                    return false
                }
                if (pos == nums.size - 1) {
                    pos = 0
                }
                else {
                   pos++
                }
            }
            hashTable[pos] = number
        }
        return false

    }
}

fun main(args: Array<String>) {
    //var nums = intArrayOf(1,2,3,1)
    //var nums = intArrayOf(1,2,3,4)
    //var nums = intArrayOf(1,1,1,3,3,4,3,2,4,2)
    //var nums = intArrayOf(0, 4, 5, 0, 3, 6)
    //var nums = intArrayOf(15,25,35,15)
    //var nums = intArrayOf(15,25,35)
    var nums = intArrayOf(1,5,-2,-4,0)
    println(ContainsDuplicate().containsDuplicate(nums))
}