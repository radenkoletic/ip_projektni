<jsp:useBean id="genreBean" type="net.etfbl.movies.bean.GenreBean" scope="session" />
<div class="main">
	<table class="table">
		<tr>
			<td class="genre-td-1">
				<div class="genre-add">
					<form id="genre-form" name="genre-form" action="genres"
						method="post" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-3" for="name">Name:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="Enter genre name..." required="required">
							</div>
						</div>
						<div class="col-sm-offset-9">
							<button type="submit" class="btn btn-default btn-login">Add
								genre</button>
						</div>
					</form>
				</div>
			</td>
			<td class="genre-td-2">
				<div class="genre-table">
					<table class="table-admin">
						<tr class="user-row">
							<td class="td-header">#</td>
							<td class="td-header">Name</td>
							<td class="td-header">Actions</td>
						</tr>
						<%
							for (int i = 0; i < genreBean.getAllGenres().size(); i++) {
						%>
						<tr class="user-row">
							<td class="td-content-number-genre"><%=(i + 1)%>.</td>
							<td class="td-content-text"><%=genreBean.getAllGenres().get(i).getName()%></td>
							<td class="td-actions"><a title="View"
								href="users?action=view&id=<%=genreBean.getAllGenres().get(i).getId()%>">
									<i class="fa fa-eye" aria-hidden="true"></i>
							</a> <a title="Activate/Deactivate" href=""
								onclick="sendRequestActivate('users?action=activate&id=<%=genreBean.getAllGenres().get(i).getId()%>');">
									<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
							</a> <a title="Delete"
								href="genres?action=delete&id=<%=genreBean.getAllGenres().get(i).getId()%>">
									<i class="fa fa-trash" aria-hidden="true"></i>
							</a></td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</td>
		</tr>
	</table>
</div>