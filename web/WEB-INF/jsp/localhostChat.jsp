<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import= "com.kootour.common.KooConst"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <title>Chat | Kootour</title>
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

            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <section class="section section-small col-xs-12">
                    <div class="col-xs-offset-2 col-xs-8">
                    <%
                    	String userName = ((String)request.getAttribute("firstName"));
                  		String loginType = ((String)request.getAttribute("loginType"));
                        String avatarUrl = ((String)request.getAttribute("picture"));
                        String location = ((String)request.getAttribute("location"));
                        String crateTime = ((String)request.getAttribute("createTime"));
                        avatarUrl = KooConst.LT_LOGIN_TYPE_EMAIL.equals(loginType) ? "../upload/images/" + avatarUrl : avatarUrl;
                    %>
                        <div class="user-thumbnail img-circle" style="background-image:url('<%=avatarUrl %>')"></div>
                        <p class="subtitle nomargin"><%=userName %></p>


                        <ul class="list-style-none">
                            <li><%=location %></li>
                            <li>Member since <%=crateTime %></li>
                        </ul>
                    </div>
                </section>
            </div>

            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                <section class="section section-small col-xs-12">
                    <div id="kootour-tchat" class="tchat">
                        <div class="text-center">
                            <div id="loadPreMessage"><a href="#" class="subtitle">Loading previous message</a></div>
                        </div>
						<div id="message-body">
						</div>
                    </div>

                    <form id="kootour-form-tchat" class="form-tchat">
                        <div class="form-group">
                            <textarea id="text-message" placeholder="Type a message" class="form-control gray" rows="5"></textarea>
                        </div>

                        <div class="text-right">
                            <button id="send-message" class="btn btn-kootour">Send</button>
                        </div>
                    </form>
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
		<script src="js/localhostChat.js"></script>
		<script src="js/localhostHeader.js" type="text/javascript"></script>
</body>
</html>