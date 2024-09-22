package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.dao.TDirectorDAO;
import com.model.TDirector;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class directorAction extends ActionSupport
{
	private int userId;
	private String userName;
	private String userPw;
	private String userRealName;
	private String userTel;
	private String message;
	private String path;
	
	private int index=1;

	private TDirectorDAO directorDAO;
	
	
	public String directorAdd()
	{
		TDirector director=new TDirector();
		director.setUserName(userName);
		director.setUserPw(userPw);
		director.setUserRealName(userRealName);
		director.setUserTel(userTel);
		directorDAO.save(director);
		this.setMessage("操作成功");
		this.setPath("directorManage.action");
		return "succeed";
	}
	
	
	
	public String directorManage()
	{
		List directorList=directorDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("directorList", directorList);
		return ActionSupport.SUCCESS;
	}
	
	public String directorManageFenye()
	{
		List directorList=directorDAO.findAll();
		int pageSize=3;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, directorList.size());
		List directorListFenye = directorList.subList(fromIndex, toIndex);
		

        Pagination p = new Pagination();//创建 分页对象
        p.setIndex(index);//设置页数
        p.setPageSize(pageSize);
        p.setTotle(directorList.size());//设置总共的条数
        p.setData(directorListFenye);//设置数据
        p.setPath("directorManageFenye.action?");//跳转的路径

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	public String directorDel()
	{
		directorDAO.delete(directorDAO.findById(userId));
		this.setMessage("删除成功");
		this.setPath("directorManage.action");
		return "succeed";
	}
	
	

	

	public TDirectorDAO getdirectorDAO() {
		return directorDAO;
	}



	public void setdirectorDAO(TDirectorDAO directorDAO) {
		this.directorDAO = directorDAO;
	}



	public String getMessage()
	{
		return message;
	}

	public int getIndex()
	{
		return index;
	}



	public void setIndex(int index)
	{
		this.index = index;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}



	public TDirectorDAO getDirectorDAO() {
		return directorDAO;
	}



	public void setDirectorDAO(TDirectorDAO directorDAO) {
		this.directorDAO = directorDAO;
	}



	public String getUserRealName() {
		return userRealName;
	}



	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}



	public String getUserTel() {
		return userTel;
	}



	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	 
}
