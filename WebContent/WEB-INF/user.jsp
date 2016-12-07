<<jsp:useBean id="isLogedIn" type="net.etfbl.movies.bean.UserBean" scope="session" />
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
								<input type="text" name="name" class="form-control" id="name"
									readonly="readonly"
									<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
									value="<%=isLogedIn.getAllUsers().get(i).getName()%>">
								<%
									}
									}
								%>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="surname">Surname:</label>
							<div class="col-sm-6">
								<input type="text" name="surname" class="form-control"
									id="surname" readonly="readonly"
									<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
									value="<%=isLogedIn.getAllUsers().get(i).getSurname()%>">
								<%
									}
									}
								%>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="ucn">Unique
								citizen number:</label>
							<div class="col-sm-6">
								<input type="text" name="ucn" class="form-control" id="ucn"
									readonly="readonly"
									<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
									value="<%=isLogedIn.getAllUsers().get(i).getUcn()%>">
								<%
									}
									}
								%>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="email">E-mail:</label>
							<div class="col-sm-6">
								<input type="text" name="email" class="form-control" id="email"
									readonly="readonly"
									<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
									value="<%=isLogedIn.getAllUsers().get(i).getEmail()%>">
								<%
									}
									}
								%>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="username-register">Username:</label>
							<div class="col-sm-6">
								<input type="text" name="username" class="form-control"
									id="username" readonly="readonly"
									<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
									value="<%=isLogedIn.getAllUsers().get(i).getUsername()%>">
								<%
									}
									}
								%>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="user-type">User type:</label>
							<div class="col-sm-6">
								<input type="text" name="user-type" class="form-control"
									id="user-type" readonly="readonly"
									<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
									value="<%=isLogedIn.getAllUsers().get(i).getUserType()%>">
								<%
									}
									}
								%>
							</div>
						</div>
					</td>
					<td class="image-register"><img id="img-prof"
						class="profile-picture"
						<%for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
				if (isLogedIn.getAllUsers().get(i).getId() == isLogedIn.getSelectedUserId()) {%>
						src="<%=isLogedIn.getAllUsers().get(i).getImagePath()%>"> <%
									}
									}
								%>
				</tr>
			</table>
		</form>
	</div>
</div>