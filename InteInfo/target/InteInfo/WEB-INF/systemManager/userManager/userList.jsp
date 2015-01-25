<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#systemManager_userManager_datagrid').datagrid({
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
				//alert(rowData["userid"]);
				$("#systemManager_userManager_window").html(rowData["userid"]);
				$('#systemManager_userManager_window').window({
					width : 600,
					height : 600,
					top : 100,
					minimizable : false,
					maximizable : false,
					draggable : false,
					modal : true
				}).window('open');
				$('#systemManager_userManager_window').window({
					onOpen : function() {
						$("#systemManager_userManager_window").html("测试数据");
					}
				});
			}

		});
	});

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


	<div id="systemManager_userManager_window"></div>


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