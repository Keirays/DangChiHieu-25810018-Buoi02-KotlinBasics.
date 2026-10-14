package BTTH_Buoi4

private abstract class PhuongTienDiChuyen {
    abstract val tocDoToiDa: Int

    fun moTa() {
        println("Phuong tien nay co toc do toi da la: " + tocDoToiDa + " km/h")
    }
}

private class XeMay : PhuongTienDiChuyen() {
    override val tocDoToiDa: Int = 100
}

private class OTo : PhuongTienDiChuyen() {
    override val tocDoToiDa: Int = 180
}

fun main() {
    val xm = XeMay()
    val ot = OTo()

    print("Xe may: ")
    xm.moTa()

    print("O to: ")
    ot.moTa()
}