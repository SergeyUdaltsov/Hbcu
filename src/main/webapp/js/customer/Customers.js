var order = new Object();
var vocabulary;
var language;
$(window).ready(function () {

    loadCustomers('https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/get?id=', $("#companyList"));

    $("#saveContr").click(function () {
    var response = new Object();
    var contract = new Object();
    contract.contractName = $("#contrId").val();
    response.customerId = $("#companyId").val();
    contract.startDate = new Date($("#startDate").val()).getTime();
    contract.finDate = new Date($("#finDate").val()).getTime();
    contract.room = $("#room").val();
    contract.area = $("#area").val();
    contract.rent = $("#rent").val();
    response.contract = contract;
    sendData(JSON.stringify(response), 'https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/contract/sign');
    });

    $("#saveCustomer").click(function() {
    var customer = new Object();
    customer.companyName = $("#companyName").val();
    customer.id = $("#compId").val();
    customer.email = $("#email").val();
    customer.contacts = $("#contacts").val();
    customer.description = $("#descr").val();
    sendData(JSON.stringify(customer), 'https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/create')
    });


    $("#cancelButton").click(function () {

        $(location).attr('href', 'http://localhost:9999/html/admin/AdminStartPage.html');


    });

    $("#createButton").click(function () {

        $(location).attr('href', 'http://localhost:9999/html/route/CreateNewRoute.html');

    });


});

function loadCustomers(url, dataList) {
    $.ajax({
        url: url,
        type: 'get',
        dataType: 'json',
        data: {},

        success: function (data) {
            var new_tbody = document.createElement('tbody');

            if (data.length === 0) {
                document.getElementsByTagName("tbody").item(0).parentNode.replaceChild(new_tbody, document.getElementsByTagName("tbody").item(0));
                return;
            }

            $.each(data, function () {

                var opt = $("<option value='" + this.id + "'></option>").text(this.companyName);
                dataList.append(opt);

                var row = document.createElement("tr");
                cell1 = document.createElement("td");
                cell2 = document.createElement("td");
                cell3 = document.createElement("td");

                companyName = document.createTextNode(this.companyName);
                companyId = document.createTextNode(this.id);
                expBal = document.createTextNode(this.explBalance);
                room = document.createTextNode(this.room);
                contrExp = document.createTextNode(new Date(this.contractExpiration).toLocaleDateString());
                rentBal = document.createTextNode(this.rentBalance);
                power = document.createTextNode(this.powerBalance);
                contacts = document.createTextNode(this.contacts);

                var companyNameNode = document.createElement('a');
                var nodText = document.createTextNode(this.companyName);

                companyNameNode.setAttribute('href', 'https://account-assist.s3.eu-central-1.amazonaws.com/html/customer/CustomerProfile.html?id=' + this.id);
                companyNameNode.appendChild(companyId);

                cell1.appendChild(companyNameNode);
                cell1.style.textAlign = "center";
                cell1.style.width = 150 + 'px';
                cell2.appendChild(companyName);
                cell2.style.textAlign = "left";
                cell2.style.width = 400 + 'px';

                cell3.appendChild(contacts);
                cell3.style.textAlign = "left";
                cell3.style.width = 500 + 'px';


                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell3);
                new_tbody.appendChild(row);

                document.getElementsByTagName("tbody").item(0).parentNode
                .replaceChild(new_tbody, document.getElementsByTagName("tbody").item(0));

            });
        }

    });
}

function sendData(data, url) {
    $.ajax({
        type: 'post',
        url: url,
        dataType: 'JSON',
        data: data
        ,
        success: function (data) {

        },
        error: function (data) {

        },
        complete: function (data) {

        }
    });
}
