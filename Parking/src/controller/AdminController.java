package controller;

import dao.Connector;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AdminController {
    private Connection connection = null;


    public  AdminController(){
        Connector connector =new Connector();
        connection =connector.getConnection();
    }
    /*
    验证登录账户密码是否正确
     */
    public  boolean checkAdmin(String adminId, String adminPassword){
        Statement stmt =null;
        ResultSet result=null;
        Admin admin =new Admin();
        boolean ifright=false;
         try {
             String sql ="Select *from admin where adminid=\""+adminId+"\" and adminpassword=\""+adminPassword+"\"";
             stmt = connection.createStatement();
             result=stmt.executeQuery(sql);
             if(result.next())
             {
                 ifright=true;
             }
             result.close();
             stmt.close();
             connection.close();
         }catch (Exception e){
             System.out.println(e);
         }
         return ifright;
    }


/*
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        boolean b = adminController.checkAdmin("16820","1234");
        System.out.println(b);
    }
*/

}

