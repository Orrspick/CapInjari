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
		MemberDTO dto = (MemberDTO)req.getAttribute("memberInfo");
		
		ddto.setUid(dto.getUid());
		ddto.setGender(req.getParameter("gender"));
		ddto.setPhone(req.getParameter("phone"));
		ddto.setAddress(req.getParameter("address"));
		ddto.setMajor(req.getParameter("major"));
		ddto.setCareer(Integer.parseInt(req.getParameter("career")));
		ddto.setCareer_year(req.getParameter("career_year"));
		
		dao.InsertDetailMember(ddto);
		
		forward.setRedirect(false);
		forward.setNextPath("Index.do");
		
		return forward;
	}

}