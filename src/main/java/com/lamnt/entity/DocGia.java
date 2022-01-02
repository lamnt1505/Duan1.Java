/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.entity;

/**
 *
 * @author DELL
 */
public class DocGia {
    private String MaDG;
    private String HoTen;
    private boolean GioiTinh;
    private String SDT;
    private String Email;
    private String DiaChi;

    public DocGia() {
    }

    public DocGia(String MaDG, String HoTen, boolean GioiTinh, String SDT, String Email, String DiaChi) {
        this.MaDG = MaDG;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
    }
    
    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}
