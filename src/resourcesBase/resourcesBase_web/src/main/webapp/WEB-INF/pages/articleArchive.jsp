<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="description">
    <meta name="description" content="文章归档"/>
</rapid:override>

<rapid:override name="keywords">
    <meta name="keywords" content="文章,归档"/>
</rapid:override>

<rapid:override name="title">
    <title>文章归档--${options.optionSiteTitle}</title>
</rapid:override>

<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/">
            <i class="fa fa-home"></i>首页
        </a>
        <i class="fa fa-angle-right"></i>
        文章归档
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>

<rapid:override name="left">
    <%--博客主体-左侧正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="page type-page status-publish hentry rwz">
                <header class="entry-header">
                    <h1 class="single-title">文章归档</h1>
                </header>
                <div class="archives">
                    <div id="all_archives">
                        <c:if test="${articleGroup != null && articleGroup.articleGroup != null && articleGroup.articleGroup.size()> 0}">
                            <c:forEach items="${articleGroup.articleGroup}" var="byYear">
                                <h3 class="year">${byYear.key} 年</h3>
                                <c:forEach items="${byYear.value}" var="byMon">
                                    <ul class="mon_list">
                                        <li>
                                            <span class="mon">
                                                ${byMon.key + 1} 月
                                                <span class="mon-num">${byMon.value.size()}篇</span>
                                            </span>
                                            <ul class="post_list" style="display: none;">
                                                <c:forEach items="${byMon.value}" var="byDay">
                                                   <li>   <fmt:formatDate value="${byDay.articleCreateTime}"
                                                                          pattern="dd日"/>&nbsp;
                                                       <a href="/article/${byDay.id}">${byDay.articleTitle}</a>
                                                   </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </ul>
                                </c:forEach>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </article>
        </main>
    </div>
</rapid:override>

<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="part/sidebar-3.jsp" %>
</rapid:override>

<rapid:override name="footer-script">
    <script type="text/javascript">
        $(document).ready(function () {
            (function () {
                // $('#all_archives span.mon').each(function () {
                //     var num = $(this).next().children('li').size();
                //     var text = $(this).text();
                //     $(this).html(text + ' <span class="mon-num">' + num + ' 篇</span>');
                // });
                // 展开第一行数据
                // var $al_post_list = $('#all_archives ul.post_list'),
                //     $al_post_list_f = $('#all_archives ul.post_list:first');
                // $al_post_list.hide(1, function () {
                //     $al_post_list_f.show();
                // });
                $('#all_archives span.mon').click(function () {
                    $(this).next().slideToggle(400);
                    return false;
                });
            })();
        });
    </script>
</rapid:override>
<%--侧边栏 end--%>
<%@ include file="framework.jsp" %>