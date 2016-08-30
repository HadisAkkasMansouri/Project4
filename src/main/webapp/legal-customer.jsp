<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <head>
        <meta charset="UTF-8">
        <title>legalCustomer</title>
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


            a:link, a:visited {
                font-weight: bold;
                margin: 10px;
                background-color: khaki;
                color: brown;
                text-align: center;
                display: inline-block;
                width: 17%;
                height: 8%;
                line-height: 2.8;
            }

            a:hover, a:active {
                background-color: chocolate;
            }

            .style {
                font-weight: bold;
                position: absolute;
                left: 5%;
                bottom: 15%;
                z-index: -1;
            }

            .add {
                color: white;
                text-align: center;
            }

            .font {
                font-size: 1.8em;
                align: right;
                color: cornsilk;
            }

        </style>
    </head>
</head>
<body>
<h1 class="capitalize">سامانه کاربران حقوقی</h1>
<div style="width: 100%;">
    <form class="add">
        <fieldset>
            <legend class="font">لطفا گزینه مورد نظر خود را انتخاب نمایید</legend>
            <br>
            <br>
            <a href="search-legal-customer.jsp">جست و جوی کاربر</a>
            <br>
            <br>
            <a href="add-legal-customer.jsp">اضافه کردن کاربر</a>
            <br>
            <br>
            <br>
        </fieldset>
    </form>
</div>
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