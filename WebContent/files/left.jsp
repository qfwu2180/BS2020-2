<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
            background-image: url(../images/left.gif);
        }
        -->
    </style>
    <link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
    function tupian(idt){
        var nametu="xiaotu"+idt;
        var tp = document.getElementById(nametu);
        tp.src="../images/ico05.gif";//图片ico04为白色的正方形

        for(var i=1;i<30;i++)
        {

            var nametu2="xiaotu"+i;
            if(i!=idt*1)
            {
                var tp2=document.getElementById('xiaotu'+i);
                if(tp2!=undefined)
                {tp2.src="../images/ico06.gif";}//图片ico06为蓝色的正方形
            }
        }
    }
    function tan(){
    	
    	alert("备份成功");
    	
    }
    

    function list(idstr){
        var name1="subtree"+idstr;
        var name2="img"+idstr;
        var objectobj=document.all(name1);
        var imgobj=document.all(name2);


        //alert(imgobj);

        if(objectobj.style.display=="none"){
            for(i=1;i<10;i++){
                var name3="img"+i;
                var name="subtree"+i;
                var o=document.all(name);
                if(o!=undefined){
                    o.style.display="none";
                    var image=document.all(name3);
                    //alert(image);
                    image.src="../images/ico04.gif";
                }
            }
            objectobj.style.display="";
            imgobj.src="../images/ico03.gif";
        }
        else{
            objectobj.style.display="none";
            imgobj.src="../images/ico04.gif";
        }
    }

</SCRIPT>
<script type="text/javascript">
    //判断时间是否为个位数，如果时间为个位数就在时间之前补上一个“0”
	function check(val) {
		if (val < 10) {
			return ("0" + val);
		} 
		else {
			return (val);
		}
	}
	function displayTime() {
		//获取div元素
		var timeDiv=document.getElementById("timeDiv");
		//获取系统当前的年、月、日、小时、分钟、毫秒
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hour = date.getHours();
		var minutes = date.getMinutes();
		var second = date.getSeconds();
		var timestr = year + "年" + month + "月" + day + "日  " + check(hour)
				+ ":" + check(minutes) + ":" + check(second);
		//将系统时间设置到div元素中
		//alert(timeDiv.innerHTML);
		timeDiv.innerHTML = timestr;
	}
	//每隔1秒调用一次displayTime函数
	function start(){
        window.setInterval("displayTime()",1000)//单位是毫秒
}
</script>
 


<body onload="start()">
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
    <tr>
        <TD>
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="207" height="55" background="../images/nav01.gif">
                        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="25%" > </td>
                                <td width="75%" height="22" class="left-font01">当前时间为<span id="timeDiv" class="left-font02"> </span></td>
                            </tr>
                            <tr>
                                <td height="22" class="left-font01">
                                    [&nbsp;<a href="../login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>



            <!--  任务系统开始    -->
              <!-- <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29">
                        <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="8%"><img name="img8" id="img8" src="../images/ico04.gif" width="8" height="11" /></td>
                                <td width="92%">
                                    <a href="javascript:" target="mainFrame" class="left-font03" onClick="list('8');" >基础信息管理</a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </TABLE>
            <table id="subtree8" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
                   cellspacing="0" class="left-table02">
                <tr>
                    <td width="9%" height="20" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmessage.do" target="mainFrame" class="left-font03" onClick="tupian('20');">供货商管理</a></td>
                </tr>
               <tr>
                    <td width="9%" height="201" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmessage.do" target="mainFrame" class="left-font03" onClick="tupian('201');">库房信息管理</a></td>
                </tr>
                 <tr>
                    <td width="9%" height="202" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmessage.do" target="mainFrame" class="left-font03" onClick="tupian('202');">门店产品信息管理</a></td>
                </tr>
                 <tr>
                    <td width="9%" height="203" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmessage.do" target="mainFrame" class="left-font03" onClick="tupian('203');">门店信息管理</a></td>
                </tr>
                 <tr>
                    <td width="9%" height="204" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmessage.do" target="mainFrame" class="left-font03" onClick="tupian('204');">客户信息管理</a></td>
                </tr>
                  <tr>
                    <td width="9%" height="20" ><img id="xiaotu20" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmessage.do" target="mainFrame" class="left-font03" onClick="tupian('20');">员工信息管理</a></td>
                </tr>

            </table>    -->
            <!--  任务系统结束    -->


 <c:if test="${dangqianyonghu.role=='管理员'}">
            <!--  消息系统开始    -->
             <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29">
                        <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="8%"><img name="img7" id="img7" src="../images/ico04.gif" width="8" height="11" /></td>
                                <td width="92%">
                                    <a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');" >基础信息管理</a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </TABLE>
            <table id="subtree7" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
                   cellspacing="0" class="left-table02">
                <tr>
                    <td width="9%" height="20" ><img id="xiaotu17" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%">
                        <a href="showMyuser.do" target="mainFrame" class="left-font03" onClick="tupian('17');">用户管理</a></td>
                </tr>
               
                <tr>
                    <td width="9%" height="20" ><img id="xiaotu13" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showBanji.do" target="mainFrame" class="left-font03" onClick="tupian('13');">班级管理</a></td>
                </tr>
               
               
            </table>  
            
            
            
                <!--  考勤系统开始    -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="8%" height="12"><img name="img4" id="img4" src="../images/ico04.gif" width="8" height="11" /></td>
                            <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('4');" >学生管理</a></td>
                        </tr>
                    </table></td>
                </tr>
            </table>

            <table id="subtree4" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
              
                <tr>
                    <td width="9%" height="20" ><img id="xiaotu11" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showStudent.do" target="mainFrame" class="left-font03" onClick="tupian('11');">学生管理</a></td>
                </tr> 
              <!--  <tr>
                    <td width="9%" height="20" ><img id="xiaotu12" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showMdsale.do" target="mainFrame" class="left-font03" onClick="tupian('12');">门店销售</a></td>
                </tr>
                
              
                <tr>
                    <td width="9%" height="20" ><img id="xiaotu13" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="toaddcaipu.do" target="mainFrame" class="left-font03" onClick="tupian('13');">菜普添加</a></td>
                </tr>
                 <tr>
                    <td width="9%" height="20" ><img id="xiaotu14" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="toshowcommoncaipu.do" target="mainFrame" class="left-font03" onClick="tupian('14');">菜普浏览</a></td>
                </tr> -->
                

            </table>
            
            
            
            
            
            </c:if>
            <!--  消息系统结束    -->
 

             <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29">
                        <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
                                <td width="92%">
                                    <a href="javascript:" target="mainFrame" class="left-font03" onClick="list('1');" >作业管理</a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </TABLE>
            <table id="subtree1" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
                   cellspacing="0" class="left-table02">
               <c:if test="${dangqianyonghu.role!='学生' }">
                 <tr>
                    <td width="9%" height="20" ><img id="xiaotu13" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showStuzuoye.do" target="mainFrame" class="left-font03" onClick="tupian('13');">作业情况</a></td>
                </tr>
               <!--  <tr>
                    <td width="9%" height="20" ><img id="xiaotu14" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="toAddCourse.do" target="mainFrame" class="left-font03" onClick="tupian('14');">作业统计</a></td>
                </tr> -->
                 <tr>
                    <td width="9%" height="20" ><img id="xiaotu2" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showZuoye.do" target="mainFrame" class="left-font03" onClick="tupian('2');">作业管理</a></td>
                </tr>
                </c:if>
                 <c:if test="${dangqianyonghu.role=='学生' }">
               <tr>
                    <td width="9%" height="20" ><img id="xiaotu1" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showmyseeZuoye.do" target="mainFrame" class="left-font03" onClick="tupian('1');">查看作业</a></td>
                </tr> 
                 <tr>
                    <td width="9%" height="20" ><img id="xiaotu9" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showstudentStuzuoye.do" target="mainFrame" class="left-font03" onClick="tupian('9');">我的作业</a></td>
                </tr> 
                </c:if>

            </table>
         <!--    项目系统结束   -->

        

            <!--  人员系统开始    -->
           <c:if test="${dangqianyonghu.role!='学生' }">
             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="8%" height="12"><img name="img3" id="img3" src="../images/ico04.gif" width="8" height="11" /></td>
                            <td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('3');" >个人信息管理</a></td>
                        </tr>
                    </table></td>
                </tr>
            </table>

            <table id="subtree3" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
                <tr>
                    <td width="9%" height="20" ><img id="xiaotu8" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="xgmm.jsp" target="mainFrame" class="left-font03" onClick="tupian('8');">修改密码</a></td>
                </tr>
               
                <!--   <tr>
                    <td width="9%" height="20" ><img id="xiaotu9" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showChain.do" target="mainFrame" class="left-font03" onClick="tupian('9');">个人信息管理</a></td>
                </tr>    -->
                 
            </table> 
         
</c:if>
            <!--  人员系统结束    -->
 
        
 

            <!--  考勤系统结束    -->
      
 

       <!--      系统帮助开始-->
           <!--  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29"><table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="8%"><img name="img6" id="img6" src="../images/ico04.gif" width="8" height="11" /></td>
                            <td width="92%"><a href="javascript:void(0)" target="mainFrame" class="left-font03" onClick="list('6');">统计查询</a></td>
                        </tr>
                    </table></td>
                </tr>
            </table>
            <table id="subtree6" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
                <tr>
                    <td width="9%" height="20"><img id="xiaotu15" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showChurukuTongJi.do" target="mainFrame" class="left-font03" onClick="tupian('15');">库存月结</a></td>
                </tr>
                <tr>
                    <td width="9%" height="20"><img id="xiaotu16" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="rexiaochanpinTongJi.do" target="mainFrame" class="left-font03" onClick="tupian('16');">热销产品统计</a></td>
                </tr>
            </table> -->
          <!--  系统帮助结束-->   

      <!--        个人信息管理开始-->

             <!-- <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
                <tr>
                    <td height="29">
                        <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="8%"><img name="img9" id="img9" src="../images/ico04.gif" width="8" height="11" /></td>
                                <td width="92%">
                                    <a href="javascript:" target="mainFrame" class="left-font03" onClick="list('9');" >个人设置</a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </TABLE> 

             <table id="subtree9" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0"
                   cellspacing="0" class="left-table02">
                <tr>
                    <td width="9%" height="22" ><img id="xiaotu22" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="xgmm.jsp" target="mainFrame" class="left-font03"
                                       onClick="tupian('22');">修改密码</a></td>
                </tr>
                <tr>
                    <td width="9%" height="23" ><img id="xiaotu23" src="../images/ico06.gif" width="8" height="12" /></td>
                    <td width="91%"><a href="showAllpbc.do" target="mainFrame" class="left-font03"
                                       onClick="tupian('23');">关键字管理</a></td>
                </tr>
            </table>  --> 
            <!--  个人信息结束    -->
            
            
            
            
            
            
            

        </TD>
    </tr>

</table>
</body>
</html>
