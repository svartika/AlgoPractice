package Arrays.FindSingleNumber

class Solution {
    private fun insertInToHashTable(hashTable:Array<Any?>, nums: IntArray) {
        for(number in nums) {
            var pos = Math.abs(number%(nums.size))
            var makeNull : Boolean = false
            while (hashTable[pos] != null) {
                if (hashTable[pos] == number) {
                    makeNull = true
                    break
                } else {
                    if (pos == nums.size - 1) pos = 0
                    if (pos == Math.abs((number % nums.size) )- 1) break
                    pos = pos + 1
                }
            }
            if(makeNull) hashTable[pos] = "D"
            else hashTable[pos] = number
        }
    }
    fun singleNumber(nums: IntArray): Int {
        var hashTable:Array<Any?> = arrayOfNulls(nums.size)
        insertInToHashTable(hashTable, nums)
        for(number in hashTable) {
            if(number!=null&&number!="D") {
                return number.toString().toInt()
            }
        }
        return -1
    }


}
fun main(args:Array<String>) {
    //var nums = intArrayOf(2,2,1)
    //var nums = intArrayOf(4,1,2,1,2)
    //var nums = intArrayOf(1)
    //var nums = intArrayOf(-1, -1, 3)
    //var nums = intArrayOf(-1)
    //var nums = intArrayOf(1, 1, 3)
    var nums = intArrayOf(-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354)
    println(Solution().singleNumber(nums));
}
