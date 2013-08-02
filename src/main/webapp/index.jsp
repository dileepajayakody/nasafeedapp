<%@ page import="org.msc.cse.nasa.feeds.NasaFeeds" %>
<%@ page import="org.msc.cse.nasa.feeds.NasaFeedResult" %>
<%
String query = request.getParameter("query");
NasaFeedResult result = null;
if (query != null && !query.equals("")) {
	result = NasaFeeds.getFeeds(query);
	query = "";
}
%>
<!doctype html>

<html>
<head>
  <title>NASA Data Feeds</title>
</head>

<body>
<h1>NASA Data Feeds</h1>
<form id="getfeeds" action="index.jsp" method="POST">
Search Query :  <input type="text" name="query" id="query"/>
<input type="submit" name="getfeeds" id="getfeeds" />
</form>

<h3>Result Summary</h3>
<% if (result != null) { %>
	<table>
	<tbody>
		<tr>
			<td>Status : </td> 
			<td><%=result.getStatus() %></td>
		</tr>
		<tr>
			<td>Count : </td>
			<td><%=result.getCount() %></td>
		</tr>
		<tr>
			<td>Count Total : </td>
			<td><%=result.getCount_total() %></td>
		</tr>
		<tr>
			<td>Pages : </td>
			<td><%=result.setPages() %></td>
		</tr>
	</tbody>
	</table>
	
	<a href="">See Full Result</a>
<%} else {%>

<%}%>
</body>
</html>
