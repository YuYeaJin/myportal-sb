package himedia.myportal.repositories;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.UserDaoException;
import himedia.myportal.mappers.UserMapper;
import himedia.myportal.repositories.vo.UserVo;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public int insert(UserVo vo) {
		
		int count = 0;
		
		try {
			count = userMapper.insert(vo); 
		} catch (Exception e) {
			throw new UserDaoException("회원가입 중 오류", vo);
		}
//		try {
//			return sqlSession.insert("user.insert", vo);
//		} catch (Exception e) {
//			throw new UserDaoException("회원가입 중 오류", vo);
//		}
		return count;
	}
	
	// 중복 체크용
	@Override
	public UserVo selectUser(String email) {
		
		UserVo = userMapper.selectUserByEmail(email);
//		UserVo vo = 
//				sqlSession.selectOne("user.selectUserByEmail", email);
		return vo;
	}

	// 로그인 용
	@Override
	public UserVo selectUser(String email, String password) {
		
		Map<String, String> userMap = new HasMap<>();
		userMap.put("email", email);
		userMap.put("Password", password);
		
		UserVo vo= userMapper.selectUserByEmailAndPassword(userMap)
//		Map<String, String> userMap 
//			= new HashMap<>();
//		userMap.put("email", email);
//		userMap.put("password", password);
//		
//		UserVo vo = 
//			sqlSession.selectOne("user.selectUserByEmailAndPassword", 
//					userMap);
		return null;
	}

}
