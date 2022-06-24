package com.demoweb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.demoweb.common.Util;
import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;
import com.demoweb.service.BoardService;
import com.demoweb.ui.ThePager;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;

	@GetMapping(path = { "/list" })
	public String list(@RequestParam(defaultValue = "1")int pageNo, 
					   Model model) {
		
		int pageSize = 3; // 한 페이지에 표시할 데이터 개수
		int pagerSize = 3; // 표시되는 페이지 번호 개수 ( 보이지 않은 페이지 번호는 다음, 이전 등으로 표시 )
		int count = 0; // 전체 데이터 개수	
		
		// List<Board> boardList = boardService.findAll();
		List<Board> boardList = boardService.findByPage(pageNo, pageSize);		
		count = boardService.findBoardCount(); // 데이터베이스에 전체 개시물 개수 조회	
		
		ThePager pager = new ThePager(count, pageNo, pageSize, pagerSize, "list");		
		
		// Model 타입의 전달인자에 데이터를 저장하면 View(JSP)로 데이터가 전달됩니다. ( request에 저장 )
		model.addAttribute("boardList", boardList);
		model.addAttribute("pager", pager);
		model.addAttribute("pageNo", pageNo);
		
		return "board/list";  // --> /WEB-INF/views/ + board/list + .jsp
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		return "board/write"; // --> /WEB-INF/views/ + board/write + .jsp
	}
	
	@PostMapping(path = { "/write" })
	public String write(Board board,
						MultipartFile[] attach,
						HttpServletRequest req) {
		
		// getRealPath : 웹경로 -> 컴퓨터 경로
		//               http:// ..... /a/b/c ---> C:\......\a\b\c
		String uploadDir = req.getServletContext().getRealPath("/resources/upload-files");
		
		ArrayList<BoardAttach> files = new ArrayList<>();
		for (MultipartFile file : attach) {
			BoardAttach f = new BoardAttach();
			String userFileName = file.getOriginalFilename();
			String savedFileName = Util.makeUniqueFileName(userFileName); 
			f.setUserFileName(userFileName);
			f.setSavedFileName(savedFileName);
			try {
				File path = new File(uploadDir, savedFileName);
				file.transferTo(path); // 파일 저장
				files.add(f);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		board.setFiles(files);
		boardService.writeBoard(board);		
		
		// return "redirect:/board/list";
		return "redirect:list"; // 
	}
	
	@GetMapping(path = { "/detail" })
	public String detail(@RequestParam(name="boardno", defaultValue = "-1")int boardNo, 
						 @RequestParam(name="pageNo", defaultValue = "-1")int pageNo,
						 Model model) {
		
		if (boardNo == -1 || pageNo == -1) {
			return "redirect:list";
		}
		
		Board board = boardService.findByBoardNo(boardNo);
		if (board == null) { // 해당 번호의 게시글이 없는 경우
			return "redirect:list";
		}
		
		model.addAttribute("board", board);
		model.addAttribute("pageNo", pageNo);
		
		return "board/detail";
	}
	
	@GetMapping(path = { "/download" })
	public String download(
			@RequestParam(name = "attachno", defaultValue = "-1") int attachNo) {
		
		if (attachNo < 1) {
			return "redirect:list";
		}
		
		BoardAttach boardAttach = boardService.findBoardAttachByAttachNo(attachNo);
		
		return "";
	}
	
}















