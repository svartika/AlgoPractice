package Arrays

class GetMaxInGeneratedArray {
    /*fun getMaximumGenerated(n: Int): Int {
        var calculateValsUpTo :Int = n/2 + 1
        var nums = IntArray(calculateValsUpTo+1)
        nums[0] = 0
        nums[1] = 1
        for( i in 2 .. calculateValsUpTo) {
            if(i%2==0) {
                nums[i] = nums[i/2]
            } else {
                nums[i] = nums[i/2] + nums[i/2+1]
            }
        }
        if (n%2==0) {
            return nums[n/2]
        } else {
            return nums[n/2] + nums[n/2+1]
        }
    }*/

    fun getMaximumGenerated(n: Int): Int {
        var max = 1
        if(n==0) return 0
        else if(n==1) return 1
        else {
            var nums = IntArray(n + 1)
            nums[0] = 0
            nums[1] = 1
            for (i in 2..n) {
                if (i % 2 == 0) {
                    nums[i] = nums[i / 2]
                } else {
                    nums[i] = nums[i / 2] + nums[i / 2 + 1]
                }
                max = Math.max(max, nums[i])
            }
            return max
        }
    }
}
fun main(args:Array<String>) {
    println(GetMaxInGeneratedArray().getMaximumGenerated(7))
    println(GetMaxInGeneratedArray().getMaximumGenerated(2))
    println(GetMaxInGeneratedArray().getMaximumGenerated(3))
    println(GetMaxInGeneratedArray().getMaximumGenerated(4))
}