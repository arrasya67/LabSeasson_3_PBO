public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       SISTEM RENTAL PLAYSTATION");
        System.out.println("========================================");

        // Membuat 4 objek (2 PS4, 2 PS5)
        Konsol ps4_1 = new PS4("K001", "PS4 Slim", 10000, 500);
        Konsol ps4_2 = new PS4("K002", "PS4 Pro", 15000, 1000);
        Konsol ps5_1 = new PS5("K003", "PS5 Standard", 25000, 2);
        Konsol ps5_2 = new PS5("K004", "PS5 Digital", 20000, 1);

        // Runtime Polymorphism: Array bertipe superclass
        Konsol[] daftarKonsol = { ps4_1, ps4_2, ps5_1, ps5_2 };

        System.out.println("\nDAFTAR KONSOL TERSEDIA");
        for (Konsol k : daftarKonsol) {
            k.tampilkanInfo();
        }

        System.out.println("\n========================================");
        System.out.println("          PROSES PENYEWAAN");
        System.out.println("========================================");

        // Menyewa PS4 Slim selama 5 jam
        ps4_1.sewa(5);
        System.out.println();

        // Menyewa PS5 Standard selama 3 jam
        ps5_1.sewa(3);
        System.out.println();

        // Polimorfisme Overloading: Hitung diskon (PS4 Pro sewa 4 jam, diskon 15%)
        System.out.println("CONTOH PERHITUNGAN DISKON (Member)");
        double biayaDiskon = ps4_2.hitungBiayaSewa(4, 15);
        System.out.printf("Biaya sewa PS4 Pro 4 jam (Diskon 15%%): Rp%,.0f%n", biayaDiskon);

        // Uji setter overloading
        ps5_2.setTersedia("Tidak Tersedia");
        System.out.println("\nStatus PS5 Digital: " + (ps5_2.isTersedia() ? "Tersedia" : "Sedang Diperbaiki"));

        System.out.println("\n========================================");
        System.out.println("       PROSES PENGEMBALIAN");
        System.out.println("========================================");

        // Mengembalikan konsol
        ps4_1.kembalikan();
        ps5_1.kembalikan();

        // Status Akhir
        System.out.println("\nDAFTAR STATUS AKHIR");
        for (Konsol k : daftarKonsol) {
            System.out.println(k.getTipe() + " : " + (k.isTersedia() ? "Tersedia" : "Disewa/Rusak"));
        }

        System.out.println("\n========================================");
        System.out.println("          PROGRAM SELESAI");
        System.out.println("========================================");
    }
}