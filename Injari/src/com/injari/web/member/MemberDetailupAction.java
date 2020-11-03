package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDetailupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		 
		ActionForward forward = new ActionForward();
		
		MemberDAO dao = MemberDAO.getInstance();
		DetailMemberDTO ddto = new DetailMemberDTO();
		return null;
	}

}
