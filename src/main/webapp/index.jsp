<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>customerSystem</title>
    <style>

        body {
            background-color: black;
            font-family: B Nazanin;
        }

        div {
            font-family: B Nazanin;
        }

        .title {
            color: cornsilk;
            text-align: right;
            margin-right: 1.4cm;
            font-size: 3em;
            line-height: 3.8;
        }

        .capitalize {
            font-size: 1.8em;
            color: cornsilk;
            margin-right: 3.4cm;
            text-align: right;
            line-height: 0.8;
        }

        img {
            position: absolute;
            left: 0px;
            top: 0px;
            z-index: -1;
        }

        .menuItem {
            font-weight: bold;
            margin: 1%;
            border-style: dotted;
            width: 100%;
            height: 30%;
            line-height: 3.8;
            color: cornsilk;
            text-align: center;
            background-color: khaki;
        }

        .menu {
            left: 74%;
            text-align: center;
            vertical-align: middle;
            border: black;
            border-width: 2px;
            width: 15%;
            height: 30%;
            line-height: 5.8;
            position: relative;
            color: brown;
        }

    </style>
</head>
<body>
<h1 class="title">به سامانه کاربران خوش آمدید</h1>
<p class="capitalize">لطفا نوع مشتری خود را انتخاب کنید</p>
<br>
<br>
<br>
<img src="western_bank-wallpaper-1366x768.jpg" style="width:1000px;height:775px;">
<div class="menu">
    <div class="menuItem"><a href="real-customer.jsp">کاربر حقیقی</a></div>
    <div class="menuItem"><a href="legal-customer.jsp">کاربر حقوقی</a></div>
</div>
</body>
</html>