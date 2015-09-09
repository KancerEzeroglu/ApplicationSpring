<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- for apache tiles -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<!-- for bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.0.4/js/bootstrap-alert.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#request').click(function() {
							$.ajax({
								type : "get",
								url : "studentPost",
								cache : false,
								success : function(data) {
									alert(data.name + 'Well Done!!!!');
									$('#body_').html("First Name:- " + data.name +"</br>Last Name:- " + data.surname  + "</br>Age:- " + data.age);
								},
								error : function() {
									alert('Error while request..');
								}
							});
						})

						$('#default')
								.click(
										function(e) {
											e.preventDefault()
											$('#message')
													.html(
															'<div class="alert alert-success fade in"><button type="button" class="close close-alert" data-dismiss="alert" aria-hidden="true">×</button>This is a success message</div>');
										})
					});
</script>

</head>
<body>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td height="30" colspan="2" class="text-center"><tiles:insertAttribute
							name="header" />
				</tr>
			</thead>
			<tbody>
				<tr>
					<td height="250" class="text-center"><tiles:insertAttribute
							name="menu" /></td>
					<td width="350" class="text-center" id="body_"><tiles:insertAttribute
							name="body" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td height="30" colspan="2" class="text-center"><tiles:insertAttribute
							name="footer" /></td>
				</tr>
			</tfoot>
		</table>
		<p>
		<form method="get">
			<button type="button" class="btn btn-default" id="default">Tikla!</button>
			<button type="button" class="btn btn-info" id="request">PostRequest</button>
		</form>
		<div id="message"></div>

	</div>

</body>
</html>
