<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body> 						
		<div class="uk-panel uk-panel-box panel-box" id="filter">
		 	<form action="<c:url value=''/>" method="get">
			 	<form:hidden path="filter.sortColumn"/>
		    	<div class="form-column uk-form-stacked">
		    		<div class="uk-form-row uk-form">
				    	<label for="department" class="uk-form-label">
				    		<spring:message code="workingType" />:
				    	</label>
						<div class="uk-form-controls">
						    <form:select path="filter.workingTypeId" id="department" class="uk-form-small uk-width-9-10">
								<form:option value="" label="<...>" />
								<form:options items="${workingTypeList}" itemValue="id" itemLabel="title" />
						   	</form:select>
					   	</div>
				   	</div>
					<div class="uk-form-row uk-form">
					   	<label for="education" class="uk-form-label">
					   		<spring:message code="education" />:
					   	</label>
					    <div class="uk-form-controls">
						    <form:select path="filter.educationId" id="education" class="uk-form-small uk-width-9-10">
								<form:option value="" label="<...>" />
								<form:options items="${educationList}" itemValue="id" itemLabel="title" />
						   	</form:select>
					   	</div>
				   	</div>
				   	<div class="uk-form-row uk-form">
				   		<label for="rubrica" class="uk-form-label">
				   			<spring:message code="rubrica" />:
				   		</label>
					   	<div class="uk-form-controls">
						    <form:select path="filter.rubricaId" id="rubrica" class="uk-form-small uk-width-9-10">
								<form:option value="" label="<...>" />
								<form:options items="${rubricaList}" itemValue="id" itemLabel="title" />
						   	</form:select>
					   	</div>
				   	</div>
				   	Найдено ${resumeCount} резюме
				   	<div class="uk-grid uk-margin-top button-container uk-width-1-3 uk-text-right button-container">
						<button type="button" class="uk-button uk-button-small uk-margin-top" onclick="location.href='<c:url value='/'/>'">
							<spring:message code="reset" />
						</button>
						<button class="uk-button-primary uk-button uk-button-small uk-margin-top">
							<spring:message code="search" />
						</button>
					</div>
		  		</div>
		    </form>
		</div> 
		<display:table name="resume" id="resume" requestURI="" pagesize="5">
			<display:column  style="width:100%"> 
				<div class="uk-panel uk-panel-box panel-box">
			  		<article style="margin-top:10px;">
						<h2>
							<c:out value="${resume.header}"/>
						</h2>
						<table style="margin-left:50px;">
							<tr>
								<td>
									<c:choose>
				    					<c:when test="${empty resume.photoUrl}">
				        					<img class="peopleImage" alt="${empty resume.contact.name}" src="<c:url value='/images/foto.jpg'/>">
				    					</c:when>
				    					<c:otherwise>
				    						<a href="http://rabota.e1.ru/pic/850/550/crop/${resume.photoUrl}" data-uk-lightbox title="">
				    							<img class="peopleImage" alt="${empty resume.contact.name}" src="<c:url value='http://rabota.e1.ru/pic/220/220/crop/${resume.photoUrl}'/>">
				    						</a>
				   					 	</c:otherwise>
									</c:choose>
								</td>
				    			<td style="margin-left:10px; width:100%">
								 	<dl class="uk-description-list-horizontal">
									    <dt data-uk-tooltip title="<c:out value="${resume.contact.name}"/>">
									    	<c:out value="${resume.contact.name}"/></dt>
    									<dd>
    										<s:eval expression="T(com.kandagar.rls.extension.Utils).pluralAge(resume.age)" var="age" />
								 			<c:out value="${age}"/>,
								 			<c:out value="${resume.info}"/>
										</dd>
									</dl>
								 	<c:choose>
					    				<c:when test="${not empty resume.salary}">
										 	<dl class="uk-description-list-horizontal">
											    <dt>Оклад</dt>
		    									<dd><c:out value="${resume.salary}"/></dd>
											</dl>
				    					</c:when>
									</c:choose>
									<c:choose>
				    					<c:when test="${not empty resume.skills}">
									 		<dl class="uk-description-list-horizontal">
											    <dt>Навыки:</dt>
		    									<dd><c:out value="${resume.skills}"/></dd>
											</dl>
				    					</c:when>
									</c:choose>
									<c:choose>
				    					<c:when test="${not empty resume.education.name}">
									 		<dl class="uk-description-list-horizontal">
											    <dt>Образование:</dt>
		    									<dd>
		    										<c:out value="${resume.education.name}"/>
		    										<c:choose>
				    									<c:when test="${not empty resume.educationDescription}">
		    												<c:out value="${resume.educationDescription}"/>
				    									</c:when>
													</c:choose>
		    									</dd>
											</dl>
				    					</c:when>
									</c:choose>
									<c:choose>
			    						<c:when test="${not empty resume.experienceLength.name}">
									 		<dl class="uk-description-list-horizontal">
											    <dt>Опыт работы:</dt>
		    									<dd>
		    										<c:out value="${resume.experienceLength.name}"/>
		    										<c:choose>
												 	<c:when test="${not empty resume.experience}">
					        							<c:out value="${resume.experience}"/> 
					    							</c:when>
					    							</c:choose>
		    									</dd>
											</dl>
			    						</c:when>
									</c:choose>
								 	<c:choose>
			    						<c:when test="${not empty resume.personalQualities}">
									 		<dl class="uk-description-list-horizontal">
											    <dt>Доп. информация:</dt>
		    									<dd>
		    										<c:out value="${resume.personalQualities}"/>
		    									</dd>
											</dl>
			    						</c:when>
									</c:choose>
									<div class="uk-text-muted uk-text-right uk-text-small">
					    				Создан: <a class="uk-text-muted link" href="javascript:void(0)">
					    							<fmt:formatDate value="${resume.addDate}" pattern="dd.MM.yyyy" />
					    						</a> | 
					    				Изменён: <a class="uk-text-muted link" href="javascript:void(0)">
					    							<fmt:formatDate value="${resume.modDate}" pattern="dd.MM.yyyy" />
					    						</a>
					    			</div>
								</td>
						 	</tr>
					 	</table>
		    		</article>
			  	</div>
			</display:column>
		</display:table>
	</body>
</html>
