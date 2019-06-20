<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="css/form.css">
<script src="css/formPOST.js"></script>
<script src="css/formGET.js"></script>

    <title>Hello, world!</title>
  </head>
  <body>
<div id="postResultDiv" align="center"></div>
	<div class="container">
		<h2>Stacked form</h2>
		<form id="movieForm">
			<div class="form-group">
				<label for="id">Book ID:</label> <input type="text"
					class="form-control" id="movieId" placeholder="Enter Book Id"
					name="bookId">
			</div>
			<div class="form-group">
				<label for="name">Book Name:</label> <input type="text"
					class="form-control" id="movieName" placeholder="Enter Book Name"
					name="bookName">
			</div>
			<div class="form-group">
				<label for="description">Author :</label> <input type="text"
					class="form-control" id="movieDescription" placeholder="Enter Author name"
					name="author">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		<div class="col-sm-7" style="margin: 20px 0px 20px 0px">
			<button id="getALlMovies" type="button" class="btn btn-primary">Get
				All Books</button>
			<div id="getResultDiv" style="padding: 20px 10px 20px 50px">
				<ul class="list-group">
				</ul>
			</div>
		</div>
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


  </body>
</html>