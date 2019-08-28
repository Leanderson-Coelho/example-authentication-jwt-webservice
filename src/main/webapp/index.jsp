
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Users</title>
</head>
<body>
    <form action="api/clients" method="POST">
        <label>Name:</label>
        <input name="name" type="text" /></br>
        <label>Email:</label>
        <input name="email" type="email" /></br>
        <label>Password:</label>
        <input name="password" type="password" />
        <input type="submit" value="Send" />
    </form>
</body>
</html>
