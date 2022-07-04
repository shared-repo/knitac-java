package com.demoweb.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;

@Mapper
public interface BoardMapper {

	@Insert("INSERT board (title, writer, content) " +
			"VALUES (#{title}, #{writer}, #{content})")
	// @Options(useGeneratedKeys = true, keyColumn = "boardno", keyProperty = "boardNo")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()",
			   resultType = Integer.class,
			   keyProperty = "boardNo", 
			   before = false)	
	void insertBoard(Board board);

	@Select("SELECT boardno, title, writer, readcount, regdate, deleted " +
			"FROM board " +
			"ORDER BY boardno DESC")
	List<Board> selectAll();

	@Select("SELECT boardno, title, writer, readcount, regdate, deleted " +
			"FROM board " +
			"ORDER BY boardno DESC " +
			"LIMIT #{from}, #{count}")
	List<Board> selectByRange(HashMap<String, Object> params);

	// 두 개의 테이블에서 데이터 조회 방법 1
	Board selectByBoardNo(int boardNo);
	BoardAttach selectBoardAttachByAttachNo(int attachNo);
	
	// 두 개의 테이블에서 데이터 조회 방법 2 : 중첩 select
	Board selectByBoardNo2(int boardNo);
	// BoardAttach selectBoardAttachByAttachNo2(int attachNo);
	
	// 두 개의 테이블에서 데이터 조회 방법 3 : 중첩 result
	Board selectByBoardNo3(int boardNo);

	void delete(int boardNo);

	void update(Board board);

	int selectBoardCount();

	void insertBoardAttach(BoardAttach attach);

	List<BoardAttach> selectBoardAttachByBoardNo(int boardNo);

	

	void updateBoardReadCount(int boardNo);

}