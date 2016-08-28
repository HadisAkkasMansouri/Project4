<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
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
            margin-right: 3cm;
        }

        .add{
            color: white;
            text-align: center;
            background-color: darkgoldenrod;
        }

        .style {
            font-weight: bold;
            position: absolute;
            left: 5%;
            bottom: 15%;
            z-index: -1;
        }

    </style>
</head>
<body>
<p class="capitalize">تشکیل پرونده تسهیلاتی</p>
<form class="add" action="/AddLegalCustomerServlet" method="get">
    <fieldset>
        <legend>لطفا شماره مشتری کاربر حقیقی مورد نظر را وارد نمایید</legend>
        <br>
        <button onclick="retrieveRealCustomerName()"><b>بازیابی</b>
        </button><input type="text" name="CompanyName">
        <br>
        <br>
    </fieldset>
</form>
<div class="style">
    <button onclick="goBack()">صفحه قبل <<</button>
</div>
<script>
    function goBack() {
        window.history.back();
    }

    function retrieveRealCustomerName() {

    }
</script>
</body>
</html>