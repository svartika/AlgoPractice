package Arrays.LongestSubString

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 0) return 0
        if (s.length == 1) return 1
        var maxLenth = 0
        var charPos: HashMap<Char, Int> = HashMap()
        var currSubStrLen = 0
        var startOfCurrSubStr = 0
        for (i in 0..s.length - 1) {
            if (charPos.containsKey(s[i])) {
                var prevPosOfThisChar = charPos.get(s[i]) ?: 0
                charPos.put(s[i], i)
                if (prevPosOfThisChar < startOfCurrSubStr) {
                    currSubStrLen++
                } else {
                    maxLenth = Math.max(maxLenth, currSubStrLen)
                    currSubStrLen = i - prevPosOfThisChar
                    startOfCurrSubStr = prevPosOfThisChar + 1
                }
            } else {
                charPos.put(s[i], i)
                currSubStrLen++
            }
            // println("char:${s[i]} currentIndex:$i currSubStrLen:$currSubStrLen posOfThisChar:${charPos.get(s[i])} startOfCurrSubStr:${startOfCurrSubStr}")
        }
        maxLenth = Math.max(maxLenth, currSubStrLen)
        return maxLenth
    }
}

fun main(args: Array<String>) {
    println(Solution().lengthOfLongestSubstring("abcabcbb"))
    println(Solution().lengthOfLongestSubstring("bbbbb"))
    println(Solution().lengthOfLongestSubstring("pwwkew"))
    println(Solution().lengthOfLongestSubstring("au"))
    println(Solution().lengthOfLongestSubstring("tmmzuxt"))
    println(Solution().lengthOfLongestSubstring("bbtablud"))
    println(Solution().lengthOfLongestSubstring("aabaab!bb"))
}