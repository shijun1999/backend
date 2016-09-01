$(document).ready(function(){
	// Load the SDK asynchronously
	(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	window.fbAsyncInit = function() {
		FB.init({
			appId      : '185425761870647',
			cookie     : true,  // enable cookies to allow the server to access
			xfbml      : true,  // parse social plugins on this page
			//version    : 'v2.7' // use graph api version 2.5
		});
		FB.getLoginStatus(function(response) {
			fbStatusChangeCallback(response, false);
		});
	};

	$('#localhost_login_form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: true,
		ignore: "",
		rules: {
			loginId: {
				required: true,
				email:true
			},
			password: {
				required: true
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

		submitHandler: function (form) {
			loginWithEmail();
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

	$("#fbLogin").on("click", function(){
		alert ("fblogin");
		checkLoginStateWithFb(true);
	});
});

function fbStatusChangeCallback(response, needToLoginWihtFb) {
	if (response.status === 'connected') {
		loginWithFb(response);
	} else {
		if (needToLoginWihtFb) {
			FB.login(function(response) {
			    if (response.authResponse) {
					FB.api('/me', {locale: 'en_US', fields: 'name, email, location, picture,first_name,last_name'}, function(response) {
						var objForCheck = new Object();
						objForCheck.loginId = response.email;
						objForCheck.loginType = "2";
						$.ajax({
							url: 'localhostLoginAjax/checkUserExist',
							type: 'post',
							dataType: 'json',
							data: {"jsonFromWeb": JSON.stringify(objForCheck)},
							success: function(json) {
								var objForCheck = JSON.parse(json);
								if (objForCheck.result === 'success' && objForCheck.data === "1") {
									loginWithFb(response);
								} else {
									var objForSign = new Object();
									objForSign.localhostIdentiNo = response.id != undefined ? response.id : "";
									objForSign.loginType = "2";
									objForSign.firstName = response.first_name != undefined ? response.first_name : "";
									objForSign.lastName = response.last_name != undefined ? response.last_name : "";
									objForSign.email = response.email != undefined ? response.email : "";
									objForSign.password = '';
									objForSign.location = response.location != undefined ? response.location.name : "";
									objForSign.avatar = response.picture.data.url != undefined ? response.picture.data.url : "";
									$.ajax({
										url: 'localhostSignAjax/regWithFb',
										type: 'post',
										dataType: 'json',
										data: {"jsonFromWeb": JSON.stringify(objForSign)},
										success: function(json) {
											var objForSign = JSON.parse(json);
											if (objForSign.result == 'success') {
												BootstrapDialog.show({
													closable: false,
													title: 'Success',
												    message: objForSign.message,
												    buttons: [{
												   		label: 'Go to Next Page',
												        action: function(dialog) {
												        	dialog.close();
												        	window.location.href="localhostCourseList!load";
												        }
												    }]
												});
											} else {
												BootstrapDialog.show({
													title: 'Error',
												    message: objForSign.message,
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
											var objForSign = JSON.parse(json);
											BootstrapDialog.show({
												title: 'Error',
											    message: objForSign.message,
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
							},
							error: function(json) {
								var objForCheck = JSON.parse(json);
								BootstrapDialog.show({
									title: 'Error',
								    message: objForCheck.message,
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
			    } else {
					BootstrapDialog.show({
						title: 'Error',
					    message: 'Please the auth of facebook to login.',
					    buttons: [{
					   		label: 'Close',
					        action: function(dialog) {
					        	dialog.close();
					        }
					    }]
					});
		    	}
			}, { scope: 'public_profile,email,user_location'});
		}
	}
}

function checkLoginStateWithFb(needToLoginWihtFb) {
	var status = FB.getLoginStatus(function(response) {
		fbStatusChangeCallback(response, needToLoginWihtFb);
	});
	alert (status);
}

function loginWithEmail() {
	var obj = new Object();
	obj.loginId = $("#loginId").val();
	obj.password = $("#password").val();
	$.ajax({
		url: 'localhostLoginAjax/loginWithEmail',
		type: 'post',
		dataType: 'json',
		data: {"jsonFromWeb": JSON.stringify(obj)},
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result == 'success') {
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

function loginWithFb(response) {
	FB.api('/me', {locale: 'en_US', fields: 'name, email, location, picture,first_name,last_name'}, function(response) {
		var objForLogin = new Object();
		objForLogin.loginType = "2";
		objForLogin.loginId = response.email;
		$.ajax({
			url: 'localhostLoginAjax/loginWithFb',
			type: 'post',
			dataType: 'json',
			data: {"jsonFromWeb": JSON.stringify(objForLogin)},
			success: function(json) {
				var objForLogin = JSON.parse(json);
				if (objForLogin.result == 'success') {
					window.location.href="localhostCourseList!load";
				} else {
					BootstrapDialog.show({
						title: 'Error',
					    message: objForLogin.message,
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
				var objForLogin = JSON.parse(json);
				BootstrapDialog.show({
					title: 'Error',
				    message: objForLogin.message,
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
}