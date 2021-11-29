object RunLengthEncoding {

    fun encode(input: String): String {
        return if (input.isEmpty()) "" else {
            val strList = input.toList()
            var first = strList.first()
            val splitList = mutableListOf<String>()
            var s = ""
            /*for (i in strList.indices) {
                if (strList[i] == first) {
                    s += strList[i]
                } else {
                    splitList.add(s)
                    s = strList[i].toString()
                    first = strList[i]
                }
            }*/
            strList.map { c ->
                if (c == first) s += c
                else {
                    splitList.add(s)
                    s = c.toString()
                    first = c
                }
            }
            splitList.add(s)
            val output = splitList.joinToString("") { (if (it.length > 1) it.length.toString() else "") + it.first() }
            output
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
            var s = ""
            splitStr.map {
                val d = it.first().toIntOrNull()
                if (d != null) {
                    for (i in 1..(d.toInt())) s += it.last()
                } else {
                    s += it.last()
                }
            }
            s
        }
    }
}

