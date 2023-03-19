package data

data class ListSoil(
    val list: List<soil>
)

data class soil(
    val soilType:String? = null,
    val prediction:Float? = null
) {
}