<#assign ctx=request.getContextPath()/>
<#import "${ctx}/layout/layout.ftl" as layout>
<@layout.layout 1>
<style>
    .table td, .table th{
        vertical-align: middle;
    }
</style>
    <!-- main content area start -->
    <div class="main-content-inner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-ml-12">
                    <div class="row">
                        <!-- Textual inputs start -->
                        <div class="col-12 mt-5">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="header-title" style="display: flex;justify-content: space-between;">创建俱乐部<a href="/club.do" class="btn btn-secondary btn-xs">取消并返回</a></h4>
                                    <p class="font-14 mb-4 list-group-item list-group-item-warning"><i class="ti-light-bulb"></i>请尽可能详细的完善俱乐部信息，创建后可发布活动、比赛等。</p>
                                    <form class="needs-validation" id="clubFormAdd" method="post" enctype="multipart/form-data" action="/club/saveClubAdd.do">
                                        <div class="form-group">
                                            <div class="form-group">
                                                <label for="clubUserId" class="col-form-label btn btn-xs btn-flat btn-secondary user-select-btn"><code>*&nbsp;</code>选择俱乐部会长</label>
                                                <div id="userPreview">
                                                </div>
                                                <input type="text" hidden id="clubUserId" name="clubUserId" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="clubName" class="col-form-label"><code>*&nbsp;</code>名称</label>
                                            <input class="form-control" id="clubName" name="clubName" type="text" required placeholder="请填写俱乐部全称...">
                                        </div>
                                        <div class="form-group">
                                            <label for="clubLogo" class="col-form-label">logo图</label>
                                            <input type="file" class="form-control-file" id="clubLogo" name="clubLogo">
                                            <div id="imgFilePreview">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="clubAddress" class="col-form-label"><code>*&nbsp;</code>活动球馆</label>
                                            <input class="form-control" id="clubAddress" name="clubAddress" type="text" required placeholder="请填写俱乐部常去活动球馆...">
                                        </div>
                                        <div class="form-group">
                                            <label for="clubQqGroup" class="col-form-label">QQ群</label>
                                            <input class="form-control" id="clubQqGroup" name="clubQqGroup" type="text" placeholder="请填写俱乐部QQ群...">
                                        </div>
                                        <div class="form-group">
                                            <label for="clubMemo" class="col-form-label"><code>*&nbsp;</code>详细说明</label>
                                            <textarea class="form-control" rows="5" id="clubMemo" name="clubMemo" required placeholder="请填写俱乐部详细说明，包括俱乐部介绍、规定、俱乐部活动注意等..."></textarea>
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
    <div class="modal fade" id="userSelectModal">
        <div class="modal-dialog" style="max-width: 800px;">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">选择人员</h5>
                    <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                </div>
                <div class="modal-body">
                    <div class="card">
                        <div class="card-body">
                            <div class="single-table">
                                <div class="table-responsive">
                                    <table id="userSelectTable" class="table text-center table-hover table-bordered">
                                        <thead class="text-uppercase bg-primary">
                                        <tr class="text-white">
                                            <th scope="col">账号</th>
                                            <th scope="col">昵称</th>
                                            <th scope="col">性别</th>
                                            <th scope="col">电话</th>
                                        </tr>
                                        </thead>
                                        <tbody id="userModalTbody">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer" style="justify-content: space-between;">
                    <p class="float-left mark-user-info">
                        <mark class="id" hidden>无</mark>
                        <code>账号：</code><mark class="account">无</mark>
                        <code>昵称：</code><mark class="nick">无</mark>
                        <code>性别：</code><mark class="sex-name">无</mark>
                        <code>电话：</code><mark class="phone">无</mark>
                    </p>
                    <div class="btn-group">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" onclick="confirmUserSelect();">确定</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main content area end -->
    <script>
        //文件选择改变事件
        $("#clubLogo").change(function () {
            var objUrl=getObjectURL(this.files[0]);
            var $preDiv=$("#imgFilePreview");
            $preDiv.empty();
            $preDiv.append('<img style="margin: 10px 0;width: 450px;height: 250px;max-width: 100%;" src="'+objUrl+'"/>');
            $preDiv.append('<div><button style="width: 450px;" type="button" class="btn btn-flat bg-secondary text-white" onclick="deleteSelectedImg()">删&nbsp;&nbsp;&nbsp;&nbsp;除</button></div>');
        });
        //删除已上传的图片
        function deleteSelectedImg(){
            $("#imgFilePreview").empty();
            $("#clubLogo").val(null);
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
        //选择人员点击事件
        $(".user-select-btn").on("click",function () {
            $.ajax({
                url: '/user/userSelect.do',
                type: 'GET',
                dataType: "json",
                success: function (res) {
                    if(res.code===200){
                        $("#userModalTbody").empty();
                        $.each(res.data,function (i,user) {
                            var sexName = user.sex===1?"男":"女";
                            $("#userModalTbody").append(
                                '<tr class="user-tbody-tr" onclick="selectUser(this);">' +
                                    '<td class="id" hidden>'+user.id+'</td>' +
                                    '<td class="account">'+user.account+'</td>' +
                                    '<td class="nick">'+user.nick+'</td>' +
                                    '<td class="sex-name">'+sexName+'</td>' +
                                    '<td class="phone">'+user.phone+'</td>' +
                                '</tr>'
                            );
                        });
                    }
                }
            });
            $("#userSelectModal").modal("show");
        });
        function selectUser(obj){
            var obj_$ = $(obj);
            var id = obj_$.find(".id").text();
            var account = obj_$.find(".account").text();
            var nick = obj_$.find(".nick").text();
            var sexName = obj_$.find(".sex-name").text();
            var phone = obj_$.find(".phone").text();
            var mark_$ = $(".mark-user-info");
            mark_$.find(".id").text(id);
            mark_$.find(".account").text(account);
            mark_$.find(".nick").text(nick);
            mark_$.find(".sex-name").text(sexName);
            mark_$.find(".phone").text(phone);
        }
        function confirmUserSelect(){
            var obj_$ = $(".mark-user-info");
            var id = obj_$.find(".id").text();
            var account = obj_$.find(".account").text();
            var nick = obj_$.find(".nick").text();
            var sexName = obj_$.find(".sex-name").text();
            var phone = obj_$.find(".phone").text();
            $("#userSelectModal").modal("hide");
            $("#clubUserId").val(id);
            var userPreview_$ = $("#userPreview");
            userPreview_$.empty();
            userPreview_$.append(
                '<p class="alert alert-primary form-control" style="margin-top: 10px;">' +
                    '<code class="text-primary">账号：</code>'+account+
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<code class="text-primary">昵称：</code>'+nick+
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<code class="text-primary">性别：</code>'+sexName+
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<code class="text-primary">电话：</code>'+phone+
                '</p>'
            );
        }
    </script>
</@layout.layout>