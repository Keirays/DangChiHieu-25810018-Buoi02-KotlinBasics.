package BTTH_Buoi3

fun tinhDienTich(chieuDai: Double, chieuRong: Double): Double{
    require(chieuDai >= 0.0 && chieuRong >= 0.0)
        return chieuDai * chieuRong
}
fun main()
{
    val dienTich1 : Double = tinhDienTich(29.50, 15.50)
    val dienTich2: Double = tinhDienTich(15.20, 29.50)

    val inKetQua : Unit = run {
        println("Dien tich 1: $dienTich1")
        println("Dien tich 2: $dienTich2")
    }
}
