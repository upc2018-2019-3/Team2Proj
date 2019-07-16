package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
/*
* 连接数据库
* */
    public Connection getConnection(){
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/park?serverTimezone=Asia/Shanghai";
        String user = "root";
        String pwd = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
    }
}
