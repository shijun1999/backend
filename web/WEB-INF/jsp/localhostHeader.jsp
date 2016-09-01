<%@ page import= "com.kootour.mapper.entity.LocalhostEntity"%>
<%@ page import= "com.kootour.common.KooConst"%>
	    <nav class="navbar navbar-kootour">
        <div class="container">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-kootour-collapse" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand navbar-brand-img" href="localhostCourseList!load">
					<img  alt="Brand" src="images/icons/logo.svg" />
                </a>

                <p class="navbar-text kootour-link">
                    <a href="localhostCourseList!load">Kootour</a>
                </p>
            </div>


            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse"  id="navbar-kootour-collapse">
                <!--<form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <select type="text" class="form-control white">
                            <option value="vancouver" selected>Vancouver</option>
                        </select>
                    </div>
                </form>-->

                <ul class="nav navbar-nav navbar-right">
                    <li class="message-link-mobile"><a href="#">Messages <img class="icon" src="images/icons/icon_message.png" /></a></li>
                    <li class="message-link-desktop dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Messages <img class="icon" src="images/icons/icon_message.png" /></a>
                      <ul id="message-container" class="dropdown-menu dropdown-dashboard">
                        <li class="dashboard-divider">
                            <span>Notifications</span>
                        </li>
                        <li>
                            <a href="localhostMessage!load">
                            <div class="message-list-wrapper">
                                <div class="illustration">
                                    <img src="images/icons/icon_notification.png" class="icon-notification">
                                </div>
                                <div>
                                    <div class="message-list">
                                        <p id="notification-num"></p>
                                    </div>
                                </div>
                            </div>
                            </a>
                        </li>
                        <li class="dashboard-divider">
                            <span>Messages (<span  id="message-num">2</span>)</span>
                        </li>
                      </ul>
                    <li class="dropdown">
                    <%
                    	String userName = ((LocalhostEntity)session.getAttribute(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY)).getFirstName();
                  		String loginType = ((LocalhostEntity)session.getAttribute(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY)).getLoginType();
                        String avatarUrl = ((LocalhostEntity)session.getAttribute(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY)).getPhoto();
                        avatarUrl = KooConst.LT_LOGIN_TYPE_EMAIL.equals(loginType) ? "../upload/images/" + avatarUrl : avatarUrl;
                    %>
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=userName%> <img class="icon" src="<%=avatarUrl%>" /></a>
                      <ul class="dropdown-menu">
                      	<%  %>
                        <li><a onclick="logout('<%=loginType%>')">Log out</a></li>
                      </ul>
                    </li>
                    <!--<li><a href="#">Messages <img class="icon" src="images/icons/account_active_192X192.png" /></a></li>-->
                    <!--<li><a href="#"><img class="icon-navbar" src="images/icons/language_icon_white.png" /></a></li>-->
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>