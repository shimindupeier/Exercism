object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val binaryNum = Integer.toBinaryString(number).map { it.toString().toInt() }.toList()
        var signalList: MutableList<Signal> = mutableListOf()

        binaryNum.reversed().forEachIndexed { index, v ->
            when (index) {
                0 -> if (v == 1) signalList.add(Signal.WINK)
                1 -> if (v == 1) signalList.add(Signal.DOUBLE_BLINK)
                2 -> if (v == 1) signalList.add(Signal.CLOSE_YOUR_EYES)
                3 -> if (v == 1) signalList.add(Signal.JUMP)
                4 -> if (v == 1) signalList = signalList.asReversed()
            }
        }
        return signalList
    }
}
