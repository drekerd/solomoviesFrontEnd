<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="/css/lookingGood.css" rel="stylesheet">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="/js/bestMovies.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <title>Hello, world!</title>
  </head>
  <body>

  <!--Navbar-->
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">SoloMovies</a>
      </div>
      <ul class="nav navbar-nav">
        <li><a href="http://localhost:8081/home">Home</a></li>
        <li class="active"><a href="localhost:8081/solomovies">Top Rated By Year</a></li>
        <li><a href="#">Add New Movie</a></li>
        <li><a href="#">Search movie</a></li>
        <li class ="form-column">
        <form action="#">
                <div class="form-group">
                  <label for="exampleInputEmail1">Year</label>
                  <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Year" min="1" max="2019">
                </div>
                <button id="sub" type="submit" class="btn btn-primary">Submit</button>
        </form>
        </li>
      </ul>
    </div>
  </nav>
  <!--/.Navbar-->

    <table class="table table-striped">
      <thead class="thead-light">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Poster</th>
          <th scope="col">Name</th>
          <th scope="col">Description</th>
        </tr>
      </thead>
      <tbody>
      <#list moviesFromBackend as item>
        <tr>
          <th scope="row">${item.listOnTableID?string.computer}</th>
          <td><img src="${item.thumbnailFullLink}" class="poster"></td>
          <td><a href="http://localhost:8081/details/${item.id?string.computer}" target="_blank">${item.name}</a></td>
          <td>${item.description}</td>
        </tr>
      </#list>
      </tbody>
    </table>
  </body>
</html>
