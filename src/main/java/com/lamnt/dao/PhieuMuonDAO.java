/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.entity.PhieuMuon;
import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class PhieuMuonDAO extends QLTVDAO<PhieuMuon, Integer> {

    @Override
    public void insert(PhieuMuon entity) {
        String sql ="INSERT PHIEUMUON ( MaDG, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES ( ?, ?, ?, ?, ?, ?)";
         XJdbc.update(sql,
                          entity.getMaDG(),
                          entity.getNgayMuon(),
                          entity.getNgayTra(),
                          entity.getMaND(),
                          entity.getTrangThai(),
                          entity.getGhiChu()
         );
    }

    @Override
    public void update(PhieuMuon entity) {
        String sql ="UPDATE PHIEUMUON SET MaDG = ?, NgayMuon = ?, NgayTra = ?, MaND = ?, TrangThai = ?, GhiChu = ? WHERE MaPM = ?";
        XJdbc.update(sql,entity.getMaDG(),
                         entity.getNgayMuon(),
                         entity.getNgayTra(),
                         entity.getMaND(),
                         entity.getTrangThai(),
                         entity.getGhiChu(),
                         entity.getMaPM()
        );
    }

    @Override
    public void delete(Integer MaPM) {
        String sql ="DELETE FROM PHIEUMUON WHERE MaPM = ?";
        XJdbc.update(sql, MaPM);
    }

    @Override
    public PhieuMuon selectById(Integer MaPM) {
        List<PhieuMuon> list = this.selectBySql("SELECT * FROM PHIEUMUON WHERE MaPM = ?",MaPM);
          return list.size() > 0 ? list.get(0) : null;
        
    }

    @Override
    public List<PhieuMuon> selectAll() {
        String sql = "SELECT * FROM PHIEUMUON";
        return this.selectBySql(sql);
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPM(rs.getInt("MaPM"));
                pm.setMaDG(rs.getString("MaDG"));
                pm.setNgayMuon(rs.getDate("NgayMuon"));
                pm.setNgayTra(rs.getDate("NgayTra"));
                pm.setMaND(rs.getString("MaND"));
                pm.setTrangThai(rs.getString("TrangThai"));
                pm.setGhiChu(rs.getString("GhiChu"));
                list.add(pm);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
