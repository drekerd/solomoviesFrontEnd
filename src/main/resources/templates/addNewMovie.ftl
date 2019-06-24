<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="/css/addNewMovie.css" rel="stylesheet">
    <script src="/js/addNewMovie.js"></script>
    <script src="/js/addNewMovieController.js"></script>
</head>

<body>


<div class="container">
    <div class="row">

        <div class="col-md-4">
            <form>
                <div id="contact-form" class="form-container" data-form-container>
                    <div class="row">
                        <div class="form-title">
                            <span>Contact Us</span>
                        </div>
                    </div>
                    <div class="input-container">
                        <div class="row">
					<span class="req-input">
						<span class="input-status" data-toggle="tooltip" data-placement="top"
                              title="Input Your First and Last Name."> </span>
						<input id="movieName" type="text" data-min-length="8" placeholder="Name">
					</span>
                        </div>
                        <div class="row">
					<span class="req-input">
						<span class="input-status" data-toggle="tooltip" data-placement="top"
                              title="Please Input Your Email."> </span>
						<input id="movieImage" type="text" placeholder="image">
					</span>
                        </div>
                        <div class="row">
					<span class="req-input">
						<span class="input-status" data-toggle="tooltip" data-placement="top"
                              title="Please Input Your Phone Number."> </span>
						<input id="movieReleaseDate" type="date" placeholder="Release Date">
					</span>
                        </div>
                        <div class="row">
					<span class="req-input message-box">
						<span class="input-status" data-toggle="tooltip" data-placement="top"
                              title="Please Include a Message."> </span>
						<textarea id="movieDescription" type="textarea" data-min-length="10" placeholder="Desciption"></textarea>
                        </div>
                        <div class="row submit-row">
                            <button id="movieSubmit" type="button" class="btn btn-block submit-form">Submit</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div id="feedback"></div>


</body>


</html>

