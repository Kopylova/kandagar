<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>

<html>
<head>
	<title>RLS</title>
	<link href="<c:url value='/images/user-icon.png'/>" rel="shortcut icon" />
	<meta charset="utf-8">  
	<link media="all" type="text/css" href="<c:url value='/styles/reset.css'/>" rel="stylesheet">
	<link media="all" type="text/css" href="<c:url value='/styles/uikit.almost-flat.css'/>" rel="stylesheet">
	<link media="all" type="text/css" href="<c:url value='/styles/main.css'/>" rel="stylesheet">   
	<script type="text/javascript" src="<c:url value='/scripts/jquery-1.8.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/uikit.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/addons/sticky.js'/>"></script>
	
	<script type="text/javascript" src="<c:url value='/scripts/addons/lightbox.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/jquery.cookie.min.js'/>"></script>
</head>
<body style="background-image: url('images/bg7.png'); background-color:#c5c9ca;background-repeat: no-repeat;">
        <nav class="uk-navbar uk-navbar-attached tm-nav fixed">
            <div class="uk-container uk-container-center">
               	<div class="uk-grid">
                    <div class="uk-width-1-2">
                	 	<a href="<c:url value='/'/>">
                	 		<img border="0" width="150" style="height:50px !important" title="Екатеринбург Он-Лайн" 
                	 			alt="Екатеринбург Он-Лайн" src="images/e1.jpg">
                	 	</a>
                 	</div>
                    <div class="uk-width-1-2" align="right">
                        <div class="uk-button-dropdown sort-column" data-uk-dropdown="{mode:'click'}">
                            <label class="uk-form-label form-label">Сортировать по:</label>
                            <button class="uk-button">
                            	<c:choose>
				    					<c:when test="${filter.sortColumn eq 'modDate'}">
				        					дате изменения (по убыванию)
				    					</c:when>
				    					<c:otherwise>
				       						дате создания (по убыванию)
				   					 	</c:otherwise>
									</c:choose>
                            	<i class="uk-icon-caret-down"></i>
                            </button>
                            <div id="sortBy" class="uk-dropdown uk-dropdown-small">
                            	<ul class="uk-nav uk-nav-dropdown sort">
                                	<li class="uk-nav-header">
                                    	<i class="uk-icon-calendar-o"></i>Дата создания
                                    </li>
                                    <li>
                                    	<a href="javascript:void(0)" data-column="addDate" data-direction="Descending">
                                        	 <i class="uk-icon-caret-down"></i>по убыванию
                                        </a>
                                   </li>
                                   <li class="uk-nav-header">
                                   		<i class="uk-icon-calendar-o"></i>Дата обновления
                                   </li>
                                   <li>
                                   		<a href="javascript:void(0)" data-column="modDate" data-direction="Descending">
                                        	<i class="uk-icon-caret-down"></i>по убыванию
                                        </a>
                                   </li>
                              	</ul>
                        	</div>
                        </div>
                        <button id="admin-btn" class="uk-button uk-icon-cog" title="Администрирование" data-uk-tooltip></button>
                        <button id="filter-btn" class="uk-button uk-icon-filter filter-button" title="Фильтр" data-uk-tooltip></button>
                    </div>  
                    
                </div>
            </div>
        </nav>
        <div class="uk-container uk-container-center container">
            <decorator:body />           
        </div>
        <script type="text/javascript">
        $(function() {
        	var filter = $.cookie('main_filter');
            if (filter && filter === "1") {
            	$('#filter').show();
            }
            $('#filter-btn').on('click', function() {
                $(this).toggleClass('filter_active');
                $('#filter').toggle();
                $.cookie('main_filter', ($('#filter').is(":visible") ? 1 : 0), { expires: 365 });
            });
            $('#admin-btn').on('click', function() {
                location.href="<c:url value='/admin/index'/>";
            });
            $('#sortBy li a').on('click', function() {
                $('#sortColumn').val($(this).data('column'));
                $('form').submit();
            });
        });

        </script>
   </body>
</html>