enum class BobResponses (val responses: String) {
    SURE("Sure."),
    WHOA("Whoa, chill out!"),
    CALMDOWN("Calm down, I know what I'm doing!"),
    FINE("Fine. Be that way!"),
    WHATEVER("Whatever.")
}
object Bob {
    fun hey(input: String): String {
        val regexWhatever = Regex("[^?\$]")
        return if (input.matches(regexWhatever)) BobResponses.CALMDOWN.responses
        else BobResponses.WHATEVER.responses
        //check if all uppercase
        //consider using regex
    }
}
