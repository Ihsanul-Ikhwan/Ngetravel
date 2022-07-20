package com.ihsan.ngetravel.model;

import com.google.gson.annotations.SerializedName;

public class BeliModel {
    @SerializedName("idtiket")
    private String idtiket;

    @SerializedName("email")
    private String email;

    @SerializedName("harga")
    private String password;

    public String getIdtiket() {
        return idtiket;
    }

    public void setIdtiket(String idtiket) {
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

    public BeliModel(String idtiket, String email, String password) {
        this.idtiket = idtiket;
        this.email = email;
        this.password = password;
    }
}
