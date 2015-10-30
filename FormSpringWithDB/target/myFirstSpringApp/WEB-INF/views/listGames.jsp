<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
	<div class="row" style="opacity: 1">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div id="content-header" class="clearfix">
						<ul class="breadcrumb">
							<li><i class="fa fa-home"></i><a
								href="<c:url value="/welcome" />">Home</a><i
								class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-gamepad"></i> <a
								href="<c:url value="/" />">Games</a> <i
								class="fa fa-angle-right"></i></li>
							<li><i class="fa fa-list"></i> List PC Games<i
								class="fa fa-angle-right"></i></li>

						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="main-box">
						<header class="main-box-header clearfix">
						<h2>List PC Games</h2>
						</header>
						<div class="main-box-body clearfix">
							<form class="form-horizontal" role="form" id="listGameForm"
								modelAttribute="listGames">

								<div class="form-group">
									<label class="col-md-2 control-label" for="name">Name</label>
									<div class="col-md-6 input-group">
										<input class="form-control" id="name" name="name" path="name"
											placeholder="Please enter your name"></input>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label" for="date">Created
										Date</label>
									<div class="input-group col-md-6">
										<span class="input-group-addon"> <i
											class="fa fa-calendar"></i>
										</span> <input type="text" class="form-control" id="date" name="date"
											path="date">
									</div>
									<div class="col-md-10 pull-right">
										<span class="help-block">format: mm-dd-yyyy</span>
									</div>
								</div>
								<div class="btn-group pull-right col-md-4">

									<div>
										<button type="submit" class="btn btn-success" id="search">
											<i class="fa fa-search"></i> Search
										</button>
									</div>
									<div>
										<a type="submit" class="btn btn-success" id="expCSV"
											href="download/sampleCsvFile"> <i class="fa fa-file"></i>
											Export CSV
										</a>
									</div>
									<div>
										<a type="submit" class="btn btn-success" id="expExcel"
											href="download/sampleExcelFile"> <i class="fa fa-file"></i>
											Export Excel
										</a>
									</div>
									<div>
										<a type="submit" class="btn btn-success" id="expPDF"
											href="download/samplePDFFile"> <i class="fa fa-file"></i>
											Export PDF
										</a>
									</div>

								</div>
								<div class="form-group">
									<div class="col-md-2"></div>
									<div class="input-group table-responsive col-md-6">
										<table class="table table-bordered" id="gameList">
											<thead>
												<tr>
													<th class="text-center"><span>Name</span></th>
													<th class="text-center"><span>Created Date</span></th>
													<th class="text-center"><span>Operations</span></th>
												</tr>

											</thead>

										</table>
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
