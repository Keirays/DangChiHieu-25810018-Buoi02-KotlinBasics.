fun main() {
    println("Dem nguoc voi while")
    var countdown: Int = 10
    while (countdown >= 1) {
        println("Dem nguoc: $countdown")
        countdown--
    }
    println("Lap co dinh voi repeat")
    repeat(5)
    {
        lanlap -> println("Lan ${lanlap + 1}")
    }
}