package model;

public class User {

    private int userId;
    private  String userName;
    private String carNum;
    private float parkFee;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public float getParkFee() {
        return parkFee;
    }

    public void setParkFee(float parkFee) {
        this.parkFee = parkFee;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userId+
                ", username='" + userName + '\'' +
                ", carid='" + carNum + '\'' +
                ", parkfee=" + parkFee +
                '}';
    }
}
