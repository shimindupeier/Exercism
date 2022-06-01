object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        var song: String = ""
        for (i in startBottles downTo takeDown) {
            song = "${ln1Phrase1(i)} ${ln1Phrase2(i)}" +
                    "${ln2Phrase1(i)} ${ln2Phrase2(i - 1)}"
        }
        return song
    }
}


//fun ln1Phrase1(): String = "bottles of beer on the wall,"

fun ln1Phrase1(bottleCount: Int): String {
    return when (bottleCount) {
        in (2..99) -> "$bottleCount bottles of beer on the wall,"
        1 -> "$bottleCount bottle of beer on the wall,"
        else -> "No more bottles of beer on the wall,"
    }
}

//fun ln1Phrase2(): String = "bottles of beer.\n"

fun ln1Phrase2(bottleCount: Int): String {
    return when (bottleCount) {
        in (2..99) -> "$bottleCount bottles of beer.\n"
        1 -> "$bottleCount bottle of beer.\n"
        else -> "no more bottles of beer.\n"
    }

}

//fun ln2Phrase1(): String = "Take one down and pass it around,"

fun ln2Phrase1(bottleCount: Int): String {
    return when (bottleCount) {
        in (2..99) ->"Take one down and pass it around,"
        1 -> "Take it down and pass it around,"
        else -> "Go to the store and buy some more,"
    }
}

//fun ln2Phrase2(): String = "bottles of beer on the wall.\n"

fun ln2Phrase2(bottleCount: Int): String {
    return when (bottleCount) {
        in (2..99) -> "$bottleCount bottles of beer on the wall.\n"
        1 -> "$bottleCount bottle of beer on the wall.\n"
        0 -> "no more bottles of beer on the wall.\n"
        else -> "99 bottles of beer on the wall.\n"
    }
}