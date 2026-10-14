fun main()
{
    val danhSachSach: MutableList<String> = mutableListOf(
        "Trang Quynh",
        "Than Dong Dat Viet",
        "Naruto",
        "Doraemon",
        "Pokemon"
    )
    println("Danh Sach Ban Dau")
    println(danhSachSach)
    danhSachSach.add("7 Vien Ngoc Rong")
    danhSachSach.add("Tham Tu Lung Danh Conan")

    danhSachSach.remove("Than Dong Dat Viet")
    danhSachSach.sort()
    println("Danh sach sach sau khi them, xoa, sap xep")
    println(danhSachSach)
}