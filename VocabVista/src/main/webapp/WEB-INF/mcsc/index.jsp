<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>ChatGPT</title>
</head>
<body>
	<div class="main container">
		<h2> ChatGPT API at Exam Live </h2>
		<h3>Send message to ChatGPT</h3>
		
		<form:form modelAttribute="dto" method="POST" id="sendmsg" class="mt-5">
			<div class="form-group">
				<form:textarea rows="4" cols="50" path="prompt" value="${prompt}" class="form-control" />
			</div>
			<div class="row">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
		
		<br>
		<c:if test="${response != null}">
			<h2>ChatGPT responded with:</h2>
			<p>${response}</p>
		</c:if>

	</div>
</body>
</html>