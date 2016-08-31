package ir.dotin.presentation;

//import ir.dotin.business.LegalCustomerLogic;
import ir.dotin.dataaccess.entity.LegalCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;
//import ir.dotin.utility.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String companyName = request.getParameter("CompanyName");
        String economicCode = request.getParameter("EconomicCode");
        String registrationDate = request.getParameter("RegistrationDate");
//        try {
//            LegalCustomer legalCustomer = CLegalCustomerLogic.validateAddLegalCustomer(companyName, economicCode, registrationDate);
//            response.getWriter().println(PageGenerator.generateAddLegalCustomerPage(legalCustomer));
//        } catch (InvalidEntranceException e) {
//            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
//            e.printStackTrace();
//        } catch (NullRequiredFieldException e) {
//            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
//            e.printStackTrace();
//        } catch (DuplicateEntranceException e) {
//            response.getWriter().println(PageGenerator.generateresultPage(e.getMessage()));
//            e.printStackTrace();
//        }
    }
}
