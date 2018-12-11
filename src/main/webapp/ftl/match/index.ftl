<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 3>
        <!-- main content area start -->
        <div class="main-content-inner">
            <div class="container">
                <#if matchModelList?? && (matchModelList?size > 0) >
                    <div class="row">
                        <#list matchModelList as matchModel>
                            <#assign endDate=matchModel.match.endTime?datetime("yyyy-MM-dd HH:mm:ss")>
                            <#assign color=(.now>endDate)?string('secondary','primary')>
                            <div class="col-lg-6 mt-5 text-${color!''}">
                                <div class="card">
                                    <div class="card-body">
                                        <ul class="list-unstyled">
                                            <li class="media mb-4">
                                                <img style="width: 100px;height: 100px;" class="border img-fluid mr-4" src="/assets/images/media/matchbg.jpg" alt="image">
                                                <div class="media-body">
                                                    <h5 class="mb-3">${matchModel.match.matchName!''}<em class="float-right">${matchModel.club.clubName!''}</em></h5>
                                                    <hr>
                                                    <h6>比赛日程：<mark class="mb-3 badge badge-${color!''}">${matchModel.match.startTime!''} - ${matchModel.match.endTime!''}</mark></h6>
                                                    <p class="alert alert-${color!''} font-weight-bold font-14">
                                                        <#if matchModel.match.menSingle==1>
                                                            <code class="badge badge-${color!''}">男单</code>
                                                        </#if>
                                                        <#if matchModel.match.womenSingle==1>
                                                            <code class="badge badge-${color!''}">女单</code>
                                                        </#if>
                                                        <#if matchModel.match.menDouble==1>
                                                            <code class="badge badge-${color!''}">男双</code>
                                                        </#if>
                                                        <#if matchModel.match.womenDouble==1>
                                                            <code class="badge badge-${color!''}">女双</code>
                                                        </#if>
                                                        <#if matchModel.match.mixDouble==1>
                                                            <code class="badge badge-${color!''}">混双</code>
                                                        </#if>
                                                    </p>
                                                    <span>比赛场地：${matchModel.match.matchAddress!''}</span>
                                                    <#if matchModel.match.limitMember==0>
                                                        <p class="text-${color!''}">限报人数：无限制&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已报人数：${matchModel.matchEnterList?size}</p>
                                                    <#else>
                                                        <p class="text-${color!''}">限报人数：${matchModel.match.limitMember!''}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已报人数：${matchModel.matchEnterList?size}</p>
                                                    </#if>
                                                    <span style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">比赛说明：${matchModel.match.matchMemo!''}</span>
                                                    <hr>
                                                    <p>
                                                        <a href="/match/seeMatchDetail.do?id=${matchModel.match.id!''}" class="btn btn-xs btn-${color!''}">详情</a>
                                                        <#assign endDate=matchModel.match.endTime?datetime("yyyy-MM-dd HH:mm:ss")>
                                                        <#if (.now<=endDate)&&(matchModel.match.limitMember==0||matchModel.matchEnterList?size<matchModel.match.limitMember)>
                                                            <a href="/match/applyMatch.do?id=${matchModel.match.id!''}" class="btn btn-xs btn-${color!''}">立即报名</a>
                                                            <#if (matchModel.matchEnterList?size>0)>
                                                                <a href="/match/organizeMatchMember.do?id=${matchModel.match.id!''}" class="btn btn-xs btn-${color!''}">安排对阵</a>
                                                            </#if>
                                                        </#if>
                                                    </p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                <#else>
                    <div class="col-lg-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <div class="additional-content">
                                    <div class="alert alert-warning" role="alert">
                                        <h4 class="alert-heading">暂无比赛信息!</h4>
                                        <hr>
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