<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务信息管理</title>
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
		<li class="active"><a href="${ctx}/service/info/serviceInfo/">服务信息列表</a></li>
		<shiro:hasPermission name="service:info:serviceInfo:edit"><li><a href="${ctx}/service/info/serviceInfo/form">服务信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="serviceInfo" action="${ctx}/service/info/serviceInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>服务代码：</label>
				<form:input path="serviceCode" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>服务名称：</label>
				<form:input path="serviceName" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>服务中心：</label>
				<form:input path="serviceCenterUrl" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>服务组：</label>
				<form:input path="serviceGroup" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>服务类型：</label>
				<form:select path="serviceType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>适配模式：</label>
				<form:select path="adapMode" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('adap_mode')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>请求方式：</label>
				<form:select path="commMode" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('request_method')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>接口状态：</label>
				<form:select path="interStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${serviceInfo.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${serviceInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>服务中心</th>
				<th>服务组</th>
				<th>服务类型</th>
				<th>适配模式</th>
				<th>请求方式</th>
				<th>接口状态</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="service:info:serviceInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceInfo">
			<tr>
				<td><a href="${ctx}/service/info/serviceInfo/form?id=${serviceInfo.id}">
					${serviceInfo.serviceCode}
				</a></td>
				<td>
					${serviceInfo.serviceName}
				</td>
				<td>
					${serviceInfo.serviceCenterUrl}
				</td>
				<td>
					${serviceInfo.serviceGroup}
				</td>
				<td>
					${fns:getDictLabel(serviceInfo.serviceType, 'service_type', '')}
				</td>
				<td>
					${fns:getDictLabel(serviceInfo.adapMode, 'adap_mode', '')}
				</td>
				<td>
					${fns:getDictLabel(serviceInfo.commMode, 'request_method', '')}
				</td>
				<td>
					${fns:getDictLabel(serviceInfo.interStatus, 'service_status', '')}
				</td>
				<td>
					<fmt:formatDate value="${serviceInfo.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${serviceInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${serviceInfo.remarks}
				</td>
				<shiro:hasPermission name="service:info:serviceInfo:edit"><td>
    				<a href="${ctx}/service/info/serviceInfo/form?id=${serviceInfo.id}">修改</a>
					<a href="${ctx}/service/info/serviceInfo/delete?id=${serviceInfo.id}" onclick="return confirmx('确认要删除该服务信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>