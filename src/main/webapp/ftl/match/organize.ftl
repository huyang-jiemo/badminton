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
                                <h4 class="header-title" style="display: flex;justify-content: space-between;">组织比赛<a href="/match.do" class="btn btn-secondary btn-xs">取消并返回</a></h4>
                                <p class="font-14 mb-4 list-group-item list-group-item-warning"><i class="ti-light-bulb"></i>注意核对活动俱乐部及活动组织者，活动时间请以整点或至少以半小时为单位，活动说明请尽可能详细。</p>
                                <form id="activityFormAdd" method="post" action="/match/saveMatchAdd.do">
                                    <div class="form-group">
                                        <label for="clubId" class="col-form-label"><code>*&nbsp;</code>俱乐部</label>
                                        <select class="custom-select" id="clubId" name="clubId">
                                        </select>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-6 mb-3">
                                            <label for="matchName"><code>*&nbsp;</code>比赛名称</label>
                                            <input class="form-control" id="matchName" name="matchName" type="text" placeholder="请填比赛名称...">
                                        </div>
                                        <div class="col-md-6 mb-3">
                                            <label for="matchAddress"><code>*&nbsp;</code>比赛场地</label>
                                            <input class="form-control" id="matchAddress" name="matchAddress" type="text" placeholder="请填比赛场馆地址...">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-4 mb-3">
                                            <label><code>*&nbsp;</code>开始时间</label>
                                            <input title="startDate" type="date" value="${.now?string('yyyy-MM-dd')}" id="startDate" name="startDate">
                                            <input title="startTime" type="time" value="09:00:00" id="startTime" name="startTime">
                                        </div>
                                        <div class="col-md-4 mb-3">
                                            <label><code>*&nbsp;</code>结束时间</label>
                                            <input title="endDate" type="date" value="${.now?string('yyyy-MM-dd')}" id="endDate" name="endDate">
                                            <input title="endTime" type="time" value="18:00:00" id="endTime" name="endTime">
                                        </div>
                                        <div class="col-md-4 mb-3">
                                            <label for="limitMember"><code>*&nbsp;</code>限报人数(<code>0表示无限制</code>)</label>
                                            <input type="number" value="0" id="limitMember" name="limitMember">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-12 mb-3">
                                            <label><code>*&nbsp;</code>对阵类型（<code>默认全部都有</code>）</label>
                                            <div class="form-control border-0">
                                                <div class="custom-control custom-checkbox custom-control-inline">
                                                    <input type="checkbox" checked value="1" class="custom-control-input" id="menSingle" name="menSingle">
                                                    <label class="custom-control-label" for="menSingle">男单</label>
                                                </div>
                                                <div class="custom-control custom-checkbox custom-control-inline">
                                                    <input type="checkbox" checked value="1" class="custom-control-input" id="womenSingle" name="womenSingle">
                                                    <label class="custom-control-label" for="womenSingle">女单</label>
                                                </div>
                                                <div class="custom-control custom-checkbox custom-control-inline">
                                                    <input type="checkbox" checked value="1" class="custom-control-input" id="menDouble" name="menDouble">
                                                    <label class="custom-control-label" for="menDouble">男双</label>
                                                </div>
                                                <div class="custom-control custom-checkbox custom-control-inline">
                                                    <input type="checkbox" checked value="1" class="custom-control-input" id="womenDouble" name="womenDouble">
                                                    <label class="custom-control-label" for="womenDouble">女双</label>
                                                </div>
                                                <div class="custom-control custom-checkbox custom-control-inline">
                                                    <input type="checkbox" checked value="1" class="custom-control-input" id="mixDouble" name="mixDouble">
                                                    <label class="custom-control-label" for="mixDouble">混双</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="matchMemo" class="col-form-label"><code>*&nbsp;</code>比赛介绍及说明</label>
                                        <textarea class="form-control" rows="10" id="matchMemo" name="matchMemo" required placeholder="请填写比赛介绍及说明、比赛须知、规则、要求等..."></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-primary mt-4 pr-4 pl-4">发布</button>
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
        $.ajax({
            url: '/club/clubSelect.do',
            type: 'GET',
            dataType: "json",
            success: function (res) {
                if(res.code===200){
                    $("#clubId").empty();
                    $.each(res.data,function (i,club) {
                        $("#clubId").append(
                                '<option value="'+club.id+'">'+club.clubName+'</option>'
                        );
                    });
                }
            }
        });
        $('#activityFormAdd').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                clubId: {
                    message: '俱乐部验证失败',
                    validators: {
                        notEmpty: {
                            message: '俱乐部不能为空'
                        }
                    }
                },
                matchName: {
                    message: '比赛名称验证失败',
                    validators: {
                        notEmpty: {
                            message: '比赛名称不能为空'
                        }
                    }
                },
                matchAddress: {
                    message: '比赛场地验证失败',
                    validators: {
                        notEmpty: {
                            message: '比赛场地不能为空'
                        }
                    }
                },
                startDate: {
                    message: '活动开始日期验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动开始日期不能为空'
                        }
                    }
                },
                endDate: {
                    message: '活动结束日期验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动结束日期不能为空'
                        }
                    }
                },
                startTime: {
                    message: '活动开始时间验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动开始时间不能为空'
                        }
                    }
                },
                endTime: {
                    message: '活动结束时间验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动结束时间不能为空'
                        }
                    }
                },
                limitMember: {
                    message: '限报人数验证失败',
                    validators: {
                        notEmpty: {
                            message: '限报人数不能为空'
                        },
                        numeric: {
                            message: '限报人数必须为整数'
                        }
                    }
                },
                matchMemo: {
                    message: '比赛介绍及说明验证失败',
                    validators: {
                        notEmpty: {
                            message: '比赛介绍及说明不能为空'
                        }
                    }
                }
            }
        });
    });
</script>
</@layout.layout>