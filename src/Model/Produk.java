package Model;

public class Produk {

    private Integer Id_produk;
    private Admin admin;
    private String Merk;
    private String Jenis;
    private int Harga_satuan;

    public void setId_produk(Integer id_produk) {
        this.Id_produk = id_produk;
    }

    public Integer getId_produk() {
        return Id_produk;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setMerk(String merk) {
        this.Merk = merk;
    }

    public String getMerk() {
        return Merk;
    }

    public void setJenis(String jenis) {
        this.Jenis = jenis;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setHarga_satuan(int harga_satuan) {
        this.Harga_satuan = harga_satuan;
    }

    public int getHarga_satuan() {
        return Harga_satuan;
    }

}
