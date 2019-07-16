package servlet;

import controller.AdminController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;

public class adminLoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String adminId = request.getParameter("adminId");
        String adminPassword = request.getParameter("adminPassword");
        AdminController adminController = new AdminController();
        boolean ifright = adminController.checkAdmin(adminId,adminPassword);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(
                "{\"ifright\"" +":"+
                    ifright+    "}"
        );
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
}
