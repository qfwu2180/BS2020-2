package com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.MyuserDao;
import com.dao.StudentDao;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Student;
import com.pojo.StudentQuery;

@Controller
public class MyUserController {
    @Autowired
	private MyuserDao  md;
    
    @Autowired
    private StudentDao sd;
	
    @RequestMapping("/login.do")
    public String login(Myuser  mu,HttpServletRequest request){
    	
    String xx=(String)	request.getSession().getAttribute("randomCode");
    	if( request.getParameter("yzm")==null||!xx.equals(request.getParameter("yzm"))){
    		 request.setAttribute("message","<script>alert('登录失败!验证码不正确')</script>");
    		return  "login.jsp";
    	}
    	
    	if(mu.getRole().equals("学生")){
    		StudentQuery  sq=new StudentQuery();
        	sq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd());
        	List<Student> list=  sd.selectByExample(sq);
       	       String path="login.jsp";   
       	    if(list!=null&&list.size()>0){  
       			
      		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
      		            request.setAttribute("message","<script>alert('登录成功!')</script>");
      		           path="index.jsp";
      		        }else{
      		            request.setAttribute("message","<script>alert('登录失败!')</script>");
      		        }
      		    return path; 
    		
    		
    	}
    	
    	MyuserQuery  mq=new MyuserQuery();
    	mq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd()).andRoleEqualTo(mu.getRole());
    	List<Myuser> list=  md.selectByExample(mq);
   	       String path="login.jsp";   
	 
   		if(list!=null&&list.size()>0){  
   			
   		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
   		            request.setAttribute("message","<script>alert('登录成功!')</script>");
   		           path="index.jsp";
   		        }else{
   		            request.setAttribute("message","<script>alert('登录失败!')</script>");
   		        }
   		    return path; 
    	
    } 
    
    
    @RequestMapping("files/showMyuser.do")
	public  String  showEmployee( Myuser   myuser  ,HttpServletRequest request){
    	MyuserQuery  mq=new MyuserQuery();
		    if(myuser!=null&&myuser.getName()!=null&&!"".equals(myuser.getName())){
		    	mq.createCriteria().andNameLike("%"+myuser.getName()+"%");
		    }
		    mq.setPageNo(myuser.getCurrentPage());
		    mq.setPageSize(myuser.getSize());
		    
		    int count =md.countByExample(mq); //查询记录数
		    myuser.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Myuser> list=  md.selectByExample(mq);
		 request.setAttribute("pager",myuser); 
		 request.setAttribute("list", list); 
		
		return "showMyuser.jsp";
	}
	
 
		@RequestMapping("files/addMyuser.do")//添加信息
	public  String  addMyuser(Myuser  myuser ,HttpServletRequest request){
		 
		 int result=   md.insertSelective(myuser);
    if(result>0){
        request.setAttribute("message","<script>alert('操作成功!')</script>");
    }else{
        request.setAttribute("message","<script>alert('操作失败!')</script>");
    }
    return "redirect:showMyuser.do"; 
	
	}
		
		
			@RequestMapping("files/loginaddMyuser.do")//用户注册
		public  String  loginaddMyuser(Myuser  myuser ,HttpServletRequest request){
			 
			 int result=   md.insertSelective(myuser);
	    if(result>0){
	        request.setAttribute("message","<script>alert('操作成功!')</script>");
	    }else{
	        request.setAttribute("message","<script>alert('操作失败!')</script>");
	    }
	    return "redirect:/login.jsp"; 
		
		}
		
	
		@RequestMapping("files/delMyuser.do") //删除信息
   public String  delMyuser(Integer[]  ids ,HttpServletRequest  request){
			if(ids!=null&&ids.length>0){
			
				MyuserQuery gq=new MyuserQuery();
				   gq.createCriteria().andUidIn(Arrays.asList(ids));
				   md.deleteByExample(gq);  
			}
			return "redirect:showMyuser.do";  
   }
		@RequestMapping("files/showMyuserdetail.do")
   	  public String  showOneMyuser(Integer uid,HttpServletRequest  request){
			Myuser g=    md.selectByPrimaryKey(uid);
		   		     request.setAttribute("g", g);  
		   		     return "myuserUpdate.jsp"; 
		}
		
		@RequestMapping("files/updateMyuser.do")
		public String  updateMyuser(Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid());
			  int result=   md.updateByExampleSelective(myuser, cq);
	           if(result>0){
	               request.setAttribute("message","<script>alert('操作成功!')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('操作失败!')</script>");
	           }
	           return "redirect:showMyuser.do";
		}
	 
		@RequestMapping("files/updatepwd.do")
		public String  updatepwd(Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid()) ;
			  int result=   md.updateByExampleSelective(myuser, cq);
	           if(result>0){
	               request.setAttribute("message","<script>alert('操作成功!请重新登录')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('操作失败!')</script>");
	           }
	           return "../up.jsp";
		}
 
    
		
    
			@RequestMapping("forgetMyuser.do")
		public String  forgetMyuser(Myuser  myuser,HttpServletRequest request){ 
				 int result=0;
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andTelEqualTo(myuser.getTel()).andLoginEqualTo(myuser.getLogin());
			    List<Myuser> list= md.selectByExample(cq);
			    if(list!=null&&list.size()>0){
			    Myuser u=	list.get(0);
			    Myuser uu=new Myuser();
			    uu.setPwd("123");
			    MyuserQuery mqq=new MyuserQuery();
			    mqq.createCriteria().andUidEqualTo(u.getUid());
			     result= md.updateByExampleSelective(uu, mqq);
			    }
			    
	           if(result>0){
	               request.setAttribute("message","<script>alert('操作成功!请重新登录密码为123')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('操作失败!')</script>");
	           }
	           return "login.jsp";
		}
 
			
			
			
	       @Autowired
			private StudentDao std;
		    @RequestMapping("/sendemail.do")
		    public String sendemail(Student stu,HttpServletRequest request) throws Exception {
		        StudentQuery sq=new StudentQuery();
		         sq.createCriteria().andLoginEqualTo(stu.getLogin()).andXhEqualTo(stu.getXh());
		    List<Student> slist=	std.selectByExample(sq);
		    if(slist.size()==0){
		    	 request.setAttribute("message","<script>alert('操作失败!登录名或学号不正确')</script>");
		    	 return "login.jsp";
		    }	
		    Student st=  slist.get(0);
		    String data=st.getMail();
		    	
		    	MailUtil mu = new MailUtil();
		        int code=0;
		        try {
		            MailConfig mc = new MailConfig();
		            //设置发件人地址
		          /*  mc.setSenderAddress("452227049@qq.com");
		            //设置发件人账户名
		            mc.setSenderAccount("452227049@qq.com");
		            //设置发件人密码(备注：密码需要用邮箱SMTP客户端授权密码，而非登录密码，此处需注意)
		            mc.setSenderPassword("izolxhifdfvncbcc");*/
		            mc.setSenderAddress("283171937@qq.com");
		            //设置发件人账户名
		            mc.setSenderAccount("283171937@qq.com");
		            //设置发件人密码(备注：密码需要用邮箱SMTP客户端授权密码，而非登录密码，此处需注意)
		            mc.setSenderPassword("hbaqfgzgrlhabhdh"); 
		            
		            //设置邮件主题
		            mc.setSubject("邮件发送测试");
		            //设置收件人地址，多个地址可用逗号隔开
		            mc.setRecipientAddresses(data);
		            //设置抄送人地址，多个地址可用逗号隔开
//		            mc.setCopyToAddresses("xxxx@qq.com");
		            //设置邮件内容
		            code= new Random().nextInt(9999);
		            request.getSession().setAttribute("code",String.valueOf(code));
		            mc.setContent("您的注册码为："+String.valueOf(code));
		            //设置附件地址，多个附件地址用逗号隔开
//		            String[] s = {"C:/测试附件1.txt","C:/测试附件2.pdf"};
//		            mc.setAttachmentPaths(s);
		             //邮件信息配置完毕，调用MailUtil发送邮件。
		            mu.sendMail(mc);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		       Student st1=new Student();
		        st1.setPwd(code+"");
		        
		        StudentQuery  sqq=new StudentQuery();
		         sqq.createCriteria().andStidEqualTo(st.getStid());
		         sd.updateByExampleSelective(st1, sqq);
		         request.setAttribute("message","<script>alert('操作成功!密码已经发送至邮箱中')</script>");
		        return "login.jsp";
		    }
			
			
			
	
}
