/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.entity.DocGia;
import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DocGiaDAO extends QLTVDAO<DocGia, String> {

    @Override
    public void insert(DocGia entity) {
        String sql = "INSERT INTO DocGia (MaDG, HoTen, GioiTinh, SDT, Email, DiaChi)VALUES(?, ?, ?, ?, ?, ?)";
                 XJdbc.update(sql,
                    entity.getMaDG(),
                    entity.getHoTen(),
                    entity.isGioiTinh(),
                    entity.getSDT(),
                    entity.getEmail(),
                    entity.getDiaChi()
                 );
    }

    @Override
    public void update(DocGia entity) {
        String sql ="UPDATE DocGia SET HoTen = ?, GioiTinh = ?, SDT = ?, Email = ?, DiaChi = ? WHERE MaDG = ?";
         XJdbc.update(sql,
                 entity.getHoTen(),
                 entity.isGioiTinh(),
                 entity.getSDT(),
                 entity.getEmail(),
                 entity.getDiaChi(),
                 entity.getMaDG()
         );
    }

    @Override
    public void delete(String MaDG) {
        String sql ="DELETE FROM DocGia WHERE MaDG = ?";
        XJdbc.update(sql, MaDG);
    }

    @Override
    public DocGia selectById(String MaDG) {
         List<DocGia> list = this.selectBySql("SELECT * FROM DocGia WHERE MaDG=?",MaDG);
          return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DocGia> selectAll() {
          String sql = "SELECT * FROM DocGia";
        return this.selectBySql(sql);
    }

    @Override
    protected List<DocGia> selectBySql(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                DocGia entity = new DocGia();
                entity.setMaDG(rs.getString("MaDG"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEmail(rs.getString("Email"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 
    public List<DocGia> selectByKeyword(String keyword) {
        String sql = "select * from DocGia where Email like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
