<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<html>
<head>
    <title>SuccessfulOperationPage</title>

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
            margin-right: 3cm;
        }

        .form {
            font-weight: bold;
            position: absolute;
            left: 5%;
            bottom: 15%;
            z-index: -1;
            color: cornsilk;
        }

        .text{
            font-size: 2.0em;
            font-weight: bold;
            color: darkgoldenrod;
            text-align: right;
            margin-right: 3cm;
            line-height: 1.8;
        }

    </style>
    <h1 class="capitalize"><%=request.getAttribute("header") == null ? "": (String)request.getAttribute("header")%></h1>
    <p class="text"><%=request.getAttribute("text") == null ? "": (String)request.getAttribute("text")%></p>
</head>
<body>
<div>
    <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
</div>
</body>
</html>
