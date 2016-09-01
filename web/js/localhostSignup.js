$(document).ready(function(){

	$('#localhost_reg_form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: false,
		ignore: "",
		rules: {
			firstName: {
				required: true
			},
			lastName: {
				required: true
			},
			email: {
				required: true,
				email:true
			},
			password: {
				required: true
			},
			repassword: {
				required: true,
				equalTo: "#password"
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
			var obj = new Object();
			obj.firstName = $("#firstName").val();
			obj.lastName = $("#lastName").val();
			obj.email = $("#email").val();
			obj.loginId = $("#email").val();
			obj.password = $("#password").val();
			$.ajax({
				url: 'localhostSignAjax/regWithEmail',
				type: 'post',
				dataType: 'json',
				data: {"jsonFromWeb": JSON.stringify(obj)},
				success: function(json) {
					var obj = JSON.parse(json);
					if (obj.result == 'success') {
						BootstrapDialog.show({
							closable: false,
							title: 'Success',
						    message: obj.message,
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
});
