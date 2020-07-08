fun main(args: Array<String>) {
	val player1 : Player = Player("Taro",WinningStrategy())
	val player2 : Player = Player("Hana",ProbStrategy())
	for (i in 0..9999) {
			val nextHand1 = player1.nextHand ()
			val nextHand2 = player2.nextHand ()
			if (nextHand1.isStrongerThan(nextHand2)) {
				System.out.println("Winner:" + player1)
				player1.win()
				player2.lose()
			} else if (nextHand2.isStrongerThan(nextHand1)) {
				System.out.println("Winner:" + player2)
				player1.lose()
				player2.win()
			} else {
				System.out.println("Even...")
				player1.even()
				player2.even()
			}
		}
		System.out.println("Total result:")
		System.out.println(player1.toString())
		System.out.println(player2.toString())
}
