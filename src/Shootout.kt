import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val rand = Random(0)
    println("n, p")
    for (i in 1..10000) {
        var avg = 0.0
        var count = 0.0
        for (run in 1..10000) {
            var people = ArrayList<Boolean>(Array(i) { true }.asList())
            while (people.size > 1) {
                for (person in 0 until people.size) {
                    var index = rand.nextInt(people.size)
                    while (index == person) index = rand.nextInt(people.size)
                    people[index] = false
                }
                people = people.filter { it }.toCollection(ArrayList())
            }
            avg += people.size
            ++count
        }
        println("$i, ${avg / count}")
    }
}
