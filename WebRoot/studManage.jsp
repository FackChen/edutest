<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studManage.jsp' starting page</title>
    
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

  </head>
  
  <body>
  
    <table id="list"></table>
    
  	<!-- 工具条 -->
  	<div id="tb">
		<a id="btn_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
		<a id="btn_edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		<a id="btn_delete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>
	
    <!-- 编辑窗口 -->
	<div id="win" class="easyui-window" title="客户数据编辑" style="width:300px;height:250px;top:100px"   
        data-options="iconCls:'icon-save',modal:true,closed:true">   
	    <form id="editForm" method="post">
	    	<%--提供id隐藏域 --%>
	    	<input type="hidden" name="id">
		  	学生姓名：<input type="text" name="name" class="easyui-validatebox" data-options="required:true"/><br/>
		  	性别：
		  	<input type="radio" name="gender" value="男" style="margin-left:45px"/>男
		  	<input type="radio" name="gender" value="女" style="margin-left:45px"/>女
		  	<br/>
		  	班级:<input type="text" name="classes" class="easyui-validatebox" data-options="required:true" style="margin-left:39px"/><br/>
		  	学号:<input type="text" name="number" class="easyui-validatebox" data-options="required:true" style="margin-left:39px"/><br/>
		  	手机号：<input type="text" name="telephone" class="easyui-validatebox" data-options="required:true" style="margin-left:14px"/><br/>
		  	入学成绩：<input type="text" name="achievement" class="easyui-validatebox" data-options="required:true"/><br/>
	  	<a id="saveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="margin-top:20px">保存</a>
 	 </form> 
	</div>
	 
    <script type="text/javascript">
    
    	//列表
  		$(function(){
  			$("#list").datagrid({
  				url:"student/listByPage.action",
  				columns:[[
  					{
  						field:"id",
  						title:"",
  						width:100,
  						checkbox:true
  					},
  					{
  						field:"name",
  						title:"姓名",
  						width:200
  					},
  					{
  						field:"gender",
  						title:"性别",
  						width:200
  					},
  					{
  						field:"classes",
  						title:"班级",
  						width:200
  					},
  					{
  						field:"number",
  						title:"学号",
  						width:200
  					},
  					{
  						field:"telephone",
  						title:"手机号",
  						width:200
  					},
  					{
  						field:"achievement",
  						title:"入学成绩",
  						width:200
  					}
  				]],
  				pagination:true,
  				toolbar:"#tb"
	  		  });
			});
			
  			//打开编辑窗口
  			$("#btn_add").click(function(){
  				$("#editForm").form("clear");
  				$("#win").window("open");
  			});
  			
  			//保存数据
  			$("#saveBtn").click(function(){
  				$("#editForm").form("submit",{
  					url:"student/save.action",
  					onSubmit:function(){
  						return $("#editForm").form("validate");
  					},
  					success:function(data){
  						data = eval("("+data+")");
  						
  						if(data.success){
  							$("#win").window("close");
  							$("#list").datagrid("reload");
  							
  							$.messager.alert("提示","保存成功","info");
  						}else{
  							$.messager.alert("提示","保存失败："+data.msg,"error");
  						}
   					}
  				});
  				
  			});
  			
  			//修改数据
  			$("#editBtn").click(function(){
  				var rows = $("#list").datagrid("getSelections");
  				if(rows.length!=1){
  					$.messager.alert("提示","修改操作只能选择一行","warning");
  					return;
  				}
  				
  				$("#editForm").form("load","student/findById.action?id="+rows[0].id);
  				
  				$("#win").window("open");
  			});
  			
  			//删除
  			$("#btn_delete").click(function(){
  				var rows =$("#list").datagrid("getSelections");
  				if(rows.length==0){
  					$.messager.alert("提示","删除操作至少选择一行","warning");
  					return;
  				}
  				
  				$.messager.confirm("提示","确认删除数据吗?",function(value){
  					if(value){
  						var idStr = "";
  						$(rows).each(function(i){
  							idStr+=("id="+rows[i].id+"&");
  						});
  						idStr = idStr.substring(0,idStr.length-1);
						
  						$.post("student/delete.action",idStr,function(data){
  							if(data.success){
  	  							$("#list").datagrid("reload");
  	  							
  	  							$.messager.alert("提示","删除成功","info");
  	  						}else{
  	  							$.messager.alert("提示","删除失败："+data.msg,"error");
  	  						}
  						},"json");
  					}
  				});
  			});
		</script>
  </body>
</html>
