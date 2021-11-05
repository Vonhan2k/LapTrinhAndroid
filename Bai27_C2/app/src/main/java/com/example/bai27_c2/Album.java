package com.example.bai27_c2;

import java.io.Serializable;

public class Album implements Serializable {
    private String maAlbum;
    private String tenAlbum;

    public Album(String maAlbum, String tenAlbum) {
        this.maAlbum = maAlbum;
        this.tenAlbum = tenAlbum;
    }

    public String getMaAlbum() {
        return maAlbum;
    }

    public void setMaAlbum(String maAlbum) {
        this.maAlbum = maAlbum;
    }

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }

    @Override
    public String toString() {
        return  tenAlbum;

    }
}
