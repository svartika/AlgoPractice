package January.countsortedvowels

class CountSortedVowelStrings {
    fun findCount(n: Int, prevChar: Char): Int {

        var count = 0
        // for( i in n downTo 1) {
        if (n == 0) return 1
        when (prevChar) {
            'a' -> {
                count += findCount(n - 1, 'a')
                count += findCount(n - 1, 'e')
                count += findCount(n - 1, 'i')
                count += findCount(n - 1, 'o')
                count += findCount(n - 1, 'u')
            }
            'e' -> {
                count += findCount(n - 1, 'e')
                count += findCount(n - 1, 'i')
                count += findCount(n - 1, 'o')
                count += findCount(n - 1, 'u')
            }
            'i' -> {
                count += findCount(n - 1, 'i')
                count += findCount(n - 1, 'o')
                count += findCount(n - 1, 'u')
            }
            'o' -> {
                count += findCount(n - 1, 'o')
                count += findCount(n - 1, 'u')
            }
            'u' -> {
                count += findCount(n - 1, 'u')
            }
        }
        return count
        //}
    }

    fun countVowelStrings(n: Int): Int {
        return findCount(n, 'a');
    }
}
fun main(args:Array<String>) {
    println(CountSortedVowelStrings().countVowelStrings(2))
    println(CountSortedVowelStrings().countVowelStrings(33))
}