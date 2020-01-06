<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="breadcrumb">
    <nav class="breadcrumb">
        <div class="bull"><i class="fa fa-volume-up"></i></div>
        <div id="scrolldiv">
            <div class="scrolltext">
                <ul style="margin-top: 0px;">
                    <c:forEach items="${noticeList}" var="n">
                        <li class="scrolltext-title">
                            <a href="/notice/${n.id}" rel="bookmark">${n.noticeTitle}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
</rapid:override>

<%--主体内容 start--%>
<rapid:override name="left">
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <!-- 轮播图 start -->
            <div id="slideshow" class="wow fadeInUp" data-wow-delay="0.3s">
                <ul class="rslides callbacks" id="slider" style="max-width: 2000px;">
                    <c:forEach items="${slideshowContents}" var="c" varStatus="index">
                        <li id="callback_s${index.index}"
                            style="float: left; position: relative; opacity: 1; z-index: 2; transition: opacity 800ms ease-in-out 0s;">
                            <a href="/article/${c.aid}" target="_blank" rel="external nofollow">
                                <img src="/image/${c.photoId}" alt="${c.summarize}" style="height: 300px;">
                            </a>
                            <p class="slider-caption">${c.summarize}</p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- 轮播图 end -->
            <c:forEach items="${articleList}" var="a">
                <article class="post type-post">
                    <header class="entry-header">
                        <h2 class="entry-title">
                            <a href="/article/${a.id}" rel="bookmark" target="_blank">${a.articleTitle}</a>
                        </h2>
                    </header>
                    <div class="entry-content">
                        <div class="archive-content">${a.articleSummary}...<br><br></div>
                        <span class="title-l"></span>
                        <span class="new-icon">
                                    <jsp:useBean id="nowDate" class="java.util.Date"/>
                                    <c:set var="interval" value="${nowDate.time - a.articleCreateTime.time}"/><%--时间差毫秒数--%>
                                    <fmt:formatNumber value="${interval/1000/60/60/24}" pattern="#0" var="days"/>
                                    <c:if test="${days <= 7}">NEW</c:if>
                        </span>
                        <span class="entry-meta">
                            <span class="date">
                                <fmt:formatDate value="${a.articleCreateTime}" pattern="yyyy年MM月dd日"/>
                            &nbsp;&nbsp;
                            </span>
                            <span class="views">
                                <i class="fa fa-eye"></i>
                                    ${a.articleViewCount} views
                            </span>
                            <span class="comment">&nbsp;&nbsp;
                                <a href="/article/${a.id}#comments" rel="external nofollow">
                                  <i class="fa fa-comment-o"></i>
                                    <c:choose>
                                        <c:when test="${a.articleCommentCount == 0}">
                                            发表评论
                                        </c:when>
                                        <c:otherwise>
                                            ${a.articleCommentCount}
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </span>
                        </span>
                        <div class="clear"></div>
                    </div><!-- .entry-content -->

                    <span class="entry-more">
                        <a href="/article/${a.id}" rel="bookmark" target="_blank">阅读全文</a>
                    </span>
                </article>
            </c:forEach>
        </main>
    </div>
</rapid:override>
<%--主体内容 end--%>

<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="part/sidebar-2.jsp" %>
</rapid:override>
<%--侧边栏 end--%>

<rapid:override name="footer-script">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#scrolldiv").textSlider({line: 1, speed: 300, timer: 3000});
        });
    </script>
</rapid:override>

<%--指定父页--%>
<%@ include file="framework.jsp" %>