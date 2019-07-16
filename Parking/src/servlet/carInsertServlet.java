package servlet;

import controller.CarController;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class carInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carid = request.getParameter("carid");
        String carNum = request.getParameter("carNum");
        String startTime = request.getParameter("starttime");
        Car car = new Car();
        car.setCarId(Integer.valueOf(carid));
        car.setCarNum(carNum);
        car.setStartTime(startTime);
        CarController carController = new CarController();
        carController.insertCar(car);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
