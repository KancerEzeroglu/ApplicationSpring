<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section id="col-left" class="col-left-nano">
	<div id="col-left-inner" class="col-left-nano-content">
		<div class="collapse navbar-collapse navbar-ex1-collapse"
			id="sidebar-nav">
			<ul class="nav nav-pills nav-stacked">
				<li class="nav-header nav-header-first hidden-sm hidden-xs">
					Menu</li>
				<li><a href="#" class="dropdown-toggle"> <i
						class="fa fa-gamepad"></i> <span>Games</span> <i
						class="fa fa-angle-right drop-icon"></i>
				</a>
					<ul class="submenu">
						<li><a href="<c:url value="/listGames" />"> List Games </a></li>
						<li><a href="<c:url value="/newPCGame" />"> New PC Game </a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="<c:url value="/newWebGame" />"> New Web Game </a></li></sec:authorize>
					</ul></li>
				<li><a href="#" class="dropdown-toggle"> <i
						class="fa fa-bullhorn"></i> <span>Announcements</span> <i
						class="fa fa-angle-right drop-icon"></i>
				</a>
					<ul class="submenu">
						<li><a href="email-inbox.html"> List Announcements </a></li>
						<li><a href="email-detail.html"> New Announcements </a></li>
					</ul></li>
				<li><a href="#" class="dropdown-toggle"> <i
						class="fa fa-flag"></i> <span>Banners</span> <i
						class="fa fa-angle-right drop-icon"></i>
				</a>
					<ul class="submenu">
						<li><a href="#"> List Banners</a></li>
						<li><a href="<c:url value="/newBanner" />"> New Banner </a></li>
					</ul></li>
				
				
			</ul>
		</div>
	</div>
</section>
<div id="nav-col-submenu"></div>
