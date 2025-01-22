package himedia.myportal.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import himedia.myportal.repositories.vo.BoardVo;

@Mapper
public interface BoardMapper {
//	<select id="selectAll"
//			resultType="boardVo">
	List<BoardVo> selectAll();
//	<insert id="insert" parameterType="boardVo">
	int insert(BoardVo vo);
//	<update id="increaseHitCount" parameterType="int">
	int increaseHitCount(int id);
//	<select id="getContent" parameterType="int"
//			resultType="boardVo">
	BoardVo getContent(Integer id);
//	<update id="update" parameterType="boardVo">
	int update(BoardVo vo);
//	<delete id="delete" parameterType="map">
	int delete(Map<String, Integer> map);
}