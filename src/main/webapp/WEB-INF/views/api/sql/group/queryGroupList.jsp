<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>SQL查询分组管理</title>
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
		<li class="active"><a href="${ctx}/sql/group/queryGroup/">SQL查询分组列表</a></li>
		<shiro:hasPermission name="sql:group:queryGroup:edit"><li><a href="${ctx}/sql/group/queryGroup/form">SQL查询分组添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="queryGroup" action="${ctx}/sql/group/queryGroup/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>查询分组ID：</label>
				<form:input path="querygroupid" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>查询介绍：</label>
				<form:input path="querygroupdes" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>查询分组ID</th>
				<th>查询介绍</th>
				<th>展示方式</th>
				<th>每页条数</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sql:group:queryGroup:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="queryGroup">
			<tr>
				<td><a href="${ctx}/sql/group/queryGroup/form?id=${queryGroup.id}">
					${queryGroup.querygroupid}
				</a></td>
				<td>
					${queryGroup.querygroupdes}
				</td>
				<td>
					${fns:getDictLabel(queryGroup.showtype, 'show_type', '')}
				</td>
				<td>
					${queryGroup.showcount}
				</td>
				<td>
					<fmt:formatDate value="${queryGroup.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${queryGroup.remarks}
				</td>
				<shiro:hasPermission name="sql:group:queryGroup:edit"><td>
    				<a href="${ctx}/sql/group/queryGroup/form?id=${queryGroup.id}">修改</a>
					<a href="${ctx}/sql/group/queryGroup/delete?id=${queryGroup.id}" onclick="return confirmx('确认要删除该SQL查询分组吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>