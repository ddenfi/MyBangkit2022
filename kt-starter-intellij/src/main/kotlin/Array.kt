fun main() {
    val iniArray : Array<String> = arrayOf("Ini","Adalah", "Percobaan", "Array")

    println(iniArray[0])
    println(iniArray.get(0))
    iniArray[0] = "Itu"
    println("mengubah data")
    println(iniArray[0])

}