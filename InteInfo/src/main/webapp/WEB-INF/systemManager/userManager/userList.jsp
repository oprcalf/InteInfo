
<%@ page contentType="text/html;  charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		$('#systemManager_userManager_datagrid').datagrid(
				{
					url : '${pageContext.request.contextPath}/User/userAction!getUserList.action',
					fit : true,
					fitColumns : true,
					border : false,
					pagination : true,
					singleSelect : true,
					pageSize : 100,
					pageList : [ 100, 200, 300, 400, 500 ],
					idField : 'userid',

					columns : [ [ {
						field : 'userid',
						title : 'userid',
						hidden : true,
						width : 10
					}, {
						field : 'username',
						title : '用户名',
						sortable : true,
						order : 'asc',
						width : 10
					}, {
						field : 'createdate',
						title : '创建时间',
						width : 20,
						align : 'right'
					} ] ],
					onDblClickRow : function(rowIndex, rowData) {
						$('#systemManager_userManager_window').window(
								{
									title : "用户信息",
									minimizable : false,
									maximizable : false,
									maximized : true,
									draggable : false,
									fit : true,
									modal : true,
									onOpen : function() {
										var userid = rowData["userid"];
										$('#systemManager_userManager_editUserForm').form('load',
												'${pageContext.request.contextPath}/User/userAction!getUserInfo.action?userid=' + userid);
									},
									onClose : function() {
										$('#systemManager_userManager_datagrid').datagrid('reload', {});
									}
								});
					}

				});
	});

	function SaveSM_UM_editUserForm() {
		var isValid = $('#systemManager_userManager_editUserForm').form('validate');
		if (isValid) {
			if (window.confirm('确定保存吗?')) {
				var userid = $('#SM_UM_editUserForm_userid').val();
				var username = $('#SM_UM_editUserForm_username').val();
				var email = $('#SM_UM_editUserForm_userEmail').val();

				$('#systemManager_userManager_editUserForm').form('submit', {
					url : '${pageContext.request.contextPath}/User/userAction!editUserInfo.action?userid=' + userid,
					success : function() {
						$.messager.alert('信息框', '保存成功!', 'info');
						$('#systemManager_userManager_window').window('close');
						return true;
					}
				});
			} else {
				return false;
			}
		} else {
			return isValid;
		}
	}

	function ResetSM_UM_editUserForm() {
		var userid = $('#SM_UM_editUserForm_userid').val();
		$('#systemManager_userManager_editUserForm').form('load',
				'${pageContext.request.contextPath}/User/userAction!getUserInfo.action?userid=' + userid);
	}

	function searchFun() {
		var username = $('#systemManager_userManager_searchForm input').val();
		$('#systemManager_userManager_datagrid').datagrid('load', {
			username : username
		});
	}

	function clearFun() {
		$('#systemManager_userManager_searchForm input').val('');
		$('#systemManager_userManager_datagrid').datagrid('load', {
			username : ''
		});
	}
</script>

<div id="systemManager_userManager_layout" class="easyui-layout"
	data-options="fit:true,border:false">


	<div id="systemManager_userManager_window">
		<!-- 上右下左 -->
		<div
			style="border: solid 1px grey; width: 60%; height: 5%; margin: 0 auto; font-size: 20px">
			用户信息</div>
		<div
			style="border: 1px solid grey; width: 60%; height: 90%; margin: 0 auto">
			<form id="systemManager_userManager_editUserForm">
				<table style="margin: 0 auto">
					<tr>
						<td><input type="hidden" name="userid"
							id="SM_UM_editUserForm_userid" /></td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input class="easyui-validatebox" type="text"
							id="SM_UM_editUserForm_username" name="username"
							data-options="required:true"></input></td>
						<td></td>
						<td>邮件:</td>
						<td><input class="easyui-validatebox" type="text"
							id="SM_UM_editUserForm_userEmail" name="email"
							data-options="required:true,validType:'email'"></input></td>
					</tr>
				</table>
			</form>
		</div>
		<div
			style="border: solid 1px grey; width: 60%; height: 5%; margin: 0 auto; text-align: right;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'"
				onclick="SaveSM_UM_editUserForm()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'"
				onclick="ResetSM_UM_editUserForm()">重置</a>
		</div>
	</div>


	<div data-options="region:'north',title:'查询条件',border:true"
		style="height: 100px">
		<form id="systemManager_userManager_searchForm">
			检索用户名称(可模糊查询)：<input name="username" type="text" /> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'" onclick="searchFun();"
				id="chaxun">查询</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
				onclick="clearFun();">清空</a>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="systemManager_userManager_datagrid">
		</table>
	</div>
</div>