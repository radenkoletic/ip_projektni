<%@page import="net.etfbl.movies.bean.UserBean"%>
<jsp:useBean id="isLogedIn" type="net.etfbl.movies.bean.UserBean" scope="session" />
<div class="main">
	<div class="center-form">
		<form id="register-form" name="register-form" action="guest"
			enctype="multipart/form-data" method="post" class="form-horizontal">
			<table class="table">
				<tr>
					<td class="content-register">
						<div class="form-group">
							<label class="control-label col-sm-4" for="name">Name:</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="Enter name..." required="required"
									<%if (isLogedIn.isLogedIn()) {%>
									value="<%=isLogedIn.getUser().getName()%>" <%}%>>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="surname">Surname:</label>
							<div class="col-sm-6">
								<input type="text" name="surname" class="form-control"
									id="surname" placeholder="Enter surname..." required="required"
									<%if (isLogedIn.isLogedIn()) {%>
									value="<%=isLogedIn.getUser().getSurname()%>" <%}%>>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="ucn">Unique
								citizen number:</label>
							<div class="col-sm-6">
								<input type="text" name="ucn" class="form-control" id="ucn"
									pattern="[0-9]{13}"
									placeholder="Enter unique citizen number..."
									required="required" <%if (isLogedIn.isLogedIn()) {%>
									value="<%=isLogedIn.getUser().getUcn()%>" readonly="readonly"
									<%}%>>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="email">E-mail:</label>
							<div class="col-sm-6">
								<input type="email" name="email" class="form-control" id="email"
									placeholder="Enter e-mail..." required="required"
									<%if (isLogedIn.isLogedIn()) {%>
									value="<%=isLogedIn.getUser().getEmail()%>" <%}%>>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="username-register">Username:</label>
							<div class="col-sm-6">
								<input type="text" name="username-register" class="form-control"
									id="username-register" placeholder="Enter username..."
									required="required" <%if (isLogedIn.isLogedIn()) {%>
									value="<%=isLogedIn.getUser().getUsername()%>"
									readonly="readonly" <%}%>>
							</div>
						</div> <%
								if (isLogedIn.isLogedIn()) {
							%>
						<div class="form-group">
							<label class="control-label col-sm-4" for="password-register-old">
								Old password: </label>
							<div class="col-sm-6">
								<input type="password" name="password-register-old"
									class="form-control" id="password-register-old"
									pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{15,25}$"
									placeholder="Enter password...">
							</div>
						</div> <%
								}
							%>
						<div class="form-group">
							<label class="control-label col-sm-4" for="password-register">
								<%
										if (isLogedIn.isLogedIn()) {
									%> New password: <%
										} else {
									%> Password: <%
										}
									%>
							</label>
							<div class="col-sm-6">
								<input type="password" name="password-register"
									class="form-control" id="password-register"
									pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{15,25}$"
									placeholder="Enter password..." required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="password-conf">
								<%
										if (isLogedIn.isLogedIn()) {
									%> Confirm new password: <%
										} else {
									%> Confirm password: <%
										}
									%>
							</label>
							<div class="col-sm-6">
								<input type="password" name="password-conf" class="form-control"
									id="password-conf" placeholder="Confirm password..."
									pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{15,25}$"
									required="required">
							</div>
						</div>
						<div class="col-sm-offset-8">
							<button type="submit" class="btn btn-default btn-login">Save</button>
						</div>
					</td>
					<td class="image-register"><img id="img-prof"
						class="profile-picture" <%if (isLogedIn.isLogedIn()) {%>
						src=" <%=isLogedIn.getUser().getImagePath()%>" /> <%
 	} else {
 %> src="resources/images/users/no-face.png"/> <%
 	}
 %> <input class="image-button" type="file" name="dataFile"
						onchange="readURL(this);" id="fileChooser" accept="image/*" />
				</tr>
			</table>
		</form>
	</div>
</div>