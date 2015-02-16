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
	<link media="all" type="text/css" href="<c:url value='/styles/uikit.almost-flat.css'/>" rel="stylesheet">
	<link media="all" type="text/css" href="<c:url value='/styles/main.css'/>" rel="stylesheet">    
	<script type="text/javascript" src="<c:url value='/scripts/jquery-1.8.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/uikit.js'/>"></script>
</head>
<body style="background-image: url('images/bg7.png'); background-color:#c5c9ca;background-repeat: no-repeat;">
        <nav class="uk-navbar uk-navbar-attached tm-nav fixed">
            <div class="uk-container uk-container-center">
               	<div class="uk-grid">
                    <div class="uk-width-1-2">
                        <div class="uk-button-dropdown sort-column" data-uk-dropdown="{mode:'click'}">
                            <label class="uk-form-label form-label">Сортировать по:</label>
                            <button class="uk-button">дате создания (по убыванию)<i class="uk-icon-caret-down"></i></button>
                            <div class="uk-dropdown">
                                <ul class="uk-nav uk-nav-dropdown">
                                    <li><a href="#">дате создания</a></li>
                                    <li><a href="#">дате изменения</a></li>
                                </ul>
                            </div>
                        </div>
                        <button class="uk-button uk-icon-history icon-calendar" title="Список событий"></button>
                        <button class="uk-button uk-icon-filter filter-button" title="Фильтр" id="filter-button"></button>
                    	
                    </div>  
                    <div class="uk-width-1-2" align="right">
                	 	<div class="user-login"><i class="uk-icon-user user-icon"></i>
                        	<a id="logonForm" href="<c:url value='/admin/index'/>" >
                				<sec:authorize access="isAuthenticated()">
        							<spring:message code="admin"/>
   								</sec:authorize>
  								<sec:authorize access="!isAuthenticated()">
   									<spring:message code="logon"/>
    							</sec:authorize>
    						</a>
    					</div>
                 	</div>
                </div>
                <!-- <div class="uk-form uk-grid uk-margin-small-top">
                    <div class="uk-width-5-10">
                        <input type="text" placeholder="Наименование" class="uk-form-small">
                        <input type="text" placeholder="Описание" class="uk-form-small">
                        <select class="uk-form-small uk-width-2-10">
                            <option>Автор</option>
                            <option>...</option>
                        </select>
                        <select class="uk-form-small uk-width-2-10">
                            <option>Тег</option>
                            <option>...</option>
                        </select>
                    </div>
                    <div class="uk-width-1-4 uk-margin-small-left button-container">
                        <button class="uk-button-primary uk-button uk-button-small">Фильтровать</button>
                        <button class="uk-button-danger uk-button uk-button-small">Сбросить фильтр</button>
                    </div>
                </div> -->
            </div>
        </nav>
        <div class="uk-container uk-container-center container">
            <decorator:body />
            

            

             
        </div>

        <script>
        $(function() {
            $('#filter-button').on('click', function() {
                $(this).toggleClass('filter_active');
                $('#filter').toggle();
            });
        })()

        </script>
   </body>
</html>