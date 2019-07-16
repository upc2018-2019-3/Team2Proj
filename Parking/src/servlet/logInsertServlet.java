package servlet;

import controller.LogController;
import model.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class logInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String logid = request.getParameter("logid");
        String carNum = request.getParameter("carNum");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String duraTime = request.getParameter("duraTime");
        String consum = request.getParameter("consum");
        Log log = new Log();
        log.setLogid(Integer.valueOf(logid));
        log.setCarNum(carNum);
        log.setStartTime(startTime);
        log.setEndTime(endTime);
        log.setDuraTime(duraTime);
        log.setConsum(Integer.valueOf(consum));

        LogController logController = new LogController();
        logController.insertLog(log);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
