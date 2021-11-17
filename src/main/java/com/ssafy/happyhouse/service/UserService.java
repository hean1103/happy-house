package com.ssafy.happyhouse.service;


import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface UserService {

	/* 회원 정보 가입  */
	public void signUpUser(UserDto userDto) throws Exception;
	
//	/* 회원 정보 수정 */
	public void updateUser(UserDto userDto) throws Exception;
//
	/* 로그인 */
	public UserDto login(Map<String, String> map) throws Exception;

//	
//	/* 비밀번호 찾기 */
//	public UserDto findPwd(String id, String name, String phone) throws Exception;
	
	
	
	
	//아이디 유효성 검증
	public int idCheck(String checkId) throws Exception;
	
	
	//회원 정보 불러오기
	List<UserDto> listMember() throws Exception;

	public void registerMember(UserDto userDto) throws Exception;

//	public UserDto getMember(String userid)throws Exception;
//
//
	public void deleteMember(String userid)throws Exception;

	public void updateMember(UserDto userDto) throws Exception;


	/* 비밀번호 찾기 */
	public UserDto findPwd(Map<String, String> map) throws Exception;
	
	/* 삭제 */
	public void deleteUser(String userId) throws Exception;

}
