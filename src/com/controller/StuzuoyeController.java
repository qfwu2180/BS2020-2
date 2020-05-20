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
	
    
    
	 @RequestMapping("files/showStuzuoye.do")//��ʦ�鿴��ҵ���
		public  String  showStuzuoye( Stuzuoye   zuoye  ,HttpServletRequest request){
		 Myuser m=(Myuser)	request.getSession().getAttribute("dangqianyonghu");
			if(m==null){
				request.setAttribute("message", "<script>alert('��¼��ʱ�����µ�¼')</script>");
				return "../login.jsp";
			}
				 //ֻ�ܲ�ѯ��ǰ��ʦ�İ༶��Ϣ
				 BanjiQuery bq=new BanjiQuery();
			    	 bq.createCriteria().andTidEqualTo(m.getUid());
			    List<Banji> blist=	  bd.selectByExample(bq);
			    request.setAttribute("blist", blist);	//�༶�б�
		 
			    List<Integer> bids=new ArrayList<>();
			      for(Banji b:blist){
			    	   bids.add(b.getBid());			    	  
			      }
			    
			    
		 
		  ZuoyeQuery  zq=new ZuoyeQuery();
		 zq.createCriteria().andBidIn(bids); 
		  
		  zq.setOrderByClause(" createtime desc");//��ʱ�併����ҵ�г�
		  
		 List<Zuoye> listzy=  zyd.selectByExample(zq);
		 
		 StuzuoyeQuery  mq=new StuzuoyeQuery();
		Criteria cc= mq.createCriteria();
			    if(zuoye!=null&&zuoye.getBanji()!=null&&!"".equals(zuoye.getBanji())){//������id
			    	cc.andBanjiEqualTo(zuoye.getBanji());
			    	request.setAttribute("banji", zuoye.getBanji());
			    } 
			    if(zuoye!=null&&zuoye.getZyid()!=null&&!"".equals(zuoye.getZyid())){
			    	cc.andZyidEqualTo(zuoye.getZyid());
			    	request.setAttribute("zyid", zuoye.getZyid());
			    }  
			    
			    
			    mq.setPageNo(zuoye.getCurrentPage());
			    mq.setPageSize(zuoye.getSize());
			    
			    int count =zd.countByExample(mq); //��ѯ��¼��
			    zuoye.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
			    request.setAttribute("banji", zuoye.getBanji());//ֵ�Ļ���
			    request.setAttribute("zylist", listzy);//��ҵ����
			 List<Stuzuoye> list=  zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showStuzuoye.jsp";
		}
		
	 
	 
	 @RequestMapping("files/showstudentStuzuoye.do")//ѧ���鿴�Լ�����ҵ���
		public  String  showstudentStuzuoye( Stuzuoye   zuoye  ,HttpServletRequest request){
		 Student m=(Student)	request.getSession().getAttribute("dangqianyonghu");
			if(m==null){
				request.setAttribute("message", "<script>alert('��¼��ʱ�����µ�¼')</script>");
				return "../login.jsp";
			}
				 
			    
			    
		 
		  ZuoyeQuery  zq=new ZuoyeQuery();
		  zq.createCriteria().andBidEqualTo(Integer.parseInt(m.getBh())); 
		  zq.setOrderByClause(" createtime desc");//��ʱ�併����ҵ�г� 
		 List<Zuoye> listzy=  zyd.selectByExample(zq);
		 
		 StuzuoyeQuery  mq=new StuzuoyeQuery(); //ѧ����ҵ���
		Criteria cc= mq.createCriteria();
			    	cc.andStidEqualTo(m.getStid());//ѧ���Լ�����Ϣ
			    
			    if(zuoye!=null&&zuoye.getZyid()!=null&&!"".equals(zuoye.getZyid())){
			    	cc.andZyidEqualTo(zuoye.getZyid());
			    	request.setAttribute("zyid", zuoye.getZyid());
			    }   
			    mq.setPageNo(zuoye.getCurrentPage());
			    mq.setPageSize(zuoye.getSize());
			    
			    int count =zd.countByExample(mq); //��ѯ��¼��
			    zuoye.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
			     
			    request.setAttribute("zylist", listzy);//��ҵ����
			 List<Stuzuoye> list=  zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showstudentStuzuoye.jsp";
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
			@RequestMapping("files/addStuzuoye.do")//�����Ϣ
		public  String  addStuzuoye(Stuzuoye  zuoye, @RequestParam("file") MultipartFile file ,@RequestParam("tu") MultipartFile tu ,HttpServletRequest request){
				 
				Student m=(Student)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('��¼��ʱ�����µ�¼!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setStid(m.getStid());//ѧ��id
					zuoye.setCreatetime(new Date());
					zuoye.setBanji(m.getBh());//���ð��
				String path=  request.getSession().getServletContext().getRealPath("/upload");//��ȡ �ļ��е�·��
		         System.out.println("path:::"+path);
		         int x=(int)(Math.random()*999);
		         if(!file.isEmpty()){
		             String fname= file.getOriginalFilename();//��ȡ�ϴ��ļ����� �����Ե�ǰ�û����+��Ŀ���������
                                   
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
		             String fname= tu.getOriginalFilename();//��ȡ�ϴ��ļ����� �����Ե�ǰ�û����+��Ŀ���������
                                  
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
	        request.setAttribute("msg","<script>alert('�����ɹ�!')</script>");
	    }else{
	        request.setAttribute("msg","<script>alert('����ʧ��!')</script>");
	    }
	  //  return "redirect:showStuzuoye.do"; 
	   // return "redirect:showStuzuoye.do"; 
	    return "redirect:showstudentStuzuoye.do";
	    
		} 
			
		 		@RequestMapping("files/toAddStuzuoye.do")//�����Ϣ
			public  String  toAddStuzuoye(Zuoye  zuoye ,HttpServletRequest request){
					  
				Zuoye z=	 zyd.selectByPrimaryKey(zuoye.getZyid());
				request.setAttribute("z", z);//��ӦҪ�ύ��ҵ
		    return "stuzuoyeAdd.jsp"; 
			
			}	  
			
		
			@RequestMapping("files/delStuzuoye.do") //ɾ����Ϣ
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
			@RequestMapping("files/showStuzuoyedetailsocre.do")//�Ϸֲ���
		   	  public String  shangfenshowStuzuoyedetail(Integer stuzyid,HttpServletRequest  request){
					 
					
					Stuzuoye g=    zd.selectByPrimaryKey(stuzyid);
				   		     request.setAttribute("g", g);
				   		     
				   		     return "stuzuoyeUpdatescore123.jsp"; 
				}
			
		 
			
			
			
			@RequestMapping("files/updateStuzuoye.do")//ѧ����¼�����ҵ���޸�
			public String  updateStuzuoye(Stuzuoye  zuoye, @RequestParam("file") MultipartFile file ,@RequestParam("tu") MultipartFile tu ,HttpServletRequest request){ 
				
				Student m=(Student)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('��¼��ʱ�����µ�¼!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setStid(m.getStid());
					 
				String path=  request.getSession().getServletContext().getRealPath("/upload");//��ȡ �ļ��е�·��
		         System.out.println("path:::"+path);
		         int x=(int)(Math.random()*999);
		         if(!file.isEmpty()){
		             String fname= file.getOriginalFilename();//��ȡ�ϴ��ļ����� �����Ե�ǰ�û����+��Ŀ���������
                               
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
		             String fname= tu.getOriginalFilename();//��ȡ�ϴ��ļ����� �����Ե�ǰ�û����+��Ŀ���������
                                  
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
		               request.setAttribute("msg","<script>alert('�����ɹ�!')</script>");
		           }else{
		               request.setAttribute("msg","<script>alert('����ʧ��!')</script>");
		           }
		          /* if(request.getParameter("sf")!=null){
		        	   return "redirect:showStuzuoye.do?zyid="+zuoye.getZyid()+"&banji="+zuoye.getBanji();
		        	   
		           }*/
		           
		           return "redirect:showstudentStuzuoye.do";
			}
			
			
			@RequestMapping("files/teacherupdateStuzuoye.do")//��ʦ��¼�����ҵ���޸�
			public String  teacherupdateStuzuoye(Stuzuoye  zuoye,HttpServletRequest request){ 
				
				Myuser m=(Myuser)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){ 
				        request.setAttribute("msg","<script>alert('��¼��ʱ�����µ�¼!')</script>");
					  return "../login.jsp";
				  }
				
				      
					 
				 
		          
				
				StuzuoyeQuery cq=new StuzuoyeQuery();
				    cq.createCriteria().andStuzyidEqualTo(zuoye.getStuzyid());
				    zuoye.setStuzyid(null);
				  int result=   zd.updateByExampleSelective(zuoye, cq);
		           if(result>0){
		               request.setAttribute("msg","<script>alert('�����ɹ�!')</script>");
		           }else{
		               request.setAttribute("msg","<script>alert('����ʧ��!')</script>");
		           }
		           return "redirect:showStuzuoye.do";
			}
			 
			
			
			@InitBinder
			public void init(WebDataBinder binder) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
			}
   
	
}
