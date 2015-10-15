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
							<li><i class="fa fa-home"></i><a
								href="<c:url value="/welcome" />">Home<i
									class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-gamepad"></i> <a
								href="<c:url value="/" />">Games</a> <i
								class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-cubes"></i> New PC Game <i
								class="fa fa-angle-right"></i></li>

						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="main-box">
						<header class="main-box-header clearfix">
						<h2>Create New PC Game</h2>
						</header>
						<div class="main-box-body clearfix">
							<form class="form-horizontal" role="form" id="newPCGameForm">

								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Name</label>
									<div class="col-md-6">
										<input class="form-control" id="name"
											placeholder="Please enter your name"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="cdn_url">CDN
										Url</label>
									<div class="col-md-6">
										<input class="form-control" id="cdn_url"
											placeholder="Please enter CDN Url"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="bgn_url">Background
										Image</label>
									<div class="col-md-6">
										<input class="form-control" id="bgn_url"
											placeholder="Please enter Background Image Url"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="tml_url">Thumbnail
										Image</label>
									<div class="col-md-6">
										<input class="form-control" id="tml_url"
											placeholder="Please enter Thumbnail Image Url"></input>
									</div>
								</div>
								<div class="form-group">
									<script type="text/javascript" src="static/jscolor/jscolor.js"></script>
									<label class="col-md-2 control-label" for="tmp_color">Template
										Color </label>
									<div class="col-md-6">
										<input class="color" value="ffffff">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">Desc</label>
									<div class="col-md-6 bs-example bs-example-tabs"
										data-example-id="togglable-tabs">
										<ul id="langTabs" class="nav nav-tabs" role="tablist">
											<li role="presentation" class="active"><a
												href="#turkish" id="turkish-tab" role="tab"
												data-toggle="tab" aria-controls="turkish"
												aria--expanded="true">Turkish</a></li>
											<li role="presentation" class><a href="#english"
												id="english-tab" role="tab" data-toggle="tab"
												aria-controls="english" aria--expanded="true">English</a></li>
											<li role="presentation" class><a href="#arabic"
												id="arabic-tab" role="tab" data-toggle="tab"
												aria-controls="arabic" aria--expanded="true">Arabic</a></li>
										</ul>
										<div id="langTabsContent" class="tab-content">
											<div role="tabpanel" class="tab-pane fade active in"
												id="turkish" aria-labelledby="turkish-tab">
												<textarea rows="3" class="form-control" id="turkishArea">Turkish text here</textarea>
											</div>
											<div role="tabpanel" class="tab-pane fade" id="english"
												aria-labelledby="english-tab">
												<textarea rows="3" class="form-control" id="turkishArea">English text here</textarea>
											</div>
											<div role="tabpanel" class="tab-pane fade" id="arabic"
												aria-labelledby="arabic-tab">
												<textarea rows="3" class="form-control" id="turkishArea">Arabic text here</textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Video</label>
									<div class="col-md-6">
										<input class="form-control" id="video"
											placeholder="Please enter video url"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">Test Mode</label>
									<div class="col-md-6 checkbox checkbox-nice">
										<input type="checkbox" id="test" checked="checked"> <label
											for="test"></label>
									</div>
								</div>

								<!-- ScreenShots area -->


								<div class="form-group">
									<label class="col-md-2 control-label" for="field1">ScreenShots</label>
									<div class="controls col-md-6">
										<div class="entry input-group col-md-6">
											<input class="form-control" id="screenshot" name="fields[]" type="text"
												placeholder="Type something" /> 
												<span
												class="input-group-btn">
												<button class="btn btn-success btn-add" type="button">
													<span class="glyphicon glyphicon-plus"></span>
												</button>
											</span>
										</div>
										
									</div>
								</div>


								<!-- END ScreenShots area -->

								<div class="form-group">
									<label class="col-md-2 control-label" for="viewOrder">View
										Order</label>
									<div class="col-md-6">
										<input class="form-control" id="viewOrder" placeholder="2"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="insDic">Install
										Directory</label>
									<div class="col-md-6">
										<input class="form-control" id="insDic" placeholder="C:/games"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="regKey">Registery
										Key</label>
									<div class="col-md-6">
										<input class="form-control" id="regKey"
											placeholder="Software\Softnyx\"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="laExPath">Launch
										Exe Path</label>
									<div class="col-md-6">
										<input class="form-control" id="laExPath" placeholder="2"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="twitter">Twitter</label>
									<div class="col-md-6">
										<input class="form-control" id="twitter" placeholder="2"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="facebook">Facebook</label>
									<div class="col-md-6">
										<input class="form-control" id="facebook" placeholder="2"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="youtube">Youtube</label>
									<div class="col-md-6">
										<input class="form-control" id="youtube" placeholder="2"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="google">Google+</label>
									<div class="col-md-6">
										<input class="form-control" id="" google"" placeholder="2"></input>
									</div>
								</div>
								<div class="col-lg-10">
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

