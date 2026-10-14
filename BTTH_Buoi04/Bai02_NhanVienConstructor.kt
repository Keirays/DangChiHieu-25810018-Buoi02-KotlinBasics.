package BTTH_Buoi4

class NhanVien(
    maNhanVien: String,
    val ten: String,
    var luongThang: Double
) {
    constructor(ten: String) : this("TAM", ten, 0.0)
}

fun main() {
    val nv1 = NhanVien("NV001", "Nguyen Van A", 15000000.0)
    val nv2 = NhanVien("Tran Thi B")

    println("--- NHAN VIEN 1 ---")
    println("Ten: " + nv1.ten)
    println("Luong thang: " + nv1.luongThang)

    println()

    println("--- NHAN VIEN 2 ---")
    println("Ten: " + nv2.ten)
    println("Luong thang: " + nv2.luongThang)
}