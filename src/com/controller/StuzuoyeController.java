package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.BanjiDao;
import com.dao.MyuserDao;
import com.dao.StudentDao;
import com.dao.StuzuoyeDao;
import com.dao.ZuoyeDao;
import com.dao.StudentDao;
import com.pojo.Stuzuoye;
import com.pojo.StuzuoyeQuery;
import com.pojo.StuzuoyeQuery.Criteria;
import com.pojo.Zuoye;
import com.pojo.ZuoyeQuery;
import com.pojo.Banji;
import com.pojo.BanjiQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Student;
import com.pojo.StudentQuery;

@Controller
public class StuzuoyeController {
    
    @Autowired 
    private StuzuoyeDao zd; 
	@Autowired
    private ZuoyeDao  zyd;
    @Autowired
    private BanjiDao bd;
	
    
    
	 @RequestMapping("files/showStuzuoye.do")//教师查看作业情况
		public  String  showStuzuoye( Stuzuoye   zuoye  ,HttpServletRequest request){
		 Myuser m=(Myuser)	request.getSession().getAttribute("dangqianyonghu");
			if(m==null){
				request.setAttribute("message", "<script>alert('登录超时请重新登录')</script>");
				return "../login.jsp";
			}
				 //只能查询当前教师的班级信息
				 BanjiQuery bq=new BanjiQuery();
			    	 bq.createCriteria().andTidEqualTo(m.getUid());
			    List<Banji> blist=	  bd.selectByExample(bq);
			    request.setAttribute("blist", blist);	//班级列表
		 
			    List<Integer> bids=new ArrayList<>();
			      for(Banji b:blist){
			    	   bids.add(b.getBid());			    	  
			      }
			    
			    
		 
		  ZuoyeQuery  zq=new ZuoyeQuery();
		 zq.createCriteria().andBidIn(bids); 
		  
		  zq.setOrderByClause(" createtime desc");//按时间降序将作业列出
		  
		 List<Zuoye> listzy=  zyd.selectByExample(zq);
		 
		 StuzuoyeQuery  mq=new StuzuoyeQuery();
		Criteria cc= mq.createCriteria();
			    if(zuoye!=null&&zuoye.getBanji()!=null&&!"".equals(zuoye.getBanji())){//这里是id
			    	cc.andBanjiEqualTo(zuoye.getBanji());
			    	request.setAttribute("banji", zuoye.getBanji());
			    } 
			    if(zuoye!=null&&zuoye.getZyid()!=null&&!"".equals(zuoye.getZyid())){
			    	cc.andZyidEqualTo(zuoye.getZyid());
			    	request.setAttribute("zyid", zuoye.getZyid());
			    }  
			    
			    
			    mq.setPageNo(zuoye.getCurrentPage());
			    mq.setPageSize(zuoye.getSize());
			    
			    int count =zd.countByExample(mq); //查询记录数
			    zuoye.setTotalCount(count); //设置查询出来的总记录条数
			    request.setAttribute("banji", zuoye.getBanji());//值的回显
			    request.setAttribute("zylist", listzy);//作业集合
			 List<Stuzuoye> list=  zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showStuzuoye.jsp";
		}
		
	 
	 
	 @RequestMapping("files/showstudentStuzuoye.do")//学生查看自己的作业情况
		public  String  showstudentStuzuoye( Stuzuoye   zuoye  ,HttpServletRequest request){
		 Student m=(Student)	request.getSession().getAttribute("dangqianyonghu");
			if(m==null){
				request.setAttribute("message", "<script>alert('登录超时请重新登录')</script>");
				return "../login.jsp";
			}
				 
			    
			    
		 
		  ZuoyeQuery  zq=new ZuoyeQuery();
		  zq.createCriteria().andBidEqualTo(Integer.parseInt(m.getBh())); 
		  zq.setOrderByClause(" createtime desc");//按时间降序将作业列出 
		 List<Zuoye> listzy=  zyd.selectByExample(zq);
		 
		 StuzuoyeQuery  mq=new StuzuoyeQuery(); //学生作业情况
		Criteria cc= mq.createCriteria();
			    	cc.andStidEqualTo(m.getStid());//学生自己的信息
			    
			    if(zuoye!=null&&zuoye.getZyid()!=null&&!"".equals(zuoye.getZyid())){
			    	cc.andZyidEqualTo(zuoye.getZyid());
			    	request.setAttribute("zyid", zuoye.getZyid());
			    }   
			    mq.setPageNo(zuoye.getCurrentPage());
			    mq.setPageSize(zuoye.getSize());
			    
			    int count =zd.countByExample(mq); //查询记录数
			    zuoye.setTotalCount(count); //设置查询出来的总记录条数
			     
			    request.setAttribute("zylist", listzy);//作业集合
			 List<Stuzuoye> list=  zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showstudentStuzuoye.jsp";
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
			@RequestMapping("files/addStuzuoye.do")//添加信息
		public  String  addStuzuoye(Stuzuoye  zuoye, @RequestParam("file") MultipartFile file ,@RequestParam("tu") MultipartFile tu ,HttpServletRequest request){
				 
				Student m=(Student)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('登录超时请重新登录!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setStid(m.getStid());//学生id
					zuoye.setCreatetime(new Date());
					zuoye.setBanji(m.getBh());//设置班号
				String path=  request.getSession().getServletContext().getRealPath("/upload");//获取 文件夹的路径
		         System.out.println("path:::"+path);
		         int x=(int)(Math.random()*999);
		         if(!file.isEmpty()){
		             String fname= file.getOriginalFilename();//获取上传文件名称 并且以当前用户编号+项目编号做区分
                                   
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//将文件上传到 对应的位置
		             try {
		                 file.transferTo(f);
		             }catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }
		            
		             zuoye.setFujian("../upload/"+x+fname);
		         }else{
		        	 zuoye.setFujian(null);
		         } 
		         
		         if(!tu.isEmpty()){
		             String fname= tu.getOriginalFilename();//获取上传文件名称 并且以当前用户编号+项目编号做区分
                                  
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//将文件上传到 对应的位置
		             try {
		            	 tu.transferTo(f);
		             }catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }
		            
		             zuoye.setPic("../upload/"+x+fname);
		         }else{
		        	 zuoye.setPic(null);
		         } 
		       
		      
			 int result= zd.insertSelective(zuoye);
	    if(result>0){
	        request.setAttribute("msg","<script>alert('操作成功!')</script>");
	    }else{
	        request.setAttribute("msg","<script>alert('操作失败!')</script>");
	    }
	  //  return "redirect:showStuzuoye.do"; 
	   // return "redirect:showStuzuoye.do"; 
	    return "redirect:showstudentStuzuoye.do";
	    
		} 
			
		 		@RequestMapping("files/toAddStuzuoye.do")//添加信息
			public  String  toAddStuzuoye(Zuoye  zuoye ,HttpServletRequest request){
					  
				Zuoye z=	 zyd.selectByPrimaryKey(zuoye.getZyid());
				request.setAttribute("z", z);//对应要提交作业
		    return "stuzuoyeAdd.jsp"; 
			
			}	  
			
		
			@RequestMapping("files/delStuzuoye.do") //删除信息
	   public String  delStuzuoye(Integer[]  ids ,HttpServletRequest  request){
				if(ids!=null&&ids.length>0){
				
					StuzuoyeQuery gq=new StuzuoyeQuery();
					   gq.createCriteria().andZyidIn(Arrays.asList(ids));
					 zd.deleteByExample(gq);  
				}
				return "redirect:showStuzuoye.do";  
	   }
			@RequestMapping("files/showStuzuoyedetail.do")
	   	  public String  showOneStuzuoye(Integer stuzyid,HttpServletRequest  request){
				 
				
				Stuzuoye g=    zd.selectByPrimaryKey(stuzyid);
			   		     request.setAttribute("g", g);  
			   		     return "stuzuoyeUpdate.jsp"; 
			}
			@RequestMapping("files/showStuzuoyedetailsocre.do")//上分操作
		   	  public String  shangfenshowStuzuoyedetail(Integer stuzyid,HttpServletRequest  request){
					 
					
					Stuzuoye g=    zd.selectByPrimaryKey(stuzyid);
				   		     request.setAttribute("g", g);
				   		     
				   		     return "stuzuoyeUpdatescore123.jsp"; 
				}
			
		 
			
			
			
			@RequestMapping("files/updateStuzuoye.do")//学生登录后对作业的修改
			public String  updateStuzuoye(Stuzuoye  zuoye, @RequestParam("file") MultipartFile file ,@RequestParam("tu") MultipartFile tu ,HttpServletRequest request){ 
				
				Student m=(Student)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('登录超时请重新登录!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setStid(m.getStid());
					 
				String path=  request.getSession().getServletContext().getRealPath("/upload");//获取 文件夹的路径
		         System.out.println("path:::"+path);
		         int x=(int)(Math.random()*999);
		         if(!file.isEmpty()){
		             String fname= file.getOriginalFilename();//获取上传文件名称 并且以当前用户编号+项目编号做区分
                               
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//将文件上传到 对应的位置
		             try {
		                 file.transferTo(f);
		             }catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }
		            
		             zuoye.setFujian("../upload/"+x+fname);
		         }else{
		        	 zuoye.setFujian(null);
		         } 
		          
		         if(!tu.isEmpty()){
		             String fname= tu.getOriginalFilename();//获取上传文件名称 并且以当前用户编号+项目编号做区分
                                  
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//将文件上传到 对应的位置
		             try {
		            	 tu.transferTo(f);
		             }catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }
		            
		             zuoye.setPic("../upload/"+x+fname);
		         }else{
		        	 zuoye.setPic(null);
		         } 
		       
				
				StuzuoyeQuery cq=new StuzuoyeQuery();
				    cq.createCriteria().andZyidEqualTo(zuoye.getZyid());
				    zuoye.setZyid(null);
				  int result=   zd.updateByExampleSelective(zuoye, cq);
		           if(result>0){
		               request.setAttribute("msg","<script>alert('操作成功!')</script>");
		           }else{
		               request.setAttribute("msg","<script>alert('操作失败!')</script>");
		           }
		          /* if(request.getParameter("sf")!=null){
		        	   return "redirect:showStuzuoye.do?zyid="+zuoye.getZyid()+"&banji="+zuoye.getBanji();
		        	   
		           }*/
		           
		           return "redirect:showstudentStuzuoye.do";
			}
			
			
			@RequestMapping("files/teacherupdateStuzuoye.do")//教师登录后对作业的修改
			public String  teacherupdateStuzuoye(Stuzuoye  zuoye,HttpServletRequest request){ 
				
				Myuser m=(Myuser)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){ 
				        request.setAttribute("msg","<script>alert('登录超时请重新登录!')</script>");
					  return "../login.jsp";
				  }
				
				      
					 
				 
		          
				
				StuzuoyeQuery cq=new StuzuoyeQuery();
				    cq.createCriteria().andStuzyidEqualTo(zuoye.getStuzyid());
				    zuoye.setStuzyid(null);
				  int result=   zd.updateByExampleSelective(zuoye, cq);
		           if(result>0){
		               request.setAttribute("msg","<script>alert('操作成功!')</script>");
		           }else{
		               request.setAttribute("msg","<script>alert('操作失败!')</script>");
		           }
		           return "redirect:showStuzuoye.do";
			}
			 
			
			
			@InitBinder
			public void init(WebDataBinder binder) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
			}
   
	
}
