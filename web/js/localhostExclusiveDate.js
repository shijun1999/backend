$(document).ready(function(){
	HoldOn.open({message:"Loading Calendar...",theme:"sk-dot"});
	$.ajax({
		url: 'localhostExclusiveDateAjax/exclusiveDateInit',
		type: 'post',
		dataType: 'json',
		success: function(json) {
			HoldOn.close();
			var obj = JSON.parse(json);
			if (obj.result == 'success') {

				var eventsForSchedule = new Array();

				var workDayArray = obj.data.workDayList;
				var orderDayArray = obj.data.orderDayList;

				var calendar = $('#calendar').fullCalendar({
			        loading: function(isLoading) {
			            if(isLoading) {
			            	var options = {
			            		    message:"Loading Calendar...",
			            		    theme:"sk-dot"
			            		};
		            		HoldOn.open(options);
			            } else {

			            }
			        },
					 buttonHtml: {
						prev: '<i class="ace-icon fa fa-chevron-left"></i>',
						next: '<i class="ace-icon fa fa-chevron-right"></i>'
					},

					header: {
						left: 'prev,next,today',
						center: 'title',
						right: ''
					},
					editable: false,
					droppable: false,
					selectable: false,
				    dayClick: function(date, jsEvent, view) {
				    	var element = $(this);
				    	var clickDayFormatted = moment(date, "YYYY-MM-DD").format('YYYYMMDD');
				    	if (moment().isAfter(date)) {
				    		return false;
				    	} else {
			    			if ($.inArray(clickDayFormatted, orderDayArray) > -1) {
			    				return false;
			    			} else {
			    				var index = $.inArray(clickDayFormatted, workDayArray);
					    		if (index > -1) {
					    			$.ajax({
					    				url: 'localhostExclusiveDateAjax/exclusiveDateClickEvent',
					    				type: 'post',
					    				dataType: 'json',
										data: {
											clickType: "1",
											clickDay: clickDayFormatted
											},
					    				success: function(json) {
					    					var obj = JSON.parse(json);
					    					if (obj.result == 'success') {
							    				workDayArray.splice(index, 1);
							    				element.removeClass("exclusive-date-work");
							    				element.addClass("exclusive-date-not-work");

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
					    		} else {
					    			$.ajax({
					    				url: 'localhostExclusiveDateAjax/exclusiveDateClickEvent',
					    				type: 'post',
					    				dataType: 'json',
										data: {
											clickType: "0",
											clickDay: clickDayFormatted
											},
					    				success: function(json) {
					    					var obj = JSON.parse(json);
					    					if (obj.result == 'success') {
								    			workDayArray.push(clickDayFormatted);
							    				element.removeClass("exclusive-date-not-work");
							    				element.addClass("exclusive-date-work");
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
			    			}
				    	}
				    },
				    dayRender: function(date, cell){
				    	var clickDayFormatted = moment(date, "YYYY-MM-DD").format('YYYYMMDD');
			        	if (moment().isAfter(date)) {
			        		$(cell).addClass("exclusive-date-before");
			        	} else {
			        		$(cell).addClass("exclusive-date-not-work");
			        		if ($.inArray(clickDayFormatted, workDayArray) > -1) {
			        			if ($.inArray(clickDayFormatted, orderDayArray) > -1) {
			        				$(cell).removeClass("exclusive-date-not-work");
			        				$(cell).addClass("exclusive-date-before");
			        			} else {
			        				$(cell).removeClass("exclusive-date-not-work");
			        				$(cell).addClass("exclusive-date-work");
			        			}
			        		}
			        	}
				    }
				});
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
			HoldOn.close();
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