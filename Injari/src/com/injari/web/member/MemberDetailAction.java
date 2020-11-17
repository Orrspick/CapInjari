package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("uid"); 
		
		// 그 아이디 해당하는 회원정보를 가져온다.
		MemberDAO dao = MemberDAO.getInstance();
		DetailMemberDTO dmember = dao.getDetailUser(uid);
		
		session.setAttribute("gender", dmember.getGender());
		session.setAttribute("phone", dmember.getPhone());
		session.setAttribute("address", dmember.getAddress());
		session.setAttribute("major", dmember.getMajor());
		session.setAttribute("career", dmember.getCareer());
		session.setAttribute("career_year", dmember.getCareer_year());
				
		forward.setRedirect(true);
		forward.setNextPath("/Injari");
		
		return forward;
	}

}
