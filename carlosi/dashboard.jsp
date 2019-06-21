<% String title = "Dashboard"; %>

<%@ include file = "./header.jsp" %>

<%
	Student aStudent = (Student)session.getAttribute("student");

	
	if(aStudent == null)
	{
		session.setAttribute("message", "Please login to access your dashboard.");
		response.sendRedirect("./login.jsp");
		return;
	}
	else 
	{
		session.setAttribute("message", "");
	}
	
%>
	<h1><%= message %></h1>

	<p>
		Welcome <%= aStudent.getFirstName() %> <%= aStudent.getLastName() %>, this is your dashboard. This is where you will see the courses you are currently enrolled in, your marks for those courses, and your GPA.
	</p>

	<table align="center" bgcolor="lightgoldenrodyellow">
	<tr>
		<td width="200" align="Center">
			<a href="changepassword.jsp">
			<strong><font size="+1">Change Password</font></strong></a>
		</td>
	</tr>
	</table>

	<table align="center" bgcolor="lightgoldenrodyellow">
	<tr>
		<td width="200" align="Center">
			<a href="update.jsp">
			<strong><font size="+1">Update Information</font></strong></a>
		</td>
	</tr>
	</table>

<br/>


	<table align="center" bgcolor="lightgoldenrodyellow">
		<tr>
			<td width="100" align="Center">
				<a href="./Logout">
				<strong><font size="+1">Log Out</font></strong></a>
			</td>
		</tr>
	</table>

<%@ include file = "./footer.jsp" %>