/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.entity.NguoiDung;
import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class NguoiDungDAO extends QLTVDAO <NguoiDung, String> {

    @Override
    public void insert(NguoiDung entity) {
        String sql = "INSERT INTO NguoiDung (MaND, MatKhau, HoTen,GioiTinh,NgaySinh,DienThoai,QueQuan,Luong,VaiTro)"
                + "VALUES (?, ?, ?, ?,?,?,?,?,?)";
        XJdbc.update(sql,entity.getMaND(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getDienThoai(),
                entity.getQueQuan(),
                entity.getLuong(),  
                entity.getVaiTro());
    }

    @Override
    public void update(NguoiDung entity) {
         String sql = "UPDATE NguoiDung SET MatKhau=?, HoTen=? , GioiTinh=?,NgaySinh=?,"
                 + "DienThoai=?,QueQuan=?,Luong=?,VaiTro=? WHERE MaND=?";
        XJdbc.update(sql,entity.getMatKhau(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getDienThoai(),
                entity.getQueQuan(),
                entity.getLuong(),
                entity.getVaiTro(),
                entity.getMaND());
    }

    @Override
    public void delete(String MaND) {
        String sql = "DELETE FROM NguoiDung WHERE MaND=?";
        XJdbc.update(sql, MaND);
    }

    @Override
    public NguoiDung selectById(String MaND) {
          List<NguoiDung> list = this.selectBySql("SELECT * FROM NguoiDung WHERE  MaND=?", MaND);
          return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NguoiDung> selectAll() {
        String sql = "SELECT * FROM NguoiDung";
        return this.selectBySql(sql);
    }

    @Override
    protected List<NguoiDung> selectBySql(String sql, Object... args) {
         List<NguoiDung> list = new ArrayList<NguoiDung>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            try {      
                while (rs.next()) {
                    NguoiDung nd = new NguoiDung();
                    nd.setMaND(rs.getString("MaND"));
                    nd.setMatKhau(rs.getString("MatKhau"));
                    nd.setHoTen(rs.getString("HoTen"));
                    nd.setGioiTinh(rs.getBoolean("GioiTinh"));
                    nd.setNgaySinh(rs.getDate("NgaySinh"));
                    nd.setDienThoai(rs.getString("DienThoai"));
                    nd.setQueQuan(rs.getString("QueQuan"));
                    nd.setLuong(rs.getDouble("Luong"));
                    nd.setVaiTro(rs.getBoolean("VaiTro"));
                    list.add(nd);
                }
            } finally {
                rs.getStatement().getConnection().close();
                return list;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
