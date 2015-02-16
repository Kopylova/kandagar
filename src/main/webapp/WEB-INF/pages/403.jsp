<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
	<title>RLS</title>
	<link href="<c:url value='/images/user-icon.png'/>" rel="shortcut icon" />
	<meta charset="utf-8">  
	<link media="all" type="text/css" href="<c:url value='/styles/reset.css'/>" rel="stylesheet">
	<link media="all" type="text/css" href="<c:url value='/styles/style.css'/>" rel="stylesheet">
	<script type="text/javascript" src="<c:url value='/scripts/jquery-1.8.2.min.js'/>"></script>
</head>
<body>
   <div class="bg1">
 	 <div class="bg2">
   	    <div class="main">
    	  <header>
      		 <h1>
      		 	 <a href="<c:url value='/'/>" alt="RLS">
      		 		<img alt="RLS" src="<c:url value='/images/logo.png'/>">
      		 	 </a>
      	     </h1>
      		 <br/>
     	 </header>
   <article id="content">
   <div id="visible-container" style="padding-left:20px; padding-top:10px;">
                
    <hgroup class="orange">
        <h2>
            <spring:message code="403Error" />
        </h2>
    </hgroup>

                
    <p class="error"><spring:message code="403Body" /></p>
    <br>
    <p class="error"><a href="<c:url value='/'/>"><spring:message code="ErrorHome" /></a></p>

                
            </div>

   </article>
    </div>
  </div>
</div>
<div class="main">
  <footer>
	 <jsp:useBean id="date" class="java.util.Date" />
   <p style=" margin-left: 300px; margin-top: 50px; color: #FFFFFF;">© Resume Load System -  <fmt:formatDate value="${date}" pattern="yyyy" /> </p>
 </footer>
</div>
</body>
</html>