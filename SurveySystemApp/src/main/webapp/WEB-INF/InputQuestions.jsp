<%@ page import="java.util.*" %>
<%
    int num = (Integer) session.getAttribute("num");
%>
<form action="InputQuestionsServlet" method="post">
    <% for(int i = 1; i <= num; i++) { %>
        <h3>Question <%= i %>:</h3>
        <input type="text" name="q<%=i%>" required placeholder="Question <%=i%>"><br>
        Option 1: <input type="text" name="q<%=i%>o1" required><br>
        Option 2: <input type="text" name="q<%=i%>o2" required><br>
        Option 3: <input type="text" name="q<%=i%>o3" required><br>
        Option 4: <input type="text" name="q<%=i%>o4" required><br><br>
    <% } %>
    <input type="submit" value="Start Survey">
</form>