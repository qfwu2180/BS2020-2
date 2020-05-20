package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.dao.ZuoyeDao;
import com.dao.StudentDao;
import com.pojo.Zuoye;
import com.pojo.ZuoyeQuery;
import com.pojo.ZuoyeQuery.Criteria;
import com.pojo.ZuoyeQuery.Criterion;
import com.pojo.BanjiQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Student;
import com.pojo.StudentQuery;

@Controller
public class ZuoyeController {
    
    @Autowired 
    private ZuoyeDao zd; 
	
    @Autowired
    private BanjiDao bd;
    
  
  
	 @RequestMapping("files/showZuoye.do")
		public  String  showZuoye( Zuoye   zuoye  ,HttpServletRequest request){
	Myuser m=(Myuser)	request.getSession().getAttribute("dangqianyonghu");
	if(m==null){
		request.setAttribute("message", "<script>alert('登录超时请重新登录')</script>");
		return "../login.jsp";
	}
		 //只能查询当前教师的班级信息
		 BanjiQuery bq=new BanjiQuery();
	    	 bq.createCriteria().andTidEqualTo(m.getUid());
	    List blist=	  bd.selectByExample(bq);
	    request.setAttribute("blist", blist);	//班级列表
		 
		 ZuoyeQuery  mq=new ZuoyeQuery();
		 Criteria cc=mq.createCriteria();
			    if(zuoye!=null&&zuoye.getTitle()!=null&&!"".equals(zuoye.getTitle())){
			    	cc.andTitleLike("%"+zuoye.getTitle()+"%");
			    	request.setAttribute("title", zuoye.getTitle());
			    } 
			    if(zuoye!=null&&zuoye.getBid()!=null&&!"".equals(zuoye.getBid())){
			    	cc.andBidEqualTo(zuoye.getBid());
			    	request.setAttribute("bid", zuoye.getBid());
			    } 
			    if(zuoye!=null&&zuoye.getKemu()!=null&&!"".equals(zuoye.getKemu())){
			    	cc.andKemuEqualTo(zuoye.getKemu());
			    	request.setAttribute("kemu", zuoye.getKemu());
			    } 
			    mq.setOrderByClause(" createtime desc");
			    mq.setPageNo(zuoye.getCurrentPage());
			    mq.setPageSize(zuoye.getSize());
			    
			    int count =zd.countByExample(mq); //查询记录数
			    zuoye.setTotalCount(count); //设置查询出来的总记录条数
			    
			 List<Zuoye> list= zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showZuoye.jsp";
		}
	 
	 
	 @RequestMapping("files/showmyseeZuoye.do")
		public  String  showstuZuoye( Zuoye   zuoye  ,HttpServletRequest request){
		 Student m=(Student)	request.getSession().getAttribute("dangqianyonghu");
	if(m==null){
		request.setAttribute("message", "<script>alert('登录超时请重新登录')</script>");
		return "../login.jsp";
	}
	 
	    
	    zuoye.setBid(Integer.parseInt(m.getBh()));//自己班号
		 
		 ZuoyeQuery  mq=new ZuoyeQuery();
		 Criteria cc=mq.createCriteria();
			    if(zuoye!=null&&zuoye.getTitle()!=null&&!"".equals(zuoye.getTitle())){
			    	cc.andTitleLike("%"+zuoye.getTitle()+"%");
			    	request.setAttribute("title", zuoye.getTitle());
			    } 
			    if(zuoye!=null&&zuoye.getBid()!=null&&!"".equals(zuoye.getBid())){
			    	cc.andBidEqualTo(zuoye.getBid());
			    	request.setAttribute("bid", zuoye.getBid());
			    } 
			    if(zuoye!=null&&zuoye.getKemu()!=null&&!"".equals(zuoye.getKemu())){
			    	cc.andKemuEqualTo(zuoye.getKemu());
			    	request.setAttribute("kemu", zuoye.getKemu());
			    } 
			    mq.setOrderByClause(" createtime desc");
			    mq.setPageNo(zuoye.getCurrentPage());
			    mq.setPageSize(zuoye.getSize());
			    
			    int count =zd.countByExample(mq); //查询记录数
			    zuoye.setTotalCount(count); //设置查询出来的总记录条数
			    
			 List<Zuoye> list= zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showmyseeZuoye.jsp";
		}
	 
	 
		
	 
			@RequestMapping("files/addZuoye.do")//添加信息
		public  String  addZuoye(Zuoye  zuoye, @RequestParam("file") MultipartFile file ,@RequestParam("daanfile") MultipartFile daanfile,@RequestParam("tu") MultipartFile tu ,HttpServletRequest request){
				 
				Myuser m=(Myuser)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('登录超时请重新登录!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setTid(m.getUid());//当前登录的教师可以留作业
					zuoye.setCreatetime(new Date());
					zuoye.setKemu(m.getKemu());
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
		         
		         if(!daanfile.isEmpty()){
		             String fname= daanfile.getOriginalFilename();//获取上传文件名称 并且以当前用户编号+项目编号做区分
                                  
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//将文件上传到 对应的位置
		             try {
		            	 daanfile.transferTo(f);
		             }catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }
		            
		             zuoye.setDaan("../upload/"+x+fname);
		         }else{
		        	 zuoye.setDaan(null);
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
	    return "redirect:showZuoye.do"; 
		
		} 
			
	 		@RequestMapping("files/toAddZuoye.do")//添加信息
			public  String  toAddZuoye(Zuoye  course ,HttpServletRequest request){
	 			Myuser m=(Myuser)	request.getSession().getAttribute("dangqianyonghu");
	 			if(m==null){
	 				request.setAttribute("message", "<script>alert('登录超时请重新登录')</script>");
	 				 return "../login.jsp";
	 			}
	 				 //只能查询当前教师的班级信息
	 				 BanjiQuery bq=new BanjiQuery();
	 			    	 bq.createCriteria().andTidEqualTo(m.getUid());
	 			    List blist=	  bd.selectByExample(bq);
	 			    request.setAttribute("blist", blist);	//班级列表
				
				
		    return "zuoyeAdd.jsp"; 
			
			}	  
			
		
			@RequestMapping("files/delZuoye.do") //删除信息
	   public String  delZuoye(Integer[]  ids ,HttpServletRequest  request){
				if(ids!=null&&ids.length>0){
				
					ZuoyeQuery gq=new ZuoyeQuery();
					   gq.createCriteria().andZyidIn(Arrays.asList(ids));
					 zd.deleteByExample(gq);  
				}
				return "redirect:showZuoye.do";  
	   }
			@RequestMapping("files/showZuoyedetail.do")
	   	  public String  showOneZuoye(Integer zyid,HttpServletRequest  request){
				 
				
				Zuoye g=    zd.selectByPrimaryKey(zyid);
			   		     request.setAttribute("g", g);  
			   		     return "zuoyeUpdate.jsp"; 
			}
		 
			
		 
			
			
			
			@RequestMapping("files/updateZuoye.do")
			public String  updateZuoye(Zuoye  zuoye, @RequestParam("file") MultipartFile file,@RequestParam("daanfile") MultipartFile daanfile ,@RequestParam("tu") MultipartFile tu,HttpServletRequest request){ 
				
				Myuser m=(Myuser)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('登录超时请重新登录!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setTid(m.getUid());
					 
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
		         
		         if(!daanfile.isEmpty()){
		             String fname= daanfile.getOriginalFilename();//获取上传文件名称 并且以当前用户编号+项目编号做区分
                                
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//将文件上传到 对应的位置
		             try {
		            	 daanfile.transferTo(f);
		             }catch (IOException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		             }
		            
		             zuoye.setDaan("../upload/"+x+fname);
		         }else{
		        	 zuoye.setDaan(null);
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
		      
	 
		
				
				ZuoyeQuery cq=new ZuoyeQuery();
				    cq.createCriteria().andZyidEqualTo(zuoye.getZyid());
				  int result=   zd.updateByExampleSelective(zuoye, cq);
		           if(result>0){
		               request.setAttribute("msg","<script>alert('操作成功!')</script>");
		           }else{
		               request.setAttribute("msg","<script>alert('操作失败!')</script>");
		           }
		           return "redirect:showZuoye.do";
			}
			
			
			 
			
			
			@InitBinder
			public void init(WebDataBinder binder) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
			}
   
	
}
