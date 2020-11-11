// MVC (C)
package com.injari.web.member;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.injari.web.action.Action;
import com.injari.web.action.ActionForward;

//회원관련 컨트롤러
public class MemberController extends HttpServlet {
	
	 static final long serialVersionUID = 1L;
	 private HashMap<String, Action> commandMap;
	 
	 public void init(ServletConfig config) throws ServletException{
		 loadProperties("com/injari/web/properties/MemberAction");
	 }


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
	 
	 private void loadProperties(String filePath) {
		 commandMap = new HashMap<String, Action>();
		 
		 ResourceBundle rb = ResourceBundle.getBundle(filePath);
		 Enumeration<String> actionEnum = rb.getKeys();
		 
		 while(actionEnum.hasMoreElements()) {
			 String command = actionEnum.nextElement();
			 String className = rb.getString(command);
			 
			 try {
                 Class actionClass = Class.forName(className); // 클래스 생성
                 Action actionInstance = (Action)actionClass.newInstance();
                 
                 // 화면전환 Action 인지 확인한다. 화면전환 Action이면 명령어를 전달한다.
                 if(className.equals("com.injari.web.member.MemberFormChangeAction")){
                     MemberFormChangeAction mf = (MemberFormChangeAction)actionInstance;
                     mf.setCommand(command);
                 }
                 
                 // 맵에 명령어와 Action을 담는다.
                 commandMap.put(command, actionInstance);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
			 
		 }
		}
	
	 
	 
	 
	 public void doProcess(HttpServletRequest req, HttpServletResponse resp)
		 		throws ServletException, IOException{
			 
		 String reqURI = req.getRequestURI();
		 int cmdIdx = reqURI.lastIndexOf("/")+1;
		 String command = reqURI.substring(cmdIdx);
		 
		 ActionForward forward = null;
		 Action action = null;
		 
		 //String form = "Index.jsp?contentPage=member/";
		 
		 try {
	            // 맵에서 명령어에 해당하는 Action을 가져온다.
	            action = commandMap.get(command);
	            
	            if (action == null) {
	                System.out.println("명령어 : "+command+"는 잘못된 명령입니다.");
	                return;
	            }
	 
	            forward = action.execute(req, resp);
	            
	            /*
	             * 화면이동 - isRedirext() 값에 따라 sendRedirect 또는 forward를 사용
	             * sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
	             * forward : 현재 실행중인 페이지와 forwad에 의해 호출될 페이지는 request와 response 객체를 공유
	             */
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
		 
			/*
			 * try { if(command.equals("Index.do")) { forward=new ActionForward();
			 * forward.setRedirect(false); forward.setNextPath("Index.jsp"); } else
			 * if(command.equals("Login.do")) { forward=new ActionForward();
			 * forward.setRedirect(false); forward.setNextPath(form+"Login.jsp"); } else
			 * if(command.equals("Signup.do")) { forward=new ActionForward();
			 * forward.setRedirect(false); forward.setNextPath(form+"Signup.jsp"); } else
			 * if(command.equals("Detailinfo.do")) { forward=new ActionForward();
			 * forward.setRedirect(false); forward.setNextPath(form+"Detailinfo.jsp"); }
			 * else if(command.equals("Mypage.do")) { forward=new ActionForward();
			 * forward.setRedirect(false); forward.setNextPath(form+"Mypage.jsp"); } else
			 * if(command.equals("DetailSignup.do")) { forward=new ActionForward();
			 * forward.setRedirect(false); forward.setNextPath(form+"DetailSignup.jsp"); }
			 * else if(command.equals("MemberLoginAction.do")) // 로그인 처리 { action = new
			 * MemberLoginAction(); forward = action.execute(req, resp); } else
			 * if(command.equals("MemberLogoutAction.do")) // 로그아웃 처리 { action = new
			 * MemberLogoutAction(); forward = action.execute(req, resp); } else
			 * if(command.equals("MemberSignupAction.do")) // 회원가입 처리 { action = new
			 * MemberSignupAction(); forward = action.execute(req, resp); } else
			 * if(command.equals("MemberInfoAction.do")) // 회원정보화면에 보여줄 정보 처리 { action = new
			 * MemberInfoAction(); forward = action.execute(req, resp); } else
			 * if(command.equals("MemberDetailAction.do")) { action = new
			 * MemberDetailAction(); forward = action.execute(req, resp); } else
			 * if(command.equals("MemberDetailupAction.do")) { action = new
			 * MemberDetailupAction(); forward = action.execute(req, resp); }
			 * 
			 * if(forward != null){ if (forward.isRedirect()) {
			 * resp.sendRedirect(forward.getNextPath()); } else { RequestDispatcher
			 * dispatcher = req .getRequestDispatcher(forward.getNextPath());
			 * dispatcher.forward(req, resp); } } } catch (Exception e) {
			 * e.printStackTrace(); }
			 */
		 
		 
		 }
}
