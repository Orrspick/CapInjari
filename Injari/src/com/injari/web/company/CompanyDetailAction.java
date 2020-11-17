package com.injari.web.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

public class CompanyDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int companynum = Integer.parseInt(req.getParameter("cid"));
		
		CompanyDAO dao = CompanyDAO.getInstance();
		CompanyDTO dto = dao.getDetail(companynum);
		
		req.setAttribute("detailinfo", dto);
		
		forward.setRedirect(false);
		forward.setNextPath("Company.cop");
		
		return forward;
	}
		
		
}
