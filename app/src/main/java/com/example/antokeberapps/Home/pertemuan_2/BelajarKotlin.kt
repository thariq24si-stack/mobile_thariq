package com.example.antokeberapps.pertemuan_2

fun main(){
    println("Hai rekan-rekan...")
    println("Selamat Datang")

    println("=========")

    var angka = 15

    println("Hasil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 10000
    val nilaiDouble = 100.03
    val nilaiFloat = 100.0f


    println("Nilai Integer = $nilaiInt")
    println("Nilai Double = $nilaiDouble")
    println("Nilai Float = $nilaiFloat")

    println("=====STRING====")

    val huruf = 'a'

    println("ini penggunaan huruf '$huruf'")

    val nilaiString = "Mawar"

    println("Halo $nilaiString !\nApa kabr?")

    println("====KONDISI=====")

    val nilai = 10
    if (nilai<0)
        println("Bilangan negatif")
    else {
if(nilai%2 == 0)
    println("Bilangan Genap")
        else
            println("Bilangan ganjil")
    }

    println("=====PERULANGAN====")
    val kampusku: Array<String> =arrayOf("Kampus","Polteknik","caltex","Riau")
    for (kampus : String in kampusku) {
        println(kampusku)
    }
}