<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="description">
    <meta name="description" content="${category.categoryName}"/>
</rapid:override>
<rapid:override name="keywords">
    <meta name="keywords" content="${category.categoryName}"/>
</rapid:override>
<rapid:override name="title">
    <title>${category.categoryName}</title>
</rapid:override>

<%--面包屑导航 start--%>
<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/">
            <i class="fa fa-home"></i>首页
        </a>
        <c:choose>
            <c:when test="${parentNodes != null && parentNodes.size() > 0}">
                <c:forEach items="${parentNodes}" var="c">
                    <i class="fa fa-angle-right"></i>
                    <a href="/category/${c.id}">${c.categoryName}</a>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <i class="fa fa-angle-right"></i>
                <a>未分类</a>
            </c:otherwise>
        </c:choose>
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>
<%--面包屑导航 end--%>

<%--主体内容 start--%>
<rapid:override name="left">
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <c:forEach items="${pageInfo.list}" var="a">
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
                                <fmt:formatDate value="${a.articleCreateTime}" pattern="yyyy年MM月dd日"/>&nbsp;&nbsp;
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
        <%@ include file="part/paging.jsp" %>
    </div>
</rapid:override>
<%--主体内容 end--%>

<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="part/sidebar-2.jsp" %>
</rapid:override>
<%--侧边栏 end--%>

<%@ include file="framework.jsp" %>