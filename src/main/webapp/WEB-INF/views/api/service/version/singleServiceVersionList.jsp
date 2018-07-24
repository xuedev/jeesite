<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务版本管理</title>
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
		<li class="active"><a href="${ctx}/service/version/singleServiceVersion/">服务版本列表</a></li>
		<shiro:hasPermission name="service:version:singleServiceVersion:edit"><li><a href="${ctx}/service/version/singleServiceVersion/form">服务版本添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="singleServiceVersion" action="${ctx}/service/version/singleServiceVersion/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>服务编码：</label>
				<form:input path="serviceCode" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>服务渠道：</label>
				<form:select path="channel" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_channel')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>版本号：</label>
				<form:input path="version" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li><label>接口状态：</label>
				<form:select path="verStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>类名：</label>
				<form:input path="className" htmlEscape="false" maxlength="512" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>服务编码</th>
				<th>服务渠道</th>
				<th>版本号</th>
				<th>接口状态</th>
				<th>类名</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="service:version:singleServiceVersion:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="singleServiceVersion">
			<tr>
				<td><a href="${ctx}/service/version/singleServiceVersion/form?id=${singleServiceVersion.id}">
					${singleServiceVersion.serviceCode}
				</a></td>
				<td>
					${fns:getDictLabel(singleServiceVersion.channel, 'service_channel', '')}
				</td>
				<td>
					${singleServiceVersion.version}
				</td>
				<td>
					${fns:getDictLabel(singleServiceVersion.verStatus, 'service_status', '')}
				</td>
				<td>
					${singleServiceVersion.className}
				</td>
				<td>
					<fmt:formatDate value="${singleServiceVersion.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${singleServiceVersion.remarks}
				</td>
				<shiro:hasPermission name="service:version:singleServiceVersion:edit"><td>
    				<a href="${ctx}/service/version/singleServiceVersion/form?id=${singleServiceVersion.id}">修改</a>
					<a href="${ctx}/service/version/singleServiceVersion/delete?id=${singleServiceVersion.id}" onclick="return confirmx('确认要删除该服务版本吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>