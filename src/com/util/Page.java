package com.util;

public class Page {
	private int size=10;//姣忛〉鏉℃暟
	private int currentPage=1;//褰撳墠椤垫暟
	private int totalCount=0;//鎬绘潯鏁�
	private int totalPage=0;//鎬婚〉鏁�

	//涓婁竴椤�
	public int getPrePage(){
		if(currentPage-1<1){
			return 1;
		} else{
			return currentPage-1;
		}
	}
	//涓嬩竴椤�
	//${xx.prePage}
	public int getNextPage(){
		if(currentPage+1>totalPage){
			return  totalPage;
		}else{
			return currentPage+1;
		}
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//璁＄畻 鎬婚〉鏁�
		if(this.totalCount%size==0){
			totalPage=totalCount/size;
		}else{
			totalPage=totalCount/size+1;
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}








}
