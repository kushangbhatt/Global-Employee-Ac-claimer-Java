<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7 lt-ie10"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8 lt-ie10"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9 lt-ie10"> <![endif]-->
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
        <title>GEA - Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

        <link rel="stylesheet" href="Css/92bc1fe4.bootstrap.css">
        

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

    <body class="login-page">
        
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

        <form role="form" method="post">
        	<input type="hidden" name="flag" value="login">
            <section class="wrapper scrollable animated fadeInDown">
                <section class="panel panel-default">
                    <div class="panel-heading">
                        <div>
                            <img src="Images/proton-logo.png" alt="proton-logo">
                            <h1>
                                <span class="title">
                                    GEA
                                </span>
                                <span class="subtitle">
                                    ADMIN PANEL
                                </span>
                            </h1>
                        </div>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <span class="welcome-text">
                                Welcome back to GEA!
                            </span>
                            <span class="member">
                                Not a Member?
                            </span>
                            <a href="javascript:;">Sign Up</a>
                        </li>
                        <li class="list-group-item">
                            <span class="login-text">
                                Login with your GEA account
                            </span>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control input-lg" id="email" placeholder="Email" name="userName">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control input-lg" id="password" placeholder="Password" name="password">
                            </div>
                        </li>
                    </ul>
                    <div class="panel-footer">
                        <button type="submit" class="btn btn-success" >LOGIN</button>
                        <br>
                        <a class="forgot" href="javascript:;">Forgot Your Password?</a>
                    </div>
                </section>
            </section>
        </form>
    </body>
</html>
