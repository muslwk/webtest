package com.dao;

import com.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public void addUser(User user) throws SQLException;

    public List<User> selectUser() throws SQLException;

    //按ID查询
    public User selectUserById(Integer id) throws SQLException;

    //模糊查询
    public List<User> selectUserByName(String username) throws SQLException;
}
