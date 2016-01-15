<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row">
	<div class="col-md-12">
		<div id="login-box">
			<div id="login-box-holder">
				<div class="row">
					<div class="col-md-12">
						<header id="login-header">
							<div id="login-logo">
								<img alt="" src="<c:url value="/static/img/Joygame.png"/>">
							</div>
						</header>
						<div id="login-box-inner">
							<form role="form" name="f"
								action="<c:url value='j_spring_security_check'/>" method="POST">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<div class="input-group">
									<span class="input-group-addon"> <i class="fa fa-user"></i>
									</span> <input class="form-control" type="text" name="username"
										placeholder="user name">
								</div>
								<div class="input-group">
									<span class="input-group-addon"> <i class="fa fa-key"></i>
									</span> <input type="password" class="form-control" name="password"
										placeholder="password">
								</div>
								<div class="row">
									<div class="col-md-12">
										<button type="submit"
											class="btn btn-success col-md-6 pull-right" name="login">Login</button>
									</div>
								</div>
								<c:if test="${not empty error}">
									<div class="alert alert-danger" role="alert">
										<span class="glyphicon glyphicon-exclamation-sign"
											aria-hidden="true"></span> <span class="sr-only">Error:</span>
										Enter a valid user name and password
									</div>
								</c:if>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>