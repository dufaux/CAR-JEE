<%-- 
    Document   : register
    Created on : 22 avr. 2015, 20:32:29
    Author     : rakotoarivony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>S'enregistrer</h1>
        <div id="div_form">
            <form action="register" method="post">
                <fieldset>
                    <legend>Information</legend>
                    <label for="username">Nom d'utilisateur</label>
                    <input type="text" id="username" name="username" value="" size="12" maxlength="60" />
                    <br />
                    
                    <label for="password">Mot de passe</label>
                    <input type="password" id="password" name="password"/>
                    <br />
                    
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email"/>
                    <br />
                    
                    <input type="submit" value="S'enregistrer"/>
                    <br />
                </fieldset>
            </form>
        </div>
    </body>
</html>
