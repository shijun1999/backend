<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <title>Sign Up | Kootour</title>
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon"/>

	<!-- bootstrap & fontawesome -->
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">

	<!-- page specific plugin styles -->
	<link rel="stylesheet" href="/css/bootstrap-dialog.min.css" />
	<link rel="stylesheet" href="/css/HoldOn.min.css" />

	<!-- kootour stles -->
	<link rel="stylesheet" href="/css/kootour-user.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <!-- Begin navbar -->
    <nav class="navbar navbar-kootour nomargin">
        <div class="container">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-kootour-collapse" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand navbar-brand-img" href="localhostLogin!load">
                        <img  alt="Brand" src="/images/icons/logo.svg" />
                    </a>

                    <p class="navbar-text kootour-link">
                        <a href="localhostLogin!load">Kootour</a>
                    </p>
                </div>


                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse"  id="navbar-kootour-collapse">
                    <!--<form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <select type="text" class="form-control white">
                                <option value="vancouver" selected>Vancouver</option>
                            </select>
                        </div>
                    </form>-->

                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="localhostLogin!load">Log In</a></li>
                        <li><a href="#">Sign Up</a></li>
                        <!--<li><a href="#">Messages <img class="icon" src="images/icons/account_active_192X192.png" /></a></li>-->
                        <!--<li><a href="#"><img class="icon-navbar" src="images/icons/language_icon_white.png" /></a></li>-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
    </nav>

    <div class="container">
        <div class="row">

            <div class="col-lg-offset-3 col-md-offset-2 col-lg-6 col-md-8 col-sm-12 col-xs-12">
            <h2 class="text-center title-page blue">bbb-Become Our Partner</h2>
                <section class="section">
                    <div class="login-wrap">
                        <div class="login-container">
                            <p class="nomargin text-right blue"><a href="localhostLogin!load">Log In</a></p>
                        </div>
                        <div class="login-separator">
                            <p class="nomargin text-center blue">|</p>
                        </div>
                        <div class="login-container">
                            <p class="nomargin text-left blue"><b>Sign Up</b></a></p>
                        </div>
                    </div>

                    <div class="login-wrap login-wrap-collapse">
                        <div class="login-container">
                            <a class="btn btn-social fullwidth btn-social-facebook">
                                <img  alt="Brand" src="/images/icons/facebook_signup.png" /> facebook
                            </a>
                        </div>
                        <div class="login-separator"></div>
                        <div class="login-container">
                            <a class="btn btn-social fullwidth btn-social-wechat">
                                <img  alt="Brand" src="/images/icons/wechat.png" /> wechat
                            </a>
                        </div>
                    </div>

                    <div class="login-wrap">
                        <div class="login-container"></div>
                        <div class="login-separator">
                            <p class="nomargin text-center blue">OR</p>
                        </div>
                        <div class="login-container"></div>
                    </div>

                     <form id="localhost_reg_form" target="_self" method="post">
                        <div class="form-validator form-group">
                            <input type="text" class="form-control input-lg gray" id="firstName" name="firstName" placeholder="First Name">
                        </div>
                        <div class="form-validator form-group">
                            <input type="text" class="form-control input-lg gray" id="lastName" name="lastName" placeholder="Last Name">
                        </div>
                        <div class="form-validator form-group">
                            <input type="email" class="form-control input-lg gray" id="email" name="email" placeholder="Email">
                        </div>

                        <div class="form-validator form-group">
                            <input type="password" class="form-control input-lg gray" id="password" name="password" placeholder="Password">
                        </div>

                        <div class="form-validator form-group">
                            <input type="password" class="form-control input-lg gray" id="repassword" name="repassword" placeholder="Re-enter Password">
                        </div>

                        <div class="form-group nopadding col-xs-12">
                            <input class="checkbox" id="signupApprove" type="checkbox" checked>
                            <label for="signupApprove"></label>
                            <label for="signupApprove">By Signing Up, I agree to Kootour's <a href="#">terms and conditions</a></label>
                        </div>

                        <button id="localhost_reg" type="submit" class="btn btn-kootour-bold fullwidth">Sign Up</button>

                    </form>

                    <br/>

                    <p class="text-center">Already a Kootour member? <a href="localhostLogin!load"><b>Log In</b></a></p>
                </section>
            </div>
        </div>
    </div>

    <footer>
		<jsp:include page="localhostFooter.jsp" />
    </footer>

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="/js/jquery-2.2.0.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="/js/jquery-2.2.0.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='/js/jquery1x.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="/js/moment.min.js"></script>
		<script src="/js/jquery.validate.min.js"></script>
		<script src="/js/bootstrap-dialog.min.js"></script>
		<script src="/js/HoldOn.min.js"></script>
		<script src="/js/localhostSignup.js"></script>
</body>
</html>