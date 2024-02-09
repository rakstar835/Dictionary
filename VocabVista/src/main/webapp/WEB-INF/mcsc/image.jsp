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
<title>DALL-E</title>
</head>
<body>
	<div class="container">
			<h1>
				DALL-E API at<br />Exam Live
			</h1>
			<h2>Describe image</h2>

			<form:form modelAttribute="examEvent" method="POST" id="sendmsg" class="mt-5">
				<div class="form-group">
					<form:input type="text" path="prompt" value="" class="form-control" />
				</div>
				<div class="row">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form:form>

			<br>
			<c:if test="${imageUri != null}">
				<h2>ChatGPT responded with:</h2>
				<p>${imageUri}</p>
				<img alt="" src="${imageUri}" alt="Picture drawn by DALL-E" />
			</c:if>
		</div>
</body>
</html>