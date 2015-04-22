<%-- 
    Document   : administration
    Created on : 22 avr. 2015, 15:58:15
    Author     : dufaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration</title>
    </head>
    <body>     
        <h1 id="main_title">Administration</h1>
        <div id="div_form">
            <form action="admin" method="post">
                <filedset>
                    <legend>Ajout de livre</legend>
                    <label for="title">Titre</label>
                    <input type="text" id="title" name="title" value="" size="12" maxlength="60" />
                    <br />
                    
                    <label for="year">Annee</label>
                    <input type="number" id="year" name="year"/>
                    <br />
                    
                    <label for="author">Auteur</label>
                    <select type="select" id="author" name="author">
                        
                    </select>
                    <br />
                    
                    <input type="submit" value="Ajouter"/>
                    <input type="" />
                    <br />
                </filedset>
                
                

                
                
                
            </form>
        </div>
    </body>
</html>
