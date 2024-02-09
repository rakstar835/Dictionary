<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>dictionary</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
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