<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- for apache tiles -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/bootstrap/bootstrap.min.css"/>" />

<script src="<c:url value="/static/js/demo-rtl.js"/>"></script>
 
 
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/libs/font-awesome.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/libs/nanoscroller.css"/>" />
 
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/compiled/theme_styles.css"/> "/>
 
<link rel="stylesheet" href="<c:url value="/static/css/libs/datepicker.css"/>" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/static/css/libs/daterangepicker.css"/>" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/static/css/libs/bootstrap-timepicker.css"/>" type="text/css"/>
<link rel="stylesheet" href="<c:url value="/static/css/libs/select2.css"/>" type="text/css"/>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400' rel='stylesheet' type='text/css'>

</head>
<body class="theme-whbl pace-done">
<div id="theme-wrapper">
	<tiles:insertAttribute name="header" />
	<div id="page-wrapper" class="container">
		<div class="row">
			<div id="nav-col">
			<tiles:insertAttribute name="menu" />
			</div>
			<div id="content-wrapper">
			<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</div>
<script src="<c:url value="/static/js/jquery.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.js"/>"></script>
<script src="<c:url value="/static/js/jquery.nanoscroller.min.js"/>"></script>
 
<script src="<c:url value="/static/js/jquery.maskedinput.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap-datepicker.js"/>"></script>
<script src="<c:url value="/static/js/moment.min.js"/>"></script>
<script src="<c:url value="/static/js/daterangepicker.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap-timepicker.min.js"/>"></script>
<script src="<c:url value="/static/js/select2.min.js"/>"></script>
<script src="<c:url value="/static/js/hogan.js"/>"></script>
<script src="<c:url value="/static/js/typeahead.min.js"/>"></script>
<script src="<c:url value="/static/js/jquery.pwstrength.js"/>"></script>
 
<script src="<c:url value="/static/js/scripts.js"/>"></script>
<script src="<c:url value="/static/js/pace.min.js"/>"></script>

<script src="<c:url value="/static/js/include.js"/>"></script>
<script src="<c:url value="/static/css/include.css"/>"></script>

<input id="contextPath" type="hidden" value="<c:url value="/"/>"/>

</body>
</html>
