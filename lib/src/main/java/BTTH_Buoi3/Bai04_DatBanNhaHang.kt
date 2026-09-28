package BTTH_Buoi3

fun datBan(tenKhach:String, soLuongKhach:Int, loaiBan:String = "Ban thuong")
{
    println("Khach hang: $tenKhach")
    println("So luong: $soLuongKhach")
    print("Loai ban: $loaiBan")
}

fun main()
{
    datBan("Nguyen Minh Lam", 2)
    println()

    datBan("Nguyen Tran Minh Tuan", 9, "Ban Vip")
    println()

    datBan(loaiBan = "Ban Khach Sieu Vip", soLuongKhach = 11, tenKhach = "Tran Minh Tuan")
}