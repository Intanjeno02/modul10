import java.util.*;

public class KatalogBuku {
    public static void main(String[] args) throws Exception {
       Map<String, Buku> katalog = new HashMap<>();

        katalog.put("0000", new Buku("9000", "kancil dan buaya"));
        katalog.put("1111", new Buku("1111", "putri salju"));
        katalog.put("2222", new Buku("2222", "cinderella"));

    }
}
