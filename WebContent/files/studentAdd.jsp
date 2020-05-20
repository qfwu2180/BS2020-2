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

       
       

    </script>
    <style type="text/css">
        <!--
        .atten {font-size:12px;font-weight:normal;color:#F00;}
        -->
    </style>
</head>

<body class="ContentBody">
<form action="addStudent.do" method="post"    name="form"   >
    <div class="MainDiv">
        <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
            <tr>
                <th class="tablestyle_title" >基本信息录入</th>
            </tr>
            <tr>
                <td class="CPanel">

                    <table border="0" cellpadding="0" cellspacing="0" style="width:100%">
                        <tr><td align="left">
                            <!-- <input type="submit" name="Submit" value="保存" class="button"   />　

                            <input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/> -->
                        </td></tr>
                        <TR>
                            <TD width="100%">
                                <fieldset style="height:100%;">
                                    <legend>学生信息</legend>
                                    <table border="0" cellpadding="2" cellspacing="1" style="width:100%">

                                        <tr>
                                            <td nowrap align="right" width="15%">学号:</td>
                                            <td width="35%"><input name='xh'   class="text" style="width:154px"  />
                                                <span class="red">*</span></td>
                                           <td width="16%" align="right" nowrap="nowrap">姓名</td>
                                            <td width="34%">
                                              <input name='name'   class="text" style="width:154px"  />
                                              </td>
                                        </tr>
                                        <tr>
                                            <td nowrap="nowrap" align="right">性别</td>
                                            <td><input     type="radio" name='sex'  checked value="男"     />男
                                            <input     type="radio" name='sex'  value="女"    />女
                                            </td>
                                              <td width="16%" align="right" nowrap="nowrap">班号</td>
                                            <td width="34%">     <select name="bh">
                                                <c:forEach items="${blist }" var="u">                                                 
                                                  <option value="${u.bid }" <c:if test="${g.bh==u.bid}">selected</c:if>>${u.bh }</option> 
                                                </c:forEach>
                                                </select> 
                                                 </td>
                                        </tr> 
                                        <tr>
                                            <td nowrap="nowrap" align="right">学年</td>
                                            <td><input  class="text" value="${g.xuenian }"  name='xuenian' style="width:154px" />
</td>
                                              <td width="16%" align="right" nowrap="nowrap">登录名</td>
                                            <td width="34%">  <input  class="text" value="${g.login }"  name='login' style="width:154px" /> </td>
                                        </tr> 
                                          <tr>
                                            <td nowrap="nowrap" align="right">密码</td>
                                            <td><input  class="text" value="${g.pwd }"  name='pwd' style="width:154px" />
</td>
                                              <td width="16%" align="right" nowrap="nowrap">邮箱</td>
                                            <td width="34%"><input  class="text" value="${g.mail }"  name='mail' style="width:154px" /></td>
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
                    <input type="submit" name="Submit" value="保存" class="button"  />　

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
