package ir.dotin.presentation;

import ir.dotin.business.LoanTypeValidation;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddLoanTypeServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String loanTypeName = request.getParameter("loanTypeName");
        float interestRate = Float.parseFloat(request.getParameter("interestRate"));


        LoanType loanType;
        try {
            loanType = LoanTypeValidation.validateLoanTypeFields(loanTypeName, interestRate);
            request.setAttribute("loanType", loanType);
            getServletConfig().getServletContext().getRequestDispatcher("grant-condition.jsp").forward(request, response);
        } catch (NullRequiredFieldException e) {
            request.setAttribute("header", "لطفا مجددا تلاش نمایید");
            request.setAttribute("text", "\n" + e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher("loan-type.jsp").forward(request, response);
        }
    }
}
