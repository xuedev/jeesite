<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>市场状态变更管理</title>
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
		<li class="active"><a href="${ctx}/trade/market/billMarketStatus/">市场状态变更列表</a></li>
		
	</ul>
	<form:form id="searchForm" modelAttribute="billMarketStatus" action="${ctx}/trade/market/billMarketStatus/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>市场状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('market_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>市场状态</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="trade:market:billMarketStatus:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="billMarketStatus">
			<tr>
				<td><a href="${ctx}/trade/market/billMarketStatus/form?id=${billMarketStatus.id}">
					${fns:getDictLabel(billMarketStatus.status, 'market_status', '')}
				</a></td>
				<td>
					${billMarketStatus.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${billMarketStatus.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${billMarketStatus.remarks}
				</td>
				<shiro:hasPermission name="trade:market:billMarketStatus:edit"><td>
    				<a href="${ctx}/trade/market/billMarketStatus/form?id=${billMarketStatus.id}">修改</a>
					<a href="${ctx}/trade/market/billMarketStatus/delete?id=${billMarketStatus.id}" onclick="return confirmx('确认要删除该市场状态变更吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>