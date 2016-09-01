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
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">

		<!-- page specific plugin styles -->
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
   <div class="container">
        <div class="row">
            <div class="left-column col-lg-8 col-md-8 col-sm-12 col-xs-12">

                <section class="carousel-kootour carousel-kootour-section nopadding col-xs-12">
                    <!-- carousel -->
                    <div id="carousel-kootour" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <!-- <li data-target="#carousel-kootour" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-kootour" data-slide-to="1"></li>
                            <li data-target="#carousel-kootour" data-slide-to="2"></li> -->
                            <s:iterator var="coursePicture" value="#request.coursePictureListDisp" status="status">
                            	<s:if test="#status.first">
                            		<li data-target="#carousel-kootour" data-slide-to="<s:property value="#status.index" />" class="active"></li>
								</s:if>
								<s:else>
									<li data-target="#carousel-kootour" data-slide-to="<s:property value="#status.index" />"></li>
								</s:else>
                            </s:iterator>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <s:iterator var="coursePicture" value="#request.coursePictureListDisp" status="status">
                            	<s:if test="#status.first">
									<div class="item active">
								</s:if>
								<s:else>
									<div class="item">
								</s:else>
	                                <img src="<s:property value="#coursePicture.fullPath" />" alt="<s:property value="#coursePicture.fullName" />">
	                            </div>
                            </s:iterator>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-kootour" role="button" data-slide="prev">
                            <span class="icon icon-prev" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-kootour" role="button" data-slide="next">
                            <span class="icon icon-next" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <s:if test='#request.favoriteIdentiNo!=""'>
                    	<div id="div_saveorcancel" class="add-favorited" onclick="saveOrCancelWish('<s:property value="#request.courseIdentiNo" />');event.cancelBubble=true;"></div>
                    </s:if>
                    <s:else>
                    	<div id="div_saveorcancel" class="add-favorite" onclick="saveOrCancelWish('<s:property value="#request.courseIdentiNo" />');event.cancelBubble=true;"></div>
                    </s:else>
                </section>

                <section class="tour-detail section noborder nomargin col-xs-12">
                    <div class="tour-descriptions">
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_time_bgwhite_300X300.png" alt="time">
                                </td>

                                <td>
                                    <s:property value="#request.duration" /> <s:property value="#request.durationUnit" />
                                </td>
                            </tr>
                        </table>
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_luggage_bgwhite_300X300.png" alt="luggage">
                                </td>

                                <td>
                                    <s:property value="#request.minTouristNum" />-<s:property value="#request.maxTouristNum" /> travellers
                                </td>
                            </tr>
                        </table>
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_location_bgwhite_300X300.png" alt="location">
                                </td>

                                <td>
                                    <s:property value="#request.tourLocation" />
                                </td>
                            </tr>
                        </table>
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_language_bgwhite_300X300.png" alt="language">
                                </td>

                                <td>
									<!-- English &<br/> Chinese -->
                                    <s:property value="#request.useLangId"/>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <h2 class="blue"><s:property value="#request.fullName"/>&nbsp;<small>($<s:property value="#request.scheduleOptionListDisp[0].retailPrice"/> per person/group)</small></h2>

                    <div class="vote-wrapper">
                        <ul class="vote">
                            <s:iterator var="scoreIconItem" value="#request.scoreIconListDisp" status="status">
                            	<li><img src="<s:property value="scoreIconItem" />"></li>
                            </s:iterator>
                        </ul>
                        <s:if test="#request.reviewNumDisp !=''">
                         <span class="vote-label"><s:property value="#request.reviewNumDisp"/> reviews</span>
                         </s:if>
                    </div>
                </section>

                <section class="section col-xs-12">
                    <span class="title">Tour Summary</span>
                    <div id="readmore1">
                            <p><s:property value="#request.courseContent" escape="false" /></p>

                            <span class="subtitle">Tour itinerary</span>

                            <p><s:property value="#request.additionalInfo" escape="false" /></p>
                    </div>

                </section>

                <section class="section col-xs-12">
                    <span class="title">Important Information</span>

                    <div id="readmore2">
                        <table class="table-information col-lg-6 col-md-12 col-sm-12 col-xs-12">
                            <tr>
                                <td class="subtitle">Tour Location</td>
                                <td><s:property value="#request.tourLocation" /></td>
                            </tr>
                            <tr>
                                <td class="subtitle">Duration</td>
                                <td><s:property value="#request.duration" />
                                <s:property value="#request.durationUnit" /></td>
                            </tr>
                            <tr>
                                <td class="subtitle">Meetup Location</td>
                                <td><s:property value="#request.meetupLocation" /></td>
                            </tr>
                        </table>

                        <div class="clearfix"></div>

                        <p class="subtitle">Inclusions</p>
                        <ul>
                            <s:iterator var="inclusionItem" value="#request.inclusionListDisp" status="status">
                            	<li><s:property value="#inclusionItem.inExclusion" /></li>
                            </s:iterator>
                        </ul>

                        <p class="subtitle">Exclusions</p>
                        <ul>
                            <s:iterator var="exclusionItem" value="#request.exclusionListDisp" status="status">
                            	<li><s:property value="#exclusionItem.inExclusion" /></li>
                            </s:iterator>
                        </ul>
                    </div>
                </section>
            </div>

            <div class="right-column col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <section class="widget nopadding section section-small">
                    <form action="booking.html" class="form-horizontal">

                        <div class="widget-row col-xs-12">
                            <div class="option-label">
                                <span class="subtitle">Customized Options:</span>
                            </div>
                        </div>
						<s:iterator var="extraOption" value="#request.extraOptionListDisp" status="status">
	                        <div class="widget-row customized-option">
	                            <%-- <div class="option-checkbox">
	                                <input type="checkbox" id="chb<s:property value="#status.index+1" />" onchange="checkChange('chb<s:property value="#status.index+1" />','<s:property value="#extraOption.extraPrice" />');" name="checkbox" class="checkbox" />
	                                <label for="chb<s:property value="#status.index+1" />"></label>
	                                <input type="hidden" id="extraOptionIdentiNo<s:property value="#status.index" />" value="<s:property value="#extraOption.extraOptionIdentiNo"/>">
	                            </div> --%>
	                            <div class="option-label">
	                                <label for="chb<s:property value="#status.index+1" />"><s:property value="#extraOption.extraOptionName" /></label>
	                            </div>
	                            <div class="option-price">
	                                <span><s:property value="#extraOption.extraPrice" /></span>
	                                <input type="hidden" id="extraPrice<s:property value="#status.index" />" name="extraPrice" value="<s:property value="#extraOption.extraPrice" />">
	                                <span class="hours"><i><s:property value="#extraOption.extraTime" /> <s:property value="#extraOption.extraUnit" /></i></span>
	                            </div>
	                        </div>
                        </s:iterator>


                        <div class="clearfix"></div>
                    </form>
                </section>
                <input type="hidden" id="extraOptionIDs" name="extraOptionIDs" value="">
                <input type="hidden" id="touristIdentiNo" name="touristIdentiNo" value="<s:property value="#request.touristIdentiNo"/>">
				<input type="hidden" id="courseIdentiNo" name="courseIdentiNo" value="<s:property value="#request.courseIdentiNo"/>">
				<input type="hidden" id="langId" name="langId" value="<s:property value="#request.langId"/>">
				<input type="hidden" id="favoriteIdentiNo" name="favoriteIdentiNo" value="<s:property value="#request.favoriteIdentiNo"/>">
				<input type="hidden" id="curTouristIdentiNo" name="curTouristIdentiNo" value="<s:property value="#request.curTouristIdentiNo"/>">
				<input type="hidden" id="personOrGroup" name="personOrGroup" value="<s:property value="#request.personOrGroup"/>">
				<input type="hidden" id="largeDiscountFlg" name="largeDiscountFlg" value="<s:property value="#request.scheduleOptionListDisp.get(0).largeDiscountFlg"/>">
				<input type="hidden" id="largeDiscountType" name="largeDiscountType" value="<s:property value="#request.scheduleOptionListDisp.get(0).largeDiscountType"/>">
				<input type="hidden" id="largeDiscountPercent" name="largeDiscountPercent" value="<s:property value="#request.scheduleOptionListDisp.get(0).largeDiscountPercent"/>">
				<input type="hidden" id="largeDiscountValue" name="largeDiscountValue" value="<s:property value="#request.scheduleOptionListDisp.get(0).largeDiscountValue"/>">
				<input type="hidden" id="largeGroupLimit" name="largeGroupLimit" value="<s:property value="#request.scheduleOptionListDisp.get(0).largeGroupLimit"/>">
				<input type="hidden" id="price" name="price" value="<s:property value="#request.scheduleOptionListDisp.get(0).price"/>">
				<input type="hidden" id="curPrice" name="curPrice" value="">

				<s:hidden id="localhostIdentiNo" name="localhostIdentiNo" value="" />
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
		<script src="js/bootstrap-dialog.min.js"></script>
		<script src="js/HoldOn.min.js"></script>
		<script src="js/localhostCourseList.js"></script>
		<script src="js/localhostHeader.js" type="text/javascript"></script>

		<!-- inline scripts related to this page -->
</body>
</html>