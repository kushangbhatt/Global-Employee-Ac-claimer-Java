<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7 lt-ie10"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8 lt-ie10"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9 lt-ie10"> <![endif]-->
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>GEA - Dashboard</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

<link rel="stylesheet" href="Css/92bc1fe4.bootstrap.css">

<!-- Page-specific Plugin CSS: -->
<link rel="stylesheet" href="Css/jquery.pnotify.default.css">
<link rel="stylesheet" href="Css/select2.css">


<!-- Proton CSS: -->
<link rel="stylesheet" href="Css/aaf5c053.proton.css">
<link rel="stylesheet" href="Css/animate.css">

<!-- adds CSS media query support to IE8   -->
<!--[if lt IE 9]>
            <script src="Js/html5shiv.js"></script>
            <script src="scripts/vendor/respond.min.js"></script>
        <![endif]-->

<!-- Fonts CSS: -->
<link rel="stylesheet" href="Css/6227bbe5.font-awesome.css"
	type="text/css" />
<link rel="stylesheet" href="Css/40ff7bd7.font-titillium.css"
	type="text/css" />

<!-- Common Scripts: -->
<script>
	(function() {
		var js;
		if (typeof JSON !== 'undefined' && 'querySelector' in document
				&& 'addEventListener' in window) {
			js = 'Js/jquery.min.js';
		} else {
			js = 'Js/jquery.min.js';
		}
		document.write('<script src="' + js + '"><\/script>');
	}());
</script>
<script src="Js/modernizr.js"></script>
<script src="Js/jquery.cookie.js"></script>
</head>

<body class="dashboard-page">

	<script>
		var theme = $.cookie('protonTheme') || 'default';
		$('body').removeClass(function(index, css) {
			return (css.match(/\btheme-\S+/g) || []).join(' ');
		});
		if (theme !== 'default')
			$('body').addClass(theme);
	</script>
	<!--[if lt IE 8]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->



	<jsp:include page="menu.jsp"></jsp:include>

	<section class="wrapper scrollable">

		<nav class="user-menu">
			<a href="javascript:;" class="main-menu-access"> <i
				class="icon-proton-logo"></i> <i class="icon-reorder"></i>
			</a>
			<section class="user-menu-wrapper">
				<a href="javascript:;" data-expand=".theme-view"
					class="view-menu-access"> <i class="icon-eye-open"></i>
				</a> <a href="javascript:;" data-expand=".messages-view"
					class="messages-access"> <i class="icon-envelope-alt"></i>
				</a> <a href="javascript:;" data-expand=".notifications-view"
					class="notifications-access unread"> <i
					class="icon-comment-alt"></i>
					<div class="menu-counter">6</div>
				</a>
			</section>

			<div class="panel panel-default nav-view theme-view">
				<div class="arrow user-menu-arrow"></div>
				<div class="panel-heading">
					<i class="icon-eye-open"></i> <span>Color Scheme</span> <a
						href="javascript:;" class="close-user-menu"><i
						class="icon-remove"></i></a>
				</div>
				<ul class="list-group">
					<li class="list-group-item" data-theme="default"><a
						href="javascript:;"> <i><b class="dark"></b></i>
							<div class="text-holder">
								<span class="title-text"> Dark </span>
							</div>
					</a></li>
				</ul>
			</div>

			<div class="panel panel-default nav-view messages-view">
				<div class="arrow user-menu-arrow"></div>
				<div class="panel-heading">
					<i class="icon-envelope-alt"></i> <span>Messages</span> <a
						href="javascript:;" class="close-user-menu"><i
						class="icon-remove"></i></a>
				</div>
				<ul class="list-group">
					<c:forEach items="${sessionScope.loanlist }" var="i">
						<ul class="list-group pending">
							<li class="list-group-item"><i><img
									src="Images/user1.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> ${i.ev.name } </span> <span
										class="description-text"> Applied for ${i.lv.loan_type }.
									</span>
								</div> <span class="stat-value"> 5 mins ago </span></li>
						</ul>
					</c:forEach>
				</ul>
			</div>

			<div class="panel panel-default nav-view notifications-view">
				<div class="arrow user-menu-arrow"></div>
				<div class="panel-heading">
					<i class="icon-comment-alt"></i> <span>Notification</span> <a
						href="javascript:;" class="close-user-menu"><i
						class="icon-remove"></i></a>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><i><img src="Images/user1.jpg"
							alt="User Icon"></i>
						<div class="text-holder">
							<span class="title-text"> </span> <span class="description-text">
								likes your website. </span>
						</div> <span class="time-ago"> 32 mins ago </span></li>
					<li class="list-group-item"><i><img src="Images/user2.jpg"
							alt="User Icon"></i>
						<div class="text-holder">
							<span class="title-text"> Flor Demoa </span> <span
								class="description-text"> wrote a new post. </span>
						</div> <span class="time-ago"> 3 hrs ago </span></li>
					<li class="list-group-item"><i><img src="Images/user4.jpg"
							alt="User Icon"></i>
						<div class="text-holder">
							<span class="title-text"> Nunc Neque </span> <span
								class="description-text"> wrote a new post. </span>
						</div> <span class="time-ago"> 57 mins ago </span></li>
					<li class="list-group-item"><i><img src="Images/user2.jpg"
							alt="User Icon"></i>
						<div class="text-holder">
							<span class="title-text"> Flor Demoa </span> <span
								class="description-text"> submitted a new ticket. </span>
						</div> <span class="time-ago"> 1.5 hrs ago </span></li>
					<li class="list-group-item"><i><img src="Images/user1.jpg"
							alt="User Icon"></i>
						<div class="text-holder">
							<span class="title-text"> Nunc Cenenatis </span> <span
								class="description-text"> wrote a new post. </span>
						</div> <span class="time-ago"> 3 hrs ago </span></li>
				</ul>
			</div>
		</nav>
		<section class="title-bar">
			<div>
				<span>DASHBOARD</span>
				<nav class="dashboard-menu">
					<a href="javascript:;"> <i class="icon-cog toggle-widget-setup"></i>
						<i class="menu-state-icon icon-sort-up"></i> <i
						class="menu-state-icon icon-caret-down active"></i>
					</a>
					<ul>

						<li><a data-toggle="modal" href="#quickLaunchModal">Add
								Quick Launch Icon</a></li>
						<li><a data-toggle="modal" href="#quickLaunchModal">Remove
								Quick Launch Icon</a></li>
						<li><a href="javascript:;">Third Menu Item</a></li>
					</ul>
				</nav>
			</div>
		</section>
		<nav class="quick-launch-bar">
			<ul>
				<li><a href="javascript:;"> <i class="icon-bar-chart"></i>
						<span>Graphs</span>
				</a></li>
				<li><a href="javascript:;"> <i class="icon-calendar-empty"></i>
						<span>Calendar</span>
				</a></li>
				<li><a href="javascript:;"> <i class="icon-map-marker"></i>
						<span>Maps</span>
				</a></li>
				<li><a href="javascript:;"> <i class="icon-cloud"></i> <span>Cloud</span>
				</a></li>
				<li><a href="javascript:;"> <i class="icon-microphone"></i>
						<span>Conference</span>
				</a></li>
			</ul>
			<a data-toggle="modal" href="#quickLaunchModal"
				class="add-quick-launch"><i class="icon-plus"></i></a>
		</nav>
		<section class="widget-group">
			<div id="messages-widget" class="proton-widget messages">
				<div class="panel panel-default back">
					<div class="panel-heading">
						<i class="icon-cog"></i> <span>Settings</span>
						<div class="toggle-widget-setup">
							<i class="icon-ok"></i> <span>DONE</span>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Location</label>
								<div>
									<select class="select2">
										<option selected="" value="Any">Any</option>
										<option value="Europe">Europe</option>
										<option value="Asia">Asia</option>
										<option value="North America">North America</option>
										<option value="Other">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Time</label>
								<div>
									<select class="select2">
										<option>Any</option>
										<option>Last Hour</option>
										<option>Today</option>
										<option selected="">This Week</option>
										<option>This Month</option>
										<option>This Year</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel panel-success front">
					<div class="panel-heading">
						<i class="icon-envelope-alt"></i> <span>Loan</span> <i
							class="icon-cog toggle-widget-setup"></i>
					</div>
					<div>

						<ul class="list-group pending">
							<li class="list-group-item">
							<c:forEach items="${sessionScope.loanlist }" var="i">
									<i><img src="Images/user1.jpg" alt="User Icon"></i>
									<div class="text-holder">
										<span class="title-text"> ${i.ev.name } </span> <span
											class="description-text"> Applied for ${i.lv.loan_type }.
										</span>
									</div>
									<span class="stat-value"> 5 mins ago </span>
								</c:forEach></li>
						</ul>

					</div>
				</div>
			</div>



			<div id="general-stats-widget" class="proton-widget general-stats">
				<div class="panel panel-default back">
					<div class="panel-heading">
						<i class="icon-cog"></i> <span>Settings</span>
						<div class="toggle-widget-setup">
							<i class="icon-ok"></i> <span>DONE</span>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Location</label>
								<div>
									<select class="select2">
										<option value="Any">Any</option>
										<option selected="" value="Europe">Europe</option>
										<option value="Asia">Asia</option>
										<option value="North America">North America</option>
										<option value="Other">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Time</label>
								<div>
									<select class="select2">
										<option>Any</option>
										<option>Last Hour</option>
										<option>Today</option>
										<option>This Week</option>
										<option>This Month</option>
										<option selected="">This Year</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel panel-primary front">
					<div class="panel-heading">
						<i class="icon-sort"></i> <span>General Stats</span> <i
							class="icon-cog toggle-widget-setup"></i>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="text-holder">
								<span class="title-text"> 2,511 </span> <span
									class="description-text"> Registered Users </span>
							</div> <span class="stat-value"> + 0.6% <i class="icon-sort-up"></i>
						</span>
						</li>
						<li class="list-group-item">
							<div class="text-holder">
								<span class="title-text"> $1,132 </span> <span
									class="description-text"> Revenue </span>
							</div> <span class="stat-value"> + 2.1% <i class="icon-sort-up"></i>
						</span>
						</li>
						<li class="list-group-item">
							<div class="text-holder">
								<span class="title-text"> 53 </span> <span
									class="description-text"> Viking Users </span>
							</div> <span class="stat-value"> 0% <i class="icon-sort"></i>
						</span>
						</li>
						<li class="list-group-item">
							<div class="text-holder">
								<span class="title-text"> 24 </span> <span
									class="description-text"> Donuts consumed </span>
							</div> <span class="stat-value"> - 6.5% <i
								class="icon-sort-down"></i>
						</span>
						</li>
						<li class="list-group-item">
							<div class="text-holder">
								<span class="title-text"> 312 </span> <span
									class="description-text"> Orders Received </span>
							</div> <span class="stat-value"> + 12.1% <i class="icon-sort-up"></i>
						</span>
						</li>
					</ul>
				</div>
			</div>



			<div id="latest-users-widget" class="proton-widget latest-users">
				<div class="panel panel-default back">
					<div class="panel-heading">
						<i class="icon-cog"></i> <span>Settings</span>
						<div class="toggle-widget-setup">
							<i class="icon-ok"></i> <span>DONE</span>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Location</label>
								<div>
									<select class="select2">
										<option selected="" value="Any">Any</option>
										<option value="Europe">Europe</option>
										<option value="Asia">Asia</option>
										<option value="North America">North America</option>
										<option value="Other">Other</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel panel-info front">
					<div class="panel-heading">
						<i class="icon-flag"></i> <span>Latest Users</span> <i
							class="icon-cog toggle-widget-setup"></i>
					</div>
					<div>
						<ul class="list-group pending">
							<li class="list-group-item"><i><img
									src="Images/user3.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> Etiam Libero </span>
								</div> <span class="stat-value"> a minut ago </span></li>
							<li class="list-group-item"><i><img
									src="Images/user2.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> Flor Demoa </span>
								</div> <span class="stat-value"> 12 hours ago </span></li>
							<li class="list-group-item"><i><img
									src="Images/user5.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> Prasent Neque </span>
								</div> <span class="stat-value"> 2 days ago </span></li>
							<li class="list-group-item"><i><img
									src="Images/user1.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> Nunc Cenenatis </span>
								</div> <span class="stat-value"> 5 days ago </span></li>
							<li class="list-group-item"><i><img
									src="Images/user4.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> Morbi Demoa </span>
								</div> <span class="stat-value"> 11 days ago </span></li>
							<li class="list-group-item"><i><img
									src="Images/user2.jpg" alt="User Icon"></i>
								<div class="text-holder">
									<span class="title-text"> Sel Drvenar </span>
								</div> <span class="stat-value"> 11 days ago </span></li>
						</ul>
					</div>
				</div>
			</div>



			<div id="task-completion-widget"
				class="proton-widget task-completion">
				<div class="panel panel-default back">
					<div class="panel-heading">
						<i class="icon-cog"></i> <span>Settings</span>
						<div class="toggle-widget-setup">
							<i class="icon-ok"></i> <span>DONE</span>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Origin</label>
								<div>
									<select class="select2">
										<option value="Any">Any</option>
										<option value="Europe">Europe</option>
										<option value="Asia">Asia</option>
										<option selected="" value="North America">North
											America</option>
										<option value="Other">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Time</label>
								<div>
									<select class="select2">
										<option>Any</option>
										<option>Last Hour</option>
										<option>Today</option>
										<option>This Week</option>
										<option selected="">This Month</option>
										<option>This Year</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel panel-info front">
					<div class="panel-heading">
						<i class="icon-ok"></i> <span>Task Completion</span> <i
							class="icon-cog toggle-widget-setup"></i>
					</div>
					<ul class="list-group">
						<li class="sub-list">
							<ul>
								<li class="list-group-item"><span class="title-text">
										Processed orders </span> <span class="processed-value"> 56 </span></li>
								<li class="list-group-item"><span class="title-text">
										Pending orders </span> <span class="processed-value"> 14 </span></li>
								<li class="list-group-item"><span class="title-text">
										Unproc. orders </span> <span class="processed-value"> 12 </span></li>
							</ul>
						</li>
						<li class="widget-progress-bar">
							<div class="form-group">
								<label>Processed orders: 63%</label>
								<div class="progress">
									<div class="progress-bar progress-bar-success"
										role="progressbar" aria-valuenow="63" aria-valuemin="0"
										aria-valuemax="100" style="width: 0%">
										<span class="sr-only">63% Complete</span>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>

			<div id="sales-income-widget" class="proton-widget">
				<div class="panel panel-default back">
					<div class="panel-heading">
						<i class="icon-cog"></i> <span>Settings</span>
						<div class="toggle-widget-setup">
							<i class="icon-ok"></i> <span>DONE</span>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Products</label>
								<div>
									<select class="select2">
										<option>All</option>
										<option selected="">Digital Media</option>
										<option>Books</option>
										<option>Shopping Carts</option>
										<option>Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Origin</label>
								<div>
									<select class="select2">
										<option value="Any">Any</option>
										<option value="Europe">Europe</option>
										<option value="Asia">Asia</option>
										<option selected="" value="North America">North
											America</option>
										<option value="Other">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Time Unit</label>
								<div>
									<select class="select2">
										<option>Day</option>
										<option>Week</option>
										<option>Month</option>
										<option selected="">Year</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel panel-warning front">
					<div class="panel-heading">
						<i class="icon-shopping-cart"></i> <span>Sales Income</span> <i
							class="icon-cog toggle-widget-setup"></i>
					</div>
					<div>
						<div class="form-group">
							<div id="hero-bar" class="graph" style="height: 225px;"></div>
						</div>
					</div>
				</div>
			</div>

			<div id="expenses-widget" class="proton-widget">
				<div class="panel panel-default back">
					<div class="panel-heading">
						<i class="icon-cog"></i> <span>Settings</span>
						<div class="toggle-widget-setup">
							<i class="icon-ok"></i> <span>DONE</span>
						</div>
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Division</label>
								<div>
									<select class="select2">
										<option selected="" value="All">All Divisions</option>
										<option value="RnD">R&amp;D</option>
										<option value="Production">Production</option>
										<option value="Marketing">Marketing</option>
										<option value="Sales">Sales</option>
										<option value="Other">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Products</label>
								<div>
									<select class="select2">
										<option selected="">All</option>
										<option>Digital Media</option>
										<option>Books</option>
										<option>Shopping Carts</option>
										<option>Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-group">
								<label>Filter by Time</label>
								<div>
									<select class="select2">
										<option>Any</option>
										<option>This Week</option>
										<option>This Month</option>
										<option selected="">This Year</option>
										<option>Ten Years</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="panel panel-danger front">
					<div class="panel-heading">
						<i class="icon-chevron-sign-down"></i> <span>Expenses</span> <i
							class="icon-cog toggle-widget-setup"></i>
					</div>
					<div>
						<div class="form-group">
							<div id="hero-donut" class="graph"
								style="margin-top: 10px; height: 185px;"></div>
						</div>
					</div>
				</div>
			</div>
		</section>

	</section>

	<div id="quickLaunchModal" tabindex="-1" role="dialog"
		class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<i class="icon-plus"></i><span>EDIT QUICK LAUNCH ITEMS</span>
					</h4>
				</div>
				<div class="modal-body">
					<p>Edit quick launch items below:</p>
					<input type="text" placeholder="Placeholder Text"
						value="Graphs,Calendar,Maps,Cloud,Conference"
						data-role="tagsinput" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-default"
						data-dismiss="modal">CANCEL</button>
					<button type="button" class="btn btn-lg btn-success"
						data-dismiss="modal">SAVE SELECTION</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


	<script src="Js/e1d08589.bootstrap.min.js"></script>

	<!-- Proton base scripts: -->
	<script src="Js/9f7a46ed.proton.js"></script>


	<!-- Page-specific scripts: -->
	<script src="Js/jquery-ui.min.js"></script>
	<script src="Js/e9e962ee.dashboard.js"></script>
	<script src="Js/61b9ced9.dashdemo.js"></script>

	<!-- Bootstrap Tags Input -->
	<!-- http://timschlechter.github.io/bootstrap-tagsinput/examples/ -->
	<script src="Js/bootstrap-tagsinput.min.js"></script>

	<!-- Raphael, used for graphs -->
	<!-- http://raphaeljs.com/ -->
	<script src="Js/raphael-min.js"></script>

	<!-- Morris graphs -->
	<!-- https://github.com/oesmith/morris.js -->
	<script src="Js/morris.min.js"></script>

	<!-- Select2 For Bootstrap3 -->
	<!-- https://github.com/fk/select2-bootstrap-css -->
	<script src="Js/select2.min.js"></script>

	<!-- Number formating for dashboard demo -->
	<script src="Js/numeral.min.js"></script>

	<!-- Notifications -->
	<!-- http://pinesframework.org/pnotify/ -->
	<script src="Js/jquery.pnotify.min.js"></script>
</body>
</html>
