<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>page1</title>
  
  <!-- Custom CSS -->
  <style>
  
  </style>
</head>
<body>
	
	
	<!-- Sample Card -->
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Sample Word</h5>
        <p class="card-text">Definition: A brief description of the word goes here.</p>
        <p class="card-text">Example: An example sentence using the word.</p>
        
        <div>
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
			<p th:text=${response}></p>
		</c:if>

	</div>
	
      </div>
    </div>
    
    <!-- End Sample Card -->
    
</body>
</html>