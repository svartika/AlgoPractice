package January

class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var buyAt: Int? = null
        var sellAt: Int? = null

        for (day in 1..prices.size - 1) {
            if (buyAt == null) {
                if (prices[day] > prices[day - 1]) {
                    buyAt = day - 1
                }
            } else {
                if (prices[day] < prices[day - 1]) {
                    sellAt = day - 1
                }
                if (sellAt != null) {
                    profit += prices[sellAt] - prices[buyAt]
                    buyAt = null
                    sellAt = null
                }
            }

        }
        if(sellAt==null) {
            sellAt = prices.size-1
            if(buyAt!=null) profit += prices[sellAt] - prices[buyAt]
        }
        return profit
    }

}

fun main() {
    //var prices = intArrayOf(7,1,5,3,6,4)
    //var prices = intArrayOf(1, 2, 3, 4, 5)
    //var prices = intArrayOf(7, 6, 4, 3, 1)
    //var prices = intArrayOf(7)
    //var prices = intArrayOf(1,2)
    var prices = intArrayOf(2,1)
    println(MaxProfit().maxProfit(prices))
}