class Handphone(builder: Builder) {
    private val processor: String = builder.processor
    private val battery: String = builder.battery
    private val screenSize: String = builder.screenSize

    // Builder class
    class Builder(processor: String) {
        var processor: String = processor // wajib ada

        var battery: String = "4000MAH"
        var screenSize: String = "6inch"

        fun setBattery(battery: String): Builder {
            this.battery = battery
            return this
        }

        fun setScreenSize(screenSize: String): Builder {
            this.screenSize = screenSize
            return this
        }

        fun create(): Handphone{
            return Handphone(this)
        }
    }
}
