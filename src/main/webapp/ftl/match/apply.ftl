<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 3>
    <!-- main content area start -->
    <div class="main-content-inner">
        <div class="container">
            <div class="row">
                <!-- Textual inputs start -->
                <div class="col-12 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="header-title" style="display: flex;justify-content: space-between;">比赛报名<a href="/match.do" class="btn btn-secondary btn-xs">取消并返回</a></h4>
                            <ul class="list-unstyled">
                                <li class="media mb-4">
                                    <img style="width: 100px;height: 100px;" class="border img-fluid mr-4" src="/assets/images/media/matchbg.jpg" alt="image">
                                    <div class="media-body">
                                        <h6 class="mb-3">${matchModel.match.matchName!''}</h6>
                                        <p class="font-weight-bold">比赛日程：<code>${matchModel.match.startTime!''} - ${matchModel.match.endTime!''}</code></p>
                                        <p class="font-weight-bold">比赛场地：${matchModel.match.matchAddress!''}</p>
                                        <p class="font-weight-bold">比赛说明：${matchModel.match.matchMemo!''}</p>
                                    </div>
                                </li>
                            </ul>
                            <form id="activityFormAdd" method="post" action="/match/saveMatchApply.do">
                                <input title="matchId" hidden id="matchId" name="matchId" value="${matchModel.match.id}">
                                <div class="form-row">
                                    <div class="col-md-3 mb-3">
                                        <label for="matchType"><code>*&nbsp;</code>选择比赛类型</label>
                                        <select class="custom-select" id="matchType" name="matchType">
                                            <option value="1">男单</option>
                                            <option value="2">女单</option>
                                            <option value="3">男双</option>
                                            <option value="4">女双</option>
                                            <option value="5">混双</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="nick"><code>*&nbsp;</code>昵称</label>
                                        <input class="form-control" id="nick" name="nick" type="text" placeholder="请填比昵称...">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="sex"><code>*&nbsp;</code>性别</label>
                                        <select class="custom-select" id="sex" name="sex">
                                            <option value="1">男</option>
                                            <option value="2">女</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="phone">电话</label>
                                        <input class="form-control" id="phone" name="phone" type="text">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary mt-4 pr-4 pl-4">提交</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main content area end -->
<script>
    $(function () {
        $('#activityFormAdd').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nick: {
                    message: '昵称验证失败',
                    validators: {
                        notEmpty: {
                            message: '昵称不能为空'
                        }
                    }
                }
            }
        });
    });
</script>
</@layout.layout>