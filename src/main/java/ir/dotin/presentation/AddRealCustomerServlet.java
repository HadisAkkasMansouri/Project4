package ir.dotin.presentation;

import ir.dotin.business.CustomerRealValidation;
import ir.dotin.dataaccess.RealCustomerDAO;
import ir.dotin.dataaccess.entity.RealCustomer;
import ir.dotin.exception.DuplicateEntranceException;
import ir.dotin.exception.InvalidEntranceException;
import ir.dotin.exception.NullRequiredFieldException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("Name");
        String familyName = request.getParameter("FamilyName");
        String fatherName = request.getParameter("FatherName");
        String birthDate = request.getParameter("BirthDate");
        String nationalCode = request.getParameter("NationalCode");
        try {
            RealCustomer realCustomer = new RealCustomer();
            if(CustomerRealValidation.validateAddRealCustomer(name, familyName, fatherName, birthDate, nationalCode))
            {
                RealCustomerDAO realCustomerDAO = new RealCustomerDAO();
                realCustomer = realCustomerDAO.addRealCustomer(name, familyName, fatherName, birthDate, nationalCode);
            };
            request.setAttribute("realCustomer" , realCustomer);
            getServletConfig().getServletContext().getRequestDispatcher("/show-added-real-customer.jsp").forward(request, response);
        } catch (InvalidEntranceException | NullRequiredFieldException | DuplicateEntranceException e) {
            request.setAttribute("text", "\n" + e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher("/add-real-customer.jsp").forward(request, response);
            e.printStackTrace();
        }catch (Exception e){
            request.setAttribute("text", "\n" + e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher("/add-real-customer.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
}
