<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>餐饮系统</title>
    <!-- Favicon -->
    <%--echart--%>
    <script src="assets/js/echarts.min.js"></script>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,600,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link rel="stylesheet" href="assets/lib/bootstrap/dist/css/bootstrap.min.css">

    <!-- Animate.css -->
    <link rel="stylesheet" href="assets/lib/animate.css/animate.min.css">

    <!-- LineAwesome Font -->
    <link rel="stylesheet" href="assets/lib/line-awesome/dist/css/line-awesome.min.css">

    <!-- Simplebar -->
    <link rel="stylesheet" href="assets/lib/simplebar/dist/simplebar.css">

    <!-- Owl Carousel -->
    <link rel="stylesheet" href="assets/lib/owl.carousel/dist/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/lib/owl.carousel/dist/assets/owl.theme.default.min.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="assets/lib/magnific-popup/dist/magnific-popup.css">

    <!-- Custom Css -->
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- You can choose a theme from assets/css/themes instead of get all themes -->
    <link rel="stylesheet" href="assets/css/themes/all.css"/>

    <!-- You can choose a color from assets/css/colors instead of get all colors -->
    <link rel="stylesheet" href="assets/css/colors/all.css"/>

    <!-- For demo purpose only. Please remove when you publish your product -->
    <link href="assets/css/demo.css" rel="stylesheet"/>
</head>

<%
    String moneyNotEnough = (String) session.getAttribute("moneyNotEnough");
    String dishNotEnough = (String) session.getAttribute("dishNotEnough");
    session.removeAttribute("moneyNotEnough");
    session.removeAttribute("dishNotEnough");
    //System.out.println(moneyNotEnough);

    if (moneyNotEnough != null) {
        response.setCharacterEncoding("utf-8");
        PrintWriter outPrint = response.getWriter();
        outPrint.print("<script>alert('" + moneyNotEnough + "'); window.location='index.jsp#about' </script>");
        outPrint.flush();
        outPrint.close();
    }
    if (dishNotEnough != null) {
        response.setCharacterEncoding("utf-8");
        PrintWriter outPrint = response.getWriter();
        outPrint.print("<script>alert('" + dishNotEnough + "'); window.location='index.jsp#about' </script>");
        outPrint.flush();
        outPrint.close();
    }

%>
<body class="theme-light color-blue">

<!-- Loading Screen -->
<div class="loading-container">
    <div class="bounce-container">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
    </div>
</div>
<!-- ### Loading Screen -->
<!-- Header -->
<header>
    <!-- Logo Area -->
    <div class="logo-area">
        <a href="#home">
            <div class="avatar">
                <img src="assets/images/avatars/face${session.customer.account}.jpg" alt="User Avatar">
            </div>
            <span class="maximize">${session.customer.nickname}</span>
        </a>
    </div>
    <!-- ### Logo Area -->
    <!-- Left Side Menu Links -->
    <div class="links-area">
        <ul>
            <li>
                <a href="#home">
                    <i class="la la-home"></i>
                    <span>Home</span>
                </a>
            </li>
            <li>
                <a href="#about">
                    <i class="la la-user"></i>
                    <span>About Me</span>
                </a>
            </li>

            <li>
                <a href="#portfolio">
                    <i class="la la-briefcase"></i>
                    <span>Menu</span>
                </a>
            </li>
            <li>
                <a href="#blog">
                    <i class="la la-newspaper-o"></i>
                    <span>ShoppingCart</span>
                </a>
            </li>
            <li>
                <a href="#resume">
                    <i class="la la-file-text"></i>
                    <span>ordered</span>
                </a>
            </li>
            <%--            <li>--%>
            <%--                <a href="#contacts">--%>
            <%--                    <i class="la la-envelope"></i>--%>
            <%--                    <span>order</span>--%>
            <%--                </a>--%>
            <%--            </li>--%>
        </ul>
    </div>
    <!-- ### Left Side Menu Links -->
    <div class="expand-area">
        <div class="expand-collapse">
            <i class="la"></i> <span>Expand</span>
        </div>
    </div>
    <span class="btn-menu-toggle">
            <span class="line"></span>
        </span>
</header>
<!-- ### Header -->

<div class="pages">
    <!-- Home Page -->
    <div class="section" id="home">
        <div class="center">
            <div class="vertical-middle">
                <div class="title">学校餐厅用户系统</div>
                <div class="subtitle">
                    <span class="typed"></span>
                </div>
            </div>
        </div>
    </div>
    <!-- ### Home Page -->

    <div class="sub-pages">
        <!-- About Page -->
        <div class="section" id="about" data-simplebar="init">
            <div class="main-container">
                <div class="main-title">ABOUT ME</div>
                <div class="main-desc">
                    <b>宁静而美好的一天，从查看我的饮食情况开始</b>
                </div>
                <!-- 我的个人信息 Area -->
                <div class="content-group">
                    <div class="title">我的个人信息</div>
                    <div class="info-container">
                        <label>&nbsp;身高:</label>
                        <s:property value="#session.customer.height"/>
                        <label>&nbsp;&nbsp;体重:</label>
                        <s:property value="#session.customer.weight"/>
                        <label>&nbsp;&nbsp;性别:</label>
                        <s:property value="#session.customer.gender==true?'男':'女'"/>
                        <label>&nbsp;&nbsp;&nbsp;推荐每日摄入卡路里：</label>
                        <s:property value="#session.customer.calorieRecommend()"/>
                        <button type="button" class="btn btn-primary"
                                data-toggle="modal" data-target="#alterInfoModal">
                            修改
                        </button>

                        <button type="button" class="btn btn-primary"
                                data-toggle="modal" data-target="#topupMoneyModal">
                            充值
                        </button>
                        <a href="findTopupById.action" class="btn btn-primary">查询充值记录</a>
                        <s:actionerror/>
                    </div>
                </div>

                <!-- ### 我的个人信息 Area -->
                <!-- 营养摄入情况 Area -->
                <div class="content-group">
                    <div class="title">营养摄入情况</div>
                    <div class="pricing-container">
                        <div class="row clearfix">
                            <div class="col-12 col-sm-12 col-md-6">
                                <div style="width: 600px;height:400px;" id="calorie"></div>
                            </div>
                            <script type="text/javascript">
                                var myChart = echarts.init(document.getElementById('calorie'));
                                var option = {
                                    color: ['#c23531', '#3398DB'],
                                    title: {
                                        text: '一周卡路里摄入'
                                    },
                                    tooltip: {},
                                    legend: {
                                        data: ['卡路里', '推荐卡路里摄入']
                                    },
                                    xAxis: {
                                        type: 'category',
                                        boundaryGap: false,
                                        data: ${session.customer.lastWeekDate()}
                                    },
                                    yAxis: {
                                        type: 'value'
                                    },
                                    series: [
                                        {
                                            name: '卡路里',
                                            type: 'line',
                                            data:${session.customer.lastWeekCalorie()},
                                            areaStyle: {}
                                        },
                                        {
                                            name: '推荐卡路里摄入',
                                            type: 'line',
                                            data: [${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()},
                                                ${session.customer.calorieRecommend()}],
                                            areaStyle: {}
                                        },
                                    ]
                                };
                                myChart.setOption(option);
                            </script>
                            <div class="col-12 col-sm-12 col-md-6">
                                <div style="width: 600px;height:400px;" id="all"></div>
                            </div>
                            <script type="text/javascript">
                                var myChart = echarts.init(document.getElementById('all'));
                                var option = {
                                    color: ['#c23531', '#3398DB'],
                                    title: {
                                        text: '今日摄入表'
                                    },
                                    tooltip: {},
                                    legend: {
                                        data: ['标准推荐', '实际摄入']
                                    },
                                    radar: {
                                        // shape: 'circle',
                                        name: {
                                            textStyle: {
                                                color: '#fff',
                                                backgroundColor: '#999',
                                                borderRadius: 3,
                                                padding: [3, 5]
                                            }
                                        },
                                        indicator: [
                                            {name: '糖分', max: 300},
                                            {name: '蛋白质', max: 72},
                                            {name: '脂肪', max: 75},
                                            {name: '盐', max: 8},
                                            {name: '膳食纤维', max: 33},
                                        ]
                                    },
                                    series: [{
                                        name: '标准 vs 实际',
                                        type: 'radar',
                                        areaStyle: {normal: {}},
                                        data: [
                                            {
                                                value: [${session.customer.sugerRecommend()},
                                                    ${session.customer.proteinRecommend()},
                                                    ${session.customer.fatRecommend()},
                                                    ${session.customer.naRecommend()},
                                                    ${session.customer.DFRecommend()}],
                                                name: '标准推荐'
                                            },
                                            {
                                                value: [${session.customer.todaySuger()},
                                                    ${session.customer.todayProtein()},
                                                    ${session.customer.todayFat()},
                                                    ${session.customer.todayNa()},
                                                    ${session.customer.todayDF()}],
                                                name: '实际摄入'
                                            }
                                        ]
                                    }]
                                };
                                myChart.setOption(option);
                            </script>
                        </div>
                    </div>
                </div>
                <!-- ### 营养摄入情况 Area -->
                <!-- 近日食品摄入量修改 Area -->
                <div class="content-group">
                    <div class="title">近日食品摄入量修改</div>
                    <div class="testimonials-container owl-carousel">
                        <s:iterator value="#session.customer.lastWeekDate()" var="date">
                            <div class="card">
                                <div class="card-header">
                                    <label>${date}</label>
                                </div>
                                <div class="card-body">
                                    <s:form action="alterNutritionIntakeDetail" method="POST" namespace="/">
                                        <input value="${date}" style="display:none;" name="time">
                                        <input value="${session.customer.account}" style="display:none;" name="account">
                                        <table class="table table-striped table-bordered table-hover">
                                            <tr>
                                                <td>菜名</td>
                                                <td>单件卡路里</td>
                                                <td>数量</td>
                                                <td>摄入量</td>
                                            </tr>
                                            <s:iterator value="#session.customer.take(#date)" var="ndt">
                                                <tr>
                                                    <input value="${ndt.key}" name="key" style="display:none;"/>
                                                    <td>${value.dish.name}</td>
                                                    <td>${value.dish.calorie}</td>
                                                    <td>${value.num}</td>
                                                    <td><input value="${ndt.value.intakeRate}" name="intakeRate"></td>
                                                </tr>
                                            </s:iterator>
                                        </table>
                                        <s:submit value="修改"/>
                                    </s:form>
                                </div>
                                <div class="card-footer">
                                </div>
                            </div>
                        </s:iterator>
                    </div>
                </div>
                <!-- ### 近日食品摄入量修改 Area -->
                <!--  今日饮食自定义 Area -->
                <div class="content-group">
                    <div class="title">我今日的个人食品摄入</div>
                    <button type="button" class="btn btn-primary"
                            data-toggle="modal" data-target="#addUserDefine">
                        增加个人饮食情况
                    </button>
                    <table class="table table-striped table-bordered table-hover "
                           style="table-layout:fixed;">
                        <tr>
                            <td>食品名称</td>
                            <td>卡路里</td>
                            <td>脂肪</td>
                            <td>膳食纤维</td>
                            <td>蛋白质</td>
                            <td>盐分</td>
                            <td>碳水化合物</td>
                            <td>选项</td>
                            <td>选项</td>

                        </tr>
                        <s:iterator value="#session.customer.takeUserDefined()" var="st">
                            <s:form method="POST" namespace="/">
                                <tr>
                                    <input name="id" value="${value.id}" style="display: none">
                                    <input name="time" value="${value.time}" style="display: none"/>
                                    <td><input name="name" value="${value.name}" style="width: 100%" required></td>
                                    <td><input name="calorie" value="${value.calorie}" style="width: 100%"></td>
                                    <td><input name="fat" value="${value.fat}" style="width: 100%" required></td>
                                    <td><input name="df" value="${value.df}" style="width: 100%" required></td>
                                    <td><input name="protein" value="${value.protein}" style="width: 100%" required>
                                    </td>
                                    <td><input name="na" value="${value.na}" style="width: 100%" required></td>
                                    <td><input name="sugar" value="${value.sugar}" style="width: 100%" required></td>
                                    <td>
                                            <%--                                        <s:submit action="updUserDefine" class="btn btn-success" value="更新" />--%>
                                        <button class="btn btn-success" formaction="updUserDefine">更新</button>

                                    </td>
                                    <td>
                                            <%--                                        <s:submit action="delUserDefine" class="btn btn-success" value="删除"/>--%>
                                        <button class="btn btn-danger" formaction="delUserDefine">删除</button>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </table>
                </div>
                <!-- ### 今日饮食自定义 Area -->
            </div>
        </div>
        <!-- ### About Page -->
        <!-- Portfolio Page -->
        <!-- ### Portfolio Filter Area -->
        <div class="section" id="portfolio" data-simplebar="init">
            <div class="main-container">
                <div class="main-title">MENU</div>
                <div class="main-desc"><b>菜单</b></div>


                <br><br>
                <s:form action="Dishsort1" namespace="/" method="post">

                    <s:submit value="按好评率排序" />



                </s:form>
                <s:form action="Dishsort2" namespace="/" method="post">

                    <s:submit value="按销售量排序" />



                </s:form>


                <s:form action="orderdishes" namespace="/" method="POST">
                <!-- Portfolio Filter Area -->
                <div class="filter filter-button-group">
                    <div class="f_btn active">
                        <label><input type="radio" name="fl_radio" value="col">所有菜</label>
                    </div>
                    <div class="f_btn">
                        <label><input type="radio" name="fl_radio" value="荤菜">荤菜</label>
                    </div>
                    <div class="f_btn">
                        <label><input type="radio" name="fl_radio" value="海鲜">海鲜</label>
                    </div>
                    <div class="f_btn">
                        <label><input type="radio" name="fl_radio" value="素菜">素菜</label>
                    </div>
                    <div class="f_btn">
                        <label><input type="radio" name="fl_radio" value="主食">主食</label>
                    </div>
                    <div class="f_btn">
                        <label><input type="radio" name="fl_radio" value="汤">汤</label>
                    </div>
                </div>

                <div class="row clearfix grid-items">
                    <!-- Portfolio Item 1 -->
                    <s:iterator value="#session.alldishes" var="st">
                        <div class="col col-12 col-sm-6 col-md-4 ${st.type}">
                            <div class="card">
                                <div class="card-title" style="color: #ef1414;">
                                    <strong>
                                        <div class="title text-center">${st.name}</div>
                                    </strong>
                                </div>
                                <div class="card-body">
                                    <div class="image-area">
                                            <%--                                        href="#portfolio_popup_1"--%>
                                        <a class="popup-type-content">
                                            <img src="../image/dish/${st.image}" alt="Portfolio Image">
                                            <span class="info-area"><i class="la la-image"></i></span>
                                        </a>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="#${st.id}" class="popup-type-content">
                                        <div class="name">${st.name}&nbsp;总销售数${st.salesNum}份,${st.dishInMenu.prize}元/份</div>
                                    </a>
                                    <div class="category" style="color: #721c24">剩余${st.dishInMenu.num}数量</br><label
                                            for="chooseDishes"><input type="checkbox"
                                                                      value="${st.id}"
                                                                      name="chooseDishes"
                                                                      id="chooseDishes">是否加入购物车</label>
                                    </div>
                                    <a href="#${st.id}2" class="popup-type-content">
                                        <div class="name">显示评论</div>
                                    </a>
                                </div>
                            </div>
                            <div class="modal fade bs-example-modal-sm"
                                 id="${st.id}ShowCommentModal" role="dialog"
                                 aria-label="ShowCommentModal" aria-hidden="true"
                                 style="z-index: 10000">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">评论列表</h4>
                                        </div>
                                        <div class="modal-body">
                                            <s:iterator value="#st.comments" var="stt">
                                            <tr>
                                                <td>用户<s:property value="#stt.customer"/>:
                                                </td>
                                                <td><s:property value="#stt.detail"/> <br></td>
                                            <tr>
                                                </s:iterator>

<%--                                                <s:form action="ShowComment" method="POST" namespace="/">--%>


<%--                                                    <s:submit value="提交" class="btn btn-defualt"/>--%>
<%--                                                </s:form>--%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="${st.id}2" class="popup-box mfp-fade mfp-hide"
                                 data-simplebar="init">
                                <div class="image-area"></div>
                                <div class="content-area">

                                    <td>好评率 <fmt:formatNumber pattern="0.00" value="${st.goodRate*100/st.salesNum}"></fmt:formatNumber>%<td><br>

                                    <s:iterator value="#st.comments" var="stt">
                                    <tr>
                                        <s:if test="#stt.type==0">
                                        <td>好评><td>
                                        </s:if>

                                        <s:if test="#stt.type==1">
                                        <td>中评><td>
                                        </s:if>
                                        <s:if test="#stt.type==2">
                                        <td>差评><td>
                                        </s:if>
                                        <td>用户<s:property value="#stt.customer"/>:
                                        </td>
                                        <td><s:property value="#stt.detail"/> <br></td>

                                    <tr>
                                        </s:iterator>

                                        <div class="content">

                                        </div>
                                </div>
                            </div>

                            <div id="${st.id}" class="popup-box mfp-fade mfp-hide" data-simplebar="init">
                                <div class="image-area">
                                    <img src="../image/dish/${st.image}" alt="Portfolio Image">
                                </div>
                                <div class="content-area">
                                    <div class="title">${st.name}</div>
                                    <div class="category">${st.calorie}卡路里</div>
                                    <div class="content">
                                        <div class="col-12 col-sm-12 col-md-6">
                                            <div style="width: 600px;height:400px;" id="${st.id}s"></div>
                                        </div>
                                        <script type="text/javascript">
                                            var myChart = echarts.init(document.getElementById('${st.id}s'));
                                            var option = {
                                                title: {
                                                    text: '营养属性',
                                                    left: 'center'
                                                },
                                                tooltip: {
                                                    trigger: 'item',
                                                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                                                },
                                                legend: {
                                                    orient: 'vertical',
                                                    left: 'left',
                                                    data: ['脂肪', '碳水化合物', '膳食纤维', '蛋白质', '盐分']
                                                },
                                                series: [
                                                    {
                                                        name: '营养属性',
                                                        type: 'pie',
                                                        radius: '55%',
                                                        center: ['50%', '60%'],
                                                        data: [
                                                            {value: ${st.fat}, name: '脂肪'},
                                                            {value: ${st.sugar}, name: '碳水化合物'},
                                                            {value: ${st.df}, name: '膳食纤维'},
                                                            {value: ${st.protein}, name: '蛋白质'},
                                                            {value: ${st.na}, name: '盐分'}
                                                        ],
                                                        emphasis: {
                                                            itemStyle: {
                                                                shadowBlur: 10,
                                                                shadowOffsetX: 0,
                                                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                                            }
                                                        }
                                                    }
                                                ]
                                            };
                                            myChart.setOption(option);
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </s:iterator>
                </div>
                <div class="pull-right">
                    <button type="submit" class="btn btn-primary" onclick="return confirm('您确定加入购物车吗？');">加入购物车
                    </button>
                </div>
            </div>

            </s:form>
        </div>
        <!-- ### Portfolio Page -->
        <!-- Blog Page -->
        <div class="section" id="blog" data-simplebar="init">
            <div class="main-container">
                <div class="main-title">ShoppingCart</div>
                <div class="main-desc">您的<b>购物车</b></div>
                <s:form method="post" action="placeanorder" namespace="/" theme="simple">
                    <div class="row clearfix">
                        <!-- Blog Item 1 -->
                        <s:iterator value="#session.customer.shoppingCart" var="scit">
                            <div class="col col-12 col-sm-6 col-md-6 col-lg-4">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="image-area">
                                            <a href="#blog_popup_1" class="popup-type-content">
                                                <img src="../image/dish/${value.dish.image}" alt="Blog Image">
                                                <span class="info-area"><i class="la la-newspaper-o"></i></span>
                                                <div class="date">
                                                    <mark><label>总销量<br/>${value.dish.salesNum}份</label></mark>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <a href="#${value.dish.id}" class="popup-type-content">
                                            <div class="name"><s:property value="value.dish.name"/>${value.num}份
                                                ,${value.dish.dishInMenu.prize}元/份
                                            </div>
                                        </a>

                                            <%--                                        <input style="display: none" value="${value.cartId}" name="orderDishes"/>--%>
                                            <%--                                    <s:hidden value="#value.cartId" name="orderDishes"/>--%>
                                        <div class="category">
                                            <label for="orderDishes">
                                                <input type="checkbox"
                                                       value="${value.cartId}"
                                                       name="orderDishes"
                                                       checked="checked"
                                                       id="orderDishes">是否下单
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div id="blog_popup_1" class="popup-box mfp-fade mfp-hide" data-simplebar="init">
                                    <div class="image-area">
                                        <img src="../image/dish/${value.dish.image}" alt="Blog Image">
                                    </div>
                                    <div class="content-area">
                                    </div>
                                </div>
                            </div>
                        </s:iterator>


                    </div>
                    <div class="pull-right">
                        <button type="submit" class="btn btn-primary" onclick="return confirm('您确定下单吗？');">下单
                        </button>
                    </div>
                </s:form>
            </div>
        </div>
        <!-- ### Blog Page -->
        <!-- Contact Page -->
        <div class="section" id="contacts" data-simplebar="init">
            <div class="main-container">
                <div class="main-title">CONTACTS</div>
                <div class="main-desc">Amet erat diam eirmod sit eirmod sed clita. Lorem at ipsum no nonumy sanctus
                    dolor. Sed lorem justo sed voluptua, elitr eos tempor labore consetetur gubergren invidunt.
                    Gubergren clita est.
                </div>

                <div class="row clearfix">
                    <div class="col-12 col-sm-12 col-md-6">
                        <!-- Contact Info Area -->
                        <div class="content-group">
                            <div class="title">Get In Touch</div>
                            <div class="get-in-touch-container">
                                <ul>
                                    <li>
                                        <i class="la la-map-marker"></i>
                                        <span>Los Angeles, USA</span>
                                    </li>
                                    <li>
                                        <i class="la la-envelope"></i>
                                        <span><a href="mailto:example@example.com">example@example.com</a></span>
                                    </li>
                                    <li>
                                        <i class="la la-phone"></i>
                                        <span><a href="">+1234567890</a></span>
                                    </li>
                                    <li>
                                        <i class="la la-check-circle"></i>
                                        <span>Freelance <b>Available</b></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- ### Contact Info Area -->
                        <!-- Contact Form -->
                        <div class="content-group">
                            <div class="title">Contact Form</div>
                            <div class="contact-form-container">
                                <form action="/">
                                    <div class="form-group">
                                        <input type="text" name="NameSurname" class="form-control"
                                               placeholder="Name Surname" required>
                                        <i class="la la-user"></i>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" name="Email" class="form-control"
                                               placeholder="Email Address" required>
                                        <i class="la la-envelope"></i>
                                    </div>
                                    <div class="form-group">
                                        <textarea name="Message" cols="30" rows="5" class="form-control no-resize"
                                                  placeholder="Your Message to Me" required></textarea>
                                        <i class="la la-comment"></i>
                                    </div>
                                    <div class="button-area">
                                        <button class="btn-submit" type="submit">Send Message <i
                                                class="la la-long-arrow-right"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- ### Contact Form -->
                    </div>
                    <div class="col-12 col-sm-12 col-md-6">
                        <!-- On Map -->
                        <div class="map">
                            <iframe src="http://www.google.cn/maps/embed?pb=!1m18!1m12!1m3!1d44464.24436745633!2d-118.3849043157581!3d34.073901857935006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2b93cca9c7ab1%3A0x9b191d3aac3e37!2sLos+Angeles+Sanat+M%C3%BCzesi!5e0!3m2!1str!2str!4v1535049256056"
                                    height="612" allowfullscreen></iframe>
                        </div>
                        <!-- ### On Map -->
                    </div>
                </div>
            </div>
        </div>
        <!-- ### Contact Page -->
        <%--        resume--%>
        <div class="section" id="resume" data-simplebar="init">


            <script type="text/javascript">
                var message = "${sessionScope.tip}";
                if (message != "") {
                    alert(message);
                }
            </script>

            <div class="main-container">
                <div class="main-title">order</div>
                <div class="main-desc">您的<b>订单记录</b></div>
                <div class="row clearfix">
                    <!-- Blog Item 1 -->
                    <jsp:useBean id="customer" class="Data.po.User.Customer"/>
                    <jsp:useBean id="order" class="Data.po.goods.Order"/>
                    <%--                    <table class="table table-striped">--%>
                    <div class="center">
                        <s:iterator value="#session.customer.orders" var="scit">


                            <div>
                                <p><strong size="100">订单号：${value.id} 总价格：${value.price}元
                                    订单时间：${value.time} </strong></p>
                            </div>
                            <div>
                                <s:iterator value="((#session.customer.orders.get(#scit.key))).orderDetails" var="a">

                                    <div id="${value.dishId}3" class="popup-box mfp-fade mfp-hide"
                                         data-simplebar="init">
                                        <div class="image-area"></div>
                                        <div class="content-area">
                                            <p><strong size="100"><label class="control-label">历史评论</label><br/></strong></p>
                                            <s:iterator value="value.dish.comments" var="stt">
                                            <tr>
                                                <s:if test="#stt.type==0">
                                                <td>好评><td>
                                                </s:if>

                                                <s:if test="#stt.type==1">
                                                <td>中评><td>
                                                </s:if>
                                                <s:if test="#stt.type==2">
                                                <td>差评><td>
                                                </s:if>
                                                <td>用户<s:property value="#stt.customer"/>:
                                                </td>
                                                <td><s:property value="#stt.detail"/> <br></td>
                                            <tr>
                                                </s:iterator>
                                                <br/><br/>
                                                <p><strong size="100"><label class="control-label">我的评论</label> </strong></p>
                                                <div class="content">
                                                    <s:form action="ShowComment" method="POST" namespace="/">
                                                        <%-- <label class="control-label">我:</label>


                                                        <s:hidden name="comment.customer"
                                                            value="#session.customer.account" />
                                                        <s:hidden name="dish.id"
                                                            value="19" />

                                                        <s:textfield name="comment.detail" />
                                                        <s:submit value="提交评论"/>
                                                         --%>
                                                        <div class="form-group" style="display: none">
                                                            <input value="${session.customer.nickname}"
                                                                   name="comment.customer"/>
                                                        </div>
                                                        <div class="form-group" style="display: none">

                                                            <input value="${value.dishId}" name="dish.id"/>
                                                        </div>
                                                        <div class="form-group" >
                                                            <s:radio list="#{'0':'好评','1':'中评','2':'差评'}" name="comment.type" value="0"/>

                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label">补充评论:</label>
                                                            <input name="comment.detail"/>
                                                        </div>


                                                        <s:submit value="提交" class="btn btn-defualt"/>
                                                    </s:form>
                                                </div>
                                        </div>
                                    </div>


                                    <div>
                                        <div class="card">
                                            <div class="card-footer">
                                                <a href="#${value.dishId}" class="popup-type-content">
                                                    <div class="name"><s:property value="value.dish.name"/>${value.num}
                                                        份,单价：${value.dish.dishInMenu.prize}元
                                                    </div>
                                                </a>

                                                <a href="#${value.dishId}3" class="popup-type-content">
                                                    <div class="name">添加评论</div>
                                                </a>
                                            </div>
                                        </div>
                                            <%--                                        </div>--%>
                                    </div>
                                    <div id="blog_popup_order" class="popup-box mfp-fade mfp-hide"
                                         data-simplebar="init">
                                        <div class="image-area">
                                            <img src="../image/dish/${a.value.dish.image}" alt="Blog Image">
                                        </div>
                                        <div class="content-area">
                                                ${a.value.dish.name}
                                        </div>
                                    </div>
                                </s:iterator>
                            </div>
                        </s:iterator>
                        <%--                    </table>--%>
                    </div>
                </div>
            </div>
        </div>
        <%--        --resume--%>

    </div>
</div>

<!-- jQuery -->
<script src="assets/lib/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap -->
<script src="assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Typed -->
<script src="assets/lib/typed.js/lib/typed.min.js"></script>

<!-- Simplebar -->
<script src="assets/lib/simplebar/dist/simplebar.js"></script>

<!-- Owl Carousel -->
<script src="assets/lib/owl.carousel/dist/owl.carousel.min.js"></script>

<!-- Masonry & Image Loaded & Masonry Filter -->
<script src="assets/lib/masonry-layout/dist/masonry.pkgd.min.js"></script>
<script src="assets/lib/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="assets/js/masonry-filter.js"></script>

<!-- Mobile Device Detect -->
<script src="assets/lib/mobile-detect/mobile-detect.min.js"></script>

<!-- Magnific Popup -->
<script src="assets/lib/magnific-popup/dist/jquery.magnific-popup.min.js"></script>

<!-- Custom Js -->
<script src="assets/js/script.js"></script>

<!-- For demo purpose only. Please remove when you publish your product -->
<script src="assets/js/demo.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-30038099-8"></script>
<script src="assets/js/google-tag-manager.js"></script>

</body>
<%--个人信息修改modal--%>
<div class="modal fade bs-example-modal-sm" id="alterInfoModal" role="dialog" aria-label="alterInfoModal"
     aria-hidden="true" style="z-index:10000">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">个人信息修改</h4>
            </div>
            <div class="modal-body">
                <s:form action="alterInfo" method="POST" namespace="/">
                    <div class="form-group" style="display: none">
                        <label class="control-label">账号:</label>
                        <input value="${session.customer.account}" name="customer.account"
                               readonly class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">昵称:</label>
                        <input value="${session.customer.nickname}" name="customer.nickname"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">身高:</label>
                        <input value="${session.customer.height}" name="customer.height"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">体重:</label>
                        <input value="${session.customer.weight}" name="customer.weight"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">性别:</label>
                            <%--                        <input value="${session.customer.gender}" name="customer.gender"--%>
                            <%--                               class="form-control"/>--%>
                        <select class="form-group" name="customer.gender" property="${session.customer.gender}">
                            <option value="true">男</option>
                            <option value="false">女</option>
                        </select>
                    </div>
                    <s:submit value="提交" class="btn btn-defualt"/>
                </s:form>
            </div>
        </div>
    </div>
</div>
<%--用户自定义摄入modal--%>
<div class="modal fade bs-example-modal-lg" id="addUserDefine" role="dialog" aria-label="addUserDefine"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content ">
            <div class="modal-header">
                <h4 class="modal-title">增加近日个人饮食情况</h4>
            </div>
            <div class="modal-body modal-lg">
                <s:form action="addUserDefine" method="POST">
                    <div class="form-group" style="display: none">
                        <label class="control-label">账号:</label>
                        <input value="${session.customer.account}" name="customer.account"
                               readonly class="form-control"/>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover " id="tabletable"
                               style="table-layout:fixed;">
                            <tr>
                                <th>序号</th>
                                <td>食品名称</td>
                                <td>卡路里</td>
                                <td>脂肪</td>
                                <td>膳食纤维</td>
                                <td>蛋白质</td>
                                <td>盐分</td>
                                <td>碳水化合物</td>
                            </tr>
                            <tbody>
                            <tr id="clo">
                                <td class="td">1</td>
                                <td><input name="name" value="0" style="width: 100%" required></td>
                                <td><input name="calorie" value="0" style="width: 100%"></td>
                                <td><input name="fat" value="0" style="width: 100%" required></td>
                                <td><input name="df" value="0" style="width: 100%" required></td>
                                <td><input name="protein" value="0" style="width: 100%" required></td>
                                <td><input name="na" value="0" style="width: 100%" required></td>
                                <td><input name="sugar" value="0" style="width: 100%" required></td>
                            </tr>
                            </tbody>
                        </table>
                            <%--                        <button onclick="fun()">增加一行</button>--%>
                            <%--                        <button onclick="del()">删除一行</button>--%>
                    </div>
                    <s:submit value="提交" class="btn btn-defualt"/>
                </s:form>

            </div>
            <%--            <script type="text/javascript">--%>
            <%--                //前面的序号1,2,3......--%>
            <%--                var i = 1;--%>
            <%--                $(".td").each(function(){--%>
            <%--                    $(this).html(i++);--%>
            <%--                })--%>
            <%--                //添加一行--%>
            <%--                function fun(){--%>
            <%--                    var $td = $("#clo").clone();       //增加一行,克隆第一个对象--%>
            <%--                    $(".table").append($td);--%>
            <%--                    var i = 1;--%>
            <%--                    $(".td").each(function(){       //增加一行后重新更新序号1,2,3......--%>
            <%--                        $(this).html(i++);--%>
            <%--                    })--%>
            <%--                    $("table tr:last").find(":input").val('');   //将尾行元素克隆来的保存的值清空--%>
            <%--                }--%>
            <%--                //删除一行--%>
            <%--                function del(){--%>
            <%--                    $("table tr:not(:first):not(:first):last").remove();//移除最后一行,并且保留前两行--%>
            <%--                }--%>
            <%--            </script>--%>
        </div>
    </div>
</div>
<%--充值modal--%>
<div class="modal fade bs-example-modal-sm" id="topupMoneyModal" role="dialog" aria-label="topupMoneyModal"
     aria-hidden="true" style="z-index:10000">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">充值</h4>
            </div>
            <div class="modal-body">
                <s:form action="topupMoney" method="POST" namespace="/">
                    <div class="form-group" style="display: none">
                        <label class="control-label">账号:</label>
                        <input value="${session.customer.account}" name="customer.account"
                               readonly class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">余额:</label>
                        <input value="${session.customer.balance}"
                               readonly class="form-control"/>
                    </div>
                    <div class="form-group">
                        <lable class="control-label">充值金额</lable>
                        <input name="customer.balance"/>
                    </div>

                    <s:submit value="提交" class="btn btn-defualt"/>
                </s:form>
            </div>
        </div>
    </div>
</div>

</html>
