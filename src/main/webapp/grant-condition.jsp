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
<p class="capitalize">اضافه کردن شروط اعطا</p>
<form class="add" action="/AddRealCustomerServlet" method="get" onsubmit="return validation()">
    <fieldset>
        <legend>لطفا اطلاعات شروط اعطا را وارد نمایید</legend>
        نام <br>
        <input type="text" name="Name">
        <br>
        حداقل مدت قرداد <br>
        <input type="text" name="FamilyName">
        <br>
        حداکثر مدت قرداد <br>
        <input type="text" name="FatherName">
        <br>
        حداقل مبلغ قرداد <br>
        <input type="text" name="BirthDate">
        <br>
        حداکثر مبلغ قرداد <br>
        <input type="text" name="NationalCode">
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
