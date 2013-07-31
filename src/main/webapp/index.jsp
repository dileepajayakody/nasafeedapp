<%@ page import="com.example.Main" %>
<%@ page import="org.msc.cse.nasa.feeds.NasaFeeds" %>
<!doctype html>

<html>
<head>
  <title>Hello</title>
</head>

<body>
<h1>SWA Lab Project</h1>
<%=Main.test() %>
<%=NasaFeeds.getFeeds("saturn") %>
</body>
</html>
