<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="main-menu" data-step='2'
		data-intro='This is the extendable Main Navigation Menu.'
		data-position='top'>
	<ul>
		<li><a href="."> <i class="icon-home nav-icon"></i> <span
				class="nav-text"> Dashboard </span>
		</a></li>
		<li class="has-subnav"><a href="javascript:;"> <i
				class="icon-laptop nav-icon"></i> <span class="nav-text">
					Loan </span> <i class="icon-angle-right"></i>
		</a>
			<ul>
				<li><a class="subnav-text"
					href="<%=request.getContextPath()%>/loan_controller?flag=loadtype">
						Apply for Loan </a></li>
				<li><a class="subnav-text"
					href="<%=request.getContextPath()%>/loan_controller?flag=loansrc">
						Loan Details </a></li>
			</ul></li>

		<li class="has-subnav"><a href="javascript:;"> <i
				class="icon-laptop nav-icon"></i> <span class="nav-text">
					Leave </span> <i class="icon-angle-right"></i>
		</a>
			<ul>
				<li><a class="subnav-text"
					href="<%=request.getContextPath()%>/leave_controller?flag=loadleave">
						Apply for Leave </a></li>
				<li><a class="subnav-text"
					href="<%=request.getContextPath()%>/leave_controller?flag=loadE">
						Leave Details </a></li>
			</ul></li>
		<li class="has-subnav"><a href="javascript:;"> <i
				class="icon-laptop nav-icon"></i> <span class="nav-text">
					Complaint </span> <i class="icon-angle-right"></i>
		</a>
			<ul>
				<li><a class="subnav-text"
					href="form_complaint.jsp">
						Post Complaint </a></li>
				<li><a class="subnav-text"
					href="<%=request.getContextPath()%>/complaint_controller?flag=load">
						Complaint Details </a></li>
			</ul></li>
	</ul>
	<ul class="logout">
		<li><a href="../Admin/login.jsp"> <i class="icon-off nav-icon"></i> <span
				class="nav-text"> Logout </span>
		</a></li>
	</ul>
	</nav>

</body>
</html>