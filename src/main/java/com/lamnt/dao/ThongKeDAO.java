/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object...args){
       try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    public List<Object[]> getPhieuMuon() {
        String sql = "{CALL sp_PhieuMuon()}";
        String[] cols = {"MaPM", "MaDG", "HoTen", "NgayMuon", "NgayTra", "TrangThai"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getPhieuMuonDT() {
        String sql = "{CALL sp_PhieuMuonDT()}";
        String[] cols = {"MaPM", "MaDG", "HoTen", "NgayMuon", "NgayTra", "TrangThai"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getPhieuMuonCT() {
        String sql = "{CALL sp_PhieuMuonCT()}";
        String[] cols = {"MaPM", "MaDG", "HoTen", "NgayMuon", "NgayTra", "TrangThai"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getNgayMuon(String ngayBD, String ngayKT) {
        String sql = "{CALL sp_NgayPM(?,?)}";
        String[] cols = {"MaPM", "MaDG", "HoTen", "NgayMuon", "NgayTra", "TrangThai"};
        return this.getListOfArray(sql, cols, ngayBD, ngayKT);
    }
    public List<Object[]> getTopSach() {
        String sql = "{CALL sp_TopSachMuon()}";
        String[] cols = {"MaSach", "TenSach", "SL"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getTopDG() {
        String sql = "{CALL sp_TopDGMuon()}";
        String[] cols = {"MaDG", "HoTen", "MaPM", "MaSach"};
        return this.getListOfArray(sql, cols);
    }
     public List<Object[]> getTopSachM(int thang, int nam) {
        String sql = "{CALL sp_SachMuon(?,?)}";
        String[] cols = {"MaSach", "TenSach", "SL"};
        return this.getListOfArray(sql, cols, thang, nam);
    }
     public List<Object[]> getTopDGM(int thang,int nam) {
        String sql = "{CALL sp_DGMuonSach(?,?)}";
        String[] cols = {"MaDG", "HoTen", "MaPM", "MaSach"};
        return this.getListOfArray(sql, cols,thang, nam);
    }
}
