<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ir.dotin.dataaccess.entity.RealCustomer" %>
<%@ page import="java.util.ArrayList" %>
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
            font-size: 3.8em;
            color: cornsilk;
            text-align: right;
            line-height: 2.8;
            top: 7%;
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
    </style>
</head>
<body>
<div class=title>
    <h>نمایش مشتری</h>
</div>
<div id=wrapper>
    <div class=content>
        <div class=box>
            <div class=box-in>
                <br>
                <br>
                <%
                    RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomer");
                %>
                <p class="capitalize">مشتری حقیقی به شرح زیر با موفقیت٬ ذخیره شد</p>
                <table table style="color: darkgoldenrod">
                    <thead>
                    <tr>
                        <th>
                            شماره مشتری
                        </th>
                        <th>
                            نام
                        </th>
                        <th>
                            نام خانوادگی
                        </th>
                        <th>
                            نام پدر
                        </th>
                        <th>
                            تاریخ تولد
                        </th>
                        <th>
                            کد ملی
                        </th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td>
                            <%=realCustomer.getCustomerNumber()%>
                        </td>
                        <td>
                            <%=realCustomer.getName()%>
                        </td>
                        <td>
                            <%=realCustomer.getFamilyName()%>
                        </td>
                        <td>
                            <%=realCustomer.getFatherName()%>
                        </td>
                        <td>
                            <%=realCustomer.getBirthDate()%>
                        </td>
                        <td>
                            <%=realCustomer.getNationalCode()%>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div>
                    <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>