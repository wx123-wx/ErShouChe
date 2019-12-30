<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>二手车后台管理系统-所有用户列表</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->

<!--aside nav-->
<!--aside nav-->



       <input type="text" class="textbox textbox_225" placeholder="输入产品关键词或产品货号..."/>
       <input type="button" value="查询" class="group_btn"/>
      </section>
      <table class="table">
       <tr>
      
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话号码</th>
        <th>电子邮件</th>
        
       </tr>
       <%  List<User>  users=(List<User>)request.getAttribute("users");
       		for(User c:users){
       %>
	       <tr>
	        <td class="center"><%=c.getXingming() %> </td>
	        <td class="center"><%=c.getXingbie() %></td>
	        <td class="center"><%=c.getNianling() %></td>
	        <td class="center"><%=c.getDianhuahaoma() %></td>
	        <td class="center"><%=c.getDianziyoujian() %></td>
	  
	        <td class="center">
	         <a href="http://www.deathghost.cn" title="预览" class="link_icon" target="_blank">&#118;</a>
	         <a href="product_detail.html" title="编辑" class="link_icon">&#101;</a>
	         <a href="javascript:if(window.confirm('您确认要删除这条数据吗?')){location.href='CarServlet?method=delete&carid=<%=c.getCarid() %>'}" title="删除" class="link_icon">&#100;</a>
	        </td>
	       </tr>
       <%} %>
    
      </table>
      
 </div>
</section>
<%  if(request.getAttribute("deleteResult")!=null){
	if(request.getAttribute("deleteResult").toString().equals("true")){
		%>
		<script type="text/javascript">
		alert("删除成功!");
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
		alert("删除失败!");
		</script>
		<%
	}
} %>
</body>
</html>