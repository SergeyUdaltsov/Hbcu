var pageInfo = new Object();
$(window).ready(function () {

    var customerId = window.location.href.split("?")[1].split("=")[1];

    loadCustomer('https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/get?id=' + customerId)

    document.getElementById("contrValue").addEventListener("change", changeFunction);

});

function changeFunction() {

    var contracts = pageInfo.contracts;
    var contractNumber = $("#contrValue").val();

    $.each(contracts, function(){
        if(this.number === contractNumber) {
            updateContractInfo(this);
            updateContractTable(this, this.rentBalance.payments, 0);
            updateContractTable(this, this.powBalance.payments, 1);
        }
    });
}

function updateContractInfo(contract) {
    var startDate = new Date(contract.startDate);
    var finishDate = new Date(contract.finDate);

    document.getElementById("areaValue").innerHTML = contract.area;
    document.getElementById("roomValue").innerHTML = contract.room;
    document.getElementById("rentValue").innerHTML = contract.rent;
    document.getElementById("startValue").innerHTML = startDate.toLocaleDateString();
    document.getElementById("finishValue").innerHTML = finishDate.toLocaleDateString();
}

function updateContractTable(contract, payments, item) {
//    var payments = contract.rentBalance.payments;
    var new_tbody = document.createElement('tbody');

        document.getElementsByTagName("tbody").item(item).parentNode.replaceChild(new_tbody, document.getElementsByTagName("tbody").item(item));
    if (payments.length === 0) {
//        document.document.getElementById("rentTableBody").parentNode.replaceChild(new_tbody, document.getElementById("rentTableBody"));
        return;
    }

    $.each(payments, function () {

        var row = document.createElement("tr");
            cell1 = document.createElement("td");
            cell2 = document.createElement("td");
            cell3 = document.createElement("td");
            cell4 = document.createElement("td");

            var date = document.createTextNode(new Date(this.date).toLocaleDateString());
            var sumBill = document.createTextNode(this.sumBill !== 0 ? this.sumBill : '');
            var sumPay = document.createTextNode(this.sumPayment !== 0 ? this.sumPayment : '');
            var balance = document.createTextNode(this.balance)

            cell1.appendChild(date);
//                        cell1.style.textAlign = "center";
//                        cell1.style.width = 150 + 'px';
            cell2.appendChild(sumBill);
//                        cell2.style.textAlign = "left";
//                        cell2.style.width = 400 + 'px';

            cell3.appendChild(sumPay);
//                        cell3.style.textAlign = "left";
//                        cell3.style.width = 500 + 'px';

            cell4.appendChild(balance);

            row.appendChild(cell1);
            row.appendChild(cell2);
            row.appendChild(cell3);
            row.appendChild(cell4);
            new_tbody.appendChild(row);

            document.getElementsByTagName("tbody").item(item).parentNode
                            .replaceChild(new_tbody, document.getElementsByTagName("tbody").item(item));

//            document.getElementById("rentTableBody").parentNode
//            .replaceChild(new_tbody, document.getElementById("rentTableBody"));
      });
}

function loadCustomer(url) {

    $.ajax({
            type: 'get',
            url: url,
            dataType: 'JSON',
            data: {
            },
            success: function (data) {
                var companyName = document.createTextNode(data.companyName);
                var contracts = data.contracts;
                var firstContract = contracts[0];
                pageInfo.contracts = contracts;
                $.each(contracts, function(){
                var opt = $("<option value='" + this.number + "'></option>").text(this.contractName);
                $("#contrValue").append(opt)
                })
                var contractNumber = document.createTextNode(firstContract.number);
                var area = document.createTextNode(firstContract.area);
                var room = document.createTextNode(firstContract.room);
                var rent = document.createTextNode(firstContract.rent);
                var contacts = document.createTextNode(data.contacts);
                var startDate = new Date(firstContract.startDate);
                var startCont = document.createTextNode(startDate.toLocaleDateString());
                var finishDate = new Date(firstContract.finDate);
                var finCont = document.createTextNode(finishDate.toLocaleDateString());
                var description = document.createTextNode(data.description);
//
                document.getElementById("compTitleValue").appendChild(companyName);
                document.getElementById("descValue").appendChild(description);
                document.getElementById("contValue").appendChild(contacts);
                document.getElementById("areaValue").appendChild(area);
                document.getElementById("roomValue").appendChild(room);
                document.getElementById("rentValue").appendChild(rent);
                document.getElementById("startValue").appendChild(startCont);
                document.getElementById("finishValue").appendChild(finCont);
                updateContractTable(firstContract, firstContract.rentBalance.payments, 0);
                updateContractTable(firstContract, firstContract.powBalance.payments, 1);

            },
            error: function (data) {
            }
    });
}

