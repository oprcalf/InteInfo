<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../shared/include.inc.jsp"%>
<!DOCTYPE HTML >
<html>
<head>
<title>示例系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 60px;"></div>
	<div data-options="region:'south'" style="height: 20px;"></div>
	<div data-options="region:'west'" style="width: 200px;">
	<jsp:include page="west.jsp"></jsp:include>
	</div>
	<div data-options="region:'east',title:'east',split:true" style="width: 200px;"></div>
	<div data-options="region:'center',title:'示例系统'" style="overflow: hidden;">
	<jsp:include page="center.jsp"></jsp:include>
	</div>

</body>
</html>