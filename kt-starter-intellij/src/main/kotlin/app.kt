import data.ListSoil
import data.soil

fun main() {

    val data1 = soil("gambut",0.44f)
    val data2 = soil("aluvial",3.44333f)
    val data3 = soil("humus",1.44f)

    val x = mutableListOf<soil>(data1,data2,data3)
    x.add(3,soil("bla bla",9.9999994234522234f))

    x.sortByDescending { it.prediction }

    for (i in x.indices) {
        println(x[i].soilType)
        println(x[i].prediction)
    }

}