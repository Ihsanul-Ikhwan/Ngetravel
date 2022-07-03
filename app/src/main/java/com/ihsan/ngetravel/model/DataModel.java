package com.ihsan.ngetravel.model;

import java.util.List;

public class DataModel {
    private int code;
    private String message;
    List<UserModel> userModelList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserModel> getUserModelList() {
        return userModelList;
    }

    public void setUserModelList(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    public DataModel(int code, String message, List<UserModel> userModelList) {
        this.code = code;
        this.message = message;
        this.userModelList = userModelList;
    }
}
