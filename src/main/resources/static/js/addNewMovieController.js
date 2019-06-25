$(document).ready(function(){

    $("#movieSubmit").click(function () {

        var newMovie = {
            "name":$("#movieName").val(),
            "date":$("#movieReleaseDate").val(),
            "thumbnailFullLink":$("#movieImage").val(),
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
                window.location='admin/list-movies'
                var json = JSON.stringify(result);
                $('#feedback').html(json);
            }
        });

    });

});