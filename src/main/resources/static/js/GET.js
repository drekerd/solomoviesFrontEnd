$(document).ready(function(){

  $("#getHello").click(function(){
        $.ajax({
            url : "time",
            success : function(data){
                $("#id_time").html(data);
            }
        });
  });

});
