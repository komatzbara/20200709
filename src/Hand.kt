class Hand {
    val name = arrayOf("グー","チョキ","パー")     // じゃんけんの手の文字列表現

    private var handvalue : Int                    // じゃんけんの手の値
    constructor(rv_handvalue : Int) {
        this.handvalue = rv_handvalue
    }
    companion object {
        val HANDVALUE_GUU : Int = 0  // グーを表す値
        val HANDVALUE_CHO : Int = 1  // チョキを表す値
        val HANDVALUE_PAA : Int = 2  // パーを表す値
        // じゃんけんの手を表す3つのインスタンス
        private val hand = arrayOf(Hand(this.HANDVALUE_GUU),Hand(this.HANDVALUE_CHO),Hand(this.HANDVALUE_PAA))
        fun getHand(rv_handvalue : Int) : Hand { // 値からインスタンスを得る
            return hand[rv_handvalue]
        }
    }
    fun isStrongerThan(h : Hand) : Boolean {     // thisがhより強いときtrue
        return fight(h) == 1
    }
    fun isWeakerThan(h : Hand) : Boolean {       // thisがhより弱いときtrue
        return fight(h) == -1
    }
    fun fight(h : Hand) : Int {                 // 引き分けは0, thisの勝ちなら1, hの勝ちなら-1
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }
    override fun toString() : String {                  // 文字列表現へ変換
        return name[handvalue]
    }
}
