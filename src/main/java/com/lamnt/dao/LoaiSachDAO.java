/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.entity.LoaiSach;
import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DELL
 */
public class LoaiSachDAO extends QLTVDAO<LoaiSach,Integer> {

    @Override
    public void insert(LoaiSach entity) {
        String sql="INSERT LS (TenLoai, ViTri) VALUES (?,?)";
        XJdbc.update(sql,
                         entity.getTenLoai(),
                         entity.getViTri()
                );
    }

    @Override
    public void update(LoaiSach entity) {
        String sql="UPDATE LS SET TenLoai = ? , ViTri= ? WHERE MaLoai = ?";
        XJdbc.update(sql,entity.getTenLoai(),
                         entity.getViTri(),
                         entity.getMaLoai()
                );
    }

    @Override
    public void delete(Integer MaLoai) {
        String sql="DELETE FROM LS WHERE MaLoai = ?";
        XJdbc.update(sql, MaLoai);
    }

    @Override
    public LoaiSach selectById(Integer MaLoai) {
        List<LoaiSach> list = this.selectBySql("SELECT * FROM LS WHERE MaLoai= ?",MaLoai);
          return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiSach> selectAll() {
         String sql = "SELECT * FROM LS";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LoaiSach> selectBySql(String sql, Object... args) {
        List<LoaiSach> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                LoaiSach entity = new LoaiSach();
                entity.setMaLoai(rs.getInt("MaLoai"));
                entity.setTenLoai(rs.getString("TenLoai"));
                entity.setViTri(rs.getString("ViTri"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }  
}
