$(document).ready(function () {

    $("#sub").click(function () {
        var year = {"year": $("#exampleInputEmail1").val()};
        $.ajax({
            url: "getBestMovies",
            data: year,
            success: function (msg) {
                window.location.reload();
            }
        });

    });

    $(".editbtn").on('click', function () {

        console.log("clicked edit");

        $('#modalEditForm').modal({
            show: true,
            backdrop: false
        });

        var $row = $(this).closest('tr');

        console.log($row);

        var movie = $row.children('td').map(function () {
            return $(this).text();
        }).get();

        console.log(movie);

        var movieImage = $row.children('td').find('.poster').attr('src');


        console.log("Movie From Grid " + movie);
        console.log("Movie Image " + $row.children('td').find('.poster').attr('src'));

        $('#mid').val(movie[0]);
        $('#mName').val(movie[2]);
        $('#mDescription').val(movie[3]);
        $('#mImage').val(movieImage);
        $('#mReleaseDate').val(movie[4]);
    });

    $('#movieEditForm').on('submit', function (e) {
        e.preventDefault();

        console.log("entered in edit");

        var newMovie = {
            "id": $("#mid").val(),
            "name": $("#mName").val(),
            "date": $("#mReleaseDate").val(),
            "thumbnailFullLink": $("#mImage").val(),
            "description": $("#mDescription").val()
        };

        console.log(newMovie);

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            dataType: 'json',
            url: "/admin/edit-movie",
            data: JSON.stringify(newMovie),
            success: function (response) {
                console.log(response);
                $('#modalEditForm').modal('hide');
                window.location.reload();
            },
            error: function (error) {
                console.log(error)
            }
        })

        $('#modalEditForm').modal('hide');
        window.location.reload();
    });

    //add Movie
    $("#addButton").on('click', function () {

        $('#modalAddForm').modal({
            show: true,
            backdrop: false
        });
    });

    $("#movieAddForm").on('submit', function (e) {

        e.preventDefault();

        var newMovie = {
            "id": $("#mAddid").val(),
            "name": $("#mAddName").val(),
            "date": $("#mAddReleaseDate").val(),
            "thumbnailFullLink": $("#mAddImage").val(),
            "description": $("#mAddDescription").val()
        };

        $.ajax({

            type: "POST",
            contentType: 'application/json',
            dataType: 'json',
            url: '/admin/add-new-movie',
            data: JSON.stringify(newMovie),
            success: function (result) {
                window.location = '/admin/list-movies'
                var json = JSON.stringify(result);
                $('#feedback').html(json);
                window.location.reload();
            }
        });

    });

    //Delete
    $(".deletebtn").on('click', function (e) {
        e.preventDefault();

        var $row = $(this).closest('tr');

        var movie = $row.children('td').map(function () {
            return $(this).text();
        }).get();

        var id = movie[0];

        $.ajax({

            type: "DELETE",
            url: '/admin/delete-movie/' + id,
            success: function (result) {
                window.location = '/admin/list-movies'
                var json = JSON.stringify(result);
                window.location.reload();

            }
        });
    });


});