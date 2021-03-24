import java.util.*

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in 0..nums.size-1) {
            var num1 = nums[i]
            //if(num1>target) continue
            for(j in i+1.. nums.size-1) {
                if(num1 + nums[j] == target) return intArrayOf(i,j)
            }
        }
        return intArrayOf(-1,-1)
    }
}
fun main(args:Array<String>) {
    println(Arrays.toString(TwoSum().twoSum(intArrayOf(2,7,11,15), 9)))
    println(Arrays.toString(TwoSum().twoSum(intArrayOf(3,2,4), 6)))
    println(Arrays.toString(TwoSum().twoSum(intArrayOf(3,3), 6)))
    println(Arrays.toString(TwoSum().twoSum(intArrayOf(0,4,3,0), 0)))
    println(Arrays.toString(TwoSum().twoSum(intArrayOf(-1,-2,-3,-4,-5), -8)))


}