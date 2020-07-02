package Model;

import java.util.ArrayList;
import java.util.Date;

public class Transaksi {

    private Integer Id_transaksi;
    private Pembeli pembeli;
    private Karyawan karyawan;
    private Date Tanggal_pembelian;
    private ArrayList<Detail_Transaksi> arrDetail_Transaksi;

    public void setId_transaksi(Integer id_transaksi) {
        this.Id_transaksi = id_transaksi;
    }

    public Integer getId_transaksi() {
        return Id_transaksi;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setkaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setTanggal_pembelian(Date tanggal_pembelian) {
        this.Tanggal_pembelian = tanggal_pembelian;
    }

    public Date getTanggal_pembelian() {
        return Tanggal_pembelian;
    }

    public void setarrDetail_Transaksi(ArrayList<Detail_Transaksi> arrDetail_Transaksi) {
        this.arrDetail_Transaksi = arrDetail_Transaksi;
    }

    public ArrayList<Detail_Transaksi> getarrDetail_Transaksi() {
        return arrDetail_Transaksi;
    }
}
