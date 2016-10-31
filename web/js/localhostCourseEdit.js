$(document).ready(function() {
	$('[data-rel=tooltip]').tooltip();

	$('#fuelux-wizard-container')
	.ace_wizard({
	})
	.on('actionclicked.fu.wizard' , function(e, info){
		var flg = true;
		if(info.step == 1) {
			for (var n = 0; n < $("div[data-step='1']").find("[name]").length; n++ ) {
				var target = $("div[data-step='1']").find("[name]").get(n);
				if (!$(target).hasClass("ignore")) {
					if (!$(target).valid()) {
						flg = false;
					}
				}
			}
			return flg;
		}
		else if (info.step == 2) {
			$("#overview").val($('#editor1').summernote('code'));
			$("#itinerary").val($('#editor2').summernote('code'));
			for (var n = 0; n < $("div[data-step='2']").find("[name]").length; n++ ) {
				var target = $("div[data-step='2']").find("[name]").get(n);
				if (!$(target).hasClass("ignore")) {
					if (!$(target).valid()) {
						flg = false;
					}
				}
			}
			return flg;
		}
		else if (info.step == 3) {
			for (var n = 0; n < $("div[data-step='3']").find("[name]").length; n++ ) {
				var target = $("div[data-step='3']").find("[name]").get(n);
				if (!$(target).hasClass("ignore")) {
					if (!$(target).valid()) {
						flg = false;
					}
				}
			}
			return flg;
		}
		else if (info.step == 4) {
			for (var n = 0; n < $("div[data-step='4']").find("[name]").length; n++ ) {
				var target = $("div[data-step='4']").find("[name]").get(n);
				if (!$(target).hasClass("ignore")) {
					if (!$(target).valid()) {
						flg = false;
					}
				}
			}
			return flg;
		}
		else if (info.step == 5) {
			    $("#prevDuration").html($('input[name=duration]').val());
			
			var select1 = $("#durationunit-select");
			var sel=document.getElementById("durationunit-select");
			$("#prevDurationUnit").html(sel.options[sel.selectedIndex].innerHTML);
			
			$("#prevMinTouristNum").html($('input[name=minTouristNum]').val());
			$("#prevMaxTouristNum").html($('input[name=maxTouristNum]').val());
			// $("#prevTourLocation").html($('input[name=tourLocation]').val());
			$("#prevTourLocation").html($("#tourLocation").val());
			// $("#prevUseLangId").html( $("#provideLanguages").val().join(";"));
			// $("#prevFullName").html($('input[name=fullName]').val());
			$("#prevFullName").children().remove();
			var fullNameHtml = $('input[name=fullName]').val() + '&nbsp;<small>($<s:label id="prevRetailPrice"/> per person/group)</small>';
			$("#prevFullName").append(fullNameHtml);
			
			//var prevCommision = $("#commision0").val()
			//var prevV = ($("#retailprice0").val() * (1 - prevCommision/100)).toFixed(2);
			//$("#netprice0").html(prevV);
			$("#prevRetailPrice").html($("#retailprice0").val());
			
			var useLang = '';
			var prevI = 0 ;
			 $("#provideLanguages :selected").each(function(){
				 if ( prevI == 0 ) {
					 useLang = useLang + $(this).text();
					 prevI = prevI + 1 ;
				 } else {
					 useLang = useLang + '&' + $(this).text();
				 }
			 });
			 $("#prevUseLangId").html(useLang);
			
			 
			 $("#prevCourseContent").html($('#editor1').summernote('code'));
			 $("#prevAdditionalInfo").html($('#editor2').summernote('code'));
			 
			 // $("#prevTourLocation2").html($('input[name=tourLocation]').val());
			 $("#prevTourLocation2").html($("#tourLocation").val());
			 $("#prevDuration2").html($('input[name=duration]').val());
			 $("#prevDurationUnit2").html(sel.options[sel.selectedIndex].innerHTML);
			 $("#prevMeetupLocation").html($('input[name=meetupLocation]').val());
			 
			 $("#prevInclusions").children().remove();
			 $("#prevExclusions").children().remove();
			 for (var x in $("input[name=inclusions]")) {
				var v = $("input[name=inclusions]").eq(x).val();
				if (v != null && v != "") {
					var trHtml='<li>' + v + '</li>';
					$("#prevInclusions").append(trHtml);
				}
			 }
			 for (var x in $("input[name=exclusions]")) {
				var v = $("input[name=exclusions]").eq(x).val();
				if (v != null && v != "") {
					var trHtml='<li>' + v + '</li>';
					$("#prevExclusions").append(trHtml);
				}
			 }
			 
			 $("#prevCustomized").children().remove();
			 for (var i = 0; i < $("[name=extraNames]").size(); i++) {
				if ($("[name=extraNames]").eq(i).val() != "" && $("[name=extraPrices]").eq(i).val() != "" && $("[name=extraTimes]").eq(i).val() != "") {
					var extraOptionName = $("[name=extraNames]").eq(i).val();
					var extraPrice = $("[name=extraPrices]").eq(i).val();
					var extraTime = $("[name=extraTimes]").eq(i).val();
					var divHtml = '<div class="option-label"><label for="chb' + (i+1)  + '">' + extraOptionName
								 + '</div><div class="option-price"><span>$' + extraPrice
								 + '</span><span class="hours"><i>' + extraTime + ' Hr(s)</i></span></div>' ;
					
					$("#prevCustomized").append(divHtml);
					
				} else {
					continue;
				}
			 }
			 
			 
			 
			 $.ajax({
					url: 'localhostCourseEditAjax/editCoursePicturesPrev',
					type: 'post',
					async: false,
					dataType: 'json',
					data:{
						courseIdentiNo:getUrlParam('courseIdentiNo')
			        },
					success: function(json) {
						var obj = JSON.parse(json);
						if (obj.result == 'success') {
							
							var picturePathList = obj.data;
							
							var prevHtml1 = '';
							var prevHtml2= '';
							
							var uploadPath ="../upload/images/";
							//var  Path ="./localImages/";
							if (picturePathList != null && picturePathList.length > 0) {
								// $("#prev-carousel-kootour").children().remove();
								// $("#prev-carousel-inner").children().remove();
								for (var n in picturePathList) {
									
									//　var prevHtml1= '' ;
									if (n == 0) {
										prevHtml1 = prevHtml1 +
											'<li data-target="#carousel-kootour" data-slide-to="' + n + '" class="active"></li>'; 
									} else {
										prevHtml1 = prevHtml1 +
											'<li data-target="#carousel-kootour" data-slide-to="' + n + '"></li>';
									}
									// $("#prev-carousel-kootour").append(prevHtml1);
									
									
									// var prevHtml2= '' ;
									if (n == 0) {
										prevHtml2 = prevHtml2 +
											'<div class="item active">'; 
									} else {
										prevHtml2 = prevHtml2 +
											'<div class="item">';
									}
									prevHtml2 = prevHtml2 + '<img width="100%" src="'+ uploadPath + picturePathList[n] +'" style="display: inline;">'+
											'</div>';
									// $("#prev-carousel-inner").append(prevHtml2);
								}
							}
							
							var htmm = 
						         '<!-- carousel -->' + 
						         '<div class="carousel slide" id="carousel-kootour" data-ride="carousel">' + 
						             '<!-- Indicators -->' + 
						             '<ol class="carousel-indicators" id="prev-carousel-kootour">' + 
						                 '<!-- <li data-target="#carousel-kootour" data-slide-to="0" class="active"></li>' + 
						                 '<li data-target="#carousel-kootour" data-slide-to="1"></li>' + 
						                 '<li data-target="#carousel-kootour" data-slide-to="2"></li> -->' + 
						                  
						                 prevHtml1 + '</ol>' + 
						                	 '<!-- Wrapper for slides -->' + 
						             '<div class="carousel-inner" id="prev-carousel-inner" role="listbox">' + 
						               	    
						             prevHtml2 + '</div>' + 
						         '</div>' + 
						         
						         '<!-- Controls -->' + 
						            '<a class="left carousel-control" role="button" href="#carousel-kootour" data-slide="prev">' + 
						                 '<span class="icon icon-prev" aria-hidden="true"></span>' + 
						                 '<span class="sr-only">Previous</span>' + 
						             '</a>' + 
						             '<a class="right carousel-control" role="button" href="#carousel-kootour" data-slide="next">' + 
						                 '<span class="icon icon-next" aria-hidden="true"></span>' + 
						                 '<span class="sr-only"> </span>' +
						             '</a>';
									 
							 $("#prev-carousel-kootour-section").children().remove();
							 $("#prev-carousel-kootour-section").append(htmm);

						} else {
							BootstrapDialog.show({
								title: 'Error',
							    message: obj.message,
							    buttons: [{
							   		label: 'Close',
							        action: function(dialog) {
							        	dialog.close();
							        }
							    }]
							});
						}
					},
					error: function(json) {
						var obj = JSON.parse(json);
						BootstrapDialog.show({
							title: 'Error',
						    message: obj.message,
						    buttons: [{
						   		label: 'Close',
						        action: function(dialog) {
						        	dialog.close();
						        }
						    }]
						});
					}
				});
		}
	})
	.on('finished.fu.wizard', function(e) {
		if ($(".progress-bar-success").size() == 0 && $("#uploaded-images").children().size() == 0) {
			BootstrapDialog.show({
				title: 'Error',
			    message: "Please upload image first.",
			    buttons: [{
			   		label: 'Close',
			        action: function(dialog) {
			        	dialog.close();
			        	return false;
			        }
			    }]
			});
		} else {
			HoldOn.open({message:"Editing...",theme:"sk-dot"});
			var obj = new Object();
			obj.courseIdentiNo = getUrlParam('courseIdentiNo');
			if ($("#provideLanguages").val() != null) {
				obj.useLangId = $("#provideLanguages").val().join(";");
			} else {
				obj.useLangId = "";
			}
			obj.courseContent = $('#editor1').summernote('code');
			obj.additionalInfo = $('#editor2').summernote('code');


			$.ajax({
				url: 'localhostCourseEditAjax/updateCourse',
				type: 'post',
				dataType: 'json',
				data: {"jsonFromWeb": JSON.stringify(obj)},
				success: function(json) {
					var obj = JSON.parse(json);
					if (obj.result == 'success') {
						HoldOn.close();
						window.location.href="localhostCourseList!load";
					} else {
						BootstrapDialog.show({
							title: 'Error',
						    message: obj.message,
						    buttons: [{
						   		label: 'Close',
						        action: function(dialog) {
						        	dialog.close();
						        }
						    }]
						});
					}
				},
				error: function(json) {
					var obj = JSON.parse(json);
					BootstrapDialog.show({
						title: 'Error',
					    message: obj.message,
					    buttons: [{
					   		label: 'Close',
					        action: function(dialog) {
					        	dialog.close();
					        }
					    }]
					});
				}
			});
		}
		
	})
        .on('changed.fu.wizard', function(e, info){
		
		if (info.step == 6) {

	  }
	}).on('stepclick.fu.wizard', function(e){
	});

	jQuery.validator.addMethod("maxmincheck", function(value, element, params) {
		var destVal = $(params).val();
		return this.optional(element) || parseInt(destVal) <= parseInt(value);
	}, "Maximum People must be greater than min minimum people.");

	$('#course_form').validate({
		errorElement: 'div',
		ignore: ".ignore",
		errorClass: 'help-block',
		focusInvalid: true,
		rules: {
			fullName: {
				required: true
			},
			tourType: {
				required: true,
				minlength:1,
				maxlength:3
			},
			useLangId: {
				required: true
			},
			overview: {
				required: true
			},
			itinerary: {
				required: true
			},
			duration: {
				required: true,
				digits: true
			},
			tourLocation: {
				required: true
			},
			meetupLocation: {
				required: true
			},
			minTouristNum: {
				required: true,
				digits: true
			},
			maxTouristNum: {
				required: true,
				digits: true,
				maxmincheck: "#minTouristNum"
			},
			personOrGroup: {
				required: true
			},
			minHourAdvance: {
				required: true,
				digits: true
			},
			courseScheduleName: {
				required: true
			},
			daterange: {
				required: true
			},
			workDay: {
				required: true
			},
			earliestStartHours: {
				required: true,
			},
			retailPrices: {
				required: true,
				digits: true
			},
			extraPrices: {
				number: true
			},
			extraTimes: {
				digits: true
			},
			discountTourists: {
				digits: true
			},
			discountValue: {
				digits: true
			},
			discountPercent: {
				digits: true
			},
		},

		messages: {
		},

		highlight: function (e) {
			$(e).closest('.form-validator').removeClass('has-info').addClass('has-error');
		},

		success: function (e) {
			$(e).closest('.form-validator').removeClass('has-error');//.addClass('has-info');
			$(e).remove();
		},

		errorPlacement: function (error, element) {
			if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
				var controls = element.closest('div[class*="control-"]');
				if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
				else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
			}

			else if(element.is('.select2')) {
				error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
			}
			else if(element.is('.chosen-select')) {
				error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
			}
			else if (element.is("input[name=extraTimes]") || element.is("input[name=extraPrices]") ) {
				error.insertAfter(element);
			}
			else error.insertAfter(element.parent());
		},

		submitHandler: function (form) {
			form.submit();
		},

		invalidHandler: function (form) {
			BootstrapDialog.show({
				title: 'Error',
			    message: 'You missed some fields. They have been highlighted below.',
			    buttons: [{
			   		label: 'Close',
			        action: function(dialog) {
			        	dialog.close();
			        }
			    }]
			});
		}
	});

	$('#modal-wizard-container').ace_wizard();
	$('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');

	if(!ace.vars['touch']) {
		$('.chosen-select').chosen({allow_single_deselect:true});
		//resize the chosen on window resize

		$(window)
		.off('resize.chosen')
		.on('resize.chosen', function() {
			$('.chosen-select').each(function() {
				 var $this = $(this);
				 $this.next().css({'width': $this.parent().width()});
			})
		}).trigger('resize.chosen');
		//resize chosen on sidebar collapse/expand
		$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
			if(event_name != 'sidebar_collapsed') return;
			$('.chosen-select').each(function() {
				 var $this = $(this);
				 $this.next().css({'width': $this.parent().width()});
			})
		});


		$('#chosen-multiple-style .btn').on('click', function(e){
			var target = $(this).find('input[type=radio]');
			var which = parseInt(target.val());
			if(which == 2) $('#provideLanguages').addClass('tag-input-style');
			 else $('#provideLanguages').removeClass('tag-input-style');
		});
	}

		$('#editor1').summernote({
			 height: 200,
			  toolbar: [
			            ['style', ['bold', 'italic', 'underline', 'clear']],
			            ['font', ['strikethrough', 'superscript', 'subscript']],
			            ['fontsize', ['fontsize']],
			            ['para', ['ul', 'ol', 'paragraph']],
			            ['height', ['height']]
			          ]
		});

		$('#editor2').summernote({
			 height: 200,
			  toolbar: [
			            ['style', ['bold', 'italic', 'underline', 'clear']],
			            ['font', ['strikethrough', 'superscript', 'subscript']],
			            ['fontsize', ['fontsize']],
			            ['para', ['ul', 'ol', 'paragraph']],
			            ['height', ['height']]
			          ]
		});

		//or change it into a date range picker
	    $('#daterange').daterangepicker({
	        locale: {
	            format: 'YYYYMMDD'
	        },
	        minDate: new Date(),
	        "showDropdowns": true,
	        "autoApply": true,
	        startDate: moment().format('YYYYMMDD'),
	        endDate: moment().add(1, 'd').format('YYYYMMDD')
	    });
    	$('#bgnDate').val(moment().format('YYYYMMDD'));
    	$('#endDate').val(moment().add(1, 'd').format('YYYYMMDD'));
	    $('#daterange').on('apply.daterangepicker', function(ev, picker) {
	    	$('#bgnDate').val(picker.startDate.format('YYYYMMDD'));
	    	$('#endDate').val(picker.endDate.format('YYYYMMDD'));
	    });

		$('input[name=date-range-picker]').daterangepicker({
			'applyClass' : 'btn-sm btn-success',
			'cancelClass' : 'btn-sm btn-default',
			locale: {
				applyLabel: 'Apply',
				cancelLabel: 'Cancel',
			}
		})
		.prev().on(ace.click_event, function(){
			$(this).next().focus();
		});

		$('#pairtimepicker0 .time').timepicker({'show2400' : true, 'timeFormat' : "H:i", 'showDuration': true});
		$('#pairtimepicker0').datepair();

		$("#add_in").click(function(){
			var tableSize = $("#inclusions-table tr").size();
			for (var i = 0; i <= 4; i++) {
				var trHtml='<tr><td><input type="text" name="inclusions" class="form-control" ></td></tr>';
				$("#inclusions-table tr:last").after(trHtml);
			}
		});

		$("#add_ex").click(function(){
			var tableSize = $("#exclusions-table tr").size();
			for (var i = 0; i <= 4; i++) {
				var trHtml='<tr><td><input type="text" name="exclusions" class="form-control" ></td></tr>';
				$("#exclusions-table tr:last").after(trHtml);
			}
		});

		$('input:radio[name="personOrGroup"]').change(function(){
			if ($(this).is(':checked') && $(this).val() == 'G') {
				$("#discount").hide();
			} else {
				$("#discount").show();
			}
		});


		$("#retailprice0").on('input', function(){
			var commision = $("#commision0").val()
			var v = ($("#retailprice0").val() * (1 - commision/100)).toFixed(2);
			$("#netprice0").html(v);
		});

		$("#commision0").on('change', function(){
			var commision = $(this).val()
			var v = ($("#retailprice0").val() * (1 - commision/100)).toFixed(2);
			$("#netprice0").html(v);
		});

		$("#discountValue").on('input', function(){
			$("#discountPercent").val('');
		});

		$("#discountPercent").on('input', function(){
			$("#discountValue").val('');
		});

	    $("#input-dim-1").fileinput({
	    	language: 'en', //设置语言
	    	showCaption: false,//是否显示标题
	    	browseClass: "btn btn-primary", //按钮样式
	    	maxFileCount: 5,
	        uploadUrl: "localhostReceivedBooking/uploadImage",
	        allowedFileExtensions: ["jpg", "png", "jpeg"],
	        maxFileSize: 5000,
	        uploadExtraData: {
	            img_key: "1000",
	            img_keywords: "happy, people",
	        }
	    });


		$.ajax({
			url: 'localhostCourseEditAjax/editCourseInit',
			type: 'post',
			dataType: 'json',
			data:{
				courseIdentiNo:getUrlParam('courseIdentiNo')
	        },
			success: function(json) {
				var obj = JSON.parse(json);
				if (obj.result == 'success') {
					var courseEntity =   obj.data.courseEntity;
					var scheduleOptionEntity = obj.data.scheduleOptionEntity;
					var extraOptionEntityList = obj.data.extraOptionEntityList;
					var coursePictureEntityList = obj.data.coursePictureEntityList;
//					var scheduleOptionEntityList = obj.data.scheduleOptionEntityList;
					var courseInExclusionEntityList = obj.data.courseInExclusionEntityList;
					var courseExtraOptionEntityList = obj.data.extraOptionEntityList;
					
					$('input[name=fullName]').val(courseEntity.fullName);
					(courseEntity.historical == "1") ? $('#historical').prop("checked", true) : $('#historical').prop("checked", false);
					(courseEntity.adventure == "1") ? $('#adventure').prop("checked", true) : $('#adventure').prop("checked", false);
					(courseEntity.leisureSports == "1") ? $('#leisureSports').prop("checked", true) : $('#leisureSports').prop("checked", false);
					(courseEntity.cultureArts == "1") ? $('#cultureArts').prop("checked", true) : $('#cultureArts').prop("checked", false);
					(courseEntity.natureRural == "1") ? $('#natureRural').prop("checked", true) : $('#natureRural').prop("checked", false);
					(courseEntity.festivalEvents == "1") ? $('#festivalEvents').prop("checked", true) : $('#festivalEvents').prop("checked", false);
					(courseEntity.nightlifeParty == "1") ? $('#nightlifeParty').prop("checked", true) : $('#nightlifeParty').prop("checked", false);
					(courseEntity.foodDrink == "1") ? $('#foodDrink').prop("checked", true) : $('#foodDrink').prop("checked", false);
					(courseEntity.shoppingMarket == "1") ? $('#shoppingMarket').prop("checked", true) : $('#shoppingMarket').prop("checked", false);
					var userLangIdArray = courseEntity.useLangId.split(";")
			        $('.chosen-select').val(userLangIdArray).trigger('chosen:updated');
					$("#editor1").summernote('code', courseEntity.courseContent);
					$('#editor2').summernote('code', courseEntity.additionalInfo);
					$('input[name=duration]').val(courseEntity.duration);
					$("#durationunit-select").val(courseEntity.durationUnit);
					//$('input[name=tourLocation]').val(courseEntity.tourLocation);
					$("#tourLocation").val(courseEntity.tourLocation);
					$('input[name=meetupLocation]').val(courseEntity.meetupLocation);

					var inArray = new Array();
					var exArray = new Array();

					for (var n in courseInExclusionEntityList) {
						if (courseInExclusionEntityList[n].inExclusionType == "1") {
							inArray.push(courseInExclusionEntityList[n].inExclusion);
						} else {
							exArray.push(courseInExclusionEntityList[n].inExclusion);
						}
					}

					for (var n in inArray) {
						if (n < 5) {
							$("input[name=inclusions]").eq(n).val(inArray[n]);
						} else {
							var trHtml='<tr><td><input type="text" name="inclusions" class="form-control" ></td></tr>';
							var inStr = '#inclusions' + newSize;
							$("input[name=inclusions]").eq(n).val(inArray[n]);
						}
					}

					for (var n in exArray) {
						if (n < 5) {
							$("input[name=exclusions]").eq(n).val(exArray[n]);
						} else {
							var trHtml='<tr><td><input type="text" name="exclusions" class="form-control" ></td></tr>';
							$("#exclusions-table tr:last").after(trHtml);
							$("input[name=exclusions]").eq(n).val(exArray[n]);
						}
					}

					$('input[name=minTouristNum]').val(courseEntity.minTouristNum);
					$('input[name=maxTouristNum]').val(courseEntity.maxTouristNum);

					if (courseEntity.personOrGroup == "P") {
						$("#radiop").attr("checked", "checked");
						$("#discount").show();
					} else {
						$("#radiog").attr("checked", "checked");
						$("#discount").hide();
					}

					$('input[name=minHourAdvance]').val(courseEntity.minHourAdvance);

					$("#courseScheduleName").val(scheduleOptionEntity.courseScheuleName);
					$("#bgnDate").val(scheduleOptionEntity.bgnDate);
					$("#endDate").val(scheduleOptionEntity.endDate);

					var workDayArray = scheduleOptionEntity.workDay.split(";");
					for (var x in workDayArray) {
						var v = workDayArray[x];
						var element = "input[name=workDay][value=" + v + "]";
						$(element).attr("checked", 'checked');
					}
					$("#discountTourists").val(scheduleOptionEntity.largeDiscountFlg);
					$("#discountValue").val(scheduleOptionEntity.largeDiscountValue);
					$("#discountPercent").val(scheduleOptionEntity.largeDiscountPercent);
					$("#earliestStartHour0").val(scheduleOptionEntity.startHour);
					$("#lastestStartHour0").val(scheduleOptionEntity.latestStartHour);
					$("#retailprice0").val(scheduleOptionEntity.retailPrice);
					$("#netprice0").html(scheduleOptionEntity.price);
					$("#commision0").get(0).selectedIndex = scheduleOptionEntity.commision - 8;

					var extraArray = new Array();
					for (var n in extraOptionEntityList) {
						if (n <= 4) {
							$("input[name=extraNames]").eq(n).val(extraOptionEntityList[n].extraOptionName);
							$("input[name=extraPrices]").eq(n).val(extraOptionEntityList[n].extraPrice);
							$("input[name=extraTimes]").eq(n).val(extraOptionEntityList[n].extraTime);
						}
					}

					var uploadPath ="../upload/images/";
					//var uploadPath ="./localImages/";
					if (coursePictureEntityList != null && coursePictureEntityList.length > 0) {
						$("#uploaded-images").children().remove();
//						$("#prev-carousel-kootour").children().remove();
//						$("#prev-carousel-inner").children().remove();

						for (var n in coursePictureEntityList) {
							var html = '' +
								'<div id="' + coursePictureEntityList[n].coursePictureIdentiNo + '" class="col-xs-12 col-sm-12 col-md-6 col-lg-6">' +
								'<a href="#" class="pic-link" target="_blank">' +
								'<img width="100%" src="' + uploadPath + coursePictureEntityList[n].fullPath + '" style="display: inline;">' +
								'</a>' +
								'<div class="space-8"></div>' +
								'<div class="center"><button onClick="deleteImage(\'' + coursePictureEntityList[n].coursePictureIdentiNo + '\')" type="button" class="btn btn-white kootour-btn-main"><i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;Delete</button></div>' +
								'<div class="space-8"></div>' +
								'</div>';
							$("#uploaded-images").append(html);
						}
					}

				} else {
					BootstrapDialog.show({
						title: 'Error',
					    message: obj.message,
					    buttons: [{
					   		label: 'Close',
					        action: function(dialog) {
					        	dialog.close();
					        }
					    }]
					});
				}
			},
			error: function(json) {
				var obj = JSON.parse(json);
				BootstrapDialog.show({
					title: 'Error',
				    message: obj.message,
				    buttons: [{
				   		label: 'Close',
				        action: function(dialog) {
				        	dialog.close();
				        }
				    }]
				});
			}
		});
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

function deleteImage(coursePictureCd) {
	var obj = new Object();
	obj.coursePictureIdentiNo = coursePictureCd;
	$.ajax({
		url: 'localhostCourseUploadAjax/deleteImage',
		type: 'post',
		dataType: 'json',
		data:{
			coursePictureIdentiNo:coursePictureCd
        },
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result == 'success') {
				$("#" + coursePictureCd ).remove();
			} else {
				BootstrapDialog.show({
					title: 'Error',
				    message: obj.message,
				    buttons: [{
				   		label: 'Close',
				        action: function(dialog) {
				        	dialog.close();
				        }
				    }]
				});
			}
		},
		error: function(json) {
			var obj = JSON.parse(json);
			BootstrapDialog.show({
				title: 'Error',
			    message: obj.message,
			    buttons: [{
			   		label: 'Close',
			        action: function(dialog) {
			        	dialog.close();
			        }
			    }]
			});
		}
	});
}