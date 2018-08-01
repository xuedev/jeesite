<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>sql查询分组sql管理</title>
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
		<li class="active"><a href="${ctx}/sql/sql/querySql/">sql查询分组sql列表</a></li>
		<shiro:hasPermission name="sql:sql:querySql:edit"><li><a href="${ctx}/sql/sql/querySql/form">sql查询分组sql添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="querySql" action="${ctx}/sql/sql/querySql/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>查询ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>查询分组ID：</label>
				<form:input path="querygroupid" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>查询sqlID</th>
				<th>查询分组ID</th>
				<th>查询序号</th>
				<th>查询SQL数据类</th>
				<th>查询说明</th>
				<th>查询SQL</th>
				<th>数据源</th>
				<th>项目编码</th>
				<th>应用编码</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>删除标记</th>
				<shiro:hasPermission name="sql:sql:querySql:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="querySql">
			<tr>
				<td><a href="${ctx}/sql/sql/querySql/form?id=${querySql.id}">
					${querySql.querysqlid}
				</a></td>
				<td>
					${querySql.querygroupid}
				</td>
				<td>
					${querySql.seqno}
				</td>
				<td>
					${querySql.querysqltype}
				</td>
				<td>
					${querySql.querydes}
				</td>
				<td>
					${querySql.querysql}
				</td>
				<td>
					${querySql.datasource}
				</td>
				<td>
					${querySql.procode}
				</td>
				<td>
					${querySql.appcode}
				</td>
				<td>
					${querySql.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${querySql.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${querySql.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${querySql.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${querySql.remarks}
				</td>
				<td>
					${fns:getDictLabel(querySql.delFlag, 'del_flag', '')}
				</td>
				<shiro:hasPermission name="sql:sql:querySql:edit"><td>
    				<a href="${ctx}/sql/sql/querySql/form?id=${querySql.id}">修改</a>
					<a href="${ctx}/sql/sql/querySql/delete?id=${querySql.id}" onclick="return confirmx('确认要删除该sql查询分组sql吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>