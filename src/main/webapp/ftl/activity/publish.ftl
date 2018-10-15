<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 2>
    <!-- main content area start -->
        <div class="main-content-inner">
            <div class="container">
                <div class="row">
                    <!-- Textual inputs start -->
                    <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title" style="display: flex;justify-content: space-between;">发布活动<a href="/activity.do" class="btn btn-secondary btn-xs mt-3">取消并返回</a></h4>
                                <p class="font-14 mb-4 list-group-item list-group-item-warning"><i class="ti-light-bulb"></i>注意核对活动俱乐部及活动组织者，活动时间请以整点或至少以半小时为单位，活动说明请尽可能详细。</p>
                                <form id="activityFormAdd" method="post" enctype="multipart/form-data" action="${ctx}/activity/saveActivityAdd.do">
                                    <div class="form-group">
                                        <label for="clubId" class="col-form-label"><code>*&nbsp;</code>俱乐部</label>
                                        <select class="custom-select" id="clubId" name="clubId">
                                        </select>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-3 mb-3">
                                            <label for="activityDate"><code>*&nbsp;</code>活动日期</label>
                                            <input class="form-control" type="date" value="${.now?string('yyyy-MM-dd')}" id="activityDate" name="activityDate">
                                        </div>
                                        <div class="col-md-3 mb-3">
                                            <label for="startTime"><code>*&nbsp;</code>活动开始时间</label>
                                            <input class="form-control" type="time" value="01:00:00" id="startTime" name="startTime">
                                        </div>
                                        <div class="col-md-3 mb-3">
                                            <label for="endTime"><code>*&nbsp;</code>活动结束时间</label>
                                            <input class="form-control" type="time" value="23:00:00" id="endTime" name="endTime">
                                        </div>
                                        <div class="col-md-3 mb-3">
                                            <label for="limitMember"><code>*&nbsp;</code>限报人数(<code>0表示无限制</code>)</label>
                                            <input class="form-control" type="number" value="0" id="limitMember" name="limitMember">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="activityAddress" class="col-form-label"><code>*&nbsp;</code>活动球馆</label>
                                        <input class="form-control" id="activityAddress" name="activityAddress" type="text" placeholder="请填写活动球馆...">
                                    </div>
                                    <div class="form-group">
                                        <label for="activityMemo" class="col-form-label"><code>*&nbsp;</code>活动介绍及说明</label>
                                        <textarea class="form-control" rows="10" id="activityMemo" name="activityMemo" required placeholder="请填写俱乐部活动详细介绍及说明，包括活动安排、活动费用、活动注意事项等..."></textarea>
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
                activityDate: {
                    message: '活动日期验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动日期不能为空'
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
                            message: '限报人数必须为大于0整数'
                        }
                    }
                },
                activityAddress: {
                    message: '活动球馆验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动球馆不能为空'
                        }
                    }
                },
                activityMemo: {
                    message: '活动说明验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动说明不能为空'
                        }
                    }
                }
            }
        });
    });
</script>
</@layout.layout>