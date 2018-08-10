<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务调用日志管理</title>
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
		<li class="active"><a href="${ctx}/service/log/serviceCallLog/">服务调用日志列表</a></li>
		<shiro:hasPermission name="service:log:serviceCallLog:edit"><li><a href="${ctx}/service/log/serviceCallLog/form">服务调用日志添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="serviceCallLog" action="${ctx}/service/log/serviceCallLog/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>服务代码：</label>
				<form:input path="serviceCode" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>服务名称：</label>
				<form:input path="serviceName" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>服务类型：</label>
				<form:select path="serviceType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>请求时间：</label>
				<input name="beginRequestTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${serviceCallLog.beginRequestTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endRequestTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${serviceCallLog.endRequestTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>返回时间：</label>
				<input name="beginResponseTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${serviceCallLog.beginResponseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endResponseTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${serviceCallLog.endResponseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>服务代码</th>
				<th>服务名称</th>
				<th>服务渠道</th>
				<th>服务中心地址</th>
				<th>服务组</th>
				<th>服务类名</th>
				<th>版本号</th>
				<th>服务类型</th>
				<th>查询分组ID</th>
				<th>请求报文</th>
				<th>返回报文</th>
				<th>请求时间</th>
				<th>返回时间</th>
				<th>处理时间</th>
				<shiro:hasPermission name="service:log:serviceCallLog:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceCallLog">
			<tr>
				<td><a href="${ctx}/service/log/serviceCallLog/form?id=${serviceCallLog.id}">
					${serviceCallLog.serviceCode}
				</a></td>
				<td>
					${serviceCallLog.serviceName}
				</td>
				<td>
					${fns:getDictLabel(serviceCallLog.channel, 'service_channel', '')}
				</td>
				<td>
					${serviceCallLog.serviceCenterUrl}
				</td>
				<td>
					${serviceCallLog.serviceGroup}
				</td>
				<td>
					${serviceCallLog.className}
				</td>
				<td>
					${serviceCallLog.version}
				</td>
				<td>
					${fns:getDictLabel(serviceCallLog.serviceType, 'service_type', '')}
				</td>
				<td>
					${serviceCallLog.queryGroupid}
				</td>
				<td>
					${serviceCallLog.requestData}
				</td>
				<td>
					${serviceCallLog.responseData}
				</td>
				<td>
					<fmt:formatDate value="${serviceCallLog.requestTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${serviceCallLog.responseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${serviceCallLog.handleTime}
				</td>
				<shiro:hasPermission name="service:log:serviceCallLog:edit"><td>
    				<a href="${ctx}/service/log/serviceCallLog/form?id=${serviceCallLog.id}">修改</a>
					<a href="${ctx}/service/log/serviceCallLog/delete?id=${serviceCallLog.id}" onclick="return confirmx('确认要删除该服务调用日志吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>