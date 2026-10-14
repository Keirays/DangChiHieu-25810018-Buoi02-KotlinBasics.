private class TaiKhoanNganHang(val soTaiKhoan: String, soDuBanDau: Double) {
    var soDu: Double = soDuBanDau

    fun napTien(soTien: Double) {
        soDu += soTien
    }

    fun rutTien(soTien: Double): Boolean {
        if (soDu >= soTien) {
            soDu -= soTien
            return true
        }
        return false
    }
}

fun main() {
    val tk = TaiKhoanNganHang("TK001", 100000.0)
    println("So du ban dau: " + tk.soDu)

    tk.napTien(50000.0)
    println("Sau khi nap 50000: " + tk.soDu)

    val kqRut1 = tk.rutTien(80000.0)
    println("Rut 80000 thanh cong: " + kqRut1)
    println("So du sau khi rut: " + tk.soDu)

    val kqRut2 = tk.rutTien(100000.0)
    println("Rut 100000 thanh cong: " + kqRut2)
    println("So du sau khi rut: " + tk.soDu)
}