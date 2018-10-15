<#macro sidebar menu_index>
        <!-- header area start -->
        <div class="header-area header-bottom">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-9  d-none d-lg-block">
                        <div class="horizontal-menu">
                            <nav>
                                <ul id="nav_menu">
                                    <li class="${(menu_index==0)?string('active','')}">
                                        <a href="${ctx}/home.do"><i class="ti-home"></i> <span>首页</span></a>
                                        <!-- 系统管理员角色操作 -->
                                        <#if BADMINTON_GLOBAL_USER.role==1>
                                            <ul class="submenu">
                                                <li><a href="${ctx}/user/index.do">人员管理</a></li>
                                            </ul>
                                        </#if>
                                    </li>
                                    <li class="${(menu_index==1)?string('active','')}">
                                        <a href="${ctx}/club.do"><i class="ti-flag-alt"></i> <span>俱乐部</span></a>
                                        <!-- 系统管理员角色操作 -->
                                        <#if BADMINTON_GLOBAL_USER.role==1>
                                            <ul class="submenu">
                                                <li><a href="${ctx}/club/clubAdd.do">创建俱乐部</a></li>
                                            </ul>
                                        </#if>
                                    </li>
                                    <li class="${(menu_index==2)?string('active','')}">
                                        <a href="${ctx}/activity.do"><i class="ti-announcement"></i> <span>活动</span></a>
                                        <!-- 系统管理员角色操作 -->
                                        <#if BADMINTON_GLOBAL_USER.role==1>
                                            <ul class="submenu">
                                                <li><a href="${ctx}/activity/activityPublish.do">发布活动</a></li>
                                            </ul>
                                        </#if>
                                    </li>
                                    <li class="${(menu_index==3)?string('active','')}">
                                        <a href="${ctx}/match.do"><i class="ti-cup"></i> <span>比赛</span></a>
                                    </li>
                                    <li class="${(menu_index==4)?string('active','')}">
                                        <a href="${ctx}/news.do"><i class="ti-signal"></i> <span>资讯</span></a>
                                    </li>
                                    <li class="${(menu_index==4)?string('active','')}">
                                        <a href="${ctx}/share.do"><i class="ti-light-bulb"></i> <span>共享资源</span></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <!-- nav and search button -->
                    <div class="col-lg-3 clearfix">
                        <div class="search-box">
                            <form action="#">
                                <input type="text" name="search" placeholder="搜索..." required>
                                <i class="ti-search"></i>
                            </form>
                        </div>
                    </div>
                    <!-- mobile_menu -->
                    <div class="col-12 d-block d-lg-none">
                        <div id="mobile_menu"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- header area end -->
</#macro>