package Arrays

class AreStringArraysEquivalent {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var str1: String = ""
        for(i in 0..word1.size-1) {
            str1 = str1.plus(word1[i])
        }
        var str2: String = ""
        for(i in 0..word2.size-1) {
            str2 = str2.plus(word2[i])
        }
        if(str1.compareTo(str2)==0) return true
        return false
    }
}
fun main(args: Array<String>) {
/*    var word1:Array<String> = arrayOf("ab", "c")
    var word2:Array<String> = arrayOf("a", "bc")*/

   /* var word1:Array<String> = arrayOf("a", "cb")
    var word2:Array<String> = arrayOf("ab", "c")*/

    var word1:Array<String> = arrayOf("abc", "d", "defg")
    var word2:Array<String> = arrayOf("abcddefg")
    println(AreStringArraysEquivalent().arrayStringsAreEqual(word1, word2))

}