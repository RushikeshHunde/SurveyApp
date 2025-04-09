<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/index.css?v=2">
</head>

<body>
<form action="LoginServlet" method="post">
     <h2>Login Form</h2>
            <input type="text"     name="name"      id="name" placeholder="Full Name" required>
            <input type="email"    name="email"     id="email" placeholder="Email" required>
            <input type="password" onclick="togglePassword()" name="password"  id="password" placeholder="Password" required>
            <input type="number"   name="age"       id="age" placeholder="Age" required>
            <select id="gender" name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            <input type="tel" name="contact" id="contact" placeholder="Contact Number" required>
            <button type="submit" value="login">Login</button>
  </form>
  <script>
function togglePassword() {
    var pw = document.getElementById("password");
    pw.type = pw.type === "password" ? "text" : "password";
}
</script>
</body>
</html>