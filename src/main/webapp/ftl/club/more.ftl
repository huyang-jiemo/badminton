<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 1>
    <!-- main content area start -->
    <div class="main-content-inner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <div class="col-lg-12 col-md-6 mt-5">
                                <div class="media">
                                    <#if user.avatar??>
                                        <img style="width: 80px;height: 80px;" class="mr-4 img-thumbnail" src="${user.avatar!''}" alt="image">
                                    <#else>
                                        <img style="width: 80px;height: 80px;" class="mr-4 img-thumbnail" src="${ctx}/assets/images/author/avatarHead.jpg" alt="image">
                                    </#if>
                                    <div class="media-body">
                                        <p><code>会长：</code>${user.nick!''}</p>
                                        <#assign sexValue = (user.sex == 1)?string((user.sex == 2)?string('女','男'),(user.sex == 0)?string('未知','女')) />
                                        <p><code>性别：</code>${sexValue}</p>
                                        <p><code>电话：</code>${user.phone!''}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="col-lg-12 col-md-6">
                                <div class="card card-body">
                                    <h2 class="text-center">${club.clubName!''}</h2>
                                </div>
                                <div class="text-left">
                                    <div class="text-lg-left alert alert-primary" style="font-size: 16pt;">
                                        <span class="badge badge-primary col-2 text-left">活动地点（场馆）：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>${club.clubAddress!''}</small>
                                        <hr>
                                        <span class="badge badge-primary col-2 text-left">QQ群：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>${club.clubQqGroup!''}</small>
                                    </div>
                                </div>
                                <div class="carousel slide card card-body text-center" data-ride="carousel">
                                    <div class="carousel-inner">
                                        <#if club.clubLogo??>
                                            <img style="max-width: 80%;max-height: 500px;" class="card-img-top img-thumbnail" src="${club.clubLogo!''}" alt="image">
                                        <#else>
                                            <img style="max-width: 80%;max-height: 500px;" class="card-img-top img-thumbnail" src="${ctx}/assets/images/card/club1.jpg" alt="image">
                                        </#if>
                                    </div>
                                </div>
                                <blockquote class="blockquote bg-secondary">
                                    <p class="mb-3">${club.clubMemo?replace('\r\n','<br/>','i')}</p>
                                </blockquote>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main content area end -->
</@layout.layout>