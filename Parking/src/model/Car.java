package model;

import java.util.Date;

public class Car {
    private int carId;
    private String carNum;
    private String startTime;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carNum='" + carNum + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
