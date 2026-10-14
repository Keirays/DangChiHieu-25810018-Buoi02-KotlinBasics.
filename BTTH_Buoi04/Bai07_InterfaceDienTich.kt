package BTTH_Buoi4

private interface CoTheTinhDienTich {
    fun tinhDienTich(): Double
}

private class HinhVuong(val canh: Double) : CoTheTinhDienTich {
    override fun tinhDienTich(): Double {
        return canh * canh
    }
}

private class HinhTron(val banKinh: Double) : CoTheTinhDienTich {
    override fun tinhDienTich(): Double {
        return 3.14 * banKinh * banKinh
    }
}

fun main() {
    val hv = HinhVuong(5.0)
    val ht = HinhTron(3.0)

    println("Dien tich hinh vuong: " + hv.tinhDienTich())
    println("Dien tich hinh tron: " + ht.tinhDienTich())
}