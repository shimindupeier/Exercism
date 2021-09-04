import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = modifier(constitution).plus(10)

    companion object {

        fun ability(): Int = List(4) { Random.nextInt(1, 6) }.sorted().drop(1).sum()

        fun modifier(score: Int) = Math.floorDiv(score.minus(10), 2)
    }
}
