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
    		 request.setAttribute("message","<script>alert('��¼ʧ��!��֤�벻��ȷ')</script>");
    		return  "login.jsp";
    	}
    	
    	if(mu.getRole().equals("ѧ��")){
    		StudentQuery  sq=new StudentQuery();
        	sq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd());
        	List<Student> list=  sd.selectByExample(sq);
       	       String path="login.jsp";   
       	    if(list!=null&&list.size()>0){  
       			
      		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
      		            request.setAttribute("message","<script>alert('��¼�ɹ�!')</script>");
      		           path="index.jsp";
      		        }else{
      		            request.setAttribute("message","<script>alert('��¼ʧ��!')</script>");
      		        }
      		    return path; 
    		
    		
    	}
    	
    	MyuserQuery  mq=new MyuserQuery();
    	mq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd()).andRoleEqualTo(mu.getRole());
    	List<Myuser> list=  md.selectByExample(mq);
   	       String path="login.jsp";   
	 
   		if(list!=null&&list.size()>0){  
   			
   		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
   		            request.setAttribute("message","<script>alert('��¼�ɹ�!')</script>");
   		           path="index.jsp";
   		        }else{
   		            request.setAttribute("message","<script>alert('��¼ʧ��!')</script>");
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
		    
		    int count =md.countByExample(mq); //��ѯ��¼��
		    myuser.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Myuser> list=  md.selectByExample(mq);
		 request.setAttribute("pager",myuser); 
		 request.setAttribute("list", list); 
		
		return "showMyuser.jsp";
	}
	
 
		@RequestMapping("files/addMyuser.do")//�����Ϣ
	public  String  addMyuser(Myuser  myuser ,HttpServletRequest request){
		 
		 int result=   md.insertSelective(myuser);
    if(result>0){
        request.setAttribute("message","<script>alert('�����ɹ�!')</script>");
    }else{
        request.setAttribute("message","<script>alert('����ʧ��!')</script>");
    }
    return "redirect:showMyuser.do"; 
	
	}
		
		
			@RequestMapping("files/loginaddMyuser.do")//�û�ע��
		public  String  loginaddMyuser(Myuser  myuser ,HttpServletRequest request){
			 
			 int result=   md.insertSelective(myuser);
	    if(result>0){
	        request.setAttribute("message","<script>alert('�����ɹ�!')</script>");
	    }else{
	        request.setAttribute("message","<script>alert('����ʧ��!')</script>");
	    }
	    return "redirect:/login.jsp"; 
		
		}
		
	
		@RequestMapping("files/delMyuser.do") //ɾ����Ϣ
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
	               request.setAttribute("message","<script>alert('�����ɹ�!')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('����ʧ��!')</script>");
	           }
	           return "redirect:showMyuser.do";
		}
	 
		@RequestMapping("files/updatepwd.do")
		public String  updatepwd(Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid()) ;
			  int result=   md.updateByExampleSelective(myuser, cq);
	           if(result>0){
	               request.setAttribute("message","<script>alert('�����ɹ�!�����µ�¼')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('����ʧ��!')</script>");
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
	               request.setAttribute("message","<script>alert('�����ɹ�!�����µ�¼����Ϊ123')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('����ʧ��!')</script>");
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
		    	 request.setAttribute("message","<script>alert('����ʧ��!��¼����ѧ�Ų���ȷ')</script>");
		    	 return "login.jsp";
		    }	
		    Student st=  slist.get(0);
		    String data=st.getMail();
		    	
		    	MailUtil mu = new MailUtil();
		        int code=0;
		        try {
		            MailConfig mc = new MailConfig();
		            //���÷����˵�ַ
		          /*  mc.setSenderAddress("452227049@qq.com");
		            //���÷������˻���
		            mc.setSenderAccount("452227049@qq.com");
		            //���÷���������(��ע��������Ҫ������SMTP�ͻ�����Ȩ���룬���ǵ�¼���룬�˴���ע��)
		            mc.setSenderPassword("izolxhifdfvncbcc");*/
		            mc.setSenderAddress("283171937@qq.com");
		            //���÷������˻���
		            mc.setSenderAccount("283171937@qq.com");
		            //���÷���������(��ע��������Ҫ������SMTP�ͻ�����Ȩ���룬���ǵ�¼���룬�˴���ע��)
		            mc.setSenderPassword("hbaqfgzgrlhabhdh"); 
		            
		            //�����ʼ�����
		            mc.setSubject("�ʼ����Ͳ���");
		            //�����ռ��˵�ַ�������ַ���ö��Ÿ���
		            mc.setRecipientAddresses(data);
		            //���ó����˵�ַ�������ַ���ö��Ÿ���
//		            mc.setCopyToAddresses("xxxx@qq.com");
		            //�����ʼ�����
		            code= new Random().nextInt(9999);
		            request.getSession().setAttribute("code",String.valueOf(code));
		            mc.setContent("����ע����Ϊ��"+String.valueOf(code));
		            //���ø�����ַ�����������ַ�ö��Ÿ���
//		            String[] s = {"C:/���Ը���1.txt","C:/���Ը���2.pdf"};
//		            mc.setAttachmentPaths(s);
		             //�ʼ���Ϣ������ϣ�����MailUtil�����ʼ���
		            mu.sendMail(mc);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		       Student st1=new Student();
		        st1.setPwd(code+"");
		        
		        StudentQuery  sqq=new StudentQuery();
		         sqq.createCriteria().andStidEqualTo(st.getStid());
		         sd.updateByExampleSelective(st1, sqq);
		         request.setAttribute("message","<script>alert('�����ɹ�!�����Ѿ�������������')</script>");
		        return "login.jsp";
		    }
			
			
			
	
}
