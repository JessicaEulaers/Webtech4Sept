<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Eightball: Get your Answer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Answer</h1>
<img src="backorb.jpeg" width="160" height="160" ></img>
<p th:text="'Question is : ' + ${ballDTO.question}" />
<p th:text="'Answer : ' + ${ballDTO.answer}" />
<a href="/eightball">Ask another question</a>
</body>
</html>