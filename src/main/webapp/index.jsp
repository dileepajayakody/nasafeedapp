<%@ page import="org.msc.cse.nasa.feeds.NasaFeeds" %>
<%
String query = request.getParameter("query");
String result = "";
if (query != null || !query.equals("")) {
	result = NasaFeeds.getFeeds("saturn");
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
<%=result %>
</body>
</html>
