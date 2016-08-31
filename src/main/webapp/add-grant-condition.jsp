<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/script-table.js"></script>
    <script type="text/javascript">
        function validateInputs() {

            var grantConditionName = document.getElementById("grantConditionName").value;
            var minDuration = document.getElementById("minDuration").value;
            var maxDuration = document.getElementById("maxDuration").value;
            var minAmount = document.getElementById("minAmount").value;
            var maxAmount = document.getElementById("maxAmount").value;
            if(grantConditionName == "" || minAmount == "" || maxAmount == "" || minDuration == "" || maxDuration == ""){
                alert("پر کردن تمامی فیلدهای شروط اعطا الزامی است !");
            }else {
                addRowTable();
            }
        }
    </script>
    <title>addRealCustomer</title>
    <style>

        body {
            background-color: black;
            font-family: "B Nazanin";
        }

        div {
            font-family: "B Nazanin";
        }

        .capitalize {
            color: cornsilk;
            text-align: right;
            line-height: 2.8;
            top: 30%;
            margin-right: 3cm;
        }


        .add {
            color: white;
            text-align: center;
            background-color: darkgoldenrod;
            position: absolute;
            top:25%;
            right:8%;
            font-weight: bold;
            border: solid darkgoldenrod;
            direction: rtl;
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

        .button{
            position: absolute;
            right:9%;
            top:50%;
            text-align: center;
            font-weight: bold;
            background-color: khaki;
            color: brown;
            font-family: "B Nazanin";
        }

        .submitButton{
            position: absolute;
            right:16%;
            top:50%;
            text-align: center;
            font-weight: bold;
            background-color: khaki;
            color: brown;
            font-family: "B Nazanin";
        }

    </style>
</head>
<body>
<div>
    <h1 class="capitalize">اضافه کردن شروط اعطا</h1>
    <h4 class="capitalize">: لطفا شروط اعطای تسهیلات مورد نظر را وارد کنید</h4>
    <p class="textError"><%=request.getAttribute("text") == null ? "" : (String) request.getAttribute("text")%>
    </p>
</div>
<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <table>
                    <tr>
                        <td>نام نوع تسهیلات</td>
                        <td><%=request.getAttribute("loanTypeName")%>
                        </td>
                    </tr>
                    <tr>
                        <td>نرخ سود</td>
                        <td><%=request.getAttribute("interestRate")%>
                        </td>
                    </tr>
                </table>
                    <table class="add">
                        <tr>
                            <td>نام</td>
                            <td><input type="text" id="grantConditionName"></td>
                        </tr>
                        <tr>
                            <td>حداقل مدت قرداد</td>
                            <td><input type="text" id="minDuration"></td>
                        </tr>
                        <tr>
                            <td>حداکثر مدت قرداد</td>
                            <td><input type="text" id="maxDuration"></td>
                        </tr>
                        <tr>
                            <td>حداقل مبلغ قرداد</td>
                            <td><input type="text" id="minAmount"></td>
                        </tr>
                        <tr>
                            <td>حداکثر مبلغ قرداد</td>
                            <td><input type="text" id="maxAmount"></td>
                        </tr>
                    </table>
                    <input class="button" type="button" value="شرط اعطا بعدی" onclick="validateInputs()">
                    </input>
                <br>
                <br>
                <form action="/AddGrantConditionServlet" method="get">
                    <input type="hidden" name="loanTypeName" value="<%=request.getParameter("loanTypeName")%>">
                    <input type="hidden" name="interestRate" value="<%=request.getParameter("interestRate")%>">
                    <table class="grantConditionTable" id="grantConditionTable"></table>
                    <br>
                </form>
                <div>
                    <td><a href="/loan.jsp" class="form">صفحه قبل <<</a></td>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
