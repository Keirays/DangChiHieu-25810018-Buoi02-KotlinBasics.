package BTTH_Buoi3

fun binhPhuongDayDu(n: Int): Int {
    return n * n
}

fun binhPhuongRutGon(n: Int): Int = n * n

fun chuViHinhVuongDayDu(canh: Double): Double {
    return canh * 4
}

fun chuViHinhVuongRutGon(canh: Double): Double = canh * 4

fun laSoChanDayDu(n: Int): Boolean {
    return n % 2 == 0
}

fun laSoChanRutGon(n: Int): Boolean = n % 2 == 0

fun main() {
    println(binhPhuongDayDu(5))
    println(binhPhuongRutGon(5))

    println(chuViHinhVuongDayDu(3.5))
    println(chuViHinhVuongRutGon(3.5))

    println(laSoChanDayDu(8))
    println(laSoChanRutGon(8))
}