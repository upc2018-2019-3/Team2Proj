package controller;

import dao.Connector;
import model.Car;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

public class CarController {
    private Connection connection;


    public CarController(){
        Connector connector = new Connector();
        connection = connector.getConnection();
    }
/*
* 用户查找车牌号
* */

    public Car selectCar(String carNum) {
        Car car = new Car();
        String sql = "select * from car where carNum=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,carNum);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                car.setCarId(rs.getInt(1));
                car.setCarNum(rs.getString(2));
                car.setStartTime(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
/*插入停车记录*/
    public void insertCar(Car car){
        int carid = car.getCarId();
        String carNum = car.getCarNum();
        String startTime = car.getStartTime();

        try{
            String sql ="insert into car values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,carid);
            preparedStatement.setString(2, carNum);
            preparedStatement.setString(3, startTime);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
* 删除指定停车记录*/
    public void deleteCar(String carnum){
        try{
            String sql = "delete from car where carnum=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,carnum);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CarController carController = new CarController();
        Car car = new Car();
        car.setCarId(2);
        car.setCarNum("123456");
        car.setStartTime(new Date().toString());
        carController.insertCar(car);
        System.out.println(car.toString());
    }
}

