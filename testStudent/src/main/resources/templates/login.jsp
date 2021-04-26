
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Log</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>

	<div class="container">

		<form th:action="@{/login}" th:object="${userformLogin}"
			method="post" style="max-width: 600px; margin: 0 auto;">
			<div class="m-3">
				<div class="form-group row">
					<label class="col-4 col-form-label">E-mail: </label>
					<div class="col-8">
						<input type="email" th:field="*{email}" class="form-control"
							required />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-4 col-form-label">Password: </label>
					<div class="col-8">
						<input type="password" th:field="*{password}" class="form-control"
							required minlength="6" maxlength="150" />
					</div>
				</div>

				<div>
					<button type="submit" class="btn btn-primary">Sign Up</button>
				</div>
			</div>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>