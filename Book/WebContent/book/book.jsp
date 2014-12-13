<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.List"
    import="java.util.Map"
    pageEncoding="UTF-8"%>
<!doctype html>
<html >
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;"/>
    <meta charset="utf-8"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
    <meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT"/>
    <title>最新上架编程书</title>
    <link rel="stylesheet" type="text/css" href="/Book/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/Book/css/index.css?v=201407300738">
    <script type="text/javascript" src="/Book/js/jquery.js"></script>
<style>
#loading{position:fixed;_position:absolute;top:50%;left:50%;width:128px;height:128px;overflow:hidden;background:url(css/loading.gif) no-repeat;
                    z-index:7; 
                    margin-left:-64px;
                    margin-top:-64px;
}  
</style>
</head>
<body>

  <div id="loading"></div> 
  <h1>新书推荐</h1>
<div  class="container">
<%
int cur_page = (Integer)request.getAttribute("cur_page");

List<Map<String, Object>> list = (List<Map<String, Object>>) request.getAttribute("list");

%>
<%  for(Map<String, Object> obj: list) {%>
	<div  class="box">
        <div class="imgbox"> <img src="<%=obj.get("pic")%>" /></div>
        <div>
             <h1><a href="<%=obj.get("detail_url")%>"><%=obj.get("title")%></a> </h1>
             
             <p><%=obj.get("detail")%></p>
         </div>
         <hr/>
    </div>
    <% } %>
    
    <% if(cur_page >1){ %>
    <a  class="myButton"  href="javascript:void(0)"     onclick="next_page(<%=(cur_page-1)%>)">上一页</a>
    <%}
    if(list.size()>=10) { %>
       <a  class="myButton"  href="javascript:void(0)"     onclick="next_page(<%=(cur_page+1)%>)">下一页</a>
    <%} %>

</div>

<script type="text/javascript">  
$("#loading").fadeOut()  

function next_page(page) { 
	  window.location.href="?cur_page=" + page;
}
</script>
</body>
</html>