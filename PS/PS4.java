public class PS4 extends Konsol {
    private int kapasitasHdd; // dalam GB

    // Constructor dengan super()
    public PS4(String id, String tipe, double tarifPerJam, int kapasitasHdd) {
        super(id, tipe, tarifPerJam);
        this.kapasitasHdd = kapasitasHdd;
    }

    public int getKapasitasHdd() { return kapasitasHdd; }
    public void setKapasitasHdd(int kapasitasHdd) {
        if (kapasitasHdd > 0) { this.kapasitasHdd = kapasitasHdd; }
    }

    // Implementasi abstract method & Overriding
    @Override
    public double hitungBiayaSewa(int jam) {
        return getTarifPerJam() * jam;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("--------------------------------");
        System.out.println("Jenis Konsol    : " + getTipe());
        System.out.println("ID              : " + getId());
        System.out.println("Kapasitas HDD   : " + kapasitasHdd + " GB");
        System.out.printf("Tarif per Jam   : Rp%,.0f%n", getTarifPerJam());
        System.out.println("Status          : " + (isTersedia() ? "Tersedia" : "Disewa"));
    }
}