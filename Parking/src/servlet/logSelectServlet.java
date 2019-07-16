package servlet;

import com.alibaba.fastjson.JSON;
import controller.CarController;
import controller.LogController;
import model.Car;
import model.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class logSelectServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carNum = request.getParameter("carnum");
        LogController logController = new LogController();
        Log log = logController.selectLog(carNum);
        PrintWriter printWriter=response.getWriter();
        printWriter.println(JSON.toJSONString(log));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
