<#assign ctx=request.getContextPath()/>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href="/assets/images/icon/favicon.ico">
        <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="/assets/css/themify-icons.css">
        <link rel="stylesheet" href="/assets/css/metisMenu.css">
        <link rel="stylesheet" href="/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="/assets/css/slicknav.min.css">
        <!-- amchart css -->
        <link rel="stylesheet" href="/assets/css/export.css" type="text/css" media="all"/>
        <!-- others css -->
        <link rel="stylesheet" href="/assets/css/typography.css">
        <link rel="stylesheet" href="/assets/css/default-css.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
        <link rel="stylesheet" href="/assets/css/responsive.css">
        <!-- modernizr css -->
        <script src="/assets/js/vendor/modernizr-2.8.3.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
            your browser</a> to improve your experience.</p>
        <![endif]-->
        <!-- preloader area start -->
        <div id="preloader">
            <div class="loader"></div>
        </div>
        <!-- preloader area end -->
        <!-- login area start -->
        <div class="login-area login-s2">
            <div class="container">
                <div class="login-box ptb--100">
                    <form id="dataForm">
                        <div class="login-form-head">
                            <h4>登录</h4>
                        </div>
                        <div class="login-form-body">
                            <div class="form-gp">
                                <label for="exampleInputAccount">账号</label>
                                <input type="text" name="account" id="exampleInputAccount">
                                <i class="ti-user"></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword">密码</label>
                                <input type="password" name="pwd" id="exampleInputPassword">
                                <i class="ti-lock"></i>
                            </div>
                            <div class="form-gp">
                                <p class="text-danger" id="errorInfo"></p>
                            </div>
                            <div class="row mb-4 rmber-area">
                                <div class="col-6">
                                    <div class="custom-control custom-checkbox mr-sm-2">
                                        <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                        <label class="custom-control-label" for="customControlAutosizing">记住我</label>
                                    </div>
                                </div>
                                <div class="col-6 text-right">
                                    <a href="javascript:void(0);" data-toggle="popover"
                                       data-content="忘记密码请联系系统管理员进行密码重置，重置后使用新密码进行登录！">忘记密码？</a>
                                </div>
                            </div>
                            <div class="submit-btn-area">
                                <button id="form_submit" type="button">确定 <i class="ti-arrow-right"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- login area end -->
        <!-- jquery latest version -->
        <script src="/assets/js/vendor/jquery-2.2.4.min.js"></script>
        <!-- bootstrap 4 js -->
        <script src="/assets/js/popper.min.js"></script>
        <script src="/assets/js/bootstrap.min.js"></script>
        <script src="/assets/js/owl.carousel.min.js"></script>
        <script src="/assets/js/metisMenu.min.js"></script>
        <script src="/assets/js/jquery.slimscroll.min.js"></script>
        <script src="/assets/js/jquery.slicknav.min.js"></script>
        <!-- others plugins -->
        <script src="/assets/js/plugins.js"></script>
        <script src="/assets/js/scripts.js"></script>
        <script src="/assets/js/jquery.form.js"></script>
        <script src="/assets/js/jquery.cookie.js"></script>
        <script>
            $(function () {
                var setcookie = function () {
                    //创建cookie 记住我; 值为true ;有效期为60天
                    $.cookie('young666_badminton_rememberme', "true", {expires: 60});
                    $.cookie('young666_badminton_usrname', encodeURIComponent($("#exampleInputAccount").val()), {expires: 60});
                    $.cookie('young666_badminton_pwd', encodeURIComponent($("#exampleInputPassword").val()), {expires: 60});
                };
                var clrcookie = function () {
                    $.cookie('young666_badminton_rememberme', "false");
                    $.cookie('young666_badminton_usrname', null);
                    $.cookie('young666_badminton_pwd', null);
                };
                //当勾上“记住我”时保存cookie，否则清空
                $("#customControlAutosizing").on("click", function () {
                    if (!$(this).hasClass("remember")) {
                        setcookie();
                        $(this).addClass("remember");
                    } else {
                        clrcookie();
                        $(this).removeClass("remember");
                    }
                });
                //当更改用户名或密码后更新cookie
                $("#exampleInputAccount,#exampleInputPassword").on("blur", function () {
                    if ($("#customControlAutosizing").hasClass("remember")) {
                        setcookie();
                    }
                }).on("keyup", function () {
                    if ($("#exampleInputAccount").val()) {
                        setcookie();
                        $(this).addClass("remember");
                    } else {
                        clrcookie();
                        $(this).removeClass("remember");
                    }
                });
                $(document).keydown(function (e) {
                    if (e.keyCode === 13) {
                        $("#form_submit").click();
                        return false;
                    }
                });
                //窗体加载时候  读取cookie中rememberme的值是否等于true
                if ($.cookie('young666_badminton_rememberme') === "true") {
                    $("#exampleInputAccount").val(decodeURIComponent($.cookie('young666_badminton_usrname'))).focus();
                    $("#exampleInputPassword").val(decodeURIComponent($.cookie('young666_badminton_pwd'))).focus();
                    $("#customControlAutosizing").addClass("remember");
                    $("#customControlAutosizing").attr("checked",'true');
                } else {
                    $("#exampleInputAccount").focus();
                    $("#customControlAutosizing").attr("checked",'false');
                }
                $("#form_submit").click(function () {
                    var account = $("#exampleInputAccount").val();
                    var pwd = $("#exampleInputPassword").val();
                    var $errorinfo = $("#errorInfo");
                    $errorinfo.empty();
                    if (account && pwd) {
                        $('#dataForm').ajaxSubmit({
                            url: '${ctx}/index.do',
                            type: 'POST',
                            dataType: 'json',
                            cache: false,
                            success: function (res) {
                                if (res.code === 200) {
                                    $(window.location).prop('href', "${ctx}/home.do");
                                } else {
                                    $errorinfo.text(res.message);
                                }
                            }
                        });
                    } else {
                        $errorinfo.text("账号密码不能为空！");
                    }
                });
            })
        </script>
    </body>
</html>