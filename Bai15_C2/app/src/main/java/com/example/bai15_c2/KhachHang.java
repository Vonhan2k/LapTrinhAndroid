package com.example.bai15_c2;

public class KhachHang {
    private String HoTen;
    private int SoluongSach;
    private boolean Vip;
    private int ThanhTien;



    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getSoluongSach() {
        return SoluongSach;
    }

    public void setSoluongSach(int soluongSach) {
        SoluongSach = soluongSach;
    }

    public boolean isVip() {
        return Vip;
    }

    public void setVip(boolean vip) {
        Vip = vip;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        ThanhTien = thanhTien;
    }

    public KhachHang(String hoTen, int soluongSach, boolean vip, int thanhTien) {
        HoTen = hoTen;
        SoluongSach = soluongSach;
        Vip = vip;
        ThanhTien = thanhTien;
    }

    public KhachHang (KhachHang kh){

    }
}
