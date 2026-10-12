package BTTH_Buoi3

fun dinhDangDiaChi(
    tenNguoiNhan: String,
    soNhaTenDuong: String,
    phuongXa: String = "Phường A",
    quanHuyen: String = "TP. Thủ Đức",
    thanhPho: String = "TP. Hồ Chí Minh"
): String {
    return "$tenNguoiNhan, $soNhaTenDuong, $phuongXa, $quanHuyen, $thanhPho"
}

fun main() {
    val diaChi1 = dinhDangDiaChi(
        "Đặng Chí Hiếu",
        "Đường ..."
    )
    println(diaChi1)

    val diaChi2 = dinhDangDiaChi(
        "Nguyễn Văn A",
        "Số 10... ",
        phuongXa = "Phường... ",
        quanHuyen = "Quận 1"
    )
    println(diaChi2)

    val diaChi3 = dinhDangDiaChi(
        "Trần Thị B",
        "Số 50 Lê Lợi",
        thanhPho = "TPHCM",
        quanHuyen = "Quận...",
        phuongXa = "Phường..."
    )
    println(diaChi3)
}