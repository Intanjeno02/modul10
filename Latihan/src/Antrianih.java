import java.util.*;

public class Antrianih {

    public static void tampilkanAntri(LinkedList<String> antrean, String event) {
        System.out.println("--- " + event + " ---");
        System.out.println("Isi Antrean (format idAnggota#isbn):");
        if (antrean.isEmpty()) {
            System.out.println("(Antrean Kosong)");
        } else {
            for (String data : antrean) {
                System.out.println("- " + data);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> antripinjam = new LinkedList<>();

        System.out.println("MULAI SIMULASI ANTREAN PEMINJAMAN");
        tampilkanAntri(antripinjam, "Awal");

        String data1 = "02043#1111";
        antripinjam.addLast(data1);
        tampilkanAntri(antripinjam, "Simulasi ke 1 (Mahasiswa Tara masuk)");

        String data2 = "02110#2222";
        antripinjam.addFirst(data2);
        tampilkanAntri(antripinjam, "Simulasi ke 2 (Dosen Tata masuk - Memotong ke depan)");

        String data3 = "02043#9000";
        antripinjam.addLast(data3);
        tampilkanAntri(antripinjam, "Simulasi ke 3 (Mahasiswa Tara masuk - pinjam buku lain)");

        String data4 = "24556#2222";
        antripinjam.addFirst(data4);
        tampilkanAntri(antripinjam, "Simulasi ke 4 (Dosen Tari masuk - Memotong ke depan)");

        System.out.println("SIMULASI TELAH SELESAI");
        System.out.println("Antrean Final sudah siap diproses.");
    }

    
}