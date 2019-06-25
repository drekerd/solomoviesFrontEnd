$(document).ready(function(){

    $("#sub").click(function(){
    var year = {"year":$("#exampleInputEmail1").val()};
        $.ajax({
            url:"getBestMovies",
            data : year,
            success: function(msg){
                window.location.reload();
            }
        });

    });

    $("#editButton").on('click', function () {

        $('#modalEditForm').modal({
            show:true,
            backdrop: false
        });

        var $row = $(this).closest('tr');

        var movie = $row.children('td').map(function () {
            return $(this).text();
        }).get();

        var movieImage =$row.children('td').find('.poster').attr('src');


        console.log("Movie From Grid "+movie);
        console.log("Movie Image "+$row.children('td').find('.poster').attr('src'));

        $('#mid').val(movie[0]);
        $('#mName').val(movie[2]);
        $('#mDescription').val(movie[3]);
        $('#mImage').val(movieImage);
        $('#mReleaseDate').val(movie[4]);

        $('#cenas').val(movie);
    });

    $('#movieEditForm').on('submit', function (e) {

        e.preventDefault();

        var id = $('#mid').val();

        var newMovie = {
            "id":$("#mid").val(),
            "name":$("#mName").val(),
            "date":$("#mReleaseDate").val(),
            "thumbnailFullLink":$("#mImage").val(),
            "description": $("#mDescription").val()
        };

        $.ajax({
            type:'PUT',
            contentType:'application/json',
            dataType:'json',
            url:"/admin/edit-movie",
            data:JSON.stringify(newMovie),
            success:function (response) {
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


});