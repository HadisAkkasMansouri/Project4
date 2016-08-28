package ir.dotin.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AddGrantDonditionServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String grantConditionName = request.getParameter("grantConditionName");
        int minDuration = Integer.parseInt(request.getParameter("minDuration"));
        int maxDuration = Integer.parseInt(request.getParameter("maxDuration"));
        String minAmountStr = request.getParameter("minAmount");
        BigDecimal minAmount = new BigDecimal(minAmountStr);
        String maxAmountStr = request.getParameter("maxAmount");
        BigDecimal maxAmount = new BigDecimal(maxAmountStr);
    }
}
