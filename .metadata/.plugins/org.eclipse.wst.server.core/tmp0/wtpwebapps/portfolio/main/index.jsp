<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String nm = (String)session.getAttribute("name");
Date maindate = new Date();
DateFormat mdf = new SimpleDateFormat("yyyyMMddhms");
String mdates = mdf.format(maindate);
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
<meta property="og:type" content="website">
<meta property="og:title" content="인천검단 레미안">
<title>인천검단 레미안</title>
<!-- css -->
<link rel="stylesheet" type="text/css" href="css/normalize.css?v=<%=mdates%>">
<link rel="stylesheet" type="text/css" href="css/slick.css?v=<%=mdates%>">
<link rel="stylesheet" type="text/css" href="css/swiper.min.css?v=<%=mdates%>">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=<%=mdates%>">
<link rel="stylesheet" type="text/css" href="css/cal-style.css?v=<%=mdates%>">
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=mdates%>">
<link rel="stylesheet" href="./dadmin/css/sweetalert.min.css?v=<%=mdates%>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
    
<link rel="stylesheet" type="text/css" href="./css/top.css?v=<%=mdates%>">
</head>

<body>
<!-- wrap -->
<div id="mask"></div>
<div id="wrap">
	<!-- header 로고 * 대메뉴,소메뉴-->
	<%@ include file="./header.jsp" %>
	<!-- header 로고 * 대메뉴,소메뉴 END-->


<div id="container">

<div id="index">
	<!-- 메인 화면 시작 -->
	<%@include file="./main.jsp" %>
    <!-- 메인 화면 종료 -->
    
    <!-- 타입정보 시작-->
	<%@ include file="./typeInfo.jsp" %>
	<!--// 타입정보 끝-->
</div>
	

  <!-- 카피라이터 -->
  <%@include file="./footer.jsp" %>
  <!-- 카피라이터 끝 -->
</div>
<!-- //container -->
<!-- //wrap -->
<script src="js/slick.min.js?v=<%=mdates%>"></script>
<script src="js/common.js?v=<%=mdates%>"></script>
<script src="js/swiper.min.js?v=<%=mdates%>"></script>
<script src="js/layout.js?v=<%=mdates%>"></script>
<script>
    $(".tab_showroom").on("click", function () {
        var num = $(this).data("num");
        $(".tab_showroom").removeClass("active");
        $(this).addClass("active");
        $(".showroom").hide();
        $("#showroom_" + num).show();
        $(".showroom_slide").hide();
        $("#showroom_slide_" + num).show();

        if( !$('#showroom_slide_' + num + ' .swiper-container').hasClass("swiper-container-initialized") ) {
            swiper = new Swiper('#showroom_slide_' + num + ' .swiper-container', {
                slidesPerView: 1,
                loop: true,
                navigation: {
                    nextEl: '.sub-slider__next',
                    prevEl: '.sub-slider__prev',
                },
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true,
                    renderBullet: function (index, className) {
                        return '<span class="' + className + '"></span>';
                    },
                },
            });

            setTimeout(reInit,500);
        }
    });

    if( !$('#showroom_slide_1 .swiper-container').hasClass("swiper-container-initialized") ){
        swiper = new Swiper('#showroom_slide_1 .swiper-container', {
            slidesPerView: 1,
            loop: true,
            navigation: {
                nextEl: '.sub-slider__next',
                prevEl: '.sub-slider__prev',
            },
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
                renderBullet: function (index, className) {
                    return '<span class="' + className + '"></span>';
                },
            },
        });
    };

    var dotArea = $('.main-slider .slick-dots');
    dotArea.wrap('<div class="w-base dot-control"></div>');
    $("<em>0</em>").prependTo('.main-slider .slick-dots>li>button');


     $('.life-slider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
         autoplay: true,
        autoplaySpeed: 3000,
        arrows: true,
        fade: true,
        asNavFor: '.life-slider-inven'
    });
    var dotArea = $('.life-slider .slick-arrow');
    dotArea.wrap('<div class="w-base dot-control"></div>');
    $("<em>0</em>").prependTo('.main-slider .slick-dots>li>button');


    $('.life-slider-inven').slick({
        slidesToShow: 2,
        slidesToScroll: 1,
        asNavFor: '.life-slider',
        //centerMode: true,
        dots: false,
        arrows: false,
    });

    $('.area-interior').slick({
        dots:true,
        infinite:true,
        autoplay:true,
        autoplaySpeed:3000
    });



$(document).ready(function() {
  var time = 2;
  var $bar,
    $slick,
    isPause,
    tick,
    percentTime;

  $slick = $('.main-slider');
  $slick.slick({
    arrows: true,
    speed: 1200,
    dots:false,
    arrows:true,
    fade: true,
    infinite: true,
    adaptiveHeight: false
  });

  $bar = $('.slider-progress .progress');

  function startProgressbar() {
    resetProgressbar();
    percentTime = 0;
    isPause = false;
    tick = setInterval(interval, 30);
  }

  function interval() {
    if (isPause === false) {
      percentTime += 1 / (time + 0.1);
      $bar.css({
        width: percentTime + "%"
      });
      if (percentTime >= 100) {
        $slick.slick('slickNext');
        startProgressbar();
      }
    }
  }

  function resetProgressbar() {
    $bar.css({
      width: 0 + '%'
    });
    clearTimeout(tick);
  }

  startProgressbar();

  $('.slick-next, .slick-prev').click(function() {
    startProgressbar();
  });

});
</script>
</body>
</html>
