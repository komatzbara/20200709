import kotlin.random.Random
import kotlin.random.nextInt

class WinningStrategy : Strategy {
    private var won : Boolean = false
    private var prevHand : Hand = Hand.getHand(Random.nextInt(0..2))
    override fun nextHand() : Hand {
        if (!won) {
            prevHand = Hand.getHand(Random.nextInt(0..2))
        }
        return prevHand
    }
    override fun study(win : Boolean) {
        won = win
    }
}
