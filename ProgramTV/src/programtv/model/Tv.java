package programtv.model;


public class Tv {
    private String kd_tv;
    private String nama;
    private String tglProduksi;
    private String merk;
    private String ukuran;
    private String harga;

    public Tv(String kd_tv, String nama, String tglProduksi, String merk, String ukuran, String harga) {
        this.kd_tv = kd_tv;
        this.nama = nama;
        this.tglProduksi = tglProduksi;
        this.merk = merk;
        this.ukuran = ukuran;
        this.harga = harga;
    }

    public void setKd_tv(String kd_tv) {
        this.kd_tv = kd_tv;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTglProduksi(String tglProduksi) {
        this.tglProduksi = tglProduksi;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKd_tv() {
        return kd_tv;
    }

    public String getNama() {
        return nama;
    }

    public String getTglProduksi() {
        return tglProduksi;
    }

    public String getMerk() {
        return merk;
    }

    public String getUkuran() {
        return ukuran;
    }

    public String getHarga() {
        return harga;
    }

   

    
    
}
