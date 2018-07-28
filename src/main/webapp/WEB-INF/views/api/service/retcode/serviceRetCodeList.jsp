<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>返回码表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/service/retcode/serviceRetCode/">返回码表列表</a></li>
		<shiro:hasPermission name="service:retcode:serviceRetCode:edit"><li><a href="${ctx}/service/retcode/serviceRetCode/form">返回码表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="serviceRetCode" action="${ctx}/service/retcode/serviceRetCode/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>返回代码：</label>
				<form:input path="retCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>返回信息：</label>
				<form:input path="retMsg" htmlEscape="false" maxlength="1024" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>返回代码</th>
				<th>返回信息</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="service:retcode:serviceRetCode:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceRetCode">
			<tr>
				<td><a href="${ctx}/service/retcode/serviceRetCode/form?id=${serviceRetCode.id}">
					${serviceRetCode.retCode}
				</a></td>
				<td>
					${serviceRetCode.retMsg}
				</td>
				<td>
					<fmt:formatDate value="${serviceRetCode.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${serviceRetCode.remarks}
				</td>
				<shiro:hasPermission name="service:retcode:serviceRetCode:edit"><td>
    				<a href="${ctx}/service/retcode/serviceRetCode/form?id=${serviceRetCode.id}">修改</a>
					<a href="${ctx}/service/retcode/serviceRetCode/delete?id=${serviceRetCode.id}" onclick="return confirmx('确认要删除该返回码表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>