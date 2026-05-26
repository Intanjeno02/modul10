import java.util.*;
public class Pinjam {
public static void main(String[] args) {
    Map<String, Anggota> daftarAnggota = new HashMap<>();
    daftarAnggota.put("02110", new Anggota("02110", "Tata", "Dosen"));
    daftarAnggota.put("02043", new Anggota("02043", "Tara", "Mahasiswa"));
    daftarAnggota.put("24556", new Anggota("24556", "Tari", "Dosen"));

    Map<String, Buku> katalog = new HashMap<>();
    katalog.put("9000", new Buku("9000", "Kancil dan Buaya"));
    katalog.put("1111", new Buku("1111", "Putri Salju"));
    katalog.put("2222", new Buku("2222", "Cinderella"));

    LinkedList<String> antripinjam = new LinkedList<>();
    antripinjam.addLast("02043#1111");
    antripinjam.addFirst("02110#2222");
    antripinjam.addLast("02043#9000");
    antripinjam.addFirst("24556#2222");

    Map<String, String> bukuDipinjam = new HashMap<>();

    System.out.println("PROSES ANTREAN PEMINJAMAN");
    System.out.println();

    while (!antripinjam.isEmpty()) {
        String data = antripinjam.pollFirst();
        String[] parts = data.split("#");
        String idAnggota = parts[0];
        String isbn = parts[1];

        System.out.println("Memproses : " + data);

        if (!daftarAnggota.containsKey(idAnggota)) {
            System.out.println("DITOLAK   : ID Anggota " + idAnggota + " tidak terdaftar di sistem.");
            System.out.println();
            continue;
        }

        if (!katalog.containsKey(isbn)) {
            System.out.println("DITOLAK   : Buku dengan ISBN " + isbn + " tidak ditemukan di katalog.");
            System.out.println();
            continue;
        }

        if (bukuDipinjam.containsKey(isbn)) {
            String peminjamSekarang = bukuDipinjam.get(isbn);
            String namaPeminjam = daftarAnggota.get(peminjamSekarang).nama;
            System.out.println("DITOLAK   : Buku \"" + katalog.get(isbn).judul + "\" sedang dipinjam oleh " + namaPeminjam + " (" + peminjamSekarang + ").");
            System.out.println();
            continue;
        }

        bukuDipinjam.put(isbn, idAnggota);
        String namaAnggota = daftarAnggota.get(idAnggota).nama;
        System.out.println("BERHASIL  : " + namaAnggota + " meminjam buku \"" + katalog.get(isbn).judul + "\".");
        System.out.println();
    }

        System.out.println("BUKU SEDANG DIPINJAM");
        System.out.println();
        for (Map.Entry<String, String> entry : bukuDipinjam.entrySet()) {
            String isbn = entry.getKey();
            String idAnggota = entry.getValue();
            System.out.println("ISBN: " + isbn + "  Judul: " + katalog.get(isbn).judul + "  Dipinjam oleh: " + daftarAnggota.get(idAnggota).nama + " (" + idAnggota + ")");
        }
    }
}