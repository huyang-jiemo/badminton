<#macro layout menu_index>
    <!doctype html>
    <html>
        <head>
            <meta charset="utf-8">
            <meta http-equiv="x-ua-compatible" content="ie=edge">
            <title>相约羽球管理系统</title>
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
            <!-- bootstrapValidator -->
            <link href="/assets/css/bootstrapValidator.min.css" rel="stylesheet" />
            <!-- jquery latest version -->
            <script src="/assets/js/vendor/jquery-2.2.4.min.js"></script>
            <script src="/assets/js/jquery.form.js"></script>
            <script src="/assets/js/bootstrapValidator.min.js"></script>
        </head>
        <body class="body-bg">
            <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
            <!-- preloader area start -->
            <div id="preloader">
                <div class="loader"></div>
            </div>
            <!-- preloader area end -->
            <!-- main wrapper start -->
            <div class="horizontal-main-wrapper">
                <!-- 顶部引用 -->
                <#import "${ctx}/layout/header.ftl" as header>
                <@header.header>
                </@header.header>
                <!-- 菜单栏引用 -->
                <#import "${ctx}/layout/sidebar.ftl" as sidebar>
                <@sidebar.sidebar menu_index>
                </@sidebar.sidebar>
                <!-- 展示区域 -->
                <#nested>
                <!-- 底部引用 -->
                <#import "${ctx}/layout/footer.ftl" as footer>
                <@footer.footer>
                </@footer.footer>
            </div>
            <!-- main wrapper start -->
            <!-- bootstrap 4 js -->
            <script src="/assets/js/popper.min.js"></script>
            <script src="/assets/js/bootstrap.min.js"></script>
            <script src="/assets/js/owl.carousel.min.js"></script>
            <script src="/assets/js/metisMenu.min.js"></script>
            <script src="/assets/js/jquery.slimscroll.min.js"></script>
            <script src="/assets/js/jquery.slicknav.min.js"></script>
            <!-- start chart js -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
            <!-- start highcharts js -->
            <script src="https://code.highcharts.com/highcharts.js"></script>
            <script src="https://code.highcharts.com/modules/exporting.js"></script>
            <script src="https://code.highcharts.com/modules/export-data.js"></script>
            <!-- start amcharts -->
            <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
            <script src="https://www.amcharts.com/lib/3/ammap.js"></script>
            <script src="https://www.amcharts.com/lib/3/maps/js/worldLow.js"></script>
            <script src="https://www.amcharts.com/lib/3/serial.js"></script>
            <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
            <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
            <!-- all line chart activation -->
            <script src="/assets/js/line-chart.js"></script>
            <!-- all pie chart -->
            <script src="/assets/js/pie-chart.js"></script>
            <!-- all bar chart -->
            <script src="/assets/js/bar-chart.js"></script>
            <!-- all map chart -->
            <script src="/assets/js/maps.js"></script>
            <!-- others plugins -->
            <script src="/assets/js/plugins.js"></script>
            <script src="/assets/js/scripts.js"></script>
        </body>
    </html>
</#macro>