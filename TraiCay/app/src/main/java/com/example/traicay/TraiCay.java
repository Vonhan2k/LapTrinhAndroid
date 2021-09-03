package com.example.traicay;

public class TraiCay {
    private String Ten;
    private String MoTa;
    private String GiaBan;
    private int Hinh;

    public TraiCay(String ten, String moTa, String giaBan, int hinh) {
        Ten = ten;
        MoTa = moTa;
        GiaBan = giaBan;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String giaBan) {
        GiaBan = giaBan;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
