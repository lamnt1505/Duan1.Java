/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import com.lamnt.entity.Sach;
import com.lamnt.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SachDAO extends QLTVDAO<Sach,Integer> {

    @Override
    public void insert(Sach entity) {
        String sql="INSERT INTO Sach(TenSach,MaLoai,TenNXB,TacGia,SoLuong, NoiDung,Hinh) VALUES (?,?,?,?,?,?,?)";
         XJdbc.update(sql,
                          entity.getTenSach(),
                          entity.getMaLoai(),
                          entity.getTenNXB(),
                          entity.getTacGia(),
                          entity.getSoLuong(),
                          entity.getNoiDung(),
                          entity.getHinh()
                 );
    }

    @Override
    public void update(Sach entity) {
        String sql ="UPDATE Sach SET TenSach=?,MaLoai = ?,TenNXB=?,TacGia=?,SoLuong=?,NoiDung=?,Hinh=? WHERE MaSach=?";
        XJdbc.update(sql,entity.getTenSach(),
                entity.getMaLoai(),
                entity.getTenNXB(),
                entity.getTacGia(),
                entity.getSoLuong(),
                entity.getNoiDung(),
                entity.getHinh(),
                entity.getMaSach()
        );
    }

    @Override
    public void delete(Integer MaSach) {
        String sql ="DELETE FROM Sach WHERE MaSach = ?";
          XJdbc.update(sql, MaSach);
    }

    @Override
    public Sach selectById(Integer MaSach) {
          List<Sach> list = this.selectBySql ("SELECT * FROM SACH WHERE MaSach=?",MaSach);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Sach> selectAll() {
        String sql = "SELECT * FROM Sach";
        return this.selectBySql(sql);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        	try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSach(rs.getInt("MaSach"));
                entity.setTenSach(rs.getString("TenSach"));
                entity.setMaLoai(rs.getInt("MaLoai"));
                entity.setTenNXB(rs.getString("TenNXB"));
                entity.setTacGia(rs.getString("TacGia"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setNoiDung(rs.getString("NoiDung"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
            
        }
    }
    public List<Sach> selectByKeyword(String keyword) {
        String sql = "select * from Sach where TenSach like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
