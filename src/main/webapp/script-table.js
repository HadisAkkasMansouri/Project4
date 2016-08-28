
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
    } else {
        deleteTableFooter();
    }
    if (grantConditionName.value != "" && minDuration.value != "" && maxDuration.value != "" && minAmount.value != "" && maxAmount != ""){
        rowCount = grantConditionTable.rows.length;
        var row = grantConditionTable.insertRow(rowCount);
        row.insertCell(0).innerHTML = (rowCount).toString();
        row.insertCell(1).innerHTML = '< input type ="text" name = "grantConditionName"' + rowCount + '"value"' + grantConditionName.value + '"readonly">';
        row.insertCell(2).innerHTML = '< input type ="text" name = "minDuration"' + rowCount + '"value"' + minDuration.value + '"readonly">';
        row.insertCell(3).innerHTML = '< input type ="text" name = "maxDuration"' + rowCount + '"value"' + maxDuration.value + '"readonly">';
        row.insertCell(4).innerHTML = '< input type ="text" name = "minAmount"' + rowCount + '"value"' + minAmount.value + '"readonly">';
        row.insertCell(5).innerHTML = '< input type ="text" name = "maxAmount"' + rowCount + '"value"' + maxAmount.value + '"readonly">';
        row.insertCell(6).innerHTML = '< button class ="button" onClick="deleteRowTable(this)">حذف</button>';
    }
    addTableFooter();

    document.getElementById("grantConditionName").value = "";
    document.getElementById("minDuration").value = "";
    document.getElementById("maxDuration").value = "";
    document.getElementById("minAmount").value = "";
    document.getElementById("maxAmount").value = "";
    
    function addTableHeader() {

        var grantConditionTable = document.getElementById("grantConditionTable");
        var rowCount = grantConditionTable.rows.length;
        var headerRowTable = grantConditionTable.insertRow(rowCount);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "ردیف";
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "نام شرط اعطا";
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداقل مدت قرارداد";
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداکثرمدت قرارداد";
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداقل مبلغ قرارداد";
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداکثر مبلغ قرارداد";
    }

    function addTableFooter() {

        var grantConditionTable = document.getElementById("grantConditionTable");
        if (!grantConditionTable.tFoot) {
            var footer = grantConditionTable.createTFoot();
            var footerRow = footer.insertRow(0);
            var cell = footerRow.insertCell(0);
            cell.innerHTML = '<input type="submit" class="button" value="ثبت اطلاعات"> <input type="text" name="rowCount" value="' + grantConditionTable.rows.length + '" hidden>';
        }
    }
    
    function deleteRowTable(input) {

        var index = input.parentNode.parentNode.rowIndex;
        var grantConditionTable = document.getElementById("grantConditionTable");
        grantConditionTable.deleteRow(index);
        deleteTableFooter();
        var rowCount = grantConditionTable.rows.length;
        if (rowCount == 1) {
            grantConditionTable.innerHTML = "";
        } else {
            for (var i = 1; i < rowCount; i++) {
                grantConditionTable.rows[i].cells[0].innerHTML = i.toString();
            }
            addTableFooter();
        }
    }

    function deleteTableFooter() {

        var grantConditionTable = document.getElementById("grantConditionTable");
        if (grantConditionTable.tFoot) {
            grantConditionTable.deleteTFoot();
        }
    }
}
