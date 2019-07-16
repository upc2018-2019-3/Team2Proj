package controller;

import dao.Connector;
import model.Admin;
import model.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogController {
    private Connection connection;

    public LogController(){
        Connector connector = new Connector();
        connection = connector.getConnection();
    }
/**
**  在log表中插入最终的停车记录
* */
    public void insertLog(Log log){
        int logid = log.getLogid();
        String carNum = log.getCarNum();
        String startTime = log.getStartTime();
        String endTime = log.getEndTime();
        String duraTime = log.getDuraTime();
        int consum = log.getConsum();

        try{
            String sql = "insert into log values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,logid);
            preparedStatement.setString(2,carNum);
            preparedStatement.setString(3,startTime);
            preparedStatement.setString(4,endTime);
            preparedStatement.setString(5,duraTime);
            preparedStatement.setInt(6,consum);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
/*
查找停车记录并返回所有
 */

    public Log selectLog(String carNum) {
        Log log = new Log();
        String sql = "select * from log where carnum=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,carNum);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                log.setLogid(rs.getInt(1));
                log.setCarNum(rs.getString(2));
                log.setStartTime(rs.getString(3));
                log.setEndTime(rs.getString(4));
                log.setDuraTime(rs.getString(5));
                log.setConsum(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log;
    }

}
