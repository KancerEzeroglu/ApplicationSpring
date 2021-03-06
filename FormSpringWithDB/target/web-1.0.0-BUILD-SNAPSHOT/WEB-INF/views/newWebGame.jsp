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
							<li><i class="fa fa-home"></i> <a
								href="<c:url value="/welcome" />">Home</a> <i
								class="fa fa-angle-right"></i></li>
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
							<form class="form-horizontal" role="form" id="newWebGameFo"
								modelAttribute="newWebGame">
								<errors path="*" cssClass="errorblock" element="div" />
								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Name</label>
									<div class="col-md-6">
										<input class="form-control" id="name" path="name" name="name"
											placeholder="Please enter game name"></input> <span
											class="help-block" id="nameErr"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="thumIm">Thumbnail
										Image</label>
									<div class="col-md-6">
										<input class="form-control" id="thumIm" path="thumIm"
											name="thumIm" placeholder="Please enter url"></input> <span
											class="help-block" id="thumImErr"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="view">View
										Order</label>
									<div class="col-md-6">
										<input class="form-control" id="view" path="view" name="view"
											placeholder="2"></input> <span class="help-block"
											id="viewErr"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="game">Game
										Url</label>
									<div class="col-md-6">
										<input class="form-control" id="game" path="game" name="game"
											placeholder="Please enter game url"></input> <span
											class="help-block" id="gameErr"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">Test Mode</label>
									<div class="col-md-6 checkbox checkbox-nice">
										<input type="checkbox" id="test" checked="checked" path="test"
											name="test"> <label for="test"></label> <span
											class="help-block" id="testErr"></span>
									</div>
								</div>
								<div class="col-lg-8">
									<div class="pull-right">
										<button type="submit" class="btn btn-success" id="create">
											<i class="fa fa-save"></i> Create
										</button>

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