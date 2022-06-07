object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        var song = ""
        for (i in startBottles downTo takeDown) {
            song += verseLyrics(i) +
                    " ${ln2Phrase2(i - 1)}"
            if (i > takeDown) song += "\n"
        }
        return song
    }
}

fun verseLyrics(bottleCount: Int): String {
    return when (bottleCount) {
        in (2..99) -> "$bottleCount bottles of beer on the wall, $bottleCount bottles of beer.\nTake one down and pass it around,"
        1 -> "$bottleCount bottle of beer on the wall, $bottleCount bottle of beer.\nTake it down and pass it around,"
        else -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more,"
    }
}

fun ln2Phrase2(bottleCount: Int): String {
    return when (bottleCount) {
        in (2..99) -> "$bottleCount bottles of beer on the wall.\n"
        1 -> "$bottleCount bottle of beer on the wall.\n"
        0 -> "no more bottles of beer on the wall.\n"
        else -> "99 bottles of beer on the wall.\n"
    }
}