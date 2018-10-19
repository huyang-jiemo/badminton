<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 0>
    <style>
        .table td, .table th{
            vertical-align: middle;
        }
    </style>
    <!-- main content area start -->
        <div class="main-content-inner">
            <div class="container">
                <div id="userListDivRow" class="row">
                    <div class="col-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title" style="display: flex;justify-content: space-between;">人员管理<button class="btn btn-xs btn-primary user-add-btn">添加</button></h4>
                                <div class="single-table">
                                    <div class="table-responsive">
                                        <table class="table table-hover progress-table text-center">
                                            <thead class="text-uppercase">
                                                <tr>
                                                    <th scope="col">序号</th>
                                                    <th scope="col">头像</th>
                                                    <th scope="col">账号</th>
                                                    <th scope="col">昵称</th>
                                                    <th scope="col">性别</th>
                                                    <th scope="col">电话</th>
                                                    <th scope="col">操作</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <#list userList as user>
                                                <tr>
                                                    <th scope="row" width="100px;">${user_index+1}</th>
                                                    <td>
                                                        <#if user.avatar??>
                                                            <img style="width: 30px;height: 30px;border-radius: 50%" class="img-thumbnail" src="${user.avatar!''}" alt="image">
                                                        <#else>
                                                            <img style="width: 30px;height: 30px;border-radius: 50%" class="img-thumbnail" src="${ctx}/assets/images/author/avatarHead.jpg" alt="image">
                                                        </#if>
                                                    </td>
                                                    <td>${user.account!''}</td>
                                                    <td>${user.nick!''}</td>
                                                    <td>
                                                        <#assign sexValue = (user.sex == 1)?string((user.sex == 2)?string('女','男'),(user.sex == 0)?string('未知','女')) />
                                                        ${sexValue}
                                                    </td>
                                                    <td><span class="status-p bg-success">${user.phone!''}</span></td>
                                                    <td>
                                                        <ul class="d-flex justify-content-center">
                                                            <li class="mr-3"><a href="/user/edit.do?id=${user.id!''}" class="text-secondary"><i class="fa fa-edit"></i>&nbsp;编辑</a></li>
                                                            <li><a href="/user/delete.do?id=${user.id!''}" class="text-danger"><i class="ti-trash"></i>&nbsp;删除</a></li>
                                                        </ul>
                                                    </td>
                                                </tr>
                                                </#list>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="userAddDivRow" class="row" style="display: none;">
                    <div class="col-lg-12 col-ml-12">
                        <div class="row">
                            <!-- Textual inputs start -->
                            <div class="col-12 mt-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="header-title" style="display: flex;justify-content: space-between;">添加人员<a href="/user/index.do" class="btn btn-secondary btn-xs mt-3 user-add-return-btn">取消并返回</a></h4>
                                        <p class="font-14 mb-4 list-group-item list-group-item-warning"><i class="ti-light-bulb"></i>人员信息请以俱乐部活动实际信息为准，联系方式如实填写，方便联系；信息一旦提交无法修改，请提交前详细核实。</p>
                                        <form id="userFormAdd" method="post" enctype="multipart/form-data" action="${ctx}/user/saveUserAdd.do">
                                            <div class="form-group">
                                                <label for="account" class="col-form-label"><code>*&nbsp;</code>账号</label>
                                                <input class="form-control" id="account" name="account" type="text">
                                            </div>
                                            <div class="form-group">
                                                <label for="pwd" class="col-form-label"><code>*&nbsp;</code>密码</label>
                                                <input class="form-control" id="pwd" name="pwd" type="password">
                                            </div>
                                            <div class="form-group">
                                                <label for="rePwd" class="col-form-label"><code>*&nbsp;</code>确认密码</label>
                                                <input class="form-control" id="rePwd" name="rePwd" type="password">
                                            </div>
                                            <div class="form-group">
                                                <label for="nick" class="col-form-label"><code>*&nbsp;</code>昵称 <mark>以常用活动昵称为主</mark></label>
                                                <input class="form-control" id="nick" name="nick" type="text">
                                            </div>
                                            <div class="form-group">
                                                <label for="account" class="col-form-label"><code>*&nbsp;</code>性别</label>
                                                <div class="form-control" style="border: none;">
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="sex" id="sex1" value="1" checked>
                                                        <label class="form-check-label" for="sex1">男</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="sex" id="sex2" value="2">
                                                        <label class="form-check-label" for="sex2">女</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="avatar" class="col-form-label">头像</label>
                                                <input type="file" class="form-control-file" id="avatar" name="avatar">
                                                <div id="imgFilePreview">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="phone" class="col-form-label"><code>*&nbsp;</code>联系电话 <mark>请填写合法手机号</mark></label>
                                                <input class="form-control" id="phone" name="phone" type="text">
                                            </div>
                                            <button type="submit" class="btn btn-primary mt-4 pr-4 pl-4">提交</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main content area end -->
<script>
    $(".user-add-btn").on("click", function () {
        $("#userListDivRow").hide();
        $("#userAddDivRow").show();
    });
    //文件选择改变事件
    $("#avatar").change(function () {
        var objUrl=getObjectURL(this.files[0]);
        var $preDiv=$("#imgFilePreview");
        $preDiv.empty();
        $preDiv.append('<img style="margin: 10px 0;width: 100px;height: 100px;max-width: 100%;" src="'+objUrl+'"/>');
        $preDiv.append('<div><button style="width: 100px;" type="button" class="btn btn-flat bg-secondary text-white" onclick="deleteSelectedImg()">删&nbsp;&nbsp;&nbsp;&nbsp;除</button></div>');
    });
    //删除已上传的图片
    function deleteSelectedImg(){
        $("#imgFilePreview").empty();
        $("#avatar").val(null);
    }
    //获取临时上传文件路径
    function getObjectURL(file){
        var url=null;
        if(window.createObjectURL!==undefined){
            url=window.createObjectURL(file);
        }else if(window.URL!==undefined){
            url=window.URL.createObjectURL(file);
        }else if (window.webkitURL !== undefined) {
            url=window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    $(function () {
        $('#userFormAdd').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                account: {
                    message: '账号验证失败',
                    validators: {
                        notEmpty: {
                            message: '账号不能为空'
                        },
                        stringLength: {
                            min: 3,
                            max: 20,
                            message: '账号长度必须在5到20位之间'
                        }
                    }
                },
                pwd: {
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 12,
                            message: '密码长度必须在6到12位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        },
                        identical: {//相同
                            field: 'rePwd', //需要进行比较的input name值
                            message: '两次密码不一致'
                        },
                        different: {//不能和用户名相同
                            field: 'account',//需要进行比较的input name值
                            message: '不能和账号相同'
                        }
                    }
                },
                rePwd: {
                    message: '密码验证失败',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 12,
                            message: '密码长度必须在6到12位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '密码只能包含大写、小写、数字和下划线'
                        },
                        identical: {//相同
                            field: 'pwd', //需要进行比较的input name值
                            message: '两次密码不一致'
                        },
                        different: {//不能和用户名相同
                            field: 'account',//需要进行比较的input name值
                            message: '不能和账号相同'
                        }
                    }
                },
                nick: {
                    message: '昵称验证失败',
                    validators: {
                        notEmpty: {
                            message: '昵称不能为空'
                        }
                    }
                },
                phone: {
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