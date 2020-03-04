<!DOCTYPE html>
<html lang="zxx">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>PortoBSB - Personal Portfolio</title>
  <!-- Favicon -->


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
  <link rel="stylesheet" href="assets/css/themes/all.css" />

  <!-- You can choose a color from assets/css/colors instead of get all colors -->
  <link rel="stylesheet" href="assets/css/colors/all.css" />

  <!-- For demo purpose only. Please remove when you publish your product -->
  <link href="assets/css/demo.css" rel="stylesheet" />
</head>

<!--
BODY Element (Possible classes)

##### Themes #####
=================================================
|   theme-light     |   Light Theme             |
|   theme-dark      |   Dark Theme              |
=================================================

##### Colors #####
=================================================
|   color-blue      |   The color of blue       |
|   color-red       |   The color of red        |
|   color-yellow    |   The color of yellow     |
|   color-green     |   The color of green      |
|   color-purple    |   The color of purple     |
=================================================

##### Home Page Types #####
=================================================
|   bg-color        |   Background Color        |
|   bg-video        |   Background Video        |
|   bg-particles    |   Background Particles    |
=================================================
-->
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
        <img src="assets/images/avatars/face4.jpg" alt="User Avatar">
      </div>
      <span class="maximize">${session.staff.name}</span>
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
        <a href="#resume">
          <i class="la la-file-text"></i>
          <span>Resume</span>
        </a>
      </li>
      <li>
        <a href="#portfolio">
          <i class="la la-briefcase"></i>
          <span>Portfolio</span>
        </a>
      </li>
      <li>
        <a href="#blog">
          <i class="la la-newspaper-o"></i>
          <span>test</span>
        </a>
      </li>
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
        <div class="title">John Sensitive</div>
        <div class="subtitle">
          <span class="typed"></span>
        </div>
      </div>
    </div>
  </div>
  <!-- ### Home Page -->
    <div class="sub-pages">
        <div class="section" id="about" data-simplebar="init">
            <div class="main-container">
                <div class="main-title">QUERY</div>
                <div class="main-desc">Query something<b></b></div>
                <div class="row clearfix">
                    <div class="col-12 col-sm-12 col-md-6">
                        <!-- Education Area -->
                        <div class="content-group">
                            <div class="container">
                                <div class="starter">
                                    <a href="findTopup.action" type="button" class="btn-primary">查看所有充值流水</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  <div class="sub-pages">
    <!-- Resume Page -->
    <div class="section" id="resume" data-simplebar="init">
      <div class="main-container">
        <div class="main-title">DISH</div>
        <div class="main-desc"><b>Add Some</b> Deliciousness</div>

        <div class="row clearfix">
          <div class="col-12 col-sm-12 col-md-6">
            <!-- Education Area -->
            <div class="content-group">
              <div class="container">
                <div class="starter">
                  <s:form action="addDish" method="POST" namespace="/" enctype="multipart/form-data">
                    <table class="table table-striped table-bordered table-hover" style="table-layout: auto">
                      <tr>
                        <th>序号</th>
                        <th>菜名</th>
                        <th>卡路里</th>
                        <th>脂肪</th>
                        <th>糖分</th>
                        <th>膳食纤维</th>
                        <th>蛋白质</th>
                        <th>钠</th>
                        <th>种类</th>
                        <th>图片</th>
                      </tr>
                      <tbody>
                      <tr id="clo">
                        <td class="td">1</td>
                        <td><s:textfield name="name" placeholder="菜名" style="width:100px"/></td>
                        <td><s:textfield name="calorie" placeholder="卡路里" style="width:100px" /></td>
                        <td><s:textfield name="fat" placeholder="脂肪" style="width:100px"/></td>
                        <td><s:textfield name="suger" placeholder="糖分" style="width:100px"/></td>
                        <td><s:textfield name="df" placeholder="膳食纤维" style="width:100px"/></td>
                        <td><s:textfield name="protein" placeholder="蛋白质" style="width:100px"/></td>
                        <td><s:textfield name="na" placeholder="钠" style="width:100px"/></td>
<%--                        <td><s:textfield name="type" placeholder="种类"/></td>--%>
                        <td><select name="type">
                            <option value="荤菜">荤菜</option>
                          <option value="素菜">素菜</option>
                          <option value="海鲜">海鲜</option>
                          <option value="主食">主食</option>
                          <option value="汤">汤</option>
                        </select></td>
                        <td><s:file name="uploadImage" label="图片" accept="image/*"/></td>
                      </tr>
                      </tbody>
                    </table>
                    <s:submit value="提交"/>

                  </s:form>
                  <button onclick="fun()" style="margin-top: 10px">增加一行</button>
                  <button onclick="del()" style="margin-top: 10px">删除一行</button>
                </div>
              </div>
            </div>
            <!-- ### Education Area -->
          </div>
        </div>
      </div>
    </div>
    <!-- ### Resume Page -->
    <!-- Portfolio Page -->
    <div class="section" id="portfolio" data-simplebar="init">
      <div class="main-container">
        <div class="main-title">MENU</div>
        <div class="main-desc">Change The<b> Menu</b></div>

        <!-- Portfolio Filter Area -->
        <div class="filter filter-button-group">
          <div class="f_btn active">
            <label><input type="radio" name="fl_radio" value="col">全部</label>
          </div>
          <div class="f_btn">
            <label><input type="radio" name="fl_radio" value="荤类">荤类</label>
          </div>
          <div class="f_btn">
            <label><input type="radio" name="fl_radio" value="素类">素类</label>
          </div>
          <div class="f_btn">
            <label><input type="radio" name="fl_radio" value="海鲜">海鲜</label>
          </div>
          <div class="f_btn">
            <label><input type="radio" name="fl_radio" value="主食">主食</label>
          </div>
          <div class="f_btn">
            <label><input type="radio" name="fl_radio" value="汤">汤</label>
          </div>
        </div>
        <!-- ### Portfolio Filter Area -->
        <form action="changeMenu" method="post">
        <div class="row clearfix grid-items">
          <s:iterator value="#session.dish" status="dish">
            <div class="col col-12 col-sm-6 col-md-6 col-lg-4 ${dish.type}">
              <div class="card">
                <div class="card-body">
                  <div class="image-area">
                    <a href="#blog_popup_1" class="popup-type-content">
                      <img src="../image/dish/${dish.image}" alt="Blog Image">
                      <span class="info-area"><i class="la la-newspaper-o"></i></span>

                    </a>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="name">
                    <p>${dish.name}
                    <p>价格为：<input name="prize" value="${prize}">
                    <p>数量为：<input name="num" value="${num}"><br>
                  </div>
                </div>
              </div>
            </div>
          </s:iterator>
        </div>
          <div align="center">
            <input type="submit">
          </div>
        </form>
      </div>
    </div>
    <!-- ### Portfolio Page -->
    <!-- Blog Page -->
    <div class="section" id="blog" data-simplebar="init">
      <div class="main-container">
        <div class="main-title">DISH</div>
        <div class="main-desc"><b>Change The</b> DISH</div>
        <div class="row clearfix grid-items">
          <!-- Blog Item 1 -->
          <s:iterator value="#session.dish" status="dish">
          <div class="col col-12 col-sm-6 col-md-6 col-lg-4">
            <div class="card">
              <div class="card-body">
                <div class="image-area">
                  <a href="#${dish.id}" class="popup-type-content">
                    <img src="../image/dish/${dish.image}" alt="Blog Image">
                    <span class="info-area"><i class="la la-newspaper-o"></i></span>
                  </a>
                </div>
              </div>
              <div class="card-footer">
                  <div class="name">
                    <p>${dish.name}
                    <form action="delDish" method="post">
                    <input name="dish.id" type="text" value="${dish.id}" style="display: none">
                    <input type="submit" value="删除">
                  </form>
                  </div>
              </div>
            </div>
            <div id="${dish.id}" class="popup-box mfp-fade mfp-hide" data-simplebar="init">
              <div class="content-area">
                <div class="ttt" style="text-align:center">
                  <div class="title">修改信息</div>
              <img src="../image/dish/${dish.image}" height="150" width="300">
              <form action="setDish" method="post">
                <input name="dish.id" type="hidden" value="${dish.id}">
                  <p>菜名:<input name="dish.name" value="${dish.name}">
                <p>卡路里:<input name="dish.calorie" value="${dish.calorie}">
                <p>脂肪:<input name="dish.fat" value="${dish.fat}">
                <p>糖分:<input name="dish.sugar" value="${dish.sugar}">
                <p>膳食纤维:<input name="dish.df" value="${dish.df}">
                <p>蛋白质:<input name="dish.protein" value="${dish.protein}">
                <p>钠:<input name="dish.na" value="${dish.na}">
                <p>种类:<input name="dish.type" value="${dish.type}"><br>
                <input type="submit" value="修改">
              </form>
                </div>
              </div>
            </div>
          </div>
            </s:iterator>
        </div>
      </div>
    </div>
    <!-- ### Blog Page -->
  </div>
</div>
<script type="text/javascript">
  window.onload=function () {
      var a='<%=session.getAttribute("message")%>';
    if(a!="null"&&a!=""){
        alert(a);
    }
  }
  //前面的序号1,2,3......
  var i = 1;
  $(".td").each(function(){
    $(this).html(i++);
  })
  //添加一行
  function fun(){
    var i = 1;
    var $td = $("#clo").clone();       //增加一行,克隆第一个对象
    $(".table").append($td);
    $(".td").each(function(){       //增加一行后重新更新序号1,2,3......
      $(this).html(i++);
    })
    $("table tr:last").find(":input").val('');   //将尾行元素克隆来的保存的值清空
  }
  //删除一行
  function del(){
    $("table tr:not(:first):not(:first):last").remove();//移除最后一行,并且保留前两行
  }
</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

</html>
