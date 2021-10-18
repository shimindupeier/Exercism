class SpaceAge(private var ageInSeconds: Int) {
    private val earthYrInSeconds = 60 * 60 * 24 * PlanetEarthYrs.EARTH.yrs
    private val dp = "%.2f"
    fun onEarth(): Double = dp.format(ageInSeconds / (earthYrInSeconds)).toDouble()
    fun onMercury(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.MERCURY.yrs)).toDouble()
    fun onVenus(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.VENUS.yrs)).toDouble()
    fun onMars(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.MARS.yrs)).toDouble()
    fun onJupiter(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.JUPITER.yrs)).toDouble()
    fun onSaturn(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.SATURN.yrs)).toDouble()
    fun onUranus(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.URANUS.yrs)).toDouble()
    fun onNeptune(): Double = dp.format(ageInSeconds / (earthYrInSeconds * PlanetEarthYrs.NEPTUNE.yrs)).toDouble()
}

