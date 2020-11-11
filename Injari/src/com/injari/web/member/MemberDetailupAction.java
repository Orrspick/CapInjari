package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

public class MemberDetailupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		 
		ActionForward forward = new ActionForward();
		HttpSession session = req.getSession();
		
		MemberDAO dao = MemberDAO.getInstance();
		DetailMemberDTO ddto = new DetailMemberDTO();
		int uid = (int) session.getAttribute("uid");
		
		ddto.setUid(uid);
		ddto.setGender(req.getParameter("gender"));
		ddto.setPhone(req.getParameter("phone"));
		ddto.setAddress(req.getParameter("address"));
		ddto.setMajor(req.getParameter("major"));
		ddto.setCareer(req.getParameter("career"));
		ddto.setCareer_year(Integer.parseInt(req.getParameter("career_year")));
		
		dao.InsertDetailMember(ddto);
		
		forward.setRedirect(true);
		forward.setNextPath("MemberInfoAction.do");
		
		return forward;
	}

}
