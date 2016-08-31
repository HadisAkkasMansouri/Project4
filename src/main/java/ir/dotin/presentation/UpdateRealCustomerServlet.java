package ir.dotin.presentation;

import ir.dotin.business.RealCustomerLogic;
import ir.dotin.dataaccess.entity.RealCustomer;
//import ir.dotin.utility.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("ID"));
        RealCustomer realCustomer;
//        try {
//            realCustomer = RealCustomerLogic.getRealCustomer(id);
//            response.getWriter().println(PageGenerator.generateUpdateRealCustomer(realCustomer));
//        } catch (SQLException e) {
//            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
//            e.printStackTrace();
//        }
    }
}