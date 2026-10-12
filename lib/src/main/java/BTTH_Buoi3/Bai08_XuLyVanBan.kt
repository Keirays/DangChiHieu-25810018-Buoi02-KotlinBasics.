package BTTH_Buoi3

fun xuLyVanBan(chuoi: String, hamXuLy: (String) -> String): String {
    return hamXuLy(chuoi)
}

fun chuyenThanhChuHoa(s: String): String {
    return s.uppercase()
}

fun main() {
    val vanBanGoc = "lap trinh di dong"

    val ketQua1 = xuLyVanBan(vanBanGoc, { s -> "[" + s + "]" })
    println(ketQua1)

    val ketQua2 = xuLyVanBan(vanBanGoc, ::chuyenThanhChuHoa)
    println(ketQua2)

    val ketQua3 = xuLyVanBan(vanBanGoc) { s ->
        s.replace(" ", "_")
    }
    println(ketQua3)
}