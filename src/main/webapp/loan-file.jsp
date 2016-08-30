<%@ page import="ir.dotin.business.CustomerRealValidation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
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
            line-height: 2.8;
            top: 7%;
            margin-right: 3cm;
        }


        .add{
            color: white;
            text-align: center;
            background-color: darkgoldenrod;
        }

        .form {
            font-weight: bold;
            position: absolute;
            left: 5%;
            bottom: 15%;
            z-index: -1;
            color: cornsilk;
        }

    </style>
</head>
<body>
<h1 class="capitalize">تشکیل پرونده تسهیلاتی</h1>
<form class="add" action="/" method="get">
    <fieldset>
        <legend>لطفا شماره مشتری کاربر حقیقی مورد نظر را وارد نمایید</legend>
        <br>
        <button onclick="retrieveRealCustomerName()", type="submit"><b>بازیابی</b>
        </button><input type="text" name="customerNumber" value="<%=request.getAttribute("customerNumber")%>">
        <br>
        <br>
    </fieldset>
</form>
<div>
        <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
</div>
<script>
    function retrieveRealCustomerName() {
        <%
//        CustomerRealValidation.getRealCustomerInfo(customerNumber);
        %>
    }
</script>
</body>
</html>