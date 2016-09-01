<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset="utf-8">
		<title>Received Booking | Kootour</title>

		<meta name="description" content="overview &amp; stats">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="css/fullcalendar.min.css" />
		<link rel="stylesheet" href="css/HoldOn.min.css" />
		<link rel="stylesheet" href="css/bootstrap-dialog.min.css" />

		<!-- text fonts -->

		<!-- ace styles -->
		<link rel="stylesheet" href="css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style">

		<!-- kootour stles -->
		<link rel="stylesheet" href="css/kootour.css">

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="js/html5shiv.min.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<jsp:include page="localhostHeader.jsp" />
		<div class="main-container container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="localhostCourseList!load">Localhost Home</a>
							</li>

							<li>
								<a href="localhostReceivedBooking!load">Received bookings</a>
							</li>
						</ul>
					</div>

					<div class="page-content">
					<div class="widget-box widget-color-dark">
					<div class="widget-header">
						<div class="widget-title bigger lighter">
							<a href="localhostCourseList!load"><Strong style="color:white">Tour Products&nbsp;|&nbsp;</Strong></a>
							<a href="localhostReceivedBooking!load"><Strong style="color:white">Received Bookings&nbsp;|&nbsp;</Strong></a>
							<a href="localhostBankInformation!load"><Strong style="color:white">Bank Information&nbsp;|&nbsp;</Strong></a>
							<a href="localhostExclusiveDate!load"><Strong style="color:white">Exclusive Date&nbsp;|&nbsp;</Strong></a>
							<a href="localhostAccount!load"><Strong style="color:white">Account</Strong></a>
							<br>
						</div>
					</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="widget-box kootour-widget-color-main light-border">
								<div class="widget-header">
									<h4 class="widget-title lighter">
										<span class="white">Received bookings:</span>
									</h4>
								</div>


								<div class="widget-body kootour-widget-color-main">
									<div class="widget-main">
									<div id="calendar"></div>
									</div><!-- /.widget-main -->
								</div><!-- /.widget-body -->
							</div><!-- /.widget-box -->
						</div><!-- /.col -->
					</div>
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

<footer>
<jsp:include page="localhostFooter.jsp" />
</footer>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="js/jquery-2.2.0.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="js/jquery.1.11.1.min.js"></script>
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


		<!-- ace scripts -->
		<script src="js/ace-elements.min.js"></script>
		<script src="js/ace.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="js/moment.min.js"></script>
		<script src="js/fullcalendar.min.js"></script>
		<script src="js/HoldOn.min.js"></script>
		<script src="js/bootstrap-dialog.min.js"></script>
		<script src="js/localhostReceivedBooking.js" type="text/javascript"></script>
		<script src="js/localhostHeader.js" type="text/javascript"></script>

		<!-- inline scripts related to this page -->
</body>
</html>