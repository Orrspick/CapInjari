package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session=req.getSession();
		
		// 이메일과 비밀번호를 가져온다.
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// DB에서 이메일, 비밀번호 확인
		MemberDAO dao = MemberDAO.getInstance();
		int check = dao.loginCheck(email, password);
		
		if(check == 0)	// 비밀번호 틀릴경우 -> 다시 로그인 화면으로 이동
		{ 
			// 로그인 실패시 메시지를 request에 담는다.
	   		req.setAttribute("fail", "0");
	   		
	   		forward.setRedirect(false);
	   		forward.setNextPath("Login.do");
		}
		else if(check == -1) // 아이디가 없을 경우 -> 다시 로그인 화면으로 이동
		{
			req.setAttribute("fail", "-1");

	   		forward.setRedirect(false);
	   		forward.setNextPath("Login.do");
		}
		else
		{
			//로그인 성공 -> 세션에 아이디, 상태 저장
	   		session.setAttribute("sessionEmail", email);
	   		
	   		// 로그인 성공후 메인화면으로 이동
	   		forward.setRedirect(true);
	   		forward.setNextPath("MemberInfoAction.do");
		}
   		
		return forward;
	}

}
