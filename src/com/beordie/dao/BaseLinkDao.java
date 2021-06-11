package com.beordie.dao;

import com.beordie.bean.Data;

import java.util.List;

public interface BaseLinkDao {
    /**
     * 用于获取所有的连接信息
     * @return
     */
    List<Data> findAll();


    /**
     * 用于根据连接的id，查询对应的连接内容
     * @param id 要查询的id
     * @return 查询到的内容
     */
    String findById(int id);
}
