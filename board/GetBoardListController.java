package jeonggeun.spring.web.board;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jeonggeun.spring.web.controller.Controller;
import jeonggeun.spring.web.board.impl.BoardDAO;
public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		// 1. 사용자 입력 정보 추출 : 검색 기능은 나중에 구현
		// 2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		// 3. 응답 화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
		 }

}
