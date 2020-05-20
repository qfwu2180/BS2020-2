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
<form action="updateZuoye.do"  method="post"  enctype="multipart/form-data"   name="form"   >
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
                                    <legend>作业信息</legend>
                                    <table border="0" cellpadding="2" cellspacing="1" style="width:100%">

                                        <tr>
                                            <td nowrap align="right" width="15%">标题:</td>
                                            <td width="35%"><input name='title'  value="${g.title }"  class="text" style="width:154px"  />
                                            <input name='zyid'  value="${g.zyid }" type="hidden" class="text" style="width:154px"  />
                                                <span class="red">*</span></td>
                                           <td width="16%" align="right" nowrap="nowrap">作业内容</td>
                                            <td width="34%">
                                              <textarea rows="8" cols="30" name="content">${g.content }</textarea>
                                              </td>
                                        </tr>
                                        <tr>
                                            <td nowrap="nowrap" align="right">附件</td>
                                            <td>
<input name='file'  type="file" class="text" style="width:154px"  />
                                            </td>
                                              <td width="16%" align="right" nowrap="nowrap">答案</td>
                                            <td width="34%">  <input name='daanfile'  type="file" class="text" style="width:154px"  /> </td>
                                        </tr> 
                                        <tr>
                                            <td nowrap="nowrap" align="right">班级</td>
                                            <td>
                                               <select name="bid">
                                                <c:forEach items="${blist }" var="u">                                                 
                                                  <option value="${u.bid }" <c:if test="${g.bid==u.bid}">selected</c:if>>${u.bh }</option> 
                                                </c:forEach>
                                                </select>  
                                            </td>
                                              <td width="16%" align="right" nowrap="nowrap">图片</td>
                                            <td width="34%">  
                                            <img src="${g.pic }" style="width:300px;height: 300px;"></img>
                                            <input name='tu'  type="file" class="text" style="width:154px"  /> </td>
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
