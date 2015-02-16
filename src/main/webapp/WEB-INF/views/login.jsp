<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	 <spring:message code="logon" />
</title>
</head>
<body>
<h2>
	 <spring:message code="logon" />
</h2>
<hr/>
	<c:if test="${not empty hasErrors}">
		<div class="alert alert-error">
			<button data-dismiss="alert" class="close" type="button">×</button>
	    	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} 
	    </div>
	</c:if>
	<form action="j_spring_security_check" method="post">
		<div class="controls">
            	<label for="userName"> <spring:message code="login" /></label>
            	<input type="text"  name="j_username" id="userName" class="span3">
       	 </div>
         <div class="controls">
         	   <label for="password"> <spring:message code="password"/></label>
          	   <input type="password" name="j_password" id="password" class="span3">
       	</div>
       	<div class="form-actions">
            <button type="submit" class="btn btn-primary">
              	<i class="icon-user icon-white"></i>
                <spring:message code="loginOn"/>
           	</button>
             <a class="btn" href="<c:url value='/'/>">
                 <i class="icon-remove"></i>
                 <spring:message code="cancel"/>
             </a>
        </div>
	</form>
</body>
</html>








