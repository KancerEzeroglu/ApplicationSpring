<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Test page</title>
</head>
<body>
<h2>Ogrencinin adi: ${student_features.name}</h2>
<h2>Ogrencinin soyadi: ${student_features.surname}</h2>
<h2>Ogrencinin Bolumu: ${student_features.department}</h2>
<h2>Ogrencinin yasi: ${student_features.age}</h2>
<h2>Ogrencinin adresi: ${student_features.address}</h2>

<h2>Dersleri:</h2>

<table border="1">
<tr>
<c:forEach var="dersler" items="${student_features.lessons}" >
		<td> <h3>${dersler}</h3> </td>
		
	</c:forEach>
	</tr>
	</table>

<h2>Arkadaslari:</h2>
<table border="1">
<tr>

<c:forEach var="arkadaslar" items="${student_features.friends}" >
		<td> <h3>${arkadaslar}</h3> </td>
		
	</c:forEach>
	</tr>
	</table>
	
<!-- <h2>Ogrenci: ${student_features}</h2>  Ogrenci bir obje oldugu icin boyle bir kod yazildiginda
bilgisayarin verdigi bir deger gorunecek, anlamli bir sey gorunmeyecektir -->
	
</body>
</html>