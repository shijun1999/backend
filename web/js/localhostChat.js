$(document).ready(function(){
	$.ajax({
		url: 'localhostChatAjax/fetchChat',
		type: 'post',
		dataType: 'json',
		data:{
			touristIdentiNo:getUrlParam('touristIdentiNo')
        },
		success: function(json) {
			var obj = JSON.parse(json);
			if (obj.result === 'success') {
				var messageObj = obj.data;
				var messageObjKeysArray = Object.keys(messageObj.messageMap);
				var innerHtml = '';
				for (var n = messageObjKeysArray.length - 1; n >= 0; n--) {
					var key = messageObjKeysArray[n];
					innerHtml +=
					'<div><span class="date">'+ key +'</span></div>';
					for (var i = messageObj.messageMap[key].length - 1; i >=0 ; i--) {
						var leftOrRight = messageObj.messageMap[key][i].messageType == "T"? "left":"right";
						innerHtml +=
						'<div><div class="message-wrapper"><div class="message-content drt-'+ leftOrRight +'"><span>'+ messageObj.messageMap[key][i].messageText +'</span></div></div></div>';
					}
				}
				$("#message-body").append(innerHtml);
				$("#kootour-tchat").scrollTop($("#kootour-tchat")[0].scrollHeight);
			} else {
			}
		},
		error: function(json) {
		}
	});

	$("#send-message").on("click", function(){
		if ($("#text-message").val() == null || $("#text-message").val() == '') return false;
		$("#send-message").prop('disabled', true);
		$.ajax({
			url: 'localhostChatAjax/sendMessage',
			type: 'post',
			dataType: 'json',
			data:{
				touristIdentiNo: getUrlParam('touristIdentiNo'),
				messageText: $("#text-message").val()
	        },
			success: function(json) {
				var obj = JSON.parse(json);
				if (obj.result === 'success') {
					var innerHtml = '<div><div class="message-wrapper"><div class="message-content drt-right"><span>'+ $("#text-message").val() +'</span></div></div></div>';
					$("#message-body").append(innerHtml);
					$("#text-message").val("");
					$("#send-message").prop('disabled', false);
					$("#kootour-tchat").scrollTop($("#kootour-tchat")[0].scrollHeight);
				} else {
				}
			},
			error: function(json) {
			}
		});
	});

	$("#loadPreMessage").on("click", function(){
		$.ajax({
			url: 'localhostChatAjax/fetchChat',
			type: 'post',
			dataType: 'json',
			data:{
				touristIdentiNo: getUrlParam('touristIdentiNo'),
	        },
			success: function(json) {
				var obj = JSON.parse(json);
				if (obj.result === 'success') {
					$("#loadPreMessage").remove();
					var messageObj = obj.data;
					var messageObjKeysArray = Object.keys(messageObj.messageMap);
					var innerHtml = '';
					for (var n = messageObjKeysArray.length - 1; n >= 0; n--) {
						var key = messageObjKeysArray[n];
						innerHtml +=
						'<div><span class="date">'+ key +'</span></div>';
						for (var i = messageObj.messageMap[key].length - 1; i >=0 ; i--) {
							var leftOrRight = messageObj.messageMap[key][i].messageType == "T"? "left":"right";
							innerHtml +=
							'<div><div class="message-wrapper"><div class="message-content drt-'+ leftOrRight +'"><span>'+ messageObj.messageMap[key][i].messageText +'</span></div></div></div>';
						}
					}
					$("#message-body").append(innerHtml);
					$("#kootour-tchat").scrollTop($("#kootour-tchat")[0].scrollHeight);
				} else {
				}
			},
			error: function(json) {
			}
		});
	});
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}