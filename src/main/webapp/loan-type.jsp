<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>addRealCustomer</title>
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

        .add {
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
        .textError{
            font-weight: bold;
            color: crimson;
            text-align: right;
            font-size: 1.0em;
            margin-right: 3cm;
            line-height: 1.8;
        }

    </style>
</head>
<body>
<h1 class="capitalize">اضافه کردن نوع تسهیلات</h1>
<div class=title>
    <p class="textError"><%=request.getAttribute("text") == null ? "" : (String) request.getAttribute("text")%>
    </p>
</div>
<form class="add" action="/AddLoanTypeServlet" method="get">
    <fieldset>
        <legend>لطفا اطلاعات نوع تسهیلات کاربر حقیقی را وارد نمایید</legend>
        نام نوع تسهیلات <br>
        <input type="text" name="loanTypeName">
        <br>
        نرخ سود <br>
        <input type="text" name="interestRate">
        <br><br>
        <button type="submit" value="registrationInformation"><b>اضافه کردن شرایط اعطا</b></button>
    </fieldset>
</form>
<div>
    <td><a href="/loan.jsp" class="form">صفحه قبل <<</a></td>
</div>
</body>
</html>