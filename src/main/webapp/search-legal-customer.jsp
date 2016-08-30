<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>searchLegalCustom</title>

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


        .search {
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

    </style>
</head>
<body>
<h1 class="capitalize">جست و جوی کاربر حقوقی</h1>
<form class="search" action="/SearchLegalCustomerServlet" method="get">
    <fieldset>
        <legend>لطفا اطلاعات کاربر حقوقی را وارد نمایید</legend>
        نام شرکت <br>
        <input type="text" name="CompanyName">
        <br>
        شماره مشتری <br>
        <input type="text" name="LegalCustomerNumber">
        <br>
        کد اقتصادی <br>
        <input type="text" name="EconomicCode">
        <br><br>
        <button type="submit" value="search"><b>جست و جو</b></button>
    </fieldset>
</form>
<div>
    <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
</div>
<script>

</script>
</body>
</html>
