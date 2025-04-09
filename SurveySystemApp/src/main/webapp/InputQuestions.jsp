<%@ page import="java.util.*" %>
<%@ page session = "true" %>
<%
Integer numObj = (Integer) session.getAttribute("num");
if (numObj == null) {
    response.sendRedirect("InputNumberOfQuestion.jsp"); // or show error
    return;
}
int num = numObj.intValue();
%>
<html>
<head>
    <title>Enter Survey Questions</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/InputQuestions.css">
</head>
<body>
    <h1>Design Survey Questions</h1>
    <form action="InputQuestionsServlet" method="post">
        <% for(int i = 1; i <= num; i++) { %>
            <div class="question-block">
                <label>Question <%= i %>:</label>
                <input type="text" name="q<%=i%>" required placeholder="Enter Question <%=i%>"><br>

                <input type="text" name="q<%=i%>o1" required placeholder="Option 1"><br>
                <input type="text" name="q<%=i%>o2" required placeholder="Option 2"><br>
                <input type="text" name="q<%=i%>o3" required placeholder="Option 3"><br>
                <input type="text" name="q<%=i%>o4" required placeholder="Option 4"><br>
            </div>
        <% } %>
        <input type="submit" value="Start Survey">
    </form>
</body>
</html>