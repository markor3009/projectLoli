<%-- 
    Document   : login
    Created on : Jul 16, 2017, 2:16:02 PM
    Author     : Korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="../loginStyle.css">
</head>

<body>
    <header>

        <nav id="menu-bar">
            <div id="heading">
                <h1>Like it or Leave it</h1>
                <img src="../film-reel.png" alt="Logo">
            </div>
            <ul>
                <li><a href="#">Log in</a></li>
                <li><a href="#">Top Lists</a></li>
                <li><a href="#">Gallery</a></li>
                <li><a href="#">About Us</a></li>
            </ul>
        </nav>
    </header>
    <div class="website">
        <div id="content">
            <section id="marketing-text">
                <h1>Do you like movies?</h1>
                <p>Create an account, explore movies and meet people with similar taste in movies.</p>
            </section>
            <aside id="create-user">
                <h2>Create New Account</h2>
                <form action="" method="POST">
                    <table>
                        <tr>
                            <td>First name:</td>
                            <td><input type="text" placeholder="Your first name" name="firstname">
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td><input type="text" placeholder="Your last name" name="lastname">
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="email" placeholder="Your email" name="email">
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" placeholder="Your password" name="password">
                        </tr>
                        <tr>
                            <td>Repeat password:</td>
                            <td><input type="password" placeholder="Repeat your password" name="repPassword">
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Submit account">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button>
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
            </aside>
        </div>
    </div>
    <footer>
        <p>Developed by Marko Radulović ©</p>
        <a id="google"></a>
        <a id="twitter"></a>
        <a id="fb"></a>
    </footer>
</body>

</html>
