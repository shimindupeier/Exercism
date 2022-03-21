class Robot {
    private var robotName = ""

    companion object {
        val setOfGeneratedNames = mutableSetOf<String>()
    }

    init {
        robotName = name
    }

    val name: String
        get() = robotName.ifEmpty {
            generateUniqueName()
        }

    private fun generateUniqueName(): String {
        var generatedName = generateName()
        while (setOfGeneratedNames.contains(generatedName)) {
            generatedName = generateName()
        }
        setOfGeneratedNames.add(generatedName)
        return generatedName
    }

    private fun generateName() = getRandomAlphabet() + getRandomNum()

    private fun getRandomAlphabet() = List(2) {('A'..'Z').random()}.joinToString("")
    private fun getRandomNum() = List(3) {('0'..'9').random()}.joinToString("")



    fun reset() {
        robotName = ""
    }
}
