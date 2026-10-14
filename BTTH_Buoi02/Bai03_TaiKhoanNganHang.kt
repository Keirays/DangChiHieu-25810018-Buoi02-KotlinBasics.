fun main()
{
    val soDuBanDau: Double = 5_000_000.0
    var soDuHienTai: Double = soDuBanDau
    println("Thong tin giao dich")
    println("So du ban dau: $soDuHienTai VND")

    val tienGui: Double = 2_000_000.0
    soDuHienTai += tienGui
    println("Giao Dich: Gui them: $tienGui VND")
    println("So du sau khi gui: $soDuHienTai VND")

    val tienRut: Double = 1_500_000.0
    soDuHienTai -= tienRut
    println("Giao Dich: Rut tien: $tienRut")
    println("So du sau khi rut: $soDuHienTai")

}