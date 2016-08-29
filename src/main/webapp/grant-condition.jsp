<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ir.dotin.dataaccess.entity.LoanType" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/table-script.js"></script>
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
<div>
    <p class="capitalize">اضافه کردن شروط اعطا</p>
</div>
<div id="wrapper">
    <div class="content">
        <div class="box">
            <div class="box-in">
                <br>
                <table>
                    <%
                        LoanType loanType = (LoanType) request.getAttribute("loanType");
                    %>
                    <tr>
                        <td>نام نوع تسهیلات</td>
                        <td><%=loanType.getLoanTypeName()%>
                        </td>
                    </tr>
                    <tr>
                        <td>نرخ سود</td>
                        <td><%=loanType.getInterestRate()%>
                        </td>
                    </tr>
                </table>
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
                    </table>
                </fieldset>
                <input type="submit" value="ثبت اطاعات" onclick="addRowTable()"><b></b>
                <br>
                <hr>
                <br>
                <form class="add" action="/AddGrantConditionServlet" method="get">
                    <input type="hidden" name="loanType" value="<%=request.getParameter("loanType")%>">
                    <input type="hidden" name="interestRate" value="<%=request.getParameter("interestRate")%>">
                    <table class="grantConditionTable" id="grantConditionTable"></table>
                    <br>
                </form>
                <div>
                    <td><a href="../index.jsp" class="form">صفحه قبل <<</a></td>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
