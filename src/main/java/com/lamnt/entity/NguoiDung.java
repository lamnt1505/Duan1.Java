/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class NguoiDung {
    private String MaND;
    private String MatKhau;
    private String HoTen;
    private Boolean GioiTinh;
    private  Date NgaySinh;
    private String DienThoai;
    private String QueQuan;
    private Double Luong;
    private Boolean VaiTro;

    public NguoiDung() {
    }

    public NguoiDung(String MaND, String MatKhau, String HoTen, Boolean GioiTinh, Date NgaySinh, String DienThoai, String QueQuan, Double Luong, Boolean VaiTro) {
        this.MaND = MaND;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DienThoai = DienThoai;
        this.QueQuan = QueQuan;
        this.Luong = Luong;
        this.VaiTro = VaiTro;
    }
    
    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public Double getLuong() {
        return Luong;
    }

    public void setLuong(Double Luong) {
        this.Luong = Luong;
    }

    public Boolean getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(Boolean VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}
