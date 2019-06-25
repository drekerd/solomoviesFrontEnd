<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="/js/updateMovie.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <!------ Include the above in your HEAD tag ---------->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="/css/adminListMovies.css" rel="stylesheet">

    <title>Solomovies Admin</title>
</head>

<body>
<!--Navbar-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">SoloMovies</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8081/home">Home</a></li>
            <li><a href="http://localhost:8081/solomovies" id="topRated">Top Rated By Year</a></li>
            <li><a href="#">Add New Movie</a></li>
            <li><a href="#">Search movie</a></li>
            <li class="form-column">
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
    <div id="feedback"></div>
    </thead>
    <tbody>
    <#list moviesFromDB as item>
        <tr>
            <td scope="row">${item.id?string.computer}</td>
            <td><img src="${item.thumbnailFullLink}" class="poster"></td>
            <td><a href="http://localhost:8081/details/${item.id?string.computer}" target="_blank">${item.name}</a></td>
            <td>${item.description}</td>
            <td>${item.date}</td>
            <td><a href="#" class="btn btn-success editbtn" id="editButton">Edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</body>

<!--modal-->
<div class="modal fade" id="modalEditForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Edit Movie</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="movieEditForm">
                <div class="modal-body mx-3">
                    <div class="md-form mb-5">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <label>Movie ID</label>
                        <input type="text" id="mid" class="form-control validate" readonly>
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <label data-error="wrong" data-success="right" for="mName">Movie Name</label>
                        <input type="text" id="mName" class="form-control validate">
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <label data-error="wrong" data-success="right" for="mDescription">Movie Description</label>
                        <textarea type="text" id="mDescription" class="form-control validate"></textarea>
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <label data-error="wrong" data-success="right" for="mReleaseDate">Movie Release Date</label>
                        <input type="text" id="mReleaseDate" class="form-control validate">
                    </div>

                    <div class="md-form mb-4">
                        <i class="fas fa-lock prefix grey-text"></i>
                        <label data-error="wrong" data-success="right" for="mImage">Movie Image</label>
                        <input type="text" id="mImage" class="form-control validate">
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button type="submit" class="btn btn-default">Edit</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--/modal-->
</html>
