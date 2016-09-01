<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <title>Change password | Kootour</title>
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
	<jsp:include page="localhostHeader.jsp" />
    <div class="container">
        <div class="row">

            <div class="col-sm-12 col-xs-12">
                <section class="text-center section">
                    <ul class="indicators">
                        <li id="li-step-1" class="active"><a href="#"></a></li>
                        <li id="li-step-2"><a href="#"></a></li>
                    </ul>

                    <!-- Display step-1 and step-2 if email not confirmed -->
                    <div id="step-1">
                        <label class="title black"><b>Change your password</b></label>

                        <p>Change your password by typing it twice.</p>

                        <div class="phone-icon">
                            <img class="" src="images/icons/icon_email.png" />
                        </div>

                        <div class="row">
                            <div class="col-lg-offset-3 col-md-offset-3 col-sm-offset-2 col-xs-offset-2 col-lg-6 col-md-6 col-sm-8 col-xs-8">
                                <form id="password-form" class="">
                                    <div  class="form-group form-validator">
                                        <input type="password" class="form-control input-lg gray" id="oldPassword" name="oldPassword"placeholder="Old Password">
                                    </div>

                                    <div  class="form-group form-validator">
                                        <input type="password" class="form-control input-lg gray" id="newPassword" name="newPassword" placeholder="New Password">
                                    </div>

                                    <div class="form-group form-validator">
                                        <input type="password" class="form-control input-lg gray" id="reNewPassword" name="reNewPassword" placeholder="Re-enter New Password">
                                    </div>

                                    <button id="changePassword" type="submit" class="btn btn-kootour-bold fullwidth">Change</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div id="step-2" style="display : none">
                        <label class="title black"><b>Congrats!</b></label>

                        <p>Your password changed successfuly.</p>

                        <div class="phone-icon">
                            <img class="" src="images/icons/icon_email.png" />
                        </div>

                        <div class="row">
                            <div class="col-lg-offset-4 col-md-offset-4 col-sm-offset-3 col-xs-offset-3 col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                <a href="localhostAccount!load" class="btn btn-kootour-bold fullwidth">Done</a>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>

    <footer>
		<jsp:include page="localhostFooter.jsp" />
    </footer>

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="js/jquery-2.2.0.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="js/jquery-2.2.0.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='js/jquery1x.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="js/moment.min.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/bootstrap-dialog.min.js"></script>
		<script src="js/HoldOn.min.js"></script>
		<script src="js/localhostChangePassword.js"></script>
		<script src="js/localhostHeader.js" type="text/javascript"></script>
</body>
</html>