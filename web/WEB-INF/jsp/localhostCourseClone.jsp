<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import= "com.kootour.common.KooConst"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.lang.String"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset="utf-8">
		<title>Clone Course | Kootour</title>

		<meta name="description" content="overview &amp; stats">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="/css/chosen.min.css" />
		<link rel="stylesheet" href="/css/daterangepicker.css" />
		<link rel="stylesheet" href="/css/fileinput.min.css" />
		<link rel="stylesheet" href="/css/jquery.timepicker.css" />
		<link rel="stylesheet" href="/css/HoldOn.min.css" />
		<link rel="stylesheet" href="/css/bootstrap-dialog.min.css" />
		<link rel="stylesheet" href="/summernote/summernote.css" />

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
								<a href="#">Clone Course</a>
							</li>

						</ul>
					</div>

					<div class="page-content">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="widget-box kootour-widget-color-main light-border">
								<div class="widget-header">
									<h4 class="widget-title lighter">
										<span class="white">Clone Course</span>
									</h4>
								</div>


								<div class="widget-body">
									<div class="widget-main">
										<div id="fuelux-wizard-container">
											<div>
												<ul class="steps">
													<li data-step="1" class="active">
														<span class="step kootour-main-color">1</span>
													<span class="title kootour-main-color">Tour Type</span>
												</li>

												<li data-step="2">
													<span class="step kootour-main-color">2</span>
													<span class="title kootour-main-color">Overview</span>
												</li>

												<li data-step="3">
													<span class="step kootour-main-color">3</span>
													<span class="title kootour-main-color">Booking Details</span>
												</li>

												<li data-step="4">
													<span class="step kootour-main-color">4</span>
													<span class="title kootour-main-color">Schedule&amp;Price</span>
												</li>

												<li data-step="5">
													<span class="step kootour-main-color">5</span>
													<span class="title kootour-main-color">Pictures</span>
												</li>
												
												<li data-step="6">
													<span class="step kootour-main-color">6</span>
													<span class="title kootour-main-color">Preview</span>
												</li>
											</ul>
										</div>

										<hr>
										<form class="form-horizontal" id="course_form" method="post">

										<div class="step-content pos-rel">

											<div class="step-pane" data-step="1">
												<h4 class="lighter block kootour-main-color">1.Name of your Tour</h4>
												<div class="form-validator"><div class="clearfix"><input id="fullName" type="text" name="fullName" class="form-control" name="fullName"/></div></div>
												<hr>
												<h4 class="lighter block kootour-main-color">2.Type of your Tour</h4>
												<div class="control-group form-validator">
												<div class="row">
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="historical" >
														<span class="lbl">&nbsp;Historical&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="adventure" >
														<span class="lbl">&nbsp;Adventure&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="leisureSports" >
														<span class="lbl">&nbsp;Leisure Sports&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="cultureArts" >
														<span class="lbl">&nbsp;Culture&amp;Arts&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="natureRural" >
														<span class="lbl">&nbsp;Nature&amp;Rural&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="festivalEvents" >
														<span class="lbl">&nbsp;Festival&amp;Events&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="nightlifeParty" >
														<span class="lbl">&nbsp;Transportation&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="foodDrink" >
														<span class="lbl">&nbsp;Food&amp;Drink&nbsp;</span>
													</label>
												</div>
												<div class="checkbox col-xs-4">
													<label>
														<input type="checkbox" class="ace" name="tourType" id="shoppingMarket" >
														<span class="lbl">&nbsp;Shopping&amp;Market&nbsp;</span>
													</label>
												</div>
												</div>
												</div>
												<hr>
												<h4 class="lighter block kootour-main-color">3.Languages you can provide</h4>
												<div class="form-validator"><div class="clearfix">
												<select multiple="" class="chosen-select form-control" id="provideLanguages" data-placeholder="Choose one or more Languages..." name="useLangId">
													<option value="en">English</option>
													<option value="ja">Japanese</option>
													<option value="zh">Chinese</option>
												</select>
												</div></div>
											</div>
											<div class="step-pane" data-step="2">
											<h4 class="lighter block kootour-main-color">4.Overview of your tour</h4>
												<div id="editor1"></div>
												<div class="form-validator"><div class="clearfix"><input type="text" id="overview" name="overview" style="display:none"></div></div>
												<hr>
												<h4 class="lighter block kootour-main-color">5.Itinerary</h4>
												<div id="editor2"></div>
												<div class="form-validator"><div class="clearfix"><input type="text" id="itinerary" name="itinerary" style="display:none"></div></div>
												<hr>
												<h4 class="lighter block kootour-main-color">6.Important information</h4>
												<h5 class="block">Duration of the tour:</h5>
												<div class="form-validator"><div class="clearfix">
												<input type="number"id="duration" name="duration" />
												<select style="height: 100%" id="durationunit-select" name="durationUnit">
													<option value="1">Days</option>
													<option value="2">Hours</option>
													<option value="3">Minutes</option>
												</select>
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Tour Location:</h5>
												<div class="form-validator"><div class="clearfix">
												<%-- <input class="form-control" type="text" placeholder="e.g. Vancouver Downtown" id="tourLocation" name="tourLocation"/> --%>
													<select style="height: 100%" id="tourLocation" name="tourLocation">
														<s:iterator var="locationList" value="#request.locationMstList" status="status">
					                                        <option value="<s:property value="#locationList.cityName" />"><s:property value="#locationList.cityName" /></option>
				                                    	</s:iterator>
													
													</select>
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Meetup Location:</h5>
												<div class="form-validator"><div class="clearfix">
												<input class="form-control" type="text" placeholder="e.g. Will pick up at traveller's hotel" id="meetupLocation" name="meetupLocation"/>
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Inclusions:<button id="add_in" type="button" class="btn btn-white kootour-btn-main pull-right"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add More Inclusions</button></h5>
												<div>
												<div class="space-8"></div>
												<table id="inclusions-table" class="table table-striped table-bordered table-hover">
												<tbody >
													<tr>
													<td>
													<input type="text" name="inclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="inclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="inclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="inclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="inclusions" class="form-control" >
													</td>
													</tr>
												</tbody>
												</table>
												</div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Exclusions:<button id="add_ex" type="button" class="btn btn-white kootour-btn-main pull-right"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add More Exclusions</button></h5>
												<div>
												<div class="space-8"></div>
												<table id="exclusions-table" class="table table-striped table-bordered table-hover">
												<tbody>
													<tr>
													<td>
													<input type="text" name="exclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="exclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="exclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="exclusions" class="form-control" >
													</td>
													</tr>
													<tr>
													<td>
													<input type="text" name="exclusions" class="form-control" >
													</td>
													</tr>
												</tbody>
												</table>
												</div>

											</div>
											<div class="step-pane" data-step="3">
											<h4 class="lighter block kootour-main-color">7.Booking Details:</h4>
												<h5 class="block">Minimum people intake:</h5>
												<div class="form-validator"><div class="clearfix">
												<input type="number" id="minTouristNum" name="minTouristNum">
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Maximum People intake:</h5>
												<div class="form-validator"><div class="clearfix">
												<input type="number" id="maxTouristNum" name="maxTouristNum">
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Booking Type:</h5>
												<div class="form-validator"><div class="clearfix">
												<div class="control-group">
												<div class="radio">
													<label>
														<input type="radio" id="radiop" class="ace" value="P" name="personOrGroup">
														<span class="lbl">Per person</span>
													</label>
												</div>

												<div class="radio">
													<label>
														<input type="radio" id="radiog" class="ace" value="G" name="personOrGroup">
														<span class="lbl">Per group</span>
													</label>
												</div>
												</div></div>
												</div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Minimum booking hours in advance:</h5>
												<div class="form-validator"><div class="clearfix"><input type="number" id="minHourAdvance" name="minHourAdvance">&nbsp;hours</div></div>
											</div>
											<div class="step-pane" data-step="4">
												<h4 class="lighter block kootour-main-color">8.Add Your serving schedule Option:</h4>
												<h5 class="block">Schedule Name:</h5>
												<div class="form-validator"><div class="clearfix"><input class="form-control" type="text" placeholder="e.g.  Summer Morning Schedule" id="courseScheduleName" name="courseScheduleName"></div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Date From:</h5>
												<div class="form-validator"><div class="clearfix">
												<div class="input-group">
													<span class="input-group-addon">
													<i class="fa fa-clock-o"></i>
													</span>
												<input type="text" id="daterange" name="daterange">
												<input type="text" style="display:none;" id="bgnDate" name="bgnDate">
												<input type="text" style="display:none;" id="endDate" name="endDate">
												</div>
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Available Tour Days:</h5>
												<div class="form-validator"><div class="clearfix">
												<div id="availabledays" class="control-group">
												<div class="checkbox">
													<label>
														<input sort="1" type="checkbox" class="ace" name="workDay" value="0">
														<span class="lbl">Mon</span>
													</label>
												</div>

												<div class="checkbox">
													<label>
														<input sort="2" type="checkbox" class="ace" name="workDay" value="1">
														<span class="lbl">Tue</span>
													</label>
												</div>

												<div class="checkbox">
													<label>
														<input sort="3" type="checkbox" class="ace" name="workDay" value="2">
														<span class="lbl">Wed</span>
													</label>
												</div>

												<div class="checkbox">
													<label>
														<input sort="4" type="checkbox" class="ace" name="workDay" value="3">
														<span class="lbl">Thu</span>
													</label>
												</div>

												<div class="checkbox">
													<label>
														<input sort="5" type="checkbox" class="ace" name="workDay" value="4">
														<span class="lbl">Fri</span>
													</label>
												</div>

												<div class="checkbox">
													<label>
														<input sort="6" type="checkbox" class="ace" name="workDay" value="5">
														<span class="lbl">Sat</span>
													</label>
												</div>

												<div class="checkbox">
													<label>
														<input sort="7" type="checkbox" class="ace" name="workDay" value="6">
														<span class="lbl">Sun</span>
													</label>
												</div>
												</div>
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Extra value of this schedule:<!-- <button id="add_extra" type="button" class="btn btn-white kootour-btn-main pull-right"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add More</button> --></h5>
												<table id="extra-table" class="table table-striped table-bordered table-hover">
												<thead>
												<tr>
												<th>Extra Tour Option Name</th>
												<th>Price</th>
												<th>Extra Time</th>
												</tr>
												</thead>
												<tbody >
													<tr data-extra="true">
													<td><input class="form-control" type="text" placeholder="e.g. Snorking" name="extraNames"></td>
													<td class="form-validator"><input class="form-control" type="text" placeholder="20" name="extraPrices"></td>
													<td class="form-validator"><input class="form-control" type="text" placeholder="2hrs" name="extraTimes"></td>
													</tr>
													<tr data-extra="true">
													<td><input class="form-control" type="text" name="extraNames"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraPrices"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraTimes"></td>
													</tr>
													<tr data-extra="true">
													<td><input class="form-control" type="text" name="extraNames"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraPrices"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraTimes"></td>
													</tr>
													<tr data-extra="true">
													<td><input class="form-control" type="text" name="extraNames"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraPrices"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraTimes"></td>
													</tr>
													<tr data-extra="true">
													<td><input class="form-control" type="text" name="extraNames"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraPrices"></td>
													<td class="form-validator"><input class="form-control" type="text" name="extraTimes"></td>
													</tr>
												</tbody>
												</table>
												<div id="discount">
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Discount for larger group</h5>
												<div class="form-validator"><div class="clearfix">
												<span>If >= </span>
												<input style="margin-left:10px;" type="number" id="discountTourists" name="discountTourists">
												<span>tourists are booked, then give $</span>
												<input style="margin-left:10px;" type="number" id="discountValue" name="discountValue">
												<span>or</span>
												<input style="margin-left:10px;" type="number" id="discountPercent" name="discountPercent">
												<span>% discount.</span></div></div>
												</div>

												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Earliest/Lastest Start Time:</h5>
												<div class="space-8"></div>
												<div class="start_time_child">
												<div class="form-validator"><div class="clearfix">
												<div class="input-group" id="pairtimepicker0">
													<span class="input-group-addon">
													<i class="fa fa-clock-o"></i>
													</span>
													<input id="earliestStartHour0" class="time start" type="text" name="earliestStartHours"> to
													<input id="lastestStartHour0" class="time end" type="text" name="lastestStartHours">
												</div>
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Suggested Retail Price:</h5>
												<div class="form-validator"><div class="clearfix">
												<input type="number" id="retailprice0" name="retailPrices">
												</div></div>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Commision pay to Kootour:</h5>
												<select disabled="disabled" id="commision0"  name="commisions">
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12">12</option>
													<option value="13">13</option>
													<option value="14">14</option>
													<option value="15">15</option>
													<option value="16">16</option>
													<option value="17">17</option>
													<option value="18">18</option>
													<option value="19">19</option>
													<option value="20" selected="selected">20</option>
													<option value="21">21</option>
													<option value="22">22</option>
													<option value="23">23</option>
													<option value="24">24</option>
													<option value="25">25</option>
												</select>
												<label>%(Percentage)</label>
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Net Price:</h5>
												<h5 class="block netprices" id="netprice0">0</h5>
												</div>





												<!--
												<div class="hr hr-8 hr-dotted"></div>
												<h5 class="block">Earliest/Lastest Start Time:<button id="add_start_time" type="button" class="btn btn-white kootour-btn-main pull-right"><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add More Time</button></h5>
												<div class="space-8"></div>
												<div class="row start_time_more">
												<div class="col-xs-4 start_time_child">
												<div class="form-validator"><div class="clearfix">
												<div class="input-group" id="pairtimepicker0">
													<span class="input-group-addon">
													<i class="fa fa-clock-o"></i>
													</span>
													<input id="earliestStartHour0" class="time start" type="text" name="earliestStartHours"> to
													<input id="lastestStartHour0" class="time end" type="text" name="lastestStartHours">
												</div>
												</div></div>
												<div class="space-8"></div>
												<h5 class="block">Suggested Retail Price:</h5>
												<div class="form-validator"><div class="clearfix">
												<input type="number" id="retailprice0" name="retailPrices">
												</div></div>
												<div class="space-8"></div>
												<h5 class="block">Commision pay to Kootour:</h5>
												<select id="commision0"  name="commisions">
													<option value="8">8</option>
													<option value="9">9</option>
													<option value="10">10</option>
													<option value="11">11</option>
													<option value="12" selected="selected">12</option>
													<option value="13">13</option>
													<option value="14">14</option>
													<option value="15" >15</option>
													<option value="16">16</option>
													<option value="17">17</option>
													<option value="18">18</option>
													<option value="19">19</option>
													<option value="20">20</option>
													<option value="21">21</option>
													<option value="22">22</option>
													<option value="23">23</option>
													<option value="24">24</option>
													<option value="25">25</option>
												</select>
												<label>%(Percentage)</label>
												<div class="space-8"></div>
												<h5 class="block">Net Price:</h5>
												<h5 class="block netprices" id="netprice0">0</h5>
												</div>
												</div>
												<div class="hr hr-8"></div>
												<div class="align-right"><button id="addscheduleoption" type="button" class="btn btn-white kootour-btn-main">Add this schedule option</button></div>
												<div class="space-8"></div>
												<div id="schedulelist" class="widget-container-col">

												</div>
												-->
											</div>
											<div class="step-pane" data-step="5">

											<h4 class="lighter block kootour-main-color">9. Have been uploaded images:</h4>
											<div class="row clearfix">
											<div id="uploaded-images">
											<span class="center">There is no image here.</span>
											</div>
											</div>
											<div class="hr hr-8"></div>

											<h4 class="lighter block kootour-main-color">10. Upload Pictures:</h4>
												<h5 class="block">Upload up to five color photos that represent your tour or activity. </h5>
												<h5 class="block">Don’t show logo or company name.</h5>
												<form id="uploadForm" action="" method="post" target="_self" enctype="multipart/form-data">
												<input id="input-dim-1" name="file" type="file" multiple class="file-loading" accept="image/*">
												</form>
											</div>
											
											
											<div class="step-pane" data-step="6">
												<% 
												%>
												 <div class="row">
												<div class="left-column col-lg-8 col-md-8 col-sm-12 col-xs-12">
                <section id="prev-carousel-kootour-section" class="carousel-kootour carousel-kootour-section nopadding col-xs-12">
                    <%-- <!-- carousel -->
                    <div id="carousel-kootour" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol id="prev-carousel-kootour" class="carousel-indicators">
                            <!-- <li data-target="#carousel-kootour" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-kootour" data-slide-to="1"></li>
                            <li data-target="#carousel-kootour" data-slide-to="2"></li> -->
                            
                             
                           	</ol>
                           	 <!-- Wrapper for slides -->
                        <div id="prev-carousel-inner" class="carousel-inner" role="listbox">
                          	
                        </div>
                    </div>
                    
                    <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-kootour" role="button" data-slide="prev">
                            <span class="icon icon-prev" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-kootour" role="button" data-slide="next">
                            <span class="icon icon-next" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a> --%>
                </section>
                
                 <section class="tour-detail section noborder nomargin col-xs-12">
                    <div class="tour-descriptions">
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_time_bgwhite_300X300.png" alt="time">
                                </td>

                                <td>
                                    <s:label id="prevDuration2" /> <s:label id="prevDurationUnit2" />
                                </td>
                            </tr>
                        </table>
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_luggage_bgwhite_300X300.png" alt="luggage">
                                </td>

                                <td>
                                    <s:label id="prevMinTouristNum" />-<s:label id="prevMaxTouristNum" /> travellers
                                </td>
                            </tr>
                        </table>
                        <table class="tour-description">
                            <tr>
                                <td>
                                    <img class="icon" src="images/icons/icon_location_bgwhite_300X300.png" alt="location">
                                </td>

                                <td>
                                    <s:label id="prevTourLocation" />
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
                                    <s:label id="prevUseLangId"/>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <h2 class="blue" id="prevFullName">&nbsp;<small>($<s:label id="prevRetailPrice"/> per person/group)</small></h2>

                    <%-- <div class="vote-wrapper">
                        <ul class="vote">
                            <s:iterator var="scoreIconItem" value="#request.scoreIconListDisp" status="status">
                            	<li><img src="<s:property value="scoreIconItem" />"></li>
                            </s:iterator>
                        </ul>
                         <span class="vote-label"><s:property value="#request.reviewNumDisp"/> reviews</span>
                    </div> --%>
                </section>
                
                <section class="section col-xs-12">
                    <span class="title">Tour Summary</span>
                    <div id="readmore1">
                            <p id="prevCourseContent" style="width: 100%;word-wrap:break-word;word-break:break-word;"></p>
                            <%-- <table style="width: 100%;">
                            <tr>
                                <td id="prevCourseContent" style="width: 100%;word-wrap:break-word;word-break:break-all;"></td>
                            </tr>
                            </table> --%>

                            <span class="subtitle">Tour itinerary</span>
                            
                            <p id="prevAdditionalInfo" style="width: 100%;word-wrap:break-word;word-break:break-word;"></p>
                            <%-- <table style="width: 100%;">
                            <tr>
                                <td id="prevAdditionalInfo" style="width: 100%;word-wrap:break-word;word-break:break-all;"></td>
                            </tr>
                            </table> --%>
                    </div>
                </section>
                
                <section class="section col-xs-12">
                    <span class="title">Important Information</span>

                    <div id="readmore2">
                        <table class="table-information col-lg-6 col-md-12 col-sm-12 col-xs-12">
                            <tr>
                                <td class="subtitle">Tour Location</td>
                                <td><s:label id="prevTourLocation2" /></td>
                            </tr>
                            <tr>
                                <td class="subtitle">Duration</td>
                                <td><s:label id="prevDuration" />
                                <s:label id="prevDurationUnit" /></td>
                            </tr>
                            <tr>
                                <td class="subtitle">Meetup Location</td>
                                <td><s:label id="prevMeetupLocation" /></td>
                            </tr>
                        </table>

                        <div class="clearfix"></div>

                        <p class="subtitle">Inclusions</p>
                        <ul id="prevInclusions"></ul>
                        <%-- <ul>
                            <s:iterator var="inclusionItem" value="#request.inclusionListDisp" status="status">
                            	<li><s:property value="#inclusionItem.inExclusion" /></li>
                            </s:iterator>
                        </ul>--%>

                        <p class="subtitle">Exclusions</p>
                        <ul id="prevExclusions"></ul>
                        <%-- <ul>
                            <s:iterator var="exclusionItem" value="#request.exclusionListDisp" status="status">
                            	<li><s:property value="#exclusionItem.inExclusion" /></li>
                            </s:iterator>
                        </ul>  --%>
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
                        <div id="prevCustomized" class="widget-row customized-option">
                        </div>
						<%-- <s:iterator var="extraOption" value="#request.extraOptionListDisp" status="status">
	                        <div class="widget-row customized-option">
	                            <div class="option-checkbox">
	                                <input type="checkbox" id="chb<s:property value="#status.index+1" />" onchange="checkChange('chb<s:property value="#status.index+1" />','<s:property value="#extraOption.extraPrice" />');" name="checkbox" class="checkbox" />
	                                <label for="chb<s:property value="#status.index+1" />"></label>
	                                <input type="hidden" id="extraOptionIdentiNo<s:property value="#status.index" />" value="<s:property value="#extraOption.extraOptionIdentiNo"/>">
	                            </div>
	                            <div class="option-label">
	                                <label for="chb<s:property value="#status.index+1" />"><s:property value="#extraOption.extraOptionName" /></label>
	                            </div>
	                            <div class="option-price">
	                                <span><s:property value="#extraOption.extraPrice" /></span>
	                                <input type="hidden" id="extraPrice<s:property value="#status.index" />" name="extraPrice" value="<s:property value="#extraOption.extraPrice" />">
	                                <span class="hours"><i><s:property value="#extraOption.extraTime" /> <s:property value="#extraOption.extraUnit" /></i></span>
	                            </div>
	                        </div>
                        </s:iterator> --%>
                        
                        
                    </form>
                </section>
            </div>
		</div>						
											<% 
												%>
											</div>
											
											
											
											
										</div>
										</form>
										</div>
											<hr>
											<div class="wizard-actions">
												<button class="btn btn-prev" disabled="disabled">
													<i class="ace-icon fa fa-arrow-left"></i>
													Prev
												</button>

												<button class="btn btn-success btn-next" data-last="Finish">
													Next
													<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
												</button>
											</div>
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
		<script src="js/chosen.jquery.min.js" type="text/javascript"></script>
		<script src="summernote/summernote.min.js"></script>
		<script src="js/moment.min.js"></script>
		<script src="js/daterangepicker.js"></script>
		<script src="js/bootbox.min.js"></script>
		<script src="js/fileinput.js"></script>
		<script src="js/fuelux.wizard.min.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/jquery.timepicker.min.js"></script>
		<script src="js/jquery.datepair.min.js"></script>
		<script src="js/jquery.nestable.min.js"></script>
		<script src="js/HoldOn.min.js"></script>
		<script src="js/bootstrap-dialog.min.js"></script>
		<script src="js/localhostCourseClone.js" type="text/javascript"></script>
		<script src="js/localhostHeader.js" type="text/javascript"></script>

		<!-- inline scripts related to this page -->
</body>
</html>
