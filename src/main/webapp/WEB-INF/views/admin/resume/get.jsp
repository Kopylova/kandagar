<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div class="filter">
       <div class="wrapper">
       <div style="font-size:16px;">
	 		<spring:message code="resumeLoadInformation" />
		</div>
		<a href="javascript:void(0)" onclick = "RLS.Utils.areYouSure('<c:url value='/admin/resume/load'/>', '<spring:message code="loadResume" />')">
			<img title="<spring:message code="load"/>" alt="<spring:message code='load'/>" src="<c:url value='/images/load.jpg'/>" border="0">
		</a>
       </div>	
     </div>          
   <article id="content">
	  	 <br>
		 </article>
</body>
</html>
