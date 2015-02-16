<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="users"/></title>
<script  type="text/javascript">
	RLS.Utils.registerFilterExpandCollapse('filter_caption');
</script>
</head>
<body>
<h2><spring:message code="users"/> </h2>
<div class="button-panel pull-right">
	 <a
		href="<c:url value='/admin/user/edit'/>"
		class="btn btn-primary btn-small" id="act_add"> 
		<i class="icon-plus icon-white"></i> 
		<spring:message code="add"/>
	</a> 
</div>
<div class="clearfix"></div>
<div class="accordion-group well filter-panel">
	<div class="accordion-heading">
		<span id="filter_caption" class="accordion-toggle"
			data-toggle="collapse" data-target="#filter_body"> 
			<strong>
				<spring:message code="filter" />
			</strong> 
			<span class="btn btn-mini pull-right"> 
				<i class="icon-chevron-down" rel="tooltip"></i>
			</span>
		</span>
	</div>
	<div id="filter_body" class="accordion-body collapse">
		<div class="accordion-inner">
			<form action="<c:url value='/admin/user/get'/>" method="get">
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span3">
							<label for="firstName" class="control-label">
								<spring:message code="fio" />
							</label>
							<div class="controls">
								<form:input type="text" path="filter.firstName" class="span12" maxlength="50" />
							</div>
						</div>
						<div class="span3">
							<label for="lastName" class="control-label">
								<spring:message code="login" />
							</label>
							<div class="controls">
								<form:input type="text" path="filter.lastName" class="span12" maxlength="50" />
							</div>
						</div>
						<div class="span3">
							<label for="email" class="control-label">
								<spring:message code="email" />
							</label>
							<div class="controls">
								<form:input type="text" path="filter.email" class="span12"  maxlength="50" />
							</div>
						</div>
						<div class="span3">
							<label for="roleId" class="control-label">
								<spring:message code="role" />
							</label>
							<div class="controls">
								<form:select path="filter.roleId" id="roleId" class="span12">
									<form:option value="" label="<...>" />
									<form:options items="${roleList}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
						</div>
					</div>
					<div class="filter-actions pull-right">
						<button type="submit" class="btn btn-primary" id="act_search">
							<i class="icon-search icon-white"></i>
							<spring:message code="search" />
						</button>
						<a href="<c:url value='/admin/user/get'/>" class="btn" id="act_clear">
							<i class="icon-remove"></i> 
							<spring:message code="reset"/>
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<br>
<display:table name="user" id="user" requestURI="users" pagesize="10" class="table table-striped table-bordered">
	<display:column property="name" titleKey="fio" sortable="true" style="width:80px" />
	<display:column property="login" titleKey="login" sortable="true" style="width:300px " />
	<display:column property="email" titleKey="email" sortable="true" style="width:300px " />
	<display:column property="additionalInformation" titleKey="additionalInfo" sortable="true" style="width:200px" />
	<display:column property="role.name" titleKey="role" sortable="true" style="width:200px" />
	<display:column paramId="id" style="text-align: center; width:20px;white-space: nowrap;" title="">
		<a class="icon-edit" title='<spring:message code="edit" />'
			href="<c:url value='/admin/user/edit/'/>${user.id}"> </a>
		<a class="icon-remove" title='<spring:message code="delete" />'
			href="<c:url value='/admin/user/delete/'/>${user.id}"></a>
	</display:column>
</display:table>
</body>
</html>
