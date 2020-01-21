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
        申请友链
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>
<rapid:override name="left">
    <%--博客主体-左侧文章正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post" style="min-height: 500px;">
                <header class="entry-header">
                    <h1 class="entry-title">
                            ${article.articleTitle}
                    </h1>
                </header><!-- .entry-header -->
                    ${article.articleContent}
                <footer class="single-footer">
                    <ul class="single-meta">
                        <li class="comment">
                            <a href="#comments" rel="external nofollow">
                                <i class="fa fa-comment-o"></i> ${commentList.size()}
                            </a>
                        </li>
                        <li class="views"><i class="fa fa-eye"></i> ${article.articleViewCount} views</li>
                        <li class="r-hide"><a href="javascript:pr()" title="侧边栏"><i
                                class="fa fa-caret-left"></i> <i class="fa fa-caret-right"></i></a></li>
                    </ul>
                </footer><!-- .entry-footer -->
                <div class="clear"></div>
    </div>
    <!-- .entry-content -->

    <div class="entry-content">
        <div class="single-content">
            <form class="layui-form layui-form-pane" id="applyLinkForm" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">网站名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="siteName" placeholder="如：${options.optionSiteTitle}"
                               class="layui-input" required>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">网站地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="siteUrl" placeholder="如：www.easondongh.cn" class="layui-input"
                               required>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">网站描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="siteDescription" placeholder="如：${options.optionSiteDescrption}"
                               class="layui-input" required>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系方式</label>
                    <div class="layui-input-block">
                        <input type="text" name="contactWay" placeholder="如：QQ、微信" class="layui-input" required>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <textarea placeholder="其他想说的内容" class="layui-textarea" name="remark" maxlength="100"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit="">提交申请</button>
                </div>
            </form>
        </div>
        <br><br>
        <footer class="single-footer">
            <ul class="single-meta">
                <li class="r-hide">
                    <a href="javascript:pr()" title="侧边栏">
                        <i class="fa fa-caret-left"></i>
                        <i class="fa fa-caret-right"></i>
                    </a>
                </li>
            </ul>
            <ul id="fontsize">
                <li>A+</li>
            </ul>
        </footer><!-- .entry-footer -->
        <div class="clear"></div>
    </div>
    <!-- .entry-content -->
    </article><!-- #post -->
    </main>
    <!-- .site-main -->
    <%--评论区域 start--%>
    <div class="scroll-comments"></div>
    <div id="comments" class="comments-area ">
        <ol class="comment-list">
            <c:set var="floor" value="0"/>
            <c:forEach items="${commentList}" var="c">
                <c:if test="${c.pid == 0}">
                    <c:set var="floor" value="${floor + 1}"/>
                    <li class="comments-anchor">
                        <ul id="anchor-comment-${c.id}"></ul>
                    </li>
                    <li class="comment">
                        <div id="div-comment-${c.id}" class="comment-body">
                            <div class="comment-author vcard">
                                <img class="avatar" src="/image/${c.avatarId}" alt="avatar"
                                     style="display: block;border-radius:50px;vertical-align:middle;">
                                <strong>${c.nickName}</strong>
                                <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <div style="float: right;">
                                                     <span class="reply">
                                                            <a rel="nofollow" class="comment-reply-link"
                                                               href="#respond">回复</a>
                                                     </span>
                                                </div>
                                                <br>
                                                <fmt:formatDate value="${c.createTime}"
                                                                pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                            </span>
                                        </span>
                                <p>
                                        ${c.content}
                                </p>
                            </div>
                        </div>
                    </li>
                </c:if>
            </c:forEach>
        </ol>
    </div>
    <%--评论框 end--%>
    </div>
    <%--博客主体-左侧文章正文end--%>
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