package com.ihsan.ngetravel.model;

import com.google.gson.annotations.SerializedName;

public class TiketModel {
    @SerializedName("asal")
    private String asal;

    @SerializedName("tujuan")
    private String tujuan;

    @SerializedName("berangkat")
    private String berangkat;

    @SerializedName("sampai")
    private String sampai;

    @SerializedName("jam")
    private String jam;

    @SerializedName("harga")
    private String harga;

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getBerangkat() {
        return berangkat;
    }

    public void setBerangkat(String berangkat) {
        this.berangkat = berangkat;
    }

    public String getSampai() {
        return sampai;
    }

    public void setSampai(String sampai) {
        this.sampai = sampai;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public TiketModel(String asal, String tujuan, String berangkat, String sampai, String jam, String harga) {
        this.asal = asal;
        this.tujuan = tujuan;
        this.berangkat = berangkat;
        this.sampai = sampai;
        this.jam = jam;
        this.harga = harga;
    }
}
