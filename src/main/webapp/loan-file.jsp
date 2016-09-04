<%@ page import="ir.dotin.dataaccess.entity.RealCustomer" %>
<%@ page import="ir.dotin.dataaccess.entity.LoanType"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <%--<script type="text/javaScript">--%>
        <%--function checkInput() {--%>
            <%--var customerNumber = document.getElementById("customerNumber").value;--%>
            <%--if (customerNumber == "") {--%>
                <%--alert("پر کردن شماره مشتری الزامی است !");--%>
            <%--}--%>
            <%--else {--%>
                <%--showResult();--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>

    <title>addLegalCustomer</title>

    <style>

        body {
            background-color: black;
            font-family: B Nazanin;
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

    </style>
</head>
<body>
<h1 class="capitalize">تشکیل پرونده تسهیلاتی</h1>
<div class=title>
    <p class="textError"><%=request.getAttribute("text") == null ? "" : (String) request.getAttribute("text")%>
    </p>
</div>
<form action="/AddLoanFileServlet" method="get">
    <h4 class="header">لطفا شماره مشتری کاربر حقیقی مورد نظر را وارد نمایید</h4>
    <input class="button" type="button" value="بازیابی" <%--onclick="checkInput()"--%>>
    <input class="text" type="text" name="customerNumber" id="customerNumber" placeholder="شماره مشتری حقیقی"
           value="<%=request.getAttribute("customerNumber")%>">
</form>
<div>
    <td><a href="/loan.jsp" class="form">صفحه قبل <<</a></td>
</div>
<script>
//    function showResult() {
//
//    }
</script>
</body>
</html>