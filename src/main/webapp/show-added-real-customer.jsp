<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ir.dotin.dataaccess.entity.RealCustomer" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>showAddedRealCustomer</title>
    <style>
        body {
            background-color: black;
            font-family: B Nazanin;
        }

        div {
            font-family: B Nazanin;
        }

        .capitalize {
            font-size: 2.8em;
            color: cornsilk;
            text-align: right;
            line-height: 2.8;
            top: 7%;
            margin-right: 3cm;
            direction: rtl;
        }

        .form {
            font-weight: bold;
            position: absolute;
            left: 5%;
            bottom: 15%;
            z-index: -1;
            color: cornsilk;
        }

        .table {
            color: #fff8dc;
            background-color: #b8860b;
            position: absolute;
            right: 7%;
            top: 40%;
            text-align: right;
            font-weight: bold;
            font-family: B Nazanin;
            vertical-align: middle;
            border-bottom: 1px solid #fff8dc;
            direction: rtl;
        }
    </style>
</head>
<body>
<div class=title>
    <h>نمایش مشتری</h>
</div>
<br>
<br>
<%
    RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomer");
%>
<h1 class="capitalize">مشتری حقیقی به شرح زیر٬ با موفقیت ذخیره شد</h1>
<table class="table">
    <thead>
    <tr>
        <th>
        <td> شماره مشتری</td>
        </th>
        <th>
        <td>نام</td>
        </th>
        <th>
        <td>نام خانوادگی</td>
        </th>
        <th>
        <td>نام پدر</td>
        </th>
        <th>
        <td>تاریخ تولد</td>
        </th>
        <th>
        <td>کد ملی</td>
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
        <td><%=realCustomer.getCustomerNumber()%>
        </td>
        </td>
        <td>
        <td>
            <%=realCustomer.getName()%>
        </td>
        </td>
        <td>
        <td>
            <%=realCustomer.getFamilyName()%>
        </td>
        </td>
        <td>
        <td>
            <%=realCustomer.getFatherName()%>
        </td>
        </td>
        <td>
        <td>
            <%=realCustomer.getBirthDate()%>
        </td>
        </td>
        <td>
        <td>
            <%=realCustomer.getNationalCode()%>
        </td>
        </td>
    </tr>
    </tbody>
</table>
<div>
    <td><a href="/index.jsp" class="form">صفحه قبل <<</a></td>

</div>
</body>
</html>