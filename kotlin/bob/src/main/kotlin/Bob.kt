enum class BobResponses(val responses: String) {
    SURE("Sure."),
    WHOA("Whoa, chill out!"),
    CALMDOWN("Calm down, I know what I'm doing!"),
    FINE("Fine. Be that way!"),
    WHATEVER("Whatever.")
}

object Bob {
    fun hey(input: String): String {
        val regexWhatever = Regex("[\\w+\\s\\W]+[^?]")
        val regexSure = Regex("[\\w+\\s\\W]+\\?")
        return if (input.matches(regexWhatever)) BobResponses.WHATEVER.responses
        else if (input.matches(regexSure)) BobResponses.SURE.responses
        else ""
    }
}
