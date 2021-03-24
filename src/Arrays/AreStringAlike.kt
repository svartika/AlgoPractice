package Arrays

import java.lang.Math.abs

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        var str1 = s.substring(0, s.length/2)
        var str2 = s.substring(s.length/2, s.length)
        if(str1.length!=str2.length) return false
        var numOfVowelsInStr1 : Int = 0
        var numOfVowelsInStr2 : Int = 0
        for(i in 0..str1.length-1){
            var char1 = str1.get(i)
            if(char1 == 'a' || char1 == 'e' || char1 == 'i' || char1 == 'o' || char1 == 'u'
                || char1 == 'A' || char1 == 'E' || char1 == 'I' || char1 == 'O' || char1 == 'U')
                numOfVowelsInStr1++
            var char2 = str2.get(i)
            if(char2 == 'a' || char2 == 'e' || char2 == 'i' || char2 == 'o' || char2 == 'u'
                || char2 == 'A' || char2 == 'E' || char2 == 'I' || char2 == 'O' || char2 == 'U')
                numOfVowelsInStr2++
            var requiredNumberOfVowels = abs(numOfVowelsInStr1-numOfVowelsInStr2)
            var remainingLen = str1.length - i
            if(remainingLen<requiredNumberOfVowels) {
                var i = 10
                return false
            }
        }
        if(numOfVowelsInStr1==numOfVowelsInStr2) return true
        return false
    }

}
fun main() {
    println(Solution().halvesAreAlike("MerryChristmas"))
}