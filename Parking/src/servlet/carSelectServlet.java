package servlet;

import com.alibaba.fastjson.JSON;
import controller.CarController;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class carSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carNum = request.getParameter("carnum");
        CarController carController = new CarController();
        Car car = carController.selectCar(carNum);
        PrintWriter printWriter=response.getWriter();
        printWriter.println(JSON.toJSONString(car));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
