fun main()
{
    val diemTb: Double = 8.5
    val xepLoai: String = when (diemTb) {
        in 8.5..10.0 -> "Xuat sac"
        in 7.0..<8.5 -> "Gioi"
        in 5.5..<7.0 -> "Kha"
        in 4.0..<5.5 -> "Trung binh"
        in 0.0..<4.0 -> "Yeu"
        else -> "Điem khong hop le"
    }
    println("Diem trung binh: $diemTb")
    println("Xep loai hoc luc:  $xepLoai")

}