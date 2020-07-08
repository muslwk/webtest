package com.dao.impl;

import com.dao.UserDao;
import com.db.DBUtil;
import com.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) throws SQLException {
        Connection conn = DBUtil.getConn();//获取连接数据库
        String sql = "insert into user (username,password) values(?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);//预编译
        preparedStatement.setString(1,user.getUsername());//setString  给？赋值 String  setInt int
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.executeUpdate();//preparedStatement.executeQuery(); 查   executeUpdate()增删改
        //preparedStatement.close();
        //conn.close();
    }

    @Override
    public List<User> selectUser() throws SQLException {//ResultSet
        Connection conn = DBUtil.getConn();
        String sql ="select * from user";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();//查询
        List<User> list = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User();//生成新地址存储一条数据
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            list.add(user);
        }
        return list;
    }

    @Override
    public User selectUserById(Integer id) throws SQLException {
        Connection conn = DBUtil.getConn();
        String sql ="select * from user where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();
        if(resultSet.next()){
            user.setId(id);
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }
        return user;
    }

    @Override
    public List<User> selectUserByName(String username) throws SQLException {
        Connection conn = DBUtil.getConn();
        String sql ="select * from user where username like concat('%',?,'%')";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> list = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User();//生成新地址存储一条数据
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            list.add(user);
        }
        return list;
    }
}
