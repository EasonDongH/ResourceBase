<%--
    一般用于首页侧边栏：
    包括 关于本站，网站概况，热评文章，所有标签，随机文章 等小工具
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--博客主体-右侧侧边栏 start--%>
<div id="sidebar" class="widget-area all-sidebar"
     style="position: relative; overflow: visible; box-sizing: border-box; min-height: 1px;">
    <%--关于本站 start--%>
    <aside class="widget about">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>关于本站
        </h3>
        <div id="feed_widget">
            <div class="feed-about">
                <div class="about-main">
                    <div class="about-img">
                        <img src="/image/authorPhoto" alt="QR Code">
                    </div>
                    <div class="about-name">${options.siteAuthorName}</div>
                    <div class="about-the">
                        ${options.optionMetaDescrption}
                    </div>
                </div>
                <div class="clear"></div>
                <ul>
                    <li class="weixin">
                        <a title="微信" id="weixin_btn" rel="external nofollow">
                            <i class="fa fa-weixin"> </i>
                            <div id="weixin_code" class="hide">
                                <img src="${options.siteAuthorWechat}" alt="">
                            </div>
                        </a>
                    </li>
                    <li class="tqq">
                        <a target="blank" rel="external nofollow"
                           href="http://wpa.qq.com/msgrd?V=3&amp;uin=${options.siteAuthorQQ}&amp;Site=QQ&amp;Menu=yes"
                           title="QQ在线">
                            <i class="fa fa-qq"></i>
                        </a>
                        <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=&site=qq&menu=yes">
                            <img border="0" src="http://wpa.qq.com/pa?p=2::52" alt="点击这里给我发消息" title="点击这里给我发消息"/>
                        </a>
                    </li>
                    <li class="tsina">
                        <a title=""
                           href="http://weibo.com/${options.siteAuthorWeibo}"
                           target="_blank" rel="external nofollow">
                            <i class="fa fa-weibo"></i>
                        </a>
                    </li>
                    <li class="feed">
                        <a title="" href="https://github.com/${options.siteAuthorGitHub}" target="_blank"
                           rel="external nofollow">
                            <i class="fa fa-github"></i>
                        </a>
                    </li>
                </ul>
                <div class="about-inf">
                    <span class="about-pn">文章 ${siteBasicStatistics[0]} </span>
                    <span class="about-cn">留言 ${siteBasicStatistics[2]} </span>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </aside>
    <%--关于本站 start--%>

    <%--网站概况 start--%>
    <aside id="php_text-22" class="widget php_text">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>网站概况
        </h3>
        <div class="textwidget widget-text">
            <ul class="site-profile">
                <li><i class="fa fa-file-o"></i> 文章总数：${siteBasicStatistics[0]} 篇</li>
                <li><i class="fa fa-eye"></i> 浏览总量：${siteBasicStatistics[1]} 次</li>
                <li><i class="fa fa-commenting-o"></i> 留言数量：${siteBasicStatistics[2]} 条</li>
                <li><i class="fa fa-folder-o"></i> 分类数量：${siteBasicStatistics[3]} 个</li>
                <li><i class="fa fa-tags"></i> 标签总数：${siteBasicStatistics[4]} 个</li>
                <li><i class="fa fa-clock-o"></i> 运行时间：${siteBasicStatistics[5]} 天</li>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--网站概况 end--%>

    <%--热评文章 start--%>
    <aside class="widget hot_comment">
        <h3 class="widget-title"><i class="fa fa-bars"></i>热评文章</h3>
        <div id="hot_comment_widget">
            <ul>
                <c:forEach items="${mostCommentArticleList}" var="a" varStatus="index">
                    <li>
                        <span class='li-icon li-icon-${index.index+1}'>${index.index+1}</span>
                        <a href="/article/${a.id}" rel="bookmark" title=" (${a.articleCommentCount}条评论)" target="_blank">
                                ${a.articleTitle}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--热评文章 end--%>

</div>
<%--博客主体-右侧侧边栏 end--%>
