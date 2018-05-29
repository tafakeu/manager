<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" >
</head>

<div>
	${exception }
</div>

<div id=formCat class="cadre">
	<f:form modelAttribute="categories" action="saveCat" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID categories</td>
				<td> <f:input path="idcategorie" /> </td>
				<td> <f:errors path="idcategorie" cssClass="errors "> </f:errors> </td>
			</tr>
			<tr>
				<td>NOM Categories</td>
				<td><f:input path="nomcategorie"/></td>
				<td><f:errors path="nomcategorie" cssClass="errors "></f:errors></td> 
				
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<c:if test="${categories.idcategorie!=null }">
					<img alt="" src="photoCat?idCat=${categories.idcategorie}">
				</c:if>
				<td><input type="file" name="file"/></td>
				<td></td>
			</tr>
			<tr>
				<td><input type= "submit" name="save"></td>
			</tr>
		</table>
	</f:form>
</div>

<div id="" class="cadre">
	<table class="tab">
		<tr>
			<td> ID</td>
			<td>NOM CAT </td>
			<td>DESCRIPTION </td>
			<td>PHOTO </td>
		 </tr>
	  <c:forEach items="${categorie }" var="cat">
		 <tr>
		 	<td> ${cat.idcategorie}</td>
		 	<td> ${cat.nomcategorie}</td>
		 	<td> ${cat.description}</td>
		 	<td><img alt="" src="photoCat?idCat=${cat.idcategorie}"> </td> 
		 	<td> <a href="suppCat?idCat=${cat.idcategorie}"> suppCat</a></td>
		 	<td> <a href="editCat?idCat=${cat.idcategorie}"> editCat</a></td> 
		 </tr>
	</c:forEach> 
	</table>
</div>


