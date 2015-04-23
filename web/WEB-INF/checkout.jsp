<%-- 
    Document   : checkout
    Created on : 22 avr. 2015, 23:40:26
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css" media="screen" />
        <title>Commande</title>
    </head>
    <body>  
        <H1 id="main_title">Commande</H1>
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
        </div>
        <div id="main">
            <c:if test="${!connected}">
                <h2 class="error">Veuillez vous connecter avant de commander votre selection</h2>
            </c:if>
            <c:if test="${emptycart}">
                <h2 class="error">Votre panier est vide</h2>
            </c:if>
            <c:if test="${connected && !emptycart}">
                <h2>Votre commande a bien été enregistrée</h2>
                <span>Récapitulatif de votre commande:</span>
                <div>
                    <ul>
                    <c:forEach items="${books}" var="b">
                        <li>${b.title}</li>
                    </c:forEach>
                    </ul>
                </div>
            </c:if>
            
            
        </div>
    </body>
</html>
