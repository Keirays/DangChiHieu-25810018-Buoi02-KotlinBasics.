package BTTH_Buoi3

fun main() {
    val tuoiKhachHang: Int = 24
    val loaiVe: String = if (tuoiKhachHang < 0) {
        "Tuoi khong hop le"
    } else if (tuoiKhachHang < 12) {
        "Ve tre em"
    } else if (tuoiKhachHang <= 60) {
        "Ve nguoi lon"
    } else
    {
        "ve cao tuoi"
    }

    println("Tuoi khach hang: $tuoiKhachHang")
    println("Loai ve: $loaiVe")
}