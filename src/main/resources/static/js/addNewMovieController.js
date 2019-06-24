$(document).ready(function(){

    $("#movieSubmit").click(function () {

        var newMovie = {
            "name":$("#movieName").val(),
            "description": $("#movieDescription").val()
        };

        alert(newMovie.name);
        $.ajax({

            type:"POST",
            contentType:'application/json',
            dataType:'json',
            url:'/admin/add-new-movie',
            data: JSON.stringify(newMovie),
            success: function (result) {
                var json = JSON.stringify(result);
                $('#feedback').html(json);
            }
        });

    });

});