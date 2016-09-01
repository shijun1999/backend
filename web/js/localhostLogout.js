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

