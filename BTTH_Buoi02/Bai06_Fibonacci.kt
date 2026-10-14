fun main()
{
    val gioiHan: Int = 100
    var a: Int = 0
    var b: Int = 1
    for (index in 0..100) {
        if (a >= gioiHan) {
            break
        }
        println("Chi so: $index: $a")
        val next: Int = a + b
        a = b
        b = next
    }
}