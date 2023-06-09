package jeonggeun.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jeonggeun.spring.web.controller.Controller;
public class LogoutController implements Controller {

	@Override
	 public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("로그아웃 처리");
	// 1. 브라우저와 연결된 세션 객체를 종료
	HttpSession session = request.getSession(false);
	session.invalidate();
	// 2. 세션 종료 후 메인 화면으로 이동
	return "login";
	 }

}
