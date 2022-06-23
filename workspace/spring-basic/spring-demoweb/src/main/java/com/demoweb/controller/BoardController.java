package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dto.Board;
import com.demoweb.service.BoardService;
import com.demoweb.service.BoardServiceImpl;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {

	@GetMapping(path = { "/list" })
	public String list() {
		
		return "board/list";  // --> /WEB-INF/views/ + board/list + .jsp
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		return "board/write"; // --> /WEB-INF/views/ + board/write + .jsp
	}
	
	@PostMapping(path = { "/write" })
	public String write(Board board) {
		
		BoardService boardService = new BoardServiceImpl();
		boardService.writeBoard(board);		
		
		// return "redirect:/board/list";
		return "redirect:list"; // 
	}
	
}
