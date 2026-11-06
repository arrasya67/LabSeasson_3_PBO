public abstract class Konsol implements DapatDisewa {

    // Atribut private untuk Encapsulation
    private String id;
    private String tipe; // Contoh: PS4 / PS5
    private double tarifPerJam;
    private boolean tersedia;

    // Constructor
    public Konsol(String id, String tipe, double tarifPerJam) {
        this.id = id;
        this.tipe = tipe;
        this.tarifPerJam = tarifPerJam;
        this.tersedia = true;
    }

    // Getter
    public String getId() { return id; }
    public String getTipe() { return tipe; }
    public double getTarifPerJam() { return tarifPerJam; }
    public boolean isTersedia() { return tersedia; }

    // Setter
    public void setId(String id) { this.id = id; }
    public void setTipe(String tipe) { this.tipe = tipe; }
    public void setTarifPerJam(double tarifPerJam) {
        if (tarifPerJam > 0) { this.tarifPerJam = tarifPerJam; }
    }

    // Method overloading (parameter berbeda)
    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
    public void setTersedia(String status) {
        this.tersedia = status.equalsIgnoreCase("tersedia");
    }

    // Abstract method (wajib diimplementasikan subclass)
    public abstract double hitungBiayaSewa(int jam);
    public abstract void tampilkanInfo();

    // Method overloading untuk hitung biaya dengan diskon
    public double hitungBiayaSewa(int jam, double diskonPersen) {
        double total = hitungBiayaSewa(jam);
        return total - (total * diskonPersen / 100);
    }

    // Implementasi method interface
    @Override
    public double sewa(int jam) {
        if (!tersedia) {
            System.out.println("Konsol " + tipe + " sedang tidak tersedia.");
            return 0;
        }
        if (jam <= 0) {
            System.out.println("Lama sewa harus lebih dari 0 jam.");
            return 0;
        }

        double total = hitungBiayaSewa(jam);
        tersedia = false;

        System.out.println("Konsol berhasil disewa.");
        System.out.println("Tipe Konsol    : " + tipe);
        System.out.println("Lama sewa      : " + jam + " jam");
        System.out.printf("Total biaya    : Rp%,.0f%n", total);
        return total;
    }

    @Override
    public void kembalikan() {
        if (tersedia) {
            System.out.println("Konsol " + tipe + " sudah ada di tempat.");
        } else {
            tersedia = true;
            System.out.println("Konsol " + tipe + " berhasil dikembalikan.");
        }
    }
}