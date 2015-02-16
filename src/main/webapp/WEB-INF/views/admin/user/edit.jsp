<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<c:choose>
    	<c:when test="${empty user.id}">
        	 <spring:message code="addUser" />
    	</c:when>
    	<c:otherwise>
       		 <spring:message code="editUser" />
   		 </c:otherwise>
	</c:choose>
</title>
<script  type="text/javascript">
	$(function() {
		RLS.Utils.registerFormValidation('act_save');
		RLS.Utils.registerTextareaLimit();
	});
</script>
</head>
<body>
<h2>
	<c:choose>
    	<c:when test="${empty user.id}">
        	 <spring:message code="addUser" />
    	</c:when>
    	<c:otherwise>
       		 <spring:message code="editUser" />
   		 </c:otherwise>
	</c:choose>
</h2>
<hr/>
<div class="clearfix"></div>
<form class="form-horizontal" action="<c:url value='/admin/user/save'/>" method="post">
<form:errors path="user.*" cssClass="alert alert-error" element="div" />
<form:hidden path="user.id"/>	
	<fieldset>
		<div class="control-group required" data-control="name">
			<label for="name" class="control-label">
				<spring:message code="fio" />
			</label>
			<div class="controls">
				<form:input type="text" path="user.name" id="name" name="name" class="span4" maxlength="50" />
			</div>
		</div>
		<div class="control-group required" data-control="login">
			<label for="login" class="control-label">
				<spring:message code="login" />
			</label>
			<div class="controls">
				<form:input type="text" path="user.login" id="login" name="login" class="span3 login" maxlength="50" />
			</div>
		</div>
		 <c:choose>
    		 <c:when test="${empty user.id}">
    	       <div data-control="password" class="control-group password required">
			      <label for="password" class="control-label">
				      <spring:message code="password" />
			       </label>
			       <div class="controls">
        				<form:input type="password" path="user.password" id="password" name="password" class="span3" maxlength="50" />
			        </div>
			     </div>
			 </c:when>
    		<c:otherwise>
    		   <div data-control="password" class="control-group password">
					<label for="password" class="control-label">
						<spring:message code="password" />
					</label>
					<div class="controls">
       					<input type="password" value=""  id="password" name="password" class="span3" maxlength="50" />
			    	</div>
			    	<div class="controls">
        				<form:input type="password" path="user.oldPassword" id="oldPassword" name="oldPassword" class="span3" style="display:none;" />
			        </div>
				</div>
			  </c:otherwise>
	 	</c:choose>
		<div class="control-group required email" data-control="email">
			<label for="email" class="control-label">
				<spring:message code="email" />
			</label>
			<div class="controls">
				<form:input type="text" path="user.email" id="email" name="email" class="span3" maxlength="50" />
			</div>
		</div>
		<div class="control-group required" data-control="role">
			<label for="role.id" class="control-label">
				<spring:message code="role" />
			</label>
			<div class="controls">
				<form:select id="role" path="user.role.id" name="category" class="span2">
					<form:option value="" label="<...>" />
					<form:options items="${roleList}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>
		</div>
		<div class="control-group" data-control="isActive">
			<label for="isActive" class="control-label">
				<spring:message code="isEnable" />
			</label>
			<div class="controls">
				<c:choose>
    				<c:when test="${empty user.id}">
        				<form:checkbox path="user.isActive" id="isActive"  checked="checked"/>
    				</c:when>
    				<c:otherwise>
       					<form:checkbox path="user.isActive" id="isActive"/>
   					 </c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="control-group" data-control="additionalInformation">
			<label for="additionalInformation" class="control-label">
				<spring:message code="dopInf" />
			</label>
			<div class="controls">
				<form:textarea path="user.additionalInformation" name="notes" class="span5 limited limit_1000" rows="3"></form:textarea>
			</div>
		</div>
		<div class="form-actions">
			<button type="submit" id="act_save" class="btn btn-primary">
				<i class="icon-ok icon-white"></i>
				<spring:message code="save" />
			</button>
			<a href="<c:url value='/admin/user/get'/>" class="btn" id="act_cancel"> 
				<i class="icon-remove"></i>
			   <spring:message code="cancel"/>
			</a>
		</div>
	</fieldset>
</form>
</body>
</html>








