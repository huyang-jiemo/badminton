<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 2>
    <!-- main content area start -->
        <div class="main-content-inner">
            <div class="container">
                <#if activityModelList?? && (activityModelList?size > 0) >
                    <div class="row">
                        <div class="col-md-12 mt-5">
                            <div class="card">
                                <div class="card-body">
                                    <h6 class="header-title">近期活动列表（<code class="text-warning">默认只展示今天或今天以后的活动</code>）</h6>
                                    <div class="list-group">
                                        <#list activityModelList as activityModel>
                                            <a href="${ctx}/activity/activityDetail.do?id=${activityModel.activity.id!''}" class="list-group-item list-group-item-action flex-column align-items-start bg-light">
                                                <div class="alert" role="alert">
                                                    <strong class="text-primary">${activityModel.club.clubName!''}</strong>
                                                    <hr>
                                                    <div class="d-flex w-100 justify-content-between">
                                                        <strong class="text-success">活动时间：${activityModel.activity.activityDate!''}&nbsp;${activityModel.activity.startTime!''}-${activityModel.activity.endTime!''}</strong>
                                                        <p class="text-muted">
                                                            <#if activityModel.activity.limitMember==0>
                                                                <code style="border-right: 1px solid gray;padding-right: 10px;">限报：无限制</code>
                                                            <#else>
                                                                <code style="border-right: 1px solid gray;padding-right: 10px;">限报：${activityModel.activity.limitMember!'无限制'}人</code>
                                                            </#if>
                                                            <code class="text-success" style="padding-left: 10px;">已报：${activityModel.activityMemberList?size}人</code>
                                                        </p>
                                                    </div>
                                                    <p style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" class="mb-1 text-secondary">${activityModel.activity.activityMemo!''}</p>
                                                </div>
                                                <p class="text-dark">
                                                    <i class="ti-map-alt"></i>&nbsp;&nbsp;&nbsp;${activityModel.activity.activityAddress!''}
                                                    <em class="text-dark float-right">电话：${activityModel.user.phone!''}</em>
                                                    <em class="text-dark float-right" style="margin-right: 20px;">联系人：${activityModel.user.nick!''}</em>
                                                </p>
                                            </a>
                                            <hr>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                <#else>
                    <div class="col-lg-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <div class="additional-content">
                                    <div class="alert alert-danger" role="alert">
                                        <h4 class="alert-heading">暂无最近活动!</h4>
                                        <hr>
                                        <p>请等待俱乐部会长发布活动预告后，再进行查看和报名！</p>
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