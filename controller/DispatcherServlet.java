package jeonggeun.spring.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeonggeun.spring.web.board.BoardVO;
import jeonggeun.spring.web.board.impl.BoardDAO;
import jeonggeun.spring.web.user.UserVO;
import jeonggeun.spring.web.user.impl.UserDAO;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException{
		
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 2. �����ͺ��̽� ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		// 3. ȭ�� �׺���̼�
		if (user != null) {
			response.sendRedirect("getBoardList.do");
		} else {
			response.sendRedirect("login.jsp");
		}
		
		// 1. Ŭ���̾�Ʈ ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �۾��� �б� �����ش�.
		if (path.equals("/login.do")) {
			System.out.println("�α��� ó��");
		} else if (path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
		} else if (path.equals("/getBoard.do")) {
			System.out.println("�� �� ���� ó��");
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
		}
	}
}