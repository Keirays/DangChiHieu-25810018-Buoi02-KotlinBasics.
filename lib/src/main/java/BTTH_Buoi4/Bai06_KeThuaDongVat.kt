package BTTH_Buoi4

open class DongVat(val ten: String) {
    open fun keu(): String {
        return "Am thanh dong vat"
    }
}

class Cho(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Gau gau"
    }
}

class Meo(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Meo meo"
    }
}

fun main() {
    val danhSachDongVat: List<DongVat> = listOf(
        Cho("Cho Vang"),
        Meo("Meo Muop"),
        Cho("Cho Bec-gie")
    )

    for (dv in danhSachDongVat) {
        println("Ten: " + dv.ten + " - Tieng keu: " + dv.keu())
    }
}