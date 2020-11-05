// MVC (C)
package com.injari.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원관련 컨트롤러
public class MemberController extends HttpServlet {
	
	 static final long serialVersionUID = 1L;
	 
	 
	 @Override
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
	 		throws ServletException, IOException{
		 doProcess(req, resp);
	 }
	 
	 @Override
	 public void doPost(HttpServletRequest req, HttpServletResponse resp)
		 		throws ServletException, IOException{
			 doProcess(req, resp);
		 }
	
	 
	 public void doProcess(HttpServletRequest req, HttpServletResponse resp)
		 		throws ServletException, IOException{
			 
		 String reqURI = req.getRequestURI();
		 //String contextPath = req.getContextPath();
		 int cmdIdx = reqURI.lastIndexOf("/")+1;
		 //String command = reqURI.substring(contextPath.length());
		 String command = reqURI.substring(cmdIdx);
		 
		 ActionForward forward = null;
		 Action action = null;
		 
		 String form = "Index.jsp?contentPage=member/";
		 
		 try {
			if(command.equals("Index.do")) {
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath("Index.jsp");
			}
			else if(command.equals("Login.do")) {
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"Login.jsp");
			}
			else if(command.equals("Signup.do")) {
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"Signup.jsp");
			}
			else if(command.equals("Detailinfo.do")) {
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"Detailinfo.jsp");
			}
			else if(command.equals("Mypage.do")) {
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"Mypage.jsp");
			}
			else if(command.equals("DetailSignup.do")) {
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"DetailSignup.jsp");
			}
			else if(command.equals("MemberLoginAction.do")) // 로그인 처리
            {
                action = new MemberLoginAction();
                forward = action.execute(req, resp);
            }
            else if(command.equals("MemberLogoutAction.do")) // 로그아웃 처리
            {
                action = new MemberLogoutAction();
                forward = action.execute(req, resp);
            }
            else if(command.equals("MemberSignupAction.do")) // 회원가입 처리
            {
                action = new MemberSignupAction();
                forward = action.execute(req, resp);
            }
            else if(command.equals("MemberInfoAction.do")) // 회원정보화면에 보여줄 정보 처리
            {
                action = new MemberInfoAction();
                forward = action.execute(req, resp);
            }
            else if(command.equals("MemberDetailAction.do")) {
            	action = new MemberDetailAction();
                forward = action.execute(req, resp);
            }
            else if(command.equals("MemberDetailupAction.do")) {
            	action = new MemberDetailupAction();
            	forward = action.execute(req, resp);
            }
			
			if(forward != null){
                if (forward.isRedirect()) {
                    resp.sendRedirect(forward.getNextPath());
                } else {
                    RequestDispatcher dispatcher = req
                            .getRequestDispatcher(forward.getNextPath());
                    dispatcher.forward(req, resp);
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		 }
}
