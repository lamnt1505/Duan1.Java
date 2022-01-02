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
public class PhieuMuon {
    private int MaPM;
    private String MaDG;
    private Date NgayMuon;
    private Date NgayTra;
    private String MaND;
    private String TrangThai;
    private String GhiChu;

    public PhieuMuon() {
    }
    public PhieuMuon(int MaPM, String MaDG, Date NgayMuon, Date NgayTra, String MaND, String TrangThai, String GhiChu) {
        this.MaPM = MaPM;
        this.MaDG = MaDG;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
        this.MaND = MaND;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }
    
    public int getMaPM() {
        return MaPM;
    }

    public void setMaPM(int MaPM) {
        this.MaPM = MaPM;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
