<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" >
</head>

<div class="errors">
	${exception}
</div>

<div id=formCat >
	<f:form modelAttribute="produit" action="saveprod" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>ID produit</td>
				<td> <f:input path="idproduit" /> </td>
				<td> <f:errors path="idproduit" cssClass="errors "> </f:errors></td>
			</tr>
			<tr>
				<td>désignation</td>
				<td><f:input path="designation"/></td>
				<td><f:errors path="designation" cssClass="errors "></f:errors></td> 
				
			</tr>
			<tr>
				<td>catégorie</td>
				<td><f:select path="categorie.idcategorie" items="${categories}" itemValue="idcategorie" itemLabel="nomcategorie"></f:select></td>
				<td><f:errors path="prix" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>prix</td>
				<td><f:input path="prix"/></td>
				<td><f:errors path="prix" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>quantité</td>
				<td><f:input path="quantite"/></td>
				<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>selectionner ?</td>
				<td><f:checkbox path="selected"/></td>
				<td><f:errors path="selected" cssClass="errors"></f:errors></td>
			</tr>
			<c:if test="${produit.idproduit!=null }">
					<img alt="" src="photoprod?idprod=${produit.idproduit}">
				</c:if>
			<tr>
				<td><input type="file" name="file"/></td>
				<td></td>
			</tr>
			<tr>
				<td><input type= "submit" name="save"></td>
			</tr>
		</table>
	</f:form>
</div>

<div id=""> 
	<table >
		<tr>
			<td> ID</td>
			<td>DESIGNATION </td>
			<td>DESCRIPTION </td>
			<td>CATEGORIE</td>
			<td>PRIX</td>
			<td>QUANTITE</td>
			<td>SELECTIONNER</td>
			<td>PHOTO </td>
		 </tr>
		 <c:forEach items="${produits }" var="p">
		 <tr>
		 	<td> ${p.idproduit}</td>
		 	<td> ${p.designation}</td>
		 	<td> ${p.description}</td>
		 	<td> ${p.categorie.nomcategorie}</td>
		 	<td> ${p.prix}</td>
		 	<td> ${p.quantite}</td>
		 	<td> ${p.selected}</td>
		 	<td><img alt="" src="photoprod?idprod=${p.idproduit}"> </td> 
		 	<td> <a href="suppprod?idprod=${p.idproduit}"> suppProd</a></td>
		 	<td> <a href="editprod?idprod=${p.idproduit}"> editProd</a></td> 
		 </tr>
	</c:forEach> 
	  
	</table>
</div>


