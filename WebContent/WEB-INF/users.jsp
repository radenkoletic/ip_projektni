<jsp:useBean id="isLogedIn" type="net.etfbl.movies.bean.UserBean" scope="session" />
<div class="main">
	<div class="user-table">
		<div class="title-div">
			<p>Users</p>
		</div>
		<table class="table-admin">
			<tr class="user-row">
				<td class="td-header">#</td>
				<td class="td-header">Name</td>
				<td class="td-header">Surname</td>
				<td class="td-header">Username</td>
				<td class="td-header">Ucn</td>
				<td class="td-header">E-mail</td>
				<td class="td-header">User type</td>
				<td class="td-header">Actions</td>
			</tr>
			<% 
				for (int i = 0; i < isLogedIn.getAllUsers().size(); i++) {
			%>
			<tr class="user-row">
				<td class="td-content-number"><%=(i + 1)%>.</td>
				<td class="td-content-text"><%=isLogedIn.getAllUsers().get(i).getName()%></td>
				<td class="td-content-text"><%=isLogedIn.getAllUsers().get(i).getSurname()%></td>
				<td class="td-content-text"><%=isLogedIn.getAllUsers().get(i).getUsername()%></td>
				<td class="td-content-text"><%=isLogedIn.getAllUsers().get(i).getUcn()%></td>
				<td class="td-content-text"><%=isLogedIn.getAllUsers().get(i).getEmail()%></td>
				<td class="td-content-text"><select
					id="select<%=isLogedIn.getAllUsers().get(i).getId()%>"
					onchange="sendRequestActivate('users?action=activate&id=<%=isLogedIn.getAllUsers().get(i).getId()%>',
					<%=isLogedIn.getAllUsers().get(i).getId()%>);"
					class="select-type">
						<%
							for (int j = 0; j < isLogedIn.getAllUserTypes().size(); j++) {
						%>
						<option value="<%=j%>"
							<%if (isLogedIn.getAllUsers().get(i).getUserType().equals(isLogedIn.getAllUserTypes().get(j))) {%>
							selected="selected" <%}%>>
							<%=isLogedIn.getAllUserTypes().get(j)%>
						</option>
						<%
							}
						%>
				</select></td>
				<td class="td-actions"><a title="View"
					href="users?action=view&id=<%=isLogedIn.getAllUsers().get(i).getId()%>">
						<i class="fa fa-eye" aria-hidden="true"></i>
				</a> <a title="Delete"
					href="users?action=delete&id=<%=isLogedIn.getAllUsers().get(i).getId()%>">
						<i class="fa fa-trash" aria-hidden="true"></i>
				</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>