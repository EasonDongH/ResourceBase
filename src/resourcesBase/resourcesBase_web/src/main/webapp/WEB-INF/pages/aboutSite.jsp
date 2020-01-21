<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="header-style">
    <style>
        .entry-title {
            background: #f8f8f8;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
</rapid:override>
<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/">
            <i class="fa fa-home"></i>首页
        </a>
        <i class="fa fa-angle-right"></i>
        关于本站
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>
<rapid:override name="left">
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post" style="min-height: 500px;">
                <header class="entry-header">
                    <h1 class="entry-title">
                        关于本站
                    </h1>
                    <div class="archives-meta">
                        站点统计：
                        运行${siteBasicStatistics[5]} 天&nbsp;&nbsp;
                            ${siteBasicStatistics[0]} 篇文章&nbsp;&nbsp;
                            ${siteBasicStatistics[2]}条评论&nbsp;&nbsp;
                            ${siteBasicStatistics[1]}次访问&nbsp;&nbsp;
                    </div>
                </header><!-- .entry-header -->
                <br>
                <div class="entry-content">
                    <div class="single-content">
                            ${article.articleContent}
                    </div>
                </div>
                <div class="clear"></div>
            </article>
        </main>
    </div>
</rapid:override>

<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="part/sidebar-3.jsp" %>
</rapid:override>
<%--侧边栏 end--%>

<rapid:override name="footer-script">
    <script>

    </script>
</rapid:override>

<%@ include file="framework.jsp" %>