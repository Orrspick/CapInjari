package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

public class MemberSignupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
		 
		ActionForward forward = new ActionForward();
			
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberDTO dto = new MemberDTO();
		dto.setEmail(req.getParameter("email"));
		dto.setPassword(req.getParameter("password"));
		dto.setName(req.getParameter("name"));
		 
		dao.insertData(dto);
		
		forward.setRedirect(true);
		forward.setNextPath("Login.do");
		
		return forward;
	}

}
