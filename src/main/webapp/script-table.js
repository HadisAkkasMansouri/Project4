
function addRowTable() {

    var grantConditionName = document.getElementById("grantConditionName");
    var minDuration = document.getElementById("minDuration");
    var maxDuration = document.getElementById("maxDuration");
    var minAmount = document.getElementById("minAmount");
    var maxAmount = document.getElementById("maxAmount");
    var grantConditionTable = document.getElementById("grantConditionTable");
    var rowCount = grantConditionTable.rows.length;
    if (rowCount == 0) {
        addTableHeader();
    }
    
    if (grantConditionName.value != "" && minDuration.value != "" && maxDuration.value != "" && minAmount.value != "" && maxAmount != ""){
        rowCount = grantConditionTable.rows.length;
        var row = grantConditionTable.insertRow(rowCount);
        row.insertCell(0).innerHTML = (rowCount).toString();
        row.insertCell(1).innerHTML = '<input type ="text" name = "grantConditionName' + rowCount + '" value="' + grantConditionName.value + '"readonly">';
        row.insertCell(2).innerHTML = '<input type ="text" name = "minDuration' + rowCount + '" value="' + minDuration.value + '" readonly >';
        row.insertCell(3).innerHTML = '<input type ="text" name = "maxDuration' + rowCount + '" value="' + maxDuration.value + '" readonly >';
        row.insertCell(4).innerHTML = '<input type ="text" name = "minAmount' + rowCount + '" value="' + minAmount.value + '" readonly >';
        row.insertCell(5).innerHTML = '<input type ="text" name = "maxAmount' + rowCount + '" value="' + maxAmount.value + '" readonly >';
    }
    // addTableFooter();

    document.getElementById("rowCount").value = rowCount;
    document.getElementById("grantConditionName").value = "";
    document.getElementById("minDuration").value = "";
    document.getElementById("maxDuration").value = "";
    document.getElementById("minAmount").value = "";
    document.getElementById("maxAmount").value = "";
    
    function addTableHeader() {
        var grantConditionTable = document.getElementById("grantConditionTable");
        var rowCount = grantConditionTable.rows.length;
        var headerRowTable = document.createElement("tr");
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "ردیف";
        headerRowTable.appendChild(headerCell);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "نام شرط اعطا";
        headerRowTable.appendChild(headerCell);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداقل مدت قرارداد";
        headerRowTable.appendChild(headerCell);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداکثرمدت قرارداد";
        headerRowTable.appendChild(headerCell);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداقل مبلغ قرارداد";
        headerRowTable.appendChild(headerCell);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداکثر مبلغ قرارداد";
        headerRowTable.appendChild(headerCell);
        headerCell = document.createElement("TH");
        grantConditionTable.appendChild(headerRowTable);
    }

    function addTableFooter() {
        var grantConditionTable = document.getElementById("grantConditionTable");
        if (!grantConditionTable.tFoot) {
            var footer = grantConditionTable.createTFoot();
            var footerRow = footer.insertRow(0);
            var cell = footerRow.insertCell(0);
            cell.innerHTML = '<!--<input type="button" class="submitButton" value="ثبت نهایی اطلاعات" onclick="document.forms[0].submit();">--> <input type="text" name="rowCount" onclick="document.forms[0].submit(); value="' + grantConditionTable.rows.length + '" hidden>';
        }
    }
}