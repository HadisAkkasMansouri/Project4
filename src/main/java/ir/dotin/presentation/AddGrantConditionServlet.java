package ir.dotin.presentation;

import ir.dotin.business.GrantConditionValidation;
import ir.dotin.dataaccess.entity.GrantCondition;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.exception.NotInRangeException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class AddGrantConditionServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String loanTypeName = request.getParameter("loanTypeName");
        Float interestRate = Float.parseFloat(request.getParameter("interestRate"));
        LoanType loanType = new LoanType(loanTypeName, interestRate);

        int rowCount = Integer.parseInt(request.getParameter("rowCount"));
        ArrayList<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

        for( int i=1; i <rowCount -1 ; i++){

            GrantCondition grantCondition = new GrantCondition();
            grantCondition.setGrantConditionName(request.getParameter("grantConditionName" + i));
            grantCondition.setMinDuration(Integer.parseInt(request.getParameter("minDuration")) + i);
            grantCondition.setMaxDuration(Integer.parseInt(request.getParameter("maxDuration")) + i);
            grantCondition.setMinAmount(new BigDecimal((request.getParameter("minAmount")) + i));
            grantCondition.setMaxAmount(new BigDecimal((request.getParameter("maxAmount")) + i));
            grantConditions.add(grantCondition);
        }

        try {
            if(GrantConditionValidation.validateGrantCondition(grantConditions)){
                GrantConditionValidation.insertGrandConditionByLoanType(loanType, grantConditions);
                request.setAttribute("text", "عملیات ثبت نوع تسهیلات با شروط اعطا وارد شده با موفقیت انجام پذیرفت");
            }
        } catch (NullRequiredFieldException | NotInRangeException e) {
            request.setAttribute("text", "\n" + e.getMessage());
            request.setAttribute("url", "/add-grant-condition.jsp");
            getServletConfig().getServletContext().getRequestDispatcher("/add-grant-condition.jsp").forward(request, response);
        }
    }
}
