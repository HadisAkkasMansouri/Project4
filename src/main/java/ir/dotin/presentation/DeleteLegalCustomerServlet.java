package ir.dotin.presentation;

//import ir.dotin.business.LegalCustomerLogic;
//import ir.dotin.utility.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteLegalCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.valueOf(request.getParameter("ID"));
//
//        if(LegalCustomerLogic.deleteLegalCustomer(id)){
//            response.getWriter().println(PageGenerator.generateresultPage("اطلاعات مشتری حقوقی وارد شده با موفقیت حذف شد"));
//        }else {
//            response.getWriter().println(PageGenerator.generateresultPage("خطا! عملیات خذف مشتری حقوقی موفقیت آمیز نبود لطفا مجددا تلاش نمایید"));
//        }
    }
}
