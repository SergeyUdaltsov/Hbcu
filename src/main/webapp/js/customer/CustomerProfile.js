$(window).ready(function () {

    var customerId = window.location.href.split("?")[1].split("=")[1];

    loadCustomer('https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/get?id=' + customerId)


});

function loadContractInfo(payments) {
    var new_tbody = document.createElement('tbody');

    if (payments.length === 0) {
        document.getElementsByTagName("tbody").item(0).parentNode.replaceChild(new_tbody, document.getElementById("rentTableBody"));
        return;
    }

    $.each(payments, function () {

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
                $.each(contracts, function(){
                var opt = $("<option value='" + this.number + "'></option>").text(this.number);
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


            },
            error: function (data) {
            }
    });
}

