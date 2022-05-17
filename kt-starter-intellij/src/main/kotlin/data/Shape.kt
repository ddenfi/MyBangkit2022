package data

abstract  class  Shape{
    var name:String = ""
    var corner:Int? = null

    abstract fun getKotak() : Kotak

    fun sayHello(){
        println("Hallo ini shape")
    }

    fun cekNama () {
        println("Object ini bernama $name")
    }
    fun cekSudut () {
        println("Object ini memiliki $corner sudut")
    }

    companion object {
        fun sayHi(name: String) {
            println("Hi aku $name")
        }
    }

}
