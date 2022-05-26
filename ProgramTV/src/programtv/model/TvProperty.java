/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TvProperty {
    private StringProperty kd_tv;
    private StringProperty nama_produk;
    private StringProperty tgl_produksi;
    private StringProperty merk;
    private StringProperty ukuran;
    private StringProperty harga;

    public TvProperty(String kd_tv, String nama_produk, String tgl_produksi, String merk, String ukuran, String harga) {
        this.kd_tv = new SimpleStringProperty(kd_tv);
        this.nama_produk = new SimpleStringProperty(nama_produk);
        this.tgl_produksi = new SimpleStringProperty(tgl_produksi);
        this.merk = new SimpleStringProperty(merk);
        this.ukuran = new SimpleStringProperty(ukuran);
        this.harga = new SimpleStringProperty(harga);
    }
    
    public TvProperty(Tv t) {
        this.kd_tv = new SimpleStringProperty(t.getKd_tv());
        this.nama_produk = new SimpleStringProperty(t.getNama());
        this.tgl_produksi = new SimpleStringProperty(t.getTglProduksi());
        this.merk = new SimpleStringProperty(t.getMerk());
        this.ukuran = new SimpleStringProperty(t.getUkuran());
        this.harga = new SimpleStringProperty(t.getHarga());
    }
    
    public StringProperty getKd_tvProperty() {
        return kd_tv;
    }

    public void setKd_tv(String kd_tv) {
        this.kd_tv = new SimpleStringProperty (kd_tv);
    }

    public StringProperty getNama_produkProperty() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = new SimpleStringProperty (nama_produk);
    }

    public StringProperty getTgl_produksiProperty() {
        return tgl_produksi;
    }

    public void setTgl_produksi(String tgl_produksi) {
        this.tgl_produksi = new SimpleStringProperty (tgl_produksi);
    }

    public StringProperty getMerkProperty() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = new SimpleStringProperty (merk);
    }

    public StringProperty getUkuranProperty() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = new SimpleStringProperty (ukuran);
    }

    public StringProperty getHargaProperty() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = new SimpleStringProperty (harga);
    }

    public String getKd_tv() {
        return kd_tv.get();
    }

    public String getNama_produk() {
        return nama_produk.get();
    }

    public String getTgl_produksi() {
        return tgl_produksi.get();
    }

    public String getMerk() {
        return merk.get();
    }

    public String getUkuran() {
        return ukuran.get();
    }

    public String getHarga() {
        return harga.get();
    }
}
