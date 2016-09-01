$(document).ready(function(){
	$.ajax({
		url: 'localhostMessageAjax/fetchNotification',
		type: 'post',
		dataType: 'json',
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result === 'success') {
				var messageArray = obj.data;
				var innerHtml = 'Comfirm your system message ('+ messageArray.length +')';
				$("#notification-num").html(innerHtml);
			} else {
				var innerHtml = 'No new message';
				$("#notification-num").html(innerHtml);
			}
		},
		error: function(json) {
			var innerHtml = 'No new message';
			$("#notification-num").html(innerHtml);
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
				var innerHtml = messageArray.length;
				$("#message-num").html(innerHtml);
				for (var i = 0; i < messageArray.length; i++) {
					var date = new Date(messageArray[i].messageEntity.messageTime);
					var messageBody = '<li><a href="localhostMessage!load">' +
					'<div class="message-list-wrapper">' +
					'<div class="illustration">' +
					'<img src="../upload/images/'+ messageArray[i].touristEntity.picture +'" alt="profile" class="icon-notification img-circle">' +
					'</div>' +
					'<div>' +
					'<div class="message-list">' +
					'<div class="name">' +
					'<span class="blue">'+ messageArray[i].touristEntity.firstName +'</span>' +
					'</div>' +
					'<div class="content">' +
					'<p>' + messageArray[i].messageEntity.messageText + '</p>' +
					'</div>' +
					'<div class="date">' +
						moment(date).format('DD/MM/YYYY'); +
					'</div>' +
					'</div>' +
					'</div>' +
					'</div></a></li>';
					$("#message-container").append(messageBody);
				}
				var messageAll = '<li><a href="localhostMessage!load"><div class="text-center"><span class="see-all">See All</span></div></a></li>';
				$("#message-container").append(messageAll);
			} else {
				var innerHtml = '0';
				$("#message-num").html(innerHtml);
			}
		},
		error: function(json) {
			var innerHtml = '0';
			$("#message-num").html(innerHtml);
		}
	});
});

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

window.fbAsyncInit = function() {
	FB.init({
		appId      : '151250988634214',
		cookie     : true,  // enable cookies to allow the server to access
		xfbml      : true,  // parse social plugins on this page
		version    : 'v2.5' // use graph api version 2.5
	});
};

function logout(loginType) {
	if (loginType == '1') {
		window.location.href="localhostLogin!logout";
	} else if (loginType == '2') {
		HoldOn.open({message:"Logout from facebook...",theme:"sk-dot"});
	    FB.getLoginStatus(function(response) {
	        if (response && response.status === 'connected') {
	            FB.logout(function(response) {
	            	HoldOn.close();
	            	window.location.href="localhostLogin!logout";
	            });
	        }
	    });
	} else if (loginType == '3') {

	}
}