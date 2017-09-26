<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="web.resources.i18n.UserHomepage" />
<!DOCTYPE html>
<html>
<head>
<title> <fmt:message key="homepage.title" /></title>
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
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#body"><fmt:message key="homepage.navitem.home" /></a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#about"><fmt:message key="homepage.history" /></a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#experience"><fmt:message key="homepage.cards" /></a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#work"><fmt:message key="homepage.options" /></a></li>
                                <li class="js_nav-item nav-item"><a class="nav-item-child nav-item-hover" href="#contact"><fmt:message key="homepage.contacts" /></a></li>
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
                            <h1 class="promo-block-title">AlPay<span class="text-uppercase margin-l-20"><fmt:message key="homepage.header.payment" /></span> <br/> <fmt:message key="homepage.welcome" /></h1>
                            <p class="promo-block-text">
                            <c:out value="<fmt:message key="homepage.glad"/>,  ${login}."/>
                            </p>
                        </div>

                    </div>
                </div>
                <!--// end row -->
            </div>
        </div>
        <!--========== SLIDER ==========-->

        <!--========== PAGE LAYOUT ==========-->
        <!-- About -->
        <div id="about">
            <div class="container content-lg">
                <div class="row">
                    <div class="col-sm-7">
                        <div class="section-seperator margin-b-50">
                            <div class="margin-b-50">
                                <div class="margin-b-30">
                                    <h2><fmt:message key="homepage.history" /></h2>
                                    <p>.......</p>
                                </div>
                                <a href="#" class="btn-theme btn-theme-md btn-default-bg text-uppercase"><fmt:message key="homepage.openhistory" /></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--// end row -->
            </div>
        </div>
        <!-- End About -->

        <!-- Experience -->
        <div id="experience">
            <div class="bg-color-sky-light" data-auto-height="true">
                <div class="container content-lg">
                    <div class="row row-space-2 margin-b-4">
                        <div class="col-md-3 col-sm-6 md-margin-b-4">
                            <div class="service" data-height="height">
                                <div class="service-info">
                                    <h3><fmt:message key="homepage.card" /> 1</h3>
									 <p class="margin-b-5">№465768798076545678</p>
                                    <p class="margin-b-5">0$</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 sm-margin-b-4">
                            <div class="service" data-height="height">
                               <div class="service-info">
                                    <h3>Card2</h3>
									 <p class="margin-b-5">№465768798076545678</p>
                                    <p class="margin-b-5">0$</p>
                                </div>
                            </div>
                        </div>
						<div class="col-md-3 col-sm-6 sm-margin-b-4">
                            <div class="service" data-height="height">
                               <div class="service-info">
                                    <h3>Card2</h3>
									 <p class="margin-b-5">№465768798076545678</p>
                                    <p class="margin-b-5">0$</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--// end row -->
                </div>
            </div>
        </div>
        <!-- End Experience -->

        <!-- Options -->
        <div id="work">
            <div class="container content-lg">
                <div class="row margin-b-40">
                    <div class="col-sm-6">
                        <h2><fmt:message key="homepage.options" /></h2>
                    </div>
                </div>
                <!--// end row -->
                <div class="row">
                 <!-- Latest Products -->
                    <div class="col-sm-4 sm-margin-b-50">
                        <h4><a href="user_acountAdding"><fmt:message key="homepage.accountAdding" /></a> <span class="text-uppercase margin-l-20"></span></h4>
                        <p><fmt:message key="homepage.addAccount" /></p>
                    </div>
                    <!-- End Latest Products -->
                      <!-- Latest Products -->
                    <div class="col-sm-4 sm-margin-b-50">
                        <h4><a href="user_cardAdding"><fmt:message key="homepage.cardAdding" /></a> <span class="text-uppercase margin-l-20"></span></h4>
                        <p><fmt:message key="homepage.addCard" /></p>
                    </div>
                    <!-- End Latest Products -->
                    <!-- Latest Products -->
                    <div class="col-sm-4 sm-margin-b-50">
                        <h4><a href="user_replenish"><fmt:message key="homepage.replenish" /></a> <span class="text-uppercase margin-l-20"></span></h4>
                        <p><fmt:message key="homepage.replenishCard" /></p>
                    </div>
                    <!-- End Latest Products -->

                    <!-- Latest Products -->
                      <div class="col-sm-4 sm-margin-b-50">
                        <h4><a href="user_payment"><fmt:message key="homepage.payment" /></a> <span class="text-uppercase margin-l-20"></span></h4>
                        <p><fmt:message key="homepage.transfer" /></p>
                    </div>
                    <!-- End Latest Products -->

                    <!-- Latest Products -->
                      <div class="col-sm-4 sm-margin-b-50">
                        <h4><a href="user_cardblocking"><fmt:message key="homepage.blocking" /></a> <span class="text-uppercase margin-l-20"></span></h4>
                        <p><fmt:message key="homepage.blockCard" /></p>
                    </div>
                    <!-- End Latest Products -->
					  <!-- Latest Products -->
                      <div class="col-sm-4 sm-margin-b-50">
                        <h4><a href="user_cardunblocking"><fmt:message key="homepage.unblocking" /></a> <span class="text-uppercase margin-l-20"></span></h4>
                        <p><fmt:message key="homepage.unblockCard" /></p>
                    </div>
                    <!-- End Latest Products -->
                </div>
                <!--// end row -->
            </div>
        </div>
        <!-- End  Options -->

        <!-- Promo Banner -->
        <div class="promo-banner parallax-window" data-parallax="scroll" data-image-src="style/images/1920x1080/01.jpg">
            <div class="container-sm content-lg">
                <h2 class="promo-banner-title"><fmt:message key="homepage.banner" /></h2>
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
                           <h2><fmt:message key="homepage.ourContacts" /></h2>
                            <p><fmt:message key="homepage.contactText" /></p>
                        </div>
                    </div>
                    <!--// end row -->

                    <div class="row">
                        <div class="col-md-3 col-xs-6 md-margin-b-30">
                            <h4><fmt:message key="homepage.location" /></h4>
                            <a><fmt:message key="homepage.ourLocation" /></a>
                        </div>
                        <div class="col-md-3 col-xs-6 md-margin-b-30">
                            <h4><fmt:message key="homepage.phone" /></h4>
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