package com.ihsan.ngetravel.model;

import com.google.gson.annotations.SerializedName;

public class BeliModel {
    @SerializedName("idtiket")
    private int idtiket;

    @SerializedName("email")
    private String email;

    @SerializedName("harga")
    private String password;

    public int getIdtiket() {
        return idtiket;
    }

    public void setIdtiket(int idtiket) {
        this.idtiket = idtiket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BeliModel(int idtiket, String email, String password) {
        this.idtiket = idtiket;
        this.email = email;
        this.password = password;
    }
}
