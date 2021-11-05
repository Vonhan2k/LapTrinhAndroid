package com.example.bai27_c2;

import java.io.Serializable;
import java.util.Date;

public class BaiHat implements Serializable {
    private String maAlbum;
    private String tenBH;
    private Date ngayraDia;

    public BaiHat(String maAlbum, String tenBH, Date ngayraDia) {
        this.maAlbum = maAlbum;
        this.tenBH = tenBH;
        this.ngayraDia = ngayraDia;
    }

    public String getMaAlbum() {
        return maAlbum;
    }

    public void setMaAlbum(String maAlbum) {
        this.maAlbum = maAlbum;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public Date getNgayraDia() {
        return ngayraDia;
    }

    public void setNgayraDia(Date ngayraDia) {
        this.ngayraDia = ngayraDia;
    }
}
