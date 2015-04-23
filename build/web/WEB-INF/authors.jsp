<%-- 
    Document   : authors
    Created on : 22 avr. 2015, 13:33:20
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css" media="screen" />
        <title>Liste des auteurs</title>
    </head>
    <body>     
        <h1 id="main_title">Liste des auteurs</h1>
        <div id="div_panier">
            <a href="listBooks">
                <span class="span_display_block">Retour à la boutique</span>
            </a>
            <a href="accueil">
                <span class="span_display_block">Retour à l'accueil</span>
            </a>
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
        <c:forEach items="${authorsList}" var="author">
            <div class="author">
                <span class="name">${author.name}</span>
                <span class="firstname">${author.firstname}</span>
            </div>
        </c:forEach>
    </body>
</html>
