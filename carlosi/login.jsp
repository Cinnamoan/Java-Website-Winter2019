<%   
	

	String login = (String)session.getAttribute("login");
	String errors = (String)session.getAttribute("errors");

	// String password = (String)session.getAttribute("password");

	
	if(login == null)
		login = "";
%>

<% String title = "Login"; %>

<%@ include file = "./header.jsp" %>

	<div class="container">

	<div class="row" style="margin-top:20px">
	    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form role="form" name="Input" method="post" action="./Login">
				<fieldset>
					<h2>Student Log In</h2>
					<h1><%= message %></h1>
					<h1><%= errors %></h1>
					<p>
						If you are a Durham College student, please enter your student ID and password to log in. <br><br>

						If you are not a student, please return to the <a href="./index.jsp">Durham College</a> home page.
					</p>
					<hr class="colorgraph">
					<div class="form-group">
	                    <input type="text" name="Login" value="<%= login %>" class="form-control input-lg" placeholder="Student ID">
					</div>
					<div class="form-group">
	                    <input type="password" name="Password" class="form-control input-lg" placeholder="Password">
					</div>
	<!-- 				<span class="button-checkbox">
						<button type="button" class="btn" data-color="info">Remember Me</button>
	                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
						<a href="" class="btn btn-link pull-right">Forgot Password?</a>
					</span> -->
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
	                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Log In">
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<a href="./register.jsp" class="btn btn-lg btn-primary btn-block">Register</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>

	</div>

<%@ include file = "./footer.jsp" %>