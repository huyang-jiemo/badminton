<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 1>
    <!-- main content area start -->
    <div class="main-content-inner">
        <div class="container">
            <#if clubList?? && (clubList?size > 0) >
                <div class="card-area">
                    <div class="row">
                        <#list clubList as club>
                            <div class="col-lg-4 col-md-6 mt-5">
                                <div class="card card-bordered">
                                    <#if club.clubLogo??>
                                        <img style="width: 450px;height: 250px;" class="card-img-top img-fluid" src="${club.clubLogo!''}" alt="image">
                                    <#else>
                                        <img style="width: 450px;height: 250px;" class="card-img-top img-fluid" src="${ctx}/assets/images/card/club1.jpg" alt="image">
                                    </#if>
                                    <div class="card-body">
                                        <h5 class="title">${club.clubName!''}</h5>
                                        <p><code><i class="ti-map-alt"></i></code>&nbsp;&nbsp;&nbsp;<mark>${club.clubAddress!''}</mark></p>
                                        <p style="height: 60px;overflow: hidden;" class="card-text">${club.clubMemo!''}</p>
                                        <div class="form-row" style="display: flex;justify-content: space-between;align-items: center;">
                                            <a href="${ctx}/club/seeClubMore.do?id=${club.id!''}" class="btn btn-xs btn-primary">详情</a>
                                            <p><small>QQ群：${club.clubQqGroup!'无'}</small></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            <#else>
                <div class="col-lg-12 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <div class="additional-content">
                                <div class="alert alert-danger" role="alert">
                                    <h4 class="alert-heading">暂无俱乐部信息!</h4>
                                    <hr>
                                    <p>如需创建自己的俱乐部，请联系系统管理员创建！</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#if>
        </div>
    </div>
    <!-- main content area end -->
</@layout.layout>