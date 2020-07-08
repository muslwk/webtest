package com.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AjaxServlet",value = {"/servlet/AjaxServlet"})
public class AjaxServlet extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("+++++++++++++");
        try {
            request.setCharacterEncoding("utf-8");//字符编码
            response.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            System.out.println(username);
            List<User> list = userDao.selectUserByName(username);
            System.out.println(list);

            PrintWriter pw = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject(list);
            pw.println(jsonArray.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
