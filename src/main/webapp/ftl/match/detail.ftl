<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 3>
        <!-- main content area start -->
        <div class="main-content-inner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-6 mt-5">
                        <div class="card card-bordered">
                            <div class="card-body">
                                <h3 class="mb-3">${matchModel.match.matchName!''}<code class="float-right text-dark">${matchModel.club.clubName!''}</code></h3>
                                <h5 class="mb-3">比赛日程：<mark>${matchModel.match.startTime!''} - ${matchModel.match.endTime!''}</mark></h5>
                                <p class="alert alert-secondary font-weight-bold" style="font-size: 16pt;">
                                    <#if matchModel.match.menSingle==1>
                                        <code class="badge badge-primary">男单</code>
                                    </#if>
                                    <#if matchModel.match.womenSingle==1>
                                        <code class="badge badge-danger">女单</code>
                                    </#if>
                                    <#if matchModel.match.menDouble==1>
                                        <code class="badge badge-success">男双</code>
                                    </#if>
                                    <#if matchModel.match.womenDouble==1>
                                        <code class="badge badge-info">女双</code>
                                    </#if>
                                    <#if matchModel.match.mixDouble==1>
                                        <code class="badge badge-dark">混双</code>
                                    </#if>
                                </p>
                                <p class="alert alert-secondary font-weight-bold" style="font-size: 16pt;">比赛场地：${matchModel.match.matchAddress!''}</p>
                                <#if matchModel.match.limitMember==0>
                                    <p class="alert alert-secondary font-weight-bold" style="font-size: 16pt;">限报人数：<code>无限制</code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已报人数：<code class="text-success">${matchModel.matchEnterList?size}</code></p>
                                <#else>
                                    <p class="alert alert-secondary font-weight-bold" style="font-size: 16pt;">限报人数：<code>${matchModel.match.limitMember!''}</code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已报人数：<code>${matchModel.matchEnterList?size}</code></p>
                                </#if>
                                <!-- 报名详情 -->
                                <div class="invoice-table table-responsive">
                                    <#if matchModel.matchEnterList?? && (matchModel.matchEnterList?size > 0) >
                                        <table class="table table-bordered table-hover text-right">
                                            <thead>
                                            <tr class="text-capitalize">
                                                <th class="text-center" style="width: 100px;">序号</th>
                                                <th class="text-center">昵称</th>
                                                <th>性别</th>
                                                <th style="width: 200px;">电话</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                                <#list matchModel.matchEnterList as matchEnter>
                                                <tr>
                                                    <td class="text-center">${matchEnter_index+1}</td>
                                                    <td class="text-center">${matchEnter.nick!''}</td>
                                                    <td>
                                                        <#assign sexValue = (matchEnter.sex == 1)?string('男','女') />
                                                        ${sexValue}
                                                    </td>
                                                    <td>${matchEnter.phone!''}</td>
                                                </tr>
                                                </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr class="bg-light">
                                                <td colspan="3">已报总人数 :</td>
                                                <td>${matchModel.matchEnterList?size}</td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    <#else>
                                        <div class="col-lg-12">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="additional-content">
                                                        <div class="alert alert-warning" role="alert">
                                                            <h4 class="alert-heading">暂无人员报名!</h4>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </#if>
                                </div>
                                <blockquote class="blockquote bg-secondary">
                                    <p class="mb-3">${matchModel.match.matchMemo?replace('\r\n','<br/>','i')}</p>
                                </blockquote>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main content area end -->
</@layout.layout>