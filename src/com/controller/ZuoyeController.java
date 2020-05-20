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
		request.setAttribute("message", "<script>alert('��¼��ʱ�����µ�¼')</script>");
		return "../login.jsp";
	}
		 //ֻ�ܲ�ѯ��ǰ��ʦ�İ༶��Ϣ
		 BanjiQuery bq=new BanjiQuery();
	    	 bq.createCriteria().andTidEqualTo(m.getUid());
	    List blist=	  bd.selectByExample(bq);
	    request.setAttribute("blist", blist);	//�༶�б�
		 
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
			    
			    int count =zd.countByExample(mq); //��ѯ��¼��
			    zuoye.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
			    
			 List<Zuoye> list= zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showZuoye.jsp";
		}
	 
	 
	 @RequestMapping("files/showmyseeZuoye.do")
		public  String  showstuZuoye( Zuoye   zuoye  ,HttpServletRequest request){
		 Student m=(Student)	request.getSession().getAttribute("dangqianyonghu");
	if(m==null){
		request.setAttribute("message", "<script>alert('��¼��ʱ�����µ�¼')</script>");
		return "../login.jsp";
	}
	 
	    
	    zuoye.setBid(Integer.parseInt(m.getBh()));//�Լ����
		 
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
			    
			    int count =zd.countByExample(mq); //��ѯ��¼��
			    zuoye.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
			    
			 List<Zuoye> list= zd.selectByExample(mq);
			 request.setAttribute("pager",zuoye); 
			 request.setAttribute("list", list); 
			
			return "showmyseeZuoye.jsp";
		}
	 
	 
		
	 
			@RequestMapping("files/addZuoye.do")//�����Ϣ
		public  String  addZuoye(Zuoye  zuoye, @RequestParam("file") MultipartFile file ,@RequestParam("daanfile") MultipartFile daanfile,@RequestParam("tu") MultipartFile tu ,HttpServletRequest request){
				 
				Myuser m=(Myuser)request.getSession().getAttribute("dangqianyonghu");
				  if(m==null){

				        request.setAttribute("msg","<script>alert('��¼��ʱ�����µ�¼!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setTid(m.getUid());//��ǰ��¼�Ľ�ʦ��������ҵ
					zuoye.setCreatetime(new Date());
					zuoye.setKemu(m.getKemu());
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
		         
		         if(!daanfile.isEmpty()){
		             String fname= daanfile.getOriginalFilename();//��ȡ�ϴ��ļ����� �����Ե�ǰ�û����+��Ŀ���������
                                  
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
	    return "redirect:showZuoye.do"; 
		
		} 
			
	 		@RequestMapping("files/toAddZuoye.do")//�����Ϣ
			public  String  toAddZuoye(Zuoye  course ,HttpServletRequest request){
	 			Myuser m=(Myuser)	request.getSession().getAttribute("dangqianyonghu");
	 			if(m==null){
	 				request.setAttribute("message", "<script>alert('��¼��ʱ�����µ�¼')</script>");
	 				 return "../login.jsp";
	 			}
	 				 //ֻ�ܲ�ѯ��ǰ��ʦ�İ༶��Ϣ
	 				 BanjiQuery bq=new BanjiQuery();
	 			    	 bq.createCriteria().andTidEqualTo(m.getUid());
	 			    List blist=	  bd.selectByExample(bq);
	 			    request.setAttribute("blist", blist);	//�༶�б�
				
				
		    return "zuoyeAdd.jsp"; 
			
			}	  
			
		
			@RequestMapping("files/delZuoye.do") //ɾ����Ϣ
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

				        request.setAttribute("msg","<script>alert('��¼��ʱ�����µ�¼!')</script>");
					  return "../login.jsp";
				  }
				
				    zuoye.setTid(m.getUid());
					 
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
		         
		         if(!daanfile.isEmpty()){
		             String fname= daanfile.getOriginalFilename();//��ȡ�ϴ��ļ����� �����Ե�ǰ�û����+��Ŀ���������
                                
		               if(fname.lastIndexOf("\\")!=-1){
		                 fname=fname.substring(fname.lastIndexOf("\\")+1);
		               }
		             System.out.println("fname"+x+fname);
		             File f=new File(path+"\\"+x+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
		      
	 
		
				
				ZuoyeQuery cq=new ZuoyeQuery();
				    cq.createCriteria().andZyidEqualTo(zuoye.getZyid());
				  int result=   zd.updateByExampleSelective(zuoye, cq);
		           if(result>0){
		               request.setAttribute("msg","<script>alert('�����ɹ�!')</script>");
		           }else{
		               request.setAttribute("msg","<script>alert('����ʧ��!')</script>");
		           }
		           return "redirect:showZuoye.do";
			}
			
			
			 
			
			
			@InitBinder
			public void init(WebDataBinder binder) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
			}
   
	
}
