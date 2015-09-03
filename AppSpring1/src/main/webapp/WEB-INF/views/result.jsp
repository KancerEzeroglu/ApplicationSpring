<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Surname</td>
        <td>${surname}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${age}</td>
    </tr>
</table>  
</body>
</html>