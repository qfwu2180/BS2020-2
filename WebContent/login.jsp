<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/logo.png"/>
    <title>作业批改系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">

    <!--[if lt IE 9]>
  <script src="js/html5shiv.min.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
    <style>
        html,body {
            height: 100%;
        }
        .box {
            /*filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /!*  IE *!/*/
            /*background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            /*background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);*/
            background-image:url("img/bg-login.png");
            background-repeat: no-repeat;
            background-size: 100%;
            margin: 0 auto;
            position: relative;
            width: 100%;
            height: 100%;
        }
        .login-box {
            width: 100%;
            max-width:500px;
            height: 400px;
            position: absolute;
            top: 50%;

            margin-top: -200px;
            /*设置负值，为要定位子盒子的一半高度*/

        }
        @media screen and (min-width:500px){
            .login-box {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }

        .form {
            width: 100%;
            max-width:500px;
            height: 275px;
            margin: 25px auto 0px auto;
            padding-top: 25px;
        }
        .login-content {
            height: 300px;
            width: 100%;
            max-width:500px;
            background-color: rgba(255, 250, 2550, .6);
            float: left;
        }


        .input-group {
            margin: 0px 0px 30px 0px !important;
        }
        .form-control,
        .input-group {
            height: 40px;
        }

        .form-group {
            margin-bottom: 0px !important;
        }
        .login-title {
            padding: 20px 10px;
            background-color: rgba(0, 0, 0, .6);
        }
        .login-title h1 {
            margin-top: 10px !important;
        }
        .login-title small {
            color: #fff;
        }

        .link p {
            line-height: 20px;
            margin-top: 30px;
        }
        .btn-sm {
            padding: 8px 24px !important;
            font-size: 16px !important;
        }
        .text-white{
            color: white;
        }
    </style>
    <script type="text/javascript">
     function tijiao(){
    	 if($("#login").val()==''){
    		 alert("请输入用户名");
    		 return ;
    	 }
    	 if($("#pwd").val()==''){
    		 alert("请输入密码");
    		 return ;
    	 }
    	 if($("#yzm").val()==''){
    		 alert("请输入验证码");
    		 return ;
    	 }
    	 document.getElementById("fom").submit();
    	 
     }
    
    </script>
    
</head>
<body>
${message }
<div class="box">
    <br/>
    <h1 class="text-center text-white"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;作业批改系统</h1>
    <div class="login-box">
        <div class="login-title text-center">
            <h1><small>登录</small></h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <form  id="fom" action="login.do" method="post" >
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input   name="login" id="login" class="form-control"    type="text" placeholder="用户名" /> 
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="pwd" name="pwd" class="form-control" placeholder="密码">
                                 <select name="role"   class="form-control" > 
                              <option value="学生">学生</option>
                              <option value="教师">教师</option>
                              <option value="管理员">管理员</option>
                              </select>
                              <input type="text" name="yzm"  id="yzm" maxlength="4" class="form-control"    placeholder="验证码">
                              <img id="yzmimg" src="randomCode.do" onclick="changeVcode()" class="code" style="cursor:pointer;"/>
                           <a href="forget.jsp" ><small>教师密码找回</small></a>         |      <a href="forgetstudent.jsp" ><small>学生密码找回</small></a>
                                    </div>
                        </div>
                    </div> 
                    
                     
                     <div class="form-group form-actions">
                        <div class="col-xs-3 col-xs-offset-4 "  >
                            <a href="javascript:void(0)" onclick="tijiao()" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</a>
                          </div>
                         
                    </div>
                    
                    
                    
                    
                      <div class="form-group">
                         <div class="col-xs-6 link">
                           <!--  <p class="text-center remove-margin"><small>忘记密码？</small> <a href="forget.jsp" ><small>找回</small></a>
                            </p> -->
                        </div>  
                        <!-- <div class="col-xs-6 link">
                            <p class="text-center remove-margin"><small>还没注册?</small> <a href="files/loginMyuserAdd.jsp" >注册</a>
                            </p>
                        </div> -->
                    </div>    
                </form>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script>
function changeVcode(){
	 $("#yzmimg").attr("src","randomCode.do?abc="+Math.random());
	//document.getElementById("yzm").src="randomCode.do?abc="+Math.random();
	//alert(document.getElementById("yzm").src);
}

    /*Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测
    (function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "js/bootlint.js";
        document.body.appendChild(s)
    })();*/
</script>
</body>
</html>