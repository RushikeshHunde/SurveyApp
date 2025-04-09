<%@ page import="java.util.*" %>
<%@ page session="true" %>
<html>
<head>
    <title>Take Survey</title>
    <link rel="stylesheet" type="text/css" href="css/TakeSurvey.css?v=2">
    <style>
        body { font-family: Arial; margin: 40px; }
        .question-block { margin-bottom: 20px; }
        .question-title { font-weight: bold; }
    </style>
</head>
<body>
    <h2>Take Survey</h2>
    <form action="SaveUsersSurvey" method="post">
        <%
            List<Map<String, Object>> questions = (List<Map<String, Object>>) session.getAttribute("questions");
            if (questions != null) {
                for (int i = 0; i < questions.size(); i++) {
                    Map<String, Object> q = questions.get(i);
                    String question = (String) q.get("question");
                    String[] options = (String[]) q.get("options");
        %>
                    <div class="question-block">
                        <div class="question-title"><%= (i + 1) + ". " + question %></div>
                        <% for (int j = 0; j < options.length; j++) { %>
                            <label>
                                <input type="radio" name="q<%=i%>" value="<%=options[j]%>" required />
                                <%= options[j] %>
                            </label><br/>
                        <% } %>
                    </div>
        <%
                }
            }
        %>
        <input type="submit" value="Submit Survey" />
    </form>
</body>
</html>
