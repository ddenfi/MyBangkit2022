fun main (){
   fun hello(name: String, transformer: (String) -> String): String {
       val nameTransform = transformer(name)
       return "Hello $nameTransform"
   }
    println(hello("SomEonE",{value:String -> value.uppercase()}))
}