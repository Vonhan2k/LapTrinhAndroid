package com.example.bai20_c2;

public class SanPham {
    String tenHinh;
    String tenSanPham;
    String danhMuc;

    public SanPham(String tenHinh, String tenSanPham, String danhMuc) {
        this.tenHinh = tenHinh;
        this.tenSanPham = tenSanPham;
        this.danhMuc = danhMuc;
    }

    public String getTenHinh() {
        return tenHinh;
    }

    public void setTenHinh(String tenHinh) {
        this.tenHinh = tenHinh;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }
}
