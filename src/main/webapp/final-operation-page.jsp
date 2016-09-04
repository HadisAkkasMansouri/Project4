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
            line-height: 2.8;
            top: 7%;
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
            font-weight: bold;
            color: darkgoldenrod;
            text-align: right;
            font-size: 2.0em;
            margin-right: 3cm;
            line-height: 1.8;
        }

    </style>
    <h class="capitalize"><%=request.getAttribute("header") == null ? "": (String)request.getAttribute("header")%></h>
    <p class="text"><%=request.getAttribute("text") == null ? "": (String)request.getAttribute("text")%></p>
</head>
<body>
<div>
    <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
</div>
</body>
</html>
