<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Movie Details</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <link href="/css/details.css" rel="stylesheet">

  </head>

  <body>

	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="${movie.thumbnailFullLink}" /></div>
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${movie.name}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
							</div>
							<span class="review-no">Vote Average ${movie.voteAverage}</span>
						</div>
						<p class="product-description">${movie.description}</p>
						<h4 class="price">Tag Line: <span></span></h4>
						<h5 class="sizes">Release Date:
							<span class="size" data-toggle="tooltip" title="s">${movie.releaseDate}</span>
						</h5>
						<h5 class="colors"><span>Trailer:</span><br/>
						<iframe
                            width="420" height="315" src="${movie.trailerFulURL}" frameborder="0" allowfullscreen="false">
                        </iframe>
						</h5>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button">add to cart</button>
							<button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
