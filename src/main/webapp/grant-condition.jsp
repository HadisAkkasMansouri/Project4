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
            font-size: 2.8em;
            color: cornsilk;
            text-align: right;
            line-height: 1.8;
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

    </style>
</head>
<body>
<p class="capitalize">اضافه کردن شروط اعطا</p>
<form class="add" action="/AddGrantConditionServlet" method="get">
    <fieldset>
        <legend>لطفا اطلاعات شروط اعطا را وارد نمایید</legend>
        <table>
            <tr>
                <td>نام</td>
                <td><input type="text" id="grantConditionName"></td>
            </tr>
            <tr>
                <td>حداقل مدت قرداد</td>
                <td><input type="text" id="minDuration"></td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td>حداکثر مدت قرداد</td>
                <td><input type="text" id="maxDuration"></td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td>حداقل مبلغ قرداد</td>
                <td><input type="text" id="minAmount"></td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td>حداکثر مبلغ قرداد</td>
                <td><input type="text" id="maxAmount"></td>
            </tr>
            <tr>

                <button type="submit" value="RegistrateInformation"><b>ثبت اطاعات</b></button>
        </table>
    </fieldset>
</form>
<div>
    <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
</div>
<script>

</script>
</body>
</html>
