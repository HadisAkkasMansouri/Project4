package ir.dotin.presentation;

import ir.dotin.business.LoanFileValidation;
import ir.dotin.exception.NullRequiredFieldException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLoanFileServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String customerNumber = request.getParameter("customerNumber");
        try {
            if(LoanFileValidation.validateCustomerNumber(customerNumber)){

            }
        } catch (NullRequiredFieldException e) {
            request.setAttribute("text", "\n" + e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher("/loan-file.jsp").forward(request, response);
        }

    }
}