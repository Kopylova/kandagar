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
 <div class="uk-panel uk-panel-box panel-box" id="filter">
                <!-- div class="form-column uk-form-stacked">
                    <div class="uk-form-row uk-form ">
                        <label class="uk-form-label" for="">Наименование</label>
                        <div class="uk-form-controls"><input class="uk-form-small uk-width-9-10" type="text"></div>
                    </div>
                    <div class="uk-form-row uk-form">
                        <label class="uk-form-label" for="">Описание</label>
                        <div class="uk-form-controls"><input class="uk-form-small uk-width-9-10" type="text"></div>
                    </div>
                    <div class="uk-form-row uk-form">
                        <label class="uk-form-label" for="">Автор</label>
                        <div class="uk-form-controls">
                            <select class="uk-form-small uk-width-9-10">
                                <option>Иванов И. И.</option>
                                <option>...</option>
                            </select>
                        </div>
                    </div>
                </div-->
                <!-- div class="uk-margin-small-left">
                    <div class="uk-grid uk-margin-top uk-width-1-3  tag-continer">
                        <div class="uk-form-controls uk-margin-small-top">
                            <i class="uk-icon-tags uk-margin-small-right"></i><a href="#">Название тэга</a><i class="uk-icon-times uk-margin-small-left"></i>
                        </div>
                    </div>
                    <div class="uk-grid uk-margin-top button-container uk-width-1-3 uk-text-right button-container">
                        <button class="uk-button uk-button-small  uk-margin-top">Сброс</button><button class="uk-button-primary uk-button uk-button-small uk-margin-top">Поиск</button>
                    </div>

                </div-->
                
                 <form action="<c:url value=''/>" method="get">
              <fieldset>
              <div class="uk-form-row uk-form">
		        	<label for="department"><spring:message code="workingType" />:</label>
				    <div class="uk-form-controls">
				    <form:select path="filter.workingTypeId" id="department"  class="uk-form-small uk-width-9-10">
						<form:option value="" label="" />
						<form:options items="${workingTypeList}" itemValue="id" itemLabel="title" />
				   	</form:select>
				   	</div>
				   	</div>
				   	<div class="uk-form-row uk-form">
				   	<label for="department"><spring:message code="education" />:</label>
				    <div class="uk-form-controls">
				    <form:select path="filter.educationId" id="department1" class="uk-form-small uk-width-9-10">
						<form:option value="" label="" />
						<form:options items="${educationList}" itemValue="id" itemLabel="title" />
				   	</form:select>
				   	</div>
				   	</div>
				   	<div class="uk-form-row uk-form">
				   	<label for="department"><spring:message code="rubrica" />:</label>
				   <div class="uk-form-controls">
				    <form:select path="filter.rubricaId" id="department2" class="uk-form-small uk-width-9-10">
						<form:option value="" label="" />
						<form:options items="${rubricaList}" itemValue="id" itemLabel="title" />
				   	</form:select>
				   	</div>
				   	</div>
					<div class="search-btn-grp"> 
						<button type="submit" class="uk-button-primary uk-button uk-button-small uk-margin-top">
								<spring:message code="search" />
						</button>
					</div>
              </fieldset>
           </form>
                
                 
            </div>
           
   <article>
		<div>
			<display:table name="resume" id="resume" requestURI="" pagesize="3" class="table table-striped">
				<display:column  style="width:100%" > 
				  <div class="uk-panel uk-panel-box panel-box">
				  <article style="margin-top:10px;">
					<h2> <c:out value="${resume.header}"/></h2>
					<table style="margin-left:50px;">
 						 <tr>
   							 <td>
   							 <c:choose>
			    				<c:when test="${empty resume.photoUrl}">
			        				<img class="peopleImage" alt="RLS" src="<c:url value='/images/foto.jpg'/>">
			    				</c:when>
			    				<c:otherwise>
			       					<img class="peopleImage" alt="RLS" src="<c:url value='http://rabota.e1.ru/pic/220/220/crop/${resume.photoUrl}'/>">
			   					 </c:otherwise>
								</c:choose>
   							 </td>
   							 <td style="margin-left:10px;">
   							 	<b> <c:out value="${resume.contact.name}"/></b>,
   							 	<c:out value="${resume.age}"/>
   							 	<br/>
   							 	<c:out value="${resume.info}"/>
   							 	<br/>
   							 	<br/>
   							 	<c:choose>
			    				<c:when test="${not empty resume.salary}">
			        				<b>Оклад:</b> <c:out value="${resume.salary}"/> <br/><br/>
			    				</c:when>
								</c:choose>
								<c:choose>
			    				<c:when test="${not empty resume.addDate}">
			        				<b>Дата добавления:</b> <c:out value="${resume.addDate}"/> <br/>
			    				</c:when>
								</c:choose>
								<c:choose>
			    				<c:when test="${not empty resume.modDate}">
			        				<b>Последнее редактирование:</b> <c:out value="${resume.modDate}"/> <br/><br/>
			    				</c:when>
								</c:choose>
								<c:choose>
			    				<c:when test="${not empty resume.skills}">
			        				<b>Навыки:</b> <c:out value="${resume.skills}"/> <br/>
			    				</c:when>
								</c:choose>
								<c:choose>
			    				<c:when test="${not empty resume.education.name}">
			        				<b>Образование:</b> <c:out value="${resume.education.name}"/> <br/>
			    				</c:when>
								</c:choose>
								<c:choose>
			    				<c:when test="${not empty resume.educationDescription}">
			        				<c:out value="${resume.educationDescription}"/> <br/><br/>
			    				</c:when>
								</c:choose>
   							 	<b>Опыт работы:</b> <c:out value="${resume.experienceLength.name}"/> <br/>
   							 	<c:choose>
   							 	<c:when test="${not empty resume.experience}">
			        				<c:out value="${resume.experience}"/> <br/><br/>
			    				</c:when>
								</c:choose>
   							 	<c:choose>
			    				<c:when test="${not empty resume.personalQualities}">
			        				<b>Дополнительная информация:</b> <br/>
   							 		<c:out value="${resume.personalQualities}"/> <br/>
			    				</c:when>
								</c:choose>
							</td>
  					 	</tr>
  					 	</table>
				    </article>
				    </div>
	    	 	</display:column>
			</display:table>
		</div> 
 </article>
</body>
</html>
