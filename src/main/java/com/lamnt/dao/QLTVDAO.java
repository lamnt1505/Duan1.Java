/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.dao;

import java.util.List;

/**
 *
 * @author DELL
 */
 abstract public  class QLTVDAO <EntityType,KeyType> {
    abstract public void insert(EntityType entity);//EntityType: NhanVien,
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);//KeyType: String, Integer, Double...
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql, Object...args);
}
