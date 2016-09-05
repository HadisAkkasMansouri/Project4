package ir.dotin.presentation;

import ir.dotin.business.LoanFileLogic;
import ir.dotin.business.LoanTypeLogic;
import ir.dotin.business.RealCustomerLogic;
import ir.dotin.dataaccess.entity.LoanFile;
import ir.dotin.dataaccess.entity.LoanType;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.NotFoundDataException;
import ir.dotin.exception.NotInRangeException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AddLoanFileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("createFile")){
            createFile(request, response);
        }
        if(action.equalsIgnoreCase("retrieveCustomerAndLoanType")){
            retrieveRealCustomerAndLoanType(request, response);
        }
        if(action.equalsIgnoreCase("addLoanFile")){
            createLoanFile(request, response);
        }
    }


    public void retrieveRealCustomerAndLoanType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean loanTypeAvailability = false;
        String customerNumber = request.getParameter("customerNumber");
        try {
            RealCustomer realCustomer = RealCustomerLogic.getRealCustomerInfo(customerNumber);
            request.setAttribute("customerAvailability", 1);
            request.setAttribute("realCustomer", realCustomer);
            request.setAttribute("customerNumber", realCustomer.getCustomerNumber());
            List<LoanType> loanTypes = LoanTypeLogic.retrieveLoanTypes();
            loanTypeAvailability = true;
            request.setAttribute("loanTypeAvailability", loanTypeAvailability);
            request.setAttribute("loanTypes", loanTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            getServletConfig().getServletContext().getRequestDispatcher("/add-loan-file.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void createLoanFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String customerNumber = request.getParameter("customerNumber");
        int LoanTypeId = Integer.parseInt(request.getParameter("LoanTypeId"));
        LoanFile loanFile = new LoanFile();
        loanFile.setAmount(new BigDecimal(request.getParameter("amount")));
        loanFile.setDuration(Integer.valueOf(request.getParameter("duration")));
        request.setAttribute("text", "پرونده تسهیلاتی مشتری حقیقی با شماره مشتری " + customerNumber + "با موفقیت ثبت شد.");
        getServletConfig().getServletContext().getRequestDispatcher("/final-operation.jsp").forward(request, response);
        try {
            LoanFileLogic.insertLoanFile(customerNumber, LoanTypeId, loanFile);
        } catch (NotFoundDataException | NotInRangeException e) {
            request.setAttribute("text", "\n" + e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher("/add-loan-file.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("customerAvailability", -1);
        request.setAttribute("customerNumber", "");
        getServletConfig().getServletContext().getRequestDispatcher("/add-loan-file.jsp").forward(request, response);
    }
}
