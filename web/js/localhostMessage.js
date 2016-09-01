$(document).ready(function(){
	$.ajax({
		url: 'localhostMessageAjax/fetchNotification',
		type: 'post',
		dataType: 'json',
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result === 'success') {
				var messageArray = obj.data;
				for (var i = 0; i < messageArray.length; i++) {
					var innerHtml = '<section class="notification">' +
					'<p>'+ messageArray[i].messageText +'</p>' +
					'<img src="images/icons/icon_close.png" class="close-icon" data-messagecd="'+ messageArray[i].messageIdentiNo +'"/>' +
					'</section>';
					$("#notifaction-list-container").append(innerHtml);
				}
				$(".close-icon").on("click", function(){
					var messageCd = $(this).data("messagecd");
					$.ajax({
						url: 'localhostMessageAjax/readNotification',
						type: 'post',
						dataType: 'json',
						data: {messageIdentiNo: messageCd},
						success: function(json) {
							var obj = JSON.parse(json);
							if (obj.result === 'success') {
								$(".close-icon").on("click", function(){
									 $(this).parent().closest('section').remove();
								});
							}
						},
						error: function(json) {
						}
					});
				});
			}
		},
		error: function(json) {
		}
	});

	$.ajax({
		url: 'localhostMessageAjax/fetchMessage',
		type: 'post',
		dataType: 'json',
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result === 'success') {
				var messageArray = obj.data;
				for (var i = 0; i < messageArray.length; i++) {
					var date = new Date(messageArray[i].messageEntity.messageTime);
					var imgUrl = '"../upload/images/' + messageArray[i].touristEntity.picture + '"';
					var messageBody = '<a href="localhostChat!load?touristIdentiNo='+ messageArray[i].touristEntity.touristIdentiNo +'">' +
					'<div class="message-list">' +
					'<div class="illustration">' +
					'<div id="touristAvatar" class="user-small-thumbnail img-circle"></div>' +
					'</div>' +
					'<div class="name">' +
					'<span class="subtitle">'+ messageArray[i].touristEntity.firstName +'</span>' +
					'</div>' +
					'<div class="content">' +
					'<p>' + messageArray[i].messageEntity.messageText + '</p>' +
					'</div>' +
					'<div class="date">' +
						moment(date).format('DD/MM/YYYY'); +
					'</div>' +
					'</div>' +
					'</a>';
					$("#message-list-container").append(messageBody);
					$("#touristAvatar").css("background-image", "url(" + imgUrl + ")");
				}
			} else {
			}
		},
		error: function(json) {
		}
	});

	$("#messageMore").on("click", function(){
		$("#messageMore").remove();
		$("#message-list-container").children().remove();
		$.ajax({
			url: 'localhostMessageAjax/fetchSeeMore',
			type: 'post',
			dataType: 'json',
			success: function(json) {
				var obj = JSON.parse(json);
				if (obj.result === 'success') {
					var messageArray = obj.data;
					for (var i = 0; i < messageArray.length; i++) {
						var date = new Date(messageArray[i].messageEntity.messageTime);
						var imgUrl = '"../upload/images/' + messageArray[i].touristEntity.picture + '"';
						var messageBody = '<a href="localhostChat!load?touristIdentiNo='+ messageArray[i].touristEntity.touristIdentiNo +'">' +
						'<div class="message-list">' +
						'<div class="illustration">' +
						'<div id="touristAvatar" class="user-small-thumbnail img-circle"></div>' +
						'</div>' +
						'<div class="name">' +
						'<span class="subtitle">'+ messageArray[i].touristEntity.firstName +'</span>' +
						'</div>' +
						'<div class="content">' +
						'<p>' + messageArray[i].messageEntity.messageText + '</p>' +
						'</div>' +
						'<div class="date">' +
							moment(date).format('DD/MM/YYYY'); +
						'</div>' +
						'</div>' +
						'</a>';
						$("#message-list-container").append(messageBody);
						$("#touristAvatar").css("background-image", "url(" + imgUrl + ")");
					}
				} else {
				}
			},
			error: function(json) {
			}
		});
	});

});