object RunLengthEncoding {

    fun encode(input: String): String {
        return if (input.isEmpty()) "" else {
            val strList = input.toList()
            var first = strList.first()
            val splitList = mutableListOf<String>()
            var charGroup = ""
            strList.map { c ->
                if (c == first) charGroup += c
                else {
                    splitList.add(charGroup)
                    charGroup = c.toString()
                    first = c
                }
            }
            splitList.add(charGroup)
            splitList.joinToString("") { (if (it.length > 1) it.length.toString() else "") + it.first() }
        }
    }

    fun decode(input: String): String {
        return if (input.isEmpty()) "" else {
            /*
            (?<=\D)(?=\d) - matches a position between a non-digit (\D) and a digit (\d)
            (?<=\d)(?=\D) - matches a position between a digit and a non-digit.
            */
            val splitStr =
                input.split("(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)".toRegex()).map { it.split("(?<=\\d)(?=\\D)".toRegex()) }
            var outputStr = ""
            splitStr.map {
                val d = it.first().toIntOrNull()
                if (d != null) {
                    for (i in 1..(d)) outputStr += it.last()
                } else {
                    outputStr += it.last()
                }
            }
            outputStr
        }
    }
}

