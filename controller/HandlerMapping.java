package jeonggeun.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import jeonggeun.spring.web.board.DeleteBoardController;
import jeonggeun.spring.web.board.GetBoardController;
import jeonggeun.spring.web.board.GetBoardListController;
import jeonggeun.spring.web.board.InsertBoardController;
import jeonggeun.spring.web.board.UpdateBoardController;
import jeonggeun.spring.web.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
