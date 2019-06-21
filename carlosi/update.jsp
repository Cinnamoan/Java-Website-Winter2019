<%
	String theId = (String)session.getAttribute("ID");
	String firstName = (String)session.getAttribute("FirstName");
	String lastName = (String)session.getAttribute("LastName");
	String programCode = (String)session.getAttribute("ProgramCode");
	String programDescription = (String)session.getAttribute("ProgramDescription");
	String email = (String)session.getAttribute("Email");

	if (theId == null)
		theId = "";

	if (firstName == null)
		firstName = "";

	if (lastName == null)
		lastName = "";

	if (programCode == null)
		programCode = "";

	if (programDescription == null)
		programDescription = "";

	if (email == null)
		email = "";

%>

<% String title = "Update"; %>

<%@ include file = "./header.jsp" %>

<%
	Student aStudent = (Student)session.getAttribute("student");
	String errors = (String)session.getAttribute("errors");
	
	if(aStudent == null)
	{
		session.setAttribute("message", "Please login to update your information.");
		response.sendRedirect("./login.jsp");
		return;
	}
	else 
	{
		session.setAttribute("message", "");
		session.setAttribute("errors", "");
	}
	
%>

<h1><%= message %></h1>

<div class="row">

    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

		<form role="form" name="Input" method="post" action="./Update">

			<h2>Update Your Information</h2>

			<h1><%= errors %></h1>

			<hr class="colorgraph">

			
			<!-- First Name and Last Name -->
			<div class="row">
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
            
                        <input type="text" name="FirstName" value="<%= firstName %>" class="form-control input-lg" placeholder="First Name" tabindex="2">
			
					</div>
			
				</div>
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
			
						<input type="text" name="LastName" value="<%= lastName %>" id="last_name" class="form-control input-lg" placeholder="Last Name" tabindex="3">
			
					</div>
			
				</div>
			
			</div>

			<!-- Program Code and Program Description -->
			<div class="row">
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
            
                        <input type="text" name="ProgramCode" value="<%= programCode %>" class="form-control input-lg" placeholder="Program Code" tabindex="4">
			
					</div>
			
				</div>
			
				<div class="col-xs-12 col-sm-6 col-md-6">
			
					<div class="form-group">
			
						<input type="text" name="ProgramDescription"  value="<%= programDescription %>" id="last_name" class="form-control input-lg" placeholder="Program Description" tabindex="5">
			
					</div>
			
				</div>
			
			</div>

			<!-- Year -->
			<div class="row">
			
				<div class="col-xs-12 col-sm-15 col-md-15">
			
					<div class="form-group">

						<label for="Year">Year</label>
			
						<select class="form-control" name="Year">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
    					</select>
			
				    </div>
			
				</div>
			
			</div>
			
			<div>
				<div class="form-group">
				
					<input type="email" name="Email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="6">
				
				</div>
			</div>
			
			
			<hr class="colorgraph">
			
			<div class="row">
			
				<div class="col-xs-12 col-md-6"><input type="submit" value="Update" class="btn btn-primary btn-block btn-lg" tabindex="9"></div>
			
				<div class="col-xs-12 col-md-6"><a href="./dashboard.jsp" class="btn btn-success btn-block btn-lg" tabindex="10">Go Back to Dashboard</a></div>
			
			</div>
		
		</form>
	
	</div>

</div>

<%@ include file = "./footer.jsp" %>