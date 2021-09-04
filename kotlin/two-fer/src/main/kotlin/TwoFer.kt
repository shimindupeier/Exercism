internal fun twofer(name: String? = null): String {

    return if (name != null)
        "One for $name, one for me."
    else
        "One for you, one for me."
}
