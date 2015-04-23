<%-- 
    Document   : index
    Created on : 22 avr. 2015, 11:44:12
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FNAC - index</title>
        <link rel="stylesheet" href="css/layout.css" media="screen" />
    </head>
    <body>
        <%@include file="searchbar.jsp" %>
        <div id="div_panier">
            <a href="cart">
                <span class="span_display_block">Voir votre panier</span>
                <img class="display_inherit" src="img/panier.png">
            </a>
            <a href="listBooks">
                <span class="span_display_block">Aller à la boutique</span>
            </a>
            <a href="admin"><span class="span_display_block">Ajouter un livre</span></a>
        </div>
        <div id="div_connection">
            <c:if test="${!connected}">
                <form action="accueil" method="post">
                <label for="ident">Identifiant</label>
                <input type="text" id="ident" name="ident" value="" size="12" maxlength="60" />

                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" value="" size="12" maxlength="20" />
                <input type="submit" value="ok"/>
                <a href="register"><button>S'enregistrer</button></a>
                </form>
                <c:if test="${wrongconnec}">
                    <span class="error">Identifiant ou mot de passe incorrect(s)</span>
                </c:if>
            </c:if>
            <c:if test="${connected}">
                <span>connecté en tant que ${identifiant}</span>
            </c:if>
        </div>
        <h1 id="main_title">Bienvenue chez la FNAC </h1>
        <div class="centrage_text">
            <a href="listBooks" class="button_link">Acceder au catalogue de livres</a>
            <a href="listAuthors" class="button_link">Acceder à la liste des auteurs</a>
        </div>
    </body>
</html>
