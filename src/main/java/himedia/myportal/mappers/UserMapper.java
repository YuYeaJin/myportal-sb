package himedia.myportal.mappers;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import himedia.myportal.repositories.vo.UserVo;

@Mapper
public interface UserMapper {
	
	int insert(UserVo vo);
	
	UserVo selectUserByEmailAndPassword(Map<String, String> map);
	
	UserVo selectUserByEmail(String email);
}
