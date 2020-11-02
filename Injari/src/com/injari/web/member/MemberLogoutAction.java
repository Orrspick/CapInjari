package com.injari.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		
		// 로그아웃시 세션정보를 모두 삭제한다.
		req.getSession().invalidate();
		
		// 로그아웃 후 메인화면으로 돌아간다.
		forward.setRedirect(true);
		forward.setNextPath("Index.do");
		
		return forward;
	}

}
