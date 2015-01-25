<%@ page contentType="text/html;  charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#main_north_logoutUserButton').bind('click', function() {
			if (window.confirm('确定退出吗?')) {
				$.ajax({
					cache : true,
					type : "POST",
					url : '${pageContext.request.contextPath}/Login/loginAction!logoutSession.action',
					async : false,
					error : function() {
						alert("Connection error");
						return false;
					},
					success : function() {
						window.location.href = '${pageContext.request.contextPath}/Login/loginAction!doNotNeedSession_ReturnLogin.action?LoginMessage=returnToLogin';
						return true;
					}
				});
			} else {
				return false;
			}
		});
	});
</script>

<div style="margin: 15px 20px 10px 20px; text-align: right;">
	<a href="#" id="main_north_logoutUserButton" class="easyui-linkbutton"
		data-options="plain:true">退出:[${sessionScope.sessionInfo}]</a>


</div>
