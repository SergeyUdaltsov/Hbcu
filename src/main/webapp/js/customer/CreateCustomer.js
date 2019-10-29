customer = new Object();
$(window).ready(function () {

   
    $("#create").click(function () {
        customer.companyName = $("#name").val();
        customer.id = $("#id").val();
        customer.email = $("#email").val();
        customer.contract = $("#contrId").val();
        customer.room = $("#room").val();
        customer.area = $("#area").val();
        customer.rent = $("#rent").val();
        customer.contractExpiration = new Date($("#contractExp").val()).getTime();
        customer.contacts = $("#contact").val();
        var data = JSON.stringify(customer);

        createCustomer(data);
    });

})


function createCustomer(data) {
    $.ajax({
        type: 'post',
        url: 'https://0jtishgt05.execute-api.eu-central-1.amazonaws.com/prod/customer/create',
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