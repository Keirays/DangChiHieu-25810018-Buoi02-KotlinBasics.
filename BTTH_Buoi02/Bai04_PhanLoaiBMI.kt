fun main()
{
    val canNang: Double = 62.5
    val chieuCao: Double = 1.73
    val bmi: Double = canNang / (chieuCao * chieuCao)

    val phanLoai: String = if (bmi < 18.5) {
        "Gay"
    } else if (bmi < 25.0) {
        "Binh Thuong"
    } else if (bmi < 30.0) {
        "Thua Can"
    } else {
        "Beo Phi"
    }

    println("Chi so BMI: $bmi")
    println("Phan loai: $phanLoai")
}