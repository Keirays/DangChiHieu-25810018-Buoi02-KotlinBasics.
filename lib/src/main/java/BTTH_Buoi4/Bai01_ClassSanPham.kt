package BTTH_Buoi4

class SanPham(
    val tenSanPham: String,
    val gia: Double,
    val soLuongTonKho: Int = 0
)

fun main() {
    val sp1 = SanPham("Ban phim co Aula", 1250000.0, 15)

    val sp2 = SanPham(
        tenSanPham = "Tai nghe Sony WF-1000XM5",
        gia = 5000000.0
    )

    println("--- SAN PHAM 1 ---")
    println("Ten san pham: " + sp1.tenSanPham)
    println("Gia: " + sp1.gia + " VND")
    println("Ton kho: " + sp1.soLuongTonKho)

    println()

    println("--- SAN PHAM 2 ---")
    println("Ten san pham: " + sp2.tenSanPham)
    println("Gia: " + sp2.gia + " VND")
    println("Ton kho: " + sp2.soLuongTonKho)
}