package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void signUpUser(UserDto userDto) throws Exception {
		sqlSession.getMapper(UserMapper.class).signUpUser(userDto);
	}

	@Override
	public UserDto login(Map<String, String> map)throws Exception {
		return sqlSession.getMapper(UserMapper.class).login(map);
	}
	
	
	//아이디 유효성 검사
	@Override
	public int idCheck(String checkId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).idCheck(checkId);
	}
	//회원 목록//////////////////////////////////////////////////
	@Override
	public List<UserDto> listMember() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).listMember();
	}

	@Override
	public void registerMember(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(UserMapper.class).registerMember(userDto);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		sqlSession.getMapper(UserMapper.class).deleteMember(userId);
		
	}

	@Override
	public void updateMember(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(UserMapper.class).updateMember(userDto);
	}
	//////////////////////////////////////////////////////////////////
	
	

	@Override
	public UserDto findPwd(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(UserMapper.class).findPwd(map);
	}

	@Override
	public void updateUser(UserDto userDto) throws Exception {
		sqlSession.getMapper(UserMapper.class).updateUser(userDto);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		sqlSession.getMapper(UserMapper.class).deleteUser(userId);
	}

}
