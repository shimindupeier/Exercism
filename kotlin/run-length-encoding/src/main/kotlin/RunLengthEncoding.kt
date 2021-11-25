object RunLengthEncoding {

    fun encode(input: String): String {
        val strList = input.toList()
        var first = strList.first()
        val splitList = mutableListOf<String>()
        var s = ""
        for (i in strList.indices) {
            if (strList[i] == first) {
                 s += strList[i]
            } else {
                splitList.add(s)
                s = strList[i].toString()
                first = strList[i]
            }
        }
        splitList.add(s)
        val output = splitList.joinToString("") { (if (it.length > 1 ) it.length.toString() else "") + it.first() }
        println(splitList)
        println(output)
        return output
    }

    fun decode(input: String): String {
        TODO("Implement this to complete the task")
    }
}

