package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

public class MemberFormChangeAction implements Action {
	private String form = "Index.jsp?contentPage=member/";
	private String path;
	
	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx)+".jsp";
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		if(path.equals("/injari"))
			forward.setNextPath(path);
		else
			forward.setNextPath(form+path);
		
		return forward;
	}
}
