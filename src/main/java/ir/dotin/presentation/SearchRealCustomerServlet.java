package ir.dotin.presentation;

import ir.dotin.business.RealCustomerLogic;
import ir.dotin.dataaccess.entity.RealCustomer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("Name");
        String familyName = request.getParameter("FamilyName");
        String realCustomerNumber = request.getParameter("RealCustomerNumber");
        String nationalCode = request.getParameter("NationalCode");

//        List<RealCustomer> realCustomers = RealCustomerLogic.searchRealCustomer(name, familyName, nationalCode, realCustomerNumber);
//        response.getWriter().println(PageGenerator.generateSearchOfRealCustomerHTML(realCustomers));
    }
}

