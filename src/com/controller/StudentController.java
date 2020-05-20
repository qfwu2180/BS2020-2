package com.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.BanjiDao;
import com.dao.MyuserDao;
import com.dao.StudentDao;
import com.dao.StudentDao;
import com.pojo.BanjiQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Student;
import com.pojo.StudentQuery;
import com.pojo.StudentQuery.Criteria;

@Controller
public class StudentController {
    
    @Autowired 
    private StudentDao sd; 
	
  @Autowired
    private BanjiDao bd;
    
    @RequestMapping("files/showStudent.do")
	public  String  showStudent( Student   target  ,HttpServletRequest request){
    	BanjiQuery bq=new BanjiQuery();
    	 bq.createCriteria();
    List blist=	  bd.selectByExample(bq);
    request.setAttribute("blist", blist);	//班级列表
    	StudentQuery  mq=new StudentQuery();
        Criteria  cc=	mq.createCriteria();
		    if(target!=null&&target.getName()!=null&&!"".equals(target.getName())){
		    	cc.andNameLike("%"+target.getName()+"%");
		    }
		    if(target!=null&&target.getBh()!=null&&!"".equals(target.getBh())){
		    	cc.andBhEqualTo(target.getBh());
		    }
		    mq.setPageNo(target.getCurrentPage());
		    mq.setPageSize(target.getSize());
		    
		    int count =sd.countByExample(mq); //查询记录数
		    target.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Student> list= sd.selectByExample(mq);
		 request.setAttribute("pager",target); 
		 request.setAttribute("list", list); 
		
		return "showStudent.jsp";
	}
	
 
		@RequestMapping("files/addStudent.do")//添加信息
	public  String  addStudent(Student  target ,HttpServletRequest request){
			target.setRole("学生");
		 int result=   sd.insertSelective(target);
    if(result>0){
        request.setAttribute("message","<script>alert('操作成功!')</script>");
    }else{
        request.setAttribute("message","<script>alert('操作失败!')</script>");
    }
    return "redirect:showStudent.do"; 
	
	} 

		@RequestMapping("files/toaddStudent.do")//添加信息
	public  String  toaddStudent(Student  target ,HttpServletRequest request){
			BanjiQuery bq=new BanjiQuery();
	    	 bq.createCriteria();
	    List blist=	  bd.selectByExample(bq);
	    request.setAttribute("blist", blist);	//班级列表
			
    return "studentAdd.jsp"; 
	
	} 
		  
		
	
		@RequestMapping("files/delStudent.do") //删除信息
   public String  delStudent(Integer[]  ids ,HttpServletRequest  request){
			if(ids!=null&&ids.length>0){
			
				StudentQuery gq=new StudentQuery();
				   gq.createCriteria().andStidIn(Arrays.asList(ids));
				   sd.deleteByExample(gq);  
			}
			return "redirect:showStudent.do";  
   }
		@RequestMapping("files/showStudentdetail.do")
   	  public String  showOneStudent(Integer stid,HttpServletRequest  request){
			BanjiQuery bq=new BanjiQuery();
	    	 bq.createCriteria();
	    List blist=	  bd.selectByExample(bq);
	    request.setAttribute("blist", blist);	//班级列表
			
			Student g=    sd.selectByPrimaryKey(stid);
		   		     request.setAttribute("g", g);  
		   		     return "studentUpdate.jsp"; 
		}
		
		@RequestMapping("files/updateStudent.do")
		public String  updateStudent(Student  target,HttpServletRequest request){ 
			
			StudentQuery cq=new StudentQuery();
			    cq.createCriteria().andStidEqualTo(target.getStid());
			  int result=   sd.updateByExampleSelective(target, cq);
	           if(result>0){
	               request.setAttribute("message","<script>alert('操作成功!')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('操作失败!')</script>");
	           }
	           return "redirect:showStudent.do";
		}
	  
	
}
