<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Produits dans la catégorie '${selected.libelle}'</title>
	</head>

	<body>
		<h3>Choisissez la catégorie à afficher</h3>
		<form> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
			<%-- Une liste de choix pour le paramètre 'code' --%>
			<select name='code' onchange='this.form.submit()'>
				<%-- On parcourt la liste des catégories en mettant une option pour chaque catégorie --%>
				<c:forEach var="categorie" items="${categories}">
					<%-- la valeur de l'option c'est le code de la catégorie --%>
					<option value='${categorie.code}' 
						<%--On détermine quelle et l'option sélectionnée dans la liste --%>
						<c:if test="${categorie.code eq selected.code}">
							selected
						</c:if>
					> <%-- le texte affiché pour l'opton c'est le libellé de la catégorie --%>
						${categorie.libelle}
					</option>
				</c:forEach>
			</select>
			<input type='submit'>
		</form>
		<h2>Produits dans la catégorie '${selected.libelle}'</h2>
		<%-- On montre la liste des produits dans la catégorie sélectionnée sous la forme d'une table HTML --%>		
		<table border='1'>
			<tr><th>Référence</th><th>Nom</th><th>Disponible ?</th></tr>
			<%-- Est-ce qu'il y a des produits dans la catégorie sélectionnée ? --%>
			<c:if test="${empty selected.produitCollection}">
				<tr><td colspan="3">aucun produit dans cette catégorie</td></tr>	
			</c:if>
			<%-- Une ligne dans la table pour chaque produit --%>				
			<c:forEach var="produit" items="${selected.produitCollection}">
				<tr>
					<td>${produit.reference}</td>
					<td>${produit.nom}</td>
					<td>
						<input type="checkbox"
						       <c:if test="${produit.indisponible eq 0}">checked</c:if>
						>
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<a href="${pageContext.request.contextPath}/">Retour au menu</a>
	<hr>
	<h3>Code source</h3>
	<ul>
		<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/java/controller/CategorieProduitController.java" target="_blank">Le contrôleur</a></li>
		<li><a href="https://bitbucket.org/rbastide/comptoirs_mvc/src/test/src/main/webapp/WEB-INF/views/categorieProduits.jsp"  target="_blank">La vue</a></li>
	</ul>		
</html>