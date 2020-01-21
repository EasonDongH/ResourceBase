<%--
    博客页脚部分
    包括：页脚部分
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--页脚 start--%>
<footer id="colophon" class="site-footer" role="contentinfo">
    <div id="footer-widget-box" class="site-footer wow fadeInUp" data-wow-delay="0.3s">
        <div class="footer-widget">
            <aside id="text-1" class="widget widget_text wow fadeInUp" data-wow-delay="0.3s">
                <h3 class="widget-title">
                    <span class="s-icon"></span>书山有路勤为径，学海无涯苦作舟
                </h3>
                <div class="textwidget">
                    <ul class="menu">
                        <c:forEach items="${menuList}" var="m">
                            <li class="menu-item">
                                <a href="${m.menuUrl}" target="_blank">
                                    <i class="${m.menuIcon}"></i>
                                    <span class="font-text">${m.menuName}&nbsp;</span>&nbsp;
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="clear"></div>
            </aside>
            <aside id="text-3" class="widget widget_text wow fadeInUp" data-wow-delay="0.3s">
                <h3 class="widget-title">
                    <span class="s-icon"></span> 关于本站
                </h3>
                <div class="textwidget">
                    <ul class="menu">
                        本站基于 Spring、SpringMVC、MyBatis、Redis、JSP 实现。
                    </ul>
                </div>
                <div class="clear"></div>
            </aside>
            <aside id="text-4" class="widget widget_text wow fadeInUp" data-wow-delay="0.3s">
                <h3 class="widget-title">
                    <span class="s-icon"></span>联系博主
                </h3>
                <div class="textwidget">
                    <ul class="menu">
                        <div style="float:right;width:35%;">
                            <img src="${pageContext.request.contextPath}/static/images/weixin.png">
                        </div>
                        <div style="margin-right:35%;padding-right:5px;">
                            <p>欢迎交流， 扫右侧微信二维码或加 QQ 1035264115</p>
                            <div class="clear"></div>
                        </div>
                    </ul>
                </div>
            </aside>
            <div class="clear"></div>
        </div>
    </div>

    <div class="site-info">
        <p style="text-align: center;">Copyright © 2020
            <a href="/" target="_blank" rel="noopener noreferrer">${options.optionSiteTitle}</a>
            All rights reserved.
        </p>
    </div>
    <!-- .site-info -->
</footer>
<!-- .site-footer -->
<%--页脚 end--%>

