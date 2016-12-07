<div class="right col-md-3">
	<form id="login-form" name="login-form" action="guest" method="post" role="form"
		class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-3" for="username">Username:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="username"
					id="username" placeholder="Enter username..." required="required">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="username">Password:</label>
			<div class="col-sm-9">
				<input type="password" name="password" class="form-control"
					id="password" placeholder="Enter password..." required="required">
			</div>
		</div>
		<div class="form-group">
			<table>
				<tr>
					<td class="table-login"><label class="control-label label-pad" for="register">Not
							registered yet?</label> 
							<a href="guest?action=register">Register here</a>
					</td>
					<td class="table-login">
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default btn-login">Log
								in</button>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>