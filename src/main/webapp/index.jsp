 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>

<body>
    <fieldset>
        <legend>Login</legend>
        ${message} <br>
        <form method="post" action="">
            <table cellpadding="2" cellspacing="2">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="login" required placeholder="login"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" required placeholder="password"></td>
                </tr>
                <tr>
                    <td>Enter</td>
                    <td><input type="submit" name="Login"></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>