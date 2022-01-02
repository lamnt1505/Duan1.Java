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
public class LoaiSach {
    private int maLoai;
    private String tenLoai;
    private String viTri;
    
    public String toString(){
        return tenLoai;
    }
    public LoaiSach() {
    }

    public LoaiSach(int maLoai, String tenLoai, String viTri) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.viTri = viTri;
    }
    
    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    
}
