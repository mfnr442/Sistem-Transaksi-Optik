package controller;

import Model.*;
import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    Koneksi koneksi;
    ArrayList<Karyawan> arrKaryawan;
    ArrayList<Produk> arrProduk;
    ArrayList<Pembeli> arrPembeli;
    ArrayList<Transaksi> arrTransaksi;
    ArrayList<Detail_Transaksi> arrDetail;

    public Controller() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrKaryawan = new ArrayList<>();
        this.arrProduk = new ArrayList<>();
        this.arrPembeli = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();
        this.arrDetail = new ArrayList<>();
    }

    public ArrayList<Karyawan> getDataKaryawan() throws SQLException {
        this.arrKaryawan.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM Karyawan");
        while (rs.next()) {
            Karyawan karyawan = new Karyawan();
            karyawan.setId_karyawan(rs.getInt("ID_KARYAWAN"));
            karyawan.setNama_karyawan(rs.getString("NAMA_KARYAWAN"));
            this.arrKaryawan.add(karyawan);
        }
        return this.arrKaryawan;
    }

    public ArrayList<Pembeli> getDataPembeli() throws SQLException {
        this.arrPembeli.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PEMBELI");
        while (rs.next()) {
            Pembeli pembeli = new Pembeli();
            pembeli.setNo_telp(rs.getString("NO_TELP"));
            pembeli.setNama_pembeli(rs.getString("NAMA_PEMBELI"));
            pembeli.setJenis_kelamin(rs.getString("JENIS_KELAMIN"));
            this.arrPembeli.add(pembeli);
        }
        return this.arrPembeli;
    }

    public ArrayList<Produk> getDataProduk() throws SQLException {
        this.arrProduk.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PRODUK JOIN ADMIN "
                + "ON PRODUK.USERNAME = ADMIN.USERNAME ORDER BY ID_PRODUK");
        while (rs.next()) {
            Admin admin = new Admin();
            admin.setUsername(rs.getString("USERNAME"));
            admin.setPassword(rs.getString("PASSWORD"));

            Produk produk = new Produk();
            produk.setId_produk(rs.getInt("ID_PRODUK"));
            produk.setAdmin(admin);
            produk.setMerk(rs.getString("MERK"));
            produk.setJenis(rs.getString("JENIS"));
            produk.setHarga_satuan(rs.getInt("HARGA_SATUAN"));
            this.arrProduk.add(produk);
        }
        return this.arrProduk;
    }

    public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        this.arrTransaksi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM TRANSAKSI JOIN PEMBELI "
                + "ON TRANSAKSI.NO_TELP = PEMBELI.NO_TELP JOIN KARYAWAN "
                + "ON TRANSAKSI.ID_KARYAWAN = KARYAWAN.ID_KARYAWAN ORDER BY ID_TRANSAKSI ASC");
        while (rs.next()) {
            Pembeli pembeli = new Pembeli();
            pembeli.setNo_telp(rs.getString("NO_TELP"));
            pembeli.setNama_pembeli(rs.getString("NAMA_PEMBELI"));
            pembeli.setJenis_kelamin(rs.getString("JENIS_KELAMIN"));

            Karyawan karyawan = new Karyawan();
            karyawan.setId_karyawan(rs.getInt("ID_KARYAWAN"));
            karyawan.setNama_karyawan(rs.getString("NAMA_KARYAWAN"));

            Transaksi transaksi = new Transaksi();
            transaksi.setId_transaksi(rs.getInt("ID_TRANSAKSI"));
            transaksi.setPembeli(pembeli);
            transaksi.setkaryawan(karyawan);
            transaksi.setTanggal_pembelian(new Date(rs.getString("TANGGAL_PEMBELIAN")));

            ResultSet rsDetail_Transaksi = this.koneksi.GetData("SELECT * FROM DETAIL_TRANSAKSI "
                    + "JOIN TRANSAKSI ON DETAIL_TRANSAKSI.ID_TRANSAKSI = TRANSAKSI.ID_TRANSAKSI "
                    + "JOIN PRODUK ON DETAIL_TRANSAKSI.ID_PRODUK = PRODUK.ID_PRODUK "
                    + "WHERE DETAIL_TRANSAKSI.ID_TRANSAKSI = " + rs.getString("ID_TRANSAKSI"));
            ArrayList<Detail_Transaksi> dt = new ArrayList<>();

            while (rsDetail_Transaksi.next()) {
                Admin admin = new Admin();
                admin.setUsername(rsDetail_Transaksi.getString("USERNAME"));

                Produk produk = new Produk();
                produk.setId_produk(rsDetail_Transaksi.getInt("ID_PRODUK"));
                produk.setAdmin(admin);
                produk.setMerk(rsDetail_Transaksi.getString("MERK"));
                produk.setJenis(rsDetail_Transaksi.getString("JENIS"));
                produk.setHarga_satuan(rsDetail_Transaksi.getInt("HARGA_SATUAN"));

                Transaksi t = new Transaksi();
                transaksi.setId_transaksi(rs.getInt("ID_TRANSAKSI"));

                Detail_Transaksi detail_transaksi = new Detail_Transaksi();
                detail_transaksi.setJumlah_produk(rsDetail_Transaksi.getInt("JUMLAH_PRODUK"));
                detail_transaksi.setTransaksi(t);
                detail_transaksi.setProduk(produk);
                dt.add(detail_transaksi);
            }
            transaksi.setarrDetail_Transaksi(dt);
            this.arrTransaksi.add(transaksi);
        }
        return this.arrTransaksi;
    }

    public void insertPembeli(Pembeli pembeli) throws SQLException {

        this.koneksi.ManipulasiData("INSERT INTO PEMBELI VALUES(" + "'" + pembeli.getNo_telp()
                + "'" + "," + "'" + pembeli.getNama_pembeli() + "'" + "," + "'" + pembeli.getJenis_kelamin() + "'" + ") ");
    }

    public void deletePembeli(String nama) throws SQLException {

        this.koneksi.ManipulasiData("DELETE FROM PEMBELI WHERE NAMA_PEMBELI =" + "'" + nama + "'");
    }

    public void updatePembeli(String nama, String No_telp) throws SQLException {

        this.koneksi.ManipulasiData("UPDATE PEMBELI SET NAMA_PEMBELI = " + "'" + nama + "'" + "WHERE NO_TELP="
                + "'" + No_telp + "'");
    }

    public void insertTransaksi(Transaksi transaksi) throws SQLException {
        String datebeli = new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTanggal_pembelian());
        this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI VALUES (forId.NEXTVAL , "
                + transaksi.getPembeli().getNo_telp() + ", "
                + transaksi.getKaryawan().getId_karyawan() + ",TO_DATE('" + datebeli + "','dd/MM/yyyy'))");
        ResultSet rs = this.koneksi.GetData("SELECT forId.CURRVAL FROM DUAL");
        rs.next();
        int id_Transaksi = rs.getInt("CURRVAL");
        for (Detail_Transaksi dt : transaksi.getarrDetail_Transaksi()) {
            this.koneksi.ManipulasiData("INSERT INTO DETAIL_TRANSAKSI VALUES (" + dt.getJumlah_produk() + ","
                    + id_Transaksi + "," + dt.getProduk().getId_produk() + ")");

        }
    }

    public void deleteTransaksi(Integer lok) throws SQLException {

        this.koneksi.ManipulasiData("DELETE FROM TRANSAKSI WHERE ID_TRANSAKSI =" + lok);
    }

}
