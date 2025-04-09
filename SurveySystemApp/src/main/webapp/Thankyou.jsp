<%@ page import="java.util.*" %>
<%@ page session="true" %>
<html>
<head>
<title>Thankyou</title>
<link rel="stylesheet" type="text/css" href="css/Thankyou.css?v=2">
</head>

<body>
    <h2>Thank you for submitting the survey!</h2>

    <%
        List<String> answers = (List<String>) session.getAttribute("userAnswers");
        if (answers != null) {
    %>
        <h3>Your Answers:</h3>
        <ul>
            <% for (String ans : answers) { %>
                <li><%= ans %></li>
            <% } %>
        </ul>
    <%
        }
    %>
 <div class="button-container">
        <form action="index.jsp" method="get">
            <button type="submit" class="btn">Login Page</button>
        </form>

        <form action="InputNumberOfQuestion.jsp" method="get">
            <button type="submit" class="btn">Design Survey</button>
        </form>
    </div>
</body>
</html>