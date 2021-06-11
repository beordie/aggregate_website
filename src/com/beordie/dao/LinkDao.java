package com.beordie.dao;

import com.beordie.bean.Data;
import com.beordie.bean.Link;
import com.beordie.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkDao implements BaseLinkDao{
    private static final String SQL_FIND_ALL = "select * from type t,link l where t.id=l.type_id order by t.sort,l.sort asc";
    private static final String SQL_FIND_BY_ID = "select content from link where id=?";

    @Override
    public List<Data> findAll() {
        //1. 准备一个集合，用于存储从数据库取出的内容。
        List<Data> data = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //2. 连接数据库
            conn = DBUtil.getConn();
            //3. 预编译数据库的SQL操作环境
            statement = conn.prepareStatement(SQL_FIND_ALL);
            //4. 执行查询
            resultSet = statement.executeQuery();
            //5. 遍历结果，并将每一个连接存储到集合中
            int tempId = 0;
            Data d1 = null;
            List<Link> links = null;
            while(resultSet.next()){
                //5.1 先获取本次拿到的连接数据的类型排序数字是什么。
                int sort = resultSet.getInt("t.id");
                if(tempId != sort){
                    tempId = sort;
                    //发现了一个新的排序的sort值。（已经遍历到了新类型的数据，可以换一个data去组装数据了）
                    d1 = new Data();
                    //5.2 向d1中存类型名称
                    String name = resultSet.getString("t.name");
                    d1.setType(name);
                    //5.3 向d1中存次类型的连接集links
                    links = new ArrayList<>();
                    d1.setLinks(links);
                    //将d1存储到data中
                    data.add(d1);
                }
                //5.4 取出一个个的连接，存储到links中
                String content = resultSet.getString("content");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int count = resultSet.getInt("count");
                int icon = resultSet.getInt("icon");
                int id = resultSet.getInt("l.id");
                int lSort = resultSet.getInt("l.sort");
                int typeId = resultSet.getInt("t.id");
                Link link = new Link(content,count,description,icon,id,sort,title,typeId);
                links.add(link);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7. 关闭连接
            DBUtil.close(conn,statement,resultSet);
        }
        return data;
    }

    @Override
    public String findById(int id) {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1. 连接数据库
            conn = DBUtil.getConn();
            //2. 预编译数据库的SQL操作环境
            statement = conn.prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1,id);
            //4. 执行查询
            resultSet = statement.executeQuery();
            //5. 遍历结果
            if(resultSet.next()){
                return resultSet.getString("content");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7. 关闭连接
            DBUtil.close(conn,statement,resultSet);
        }
        return null;
    }
}
