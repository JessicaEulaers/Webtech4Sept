<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Eightball: Ask Any Question</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Eightball Question Form</h1>
<img src="orb.jpeg" ></img>
<form action="#" th:action="@{/eightball}" th:object="${ballDTO}" method="post">
    <p>Ask your Question: <input type="text" th:field="*{question}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>
</body>
</html>