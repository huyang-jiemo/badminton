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
                                <h5 class="mb-3">比赛日程：<mark>${matchModel.match.startTime!''} - ${matchModel.match.endTime!''}</mark><code class="float-right text-dark">比赛场地：${matchModel.match.matchAddress!''}</code></h5>
                                <#if matchModel.match.limitMember==0>
                                    <p class="alert alert-secondary font-weight-bold" style="font-size: 16pt;">限报人数：<code>无限制</code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已报人数：<code class="text-success">${matchModel.matchEnterList?size}</code></p>
                                <#else>
                                    <p class="alert alert-secondary font-weight-bold" style="font-size: 16pt;">限报人数：<code>${matchModel.match.limitMember!''}</code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已报人数：<code class="text-success">${matchModel.matchEnterList?size}</code></p>
                                </#if>
                                <!-- 对阵安排 -->
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <div id="accordion2" class="according accordion-s2">
                                                <!-- 男单 -->
                                                <#if matchModel.match.menSingle==1>
                                                    <div class="card">
                                                        <div class="card-header">
                                                            <a class="card-link text-primary" data-toggle="collapse" href="#accordion21">男单</a>
                                                        </div>
                                                        <div id="accordion21" class="collapse show" data-parent="#accordion2">
                                                            <div class="card-body">
                                                                <#list menSingleList as ms>
                                                                    <#assign sexValue = (ms.sex == 1)?string('男','女') />
                                                                    <button type="button" class="btn btn-xs btn-light mb-3">${ms.nick}（${sexValue}-${ms.phone}）</button>
                                                                </#list>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </#if>
                                                <!-- 女单 -->
                                                <#if matchModel.match.womenSingle==1>
                                                    <div class="card">
                                                        <div class="card-header">
                                                            <a class="collapsed card-link text-danger" data-toggle="collapse" href="#accordion22">女单</a>
                                                        </div>
                                                        <div id="accordion22" class="collapse" data-parent="#accordion2">
                                                            <div class="card-body">
                                                                <#list womenSingleList as ws>
                                                                    <#assign sexValue = (ws.sex == 1)?string('男','女') />
                                                                    <button type="button" class="btn btn-xs btn-light mb-3">${ws.nick}（${sexValue}-${ws.phone}）</button>
                                                                </#list>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </#if>
                                                <!-- 男双 -->
                                                <#if matchModel.match.menDouble==1>
                                                    <div class="card">
                                                        <div class="card-header">
                                                            <a class="collapsed card-link text-success" data-toggle="collapse" href="#accordion23">男双</a>
                                                        </div>
                                                        <div id="accordion23" class="collapse" data-parent="#accordion2">
                                                            <div class="card-body">
                                                                <#list menDoubleList as md>
                                                                    <#assign sexValue = (md.sex == 1)?string('男','女') />
                                                                    <button type="button" class="btn btn-xs btn-light mb-3">${md.nick}（${sexValue}-${md.phone}）</button>
                                                                </#list>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </#if>
                                                <!-- 女双 -->
                                                <#if matchModel.match.womenDouble==1>
                                                    <div class="card">
                                                        <div class="card-header">
                                                            <a class="collapsed card-link text-info" data-toggle="collapse" href="#accordion24">女双</a>
                                                        </div>
                                                        <div id="accordion24" class="collapse" data-parent="#accordion2">
                                                            <div class="card-body">
                                                                <#list womenDoubleList as wd>
                                                                    <#assign sexValue = (wd.sex == 1)?string('男','女') />
                                                                    <button type="button" class="btn btn-xs btn-light mb-3">${wd.nick}（${sexValue}-${wd.phone}）</button>
                                                                </#list>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </#if>
                                                <!-- 混双 -->
                                                <#if matchModel.match.mixDouble==1>
                                                    <div class="card">
                                                        <div class="card-header">
                                                            <a class="collapsed card-link text-dark" data-toggle="collapse" href="#accordion25">混双</a>
                                                        </div>
                                                        <div id="accordion25" class="collapse" data-parent="#accordion2">
                                                            <div class="card-body">
                                                                <#list mixDoubleList as mxd>
                                                                    <#assign sexValue = (mxd.sex == 1)?string('男','女') />
                                                                    <button type="button" class="btn btn-xs btn-light mb-3">${mxd.nick}（${sexValue}-${mxd.phone}）</button>
                                                                </#list>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </#if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main content area end -->
</@layout.layout>