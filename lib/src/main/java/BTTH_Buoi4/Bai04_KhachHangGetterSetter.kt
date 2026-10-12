package BTTH_Buoi4

class KhachHang(var ho: String, var ten: String) {
    var hoTen: String
        get() = "$ho $ten"
        set(value) {
            val danhSachTu = value.trim().split(" ", limit = 2)
            if (danhSachTu.size >= 2) {
                ho = danhSachTu[0]
                ten = danhSachTu[1]
            } else if (danhSachTu.isNotEmpty()) {
                ho = ""
                ten = danhSachTu[0]
            }
        }
}

fun main() {
    val kh = KhachHang("Nguyen", "An")
    println("Ho ten ban dau: " + kh.hoTen)

    kh.ten = "Binh"
    println("Sau khi doi ten: " + kh.hoTen)

    kh.hoTen = "Tran Cuong"
    println("Sau khi gan ho ten moi:")
    println("Ho: " + kh.ho)
    println("Ten: " + kh.ten)
}