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

<table border="1">
<tr>
<c:forEach var="isim" items="${dizinIsimler}" >
		<td> <h2>${isim}</h2> </td>
		<!-- <c:out value="${isim}"/> -->
	</c:forEach>
	</tr>
	</table>
	
<a href="sayfa3">tikla canim</a>

</body>
</html>