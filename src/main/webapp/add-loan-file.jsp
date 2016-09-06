<%@ page import="ir.dotin.dataaccess.entity.RealCustomer" %>
<%@ page import="ir.dotin.dataaccess.entity.LoanType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>addLegalCustomer</title>

    <style>

        body {
            background-color: black;
            font-family: B Nazanin;
            color: darkgoldenrod;
        }

        div {
            font-family: B Nazanin;
        }

        .capitalize {
            font-size: 3.8em;
            color: cornsilk;
            text-align: right;
            margin-right: 3cm;
        }

        .form {
            font-weight: bold;
            position: absolute;
            left: 5%;
            bottom: 15%;
            z-index: -1;
            color: cornsilk;
        }

        .textError {
            font-weight: bold;
            color: crimson;
            text-align: right;
            font-size: 1.0em;
            margin-right: 3cm;
            line-height: 1.8;
        }

        .header {

            color: cornsilk;
            text-align: right;
            margin-right: 3cm;
        }

        .button {
            position: absolute;
            right: 22%;
            top: 29.7%;
            text-align: center;
            font-weight: bold;
            background-color: khaki;
            color: brown;
            font-family: "B Nazanin";
        }

        .text {
            position: absolute;
            right: 10%;
            top: 30%;
        }

        .finalButton {

            text-align: center;
            font-weight: bold;
            background-color: khaki;
            color: brown;
            font-family: "B Nazanin";
            position: absolute;
            right: 22%;
            top: 80%;

        }

        .dropDown {
            background-color: cornsilk;
            color: darkgoldenrod;
            font-weight: bold;
            font-family: "B Nazanin";
        }

    </style>
</head>
<body>
<h1 class="capitalize">تشکیل پرونده تسهیلاتی</h1>
<div>
    <p class="textError"><%=request.getAttribute("text") == null ? "" : (String) request.getAttribute("text")%>
    </p>
</div>
<form action="/AddLoanFileServlet">
    <h4 class="header">لطفا شماره مشتری کاربر حقیقی مورد نظر را وارد نمایید</h4>
    <input type="hidden" value="retrieveCustomerAndLoanType" name="action">
    <input class="text" type="text" name="customerNumber" id="customerNumber" placeholder="شماره مشتری حقیقی"
           required=required
           oninvalid="alert('وارد کردن شماره مشتری الزامی است')" value="<%=request.getAttribute("customerNumber")%>">
    <input class="button" type="submit" value="بازیابی">
</form>
<br>
<br>
<form action="/AddLoanFileServlet">
    <%
        Object customerAvailabilityObject = request.getAttribute("customerAvailability");
        int customerAvailability = -1;
        if (customerAvailabilityObject != null) {
            customerAvailability = (int) customerAvailabilityObject;
        }
    %>
    <%if (customerAvailability == 1) {%>
    <div style="width: 100%">
        <input type="text" name="action" value="addLoanFile" hidden>
        <%RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomer");%>
        <input type="text" name="customerNumber" hidden value="<%=request.getAttribute("customerNumber")%>">
    </div>
    <div style="width: 100%; direction: rtl;">

        <table style="color: darkgoldenrod;">
            <tr>
                <td>انواع تسهیلات</td>
                <td>
                    <%boolean loanTypeAvailability = (boolean) request.getAttribute("loanTypeAvailability");%>
                    <%if (loanTypeAvailability) {%>
                    <%List<LoanType> loanTypes = (List<LoanType>) request.getAttribute("loanTypes");%>
                    <select class="dropDown" name="loanTypeId">
                        <%for (LoanType loanType : loanTypes) {%>
                        <option value="<%=loanType.getId()%>"><%=loanType.getLoanTypeName()%>
                        </option>
                        <%}%>
                    </select>
                    <%} else {%>
                    <p>هیچ تسهیلاتی موجود نمی باشد</p>
                    <%}%>
                </td>
            </tr>
            <tr>
                <td>نام مشتری حقیقی</td>
                <td><%=realCustomer.getName()%>
                </td>
            </tr>
            <tr>
                <td>نام خانوادگی مشتری حقیقی</td>
                <td><%=realCustomer.getFamilyName()%>
                </td>
            </tr>
            <tr>
                <td>مدت قرارداد</td>
                <td><input type="text" name="duration" required="required"
                           oninvalid="alert('وارد کردن فیلد مدت قرارداد الزامی است')"></td>
            </tr>
            <tr>
                <td>مبلغ قرارداد</td>
                <td><input type="text" name="amount" required="required"
                           oninvalid="alert('وارد کردن فیلد مبلغ قرارداد الزامی است')"></td>
            </tr>
        </table>
    </div>
    <input type="submit" class="finalButton" value="ثبت نهایی">
    <%} else if (customerAvailability == 0) {%>
    <p class="textError">مشتری با شماره مشتری وارد شده یافت نشد</p>
    <%}%>
</form>
<form action="/AddLoanFileServlet">
</form>
<div>
    <td><a href="/loan.jsp" class="form">صفحه قبل <<</a></td>
</div>
</body>
</html>