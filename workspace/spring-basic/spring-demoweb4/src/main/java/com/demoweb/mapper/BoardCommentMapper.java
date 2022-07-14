package com.demoweb.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;
import com.demoweb.dto.BoardComment;

@Mapper
public interface BoardCommentMapper {

	void insertBoardComment(BoardComment boardComment);
	List<BoardComment> selectByBoardNo(int boardNo);
	List<BoardComment> selectRangeByBoardNo(@Param("boardNo")int boardNo, @Param("from")int from, @Param("count")int count);
	int selectCommentCount();
	void delete(int commentNo);
	void update(BoardComment boardComment);
	
	

}