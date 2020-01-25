<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Import des "tag libraries" de JSP -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<title>Affiche tous les produits</title>
</head>

<body>
	<h1>Liste des produits</h1>
	<a href="produits/create">Ajouter un nouveau produit</a>
	<table border='1'>
		<tr><th>Référence</th><th>Nom</th><th>Prix Unitaire</th><th>Catégorie</th></tr>
		<%-- Pour chaque produit, une ligne dans la table HTML --%>
		<c:forEach var="produit" items="${produits}">
			<tr>
				<td>${produit.reference}</td>
				<%-- Le nom peut contenir des caractères spéciaux HTML ! --%>
				<td>${mvc.encoders.html(produit.nom)}</td>
				<%-- Exemple d'utilisation des fonctions de formatage de données de la JSTL --%>
				<td><fmt:formatNumber value="${produit.prixUnitaire}" type="currency"/></td>
				<td>${mvc.encoders.html(produit.categorie.libelle)}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/">Retour au menu</a>
</body>

</html>