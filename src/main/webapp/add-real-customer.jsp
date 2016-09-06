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
<h1 class="capitalize">اضافه کردن کاربر حقیقی</h1>
<h1 class="textError"><%=request.getAttribute("text") == null ? "" : (String) request.getAttribute("text")%>
</h1>
<form class="add" action="/AddRealCustomerServlet" method="get" onsubmit="return validation()">
    <fieldset>
        <legend>لطفا اطلاعات کاربر حقیقی را وارد نمایید</legend>
        نام <br>
        <input type="text" name="Name" id="Name">
        <br>
        نام خانوادگی <br>
        <input type="text" name="FamilyName" id="FamilyName">
        <br>
        نام پدر <br>
        <input type="text" name="FatherName" id="FatherName">
        <br>
        تاریخ تولد <br>
        <input type="text" name="BirthDate" id="BirthDate">
        <br>
        کد ملی <br>
        <input type="text" name="NationalCode" id="NationalCode">
        <br><br>
        <button type="submit" value="RegistrateInformation"><b>ثبت اطاعات</b></button>
    </fieldset>
</form>
<div>
    <td><a href="/index.jsp" class="form">صفحه قبل <<</a></td>
</div>
<script>
    function validation() {
        var name = document.getElementById("Name").value;
        var familyName = document.getElementById("FamilyName").value;
        var fatherName = document.getElementById("FatherName").value;
        var birthDate = document.getElementById("BirthDate").value;
        var nationalCode = document.getElementById("NationalCode").value;
        if(nationalCode == "" || name == "" || familyName == "" || fatherName == "" || birthDate == ""){
            alert("پر کردن تمامی فیلد های کاربر حقیقی الزامی است !");
        }
        if (nationalCode.length!=10) {
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
</script>
</body>
</html>