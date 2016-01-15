<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
 
<script type="text/javascript" src="<c:url value="/static/js/demo-rtl.js"/>"></script>
 
<link rel="shortcut icon"
	href="<c:url value="/static/img/Joygame.png"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/bootstrap/bootstrap.min.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/libs/font-awesome.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/libs/nanoscroller.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/compiled/theme_styles.css"/> " />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/libs/datepicker.css"/>"  />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/libs/daterangepicker.css"/>"
	 />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/libs/bootstrap-timepicker.css"/>"
	 />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/libs/select2.css"/>"  />
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'
	rel='stylesheet' type="text/css"/>

</head>

<body id="login-page-full" class="theme-whbl fixed-header fixed-footer">

	<div id="login-full-wrapper">
		<div class="container">
			<div class="row">
				<div class="overlay-bg"></div>
				<div class="col-xs-12">
					<div id="login-box">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

