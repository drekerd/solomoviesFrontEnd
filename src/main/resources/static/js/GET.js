$(document).ready(function(){

    $("#getHello").click(function(){

        var name = {"name":$("#firstName").val()};
        $.ajax({
            type: "POST",
            dataType: "text",
            url : "time",
            data : name,
            success : function(data){
                $("#id_time").html(data);
            }
        });
    });

    $("#get_data").click(function(){
    alert("eu");
        $.ajax({
            url:"getMe",
            success:function(data){
                $("#id_time").html(data);
            }
        });
    });

});
