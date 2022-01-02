/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.entity.CHITIETPM;
import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CHITIETPMDAO extends QLTVDAO<CHITIETPM,Integer> {

    @Override
    public void insert(CHITIETPM entity) {
        String sql="INSERT CHITIETPM (MaPM, MaSach, TrangThai, SoLuong, GhiChu) VALUES (?,?,?,?,?)";
        XJdbc.update(sql, entity.getMaPM(),
                          entity.getMaSach(),
                          entity.getTrangThai(),
                          entity.getSoLuong(),
                          entity.getGhiChu()
        
        );
    }

    @Override
    public void update(CHITIETPM entity) {
        String sql="UPDATE ChiTietPM SET MaSach = ?, TrangThai = ?, SoLuong = ?, GhiChu = ? WHERE MaPM = ?";
        XJdbc.update(sql,entity.getMaSach(),
                         entity.getTrangThai(),
                         entity.getSoLuong(),
                         entity.getGhiChu(),
                         entity.getMaPM()
                );
    }

    @Override
    public void delete(Integer MaPM) {
         String sql="DELETE FROM ChiTietPM WHERE MaPM = ?";
          XJdbc.update(sql, MaPM);
    }

    @Override
    public CHITIETPM selectById(Integer MaPM) {
        List<CHITIETPM> list = this.selectBySql ("SELECT * FROM ChiTietPM WHERE MaPM = ?",MaPM);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<CHITIETPM> selectAll() {
         String sql = "select * from CHITIETPM";
        return this.selectBySql(sql);
    }

    @Override
    protected List<CHITIETPM> selectBySql(String sql, Object... args) {
        List<CHITIETPM> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                CHITIETPM entity = new CHITIETPM();
                entity.setMaPM(rs.getInt("MaPM"));
                entity.setMaSach(rs.getInt("MaSach"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
