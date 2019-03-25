<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link id="themeLink" rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<style type="text/css">
		li{
			list-style:none;
			margin-top:5px;
		}
	</style>
  </head>
  
  <body>
  
	<div class="easyui-layout" style="height:705px">
	
		<!-- 上部区域 -->
		<div data-options="region:'north',title:'试验-教务管理系统',split:true" style="height:100px">
			点击左侧的“学生管理”可打开学生名单页面。<br/>
			点击添加按钮可打开编辑页面，添加新的成员；勾选其中一行并点击修改按钮可对改行的数据进行编辑修正；删除按钮可删掉指定行。
		</div>
		
		<!-- 左侧区域 -->
	    <div data-options="region:'west',title:'管理',split:true" style="width:200px">
	    	<div class="easyui-accordion">
			    <div title="师生管理" style="overflow:auto;padding:10px;" data-options="selected:false">
			       <ul>
			       	 <li><a href="javascript:void(0)" pageUrl="studManage.jsp">学生管理</a></li>
			       	 <li><a href="javascript:void(0)" pageUrl="teachManage.jsp">教师管理</a></li>
			       </ul>			    
			    </div>
			    <div title="教务处" data-options="iconCls:'icon-reload'" style="padding:10px;">
					<li><a href="javascript:void(0)" pageUrl="">教务处</a></li>
			    </div>
			</div>
	    </div>
	    
	    <!-- 中间区域 -->
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
			<div id="tabs" class="easyui-tabs">
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		//打开标签页
    	$(function(){
    		$("a[pageUrl]").click(function(){
    			var pageUrl = $(this).attr("pageUrl");
    			var title = $(this).text();
    			if( $("#tabs").tabs("exists",title)  )  {
    				$("#tabs").tabs("select",title);				
    			}else{
    				$("#tabs").tabs("add",{
    					title:title,
    					closable:true,
    					content:"<iframe src='"+pageUrl+"' width='100%' height='100%' frameborder='0'><iframe>"
    				});				
    			}
    		});
    	});
    	
	</script>
  </body>
</html>
