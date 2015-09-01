<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Test page</title>
</head>
<body>
<h1>
    ${selam}
</h1>
<h2>Tebrikler</h2>

<form>
<c:forEach var="his" items="${hisler}" >
		<input type="radio">${his} <!-- burada butonlardan biri secili olup diger butonu secince ilk secilen butonun secili hali kalkmiyor -->
		<!-- <c:out value="${his}"/> -->
	</c:forEach>
</form>
</body>
</html>