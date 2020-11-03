package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다
		HttpSession session = req.getSession();
		String id = session.getAttribute("sessionEmail").toString();
		
		// 그 아이디 해당하는 회원정보를 가져온다.
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO member = dao.getUserInfo(id);
		
		req.setAttribute("memberInfo", member);
		
		if(member.getAuthority() == 1) {
			forward.setRedirect(false);
			forward.setNextPath("Index.do");
		}
		else if(member.getAuthority() == 0) {
			forward.setRedirect(false);
			forward.setNextPath("Index.do");
		}
			
		return forward;
	}

}
