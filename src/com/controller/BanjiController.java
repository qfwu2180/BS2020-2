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
import com.pojo.Banji;
import com.pojo.BanjiQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Student;
import com.pojo.StudentQuery;

@Controller
public class BanjiController {
    @Autowired
	private BanjiDao  md;
    
    @Autowired
    private MyuserDao sd;
	 
    
    
    @RequestMapping("files/showBanji.do")
	public  String  showEmployee( Banji   banji  ,HttpServletRequest request){
    	BanjiQuery  mq=new BanjiQuery();
		    if(banji!=null&&banji.getBh()!=null&&!"".equals(banji.getBh())){
		    	mq.createCriteria().andBhLike("%"+banji.getBh()+"%");
		    }
		    mq.setPageNo(banji.getCurrentPage());
		    mq.setPageSize(banji.getSize());
		    
		    int count =md.countByExample(mq); //查询记录数
		    banji.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Banji> list=  md.selectByExample(mq);
		 request.setAttribute("pager",banji); 
		 request.setAttribute("list", list); 
		
		return "showBanji.jsp";
	}
	
 
		@RequestMapping("files/addBanji.do")//添加信息
	public  String  addBanji(Banji  banji ,HttpServletRequest request){
		 
		 int result=   md.insertSelective(banji);
    if(result>0){
        request.setAttribute("message","<script>alert('操作成功!')</script>");
    }else{
        request.setAttribute("message","<script>alert('操作失败!')</script>");
    }
    return "redirect:showBanji.do"; 
	
	}
		 
		
		@RequestMapping("files/toaddBanji.do")//添加信息
		public  String  toaddBanji(Banji  banji ,HttpServletRequest request){
		MyuserQuery  mq= new MyuserQuery();
		 mq.createCriteria();
			List<Myuser > list=   sd.selectByExample(mq);
			request.setAttribute("list", list);
		return  "banjiAdd.jsp";
		}
		
	
		@RequestMapping("files/delBanji.do") //删除信息
   public String  delBanji(Integer[]  ids ,HttpServletRequest  request){
			if(ids!=null&&ids.length>0){
			
				BanjiQuery gq=new BanjiQuery();
				   gq.createCriteria().andBidIn(Arrays.asList(ids));
				   md.deleteByExample(gq);  
			}
			return "redirect:showBanji.do";  
   }
		@RequestMapping("files/showBanjidetail.do")
   	  public String  showOneBanji(Integer uid,HttpServletRequest  request){
			MyuserQuery  mq= new MyuserQuery();
			 mq.createCriteria();
				List<Myuser > list=   sd.selectByExample(mq);
				request.setAttribute("list", list);
			
			Banji g=    md.selectByPrimaryKey(uid);
		   		     request.setAttribute("g", g);  
		   		     return "banjiUpdate.jsp"; 
		}
		
		@RequestMapping("files/updateBanji.do")
		public String  updateBanji(Banji  banji,HttpServletRequest request){ 
			
			BanjiQuery cq=new BanjiQuery();
			    cq.createCriteria().andBidEqualTo(banji.getBid());
			  int result=   md.updateByExampleSelective(banji, cq);
	           if(result>0){
	               request.setAttribute("message","<script>alert('操作成功!')</script>");
	           }else{
	               request.setAttribute("message","<script>alert('操作失败!')</script>");
	           }
	           return "redirect:showBanji.do";
		}
	 
	 
    
		
    
 
	
	
}
