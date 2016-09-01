$(document).ready(function(){
	$('#create_new').click(function () {
		$(this).attr("disabled", true);
		window.location.href="localhostCourse!load";
	});
});

function doEdit(v) {
	window.location.href="localhostCourseEdit!load?courseIdentiNo=" + v;
}
function doDelete(v) {
	BootstrapDialog.show({
		title: 'Confirm',
	    message: "Are you sure to delete this course?",
	    buttons: [
	        {
		   		label: 'Delete',
		   		cssClass: 'btn-danger',
		        action: function(dialog) {
		        	dialog.close();
		        	window.location.href="localhostCourseDelete!deleteCourse?courseIdentiNo=" + v;
		        }
	        },
	        {
		   		label: 'Cancel',
		        action: function(dialog) {
		        	dialog.close();
		        }
	        }
	    ]
	});

}

function doPreview(v) {
	window.location.href="localhostCoursePreview!load?courseIdentiNo=" + v;
}

function doClone(v) {
	window.location.href="localhostCourseClone!load?courseIdentiNo=" + v;
}
function doChangeStatus(v) {
	$.ajax({
		url: 'localhostCourseListAjax/updateCourseStatus',
		type: 'post',
		dataType: 'json',
		data: {
			courseIdentiNo: v,
			},
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result == 'success') {
	        	if (obj.data === '1') {
	        		$("#courseStatusNow-" + v).html("Active");
	        		$("#courseStatusTo-" + v).html("Inactive");
	        		$("#" + v).css("background-color","");
	        	} else {
	        		$("#courseStatusNow-" + v).html("Inactive");
	        		$("#courseStatusTo-" + v).html("Active");
	        		$("#" + v).css("background-color","#eee");
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
}