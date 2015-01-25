<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function countDown(secs) {
		document.getElementById("jump").innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + " )", 1000);
		} else {
			window.location = '${pageContext.request.contextPath}';
		}
	}
</script>
<title>Session Page</title>
</head>
<body onLoad="javascript:countDown(1);" style="text-align: center;">
	<h3>
		你的会话已经过期或未登录，页面将在<span id="jump"></span>秒后自动跳转到登陆页面
	</h3>
</body>
</html>