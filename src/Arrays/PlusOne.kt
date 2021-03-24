package Arrays

import java.util.*

class PlusOne  {
    fun plusOne(digits: IntArray): IntArray {
        var carryForward = 0
        for(i in digits.size-1 downTo 0) {
            if(digits[i]==9) {
                digits[i] = 0
                carryForward = 1
            } else {
                digits[i] = digits[i]+1
                if(carryForward==1) carryForward = 0
                break
            }
        }
        if(carryForward==1) {
            var newDigits : IntArray = IntArray(digits.size+1)
            newDigits[0] =  1
            for(i in 0..digits.size-1) {
                newDigits[i+1] = digits[i]
            }
            return newDigits
        } else {
            return digits
        }
    }
}
fun main(args:Array<String>) {
    //var digits:IntArray = intArrayOf(1,2,3)
    //var digits:IntArray = intArrayOf(4,3,2,1)
    //var digits:IntArray = intArrayOf(0)
    //var digits:IntArray = intArrayOf(9)
    //var digits:IntArray = intArrayOf(1,9)
    var digits:IntArray = intArrayOf(9,9)
    var newDigits = PlusOne().plusOne(digits)
    println(Arrays.toString(newDigits))
}