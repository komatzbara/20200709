class Player {
	private var name : String
	private var strategy : Strategy
    private var wincount : Int = 0
    private var losecount : Int = 0
    private var gamecount : Int = 0

    constructor (name:String, strategy:Strategy) {         // 名前と戦略を授けられる
        this.name = name
        this.strategy = strategy
    }

    fun nextHand() : Hand {                                // 戦略におうかがいを立てる
        return strategy.nextHand()
    }

    fun win() {                 // 勝った
        strategy.study(true)
        wincount++
        gamecount++
    }

    fun lose() {                // 負けた
        strategy.study(false)
        losecount++
        gamecount++
    }

    fun even() {                // 引き分け
        gamecount++
    }

    override fun toString() : String {
        return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose" + "]";
    }
}
