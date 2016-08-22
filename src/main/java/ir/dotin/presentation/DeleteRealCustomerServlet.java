package ir.dotin.presentation;

import ir.dotin.business.CustomerRealValidation;
//import ir.dotin.utility.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRealCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("ID"));

//        if(CustomerRealValidation.deleteRealCustomer(id)){
//            response.getWriter().println(PageGenerator.generateresultPage("اطلاعات مشتری حقیقی وارد شده با موفقیت حذف شد"));
//        }else {
//            response.getWriter().println(PageGenerator.generateresultPage("خطا! عملیات خذف مشتری حقیقی موفقیت آمیز نبود لطفا مجددا تلاش نمایید"));
//        }
    }
}
