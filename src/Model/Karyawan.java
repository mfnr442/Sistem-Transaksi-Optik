package Model;

public class Karyawan {

    private Integer Id_karyawan;
    private String Nama_karyawan;

    public void setId_karyawan(Integer id_karyawan) {
        this.Id_karyawan = id_karyawan;
    }

    public Integer getId_karyawan() {
        return Id_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.Nama_karyawan = nama_karyawan;
    }

    public String getNama_karyawan() {
        return Nama_karyawan;
    }
}
