package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TDirectorDAO;
import com.dao.TUserDAO;
import com.model.TAdmin;
import com.model.TDirector;
import com.model.TUser;

public class loginService {
	private TAdminDAO adminDAO;

	private TDirectorDAO directorDAO;

	private TUserDAO userDAO;

	public TAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String login(String userName, String userPw, int userType) {
		System.out.println("userType" + userType);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "no";

		if (userType == 1)//系统管理员登陆
		{
			String sql = "from TAdmin where userName=? and userPw=?";
			Object[] con = { userName, userPw };
			List adminList = adminDAO.getHibernateTemplate().find(sql, con);
			if (adminList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TAdmin admin = (TAdmin) adminList.get(0);
				session.setAttribute("userType", userType);
				session.setAttribute("admin", admin);
				result = "yes";
			}
		}
		if (userType == 2)//业务主管登陆
		{
			String sql = "from TDirector where userName=? and userPw=?";
			Object[] con = { userName, userPw };
			List directorList = adminDAO.getHibernateTemplate().find(sql, con);
			if (directorList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TDirector director = (TDirector) directorList.get(0);
				TAdmin admin = new TAdmin();
				admin.setUserId(director.getUserId());
				admin.setUserName(director.getUserName());
				admin.setUserPw(director.getUserPw());
				session.setAttribute("userType", userType);
				session.setAttribute("admin", admin);
				result = "yes";
			}
		}
		if (userType == 3)//学生登陆
		{

		}
		return result;
	}

	public String adminPwEdit(String userPwNew) {
		//System.out.println("DDDD");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();
		if (session.getAttribute("userType").toString().equals("1")) {
			TAdmin admin = (TAdmin) session.getAttribute("admin");
			admin.setUserPw(userPwNew);
			adminDAO.getHibernateTemplate().update(admin);
			session.setAttribute("admin", admin);
		}
		if (session.getAttribute("userType").toString().equals("2")) {
			TAdmin admin = (TAdmin) session.getAttribute("admin");
			admin.setUserPw(userPwNew);
			TDirector director = new TDirector();
			director = directorDAO.findById(admin.getUserId());
			director.setUserPw(userPwNew);
			directorDAO.getHibernateTemplate().update(director);
			session.setAttribute("admin", admin);
		}
		return "yes";
	}

	public String jiance(String userName) {
		//System.out.println("DDDD");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "from TUser where userName='" + userName + "'";
		List list = userDAO.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			return "no";
		} else {
			return "yes";
		}
	}

	public TDirectorDAO getDirectorDAO() {
		return directorDAO;
	}

	public void setDirectorDAO(TDirectorDAO directorDAO) {
		this.directorDAO = directorDAO;
	}

}
