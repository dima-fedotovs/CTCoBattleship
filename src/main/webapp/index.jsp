<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Battleship</title>
</head>
<body>
<h1>Welcome to Battleship game!</h1>
<h2>Please enter your name to start</h2>
<form method="post" action="<c:url value="/registration"/>">
    <input type="text" name="username">
    <button>Start</button>
</form>
</body>
</html>
