package jeonggeun.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jeonggeun.spring.web.controller.Controller;
import jeonggeun.spring.web.board.impl.BoardDAO;
public class DeleteBoardController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
		// 1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq");
		// 2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		// 3. 화면 네비게이션
		return "getBoardList.do";
		 }

}
