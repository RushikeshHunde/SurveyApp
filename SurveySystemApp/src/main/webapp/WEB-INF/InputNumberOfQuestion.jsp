<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Design Survey</title>
    <link rel="stylesheet" href="CSS/Design.css">
</head>
<body>
    <h1>Design Your Survey</h1>
    <form action="InputNumberOfQuestionServlet" method="post">
        <label for="numQuestions"> Enter Number of Questions:</label>
        <input type="number" id="num" name="num"  min="1" placeholder="Enter number" required/>
        <input type="submit" value="Next" />
    </form>
</body>
</html>
