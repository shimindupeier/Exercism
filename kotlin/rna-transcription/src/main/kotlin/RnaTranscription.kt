fun transcribeToRna(dna: String): String {
    val dnaToRnaMap = mapOf("G" to "C", "C" to "G", "T" to "A", "A" to "U")
    val dnaList = dna.map { it.toString() }.toList()
    return if (dna.isEmpty()) ""
    else {
        dnaList.joinToString("") { dnaToRnaMap.getValue(it) }
    }
}
