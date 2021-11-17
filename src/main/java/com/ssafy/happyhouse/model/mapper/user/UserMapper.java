package com.ssafy.happyhouse.model.mapper.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserMapper {
	/* 회원 정보 가입  */
	public void signUpUser(UserDto userDto) throws SQLException;
	
	/* 회원 정보 수정 */
	public void updateUser(UserDto userDto) throws SQLException;

	/* 로그인 */
	public UserDto login(Map<String, String> map) throws SQLException;
	
	/* 비밀번호 찾기 */
	public UserDto findPwd(Map<String, String> map) throws SQLException;
	
	/* 회원 삭제 */
	public void deleteUser(String userId) throws SQLException;
	
	
	/*아이디 유효성 체크*/
	public int idCheck(String checkId) throws Exception;

	public List<UserDto> listMember() throws Exception;

	public void registerMember(UserDto userDto) throws Exception;

	public void deleteMember(String userId) throws Exception;

	public void updateMember(UserDto userDto);

	

}
