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
    <link rel="stylesheet" href="static/plugin/layui/css/layui.css">
</rapid:override>

<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/">
            <i class="fa fa-home"></i>首页
        </a>
        <i class="fa fa-angle-right"></i>
        留言板
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
                        留言板
                    </h1>
                </header><!-- .entry-header -->

                <div class="entry-content">
                    <div class="single-content">

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
                </div><!-- .entry-content -->
            </article><!-- #post -->

                <%--留言区域 start--%>
            <div class="scroll-comments"></div>
            <div id="comments" class="comments-area ">
                <div id="respond" class="comment-respond">
                    <h3 id="reply-title" class="comment-reply-title"><span id="reply-title-word">发表评论</span>
                        <a rel="nofollow" id="cancel-comment-reply-link" href="/article/${article.id}#respond" style="">取消回复</a>
                    </h3>
                    <form id="comment_form" method="post">
                        <c:if test="${sessionScope.user != null}">
                            <div class="user_avatar">
                                <img alt="avatar" src="${sessionScope.user.userAvatar}" class="avatar avatar-64 photo"
                                     height="64" width="64">
                                登录者：${sessionScope.user.userNickname}
                                <br> <a href="javascript:void(0)" onclick="logout()">登出</a>
                                <input type="hidden" name="commentRole" value="1">
                                <input type="hidden" name="commentAuthorName"
                                       value="${sessionScope.user.getUserNickname()}">
                                <input type="hidden" name="commentAuthorEmail"
                                       value="${sessionScope.user.getUserEmail()}">
                                <input type="hidden" name="commentAuthorUrl" value="${sessionScope.user.getUserUrl()}">
                            </div>
                        </c:if>
                        <p class="comment-form-comment">
                            <textarea id="comment" name="content" rows="4" tabindex="1" style="resize:none;"
                                      required></textarea>
                        </p>
                        <div id="comment-author-info">
                            <input type="hidden" name="pid" value="0">
                            <input type="hidden" name="pname" value="">
                            <c:if test="${sessionScope.user == null}">
                                <p class="comment-form-author">
                                    <label for="author_name">昵称</label>
                                    <input type="text" name="nickName" id="author_name" tabindex="2">
                                </p>
                                <p class="comment-form-email">
                                    <label for="author_email">联系方式</label>
                                    <input type="email" name="commentAuthorEmail" id="author_email" tabindex="3">
                                </p>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                        <p class="form-submit">
                            <input id="submit" name="submit" type="submit" tabindex="5" value="提交评论">
                            <input type="hidden" name="aid"
                                   value="${article.id}" id="article_id">
                            <input type="hidden" name="pid" id="comment_pid" value="0">
                        </p>
                    </form>
                </div>

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
                                             style="display: block;border-radius:50px;">
                                        <strong>${c.nickName}</strong>
                                        <c:if test="${c.userId == article.userId}">
                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                            <span class=""
                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>博主</b></span>
                                        </c:if>
                                        <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <div style="float: right;">
                                                    <c:if test="${c.childCommentCount > 0}">
                                                        <span class="readreply">
                                                                <a id="reply-list-a-${c.id}" rel="nofollow"
                                                                   class="comment-reply-link" href="#respond"
                                                                   onclick="readreply(${c.id})">查看回复(${c.childCommentCount})</a>
                                                            <input type="hidden" id="reply-count-${c.id}"
                                                                   value="${c.childCommentCount}"/>
                                                        </span>
                                                    </c:if>
                                                     <span id="replyspan-${c.id}" class="reply">
                                                            <a id="showreply-${c.id}" rel="nofollow" class="comment-reply-link" href="#respond"
                                                            >回复</a>
                                                     </span>

                                                </div>
                                                <br>
                                                <fmt:formatDate value="${c.createTime}"
                                                                pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                <c:if test="${sessionScope.user != null}">
                                                        <a href="javascript:void(0)"
                                                           onclick="deleteComment(${c.commentId})">删除</a>
                                                    <a class="comment-edit-link"
                                                       href="/admin/comment/edit/${c.commentId}"
                                                       target="_blank">编辑</a>
                                                </c:if>
                                            </span>
                                        </span>
                                        <p>
                                            <c:if test="${c.pid!=0}">
                                                <span class="at">@ ${c.pname}</span>
                                            </c:if>
                                                ${c.content}
                                        </p>
                                        <div>
                                            <input type="text" style="display: none" id="replayInput-${c.id}" />
                                        </div>
                                    </div>
                                </div>
                                <ul class="children" style="display: none;" id="reply-list-${c.id}">
                                    <c:set var="floor2" value="0"/>
                                    <c:forEach items="${commentList}" var="c2">
                                        <c:if test="${c.id == c2.pid}">
                                            <c:set var="floor2" value="${floor2+1}"/>
                                            <li class="comments-anchor">
                                                <ul id="anchor-comment-${c2.id}"></ul>
                                            </li>
                                            <li class="comment">
                                                <div id="div-comment-${c.id}" class="comment-body">
                                                    <div class="comment-author vcard">
                                                        <img class="avatar" src="/image/${c.avatarId}" alt="avatar"
                                                             style="display: block;border-radius:50px;">
                                                        <strong>${c2.nickName} </strong>
                                                        <c:if test="${c2.pid!=0}">
                                                            &nbsp;回复&nbsp;<span class="at">${c2.pname}</span>
                                                        </c:if>
                                                        <c:if test="${c.userId == article.userId}">
                                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                                            <span class=""
                                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>博主</b></span>
                                                        </c:if>
                                                        <span class="comment-meta">
                                                    <span class="ua-info" style="display: inline;">
                                                    <span class="comment-aux">
                                                        <span class="reply">
                                                            <a rel="nofollow" class="comment-reply-link" href="#respond"
                                                               onclick="replyComment()">回复</a>
                                                        </span>
                                                        <br>
                                                        <fmt:formatDate value="${c2.createTime}"
                                                                        pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                        <c:if test="${sessionScope.user != null}">
                                                            <a href="javascript:void(0)"
                                                               onclick="deleteComment(${c2.id})">删除</a>
                                                            <a class="comment-edit-link"
                                                               href="/admin/comment/edit/${c2.id}"
                                                               target="_blank">编辑</a>
                                                        </c:if>
                                                    </span>
                                                </span>
                                                    </span>
                                                        <p>
                                                            <c:if test="${c2.pid!=0}">
                                                                ${c2.content}
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                    </c:forEach>
                </ol>
            </div>
                <%--留言区域 end--%>

        </main>
        <!-- .site-main -->
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
        //添加用户验证和编辑用户验证
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form, layer = layui.layer;
            form.verify({
                userName: function (value) {
                    if (value.length > 12 || value.length < 4) {
                        return "用户名必须4到12位";
                    }
                    if(checkUserName()==1) {
                        return "用户名已存在";
                    }
                },
                userEmail: function () {
                    if(checkUserEmail()==1) {
                        return "电子邮箱已存在";
                    }
                }
            });
            form.on('submit(demo1)', function (data) {
                return true;
            });
        });
    </script>
</rapid:override>

<%@ include file="framework.jsp" %>