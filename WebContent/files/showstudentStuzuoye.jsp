<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目管理系统 by www.eyingda.com</title>
    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }
        .tabfont01 {
            font-family: "宋体";
            font-size: 9px;
            color: #555555;
            text-decoration: none;
            text-align: center;
        }
        .font051 {font-family: "宋体";
            font-size: 12px;
            color: #333333;
            text-decoration: none;
            line-height: 20px;
        }
        .font201 {font-family: "宋体";
            font-size: 12px;
            color: #FF0000;
            text-decoration: none;
        }
        .button {
            font-family: "宋体";
            font-size: 14px;
            height: 37px;
        }
        html { overflow-x: auto; overflow-y: auto; border:0;}
        -->
    </style>

    <link href="../css/css.css" rel="stylesheet" type="text/css" />
    <script type="text/JavaScript">

    </script>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
   /* function sousuo(){
        window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
    }*/
    function selectAll(){
        var obj = document.fom.elements;
        for (var i=0;i<obj.length;i++){
            if (obj[i].name == "ids"){
                obj[i].checked = true;
            }
        }
    }

    function unselectAll(){
        var obj = document.fom.elements;
        for (var i=0;i<obj.length;i++){
            if (obj[i].name == "ids"){
                if (obj[i].checked==true) obj[i].checked = false;
                else obj[i].checked = true;
            }
        }
    }

    function link(){
        document.getElementById("fom").action="zuoyeAdd.jsp";
        document.getElementById("fom").submit();
    }
    function back(){
        document.getElementById("fom").action="showStuzuoye.do";
        document.getElementById("fom").submit();
    }
    function shanchu(){
     //alert('xxx');
    if(confirm("确认删除?")){
        var obj = document.fom.elements;
        var flag=false;
        for (var i=0;i<obj.length;i++){
            if (obj[i].name == "ids"){
                if (obj[i].checked==true){flag=true;
                }
            }
        }
        if(flag==true) {
            var fom = document.getElementById("fom");
            fom.action = "delStuzuoye.do";
            fom.submit();
        }else{
            alert("请选择记录");
        }
    }
    }
    
    
    function preview(oper) { 
  	  if (oper < 10){ 
  	  bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
  	  sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域 
  	  eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域 
  	  prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html 

  	  prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html 
  	  window.document.body.innerHTML=prnhtml; 
  	  window.print(); 
  	  window.document.body.innerHTML=bdhtml; 

  	  }
  	   else{ 
  	  window.print(); 
  	  } 

  	  }


</SCRIPT>
${message}
<body>
<form name="fom"   action="showstudentStuzuoye.do" id="fom" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
            <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="62" background="../images/nav04.gif">

                        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                             <tr>
                                <td width="24"><img src="../images/ico07.gif" width="20" height="18" /></td>
                                <td  > 
                                                                                  
                                                                            作业<select name="zyid" >
                                  <option value="">全部</option>
                                  <c:forEach items="${zylist }" var="z">
                                  <option value="${z.zyid }" <c:if test="${z.zyid==zyid }"> selected </c:if>>${z.title }</option>
                                  </c:forEach>
                                  </select>                                            
                                    <input name="Submit" type="submit" class="right-button02" value="查 询" /> </td>
                                <td  align="left"> 
                            </tr>
                        </table></td>
                </tr>
            </table></td></tr>
        <tr>
            <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                            
                               <!--   <a   onclick="shanchu()"   href="javascript:void(0)"  class="right-button08" >删除所选信息</a>   <input name="Submit" type="button" class="right-button08" value="添加作业" onclick="link();" /> --> 
                                
                                作业信息通过右键另存为的方式下载
                            </td>
                        </tr>
                        <tr>
                            <td height="40" class="font42">
                             <!--startprint1-->
                            <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

                                <tr>
                                    <td height="20" colspan="15" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生提交作业信息列表&nbsp;</td>
                                </tr>
                                <tr>
                                    <td width="2%" align="center" bgcolor="#EEEEEE">选择</td>
                                    <td width="2%" height="20" align="center" bgcolor="#EEEEEE">编号</td>
                                    <td width="5%" align="center" bgcolor="#EEEEEE">标题</td>  
                                    <td width="9%" align="center" bgcolor="#EEEEEE">学生姓名</td> 
                                     <td width="2%" align="center" bgcolor="#EEEEEE">提交答案</td>
                                     <td width="2%" align="center" bgcolor="#EEEEEE">配图</td>     
                                       <td width="2%" align="center" bgcolor="#EEEEEE">创建时间</td> 
                                         <td width="2%" align="center" bgcolor="#EEEEEE">教师名</td> 
                                           <td width="2%" align="center" bgcolor="#EEEEEE">科目</td>  
                                           <td width="2%" align="center" bgcolor="#EEEEEE">班级</td> 
                                           <td width="2%" align="center" bgcolor="#EEEEEE">得分</td> 
                                       <td width="5%" align="center" bgcolor="#EEEEEE">操作</td> 
                                </tr>
                                <c:forEach items="${list}"  var="p" >
                                <tr>
                                    <td bgcolor="#FFFFFF"><input type="checkbox" value="${p.stuzyid}" name="ids"/></td>
                                    <td height="20" bgcolor="#FFFFFF" >${p.stuzyid}</td>
                                    <td bgcolor="#FFFFFF">${p.zy.title}</td> 
                                     <td bgcolor="#FFFFFF">${p.stu.name }</td> 
                                      <td bgcolor="#FFFFFF">
                                       <c:if test="${empty p.fujian }">暂无文档</c:if> 
                                        <c:if test="${ p.fujian!=''&&p.fujian!=null }"> <a href="${p.fujian}">学生文档</a></c:if>
                                       </td>
                                      
                                      <td bgcolor="#FFFFFF"><img src="${p.pic}"  style="width:150px;height: 150px;"/></td>    
                                      
                                      <td bgcolor="#FFFFFF"><fmt:formatDate value="${p.createtime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>  
                                      <td bgcolor="#FFFFFF">${p.zy.t.name}</td>  
                                      <td bgcolor="#FFFFFF">${p.kemu}</td>   
                                        <td bgcolor="#FFFFFF">${p.bj.bh}</td>   
                                         <td bgcolor="#FFFFFF">${p.socre}</td>   
                                      <td bgcolor="#FFFFFF">
                                       
                                      <a href="showStuzuoyedetail.do?stuzyid=${p.stuzyid }" >编辑 </a> 
                                      
                                       
                                      </td>
                                </tr>
                                </c:forEach>
                            </table>
                            <!--endprint1-->
                            </td>
                        </tr>
                    </table></td>
                </tr>
            </table>

                <!-- 分页部分开始 -->
                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
                    </tr>
                    <tr>
                        <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
                            <tr>
                                <td width="50%">共 <span class="right-text09">${pager.totalPage }</span> 页 | 第 <span class="right-text09">${pager.currentPage }</span> 页</td>
                                <td width="49%" align="right">[<a href="javascript:void(0)" onclick="fenye(1)" class="right-font08">首页</a> | <a href="javascript:void(0)" onclick="fenye(${pager.prePage})" class="right-font08">上一页</a> | <a href="javascript:void(0)" onclick="fenye(${pager.nextPage})" class="right-font08">下一页</a> | <a href="javascript:void(0)" onclick="fenye(${pager.totalPage})" class="right-font08">末页</a>] 转至：</td>
                                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="1%"><input id="currentPage" name="currentPage" value="${pager.currentPage }" type="text" class="right-textfield03" size="1" /></td>
                                        <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                                        </td>
                                    </tr>
                                </table></td>
                            </tr>
                        </table></td>
                    </tr>
                </table>
                <script>
                    function  fenye(p){
                        var pp= document.getElementById("currentPage");
                        pp.value=p;
                        if(pp.value>0&&pp.value!=""&&pp.value<=${pager.totalPage }){
                            document.forms[0].submit();
                        }else{
                            alert("跳转页数不正确");
                            pp.focus();
                        }

                    }

                </script>
                <!-- 分页部分结束 -->

            </td>
        </tr>
    </table>
</form>
</body>
</html>
