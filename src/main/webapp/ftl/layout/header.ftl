<#macro header>
        <!-- main header area start -->
        <div class="mainheader-area" style="background: linear-gradient(180deg, #29B6F6 0%, #4FC3F7 100%);">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a style="display: flex;align-items: center;max-width: 100%" href="${ctx}/home.do">
                                <img style="border-radius: 50%;width: 50px;height: 50px;" src="${ctx}/assets/images/icon/logoband.jpeg" alt="logo">
                                <h3 class="text-white" style="margin-left: 20px;">相约羽毛球</h3>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-9 clearfix text-right">
                        <div class="clearfix d-md-inline-block d-block">
                            <div class="user-profile m-0" style="background: linear-gradient(180deg, #29B6F6 0%, #4FC3F7 100%);">
                                <#if BADMINTON_GLOBAL_USER.avatar??>
                                    <img class="avatar user-thumb" src="${BADMINTON_GLOBAL_USER.avatar!''}" alt="avatar">
                                <#else>
                                    <img class="avatar user-thumb" src="${ctx}/assets/images/author/avatar.png" alt="avatar">
                                </#if>
                                <h8 class="user-name">${BADMINTON_GLOBAL_USER.account}&nbsp;&nbsp;&nbsp;(${BADMINTON_GLOBAL_USER.nick})</h8>
                                <a style="margin-left: 10px;border-left: 1px solid white;padding-left: 10px;" class="text-white" href="${ctx}/logout.do"><i class="ti-new-window"></i>退出</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main header area end -->
</#macro>