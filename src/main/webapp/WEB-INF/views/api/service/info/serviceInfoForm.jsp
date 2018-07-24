<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务信息管理</title>
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
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/service/info/serviceInfo/">服务信息列表</a></li>
		<li class="active"><a href="${ctx}/service/info/serviceInfo/form?id=${serviceInfo.id}">服务信息<shiro:hasPermission name="service:info:serviceInfo:edit">${not empty serviceInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="service:info:serviceInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="serviceInfo" action="${ctx}/service/info/serviceInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">服务代码：</label>
			<div class="controls">
				<form:input path="serviceCode" htmlEscape="false" maxlength="128" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">服务名称：</label>
			<div class="controls">
				<form:input path="serviceName" htmlEscape="false" maxlength="256" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录认证方式：</label>
			<div class="controls">
				<form:select path="isNeedLogin" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('login_auth_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否允许跨域：</label>
			<div class="controls">
				<form:select path="isAllowCrossDomain" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('is_allow_cross_domain')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">服务类型：</label>
			<div class="controls">
				<form:select path="serviceType" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">适配模式：</label>
			<div class="controls">
				<form:select path="adapMode" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('adap_mode')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">请求方式：</label>
			<div class="controls">
				<form:select path="commMode" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('request_method')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">接口状态：</label>
			<div class="controls">
				<form:select path="interStatus" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('service_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目编码：</label>
			<div class="controls">
				<form:input path="proCode" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">应用编码：</label>
			<div class="controls">
				<form:input path="appCode" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">服务接口版本表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>服务渠道</th>
								<th>版本号</th>
								<th>接口状态</th>
								<th>接口说明</th>
								<th>接口示例</th>
								<th>返回结果报文</th>
								<th>是否当前版本</th>
								<th>返回数据类型</th>
								<th>类名</th>
								<th>模拟报文</th>
								<th>查询分组ID</th>
								<th>项目编码</th>
								<th>应用编码</th>
								<th>备注信息</th>
								<shiro:hasPermission name="service:info:serviceInfo:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="serviceVersionList">
						</tbody>
						<shiro:hasPermission name="service:info:serviceInfo:edit"><tfoot>
							<tr><td colspan="16"><a href="javascript:" onclick="addRow('#serviceVersionList', serviceVersionRowIdx, serviceVersionTpl);serviceVersionRowIdx = serviceVersionRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="serviceVersionTpl">//<!--
						<tr id="serviceVersionList{{idx}}">
							<td class="hide">
								<input id="serviceVersionList{{idx}}_id" name="serviceVersionList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="serviceVersionList{{idx}}_delFlag" name="serviceVersionList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_channel" name="serviceVersionList[{{idx}}].channel" type="text" value="{{row.channel}}" maxlength="2" class="input-small required"/>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_version" name="serviceVersionList[{{idx}}].version" type="text" value="{{row.version}}" maxlength="8" class="input-small required"/>
							</td>
							<td>
								<select id="serviceVersionList{{idx}}_verStatus" name="serviceVersionList[{{idx}}].verStatus" data-value="{{row.verStatus}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDictList('service_status')}" var="dict">
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<textarea id="serviceVersionList{{idx}}_dataDes" name="serviceVersionList[{{idx}}].dataDes" rows="4" class="input-small ">{{row.dataDes}}</textarea>
							</td>
							<td>
								<textarea id="serviceVersionList{{idx}}_dataExample" name="serviceVersionList[{{idx}}].dataExample" rows="4" class="input-small ">{{row.dataExample}}</textarea>
							</td>
							<td>
								<textarea id="serviceVersionList{{idx}}_dataReturndes" name="serviceVersionList[{{idx}}].dataReturndes" rows="4" class="input-small ">{{row.dataReturndes}}</textarea>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_isCurrent" name="serviceVersionList[{{idx}}].isCurrent" type="text" value="{{row.isCurrent}}" maxlength="2" class="input-small "/>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_retDataType" name="serviceVersionList[{{idx}}].retDataType" type="text" value="{{row.retDataType}}" maxlength="2" class="input-small "/>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_className" name="serviceVersionList[{{idx}}].className" type="text" value="{{row.className}}" maxlength="512" class="input-small "/>
							</td>
							<td>
								<textarea id="serviceVersionList{{idx}}_imitateData" name="serviceVersionList[{{idx}}].imitateData" rows="4" class="input-small ">{{row.imitateData}}</textarea>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_queryGroupid" name="serviceVersionList[{{idx}}].queryGroupid" type="text" value="{{row.queryGroupid}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_proCode" name="serviceVersionList[{{idx}}].proCode" type="text" value="{{row.proCode}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="serviceVersionList{{idx}}_appCode" name="serviceVersionList[{{idx}}].appCode" type="text" value="{{row.appCode}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<textarea id="serviceVersionList{{idx}}_remarks" name="serviceVersionList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="service:info:serviceInfo:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#serviceVersionList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var serviceVersionRowIdx = 0, serviceVersionTpl = $("#serviceVersionTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(serviceInfo.serviceVersionList)};
							for (var i=0; i<data.length; i++){
								addRow('#serviceVersionList', serviceVersionRowIdx, serviceVersionTpl, data[i]);
								serviceVersionRowIdx = serviceVersionRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="service:info:serviceInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>