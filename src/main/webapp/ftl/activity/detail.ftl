<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 2>
    <!-- main content area start -->
        <div class="main-content-inner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title" style="display: flex;justify-content: space-between;">活动详情<a href="/activity.do" class="btn btn-secondary btn-xs">返回活动列表</a></h4>
                                <div class="invoice-area">
                                    <div class="invoice-head">
                                        <div class="row" style="font-size: 15pt;">
                                            <div class="iv-left col-6">
                                                <mark>活动：${activityModel.club.clubName!''}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<code class="text-success">${activityModel.activity.activityDate!''}&nbsp;${activityModel.activity.startTime!''}-${activityModel.activity.endTime!''}</code></mark>
                                            </div>
                                            <div class="iv-right col-6 text-md-right">
                                                <p class="text-muted">
                                                    <#if activityModel.activity.limitMember==0>
                                                        <code style="border-right: 1px solid gray;padding-right: 10px;">限报：无限制</code>
                                                    <#else>
                                                        <code style="border-right: 1px solid gray;padding-right: 10px;">限报：${activityModel.activity.limitMember!'无限制'}人</code>
                                                    </#if>
                                                    <code class="text-success" style="padding-left: 10px;">已报：${activityModel.activityMemberList?size}人</code>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row align-items-center">
                                        <div class="col-md-6">
                                            <div class="invoice-address">
                                                <p>活动场馆：${activityModel.activity.activityAddress!''}</p>
                                                <p><code>联系人：${activityModel.user.nick!''}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：${activityModel.user.phone!''}</code></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="invoice-table table-responsive mt-5">
                                        <h6 class="header-title">已报人员</h6>
                                        <#if activityModel.activityMemberList?? && (activityModel.activityMemberList?size > 0) >
                                            <table class="table table-bordered table-hover text-right">
                                                <thead>
                                                <tr class="text-capitalize">
                                                    <th class="text-center" style="width: 5%;">序号</th>
                                                    <th class="text-left" style="width: 45%; min-width: 130px;">昵称</th>
                                                    <th>性别</th>
                                                    <th>人数</th>
                                                    <th style="min-width: 100px">联系电话</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    <#list activityModel.activityMemberList as activityMember>
                                                    <tr>
                                                        <td class="text-center">${activityMember_index+1}</td>
                                                        <td class="text-left">${activityMember.nick!''}</td>
                                                        <td>
                                                            <#assign sexValue = (activityMember.memberSex == 1)?string((activityMember.memberSex == 2)?string('女','男'),(activityMember.memberSex == 0)?string('未知','女')) />
                                                            ${sexValue}
                                                        </td>
                                                        <td>${activityMember.memberNum!''}</td>
                                                        <td>${activityMember.memberPhone!''}</td>
                                                    </tr>
                                                    </#list>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <td colspan="4">已报总人数 :</td>
                                                    <td>${activityModel.activityMemberList?size}</td>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        <#else>
                                            <div class="col-lg-12 mt-5">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="additional-content">
                                                            <div class="alert alert-danger" role="alert">
                                                                <h4 class="alert-heading">暂无人员报名活动!</h4>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </#if>
                                        <h6 class="header-title">活动说明：</h6>
                                        <p class="mb-1 text-secondary">${activityModel.activity.activityMemo?replace('\r\n','<br/>','i')}</p>
                                    </div>
                                </div>
                                <div class="invoice-buttons text-right">
                                    <a href="javascript:void(0);" class="invoice-btn">立即报名</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main content area end -->
        <!-- 报名窗口 -->
        <div class="modal fade" id="activityApplyModal">
            <div class="modal-dialog" style="max-width: 1000px;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">报名活动</h5>
                        <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                    </div>
                    <div class="modal-body">
                        <div class="card">
                            <form id="activityFormApply" method="post" enctype="multipart/form-data" action="/activity/saveActivityMemberApply.do">
                                <label for="activityId" hidden><code>*&nbsp;</code>性别</label>
                                <input hidden id="activityId" name="activityId" value="${activityModel.activity.id!''}">
                                <div class="form-row">
                                    <div class="col-md-4 mb-3">
                                        <label for="nick"><code>*&nbsp;</code>活动昵称</label>
                                        <input class="form-control" id="nick" name="nick" type="text" placeholder="请填写活动常用昵称...">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="startTime"><code>*&nbsp;</code>性别</label>
                                        <div class="form-control" style="border: none;">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="memberSex" id="sex1" value="1" checked>
                                                <label class="form-check-label" for="sex1">男</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="memberSex" id="sex2" value="2">
                                                <label class="form-check-label" for="sex2">女</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-1 mb-3">
                                        <label for="memberNum"><code>*&nbsp;</code>人数</label>
                                        <input class="form-control" type="number" value="1" min="1" <#if (activityModel.activity.limitMember>0)>max="${activityModel.activity.limitMember!''}" </#if> id="memberNum" name="memberNum">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="memberPhone">手机号码</label>
                                        <input class="form-control" id="memberPhone" name="memberPhone" type="text" placeholder="请填写活动常用联系电话...">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">确定</button>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
<script>
    $(".invoice-btn").on("click",function () {
        $("#activityApplyModal").modal("show");
    });
    $(function () {
        $('#activityFormApply').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nick: {
                    message: '活动昵称验证失败',
                    validators: {
                        notEmpty: {
                            message: '活动昵称不能为空'
                        }
                    }
                },
                memberSex: {
                    message: '性别验证失败',
                    validators: {
                        notEmpty: {
                            message: '性别不能为空'
                        }
                    }
                },
                memberNum: {
                    message: '报名人数验证失败',
                    validators: {
                        notEmpty: {
                            message: '报名人数不能为空'
                        },
                        numeric: {
                            message: '报名人数必须为大于0整数'
                        }
                    }
                },
                memberPhone: {
                    message: '手机号码验证失败',
                    validators: {
                        notEmpty: {
                            message: '手机号码不能为空'
                        },
                        stringLength: {
                            min: 11,
                            max: 11,
                            message: '请输入11位手机号码'
                        },
                        regexp: {
                            regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                            message: '请输入正确的手机号码'
                        }
                    }
                }
            }
        });
    });
</script>
</@layout.layout>