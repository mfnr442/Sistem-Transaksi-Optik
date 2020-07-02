package Model;

public class Detail_Transaksi {

    private Integer jumlah_produk;
    private Transaksi transaksi;
    private Produk produk;

    public void setJumlah_produk(Integer jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public Integer getJumlah_produk() {
        return jumlah_produk;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Produk getProduk() {
        return produk;
    }
}
