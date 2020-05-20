<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>项目管理系统 by www.eyingda.com</title>
    <link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


    <script language="JavaScript" type="text/javascript">
        function tishi()
        {
            var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
            if(a!=true)return false;
            window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
        }

        
        function change(){ 
        	var rt= document.getElementById("renttype");	
        	  if(rt.value=='出租'){
        	document.getElementById("yajintr").style.display=""; 
        	  }else{
              	document.getElementById("yajintr").style.display="none"; 
        	  }
        	
        }
        function check(){
        	var pwd1=document.getElementById("pwd1");
        	var oldpwd=document.getElementById("oldpwd");
        	if(pwd1.value!=oldpwd.value){
        		alert("原密码不正确");
        		return false;
        	}else{
        	document.getElementById("fom").submit();
        	}
        }

    </script>
    <style type="text/css">
        <!--
        .atten {font-size:12px;font-weight:normal;color:#F00;}
        -->
    </style>
</head>

<body class="ContentBody">
<form action="updatepwd.do" method="post" id="fom"    name="form"   >
    <div class="MainDiv">
        <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
            <tr>
                <th class="tablestyle_title" >基本信息录入</th>
            </tr>
            <tr>
                <td class="CPanel">

                    <table border="0" cellpadding="0" cellspacing="0" style="width:100%">
                        <tr><td align="left">
                           <!--  <input type="submit"  onclick="return check()" name="Submit" value="保存" class="button"   />　

                            <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/> -->
                        </td></tr>
                        <TR>
                            <TD width="100%">
                                <fieldset style="height:100%;">
                                    <legend>密码信息</legend>
                                    <table border="0" cellpadding="2" cellspacing="1" style="width:100%">

                                        <tr>
                                            <td nowrap align="right" width="15%">原密码</td>
                                            
                                            <td width="35%"><input id='pwd1'  value=""   class="text" style="width:154px"  />
                                            <input id='oldpwd' type="hidden"   value="${dangqianyonghu.pwd }"   class="text" style="width:154px"  />
                                              <input name="uid" type="hidden"   value="${dangqianyonghu.uid }"   class="text" style="width:154px"  />
                                            
                                                <span class="red">*</span></td>
                                           <td width="16%" align="right" nowrap="nowrap">新密码</td>
                                            <td width="34%"><input id='pwd' name="pwd"  value=""   class="text" style="width:154px"  /> </td>
                                        </tr>
                                        
                                         
                                    </table>
                                    <br/>
                                </fieldset>			</TD>

                        </TR>





                    </TABLE>


                </td>
            </tr>





            <TR>
                <TD colspan="2" align="center" height="50px">
                    <input type="button"  onclick="check()" name="button" value="保存" class="button"  />　

                    <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
            </TR>
        </TABLE>


        </td>
        </tr>



        </table>

    </div>
</form>
</body>
</html>
