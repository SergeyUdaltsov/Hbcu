var order = new Object();
var vocabulary;
var language;
$(window).ready(function () {

    loadCustomers('https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/get?email=');

    $("#showBut").click(function () {

        var stFirst = $("#stFirst").val();
        var stSecond = $("#stSecond").val();

        $(location).attr('href', 'http://localhost:9999/html/route/SelectedRoutes.html?stFirst=' +
            stFirst + "&stSecond=" + stSecond);


    });

    $("#cancelButton").click(function () {

        $(location).attr('href', 'http://localhost:9999/html/admin/AdminStartPage.html');


    });

    $("#createButton").click(function () {

        $(location).attr('href', 'http://localhost:9999/html/route/CreateNewRoute.html');

    });


});



function loadStations(select) {
    $.ajax({
        url: 'https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/get?email=',
        type: 'get',
        dataType: 'json',

        success: function (data) {
            $.each(data, function () {

                var opt = $("<option value='" + this.id + "'></option>").text((language === 'ru') ? this.nameRu : this.name);
                select.append(opt);
            });
        }
    });
}

function validateUser() {
    var password = readCookie('password');
    var user = JSON.parse(window.localStorage.getItem('user'));

    if (password !== user.password ||
        JSON.parse(window.localStorage.getItem('status')) !== 'admin') {

        $(location).attr('href', 'http://localhost:9999/index.jsp');
    }
}

function loadCustomers(url) {
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

                var row = document.createElement("tr");
                cell1 = document.createElement("td");
                cell2 = document.createElement("td");
                cell3 = document.createElement("td");
                cell4 = document.createElement("td");
                cell5 = document.createElement("td");
                cell6 = document.createElement("td");

                companyName = document.createTextNode(this.companyName);
                exploat = document.createTextNode(this.exploat);
                room = document.createTextNode(this.room);
                rent = document.createTextNode(this.rent);
                power = document.createTextNode(this.power);

                var emailNod = document.createElement('a');
                var nodText = document.createTextNode(this.email);

                emailNod.setAttribute('href', 'http://localhost:9999/html/route/EditRoute.html?id=' + this.id);
                emailNod.appendChild(nodText);

                cell1.appendChild(companyName);
                cell2.appendChild(emailNod);
                cell3.appendChild(room);
                cell4.appendChild(rent);
                cell5.appendChild(exploat);
                cell6.appendChild(power);

                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell3);
                row.appendChild(cell4);
                row.appendChild(cell5);
                row.appendChild(cell6);

                new_tbody.appendChild(row);

                document.getElementsByTagName("tbody").item(0).parentNode.replaceChild(new_tbody, document.getElementsByTagName("tbody").item(0));

            });
        }

    });
}

function readCookie(name) {
    var i, c, ca, nameEQ = name + "=";
    ca = document.cookie.split(';');
    for (i = 0; i < ca.length; i++) {
        c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1, c.length);
        }
        if (c.indexOf(nameEQ) == 0) {
            return c.substring(nameEQ.length, c.length);
        }
    }
    return '';
}

function prepareTime(time) {

    var hours = (Object.values(time)[0] < 10) ? ("0" + Object.values(time)[0]) : (Object.values(time)[0]);
    var minutes = (Object.values(time)[1] < 10) ? ("0" + Object.values(time)[1]) : (Object.values(time)[1]);
    var res = hours + ":" + minutes;
    return res;
}

function prepareDate(date) {
    var month = (Object.values(date)[1] < 10) ? ("-0" + Object.values(date)[1]) : ("-" + Object.values(date)[1]);

    var day = (Object.values(date)[2] < 10) ? ("-0" + Object.values(date)[2]) : ("-" + Object.values(date)[2]);

    var date = Object.values(date)[0] + month + day;
    return date;
}




