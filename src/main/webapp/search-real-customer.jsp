<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>serachRealCustom</title>

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

        .search {
            color: white;
            text-align: center;
            background-color: darkgoldenrod;
        }

        .style {
            font-weight: bold;
            position: absolute;
            left: 90px;
            bottom: 150px;
            z-index: -1;
        }

    </style>
</head>
<body>
<p class="capitalize">جست و جوی کاربر حقیقی</p>
<form class="search" action="/SearchRealCustomerServlet" method="get">
    <fieldset>
        <legend>لطفا اطلاعات کاربر حقیقی را وارد نمایید</legend>
        نام <br>
        <input type="text" name="Name">
        <br>
        نام خانوادگی <br>
        <input type="text" name="FamilyName">
        <br>
        شماره مشتری <br>
        <input type="text" name="RealCustomerNumber">
        <br>
        کد ملی <br>
        <input type="text" name="NationalCode">
        <br><br>
        <button type="submit" value="search"><b>جست و جو</b></button>
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
