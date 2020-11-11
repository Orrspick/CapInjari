package com.injari.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MVC 패턴을 위한 추가)

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
	throws Exception;
}
