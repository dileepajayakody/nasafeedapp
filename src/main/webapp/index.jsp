<%@ page import="org.msc.cse.nasa.feeds.NasaFeeds" %>
<%@ page import="org.msc.cse.nasa.feed.result.NasaFeedResult" %>
<%@ page import="com.google.gson.Gson" %>
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
  
  <script type="text/javascript">
  	function showResult() {
  		var jsonText = docoument.getElementById('jsonString');
  		$('#json').val(JSON.stringify(JSON.parse(jsonText), null, 4));
  	}
  </script>
</head>

<body>
<h1>NASA Data Feeds</h1>
<form id="getfeeds" action="index.jsp" method="POST">
Search Query :  <input type="text" name="query" id="query"/>
<input type="submit" name="getfeeds" id="getfeeds" />
</form>

<% if (result != null) { %>
	<h3>Result Summary</h3>
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
			<td><%=result.getPages() %></td>
		</tr>
	</tbody>
	</table>
	
	<% Gson gson = new Gson(); %>
	<input type="hidden" name="jsonString" id="jsonString" value="<%=gson.toJson(result)%>"/>
	<a href="#" onclick="showResult()">See Full Result</a>
	<div id="fullresult" style="display:none">
		 <textarea id="json"></textarea>
    	
	</div>
<%} else {%>

<%}%>
</body>
	<script src="json2.js"></script>
    <script src="jquery.min.js"></script>
</html>
