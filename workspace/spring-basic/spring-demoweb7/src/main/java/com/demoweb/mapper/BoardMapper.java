package com.demoweb.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

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
	@Select("SELECT boardno, title, content, writer, readcount, regdate " + 
			"FROM board " +
			"WHERE boardno = #{ boardNo } AND deleted = FALSE")
	Board selectByBoardNo(int boardNo);
	@Select("SELECT attachno, boardno, userfilename, savedfilename " + 
			"FROM boardattach " +
			"WHERE boardno = #{ boardNo }")
	List<BoardAttach> selectBoardAttachByBoardNo(int boardNo);
	
	// 두 개의 테이블에서 데이터 조회 방법 2 : 중첩 select
	@Select("SELECT boardno, title, content, writer, readcount, regdate " + 
			"FROM board " +
			"WHERE boardno = #{ boardNo } AND deleted = FALSE")
	@Results({
		@Result(id = true, column = "boardno", property = "boardNo"),
		@Result(column = "title", property = "title"),
		@Result(column = "writer", property = "writer"),
		@Result(column = "content", property = "content"),
		@Result(column = "readcount", property = "readCount"),
		@Result(column = "regdate", property = "regDate"),
		@Result(column = "boardno", property = "files",
				many = @Many(select = "selectBoardAttachByBoardNo2"))
	})	
	Board selectByBoardNo2(int boardNo);
	
	@Select("SELECT attachno, boardno, userfilename, savedfilename " + 
			"FROM boardattach " +
			"WHERE boardno = #{ boardNo }")
	List<BoardAttach> selectBoardAttachByBoardNo2(int boardNo);
	
	// 두 개의 테이블에서 데이터 조회 방법 3 : 중첩 result
	@Select("SELECT b.boardno, b.title, b.writer, b.content, b.readcount, b.regdate, " + 
			"		ba.attachno, ba.userfilename, ba.savedfilename, ba.downloadcount " +
			"FROM board b " +
			"LEFT OUTER JOIN boardattach ba " +
			"ON b.boardno = ba.boardno " +
			"WHERE b.boardno = #{boardNo} AND b.deleted = FALSE")
	@Results({
		@Result(id = true, column = "boardno", property = "boardNo"),
		@Result(column = "title", property = "title"),
		@Result(column = "writer", property = "writer"),
		@Result(column = "content", property = "content"),
		@Result(column = "readcount", property = "readCount"),
		@Result(column = "regdate", property = "regDate"),
		@Result(column = "boardno", property = "files",
				many = @Many(resultMap = "boardAttachResultMap3"))
	})
	Board selectByBoardNo3(int boardNo);
	
	@Results(id = "boardAttachResultMap3", value = {
		@Result(id = true, column = "attachno", property = "attachNo"),
		@Result(column = "boardno", property = "boardNo"),
		@Result(column = "userfilename", property = "userFileName"),
		@Result(column = "savedfilename", property = "savedFileName"),
		@Result(column = "downloadcount", property = "downloadCount")
	})
	@Select("SELECT attachno, boardno, userfilename, savedfilename " + 
			"FROM boardattach " +
			"WHERE boardno = #{ boardNo }")
	List<BoardAttach> selectBoardAttachByBoardNo3(int boardNo);

	@Delete("UPDATE board " +
			"SET deleted = TRUE " +
			"WHERE boardno = #{ boardNo }")
	void delete(int boardNo);

	@Update("UPDATE board " +
			"SET title = #{ title }, content = #{ content } " +
			"WHERE boardno = #{ boardNo }")
	void update(Board board);


	@Select("SELECT COUNT(*) FROM board")
	int selectBoardCount();

	@Insert("INSERT INTO boardattach (boardno, savedfilename, userfilename) " +
			"VALUES (#{ boardNo }, #{ savedFileName }, #{ userFileName })")
	@Options(useGeneratedKeys = true, keyColumn = "attachno", keyProperty = "attachNo")
	void insertBoardAttach(BoardAttach attach);

	@Select("SELECT attachno, boardno, userfilename, savedfilename " + 
			"FROM boardattach " +
			"WHERE attachno = #{ attachNo }")
	BoardAttach selectBoardAttachByAttachNo(int attachNo);

	@Update("UPDATE board " + 
			"SET readcount = readcount + 1 " +
			"WHERE boardno = #{ boardNo }")
	void updateBoardReadCount(int boardNo);

}