<%@page import="portfolio.ConfigDTO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>      
<!-- 타입정보 시작-->
	<section id="px4" class="sect04 px-sect last-sect">
        <div class="w-base">
            <div class="tit-area  animated fadeInUp m_center">
                <h3>편안하고 실용적인 <br class="m_br">합리적 공간배치<br class="m_br"><a href="#">more</a></h3>
                <p class="animated fadeInUp m_center">더 나은 삶, 나은 내일<br>가족의 행복한 이야기로 가득 채워집니다</p>
            </div>


             <div class="contents-4-box row">
                <div>
                    <ul class="nav nav-tabs box-nav m_flex_center">
                        <!-- 타입 출력 -->
                        <app:forEach var="type" items="${lists}" varStatus="list">
                        <li>
                            <button type="button" class="tab_showroom ${list.first ? 'active' : ''}" data-num="${list.index+1}">${type.atype}</button>
                        </li>
                        </app:forEach>
                        <!-- 타입 출력 끝-->
                    </ul>
                </div>
                <div class="col-sm-12 col-xs-12">
                    <div class="iso-box">
                    <app:forEach var="type" items="${lists}" varStatus="list">
                        <div class="showroom" id="showroom_${list.index+1}">
                            <span><img src="${type.aimgUrl}" class="img-responsive center-block" alt=""></span>

                            <div class="area-info col-sm-1">
                                <h4>${type.atype}</h4>
                                <ul>
                                    <li>
                                        <h5>주거전용</h5>
                                        <p>${type.aprivate}㎡</p>
                                    </li>
                                    <li>
                                        <h5>주거공용</h5>
                                        <p>${type.apublic}㎡</p>
                                    </li>
                                    <li>
                                        <h5>기타공용</h5>
                                        <p>${type.aetcpublic}㎡</p>
                                    </li>
                                    <li>
                                        <h5>계약면적</h5>
                                        <p>${type.acontractSize}㎡</p>
                                    </li>
                                </ul>
                               </div>
                          </div>
                        </app:forEach>
                    </div>
                </div>
            </div>
        </div>
	</section>
	<!--// 타입정보 끝-->