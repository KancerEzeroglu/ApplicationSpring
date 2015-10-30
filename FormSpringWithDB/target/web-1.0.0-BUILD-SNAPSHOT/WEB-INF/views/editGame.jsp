<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
	<div class="row" style="opacity: 1">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div id="content-header" class="clearfix">
						<ul class="breadcrumb">
							<li><i class="fa fa-home"></i> <a
								href="<c:url value="/welcome" />"> Home</a> <i
								class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-gamepad"></i> <a
								href="<c:url value="/" />"> Games</a> <i
								class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-pencil-square-o"></i> Edit Game <i
								class="fa fa-angle-right"></i></li>

						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="main-box">
						<header class="main-box-header clearfix">
						<h2>Edit Game</h2>
						</header>
						<div class="main-box-body clearfix">
							<form:form class="form-horizontal" role="form" id="editGameForm"
								modelAttribute="game">

								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Name</label>
									<div class="col-md-6">
										<form:input class="form-control" id="name" path="name"
											name="name"></form:input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="thumIm">Thumbnail
										Image</label>
									<div class="col-md-6">
										<form:input class="form-control" id="thumIm" path="thumIm"
											name="thumIm" placeholder="Please enter url"></form:input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="view">View
										Order</label>
									<div class="col-md-6">
										<form:input class="form-control" id="view" path="view"
											name="view" placeholder="2"></form:input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="game">Game
										Url</label>
									<div class="col-md-6">
										<form:input class="form-control" id="game" path="game"
											name="game"></form:input>
									</div>

								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">Test Mode</label>
									<div class="col-md-9 checkbox-nice">
										<input type="checkbox" id="test" path="test" name="test" <c:if test="${game.test}">checked="checked"</c:if>></input>
										<label for="test"></label>
									</div>
								</div>
								<div class="col-lg-8">
									<div class="pull-right">
										<button type="submit" class="btn btn-success" id="update">
											<i class="fa fa-save"></i> Update
										</button>

									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
