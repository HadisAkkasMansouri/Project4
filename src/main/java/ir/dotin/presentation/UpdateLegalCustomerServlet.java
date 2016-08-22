package ir.dotin.presentation;

//import ir.dotin.business.CustomerLegalValidation;
import ir.dotin.dataaccess.entity.LegalCustomer;
//import ir.dotin.utility.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.valueOf(request.getParameter("ID"));

        LegalCustomer legalCustomer = null;
//        try {
//            legalCustomer = CustomerLegalValidation.getLegalCustomer(id);
//            response.getWriter().println(PageGenerator.generateUpdateLegalCustomer(legalCustomer));
//        } catch (SQLException e) {
//            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
//            e.printStackTrace();
//        }
    }
}