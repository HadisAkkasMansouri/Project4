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
            line-height: 2.8;
            margin-right: 3cm;
        }

        .add {
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
<p class="capitalize">اضافه کردن نوع تسهیلات</p>
<form class="add" action="grant-condition.jsp" method="get">
    <fieldset>
        <legend>لطفا اطلاعات نوع تسهیلات کاربر حقیقی را وارد نمایید</legend>
        نام نوع تسهیلات <br>
        <input type="text" name="Name">
        <br>
        نرخ سود <br>
        <input type="text" name="FamilyName">
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