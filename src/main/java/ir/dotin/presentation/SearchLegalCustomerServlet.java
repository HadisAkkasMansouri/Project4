package ir.dotin.presentation;

//import ir.dotin.business.LegalCustomerLogic;
import ir.dotin.dataaccess.entity.LegalCustomer;
//import ir.dotin.utility.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String companyName = request.getParameter("CompanyName");
        String economicCode = request.getParameter("EconomicCode");
        String legalCustomerNumber = request.getParameter("LegalCustomerNumber");

//        List<LegalCustomer> legalCustomers = LegalCustomerLogic.searchLegalCustomer(companyName, economicCode, legalCustomerNumber);
//        response.getWriter().println(PageGenerator.generateSearchOfLegalCustomerHTML(legalCustomers));
    }
}
