<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Nouveau collaborateur</title>
    </head>
    <body>
		<h1>Nouveau collaborateur</h1>

        <form action="/sgp/collaborateurs/nouveau"  method="post">
           <p>Nom : <input type="text" name="nom" /></p>
           <p>Prénom : <input type="text" name="prenom" /></p>
           <p>Date de naissance : <input type="date" name="date" /></p>
           <p>Adresse : <input type="text" name="adresse" /></p>
           <p>Numéro de sécurité sociale : <input type="text" maxlength="15" size="15" name="num" /></p>
           <p><input type="submit"  value="Créer" /></p>
        </form>


    </body>
</html>