<#macro header>
        <!-- main header area start -->
        <div class="mainheader-area">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a href="/home.do"><h5 style="color: #8255f7;">相约羽球</h5></a>
                        </div>
                    </div>
                    <div class="col-md-9 clearfix text-right">
                        <div class="clearfix d-md-inline-block d-block">
                            <div class="user-profile m-0" style="justify-content: center;">
                                <#if BADMINTON_GLOBAL_USER.avatar??>
                                    <img class="avatar user-thumb" src="${BADMINTON_GLOBAL_USER.avatar!''}" alt="avatar">
                                <#else>
                                    <img class="avatar user-thumb" src="${ctx}/assets/images/author/avatar.png" alt="avatar">
                                </#if>
                                <div class="user-name" style="display: flex;align-items: center;font-size: 10pt;">${BADMINTON_GLOBAL_USER.account}&nbsp;&nbsp;&nbsp;(${BADMINTON_GLOBAL_USER.nick})</div>
                                <a style="color: #fff;margin:0 20px;border: 1px solid #fff;font-size: 10pt;width: 50px;text-align: center;" href="/logout.do">退出</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main header area end -->
</#macro>