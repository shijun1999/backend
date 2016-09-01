<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import= "com.kootour.mapper.entity.LocalhostEntity"%>
<%@ page import= "com.kootour.common.KooConst"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset="utf-8">
		<title>Account | Kootour</title>

		<meta name="description" content="overview &amp; stats">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/css/bootstrap.min.css">
		<link href="/css/bootstrap-theme.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/css/fileinput.min.css" />
		<link rel="stylesheet" href="/css/uploadfile.css" />
		<link rel="stylesheet" href="/css/bootstrap-dialog.min.css" />
		<link rel="stylesheet" href="/summernote/summernote.css" />
		<link rel="stylesheet" href="/css/HoldOn.min.css" />

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
		<script src="js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="js/html5shiv.min.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>

<body>
	<jsp:include page="localhostHeader.jsp" />

    <div class="container">
        <div class="row">

            <div class="col-sm-12 col-xs-12">
                <section class="section section-small">
                        <div class="col-xs-12">
                        <form class="form-horizontal row">
                            <p class="subtitle"><b>General</b></p>
                            <div class="form-group uploader-from-group">
                                <label class="col-xs-12 col-sm-3 text-left control-label">Picture</label>
                                <div class="uploader nopadding col-xs-12 col-sm-8">
                                    <div class="col-xs-12 col-sm-4">
                                        <div class="user-thumbnail img-circle nomargin" id="output-uploader"></div>
                                    </div>
                                    <div class="col-xs-12 col-sm-8">
                                        <div id="singleupload">Upload</div>
                                    </div>
                                </div>
                            </div>
                            </form>
                            </div>

							<form class="form-horizontal row" id="account-form">
                            <div class="col-xs-12">
                            <div class="form-group form-validator">
                                <label for="firstName" class="col-sm-3 text-left control-label">First Name</label>
                                <div class="col-sm-9">
                                    <input type="text" value="" class="form-control input-lg gray" name="firstName" id="firstName" required>
                                </div>
                            </div>

                            <div class="form-group form-validator">
                                <label for="lastName" class="col-sm-3 text-left control-label">Last Name</label>
                                <div class="col-sm-9">
                                    <input type="text" value="" class="form-control input-lg gray" name="lastName" id="lastName" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="location" class="col-sm-3 text-left control-label">Location</label>
                                <div class="col-sm-9">
                                    <input type="text" value="" class="form-control input-lg gray" name="location" id="location">
                                </div>
                            </div>
                            <%
                            String loginType = ((LocalhostEntity)session.getAttribute(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY)).getLoginType();
                            if ("1".equals(loginType)) {
                            %>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 text-left text-left control-label">Password</label>
                                <div class="col-sm-4">
                                    <input type="password" value="" class="form-control input-lg transparent" name="password" id="password" readonly>
                                </div>

                                <div class="col-sm-4">
                                <a href="localhostChangePassword!load" class="btn btn-white kootour-btn-main fullwidth">Change Password</a>
                              	</div>
                            </div>
                           	<%
	                        }
	                        %>
                        </div>

                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="email" class="col-sm-3 text-left control-label">Email</label>
                                <div class="col-sm-4">
                                    <input type="text" value="" class="form-control input-lg transparent" name="email" id="email" readonly="readonly">
                                </div>
                                <div class="col-sm-4">
                                    <a href="#" class="btn btn-white kootour-btn-main fullwidth">Verify</a>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="phoneNumber" class="col-sm-3 text-left control-label">Phone Number</label>
                                <div class="col-sm-4">
                                    <input type="text" value="" class="form-control input-lg transparent" name="phone" id="phoneNumber" readonly="readonly">
                                </div>
                                <div class="col-sm-4">
                                    <a href="#" class="btn btn-white kootour-btn-main fullwidth">Verify</a>
                                </div>
                            </div>

						<p class="subtitle"><b>Introduction about yourself:</b></p>
						<div id="editor"></div>
						</div>
                        <div class="nested-section col-xs-offset-3 col-xs-6">
                            <p class="text-center">
                                <button type="submit" class="btn btn-white kootour-btn-main fullwidth">Save</button>
                            </p>
                        </div>
                    </form>
					<hr>
					<div class="form-group">
					<p class="subtitle"><b>Upload your Video:</b></p>
					<h5 class="block">Upload up to 3 videos that represent your tour or activity. </h5>
					<h5 class="block">Minimum size is 10M. Video type is .mp4. </h5>
					<h5 class="block">Don’t show logo or company name.</h5>
					<form id="uploadVideoForm" action="" method="post" target="_self" enctype="multipart/form-data">
					<input id="input-dim-2" name="file" type="file" multiple class="file-loading" accept="video/*">
					</form>
					</div>
                </section>
            </div>
        </div>
    </div>

<footer>
<jsp:include page="localhostFooter.jsp" />
</footer>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!--[if !IE]>-->
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

		<!-- page specific plugin scripts -->
		<script src="js/moment.min.js"></script>
		<script src="js/fileinput.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/bootstrap-dialog.min.js"></script>
		<script src="summernote/summernote.min.js"></script>
		<script src="js/jquery.uploadfile.min.js"></script>
		<script src="js/HoldOn.min.js"></script>
		<script src="js/localhostAccount.js" type="text/javascript"></script>
		<script src="js/localhostHeader.js" type="text/javascript"></script>

		<!-- ace scripts -->
		<script src="js/ace-elements.min.js"></script>
		<script src="js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
</body>
</html>
