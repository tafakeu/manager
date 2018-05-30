<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
	<title>authtification </title>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
<form action="">
	<label for="login">login</label>
	<input type="text">
	<br>
	<label>password</label>
	<input type="password">
	<input type="button" name="send" value="envoyer">
</form>

<%-- 
<f:form  action="j_spring_security_check">
	<f:label path="">login</f:label>
	<f:input path=""/>
	<br />
	<f:label path="" >mot de passe</f:label>
	<f:password path=""/>
</f:form> --%>

</body>
</html>
