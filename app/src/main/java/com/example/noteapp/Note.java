package com.example.noteapp;

import com.orm.SugarRecord;

public class Note extends SugarRecord {
    String massage;
    String datatime;

    public Note() {
    }

    public Note(String massage, String datatime) {
        this.massage = massage;
        this.datatime = datatime;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }
}
