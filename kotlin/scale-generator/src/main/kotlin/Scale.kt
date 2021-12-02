class Scale(private val tonic: String) {

    private val chromaticScaleSharp = listOf("C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B")
    private val chromaticScaleFlat = listOf("C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B","C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B")
    private val useSharp = listOf("G","D","A","E","B","F#","C","e","b","f#","c#","g#","d#")

    fun chromatic(): List<String> {
        val startIndex: Int
        val endIndex: Int
        return if (tonic in useSharp) {
            startIndex = chromaticScaleSharp.indexOf(tonic)
            endIndex = startIndex + 12
            chromaticScaleSharp.subList(startIndex, endIndex)
        } else {
            startIndex = chromaticScaleFlat.indexOf(tonic)
            endIndex = startIndex + 12
            chromaticScaleFlat.subList(startIndex, endIndex)
        }
    }

    fun interval(intervals: String): List<String> {
        val intervalList = intervals.split("(?<=\\D)(?=\\D)".toRegex())
        val scale: MutableList<String> = mutableListOf(tonic.replaceFirstChar { it.uppercase() })
        var startIndex: Int

        if (tonic in useSharp) {
            startIndex = chromaticScaleSharp.indexOf(tonic.replaceFirstChar { it.uppercase() })
            intervalList.dropLast(1).map {
                startIndex += scaleGenerator(it)
                scale.add(chromaticScaleSharp[startIndex])}
        } else {
            startIndex = chromaticScaleFlat.indexOf(tonic.replaceFirstChar { it.uppercase() })
            intervalList.dropLast(1).map {
                startIndex += scaleGenerator(it)
                scale.add(chromaticScaleFlat[startIndex])}
        }
        return scale
    }

    private fun scaleGenerator(interval: String): Int = when (interval) {
        "M" -> 2
        "m" -> 1
        "A" -> 3
        else -> 0
    }
}
