<% String title = "Change Password"; %>

<%@ include file = "./header.jsp" %>

<%
	Student aStudent = (Student)session.getAttribute("student");

	if(aStudent == null)
	{
		session.setAttribute("message", "Please login to access your dashboard.");
		response.sendRedirect("./login.jsp");
	}
	else 
	{
		session.setAttribute("message", "");
	}	
%>

<div class="container">

	<div class="row" style="margin-top:20px">
	    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form role="form" name="Input" method="post" action="./ChangePassword">
				<fieldset>
					<h2>Change Password</h2>
					<h1><%= message %></h1>
					<hr class="colorgraph">
					<div class="form-group">
	                    <input type="password" name="CurrentPassword" class="form-control input-lg" placeholder="Current Password">
					</div>
					<div class="form-group">
	                    <input type="password" name="NewPassword" class="form-control input-lg" placeholder="New Password">
					</div>
					<div class="form-group">
	                    <input type="password" name="ConfirmPassword" class="form-control input-lg" placeholder="Confirm Password">
					</div>					
	<!-- 				<span class="button-checkbox">
						<button type="button" class="btn" data-color="info">Remember Me</button>
	                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
						<a href="" class="btn btn-link pull-right">Forgot Password?</a>
					</span> -->
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
	                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Change Password">
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<a href="./dashboard.jsp" class="btn btn-lg btn-primary btn-block">Go Back to Dashboard</a>
						</div>
					</div>	
				</fieldset>
			</form>
		</div>
	</div>

	</div>


<%@ include file = "./footer.jsp" %>