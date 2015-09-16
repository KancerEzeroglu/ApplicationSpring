<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
	<div class="row" style="opacity: 1">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div id="content-header" class="clearfix">
						<ul class="breadcrumb">
							<li><i class="fa fa-home"></i> <a href="<c:url value="/welcome" />">Home</a>
								<i class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-gamepad"></i> <a
								href="<c:url value="/" />">Games</a> <i
								class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-cube"></i> New Web Game <i
								class="fa fa-angle-right"></i></li>

						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="main-box">
						<header class="main-box-header clearfix">
						<h2>New Web Game</h2>
						</header>
						<div class="main-box-body clearfix">
							<form class="form-horizontal" role="form" id="newPCGameForm">

								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Name</label>
									<div class="col-md-6">
										<input class="form-control" id="name"
											placeholder="Please enter game name"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Thumbnail
										Image</label>
									<div class="col-md-6">
										<input class="form-control" id="name"
											placeholder="Please enter url"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="name">View
										Order</label>
									<div class="col-md-6">
										<input class="form-control" id="name" placeholder="2"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Game
										Url</label>
									<div class="col-md-6">
										<input class="form-control" id="name"
											placeholder="Please enter game url"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">Test Mode</label>
									<div class="col-md-6 checkbox checkbox-nice">
										<input type="checkbox" id="test" checked="checked"> <label
											for="test"></label>
									</div>
								</div>
								<div class="col-lg-8">
									<div class="pull-right">
										<button type="submit" class="btn btn-success">Create</button>
									</div>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>





<%-- <li><i class="fa fa-search-plus"></i> <a
					href="<c:url value="/" />"> List Games</a> <i
					class="fa fa-angle-right"></i></li>

<li><i class="fa fa-bar-chart"></i> New Web Game</li> --%>

