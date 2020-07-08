interface Strategy {
    abstract fun nextHand() : Hand
    abstract fun study(win : Boolean)
}
