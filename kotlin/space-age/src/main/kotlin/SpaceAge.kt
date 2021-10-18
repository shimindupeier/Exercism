class SpaceAge {

    // TODO: Implement proper constructor
    private var ageInSeconds: Int

    constructor(ageInSeconds: Int) {
        this.ageInSeconds = ageInSeconds
    }

    fun onEarth(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25))).toDouble()
    fun onMercury(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*0.2408467))).toDouble()
    fun onVenus(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*0.61519726))).toDouble()
    fun onMars(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*1.8808158))).toDouble()
    fun onJupiter(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*11.862615))).toDouble()
    fun onSaturn(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*29.447498))).toDouble()
    fun onUranus(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*84.016846))).toDouble()
    fun onNeptune(): Double = ("%.2f".format(ageInSeconds/(60*60*24*365.25*164.79132))).toDouble()
}
