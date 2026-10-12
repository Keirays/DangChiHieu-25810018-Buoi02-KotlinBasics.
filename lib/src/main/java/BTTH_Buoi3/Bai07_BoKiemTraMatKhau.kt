package BTTH_Buoi3

fun main() {
    val kiemTraDoDai: (String) -> Boolean = { matKhau ->
        matKhau.length >= 8
    }

    val mk1 = "abc"
    val mk2 = "12345678"
    val mk3 = "matkhauBaoMat2026"

    println(kiemTraDoDai(mk1))
    println(kiemTraDoDai(mk2))
    println(kiemTraDoDai(mk3))
}