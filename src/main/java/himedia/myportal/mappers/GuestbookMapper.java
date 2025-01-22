package himedia.myportal.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.myportal.repositories.vo.GuestbookVo;

@Mapper
public interface GuestbookMapper {
	List<GuestbookVo> selectAll();
	
	int insert(GuestbookVo vo);
	
	int delete(GuestbookVo vo);
}
