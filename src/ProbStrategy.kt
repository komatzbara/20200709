import kotlin.random.Random

class ProbStrategy : Strategy {
    private var prevHandValue : Int = 0
    private var currentHandValue : Int = 0
    private var history_goo = arrayOf(1,1,1)
    private var history_cho = arrayOf(1,1,1)
    private var history_paa = arrayOf(1,1,1)
    private var history : Array<Array<Int>> = arrayOf(history_goo,history_cho,history_paa)
    override fun nextHand() : Hand {
        val bet : Int = Random.nextInt(getSum(currentHandValue))
        var handvalue : Int
        if (bet < history[currentHandValue][0]) {
            handvalue = 0
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1
        } else {
            handvalue = 2
        }
        prevHandValue = currentHandValue
        currentHandValue = handvalue
        return Hand.getHand(handvalue)
    }
    fun getSum(hv : Int) : Int {
        var sum : Int = 0
        for (i in 0..2) {
            sum += history[hv][i]
        }
        return sum
    }
    override fun study(win : Boolean) {
        if (win) {
            history[prevHandValue][currentHandValue]++
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 2) % 3]++
        }
    }
}
