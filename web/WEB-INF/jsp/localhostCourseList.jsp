<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import= "java.util.List"%>
<%@ page import= "com.kootour.model.LocalhostCourseListModel"%>
<%@ page import= "com.kootour.transfer.CourseListTransfer"%>
<%@ page import= "com.kootour.mapper.entity.CourseEntity"%>
<%@ page import= "com.kootour.mapper.entity.CoursePictureEntity"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset="utf-8">
		<title>Course List | Kootour</title>

		<meta name="description" content="overview &amp; stats">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/css/HoldOn.min.css" />
		<link rel="stylesheet" href="/css/bootstrap-dialog.min.css" />

		<!-- text fonts -->

		<!-- ace styles -->
		<link rel="stylesheet" href="/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style">

		<!-- kootour stles -->
		<link rel="stylesheet" href="/css/kootour.css">

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="/js/html5shiv.min.js"></script>
		<script src="/js/respond.min.js"></script>
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
										<span class="white">Products</span>
										<button id="create_new" type="button" class="btn btn-white kootour-btn-main pull-right">Create a tour product</button>
									</h4>
								</div>


								<div class="widget-body kootour-widget-color-main">
									<div class="widget-main">
									<%
									List<CourseListTransfer> dataList = (List<CourseListTransfer>)request.getAttribute("courseList");
									if(dataList == null || dataList.size() == 0){
									%>
									<h5 class="center"> No Course Data</h5>
									<%
									} else {
										for (CourseListTransfer entity : dataList) {
											String courseCd = entity.getCourseEntity().getCourseIdentiNo();
											String courseName = entity.getCourseEntity().getFullName();
											String courseStatus = entity.getCourseEntity().getOkFlg().equals("1") ? "Active" : "Inactive";
											String courseStatusEvent = entity.getCourseEntity().getOkFlg().equals("1") ? "Inactive" : "Active";
											String picFullPath, picMemo;
											if (entity.getCoursePictureEntityList() == null || entity.getCoursePictureEntityList().size() <= 0) {
												// picFullPath = "./localImages/noimage.png";
												picFullPath = "../upload/images/noimage.png";
												picMemo = "No image";
											} else {
												// picFullPath = "./localImages/" + entity.getCoursePictureEntityList().get(0).getFullPath();
												picFullPath = "../upload/images/" + entity.getCoursePictureEntityList().get(0).getFullPath();
												picMemo = entity.getCoursePictureEntityList().get(0).getMemo();
											}
											%>
											<%
											if (entity.getCourseEntity().getOkFlg().equals("1")) {
											%>
												<div id=<%=courseCd%> class="row-fluid clearfix">
											<%
											} else {
											%>
												<div id=<%=courseCd%> class="row-fluid clearfix" style="background-color : #eee">
											<%
											}
											%>

											<div class="travel-list">
												<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
												<a class="pic-link" target="_blank">
												<img onclick="doPreview('<%=courseCd%>')" width="100%" src=<%=picFullPath%> style="display: inline;">
												</a>
												</div>
												<div class="col-xs-12 col-sm-12 col-md-7 col-lg-7 align-left">
													<h3><%=courseName%></h3>
													<h4><span class="kootour-main-color" id="courseStatusNow-<%=courseCd%>"><%=courseStatus%></span></h4>
													<div class="space-32"></div>
													<div>
													<button type="button" class="btn btn-white kootour-btn-main" onclick="doEdit('<%=courseCd%>')">Edit</button>
													<%
													if (entity.isCanDelete()) {
													%>
													<button type="button" class="btn btn-white kootour-btn-main" onclick="doDelete('<%=courseCd%>')">Delete</button>
													<%
													} else {
													%>
													<button  disabled style="color:#ccc" type="button" class="btn btn-white" onclick="doDelete('<%=courseCd%>')">Delete</button>
													<%
													}
													%>
													<button type="button" class="btn btn-white kootour-btn-main" onclick="doClone('<%=courseCd%>')">Duplicate</button>
													<%
													if (entity.isCanDelete()) {
													%>
													<button type="button" class="btn btn-white kootour-btn-main" id="courseStatusTo-<%=courseCd%>" onclick="doChangeStatus('<%=courseCd%>')"><%=courseStatusEvent%></button>
													<%
													} else {
													%>
													<button type="button" class="btn btn-white kootour-btn-main" id="courseStatusTo-<%=courseCd%>" onclick="doChangeStatus('<%=courseCd%>')"><%=courseStatusEvent%></button>
													<%
													}
													%>
													<button type="button" class="btn btn-white kootour-btn-main" onclick="">Extend the Date</button>
													</div>
												</div>
											</div>
											</div>
											<div class="hr hr-24"></div>
									<%
										}
									}
									%>
									</div><!-- /.widget-main -->
								</div><!-- /.widget-body -->
							</div><!-- /.widget-box -->
						</div><!-- /.col -->
					</div>
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
		</div>


			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
<footer>
<jsp:include page="localhostFooter.jsp" />
</footer>
		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="/js/jquery-2.2.0.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="/js/jquery.1.11.1.min.js"></script>
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


		<!-- ace scripts -->
		<script src="/js/ace-elements.min.js"></script>
		<script src="/js/ace.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="/js/moment.min.js"></script>
		<script src="/js/bootstrap-dialog.min.js"></script>
		<script src="/js/HoldOn.min.js"></script>
		<script src="/js/localhostCourseList.js"></script>
		<script src="/js/localhostHeader.js" type="text/javascript"></script>

		<!-- inline scripts related to this page -->
</body>
</html>