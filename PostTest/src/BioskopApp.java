import java.util.*;

public class BioskopApp {

    public static void main(String[] args) {
        Map<String, Film> jadwalFilm = new HashMap<>();
        jadwalFilm.put("F01", new Film("Yowis Ben", 50000));
        jadwalFilm.put("F02", new Film("Warkop DKI Reborn: Jangkrik Boss!", 55000));
        jadwalFilm.put("F03", new Film("Cek Toko Sebelah", 50000));

        Set<String> kursiDipesan = new HashSet<>();
        LinkedList<Transaksi> riwayatTransaksi = new LinkedList<>();

        pesan(jadwalFilm, kursiDipesan, riwayatTransaksi, "Benny", "F01", "A7");
        pesan(jadwalFilm, kursiDipesan, riwayatTransaksi, "Bella", "F02", "G3");
        pesan(jadwalFilm, kursiDipesan, riwayatTransaksi, "Rudia", "F03", "D5");
        pesan(jadwalFilm, kursiDipesan, riwayatTransaksi, "Resti", "F01", "A7");

        System.out.println("Riwayat Transaksi:");
        for (Transaksi t : riwayatTransaksi) {
            System.out.println("Nama Pemesan : " + t.namaPemesan);
            System.out.println("Film    : " + t.judulFilm);
            System.out.println("Kursi   : " + t.noKursi);
            System.out.println("Harga   : Rp" + t.harga);
            System.out.println("                        ");
        }
    }

    static void pesan(Map<String, Film> jadwalFilm, Set<String> kursiDipesan, LinkedList<Transaksi> riwayatTransaksi, String namaPemesan, String kodeFilm, String noKursi) {
        System.out.println("Pemesanan : " + namaPemesan + " -> Film : " + kodeFilm + ", Kursi : " + noKursi);

        if (!jadwalFilm.containsKey(kodeFilm)) {
            System.out.println("Kode film tidak ditemukan.\n");
            return;
        }

        if (kursiDipesan.contains(noKursi)) {
            System.out.println("Kursi nomor " + noKursi + " telah dipesan.");
            System.out.println("Silahkan pilih kursi lain.\n");
            return;
        }

        Film film = jadwalFilm.get(kodeFilm);
        kursiDipesan.add(noKursi);
        riwayatTransaksi.add(new Transaksi(namaPemesan, film.judul, noKursi, film.harga));
        System.out.println("Tiket telah berhasil dipesan.\n");
    }
}