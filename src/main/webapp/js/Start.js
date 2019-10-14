var vocabulary;
var language;
var user = new Object();
var customer = new Object();
$(window).ready(function () {

   
    $("#test").click(function () {
        customer.name = $("#companyName").val();
        customer.email = $("#companyEmail").val();
        customer.roomNumber = $("#roomNumber").val();
        var data = JSON.stringify(customer);

        logOut();
    });

})


function logOut() {
    $.ajax({
        url: 'https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/start?name=serg&mail=newmail',
        type: 'get',
        dataType: 'json',

        success: function (data) {
           alert('Lambda worked.')
        }
    });
}

function createCustomer(data) {
    $.ajax({
        type: 'post',
        url: 'https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/start',
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


