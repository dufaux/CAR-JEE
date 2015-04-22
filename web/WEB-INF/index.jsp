<%-- 
    Document   : index
    Created on : 22 avr. 2015, 11:44:12
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FNAC - index</title>
        <link rel="stylesheet" href="css/layout.css" media="screen" />
    </head>
    <body>
        <div id="div_connection">
            <form action="index" method="post">
            <label for="identifiant">Adresse email</label>
            <input type="text" id="identifiant" name="identifiant" value="" size="12" maxlength="60" />

            <label for="motdepasse">Mot de passe</label>
            <input type="password" id="motdepasse" name="motdepasse" value="" size="12" maxlength="20" />
            <input type="submit" value="ok"/>
            </form>
        </div>
        <H1 id="main_title">Bienvenue chez la FNAC <H1>
        <div class="centrage_text">
            <a href="bookslist" class="button_link">Acceder au catalogue de livres</a>
            <a href="listAuthors" class="button_link">Acceder à la liste des auteurs</a>
        </div>
    </body>
</html>
