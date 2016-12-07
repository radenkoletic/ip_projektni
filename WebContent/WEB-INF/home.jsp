<jsp:useBean id="isLogedIn" type="net.etfbl.movies.bean.UserBean" scope="session" />
<jsp:useBean id="movieBean" type="net.etfbl.movies.bean.MovieBean" scope="session" />
<div class="main">
	<div class="title-div-netflix">
		<%=isLogedIn.getNetflixFeed().get(0).getTitle()%>
	</div>
	<div class="netflix-rss">
		<div class="center-pag">
			<ul class="pagination">
				<li><a class="pag-item" href="#">&lt;&lt;</a></li>
				<li><a class="pag-item" href="#">1</a></li>
				<li><a class="pag-item" href="#">2</a></li>
				<li><a class="pag-item" href="#">3</a></li>
				<li><a class="pag-item" href="#">4</a></li>
				<li><a class="pag-item" href="#">5</a></li>
				<li><a class="pag-item" href="#">&gt;&gt;</a></li>
			</ul>
		</div>
		<table class="table">
			<%
				for (int i = 1; i < 21; i++) {
			%>
			<tr>
				<td class="netflix-td"></td>
				<td class="netflix-td"></td>
				<td class="netflix-td"><a class="netflix-title"
					href=" <%=isLogedIn.getNetflixFeed().get(i).getLink()%>"
					target="_blank"> <%=isLogedIn.getNetflixFeed().get(i).getTitle()%>
				</a></td>
			</tr>
			<tr>
				<td class="netflix-td netflix-number"><%=i%>.</td>
				<td class="netflix-td"><a
					href=" <%=isLogedIn.getNetflixFeed().get(i).getLink()%>"
					target="_blank"> <img class="netflix-image"
						src=" <%=isLogedIn.getNetflixFeed().get(i).getImage()%> " /></a></td>
				<td class="netflix-td"><%=isLogedIn.getNetflixFeed().get(i).getDescription()%>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<div class="center-pag">
			<ul class="pagination">
				<li><a class="pag-item" href="#">&lt;&lt;</a></li>
				<li><a class="pag-item" href="#">1</a></li>
				<li><a class="pag-item" href="#">2</a></li>
				<li><a class="pag-item" href="#">3</a></li>
				<li><a class="pag-item" href="#">4</a></li>
				<li><a class="pag-item" href="#">5</a></li>
				<li><a class="pag-item" href="#">&gt;&gt;</a></li>
			</ul>
		</div>
	</div>
	<div class="rest-service-div">
		<div class="title-div-netflix">Search IMDB</div>
		<div class="rest-service">
			<div>
				<form class="form-inline" action="home" method="get">
					<input type="text" placeholder="Search movies or actors..."
						name="search-imdb" class="form-control search-input"> <input
						type="submit" value="Search" class="btn btn-default">
				</form>
			</div>
			<p id="example" class="example">(Example: Search "Interstellar"
				will give You result like below)</p>
			<div>
				<table class="table">
					<%
						int sizeM = movieBean.getRestMovies().size();
						int sizeA = movieBean.getRestActors().size();
						if (sizeM != 0) {
					%>
					<tr>
						<td class="netflix-td"></td>
						<td class="netflix-td">
							<p class="netflix-title no-result">Movies</p>
						</td>
					</tr>
					<%
						for (int i = 0; i < sizeM; i++) {
					%>
					<tr>
						<td class="netflix-td netflix-number"><%=(i + 1)%>.</td>
						<td class="netflix-td"><a
							href="<%=movieBean.getRestMovies().get(i).getRestUrl()%>"
							target="_blank"> <img class="netflix-image"
								src="<%=movieBean.getRestMovies().get(i).getRestThumbnail()%>" />
						</a></td>
						<td class="netflix-td center-title"><a target="_blank"
							class="netflix-title"
							href="<%=movieBean.getRestMovies().get(i).getRestUrl()%>">
								<%=movieBean.getRestMovies().get(i).getName()%>
						</a></td>
					</tr>
					<%
						}
						}
						if (sizeA != 0) {
					%>
					<tr>
						<td class="netflix-td"></td>
						<td class="netflix-td">
							<p class="netflix-title no-result">Actors</p>
						</td>
					</tr>
					<%
						for (int i = 0; i < sizeA; i++) {
					%>
					<tr>
						<td class="netflix-td netflix-number"><%=(i + 1)%>.</td>
						<td class="netflix-td"><a
							href="<%=movieBean.getRestActors().get(i).getRestUrl()%>"
							target="_blank"> <img class="netflix-image"
								src="<%=movieBean.getRestActors().get(i).getRestThumbnail()%>" />
						</a></td>
						<td class="netflix-td center-title"><a target="_blank"
							class="netflix-title"
							href="<%=movieBean.getRestActors().get(i).getRestUrl()%>">
								<%=movieBean.getRestActors().get(i).getName()%>
						</a></td>
					</tr>
					<%
						}
						}
						if (sizeM == 0 && sizeA == 0) {
					%>
					<tr>
						<td class="netflix-td"></td>
						<td class="netflix-td">
							<p class="netflix-title no-result">No results...</p>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>
</div>