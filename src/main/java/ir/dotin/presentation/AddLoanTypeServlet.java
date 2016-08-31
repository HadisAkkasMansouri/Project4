package ir.dotin.presentation;

import ir.dotin.business.LoanTypeLogic;
import ir.dotin.exception.InvalidEntranceException;
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
        Float interestRate = Float.parseFloat(request.getParameter("interestRate"));

        try {
            if (LoanTypeLogic.validateLoanTypeFields(loanTypeName, interestRate)) {
                request.setAttribute("loanTypeName", loanTypeName);
                request.setAttribute("interestRate", interestRate);
                getServletConfig().getServletContext().getRequestDispatcher("/add-grant-condition.jsp").forward(request, response);
            }
        } catch (NullRequiredFieldException | InvalidEntranceException e) {
            request.setAttribute("header", "لطفا مجددا تلاش نمایید");
            request.setAttribute("text", "\n" + e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher("/loan-type.jsp").forward(request, response);
        }
    }
}
