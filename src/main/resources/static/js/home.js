$(document).ready(function(){

    $("#sub").click(function(){
    var year = {"year":$("#exampleInputEmail1").val()};
        $.ajax({
            url:"getBestMovies",
            data : year,
            success: function(msg){

            }
        });
        window.location.reload();
    });

     $("#topRated").click(function() {
            window.location.href='/solomovies';
     });
});



