<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
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
            line-height: 1.8;
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
            left: 90px;
            bottom: 120px;
            z-index: -1;
        }

    </style>
</head>
<body>
<p class="capitalize">اضافه کردن کاربر حقیقی</p>
<form class="add" action="/AddRealCustomerServlet" method="get">
    <fieldset>
        <legend>لطفا اطلاعات کاربر حقوقی را وارد نمایید </legend>
        نام    <br>
        <input type="text" name="Name">
        <br>
        نام خانوادگی    <br>
        <input type="text" name="FamilyName">
        <br>
        نام پدر    <br>
        <input type="text" name="FatherName" >
        <br>
        تاریخ تولد    <br>
        <input type="text" name="BirthDate" >
        <br>
        کد ملی    <br>
        <input type="text" name="NationalCode" >
        <br><br>
        <button type="submit" value="RegistrateInformation"><b>ثبت اطاعات</b></button>
    </fieldset>
</form>
<div class="style">
    <button onclick="goBack()">صفحه قبل <<</button>
</div>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>