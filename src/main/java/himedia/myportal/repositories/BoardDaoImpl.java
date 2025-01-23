package himedia.myportal.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.BoardDaoException;
import himedia.myportal.mappers.BoardMapper;
import himedia.myportal.repositories.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;
//	@Autowired 
//	SqlSession sqlSession;
	
	@Override
	public List<BoardVo> selectAll() {
//		List<BoardVo> list = sqlSession.selectList("board.selectAll");
		List<BoardVo> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public int insert(BoardVo boardVo) {
		int insertedCount = 0;
		try {
			insertedCount = boardMapper.insert(boardVo);
			return insertedCount;
		} catch (Exception e) {
			throw new BoardDaoException("게시물 삽입 중 예외 발생", boardVo);
		}
		
		// 스프링 프레임워크에서 사용할 때 
		/*
		try {
			return sqlSession.insert("board.insert", boardVo);
		} catch (Exception e) {
			throw new BoardDaoException("게시물 삽입 중 예외 발생", boardVo);
		}
		*/
	}

	@Override
	public BoardVo getContent(Integer no) {
	
		boardMapper.increaseHitCount(no);
		BoardVo vo = boardMapper.getContent(no);
		
		return vo;
		
		/*
		sqlSession.update("board.increaseHitCount", no);
		BoardVo vo = sqlSession.selectOne("board.getContent", no);
		return vo;
		*/
	}

	@Override
	public int update(BoardVo boardVo) {
		
		int updatedCount = boardMapper.update(boardVo);
		return updatedCount;
		
		/*
		int updatedCount = 
			sqlSession.update("board.update", boardVo);
		return updatedCount;
		*/
	}

	@Override
	public int delete(Integer no, Integer userNo) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("no", no);
		map.put("userNo", userNo);
		
		return boardMapper.delete(map);
		
		
		/*
		Map<String, Integer> map = new HashMap<>();
		map.put("no", no);
		map.put("userNo", userNo);
		
		return sqlSession.delete("board.delete", map);
		*/
	}

}
