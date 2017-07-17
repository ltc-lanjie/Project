<%@ page language="java"
	import="java.util.*,java.text.*,java.sql.*,java.util.Date,com.zhongxing.dao.*,
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

.label1,.label2,.label3,.label4 {
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
	background: rgba(193, 174, 134, .4);
}

.label2:hover {
	background: rgba(193, 174, 134, .8);
}

.label3 {
	background: rgba(255, 102, 0, .4);
	display: <%=job.equals("manager")?"block;":"none;"%>
}

.label3:hover {
	background: rgba(255, 102, 0, .8);
}
.label4{
	background: rgba(100, 75, 75, .4);
	display: <%=job.equals("manager")?"block;":"none;"%>
}
.label4:hover{
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

.sign_btns{
	width:400px;
	margin:auto;
	position:relative;
}
#signIn,#signOff {
	display: block;
	width: 150px;
	height: 45px;
	line-height: 45px;
	text-align: center;
	border-radius: 4px;
	margin:20px;
	float: left;
}
#signIn{
	border:1px solid #0ce;
	background: #0ce;
	color: #000;
}
#signOff{
	color:#fff;
	border:1px solid #fff;
}
#signIn:hover {
	border:1px solid #0ae;
	background: #0ae;
}

.content2-2 {
	background: rgba(193, 174, 134, .4);
	display: none;
}

.content2-21 {
	width: 20%;
	height: 100%;
	float: left;
}

.content2-21>* {
	margin: 30px auto;
}

.content2-21>*>* {
	margin: 9px;
}

.content2-22 {
	width: 80%;
	height: 100%;
	float: left;
}

.t2 tr>th {
	width: 160px;
	height: 40px;
}

.t2 tr>td {
	width: 160px;
	height: 40px;
	text-align: center;
}

.t3 tr>th {
	width: 130px;
	height: 40px;
}

.t3 tr>td {
	width: 130px;
	height: 40px;
	text-align: center;
}

.content2-3 {
	background: rgba(255, 102, 0, .4);
	display: none;
}

.outline {
	position: absolute;
	height: 655px;
	overflow: auto;
}

.inline tr>td {
	width: 208px;
	height: 40px;
	text-align: center;
}

.go_page {
	position: absolute;
	top: 500px;
	left: 500px;
	display: none;
}

.go_page * {
	margin: 10px;
}

.pageNum {
	width: 45px;
}
.content2-4 {
	background: rgba(100, 75, 75, .4);
	display: none;
}


.showcolor {
	float: left;
	width: 170px;
}

.showcolor ul {
	margin: 10px auto;
	line-height: 25px;
	width: 130px;
	height: 25px;
}

.showcolor1 {
	background: green;
	width: 50px;
	height: 25px;
}

.showcolor2 {
	background: purple;
	width: 50px;
	height: 25px;
}

.showcolor3 {
	background: orange;
	width: 50px;
	height: 25px;
}

.showcolor4 {
	background: blue;
	width: 50px;
	height: 25px;
}

.showcolor5 {
	background: red;
	width: 50px;
	height: 25px;
}

.showcolor6 {
	background: black;
	width: 50px;
	height: 25px;
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
					<div class="label2">查询个人</div>
				</ul>
				<ul class="label">
					<div class="label3">查询所有</div>
				</ul>
				<ul class="label">
					<div class="label4">管理</div>
				</ul>
			</li>
			<li class="content2">
				<div class=content2-1>
					<div class="content-font1"><%=month%>月份考勤
					</div>
					<div class="showcolor">
						<ul>
							<li class="showcolor1"></li>
							<li>签到</li>
						</ul>
						<ul>
							<li class="showcolor2"></li>
							<li>迟到</li>
						</ul>
						<ul>
							<li class="showcolor3"></li>
							<li>早退</li>
						</ul>
						<ul>
							<li class="showcolor4"></li>
							<li>缺席</li>
						</ul>
						<ul>
							<li class="showcolor5"></li>
							<li>请假</li>
						</ul>
						<ul>
							<li class="showcolor6"></li>
							<li>迟到且早退</li>
						</ul>
					</div>
					<div class="table-M">
						<%
							ShowOnMonth som = new ShowOnMonthImpl();
							List<Sign> list = som.showTable(id);
							calendar.set(Calendar.DAY_OF_MONTH, 1);
							int row = calendar.getMaximum(Calendar.WEEK_OF_MONTH);
							int col = 7;
							int count = 1;
							boolean flag = false, flag1 = false;
							out.print("<table class='t1' border=1px cellspacing='0' ><tr><th>星期一</th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th><th>星期六</th><th>星期日</th></tr>");
							for (int i = 1; i < row + 1; i++) {
								out.print("<tr>");
								for (int j = 1; j < col + 1; j++) {
									if (flag
											&& count <= calendar
													.getMaximum(Calendar.DAY_OF_MONTH)) {
										calendar.set(Calendar.DAY_OF_MONTH, count);
										calendar.getTime();
										ShowPersonal sp = new ShowPersonalImpl();
										list = sp.showTabel(id, calendar.getTime(),
												calendar.getTime());
										String output = "";
										if (list.size() > 0) {
											switch (list.get(0).getSignstatus()) {
											case 0:
												output = "background:green";
												break;
											case 1:
												output = "background:purple";
												break;
											case 2:
												output = "background:orange";
												break;
											case 3:
												output = "background:blue";
												break;
											case 4:
												output = "background:red";
												break;
											case 5:
												output = "background:black";
												break;
											}
										}
										out.print(String.format(
												"<td style='%s;'>%d</td>", output,
												count));
										/* for (int d : days) {

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
													+ count + "</td>");*/
										count++;
									} else
										out.print("<td></td>");
									if (j > 4)
										flag = true;
								}
								out.print("</tr>");
							}
							out.print("</table>");
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
					<div class="sign_btns">
					<a id="signIn" href="javascript:;" class="content-font2">上班</a>
					<a id="signOff" href="javascript:;" class="content-font2">下班</a>
					</div>
				</div>
				<div class=content2-2>

					<div class="content2-21">
						<div>
							<div class="content-font2">查询时间：</div>
							<br> 开始时间：<br> <input type="date" class="start"
								value="<%=time%>"><br> 结束时间：<br> <input
								type="date" class="end" value="<%=time%>"><br>
						</div>
						<div>
							<div class="content-font2">筛选：</div>
							<input type="radio" class="signstatus" name="signstatus" value=0>查询签到<br>
							<input type="radio" class="signstatus" name="signstatus" value=1>查询迟到<br>
							<input type="radio" class="signstatus" name="signstatus" value=2>查询早退<br>
							<input type="radio" class="signstatus" name="signstatus" value=3>查询请假<br>
							<input type="radio" class="signstatus" name="signstatus" value=4>查询缺席<br>
							<input type="radio" class="signstatus" name="signstatus" value=4>查询迟到并且早退<br>
							<input type="radio" class="signstatus" name="signstatus" value=6>查询所有<br>
							<input type="button" class="bt_check" value="查询">
						</div>
					</div>
					<div class="content2-22">
						<div class="aaa">
							<!--  编号  日期  上班签到  下班签到  签到情况  -->
							<ul>
								<table class='t2' border=1>
									<tr>
										<th>员工编号</th>
										<th>日期</th>
										<th>上班签到</th>
										<th>下班签到</th>
										<th>签到情况</th>
									</tr>
								</table>
								</table>
							</ul>
							<ul class="outline">
								<table class='t2' border=1 id="checkInOrder" class="inline"></table>
							</ul>
						</div>
					</div>
				</div>
				<div class=content2-3>
					<div class="content2-21">
						<div>
							<div class="content-font2">查询时间：</div>
							<br> 开始时间：<br> <input type="date" class="start1"
								value="<%=time%>"><br> 结束时间：<br> <input
								type="date" class="end1" value="<%=time%>"><br>
						</div>
						<div>
							<div class="content-font2">筛选条件：</div>
							<input type="text" class="select_name" placeholder="请输入需要查询的姓名"><br>
							<input type="text" class="select_id" placeholder="请输入需要查询的id"><br>
							<input type="radio" class="signstatus1" name="signstatus1" value=0>查询签到<br>
							<input type="radio" class="signstatus1" name="signstatus1" value=1>查询迟到<br>
							<input type="radio" class="signstatus1" name="signstatus1" value=2>查询早退<br>
							<input type="radio" class="signstatus1" name="signstatus1" value=3>查询请假<br>
							<input type="radio" class="signstatus1" name="signstatus1" value=4>查询缺席<br>
							<input type="radio" class="signstatus1" name="signstatus1" value=4>查询迟到并且早退<br>
							<input type="radio" class="signstatus1" name="signstatus1" value=6>查询所有<br>
							<input type="button" class="bt_check1" value="查询"><br>
						</div>
					</div>
					<div class="content2-22">
						<div class="outline">
							<table border=1 class="t3">
								<tr>
									<th>员工姓名</th>
									<th>员工编号</th>
									<th>日期</th>
									<th>上班签到时间</th>
									<th>下班签到时间</th>
									<th>考勤情况</th>
								</tr>
							</table>
							<table border=1 class="t3" id="checkInOrder1" class="inline"></table>
						</div>
						<div class="go_page">
							<input type="button" class="pageUp" value="上一页"> <input
								type="button" class="pageDown" value="下一页"> <input
								type="text" class="pageNum" value="1"> <input
								type="button" class="go" value="跳转">
						</div>
					</div>
				</div>
				<div class=content2-4>
					<form class="users_insert" action="./Insert_uServlet">
					<center>
					<table border="1px" cellspacing=0 cellspadding=0><tr><th>姓名</th><th>手机</th><th>生日</th><th>性别</th><th>职位</th></tr>
							<tr>
								<td><input type="text" name="uname1"></td>
								<td><input type="text" name="utelphone1"></td>
								<td><input type="date" name="ubirthday1"></td>
								<td><select name="usex1"><option value="1">男</option><option value="0 ">女</option></select></td>
								<td><input type="text" name="utype1"></td>
							</tr>
								<tr><td><input type="text" name="uname2"></td>
								<td><input type="text" name="utelphone2"></td>
								<td><input type="date" name="ubirthday2"></td>
								<td><select name="usex2"><option value="1">男</option><option value="0">女</option></select></td>
								<td><input type="text" name="utype2"></td>
							</tr>
							<tr>
								<td><input type="text" name="uname3"></td>
								<td><input type="text" name="utelphone3"></td>
								<td><input type="date" name="ubirthday3"></td>
								<td><select name="usex3"><option value="1">男</option><option value="0">女</option></select></td>
								<td><input type="text" name="utype3"></td>
							</tr>
							<tr>
								<td><input type="text" name="uname4"></td>
								<td><input type="text" name="utelphone4"></td>
								<td><input type="date" name="ubirthday4"></td>
								<td><select name="usex4"><option value="1">男</option><option value="0">女</option></select></td>
								<td><input type="text" name="utype4"></td>
							</tr>
							<tr>
								<td><input type="text" name="uname5"></td>
								<td><input type="text" name="utelphone5"></td>
								<td><input type="date" name="ubirthday5"></td>
								<td><select name="usex5"><option value=1>男</option><option value="0">女</option></select></td>
								<td><input type="text" name="utype5"></td>
							</tr>
							
						</table>
					<input type="submit" value="提交">
					</center>
					</form>
				</div>
			</li>
		</ul>
	</div>
</body>
<script src="./js/tools.js"></script>
<script type="text/javascript">
	

	$('.label1').onclick = function() {
		$('.content2-1').style = "display:block";
		$('.content2-2').style = "display:none";
		$('.content2-3').style = "display:none";
		$('.content2-4').style = "display:none";
	};
	$('.label2').onclick = function() {
		$('.content2-1').style = "display:none";
		$('.content2-2').style = "display:block";
		$('.content2-3').style = "display:none";
		$('.content2-4').style = "display:none";
	};
	$('.label3').onclick = function() {
		$('.content2-1').style = "display:none";
		$('.content2-2').style = "display:none";
		$('.content2-3').style = "display:block";
		$('.content2-4').style = "display:none";
	};
	$('.label4').onclick = function() {
		$('.content2-1').style = "display:none";
		$('.content2-2').style = "display:none";
		$('.content2-3').style = "display:none";
		$('.content2-4').style = "display:block";
	};
	var signstatus = 0;
	for (var i = 0; i < $('.signstatus').length; i++) {
		$('.signstatus')[i].onclick = function(event) {
			signstatus = event.target.value;
		};
	}

	var signstatus1 = 0;
	for (var i = 0; i < $('.signstatus1').length; i++) {
		$('.signstatus1')[i].onclick = function(event) {
			signstatus1 = event.target.value;
		}
	}
	var xhr = new XMLHttpRequest();
	$(".bt_check").onclick = function(event) {
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				$("#checkInOrder").innerHTML = xhr.responseText;
			}
		};
		var str = "./ShowPersonalServlet?id=" +
<%=id%>
	+ "&signstatus="
				+ signstatus + "&start=" + $('.start').value + "&end="
				+ $('.end').value;
		xhr.open("post", str, true);
		xhr.send();
	};
	var xhr1 = new XMLHttpRequest();
	$("#signIn").onclick = function() {
		xhr1.onreadystatechange = function() {
			if (xhr1.readyState == 4 && xhr1.status == 200) {

				alert(xhr1.responseText);
				location.href = "./mainPage.jsp";
			}
		};
		var str = "./SignInServlet?id=" +
<%=id%>
	;
		xhr1.open("post", str, true);
		xhr1.send();
	};
	var xhr2 = new XMLHttpRequest();
	$("#signOff").onclick = function() {
		xhr2.onreadystatechange = function() {
			if (xhr2.readyState == 4 && xhr2.status == 200) {

				alert(xhr2.responseText);
				location.href = "./mainPage.jsp";
			}
		};
		var str = "./SignOffServlet?id=" +
<%=id%>
	;
		xhr2.open("post", str, true);
		xhr2.send();
	};
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
	var pageflag = 0;
	var xhr3 = new XMLHttpRequest();
	function go_page(i, n, signstatus1, s, e, p) {
		xhr3.onreadystatechange = function() {
			if (xhr3.readyState == 4 && xhr3.status == 200) {
				//if(xhr3.responseText.indexOf("errorPage",0)<0){
				if (xhr3.responseText.indexOf("errorTime", 0) >= 0)
					alert("请输入正确的时间！");
				else if (xhr3.responseText.indexOf("errorPage", 0) >= 0) {
					pageflag = 0;
					alert("页码有误，请重新输入！");
				} else {
					pageflag = 1;
					$("#checkInOrder1").innerHTML = xhr3.responseText;
				}
				/* if(xhr3.responseText.indexOf("errorTime", 0)<0)
				id("checkInOrder1").innerHTML=xhr3.responseText;
				else alert("请输入正确的时间！");
				if(xhr3.responseText.indexOf("errorPage", 0)<0)
					id("checkInOrder1").innerHTML=xhr3.responseText;
					else alert("请输入正确的时间！");
				}else {
				alert("输入的页码有误，请重新输入！");
				classes('pageNum').value=1;
				} */
			}
		};
		//var str="./refurbish1.jsp?id="+name('select_id').value+"&name="+name('select_name').value+"&type="+type1+"&start="+name('start1').value+"&end="+name('end1').value+"&pageNum="+classes('pageNum').value;

		var str = "./ShowAllServlet?id=" + i + "&name=" + n + "&signstatus="
				+ signstatus1 + "&start=" + s + "&end=" + e + "&pageNum=" + p;

		xhr3.open("post", str, true);
		xhr3.send();
		/* var str="./refurbish1.jsp";
		xhr3.open("post",str,true);
		xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
		xhr3.send("id="+i+"&name="+n+"&type="+t+"&start="+s+"&end="+e+"&pageNum="+p); */
	}
	$('.go').onclick = function() {
		go_page($('.select_id').value, $('.select_name').value, signstatus1,
				$('.start1').value, $('.end1').value, $('.pageNum').value);
	};
	$('.pageUp').onclick = function() {
		go_page($('.select_id').value, $('.select_name').value, signstatus1,
				$('.start1').value, $('.end1').value, $('.pageNum').value - 1);
		$('.pageNum').value = $('.pageNum').value - pageflag;
	};
	$('.pageDown').onclick = function() {
		go_page($('.select_id').value, $('.select_name').value, signstatus1,
				$('.start1').value, $('.end1').value,
				parseInt($('.pageNum').value) + 1);
		$('.pageNum').value = parseInt($('.pageNum').value) + pageflag;
	};
	$(".bt_check1").onclick = function(event) {
		go_page($('.select_id').value, $('.select_name').value, signstatus1,
				$('.start1').value, $('.end1').value, 1);
		$('.go_page').style = "display:block;";
	};
</script>
</html>
