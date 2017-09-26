<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.login" />
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="error.title" /></title>
            <!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
        <!-- CORE PLUGINS -->
        <script src="style/vendor/jquery.min.js" type="text/javascript"></script>
        <script src="style/vendor/jquery-migrate.min.js" type="text/javascript"></script>
        <script src="style/vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL PLUGINS -->
        <script src="style/vendor/jquery.easing.js" type="text/javascript"></script>
        <script src="style/vendor/jquery.back-to-top.js" type="text/javascript"></script>
        <script src="style/vendor/jquery.smooth-scroll.js" type="text/javascript"></script>
        <script src="style/vendor/jquery.wow.min.js" type="text/javascript"></script>
        <script src="style/vendor/jquery.parallax.min.js" type="text/javascript"></script>
        <script src="style/vendor/jquery.appear.js" type="text/javascript"></script>
        <script src="style/vendor/swiper/js/swiper.jquery.min.js" type="text/javascript"></script>

        <!-- PAGE LEVEL SCRIPTS -->
        <script src="style/js/layout.min.js" type="text/javascript"></script>
        <script src="style/js/components/progress-bar.min.js" type="text/javascript"></script>
        <script src="style/js/components/swiper.min.js" type="text/javascript"></script>
        <script src="style/js/components/wow.min.js" type="text/javascript"></script>

        <!-- GLOBAL MANDATORY STYLES -->
        <link href="style/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css"/>
        <link href="style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- PAGE LEVEL PLUGIN STYLES -->
        <link href="style/css/animate.css" rel="stylesheet">
        <link href="style/vendor/swiper/css/swiper.min.css" rel="stylesheet" type="text/css"/>

        <!-- THEME STYLES -->
        <link href="style/css/layout.min.css" rel="stylesheet" type="text/css"/>

    </head>
    <!-- END HEAD -->

    <!-- BODY -->
    <body id="body" data-spy="scroll" data-target=".header">

        <!--========== HEADER ==========-->
        <header class="header navbar-fixed-top">
            <!-- Navbar -->
            <nav class="navbar" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="menu-container js_nav-item">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="toggle-icon"></span>
                        </button>
						<!-- Logo -->
                        <div class="logo">
                            <a class="logo-wrap" href="#body">
                               <h1>alpay</h1>
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>
					
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse nav-collapse">
                        <div class="menu-container">
                            <ul class="nav navbar-nav navbar-nav-right">
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#contact"><fmt:message key="error.contacts" /></a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- End Navbar Collapse -->
                </div>
            </nav>
            <!-- Navbar -->
        </header>
        <!--========== END HEADER ==========-->

        <!--========== SLIDER ==========-->
        <div class="promo-block">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 sm-margin-b-60">
                        <div class="margin-b-30">
                            <h1 class="promo-block-title"><fmt:message key="error.ops" /><br/><fmt:message key="error.message" /></span></h1>
                            <p class="promo-block-text">
							<fmt:message key="error.can" />
                            </p>
                        </div>
                    </div>
                </div>
                <!--// end row -->
            </div>
        </div>
        <!--========== SLIDER ==========-->


        <!-- Promo Banner -->
        <div class="promo-banner parallax-window" data-parallax="scroll" data-image-src="style/images/1920x1080/error.jpg">
            <div class="container-sm content-lg">
                <h2 class="promo-banner-title"></h2>
                <p class="promo-banner-text"></p>
            </div>
        </div>
        <!-- End Promo Banner -->

        <!-- Contact -->
        <div id="contact">
            <div class="bg-color-sky-light">
                <div class="container content-lg">
                    <div class="row margin-b-40">
                        <div class="col-sm-6">
                           <h2><fmt:message key="error.ourContacts" /></h2>
                            <p><fmt:message key="error.contactText" /></p>
                        </div>
                    </div>
                    <!--// end row -->

                    <div class="row">
                        <div class="col-md-3 col-xs-6 md-margin-b-30">
                            <h4><fmt:message key="error.location" /></h4>
                            <a><fmt:message key="error.ourLocation" /></a>
                        </div>
                        <div class="col-md-3 col-xs-6 md-margin-b-30">
                            <h4><fmt:message key="error.phone" /></h4>
                            <a>+380991917402</a>
                        </div>
                        <div class="col-md-3 col-xs-6">
                            <h4>Email</h4>
                            <a>nameisalaska@gmail.com</a>
                        </div>
                    </div>
                    <!--// end row -->
                </div>
            </div>
        </div>
        <!-- End Contact -->
        <!--========== END PAGE LAYOUT ==========-->

        <!-- Back To Top -->
        <a href="javascript:void(0);" class="js-back-to-top back-to-top">Top</a>

    </body>
    <!-- END BODY -->
</html>