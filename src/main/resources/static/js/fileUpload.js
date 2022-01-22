$(document).ready(function() {

    $("#submitButton").click(function(event) {
        event.preventDefault();
        ajaxSubmitForm();
    });
});

function ajaxSubmitForm() {

    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);

    $("#submitButton").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/uploadImage",
        data: data,

        // prevent jQuery from automatically transforming the data into a query string
        processData: false,
        contentType: false,
        cache: false,
        timeout: 1000000,
        success: function(data) {
            $("#result").html(data);
            console.log("SUCCESS : ", data);
            $("#submitButton").prop("disabled", false);
            $('#fileUploadForm')[0].reset();
        },
        error: function(jqXHR) {
            $("#result").html(jqXHR.responseText);
            console.log("ERROR : ", jqXHR.responseText);
            $("#submitButton").prop("disabled", false);

        }
    });

}