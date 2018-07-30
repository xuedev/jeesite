<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>SQL查询分组管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sql/group/queryGroup/">SQL查询分组列表</a></li>
		<li class="active"><a href="${ctx}/sql/group/queryGroup/form?id=${queryGroup.id}">SQL查询分组<shiro:hasPermission name="sql:group:queryGroup:edit">${not empty queryGroup.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sql:group:queryGroup:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="queryGroup" action="${ctx}/sql/group/queryGroup/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">查询分组ID：</label>
			<div class="controls">
				<form:input path="querygroupid" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">查询介绍：</label>
			<div class="controls">
				<form:input path="querygroupdes" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">展示方式：</label>
			<div class="controls">
				<form:select path="showtype" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('show_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">每页条数：</label>
			<div class="controls">
				<form:input path="showcount" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缓存类型：</label>
			<div class="controls">
				<form:select path="cachetype" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('cache_Type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缓存时长：</label>
			<div class="controls">
				<form:input path="cachetime" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缓存KEY：</label>
			<div class="controls">
				<form:input path="cachekey" htmlEscape="false" maxlength="128" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拦截器：</label>
			<div class="controls">
				<form:input path="interceptor" htmlEscape="false" maxlength="256" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">查询引用：</label>
			<div class="controls">
				<form:input path="queryreference" htmlEscape="false" maxlength="512" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目编码：</label>
			<div class="controls">
				<form:input path="procode" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应用编码：</label>
			<div class="controls">
				<form:input path="appcode" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否允许公共调：</label>
			<div class="controls">
				<form:select path="ispubliccall" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('public_call')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sql:group:queryGroup:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>