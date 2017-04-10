<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="main-menu" data-step='2' data-intro='This is the extendable Main Navigation Menu.' data-position='top'>
            <ul>
                <li>
                    <a href=".">
                        <i class="icon-home nav-icon"></i>
                        <span class="nav-text">
                            Dashboard
                        </span>
                    </a>
                </li>
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-laptop nav-icon"></i>
                        <span class="nav-text">
                        	Manage Candidate
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/reg_controller?flag=loadcountry">
                                Add Candidate
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/reg_controller?flag=load">
                                Search Candidate
                            </a>
                        </li>
                       
                    </ul>
                </li>
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-list nav-icon"></i>
                        <span class="nav-text">
                            Manage Exam
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>

                        <li>
                            <a class="subnav-text" href="form_examtype.jsp">
                                Add ExamType
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/etype_controller?flag=load">
                                Search ExamType
                            </a>
                        </li>
                        
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/exam_controller?flag=loadetype">
                                Add Exam
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/exam_controller?flag=load">
                                Search Exam
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-folder-open nav-icon"></i>
                        <span class="nav-text">
                            Manage Questions 
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/que_controller?flag=loadsub">
                           	Add Questions
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/que_controller?flag=load">
                                Search Questions
                            </a>
                        </li>
                        
                    </ul>
                </li>
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-folder-open nav-icon"></i>
                        <span class="nav-text">
                            Manage Categories 
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/cat_controller?flag=loadetype">
                                Add Category
                            </a>
                        </li>
                        
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/cat_controller?flag=load">
                                Search Category
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/subcat_controller?flag=loadetype">
                                Add Subcategory
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/subcat_controller?flag=load">
                                Search Subcategory
                            </a>
                        </li>
                    </ul>
                </li>
                
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-folder-open nav-icon"></i>
                        <span class="nav-text">
                            Manage Country 
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>
                        <li>
                            <a class="subnav-text" href="form_country.jsp">
                           	Add Country
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/country_controller?flag=load">
                                Search Country
                            </a>
                        </li>
                    </ul>
                </li>
                
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-folder-open nav-icon"></i>
                        <span class="nav-text">
                            Manage State 
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/state_controller?flag=loadcnt">
                           	Add State
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/state_controller?flag=load">
                                Search State
                            </a>
                        </li>
                    </ul>
                </li>
                
                <li class="has-subnav">
                    <a href="javascript:;">
                        <i class="icon-folder-open nav-icon"></i>
                        <span class="nav-text">
                            Manage City 
                        </span>
                        <i class="icon-angle-right"></i>
                    </a>
                    <ul>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/city_controller?flag=loadCnt">
                           	Add City
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/city_controller?flag=load">
                                Search City
                            </a>
                        </li>
                    </ul>
                </li>
                
                
                <li>
                    <a href="manage_result.jsp">
                        <i class="icon-table nav-icon"></i>
                        <span class="nav-text">
                            Manage Result
                        </span>
                    </a>
                </li>
                <li>
                    <a href="manage_interview.jsp">
                        <i class="icon-table nav-icon"></i>
                        <span class="nav-text">
                            Manage Interview
                        </span>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="icon-bar-chart nav-icon"></i>
                        <span class="nav-text">
                            Manage Employee
                        </span>
						<i class="icon-angle-right"></i>
                    </a>
 		    		<ul>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/emp_controller?flag=loadcsc">
                         	Add Employee
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/emp_controller?flag=load">
                                Search Employee
                            </a>
                        </li>
                        
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="icon-font nav-icon"></i>
                        <span class="nav-text">
                            Manage Leave
                        </span>
						<i class="icon-angle-right"></i>
                    </a>
		    		<ul>
                        <li>
                            <a class="subnav-text" href="form_leavemst.jsp">
                         	Add Leave
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/leave_controller?flag=load">
                                Search Leave
                            </a>
                        </li>
                        
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="icon-table nav-icon"></i>
                        <span class="nav-text">
                            Manage Loan
                        </span>
						<i class="icon-angle-right"></i>
                    </a>
 		    		<ul>
                        <li>
                            <a class="subnav-text" href="form_loandtl.jsp">
                         	Add Loan
                            </a>
                        </li>
                        <li>
                            <a class="subnav-text" href="<%=request.getContextPath() %>/loan_controller?flag=load">
                                Search Loan
                            </a>
                        </li>
                        
                    </ul>
                </li>
                <li>
                    <a href="manage_complaint.jsp">
                        <i class="icon-table nav-icon"></i>
                        <span class="nav-text">
                            Manage Complaint
                        </span>
                    </a>
                </li>
                <li>
                    <a href="view_attendance.jsp">
                        <i class="icon-table nav-icon"></i>
                        <span class="nav-text">
                            View Attendance
                        </span>
                    </a>
                </li>
                <li>
                    <a href="exam_controller?flag=exam">
                        <i class="icon-table nav-icon"></i>
                        <span class="nav-text">
                            Generate Exam
                        </span>
                    </a>
                </li>
                </ul>
                

            <ul class="logout">
                <li>
                    <a href="login.jsp">
                        <i class="icon-off nav-icon"></i>
                        <span class="nav-text">
                            Logout
                        </span>
                    </a>
                </li>  
            </ul>
        </nav>
        
</body>
</html>