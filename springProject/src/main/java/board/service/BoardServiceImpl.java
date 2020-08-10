package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardPaging boardPaging;

	@Override
	public void boardWrite(Map<String, String> map) {
		
		map.put("id", (String)session.getAttribute("memId"));
		map.put("name", (String)session.getAttribute("memName"));
		map.put("email", (String)session.getAttribute("memEmail"));
		
		boardDAO.boardWrite(map);
		
	}

	@Override
	public List<BoardDTO> getBoardList(String pg) {
		//1페이지당 5개의 글
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return boardDAO.getBoardList(map);
	}

	@Override
	public BoardPaging boardPaging(String pg) {
		int totalA = boardDAO.getBoardTotalA();
		
		boardPaging.setCurrentPage(Integer.parseInt(pg));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		return boardPaging;
	}

	@Override
	public List<BoardDTO> getBoardSearch(Map<String, String> map) {
				//1페이지당 5개의 글
				int endNum = Integer.parseInt(map.get("pg"))*5;
				int startNum = endNum-4;
				
				
				map.put("startNum", startNum+"");
				map.put("endNum", endNum+"");
				
				return boardDAO.getBoardSearch(map);
	}

	@Override
	public BoardPaging boardPaging(Map<String, String> map) {
		
		int totalA = boardDAO.getBoardSearchTotalA(map);//총글수
		
		boardPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		return boardPaging;
	}

	@Override
	public BoardDTO getBoard(String seq) {
		
		return boardDAO.getBoard(seq);
	}

	@Override
	public void boardReply(Map<String, Object> map) {
				//원글
				BoardDTO pDTO = boardDAO.getBoard(map.get("pseq")+"");
				
				//map안에 이미 있는 pseq, pg, subject, content
				map.put("id", (String)session.getAttribute("memId"));
				map.put("name", (String)session.getAttribute("memName"));
				map.put("email", (String)session.getAttribute("memEmail"));
				
				map.put("ref", pDTO.getRef()+"");//원글의 그룹번호
				map.put("lev", pDTO.getLev()+"");//원글lev
				map.put("step", pDTO.getStep()+"");//원글step
				
				boardDAO.boardReply(map);
		
	}

	@Override
	public void boardModify(Map<String, Object> map) {
		boardDAO.boardModify(map);
		
	}

	@Override
	public void boardHit(String seq) {
		boardDAO.boardHit(seq);
		
	}
}
