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
public class CHITIETPM {
    private int maPM;
    private int maSach;
    private String trangThai;
    private int soLuong;
    private String ghiChu;

    public CHITIETPM() {
    }
    public String toString(){
        return trangThai ;
    }
    public CHITIETPM(int maPM, int maSach, String trangThai, int soLuong, String ghiChu) {
        this.maPM = maPM;
        this.maSach = maSach;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }
    
    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
