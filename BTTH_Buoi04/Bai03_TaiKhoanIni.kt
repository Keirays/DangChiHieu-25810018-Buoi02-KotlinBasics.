package BTTH_Buoi4

private class TaiKhoanNganHang(soTaiKhoan: String, soDuBanDau: Double) {
    var soDu: Double = soDuBanDau

    init {
        if (soDuBanDau < 0) {
            println("So du khong hop le")
        } else {
            println("Tao tai khoan thanh cong voi so du ban dau: $soDu")
        }
    }
}

fun main() {
    val tk1 = TaiKhoanNganHang("TK001", 500000.0)
    val tk2 = TaiKhoanNganHang("TK002", -100000.0)
}