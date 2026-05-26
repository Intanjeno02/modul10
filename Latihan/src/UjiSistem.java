import java.util.*;

class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Anggota anggota = (Anggota) o;
    return Objects.equals(idAnggota, anggota.idAnggota);
    }

    @Override
    public int hashCode() {
    return Objects.hash(idAnggota);
    }

}

public class UjiSistem {
    public static void main(String[] args) {
        Set<Anggota> daftarAnggota = new HashSet<>();
        daftarAnggota.add(new Anggota("02110", "Tata", "Dosen"));
        daftarAnggota.add(new Anggota("02043", "Tara", "Mahasiswa"));
        daftarAnggota.add(new Anggota("24556", "Tari", "Dosen"));
        daftarAnggota.add(new Anggota("24556", "Ture", "Mahasiswa"));

        System.out.println(daftarAnggota.size());
    }
}
