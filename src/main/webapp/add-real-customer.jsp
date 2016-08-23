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
<p class="capitalize">اضافه کردن کاربر حقیقی</p>
<form class="add" action="/AddRealCustomerServlet" method="get" onsubmit="return validation()">
    <fieldset>
        <legend>لطفا اطلاعات کاربر حقوقی را وارد نمایید</legend>
        نام <br>
        <input type="text" name="Name">
        <br>
        نام خانوادگی <br>
        <input type="text" name="FamilyName">
        <br>
        نام پدر <br>
        <input type="text" name="FatherName">
        <br>
        تاریخ تولد <br>
        <input type="text" name="BirthDate">
        <br>
        کد ملی <br>
        <input type="text" name="NationalCode">
        <br><br>
        <button type="submit" value="RegistrateInformation"><b>ثبت اطاعات</b></button>
    </fieldset>
</form>
<div class="style">
    <button onclick="goBack()">صفحه قبل <<</button>
</div>
<script>
    function validation() {
        var input = document.getElementsByName("NationalCode")[0].value;
        alert(input);
        if (input.length!=10) {
            alert("کد ملی باید ۱۰ رقم باشد لطفا مجددا تلاش نمایید");
            return false;
        }
        var check = parseInt(input[9]);
        var sum = 0;
        var i;
        for (i = 0; i < 9; ++i) {
            sum += parseInt(input[i]) * (10 - i);
        }
        sum %= 11;
        var result = (sum < 2 && check == sum) || (sum >= 2 && check + sum == 11);
        if (result) {
            return true;
        } else {
            alert("کد ملی وارد شده صحیح نمی باشد لطفا مجددا تلاش نمایید");
            return false;
        }
    }
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>