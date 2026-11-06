public class PS5 extends Konsol {
    private int jumlahStik;

    // Constructor dengan super()
    public PS5(String id, String tipe, double tarifPerJam, int jumlahStik) {
        super(id, tipe, tarifPerJam);
        this.jumlahStik = jumlahStik;
    }

    public int getJumlahStik() { return jumlahStik; }
    public void setJumlahStik(int jumlahStik) {
        if (jumlahStik > 0) { this.jumlahStik = jumlahStik; }
    }

    // Implementasi abstract method & Overriding
    @Override
    public double hitungBiayaSewa(int jam) {
        // Misal: PS5 tarifnya otomatis ditambah biaya asuransi 5000/jam
        return (getTarifPerJam() * jam) + (5000 * jam);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("--------------------------------");
        System.out.println("Jenis Konsol    : " + getTipe());
        System.out.println("ID              : " + getId());
        System.out.println("Jumlah Stik     : " + jumlahStik);
        System.out.printf("Tarif per Jam   : Rp%,.0f%n", getTarifPerJam());
        System.out.println("Status          : " + (isTersedia() ? "Tersedia" : "Disewa"));
    }
}