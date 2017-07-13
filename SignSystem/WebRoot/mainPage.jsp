<%@ page language="java"
	import="java.util.*,java.text.*,java.sql.*,java.util.Date,
	com.zhongxing.dao.impl.*,com.zhongxing.entity.*,com.zhongxing.server.*,com.zhongxing.server.impl.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mianPage.jsp' starting page</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<%
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
Calendar calendar = Calendar.getInstance();
String time=sdf.format(calendar.getTime());
int month=calendar.get(Calendar.MONTH)+1;
Integer id=new Integer(session.getAttribute("id").toString());
User user=new UserDaoImpl().select(id).get(0);
String name=user.getUname();
String job=user.getUtype();
%>
<style type="text/css">
body {
	overflow: hidden;
}

ul,li {
	list-style: none;
	position: relative;
}

ul {
	margin: 0;
	padding: 0;
}

li {
	float: left;
}
/*a标签*/
.win a {
	text-decoration: none;
}

.win a:hover {
	color: #0be;
}

.win {
	position: absolute;
	width: 100%;
	height: 100%;
	min-width: 1200px;
	min-height: 980px;
	top: 0;
	left: 0;
	background-image: url("./img/background1.jpg");
	background-size: 100% 90%;
	background-repeat: no-repeat;
}

/* 导航栏*/
.headline {
	width: 100%;
	height: 100px;
	background: rgba(255, 255, 255, .8);
}

.usermsg,.useroperation {
	position: relative;
	display: list-item;
}

.usermsg {
	width: 300px;
	height: 100px;
	float: left;
}

.useroperation {
	line-height: 100px;
	text-align: center;
	float: right;
	margin-right: 250px;
}

.useroperation a {
	color: #000;
	margin: 0 30px;
}

.headimg {
	width: 100px;
	height: 100px;
	overflow: hidden;
	background-image: url("./img/headimg1.jpg");
	background-size: 100%;
	background-repeat: no-repeat;
	border-radius: 50%;
}

.bt_headimg {
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0);
	border-width: 0;
}

.username {
	margin: 40px 0 10px 10px;
}

.userid {
	margin-left: 10px;
}
/* 内容部分 */
.content {
	width: 1200px;
	height: 100%;
	margin: auto;
}

.content>li {
	height: 100%;
}

.content1 {
	width: 35px;
}

.t1 tr>th,.t1 tr>td {
	width: 100px;
	height: 40px;
	text-align: center;
}

.table th:hover,td:hover {
	opacity: .8;
}

/* 标签 */
.label {
	width: 100%;
	height: 120px;
}

.label1,.label2,.label3 {
	width: 35px;
	height: 100%;
	border-radius: 20px 0 0 60px;
	border: 0;
	writing-mode: vertical-lr;
	line-height: 35px;
	text-align: center;
}

.label1 {
	background: rgba(0, 186, 238, .4);
}

.label1:hover {
	background: rgba(0, 186, 238, .8);
}

.label2 {
	background: rgba(255, 102, 0, .4);
}

.label2:hover {
	background: rgba(255, 102, 0, .8);
}
.label3 {
	background: rgba(100, 75, 75, .4);
	display: <%=job.equals("manager")?"block;":"none;"%>
}
.label3:hover {
	background: rgba(100, 75, 75, .8);
}

.content2 {
	width: 90%;
}

.content2>div {
	width: 100%;
	height: 100%;
	position: absolute;
}

.content2-1 {
	background: rgba(0, 186, 238, .4);
	display: block;
}

.content-font1 {
	font-size: 20px;
	margin: 50px 0;
	letter-spacing: 12px;
	text-align: center;
}

.content-font2 {
	font-size: 15px;
	letter-spacing: 10px;
}

#sign {
	display: block;
	width: 150px;
	height: 45px;
	line-height: 45px;
	text-align: center;
	margin: auto;
	background: #0ce;
	border-radius: 4px;
	color: #000;
}

#sign:hover {
	background: #0ae;
}

.content2-2 {
	background: rgba(255, 102, 0, .4);
	display: none;
}

.content2-21 {
	width: 20%;
	height: 100%;
	float: left;
}
.content2-21>*{
	margin:30px auto;
}
.content2-21>*>*{
	margin:9px;
}
.content2-22 {
	width: 80%;
	height: 100%;
	float:left;
}
.t2 tr>th{
	width: 160px;
    height: 40px;
}
.t2 tr>td{
	width: 160px;
    height: 40px;
    text-align:center;
}
.t3 tr>th{
	width: 208px;
    height: 40px;
}

.content2-3 {
	background: rgba(100, 75, 75, .4);
	display: none;
}

.outline{
	position:absolute;
	height:655px;
	overflow:auto;
}
.inline tr>td{
	width: 208px;
    height: 40px;
    text-align:center;
}
.go_page{
	position:absolute;
	top:500px;
	left:500px;
	display:none;
}
.go_page *{
	margin:10px;
}
.pageNum{
	width:45px;
}
</style>

</head>

<body>
	<div class="win">
		<ul class="headline">
			<div style="width:1200px;margin:auto;">
				<div class="usermsg">
					<li class="headimg"><input type="button" class="bt_headimg"></li>
					<li>
						<ul class='username'><%=name%></ul>
						<ul class='userid'><%=id%></ul>
					</li>
				</div>
				<div class="useroperation">
					<a href="javascript:;">修改密码</a> <a href="javascript:;">异常申述</a> <a
						href="javascript:;">退出登录</a> <a href="javascript:;">更多</a>
				</div>
			</div>
		</ul>
		<ul class="content">
			<li class="content1">
				<ul class="label">
					<div class="label1">签到</div>
				</ul>
				<ul class="label">
					<div class="label2">查询</div>
				</ul>
				<ul class="label">
					<div class="label3">管理</div>
				</ul>
			</li>
			<li class="content2">
				<div class=content2-1>
					<div class="content-font1"><%=month%>月份考勤
					</div>
					<div class="table-M">
						<%
							ShowOnMonth som=new ShowOnMonthImpl();
							List<Sign> list=som.showTable(id);
							
						%>
					
						<%-- <%
							int[] days = Check.checkM(id);
										calendar.set(Calendar.DAY_OF_MONTH, 1);
										int row = calendar.getMaximum(Calendar.WEEK_OF_MONTH);
										int col = 7;
										int count = 1;
										boolean flag = false, flag1 = false;
										out.print("<table class='t1' border=1px cellspacing='0' style='margin:auto;'><tr><th>星期一</th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th><th>星期六</th><th>星期日</th></tr>");
										for (int i = 1; i < row + 1; i++) {
											out.print("<tr>");
											for (int j = 1; j < col + 1; j++) {
												if (flag && count <= calendar.getMaximum(Calendar.DAY_OF_MONTH)) {
													for (int d : days) {

														if (d == count) {
															flag1 = true;
															break;
														} else
															flag1 = false;
													}
													if (flag1)
														out.print("<td style='background:rgba(4,255,200,0.8);'>"
																+ count + "</td>");
													else
														out.print("<td style='background:rgba(200,30,90,0.8);'>"
																+ count + "</td>");
													count++;
												} else
													out.print("<td></td>");
												if (j > 4)
													flag = true;
											}
											out.print("</tr>");
										}
										out.print("</table>");
						%> --%>
					</div>
					<div class="content-font1">亲！ 你今天签到了吗？</div>
					<a id="sign" href="javascript:;" class="content-font2">签 到</a>
				</div>
				<div class=content2-2>

					<div class="content2-21">
					<div>
						<div class="content-font2">查询时间：</div><br>
						开始时间：<br><input type="date" name="start" value="<%=time%>"><br>
						结束时间：<br><input type="date" name="end" value="<%=time%>"><br>
					</div>
						<div>
							<div class="content-font2">筛选：</div>
							 <input type="radio" name="signstatus" value=0>查询签到<br>
							 <input type="radio" name="signstatus" value=1>查询迟到<br>
							 <input type="radio" name="signstatus" value=2>查询早退<br>
							 <input type="radio" name="signstatus" value=3>查询缺席<br>
							 <input type="radio" name="signstatus" value=4>查询所有<br>
							 <input type="button" class="bt_check" value="查询">
						</div>
					</div>
					<div class="content2-22">
						<div class="aaa">
						<!--  编号  日期  上班签到  下班签到  签到情况  -->
							<ul><table class='t2' border=1><tr><th>员工编号</th><th>日期</th><th>上班签到</th><th>下班签到</th><th>签到情况</th></tr></table></table></ul>
							<ul class="outline">
								<table class='t2' border=1 id="checkInOrder" class="inline"></table>
							</ul>
						</div>
					</div>
				</div>
				<div class=content2-3>
					<div class="content2-21">
						<div>
							<div class="content-font2">查询时间：</div><br>
						开始时间：<br><input type="date" name="start1" value="<%=time%>"><br>
						结束时间：<br><input type="date" name="end1" value="<%=time%>"><br>
						</div>
						<div>
							<div class="content-font2">筛选条件：</div>
							<input type="text" name="select_name" placeholder="请输入需要查询的姓名"><br>
							<input type="text" name="select_id" placeholder="请输入需要查询的id"><br>
							<input type="radio" name="type1" value=1>查询已签到 <br> <input
								type="radio" name="type1" value=0>查询未签到<br> <input
								type="radio" name="type1" value=3>查询所有<br> <input
								type="button" class="bt_check1" value="查询"><br>
						</div>
					</div>
					<div class="content2-22">
						<div class="outline">
							<table border=1 class="t3"><tr><th>员工姓名</th><th>员工编号</th><th>日期</th><th>考勤</th></tr></table>
							<table border=1 id="checkInOrder1" class="inline"></table>
						</div>
						<div class="go_page">
							<input type="button" class="pageUp" value="上一页">
							<input type="button" class="pageDown" value="下一页">
							<input type="text" class="pageNum" value="1" >
							<input type="button" class="go" value="跳转">
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
</body>
<script type="text/javascript">
	function classes(cn) {
		c = document.getElementsByClassName(cn);
		if (c.length == 1)
			return c[0];
		else
			return c;
	}
	function id(id) {
		return document.getElementById(id);
	}
	function tag(tag) {
		t = document.getElementsByTagName(tag);
		if (t.length == 1)
			return t[0];
		else
			return t;
	}
	function name(name) {
		n = document.getElementsByName(name);
		if (n.length == 1)
			return n[0];
		else
			return n;
	}
	classes('label1').onclick = function() {
		classes('content2-1').style = "display:block";
		classes('content2-2').style = "display:none";
		classes('content2-3').style = "display:none";
	};
	classes('label2').onclick = function() {
		classes('content2-1').style = "display:none";
		classes('content2-2').style = "display:block";
		classes('content2-3').style = "display:none";
	};
	classes('label3').onclick = function() {
		classes('content2-1').style = "display:none";
		classes('content2-2').style = "display:none";
		classes('content2-3').style = "display:block";
	};
	var signstatus=0;
	for(var i=0;i<name('type').length;i++){
		name('signstatus')[i].onclick=function(event){
			signstatus=event.target.value;
		};
	}
	var type1=3;
	for(var i=0;i<name('type1').length;i++){
		name('type1')[i].onclick=function(event){
			type1=event.target.value;
		}
	}
	var xhr=new XMLHttpRequest();
	classes("bt_check").onclick=function(event){
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				id("checkInOrder").innerHTML=xhr.responseText;
				
			}
		};
		console.log(name('start'));
		var str="./ShowPersonalServlet?id="+<%=id %>+"&signstatus="+signstatus+"&start="+name('start').value+"&end="+name('end').value;
		xhr.open("post",str,true);
		xhr.send();
	};
	var xhr1=new XMLHttpRequest();
	id("sign").onclick=function(){
		xhr1.onreadystatechange=function(){
			if(xhr1.readyState==4&&xhr1.status==200){
				
				alert(xhr1.responseText);
				location.href="./mainPage.jsp";
			}
		};
		var str="./sign.jsp?id="+<%=id %>;
		xhr1.open("post",str,true);
		xhr1.send();
	}
	/* var xhr2=new XMLHttpRequest();
	classes("bt_check1").onclick=function(event){
		classes('go_page').style="display:block;";
		xhr2.onreadystatechange=function(){
			if(xhr2.readyState==4&&xhr2.status==200){
				id("checkInOrder1").innerHTML=xhr2.responseText;
			}
		};
		var str="./refurbish1.jsp?id="+name('select_id').value+"&name="+name('select_name').value+"&type="+type1+"&start="+name('start1').value+"&end="+name('end1').value;
		xhr2.open("post",str,true);
		xhr2.send();
	}; */
	var xhr3=new XMLHttpRequest();
	function go_page(i,n,t,s,e,p){
		xhr3.onreadystatechange=function(){
			if(xhr3.readyState==4&&xhr3.status==200){
				if(xhr3.responseText.indexOf("error",0)<0){
					id("checkInOrder1").innerHTML=xhr3.responseText;
				}else {
					alert("输入的页码有误，请重新输入！");
					classes('pageNum').value=1;
				}
			}
		};
		//var str="./refurbish1.jsp?id="+name('select_id').value+"&name="+name('select_name').value+"&type="+type1+"&start="+name('start1').value+"&end="+name('end1').value+"&pageNum="+classes('pageNum').value;
		var str="./refurbish1.jsp?id="+i+"&name="+n+"&type="+t+"&start="+s+"&end="+e+"&pageNum="+p;
		xhr3.open("post",str,true);
		xhr3.send();
		/* var str="./refurbish1.jsp";
		xhr3.open("post",str,true);
		xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
		xhr3.send("id="+i+"&name="+n+"&type="+t+"&start="+s+"&end="+e+"&pageNum="+p); */
	}
	classes('go').onclick=function(){
		go_page(name('select_id').value,name('select_name').value,type1,name('start1').value,name('end1').value,classes('pageNum').value);
	};
	classes('pageUp').onclick=function(){
		go_page(name('select_id').value,name('select_name').value,type1,name('start1').value,name('end1').value,classes('pageNum').value-1);
		classes('pageNum').value=classes('pageNum').value-1;
	};
	classes('pageDown').onclick=function(){
		go_page(name('select_id').value,name('select_name').value,type1,name('start1').value,name('end1').value,parseInt(classes('pageNum').value)+1);
		classes('pageNum').value=parseInt(classes('pageNum').value)+1;
	};
	classes("bt_check1").onclick=function(event){
		go_page(name('select_id').value,name('select_name').value,type1,name('start1').value,name('end1').value,1);
		classes('go_page').style="display:block;";
	};
</script>
</html>
