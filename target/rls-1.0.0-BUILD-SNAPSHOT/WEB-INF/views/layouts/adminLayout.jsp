<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title><decorator:title default="RLS"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/images/favicon.ico'/>" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/bootstrap.fix.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/admin.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/jquery-1.8.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/jquery.cookie.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/jquery.tmpl.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/jquery.chosen.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/utils.js'/>"></script>

<script  type="text/javascript">
	$(function() {
		RLS.Utils.init("${pageContext.request.servletPath}", '', '<c:url value='/'/>');
	});
</script>

<decorator:head/>

</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container-fluid">
			<sec:authorize access="isAuthenticated()">	
				<a style="font-weight: bold" href="<c:url value='/admin/index'/>" class="brand">RLS</a>	
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">	
				<a style="font-weight: bold" href="<c:url value='/'/>" class="brand">RLS</a>	
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">		
				<ul class="nav">
					<li class="divider-vertical"></li>
				 <sec:authorize access="hasRole('Administrator')">
					<li class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle">
							<spring:message code="admin" />
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li class="active">
								<a href="<c:url value='/admin/user/get'/>">
									<i class="icon-user"></i> 
									<spring:message code="users" />
								</a>
							</li>
						</ul>
					</li>
					</sec:authorize>
					<li class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle">
							<spring:message code="resume" />
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="<c:url value='/admin/resume/get'/>">
									<i class="icon-th"></i> 
									<spring:message code="load" />
								</a>
							</li>
						</ul>
					</li>
				</ul>		
				
				<div class="btn-group pull-right">
					<a href="#" data-toggle="dropdown" class="btn dropdown-toggle"> 
						<i class="icon-user"></i> 
						<span> 
							<sec:authentication property="principal.username"/>
						</span> 
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li>
							<a id="go-client-side-btn" href="<c:url value='/'/>">
								<i class="icon-home"></i> 
								<spring:message code="outInStartPage" />
							</a>
						</li>
						<li>
							<a href="<spring:url value="/j_spring_security_logout" />">
								<i class="icon-off"></i> 
								<spring:message code="out" />
							</a>
						</li>
					</ul>
				</div>
					</sec:authorize>
				<div class="pull-right">
					<ul class="nav">
						<li class="divider-vertical"></li>
						<li>
							<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=ru"> 
								<img class="country-img" title="<spring:message code="russian"/>" alt="<spring:message code='russian'/>" src="<c:url value='/images/flag_ru.png'/>">
							</a>
						</li>
						<li>
							<a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en"> 
								<img class="country-img"  title="<spring:message code="english"/>" alt="<spring:message code='english'/>" src="<c:url value='/images/flag_en.png'/>">
							</a>
						</li>
						<li class="divider-vertical"></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div style="padding-top: 60px" class="container">
	<c:if test="${SUCCESS_MESSAGE != null}">
  	 	<div class="alert alert-success">
        	<button data-dismiss="alert" class="close" type="button">×</button>
        	${SUCCESS_MESSAGE} 
        </div>
	</c:if> 
	<c:if test="${ERROR_MESSAGE != null}">
  		<div class="alert alert-error">
              <button data-dismiss="alert" class="close" type="button">×</button>
              ${ERROR_MESSAGE}
        </div>
	</c:if> 
   <decorator:body />
   <hr/>
</div>
</body>
<footer>
	<jsp:useBean id="date" class="java.util.Date" />
	<p>© RLS  <fmt:formatDate value="${date}" pattern="yyyy" /> </p>
</footer>
</html>