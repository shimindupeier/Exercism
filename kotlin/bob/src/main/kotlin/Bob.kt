enum class BobResponses(val responses: String) {
    SURE("Sure."),
    WHOA("Whoa, chill out!"),
    CALM("Calm down, I know what I'm doing!"),
    FINE("Fine. Be that way!"),
    WHATEVER("Whatever.")
}

object Bob {
    fun hey(input: String): String {

        val bobResponses = when {
            input.trim().endsWith("?") -> {
                if (input.matches("[A-Z\\s]+\\?".toRegex()))
                    BobResponses.CALM.responses
                else
                    BobResponses.SURE.responses
            }
            input.trim().matches("[\\dA-Z\\s]+[^?]+".toRegex()) -> {
                BobResponses.WHOA.responses
                if (input.matches("[0-9, ]+".toRegex()) || input.contains("[a-z]".toRegex()))
                    BobResponses.WHATEVER.responses
                else
                    BobResponses.WHOA.responses
            }
            input.trim().isEmpty() -> BobResponses.FINE.responses
            else -> BobResponses.WHATEVER.responses
        }
        return bobResponses
    }
}
