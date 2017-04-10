<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7 lt-ie10"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8 lt-ie10"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9 lt-ie10"> <![endif]-->
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
        <title>Proton UI - Tables</title>
        <meta name="description" content="Page Description">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

        <link rel="stylesheet" href="Css/92bc1fe4.bootstrap.css">
        

        <!-- Page-specific Plugin CSS: -->
        <link rel="stylesheet" href="Css/select2.css">
        <link rel="stylesheet" href="styles/vendor/datatables.css" media="screen" />


        <!-- Proton CSS: -->
        <link rel="stylesheet" href="Css/aaf5c053.proton.css">
        <link rel="stylesheet" href="Css/animate.css">

        <!-- adds CSS media query support to IE8   -->
        <!--[if lt IE 9]>
            <script src="Js/html5shiv.js"></script>
            <script src="scripts/vendor/respond.min.js"></script>
        <![endif]-->

        <!-- Fonts CSS: -->
        <link rel="stylesheet" href="Css/6227bbe5.font-awesome.css" type="text/css" />
        <link rel="stylesheet" href="Css/40ff7bd7.font-titillium.css" type="text/css" />

        <!-- Common Scripts: -->
        <script>
        (function () {
          var js;
          if (typeof JSON !== 'undefined' && 'querySelector' in document && 'addEventListener' in window) {
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

    <body>
        
        <script>
	        var theme = $.cookie('protonTheme') || 'default';
	        $('body').removeClass (function (index, css) {
	            return (css.match (/\btheme-\S+/g) || []).join(' ');
	        });
	        if (theme !== 'default') $('body').addClass(theme);
        </script>
        <!--[if lt IE 8]>
        <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        
		<jsp:include page="menu.jsp"></jsp:include>
        
        <section class="sidebar extended">
            <script>
            $(document).ready(function() {
                if ($.cookie('protonSidebar') == 'retracted') {
                    $('.sidebar').removeClass('extended').addClass('retracted');
                    $('.wrapper').removeClass('retracted').addClass('extended');
                }
                if ($.cookie('protonSidebar') == 'extended') {
                    $('.wrapper').removeClass('extended').addClass('retracted');
                    $('.sidebar').removeClass('retracted').addClass('extended');
                }
            });
            </script>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="clearfix">
                        <img src="Images/proton-logo.png" alt="proton-logo">
                        <h5>
                            <span class="title">
                                Proton
                            </span>
                            <span class="subtitle">
                                CMS ADMIN PANEL
                            </span>
                        </h5>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="title">
                        <i class="icon-shopping-cart"></i>
                        <span>
                            CATEGORIES
                        </span>
                        <a href="javascript:;" class="add">
                            <i class="icon-plus-sign"></i>
                            <span>
                                ADD NEW
                            </span>
                        </a>
                    </div>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <div class="input-group-btn">
                            <button class="btn btn-default btn-search" type="button"><i class="icon-search"></i></button>
                        </div>
                    </div>
                </div>
                <div class="panel-body tree-body">
                    <div class="scrollable">
                        <div id="proton-tree"></div>
                    </div>
                </div>
            </div>
            <div class="sidebar-handle">
                <i class="icon-ellipsis-horizontal"></i>
                <i class="icon-ellipsis-vertical"></i>
            </div>
        </section>

        <section class="wrapper retracted scrollable">
            
            <script>
                if (!($('body').is('.dashboard-page') || $('body').is('.login-page'))){
                    if ($.cookie('protonSidebar') == 'retracted') {
                        $('.wrapper').removeClass('retracted').addClass('extended');
                    }
                    if ($.cookie('protonSidebar') == 'extended') {
                        $('.wrapper').removeClass('extended').addClass('retracted');
                    }
                }
            </script>
            
            <nav class="user-menu">
                <a href="javascript:;" class="main-menu-access">
                    <i class="icon-proton-logo"></i>
                    <i class="icon-reorder"></i>
                </a>
                <section class="user-menu-wrapper">
                    <a href="javascript:;" data-expand=".theme-view" class="view-menu-access">
                        <i class="icon-eye-open"></i>
                    </a>
                    <a href="javascript:;" data-expand=".messages-view" class="messages-access">
                        <i class="icon-envelope-alt"></i>
                    </a>
                    <a href="javascript:;" data-expand=".notifications-view" class="notifications-access unread">
                        <i class="icon-comment-alt"></i>
                        <div class="menu-counter">6</div>
                    </a>
                </section>

                <div class="panel panel-default nav-view theme-view">
                    <div class="arrow user-menu-arrow"></div>
                    <div class="panel-heading">
                        <i class="icon-eye-open"></i>
                        <span>Color Scheme</span>
                        <a href="javascript:;" class="close-user-menu"><i class="icon-remove"></i></a>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item" data-theme="default">
                            <a href="javascript:;">
                                <i><b class="dark"></b></i>
                                <div class="text-holder">
                                    <span class="title-text">
                                        Dark
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item" data-theme="theme-light">
                            <a href="javascript:;">
                                <i><b></b></i>
                                <div class="text-holder">
                                    <span class="title-text">
                                        Light
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item" data-theme="theme-pastel">
                            <a href="javascript:;">
                                <i><b class="pastel"></b></i>
                                <div class="text-holder">
                                    <span class="title-text">
                                        Pastel Green
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item" data-theme="theme-pastel-marine">
                            <a href="javascript:;">
                                <i><b class="pastel-marine"></b></i>
                                <div class="text-holder">
                                    <span class="title-text">
                                        Pastel Marine
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item" data-theme="theme-terminal">
                            <a href="javascript:;">
                                <i><b class="terminal"></b></i>
                                <div class="text-holder">
                                    <span class="title-text">
                                        Terminal
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li class="list-group-item" data-theme="theme-rio">
                            <a href="javascript:;">
                                <i><b class="rio"></b></i>
                                <div class="text-holder">
                                    <span class="title-text">
                                        Rio
                                    </span>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="panel panel-default nav-view messages-view">
                    <div class="arrow user-menu-arrow"></div>
                    <div class="panel-heading">
                        <i class="icon-envelope-alt"></i>
                        <span>Messages</span>
                        <a href="javascript:;" class="close-user-menu"><i class="icon-remove"></i></a>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <i><img src="Images/user1.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Nunc Cenenatis:
                                </span>
                                <span class="description-text">
                                    Hi, can you meet me at the office tomorrow morning?
                                </span>
                            </div>
                            <span class="time-ago">
                                3 mins ago
                            </span>
                        </li>
                        <li class="list-group-item">
                            <i><img src="Images/user5.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Prasent Neque:
                                </span>
                                <span class="description-text">
                                    Just a quick question: do you know the balance on the adsense account?
                                </span>
                            </div>
                            <span class="time-ago">
                                17 mins ago
                            </span>
                        </li>
                        <li class="list-group-item">
                            <i><img src="Images/user2.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Flor Demoa:
                                </span>
                                <span class="description-text">
                                    Hey, we're going surfing tomorrow. Feel free to join in.
                                </span>
                            </div>
                            <span class="time-ago">
                                3 hrs ago
                            </span>
                        </li>
                    </ul>
                </div>

                <div class="panel panel-default nav-view notifications-view">
                    <div class="arrow user-menu-arrow"></div>
                    <div class="panel-heading">
                        <i class="icon-comment-alt"></i>
                        <span>Notifications</span>
                        <a href="javascript:;" class="close-user-menu"><i class="icon-remove"></i></a>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <i><img src="Images/user1.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Nunc Cenenatis
                                </span>
                                <span class="description-text">
                                    likes your website.
                                </span>
                            </div>
                            <span class="time-ago">
                                32 mins ago
                            </span>
                        </li>
                        <li class="list-group-item">
                            <i><img src="Images/user2.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Flor Demoa
                                </span>
                                <span class="description-text">
                                    wrote a new post.
                                </span>
                            </div>
                            <span class="time-ago">
                                3 hrs ago
                            </span>
                        </li>
                        <li class="list-group-item">
                            <i><img src="Images/user4.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Nunc Neque
                                </span>
                                <span class="description-text">
                                    wrote a new post.
                                </span>
                            </div>
                            <span class="time-ago">
                                57 mins ago
                            </span>
                        </li>
                        <li class="list-group-item">
                            <i><img src="Images/user2.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Flor Demoa
                                </span>
                                <span class="description-text">
                                    submitted a new ticket.
                                </span>
                            </div>
                            <span class="time-ago">
                                1.5 hrs ago
                            </span>
                        </li>
                        <li class="list-group-item">
                            <i><img src="Images/user1.jpg" alt="User Icon"></i>
                            <div class="text-holder">
                                <span class="title-text">
                                    Nunc Cenenatis
                                </span>
                                <span class="description-text">
                                    wrote a new post.
                                </span>
                            </div>
                            <span class="time-ago">
                                3 hrs ago
                            </span>
                        </li>
                    </ul>
                </div>
            </nav>
            
            <ol class="breadcrumb breadcrumb-nav">
                <li><a href="."><i class="icon-home"></i></a></li>
                <li class="active">
                    <a  data-toggle="dropdown" href="#">Manage Result</a>
                    <ul class="dropdown-menu dropdown-menu-arrow" role="menu">
                    </ul>
                </li>
            </ol>
        
            
            <div class="row">
                <div class="col-md-12">
                                        



                    
                    <div class="panel panel-default panel-block">
                    	<div id="data-table" class="panel-heading datatable-heading">
                            <h4 class="section-title">Result Table</h4>
                    	</div>
	                    <table class="table table-bordered table-striped" id="tableSortable">
	                        <thead>
	                            <tr>
	                                <th>No.</th>
	                                <th>Exam Name</th>
	                                <th>User Name</th>
	                                <th>Result</th>
	                                <th>Select/Reject</th>
	                            </tr>
	                        </thead>
	                        <tbody>

	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Firefox 1.0</td>
	                                <td>Win 98+ / OSX.2+</td>
	                                <td class="center">1.7</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Firefox 1.5</td>
	                                <td>Win 98+ / OSX.2+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Firefox 2.0</td>
	                                <td>Win 98+ / OSX.2+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Firefox 3.0</td>
	                                <td>Win 2k+ / OSX.3+</td>
	                                <td class="center">1.9</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Camino 1.0</td>
	                                <td>OSX.2+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Camino 1.5</td>
	                                <td>OSX.3+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Netscape 7.2</td>
	                                <td>Win 95+ / Mac OS 8.6-9.2</td>
	                                <td class="center">1.7</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Netscape Browser 8</td>
	                                <td>Win 98SE+</td>
	                                <td class="center">1.7</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Netscape Navigator 9</td>
	                                <td>Win 98+ / OSX.2+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.0</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.1</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1.1</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.2</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1.2</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.3</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1.3</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.4</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1.4</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.5</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1.5</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.6</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">1.6</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.7</td>
	                                <td>Win 98+ / OSX.1+</td>
	                                <td class="center">1.7</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Mozilla 1.8</td>
	                                <td>Win 98+ / OSX.1+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Seamonkey 1.1</td>
	                                <td>Win 98+ / OSX.2+</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Gecko</td>
	                                <td>Epiphany 2.20</td>
	                                <td>Gnome</td>
	                                <td class="center">1.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>Safari 1.2</td>
	                                <td>OSX.3</td>
	                                <td class="center">125.5</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>Safari 1.3</td>
	                                <td>OSX.3</td>
	                                <td class="center">312.8</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>Safari 2.0</td>
	                                <td>OSX.4+</td>
	                                <td class="center">419.3</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>Safari 3.0</td>
	                                <td>OSX.4+</td>
	                                <td class="center">522.1</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>OmniWeb 5.5</td>
	                                <td>OSX.4+</td>
	                                <td class="center">420</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>iPod Touch / iPhone</td>
	                                <td>iPod</td>
	                                <td class="center">420.1</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Webkit</td>
	                                <td>S60</td>
	                                <td>S60</td>
	                                <td class="center">413</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 7.0</td>
	                                <td>Win 95+ / OSX.1+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 7.5</td>
	                                <td>Win 95+ / OSX.2+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 8.0</td>
	                                <td>Win 95+ / OSX.2+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 8.5</td>
	                                <td>Win 95+ / OSX.2+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 9.0</td>
	                                <td>Win 95+ / OSX.3+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 9.2</td>
	                                <td>Win 88+ / OSX.3+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera 9.5</td>
	                                <td>Win 88+ / OSX.3+</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Opera for Wii</td>
	                                <td>Wii</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Nokia N800</td>
	                                <td>N800</td>
	                                <td class="center">-</td>
	                                <td class="center"><button type="button" class="btn btn-sm btn-primary">Select</button> | <button type="button" class="btn btn-sm btn-danger">Reject</button></td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Presto</td>
	                                <td>Nintendo DS browser</td>
	                                <td>Nintendo DS</td>
	                                <td class="center">8.5</td>
	                                <td class="center">C/A<sup>1</sup></td>
	                            </tr>
	                            <tr class="gradeC">
	                                <td>KHTML</td>
	                                <td>Konqureror 3.1</td>
	                                <td>KDE 3.1</td>
	                                <td class="center">3.1</td>
	                                <td class="center">C</td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>KHTML</td>
	                                <td>Konqureror 3.3</td>
	                                <td>KDE 3.3</td>
	                                <td class="center">3.3</td>
	                                <td class="center">A</td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>KHTML</td>
	                                <td>Konqureror 3.5</td>
	                                <td>KDE 3.5</td>
	                                <td class="center">3.5</td>
	                                <td class="center">A</td>
	                            </tr>
	                            <tr class="gradeX">
	                                <td>Tasman</td>
	                                <td>Internet Explorer 4.5</td>
	                                <td>Mac OS 8-9</td>
	                                <td class="center">-</td>
	                                <td class="center">X</td>
	                            </tr>
	                            <tr class="gradeC">
	                                <td>Tasman</td>
	                                <td>Internet Explorer 5.1</td>
	                                <td>Mac OS 7.6-9</td>
	                                <td class="center">1</td>
	                                <td class="center">C</td>
	                            </tr>
	                            <tr class="gradeC">
	                                <td>Tasman</td>
	                                <td>Internet Explorer 5.2</td>
	                                <td>Mac OS 8-X</td>
	                                <td class="center">1</td>
	                                <td class="center">C</td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Misc</td>
	                                <td>NetFront 3.1</td>
	                                <td>Embedded devices</td>
	                                <td class="center">-</td>
	                                <td class="center">C</td>
	                            </tr>
	                            <tr class="gradeA">
	                                <td>Misc</td>
	                                <td>NetFront 3.4</td>
	                                <td>Embedded devices</td>
	                                <td class="center">-</td>
	                                <td class="center">A</td>
	                            </tr>
	                            <tr class="gradeX">
	                                <td>Misc</td>
	                                <td>Dillo 0.8</td>
	                                <td>Embedded devices</td>
	                                <td class="center">-</td>
	                                <td class="center">X</td>
	                            </tr>
	                            <tr class="gradeX">
	                                <td>Misc</td>
	                                <td>Links</td>
	                                <td>Text only</td>
	                                <td class="center">-</td>
	                                <td class="center">X</td>
	                            </tr>
	                            <tr class="gradeX">
	                                <td>Misc</td>
	                                <td>Lynx</td>
	                                <td>Text only</td>
	                                <td class="center">-</td>
	                                <td class="center">X</td>
	                            </tr>
	                            <tr class="gradeC">
	                                <td>Misc</td>
	                                <td>IE Mobile</td>
	                                <td>Windows Mobile 6</td>
	                                <td class="center">-</td>
	                                <td class="center">C</td>
	                            </tr>
	                            <tr class="gradeC">
	                                <td>Misc</td>
	                                <td>PSP browser</td>
	                                <td>PSP</td>
	                                <td class="center">-</td>
	                                <td class="center">C</td>
	                            </tr>
	                            <tr class="gradeU">
	                                <td>Other browsers</td>
	                                <td>All others</td>
	                                <td>-</td>
	                                <td class="center">-</td>
	                                <td class="center">U</td>
	                            </tr>
	                        </tbody>
	                    </table>
		            </div>
                </div>
            </div>
        </section>


        

        
        <script src="Js/e1d08589.bootstrap.min.js"></script>

		<!-- Proton base scripts: -->
        <script src="Js/9f7a46ed.proton.js"></script>


        <!-- Page-specific scripts: -->
        <script src="Js/ba45a7b8.sidebar.js"></script>
        <script src="Js/5558cd34.tables.js"></script>
        <!-- jsTree -->
        <script src="Js/jquery.jstree.js"></script>
        <!-- Data Tables -->
        <!-- http://datatables.net/ -->
            <script src="Js/jquery.dataTables.min.js"></script>
        
        <!-- Data Tables for BS3 -->
        <!-- https://github.com/Jowin/Datatables-Bootstrap3/ -->
        <!-- NOTE: Original JS file is modified -->
            <script src="Js/datatables.js"></script>
        <!-- Select2 Required To Style Datatable Select Box(es) -->
        <!-- https://github.com/fk/select2-bootstrap-css -->
            <script src="Js/select2.min.js"></script>
      </body>
</html>
    