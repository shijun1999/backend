$(document).ready(function() {
	$('[data-rel=tooltip]').tooltip();

	$.ajax({
		url: 'localhostAccountAjax/accountInit',
		type: 'post',
		dataType: 'json',
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result == 'success') {
				var localhostEntity = obj.data;
				$("#output-uploader").css("background-image", "url(../upload/images/" + localhostEntity.photo + ")");
				$('#firstName').val(localhostEntity.firstName);
				$('#lastName').val(localhostEntity.lastName);
				$('#location').val(localhostEntity.addr3);
				$('#password').val(localhostEntity.password);
				$('#email').val(localhostEntity.email);
				$('#phoneNumber').val(localhostEntity.telCode + localhostEntity.telNo);
				$('#editor').summernote('code', localhostEntity.memo);
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

	$('#account-form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: true,
		ignore: "",
		rules: {
			firstName: {
				required: true
			},
			lastName: {
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
			var obj = new Object();
			obj.firstName = $("#firstName").val();
			obj.lastName = $("#lastName").val();
			obj.location = $("#location").val();
			obj.memo = $('#editor').summernote('code');
			$.ajax({
				url: 'localhostAccountAjax/updateAccount',
				type: 'post',
				dataType: 'json',
				data: {"jsonFromWeb": JSON.stringify(obj)},
				success: function(json) {
					var obj = JSON.parse(json);
					if (obj.result == 'success') {
						BootstrapDialog.show({
							title: 'Success',
						    message: obj.message,
						    buttons: [{
						   		label: 'Close',
						        action: function(dialog) {
						        	dialog.close();
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
	$('#editor').summernote({
		 height: 200,
		  toolbar: [
		            ['style', ['bold', 'italic', 'underline', 'clear']],
		            ['font', ['strikethrough', 'superscript', 'subscript']],
		            ['fontsize', ['fontsize']],
		            ['para', ['ul', 'ol', 'paragraph']],
		            ['height', ['height']]
		          ]
	});

    $("#input-dim-2").fileinput({
    	language: 'en', //设置语言
    	showCaption: false,//是否显示标题
    	browseClass: "btn btn-primary", //按钮样式
    	dropZoneTitle: "Drag & drop videos here &hellip;",
    	maxFileCount: 3,
        uploadUrl: "localhostAccountUpload/uploadVideo",
        allowedFileExtensions: ["mp4"],
        maxFileSize: 50000
    });
    $("#singleupload").uploadFile({
    	url:"localhostCourseUpload/uploadAvatar",
    	multiple:false,
    	dragDrop:false,
    	fileName:"file",
    	onSuccess:function(files,data,xhr,pd) {
    		var obj = JSON.parse(data);
    		$("#output-uploader").css("background-image", "url(../upload/images/" + obj.data + ")");
    	}
    });
});