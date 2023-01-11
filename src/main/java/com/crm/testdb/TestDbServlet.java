package com.crm.testdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //set up connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        // get connection to db
        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to db: "+ jdbcUrl);
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
            out.println("SCUCCESS");
            conn.close();

        }catch (Exception exception){
            exception.printStackTrace();
            throw new ServletException(exception);
        }
    }

}
