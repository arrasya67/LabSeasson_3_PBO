# LabSeasson_3_PBO
Program Sistem Rental PlayStation berbasis Java untuk memenuhi tugas Praktikum OOP Lab Session. Menerapkan konsep Encapsulation, Inheritance, Polymorphism (Overriding & Overloading), Abstract Class, dan Interface.
**Dibuat oleh:**
- **Nama:** Dwi Agus Maulana
- **NIM:** L0325022
- **Kelas:** 3B
- **Mata Kuliah:** Pemrograman Berorientasi Objek (PBO)

# 🎮 Sistem Rental PlayStation (Java OOP)

Repositori ini berisi program Java sederhana berbasis *Command Line Interface* (CLI) untuk memenuhi tugas **Praktik Lab Session 3B: Pengembangan Program Berbasis Object-Oriented Programming (OOP)**. 

Program ini mensimulasikan sistem penyewaan konsol PlayStation (PS4 dan PS5) dengan menerapkan berbagai konsep dasar Pemrograman Berorientasi Objek.

## 🚀 Fitur & Konsep OOP yang Diterapkan

1. **Encapsulation**: Atribut pada class `Konsol` dibuat `private` dan diakses melalui *getter* & *setter*.
2. **Inheritance**: Class `PS4` dan `PS5` mewarisi (*extends*) class abstrak `Konsol`, serta memanggil `super()` pada *constructor*.
3. **Polymorphism**:
   - **Overriding**: Method `hitungBiayaSewa()` dan `tampilkanInfo()` di-*override* oleh subclass (contoh: PS5 memiliki tambahan biaya asuransi).
   - **Overloading**: Terdapat method `setTersedia()` dan `hitungBiayaSewa()` dengan parameter yang berbeda.
   - **Runtime Polymorphism**: Objek PS4 dan PS5 disimpan dalam array bertipe superclass `Konsol[]`.
4. **Abstract Class**: Class `Konsol` merupakan *abstract class* yang memiliki *abstract method*.
5. **Interface**: Interface `DapatDisewa` diimplementasikan oleh class `Konsol`.

## 📂 Struktur File

- `DapatDisewa.java` : Interface kontrak penyewaan.
- `Konsol.java` : Abstract class (superclass) yang menampung atribut umum dan logika dasar.
- `PS4.java` : Subclass untuk konsol PS4 (memiliki atribut spesifik: kapasitas HDD).
- `PS5.java` : Subclass untuk konsol PS5 (memiliki atribut spesifik: jumlah stik & biaya asuransi).
- `Main.java` : Class utama untuk menjalankan simulasi program.

## 🛠️ Cara Menjalankan Program

Pastikan kamu sudah menginstal **JDK (Java Development Kit)** di komputermu. 

1. Buka terminal / *Command Prompt* di direktori folder ini.
2. Lakukan kompilasi semua file Java:
   ```bash
   javac *.java
   ```

## 📸 Output Program

Berikut adalah tampilan output secara langsung ketika program dijalankan. Pengguna tidak perlu menjalankannya lagi karena hasilnya sudah tertera di bawah ini:

```text
PS D:\SMT 3\PBO\Labsession\Lab3\PS> java Main
========================================
       SISTEM RENTAL PLAYSTATION
========================================

DAFTAR KONSOL TERSEDIA
--------------------------------
Jenis Konsol    : PS4 Slim
ID              : K001
Kapasitas HDD   : 500 GB
Tarif per Jam   : Rp10,000
Status          : Tersedia
--------------------------------
Jenis Konsol    : PS4 Pro
ID              : K002
Kapasitas HDD   : 1000 GB
Tarif per Jam   : Rp15,000
Status          : Tersedia
--------------------------------
Jenis Konsol    : PS5 Standard
ID              : K003
Jumlah Stik     : 2
Tarif per Jam   : Rp25,000
Status          : Tersedia
--------------------------------
Jenis Konsol    : PS5 Digital
ID              : K004
Jumlah Stik     : 1
Tarif per Jam   : Rp20,000
Status          : Tersedia

========================================
          PROSES PENYEWAAN
========================================
Konsol berhasil disewa.
Tipe Konsol    : PS4 Slim
Lama sewa      : 5 jam
Total biaya    : Rp50,000

Konsol berhasil disewa.
Tipe Konsol    : PS5 Standard
Lama sewa      : 3 jam
Total biaya    : Rp90,000

CONTOH PERHITUNGAN DISKON (Member)
Biaya sewa PS4 Pro 4 jam (Diskon 15%): Rp51,000

Status PS5 Digital: Sedang Diperbaiki

========================================
       PROSES PENGEMBALIAN
========================================
Konsol PS4 Slim berhasil dikembalikan.
Konsol PS5 Standard berhasil dikembalikan.

DAFTAR STATUS AKHIR
PS4 Slim : Tersedia
PS4 Pro : Tersedia
PS5 Standard : Tersedia
PS5 Digital : Disewa/Rusak

========================================
          PROGRAM SELESAI
========================================
```

## 📝 Penjelasan Alur Output Program

**1. Daftar Konsol Tersedia**
*   Program dimulai dengan membuat 4 objek (2 PS4 dan 2 PS5) dan memasukkannya ke dalam array `Konsol[]`.
*   Saat melakukan perulangan (looping), program memanggil method `tampilkanInfo()`. Di sini konsep **Runtime Polymorphism** bekerja: meskipun tipe array-nya adalah `Konsol`, program otomatis tahu harus memanggil `tampilkanInfo()` milik PS4 atau PS5. Perbedaan atribut (Kapasitas HDD vs Jumlah Stik) berhasil ditampilkan.

**2. Proses Penyewaan (PS4 Slim & PS5 Standard)**
*   **PS4 Slim (5 Jam):** Memanggil `ps4_1.sewa(5)`. Biaya dihitung dengan tarif standar: Rp10.000 x 5 = **Rp50.000**.
*   **PS5 Standard (3 Jam):** Memanggil `ps5_1.sewa(3)`. Di sinilah **Method Overriding** terlihat. Karena PS5 memiliki biaya asuransi tambahan (Rp5.000/jam), maka perhitungannya: (Rp25.000 + Rp5.000) x 3 = **Rp90.000**. Setelah disewa, status ketersediaan (*private boolean tersedia*) diubah menjadi `false`.

**3. Contoh Perhitungan Diskon (Member)**
*   Program memanggil `ps4_2.hitungBiayaSewa(4, 15)`. Ini membuktikan **Method Overloading** berjalan.
*   Perhitungan: Sewa normal 4 jam = Rp15.000 x 4 = Rp60.000. Dengan diskon 15% (potongan Rp9.000), total biaya menjadi **Rp51.000**.

**4. Status PS5 Digital**
*   Program memanggil `ps5_2.setTersedia("Tidak Tersedia")`. Ini adalah contoh **Method Overloading** pada *setter* (menerima parameter `String` alih-alih `boolean`).
*   Output menunjukkan statusnya berubah menjadi "Sedang Diperbaiki" (karena logika `if` pada saat print di `Main.java`).

**5. Proses Pengembalian**
*   Memanggil method `kembalikan()` pada PS4 Slim dan PS5 Standard.
*   Atribut `tersedia` di dalam class `Konsol` diubah kembali menjadi `true`. Program mencetak pesan bahwa konsol berhasil dikembalikan.

**6. Daftar Status Akhir**
*   Program mencetak status akhir dari semua objek di dalam array.
*   **PS4 Slim, PS4 Pro, dan PS5 Standard** berstatus **"Tersedia"** (PS4 Pro dari awal tidak disewa, PS4 Slim & PS5 Standard sudah dikembalikan).
*   **PS5 Digital** berstatus **"Disewa/Rusak"** karena sebelumnya statusnya sudah diubah secara manual menjadi tidak tersedia (rusak/diperbaiki) dan tidak ada proses pengembalian untuk konsol ini.

---
