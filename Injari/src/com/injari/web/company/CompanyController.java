package com.injari.web.company;

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
import com.injari.web.member.MemberFormChangeAction;

public class CompanyController extends HttpServlet {
	 static final long serialVersionUID = 1L;
	 private HashMap<String, Action> commandMap;
	 
	 public void init(ServletConfig config) throws ServletException{
		 loadProperties("com/injari/web/properties/CompanyAction");
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
                 if(className.equals("com.injari.web.company.CompanyFormChangeAction")){
                     CompanyFormChangeAction cf = (CompanyFormChangeAction)actionInstance;
                     cf.setCommand(command);
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
		 
		 
		 try {
	            // 맵에서 명령어에 해당하는 Action을 가져온다.
	            action = commandMap.get(command);
	            
	            if (action == null) {
	                System.out.println("명령어 : "+command+"는 잘못된 명령입니다.");
	                return;
	            }
	 
	            forward = action.execute(req, resp);
	            
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
