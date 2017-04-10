<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7 lt-ie10"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8 lt-ie10"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9 lt-ie10"> <![endif]-->
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
        <title>GEA - Loan</title>
        <meta name="description" content="Page Description">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

        <link rel="stylesheet" href="Css/92bc1fe4.bootstrap.css">
        

        <!-- Page-specific Plugin CSS: -->
        <link rel="stylesheet" href="Css/select2.css">
        <link rel="stylesheet" href="Css/uniform.default.css">


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
            js = 'Js/jquery2.min.js';
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
                <li class="group">
                    <a data-toggle="dropdown" href="#">Manage loan</a>
                    <ul class="dropdown-menu dropdown-menu-arrow" role="menu">
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="loandtl_form.jsp">Add Loan</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="forms-masked-input-fields.html">Search Loan</a></li>

                    </ul>
                </li>
                <li class="active">
                    <a class="bread-page-title" data-toggle="dropdown" href="#"></a>
                    <ul class="dropdown-menu dropdown-menu-arrow" role="menu">
                    </ul>
                </li>
            </ol>

            

            <div class="row">
                                    <!-- FORM VALIDATION -->
                <div class="col-md-6 col-lg-6">
                        <form action="<%=request.getContextPath() %>/loan_controller" method="post" data-parsley-namespace="data-parsley-" data-parsley-validate>
                        <input type="hidden" name="flag" value="update"/>
                        
                            <div class="panel panel-default panel-block">
                                <div class="list-group">
                                    <div class="list-group-item">
                                        <h4 class="section-title">Loan Detail</h4>
										<c:forEach items="${sessionScope.ulist }" var="l">
                                        <div class="form-group">
                                        <input type="hidden" name="id" value="${l.id }">
                                            <label>Loan Type <span class="text-danger">*</span></label>
                                            <input type="text" name="lt" class="form-control" value="${l.loan_type }" data-parsley-required="true">
                                        </div>
										
										
										<div class="form-group">
                                            <label>Amount Allowed</label>
                                            <input type="text" name="amount" class="form-control" value="${l.amount }" data-parsley-required="true">
                                        </div>
										
										<div class="form-group">
                                            <label>Interest Rate</label>
                                            <input type="text" name="rate" class="form-control" value="${l.rate }" data-parsley-required="true">
                                        </div>
										
										<div class="form-group">
                                            <label>Loan Description</label>
                                            <textarea class="form-control" name="ld" rows="5" >${l.loan_desc }</textarea>
                                        </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <footer class="panel-footer text-right">
                                  <button type="submit" class="btn btn-success">Submit</button>
                                </footer>
                            </div>
                        </form>
                    </div>


                    
            </div>
        </section>

        <div id="success" tabindex="-1" role="dialog" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title"><i class="icon-smile"></i> From Submitted</h4>
                    </div>
                    <div class="modal-body text-center">
                        <h4>All form input values are valid!</h4>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-lg btn-success" data-dismiss="modal">Yeaaah!</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        
        <script src="Js/e1d08589.bootstrap.min.js"></script>

		<!-- Proton base scripts: -->
        <script src="Js/9f7a46ed.proton.js"></script>


        <!-- Page-specific scripts: -->
        <script src="Js/ba45a7b8.sidebar.js"></script>
        <script src="Js/de9cba6c.forms.js"></script>
        <!-- jsTree -->
        <script src="Js/jquery.jstree.js"></script>
        
        <!-- Parsley.js forms validation -->
        <!-- http://parsleyjs.org/ -->
            <script src="Js/parsley.min.js"></script>
            <script src="js/parsley.extend.min.js"></script>
    </body>
</html>
    